//todo требует отладки
package framework.qa.test.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import framework.qa.mq.OmniMqClient;
import framework.qa.consts.ChannelEnum;
import framework.qa.jupiter.annotations.InitRequest;
import framework.qa.models.requestData.OmniRequestItem;
import framework.qa.test.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.jms.JMSException;
import java.util.UUID;

import static io.qameta.allure.Allure.step;

public class MqExampleTest extends BaseTest {
    ObjectMapper om = new ObjectMapper();


    @DisplayName("Получение успешного экрана при запросе на init с проверкой заполнения параметров из client-search")
    @Test
    public void initMQTest(@InitRequest OmniRequestItem init) throws JMSException, JsonProcessingException {
        String gpbRequestId = UUID.randomUUID().toString();
        OmniMqClient mqClient = new OmniMqClient();
        mqClient.sendMqMessage("IN.RQ.CARDACPTACTVISTDR11_01.00.00",init,gpbRequestId);
        OmniRequestItem result = om.readValue(mqClient.readMqMessage("IN.RQ.CARDACPTACTVISTDR11_01.00.00","X_TransactionID",gpbRequestId),OmniRequestItem.class);
     Assertions.assertEquals(ChannelEnum.UFO.getName(), result.getMeta().getChannel());
    }
}
