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

            Operation operation = new Operation(UUID.randomUUID().toString());
//            operation.setOrderId(UUID.randomUUID().toString());

            VerifyData verifyData = new VerifyData();
            verifyData.setValues(valueBackList);
            verifyData.setScreenStage("initial");

            DepartmentAddress departmentAddress = new DepartmentAddress();
            departmentAddress.setFullAddress(TestDataValues.address);

            EmployeeDepartment department = new EmployeeDepartment();
            department.setAddress(departmentAddress);
            department.setCode(TestDataValues.branchCode);
            department.setFullName(TestDataValues.userFullName);
            department.setBranchCode(TestDataValues.branchUnitCode);

            Employee employee = new Employee();
            employee.setLogin(TestDataValues.login);
            employee.setPosition(TestDataValues.title);
            employee.setDepartment(department);

            ClientContext clientContext = new ClientContext();
            clientContext.setVersion(TestDataValues.version);
            clientContext.setEmployee(employee);

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

            return new OmniRequestItem(requestData,new OmniRequestMeta("DRTL", ChannelEnum.UFO.getName(),"OMNI",null));

//            InitRequestParams initRequestParams = new InitRequestParams();
//            initRequestParams.setChannel(ChannelEnum.UFO);
//            initRequestParams.setScenarioCode(ScenarioCodeEnum.sc_57eb451bc6aa383.getCode());
//            initRequestParams.setScenarioId(ScenarioCodeEnum.sc_57eb451bc6aa383.getId());
//            initRequestParams.setSystemExecute("DRTL");
//            initRequestParams.setRequestMeta();
//            initRequestParams.set

        }
        throw new ParameterResolutionException("No random generator " + type);
    }

}
