//package framework.qa.jupiter.parameters;
//
//import framework.qa.consts.ChannelEnum;
//import framework.qa.consts.ScenarioCodeEnum;
//import framework.qa.consts.UiFieldsNames;
//import framework.qa.jupiter.annotations.CheckRequest;
//import framework.qa.models.requestData.*;
//import framework.qa.values.*;
//import org.junit.jupiter.api.extension.ExtensionContext;
//import org.junit.jupiter.api.extension.ParameterContext;
//import org.junit.jupiter.api.extension.ParameterResolutionException;
//import org.junit.jupiter.api.extension.ParameterResolver;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//public class CheckRequestResolver implements ParameterResolver {
//    @Override
//    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
//        return parameterContext.isAnnotated(CheckRequest.class);
//
//    }
//
//    @Override
//    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
//        Class<?> type = parameterContext.getParameter().getType();
//        if (OmniRequestItem.class.equals(type)) {
//            List<ScreenValueBack> operationValueBackList = new ArrayList<>();
//            operationValueBackList.add(new ScreenValueBack("cardCategoryCode", "7"));
//
//            List<ScreenValueBack> verifyDataValueBackList = new ArrayList<>();
//            verifyDataValueBackList.add(new ScreenValueBack(UiFieldsNames.UI_LOCATION, TestDataValues.location));
//
//            Operation operation = new Operation(UUID.randomUUID().toString(),operationValueBackList);
//
//            VerifyData verifyData = new VerifyData();
//            verifyData.setValues(verifyDataValueBackList);
//            verifyData.setScreenStage("initial");
//            verifyData.setCommand(new ScreenCommandFront("check","checkSmartCardParams",null,null,null));
//
//            DepartmentAddress departmentAddress = new DepartmentAddress();
//            departmentAddress.setFullAddress(TestDataValues.address);
//
//            EmployeeDepartment department = new EmployeeDepartment();
//            department.setAddress(departmentAddress);
//            department.setCode(TestDataValues.branchCode);
//            department.setFullName(TestDataValues.userFullName);
//            department.setBranchCode(TestDataValues.branchUnitCode);
//
//            Employee employee = new Employee();
//            employee.setLogin(TestDataValues.login);
//            employee.setPosition(TestDataValues.title);
//            employee.setDepartment(department);
//
//            ClientContext clientContext = new ClientContext();
//            clientContext.setVersion(TestDataValues.version);
//            clientContext.setEmployee(employee);
//
//            Scenario scenario = new Scenario(ScenarioCodeEnum.sc_57eb451bc6aa383.getId(),
//                    "CARDS",
//                    "Банковские карты",
//                    "DEBIT",
//                    "Дебетовые",
//                    "#EMPTY#",
//                    ScenarioCodeEnum.sc_57eb451bc6aa383.getCode(),
//                    "Умная карта",
//                    true,
//                    "OMNI",
//                    "OMNI-OKS-CARDS",
//                    "OMNI-OKS-CARDS",
//                    "DRTL");
//
//
//            RequestData requestData = new RequestData();
//            requestData.setClientContext(clientContext);
//            requestData.setVerifyData(verifyData);
//            requestData.setOperation(operation);
//            requestData.setScenario(scenario);
//
//            return new OmniRequestItem(requestData,new OmniRequestMeta("DRTL", ChannelEnum.UFO.getName(),"OMNI",null));
//
////            InitRequestParams initRequestParams = new InitRequestParams();
////            initRequestParams.setChannel(ChannelEnum.UFO);
////            initRequestParams.setScenarioCode(ScenarioCodeEnum.sc_57eb451bc6aa383.getCode());
////            initRequestParams.setScenarioId(ScenarioCodeEnum.sc_57eb451bc6aa383.getId());
////            initRequestParams.setSystemExecute("DRTL");
////            initRequestParams.setRequestMeta();
////            initRequestParams.set
//
//        }
//        throw new ParameterResolutionException("No random generator " + type);
//    }
//
//}
