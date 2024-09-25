package framework.qa.mqclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.msg.client.wmq.WMQConstants;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.internal.JsonContext;
import framework.qa.models.requestData.OmniRequestItem;

import javax.jms.*;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class MqConnect {

    public String hostName = "localhost";

    public Integer port = 1414;

    public String queueManager = "QM1";

    public String channel = "DEV.APP.SVRCONN";

    public String mq_appName = "app";

    public String pass = "passw0rd";

    public String user = "app";

    public Supplier<QueueConnection> connect() throws JMSException {
        return () -> {
            try {
                var cf = new MQQueueConnectionFactory();
                cf.setTransportType(WMQConstants.WMQ_CM_CLIENT);
                cf.setBooleanProperty(WMQConstants.USER_AUTHENTICATION_MQCSP, false);
                System.setProperty("com.ibm.mq.cfg.useIBMCipherMappings", "false");
                cf.setHostName(hostName);
                cf.setPort(port);
                cf.setQueueManager(queueManager);
                cf.setChannel(channel);
                cf.setStringProperty(WMQConstants.USERID, user);
                cf.setStringProperty(WMQConstants.PASSWORD, pass);
                cf.setAppName(mq_appName);
                return cf.createQueueConnection();
            } catch (JMSException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        };
    }


   public void sendMqMessage(String queueName, Object msg, String requestId) throws JMSException, JsonProcessingException {
       ObjectMapper om = new ObjectMapper();
       String stringMessage=om.writeValueAsString(msg);
        //установили соединение с IBM MQ
        MqConnect mqConnect = new MqConnect();
        QueueConnection queueConnection = mqConnect.connect().get();
        //установили соединение с выбранной очередью
        QueueSession queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        QueueSender queueSender = queueSession.createSender(queueSession.createQueue(queueName));
        //сформировали сообщение в очередь
        Message message = queueSession.createTextMessage(stringMessage);
        message.setStringProperty("X_CreateDateTime", "2023-05-22T20:45:00.259Z");
        message.setStringProperty("X_TransactionID", requestId);
        //отправили сообщение в очередь
        queueSender.send(message);
        //закрыли соединение
        queueSender.close();
        queueSession.close();
    }

    public String readMqMessage(String queueName, String mqHeader, String mqHeaderValue ) throws JMSException {
        //установили соединение с IBM MQ
        MqConnect mqConnect = new MqConnect();
        QueueConnection queueConnection = mqConnect.connect().get();
        //установили соединение с выбранной очередью
        QueueSession queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = queueSession.createQueue((queueName));
        //создали листнера/ресивера сообщения
        QueueReceiver queueReceiver = queueSession.createReceiver(queue, mqHeader+"='"+mqHeaderValue+"'");
        queueConnection.start();
        Message message = Optional.ofNullable(queueReceiver.receive(60 * 1000)).get();
        System.out.println("Сообщение: " + ((TextMessage) message));
        System.out.println("Тело сообщения: " + ((TextMessage) message).getText());
        String mqResponseBody = ((TextMessage) message).getText();
        System.out.println(mqResponseBody);
        queueSession.close();
        queueReceiver.close();
        return mqResponseBody;
    }

}
