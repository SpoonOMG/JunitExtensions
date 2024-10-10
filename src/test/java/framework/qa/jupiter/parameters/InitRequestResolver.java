package framework.qa.jupiter.parameters;

import framework.qa.jupiter.annotations.InitRequest;
import framework.qa.models.requestData.*;
import framework.qa.consts.ChannelEnum;
import framework.qa.consts.Params;
import framework.qa.consts.ScenarioCodeEnum;
import framework.qa.values.TestDataValues;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*
 Расширение JunitExtension позволяет используя аннотацию InitRequest собирать джейсон запроса из модели OmniRequestItem
 для запроса на init
 */

public class InitRequestResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.isAnnotated(InitRequest.class);

    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Class<?> type = parameterContext.getParameter().getType();
        if (OmniRequestItem.class.equals(type)) {
            List<ScreenValueBack> valueBackList = new ArrayList<>();
            valueBackList.add(new ScreenValueBack(Params.LOGIN, TestDataValues.login));
            valueBackList.add(new ScreenValueBack(Params.USER_FULL_NAME, TestDataValues.userFullName));
            valueBackList.add(new ScreenValueBack(Params.TITLE, TestDataValues.title));
            valueBackList.add(new ScreenValueBack(Params.BRANCH_CODE, TestDataValues.branchCode));
            valueBackList.add(new ScreenValueBack(Params.BRANCH_UNIT_CODE, TestDataValues.branchUnitCode));
            valueBackList.add(new ScreenValueBack(Params.VIRTUAL_NUM, TestDataValues.virtualNum));
            valueBackList.add(new ScreenValueBack(Params.BRANCH_CODE_5NT, TestDataValues.branchCode5nt));
            valueBackList.add(new ScreenValueBack(Params.ADDRESS_IS_INCORRECT, TestDataValues.addressIsIncorrect));

            return new OmniRequestItem (
                    new OmniRequestMeta("DRTL", ChannelEnum.UFO.getName(),"OMNI",null),
                    new RequestData(new Scenario(ScenarioCodeEnum.sc_421e8df062b2939.getId(), ScenarioCodeEnum.sc_421e8df062b2939.getCode(), "OMNI"),
                            new Operation(UUID.randomUUID().toString()),
                            new ClientContext(),
                            new VerifyData(valueBackList)
                    ));


        }
        throw new ParameterResolutionException("No random generator " + type);
    }

}
