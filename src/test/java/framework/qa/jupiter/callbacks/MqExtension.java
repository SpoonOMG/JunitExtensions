////todo Реализовать mqExtension
//package framework.qa.jupiter.callbacks;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.ibm.mq.jms.MQQueueConnectionFactory;
//import com.ibm.msg.client.wmq.WMQConstants;
//import com.jayway.jsonpath.DocumentContext;
//import com.jayway.jsonpath.JsonPath;
//import com.jayway.jsonpath.internal.JsonContext;
//import framework.qa.config.Config;
//import framework.qa.models.requestData.OmniRequestItem;
//import org.junit.jupiter.api.extension.BeforeAllCallback;
//import org.junit.jupiter.api.extension.ExtensionContext;
//
//import javax.jms.*;
//import java.util.Arrays;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.Optional;
//import java.util.function.Supplier;
//
//public class MqExtension implements BeforeAllCallback {
//    protected static final Config CFG = Config.getInstance();
//    @Override
//    public void beforeAll(ExtensionContext extensionContext) throws Exception {
//
//    }
//
//
//    public Supplier<QueueConnection> connect() throws JMSException {
//        return () -> {
//            try {
//                var cf = new MQQueueConnectionFactory();
//                cf.setTransportType(WMQConstants.WMQ_CM_CLIENT);
//                cf.setBooleanProperty(WMQConstants.USER_AUTHENTICATION_MQCSP, false);
//                System.setProperty("com.ibm.mq.cfg.useIBMCipherMappings", "false");
//                cf.setHostName(CFG.mqHost());
//                cf.setPort(CFG.port());
//                cf.setQueueManager(CFG.queueManager());
//                cf.setChannel(CFG.channel());
//                cf.setStringProperty(WMQConstants.USERID, CFG.user());
//                cf.setStringProperty(WMQConstants.PASSWORD, CFG.pass());
//                cf.setAppName(CFG.mq_appName());
//                return cf.createQueueConnection();
//            } catch (JMSException e) {
//                e.printStackTrace();
//                throw new RuntimeException(e);
//            }
//        };
//    }
//
//
//    public void sendMqMessage(String queueName, Object msg) throws JMSException, JsonProcessingException {
//        ObjectMapper om = new ObjectMapper();
//        String stringMessage=om.writeValueAsString(msg);
//        //установили соединение с IBM MQ
//        MqConnect mqConnect = new MqConnect();
//        QueueConnection queueConnection = mqConnect.connect().get();
//        //установили соединение с выбранной очередью
//        QueueSession queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
//        QueueSender queueSender = queueSession.createSender(queueSession.createQueue(queueName));
//        //сформировали сообщение в очередь
//        Message message = queueSession.createTextMessage(stringMessage);
//        message.setStringProperty("X_CreateDateTime", "2023-05-22T20:45:00.259Z");
//        message.setStringProperty("X_From", "RMI");
//        //отправили сообщение в очередь
//        queueSender.send(message);
//        //закрыли соединение
//        queueSender.close();
//        queueSession.close();
//    }
//
//    //    @Тогда("Считали из очереди MQ {string} сообщение по заголовку {string} со значением {string}")
////    public void считалиИзОчередиMQСообщение(String mq_name, String header_name, String header_value) throws JMSException {
////        //сделали коннект к MQ
////        var queueConnection = connect.get();
////
////        //читаем сообщение
////        var queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
////        var queue = queueSession.createQueue(mq_name);
////        var receiver = queueSession.createReceiver(queue, header_name + "='" + header_value + "'");
////        queueConnection.start();
////        var message = Optional.ofNullable(receiver.receive(60 * 1000)).get();
////
////        logger.debug("Сообщение: " + ((TextMessage) message));
////        logger.debug("Тело сообщения: " + ((TextMessage) message).getText());
////        mqResponseBody = ((TextMessage) message).getText();
////        queueSession.close();
////        receiver.close();
////    }
//    public String readMqMessage(String queueName, String mqHeader, String mqHeaderValue ) throws JMSException {
//        //установили соединение с IBM MQ
//        MqConnect mqConnect = new MqConnect();
//        QueueConnection queueConnection = mqConnect.connect().get();
//        //установили соединение с выбранной очередью
//        QueueSession queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
//        Queue queue = queueSession.createQueue((queueName));
//        //создали листнера/ресивера сообщения
//        QueueReceiver queueReceiver = queueSession.createReceiver(queue, mqHeader+"='"+mqHeaderValue+"'");
//        queueConnection.start();
//        Message message = Optional.ofNullable(queueReceiver.receive(60 * 1000)).get();
//        System.out.println("Сообщение: " + ((TextMessage) message));
//        System.out.println("Тело сообщения: " + ((TextMessage) message).getText());
//        String mqResponseBody = ((TextMessage) message).getText();
//        System.out.println(mqResponseBody);
//        queueSession.close();
//        queueReceiver.close();
//        return mqResponseBody;
//    }
//
//
//
////    public static void main(String[] args) throws JMSException {
////        MqConnect mqConnect = new MqConnect();
////        mqConnect.sendMqMessage();
////        mqConnect.readMqMessage();
////    }
//}
