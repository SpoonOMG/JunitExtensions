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
            Operation operation = new Operation(UUID.randomUUID().toString());
            VerifyData verifyData = new VerifyData();
            verifyData.setValues(verifyDataValueBackList);
            DepartmentAddress departmentAddress = new DepartmentAddress();
            departmentAddress.setFullAddress(TestDataValues.address);
            ClientContext clientContext = new ClientContext();
            clientContext.setVersion(TestDataValues.version);

            Scenario scenario = new Scenario(ScenarioCodeEnum.sc_57eb451bc6aa383.getId(),
                    "CARDS",
                    "Банковские карты",
                    "DEBIT",
                    "Дебетовые",
                    "#EMPTY#",
                    ScenarioCodeEnum.sc_57eb451bc6aa383.getCode(),
                    "Умная карта",
                    true,
                    "OMNI",
                    "OMNI-OKS-CARDS",
                    "OMNI-OKS-CARDS",
                    "DRTL");


            RequestData requestData = new RequestData();
            requestData.setClientContext(clientContext);
            requestData.setVerifyData(verifyData);
            requestData.setOperation(operation);
            requestData.setScenario(scenario);

            return new OmniRequestItem(requestData,new OmniRequestMeta("DRTL", ChannelEnum.WEB.getName(),"OMNI",null));

        }
        throw new ParameterResolutionException("No random generator " + type);
    }

}
