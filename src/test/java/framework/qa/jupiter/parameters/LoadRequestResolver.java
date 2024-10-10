package framework.qa.jupiter.parameters;

import framework.qa.consts.ChannelEnum;
import framework.qa.consts.ScenarioCodeEnum;
import framework.qa.consts.UiFieldsNames;
import framework.qa.jupiter.annotations.CheckRequest;
import framework.qa.jupiter.annotations.LoadRequest;
import framework.qa.models.requestData.*;
import framework.qa.values.TestDataValues;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LoadRequestResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.isAnnotated(LoadRequest.class);

    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Class<?> type = parameterContext.getParameter().getType();
        if (OmniRequestItem.class.equals(type)) {
            List<ScreenValueBack> verifyDataValueBackList = new ArrayList<>();


            return new OmniRequestItem(
                    new OmniRequestMeta("DRTL", ChannelEnum.WEB.getName(), "OMNI", null),
                    new RequestData(new Scenario(ScenarioCodeEnum.sc_421e8df062b2939.getId(), ScenarioCodeEnum.sc_421e8df062b2939.getCode(), "OMNI"),
                            new Operation(UUID.randomUUID().toString()),
                            new ClientContext(TestDataValues.version),
                            new VerifyData(verifyDataValueBackList)
                    ));
        }
        throw new ParameterResolutionException("No random generator " + type);
    }

}
