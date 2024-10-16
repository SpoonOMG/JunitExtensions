package framework.qa.test.site.gapi_scenario;

import framework.qa.consts.Params;
import framework.qa.consts.ScenarioCodeEnum;
import framework.qa.jupiter.annotations.CheckRequest;
import framework.qa.models.omniresponseitem.ElementsItem;
import framework.qa.models.omniresponseitem.Error;
import framework.qa.models.omniresponseitem.ResponseItem;
import framework.qa.models.omniresponseitem.ValuesItem;
import framework.qa.models.requestData.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckSiteGapiTest extends BaseSiteTest {


    @DisplayName("Валидация параметров check при приеме заявки с сайта на ДК. Проверка списка параметров валидации")
    @Test
    public void siteCheckRequestValidateRequiredParams(@CheckRequest OmniRequestItem check) throws IOException {
        String gpbRequestId = UUID.randomUUID().toString();
        check.getMeta().setChannel("WEB");
        check.getMeta().setSystemId("GAPI");
        check.getData().setScenario(new Scenario(ScenarioCodeEnum.sc_13cc01653561c2c.getId(), ScenarioCodeEnum.sc_13cc01653561c2c.getCode(), "RMI"));
        check.getData().setVerifyData(new VerifyData(new ArrayList<>(), "initial", "SITE_CARD_PARAMS", new ScreenCommandFront("execute", "applyCard")));
        ResponseItem response = checkApi.checkRequest(gpbRequestId, check);

        Map<String, Error> collect = response.getScreen().getMessage().getElements().stream().collect(Collectors.toMap(ElementsItem::getId, ElementsItem::getError));
        assertAll(
                () -> assertEquals("Параметр указан неверно", collect.get(Params.SITE_TYPE_CARD).getMessage()),
                () -> assertEquals("Параметр указан неверно", collect.get(Params.BRANCH_CODE).getMessage()),
                () -> assertEquals("Параметр указан неверно", collect.get(Params.SURNAME).getMessage()),
                () -> assertEquals("Параметр указан неверно", collect.get(Params.NAME).getMessage()),
                () -> assertEquals("Параметр указан неверно", collect.get(Params.SEX_CODE).getMessage()),
                () -> assertEquals("Параметр указан неверно", collect.get(Params.BIRTH_DATE).getMessage()),
                () -> assertEquals("Параметр указан неверно", collect.get(Params.BIRTH_PLACE).getMessage()),
                () -> assertEquals("Параметр указан неверно", collect.get(Params.BIRTH_COUNTRY_CODE).getMessage()),
                () -> assertEquals("Параметр указан неверно", collect.get(Params.DOC_TYPE_CODE).getMessage()),
                () -> assertEquals("Параметр указан неверно", collect.get(Params.DOC_SERIES).getMessage()),
                () -> assertEquals("Параметр указан неверно", collect.get(Params.DOC_NUM).getMessage()),
                () -> assertEquals("Параметр указан неверно", collect.get(Params.ISSUE_DATE).getMessage()),
                () -> assertEquals("Параметр указан неверно", collect.get(Params.ISSUED_BY).getMessage()),
                () -> assertEquals("Параметр указан неверно", collect.get(Params.DEPART_CODE).getMessage()),
                () -> assertEquals("Параметр указан неверно", collect.get(Params.RG_COUNTRY_CODE).getMessage()),
                () -> assertEquals("Параметр указан неверно", collect.get(Params.RG_POSTAL_CODE).getMessage()),
                () -> assertEquals("Параметр указан неверно", collect.get(Params.RG_REGION_CODE).getMessage()),
                () -> assertEquals("Параметр указан неверно", collect.get(Params.FT_COUNTRY_CODE).getMessage()),
                () -> assertEquals("Параметр указан неверно", collect.get(Params.FT_POSTAL_CODE).getMessage()),
                () -> assertEquals("Параметр указан неверно", collect.get(Params.FT_REGION_CODE).getMessage()),
                () -> assertEquals("Параметр указан неверно", collect.get(Params.SITE_MOBILE_NUMBER).getMessage()),
                () -> assertEquals("Параметр указан неверно", collect.get(Params.CONSENT_PERSONAL_DATA).getMessage()),
                () -> assertEquals("Параметр указан неверно", collect.get(Params.CONSENT_PERSONAL_DATA_SHARING).getMessage()),
                () -> assertEquals("Параметр указан неверно", collect.get(Params.CONSENT_CH_CHECK).getMessage()),
                () -> assertEquals("Параметр указан неверно", collect.get(Params.CONSENT_ADV_SUBSCRIPTION).getMessage()),
                () -> assertEquals("Параметр указан неверно", collect.get(Params.CURRENCY_CODE).getMessage()),
                () -> assertEquals("Параметр указан неверно", collect.get(Params.BRANCH_UNIT_CODE).getMessage()),
                () -> assertEquals("Параметр указан неверно", collect.get(Params.KIND_GET).getMessage()),
                () -> assertEquals("Параметр указан неверно", collect.get(Params.SUB_PROGRAM_CODE).getMessage()),
                () -> assertEquals(29, collect.size())
        );
    }


    @DisplayName("Получение списка параметров на исполнение при запросе на check")
    @Test
    public void siteCheckRequestShouldReturnSuccess(@CheckRequest OmniRequestItem check) throws IOException {
        String gpbRequestId = UUID.randomUUID().toString();
        check.getMeta().setChannel("WEB");
        check.getMeta().setSystemId("GAPI");
        check.getData().setScenario(new Scenario(ScenarioCodeEnum.sc_13cc01653561c2c.getId(), ScenarioCodeEnum.sc_13cc01653561c2c.getCode(), "RMI"));
        check.getData().setOperation(new Operation(UUID.randomUUID().toString(), UUID.randomUUID().toString(), null, new ArrayList<>()));
        check.getData().setVerifyData(new VerifyData(siteVerifyDataRequiredParams(), "initial", "SITE_CARD_PARAMS", new ScreenCommandFront("execute", "applyCard")));
        ResponseItem response = checkApi.checkRequest(gpbRequestId, check);
        Map<String, String> collect = response.getData().getOperation().getValues().stream().collect(Collectors.toMap(ValuesItem::getId, ValuesItem::getValue));
        assertAll(
                () -> assertEquals("success", response.getStatus()),
                () -> assertEquals(check.getData().getOperation().getOrderId(), response.getData().getOperation().getOrderId()),
                () -> assertEquals(check.getData().getOperation().getOrder4client(), collect.get(Params.ORDER_4_CLIENT)),
                () -> assertEquals(42, collect.size())

        );
    }

    @DisplayName("Валидация принимаемых продуктов")
    @ParameterizedTest
    @MethodSource("provideAvailableSubProgramFromSiteToKdk")
    public void siteCheckRequestSubProgramCodeValidation(
            String subProgramCode,
            String subProgramCodeResponse,
            @CheckRequest OmniRequestItem check) throws IOException {
        String gpbRequestId = UUID.randomUUID().toString();
        check.getMeta().setChannel("WEB");
        check.getMeta().setSystemId("GAPI");
        check.getData().setScenario(new Scenario(ScenarioCodeEnum.sc_13cc01653561c2c.getId(), ScenarioCodeEnum.sc_13cc01653561c2c.getCode(), "RMI"));
        check.getData().setOperation(new Operation(UUID.randomUUID().toString(), UUID.randomUUID().toString(), null, new ArrayList<>()));

        List<ScreenValueBack> lst = siteVerifyDataRequiredParams();
        lst.stream().filter(value->Objects.equals("subProgramCode",value.getId())).forEach(value->value.setValue(subProgramCode));

        check.getData().setVerifyData(new VerifyData(lst, "initial", "SITE_CARD_PARAMS", new ScreenCommandFront("execute", "applyCard")));
        ResponseItem response = checkApi.checkRequest(gpbRequestId, check);
        Map<String, String> collect = response.getData().getOperation().getValues().stream().collect(Collectors.toMap(ValuesItem::getId, ValuesItem::getValue));
        assertAll(
                () -> assertEquals("success", response.getStatus()),
                () -> assertEquals(check.getData().getOperation().getOrderId(), response.getData().getOperation().getOrderId()),
                () -> assertEquals(check.getData().getOperation().getOrder4client(), collect.get(Params.ORDER_4_CLIENT)),
                () -> assertEquals(subProgramCodeResponse, collect.get("subProgramCode"))
        );
    }

    private static Stream<Arguments> provideAvailableSubProgramFromSiteToKdk() {
        return Stream.of(
                Arguments.of("053","053"),
                Arguments.of("019","019"),
                Arguments.of("023","023"),
                Arguments.of("069","069"),
                Arguments.of("053","053"),
                Arguments.of("059","059"),
                Arguments.of("060","060"),
                Arguments.of("014","014"),
                Arguments.of("083","053"),
                Arguments.of("063","063"),
                Arguments.of("075","075"),
                Arguments.of("057","057"),
                Arguments.of("171","171"),
                Arguments.of("172","172"),
                Arguments.of("123","123"));
    }
}
