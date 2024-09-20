package framework.qa.jupiter.parameters;

import framework.qa.jupiter.annotations.Init;
import framework.qa.models.init.*;
import framework.qa.consts.Params;
import framework.qa.values.TestDataValues;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.util.LinkedList;
import java.util.List;

public class InitResolver implements ParameterResolver {


    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.isAnnotated(Init.class);

    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Class<?> type = parameterContext.getParameter().getType();
        if(InitRoot.class.equals(type)){
            InitRoot initRoot = new InitRoot();
            Meta meta = new Meta();
            Data data = new Data();
            Scenario scenario = new Scenario();
            ClientContext clientContext = new ClientContext();
            Employee employee = new Employee();
            Department department = new Department();
            Address address = new Address();

            ValuesItem loginValue = new ValuesItem(Params.LOGIN, TestDataValues.login);
            ValuesItem userFullNameValue = new ValuesItem(Params.USER_FULL_NAME,TestDataValues.userFullName);
            ValuesItem titleValue = new ValuesItem(Params.TITLE,TestDataValues.title);
            ValuesItem branchCodeValue = new ValuesItem(Params.BRANCH_CODE,TestDataValues.branchCode);
            ValuesItem branchUnitCodeValue = new ValuesItem(Params.BRANCH_UNIT_CODE, TestDataValues.branchUnitCode);
            ValuesItem virtualNumValue = new ValuesItem(Params.VIRTUAL_NUM,TestDataValues.virtualNum);
            ValuesItem branchCode5ntValue = new ValuesItem(Params.BRANCH_CODE_5NT,TestDataValues.branchCode5nt);
            ValuesItem addressIsIncorrectValue = new ValuesItem(Params.ADDRESS_IS_INCORRECT,TestDataValues.addressIsIncorrect);

            List<ValuesItem> values = new LinkedList<>();
            values.add(loginValue);
            values.add(userFullNameValue);
            values.add(titleValue);
            values.add(branchCodeValue);
            values.add(branchUnitCodeValue);
            values.add(virtualNumValue);
            values.add(branchCode5ntValue);
            values.add(addressIsIncorrectValue);

            VerifyData verifyData = new VerifyData();
            verifyData.setValues(values);

            department.setAddress(address);
            employee.setDepartment(department);
            clientContext.setEmployee(employee);
            data.setClientContext(clientContext);
            data.setScenario(scenario);
            data.setOperation(new Operation());
            data.setVerifyData(verifyData);
            initRoot.setData(data);
            initRoot.setMeta(meta);
            return initRoot;
        }
        throw new ParameterResolutionException("No random generator "+type);
    }
}
