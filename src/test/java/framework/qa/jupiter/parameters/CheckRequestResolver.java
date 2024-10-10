package framework.qa.jupiter.parameters;

import framework.qa.consts.ChannelEnum;
import framework.qa.consts.Params;
import framework.qa.consts.ScenarioCodeEnum;
import framework.qa.consts.UiFieldsNames;
import framework.qa.jupiter.annotations.CheckRequest;
import framework.qa.models.requestData.*;
import framework.qa.values.*;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CheckRequestResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.isAnnotated(CheckRequest.class);

    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Class<?> type = parameterContext.getParameter().getType();
        if (OmniRequestItem.class.equals(type)) {
            List<ScreenValueBack> operationValueBackList = new ArrayList<>();
            List<ScreenValueBack> verifyDataValueBackList = new ArrayList<>();
            verifyDataValueBackList.add(new ScreenValueBack(UiFieldsNames.UI_LOCATION, TestDataValues.location));

            return new OmniRequestItem (
                    new OmniRequestMeta("DRTL", ChannelEnum.UFO.getName(),"OMNI",null),
                    new RequestData(new Scenario(ScenarioCodeEnum.sc_421e8df062b2939.getId(), ScenarioCodeEnum.sc_421e8df062b2939.getCode(), "OMNI"),
                            new Operation(UUID.randomUUID().toString(),operationValueBackList),
                            new ClientContext(new Employee(new EmployeeDepartment(TestDataValues.branchCode,TestDataValues.branchUnitCode))),
                            new VerifyData(verifyDataValueBackList,"initial",null,new ScreenCommandFront("check","checkSmartCardParams",null,null,null))
            ));
        }
        throw new ParameterResolutionException("No random generator " + type);
    }

}
