package framework.qa.mq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.jms.*;
import java.util.Optional;

public class OmniMqClient extends MqClient{

    public OmniMqClient() throws JMSException {
    }

    public void sendMqMessage (String queueName, Object msg, String requestId) throws JsonProcessingException, JMSException {
        ObjectMapper om = new ObjectMapper();
        String stringMessage=om.writeValueAsString(msg);
        //установили соединение с IBM MQ
        MqClient mqConnect = new MqClient() {};
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
        MqClient mqConnect = new MqClient() {};
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
