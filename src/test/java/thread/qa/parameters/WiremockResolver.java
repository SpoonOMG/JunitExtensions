package thread.qa.parameters;

import org.apache.http.impl.conn.Wire;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import thread.qa.utils.Wiremock;

public class WiremockResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.isAnnotated(Mock.class);

    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext ) throws ParameterResolutionException {
        Class<?> type = parameterContext.getParameter().getType();
        if(Wiremock.class.equals(type)){
            Wiremock wiremock = new Wiremock();
            return wiremock;
        }
        throw new ParameterResolutionException("No random generator "+type);

    }
}
