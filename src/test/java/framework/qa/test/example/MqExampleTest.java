////todo требует отладки
//package framework.qa.test.example;
//
//import framework.qa.jupiter.annotations.CheckRequest;
//import framework.qa.jupiter.annotations.InitRequest;
//import framework.qa.models.requestData.OmniRequestItem;
//import framework.qa.mqclient.MqConnect;
//import framework.qa.test.BaseTest;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.util.UUID;
//
//import static io.qameta.allure.Allure.step;
//
//public class MqExampleTest extends BaseTest {
//
//
//
//    @DisplayName("Получение успешного экрана при запросе на init с проверкой заполнения параметров из client-search")
//    @Test
//    public void initMQTest(@InitRequest OmniRequestItem init) {
//        String gpbRequestId = UUID.randomUUID().toString();
//        step("Отправка запроса на mq с телом init", () -> {
//            MqConnect mqConnect = new MqConnect();
//            mqConnect.sendMqMessage("IN.RQ.CARDACPTACTVISTDR11_01.00.00",init,gpbRequestId);
//            String mqmsg=mqConnect.readMqMessage("IN.RQ.CARDACPTACTVISTDR11_01.00.00","X_TransactionID",gpbRequestId);
//            Assertions.assertTrue(mqmsg.contains("\"data\":{\"scenario\":{\"id\":\"sc_57eb451bc6aa383\",\"categoryCode\":\"CARDS\",\"categoryName\""));
//        });
//
//    }
//
//    @DisplayName("Получение успешного экрана при запросе на init с проверкой заполнения параметров из client-search")
//    @Test
//    public void checkMQTest(@CheckRequest OmniRequestItem check
//    ) {
//        String gpbRequestId = UUID.randomUUID().toString();
//
//
//        step("Отправка запроса на init", () -> {
//            MqConnect mqConnect = new MqConnect();
//            mqConnect.sendMqMessage("IN.RQ.CARDACPTACTVISTDR11_01.00.00",check,gpbRequestId);
//            String mqmsg=mqConnect.readMqMessage("IN.RQ.CARDACPTACTVISTDR11_01.00.00","X_TransactionID",gpbRequestId);
//            Assertions.assertTrue(mqmsg.contains("\"data\":{\"scenario\":{\"id\":\"sc_57eb451bc6aa383\",\"categoryCode\":\"CARDS\",\"categoryName\""));
//
//        });
//    }
//    @DisplayName("Получение успешного экрана при запросе на init с проверкой заполнения параметров из client-search")
//    @Test
//    public void initMQTest1(@InitRequest OmniRequestItem init) {
//        String gpbRequestId = UUID.randomUUID().toString();
//        step("Отправка запроса на mq с телом init", () -> {
//            MqConnect mqConnect = new MqConnect();
//            mqConnect.sendMqMessage("IN.RQ.CARDACPTACTVISTDR11_01.00.00",init,gpbRequestId);
//            String mqmsg=mqConnect.readMqMessage("IN.RQ.CARDACPTACTVISTDR11_01.00.00","X_TransactionID",gpbRequestId);
//            Assertions.assertTrue(mqmsg.contains("\"data\":{\"scenario\":{\"id\":\"sc_57eb451bc6aa383\",\"categoryCode\":\"CARDS\",\"categoryName\""));
//        });
//
//    }
//
//    @DisplayName("Получение успешного экрана при запросе на init с проверкой заполнения параметров из client-search")
//    @Test
//    public void checkMQTest1(@CheckRequest OmniRequestItem check
//    ) {
//        String gpbRequestId = UUID.randomUUID().toString();
//
//
//        step("Отправка запроса на init", () -> {
//            MqConnect mqConnect = new MqConnect();
//            mqConnect.sendMqMessage("IN.RQ.CARDACPTACTVISTDR11_01.00.00",check,gpbRequestId);
//            String mqmsg=mqConnect.readMqMessage("IN.RQ.CARDACPTACTVISTDR11_01.00.00","X_TransactionID",gpbRequestId);
//            Assertions.assertTrue(mqmsg.contains("\"data\":{\"scenario\":{\"id\":\"sc_57eb451bc6aa383\",\"categoryCode\":\"CARDS\",\"categoryName\""));
//
//        });
//    }
//}
