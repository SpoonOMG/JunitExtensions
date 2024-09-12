package framework.qa.jupiter.parameters;

import framework.qa.models.init.*;
import framework.qa.values.TestDataValues;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import framework.qa.values.Values;

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

            ValuesItem loginValue = new ValuesItem(Values.LOGIN, TestDataValues.login);
            ValuesItem userFullNameValue = new ValuesItem(Values.USER_FULL_NAME,TestDataValues.userFullName);
            ValuesItem titleValue = new ValuesItem(Values.TITLE,TestDataValues.title);
            ValuesItem branchCodeValue = new ValuesItem(Values.BRANCH_CODE,TestDataValues.branchCode);
            ValuesItem branchUnitCodeValue = new ValuesItem(Values.BRANCH_UNIT_CODE, TestDataValues.branchUnitCode);
            ValuesItem virtualNumValue = new ValuesItem(Values.VIRTUAL_NUM,TestDataValues.virtualNum);

            List<ValuesItem> values = new LinkedList<>();
            values.add(loginValue);
            values.add(userFullNameValue);
            values.add(titleValue);
            values.add(branchCodeValue);
            values.add(branchUnitCodeValue);
            values.add(virtualNumValue);

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
