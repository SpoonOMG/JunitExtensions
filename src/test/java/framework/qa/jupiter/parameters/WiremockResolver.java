//package framework.qa.jupiter.parameters;
//
//import framework.qa.jupiter.annotations.Mock;
//import org.junit.jupiter.api.extension.ExtensionContext;
//import org.junit.jupiter.api.extension.ParameterContext;
//import org.junit.jupiter.api.extension.ParameterResolutionException;
//import org.junit.jupiter.api.extension.ParameterResolver;
//import framework.qa.utils.WiremockRetrofit;
//
//public class WiremockResolver implements ParameterResolver {
//    @Override
//    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
//        return parameterContext.isAnnotated(Mock.class);
//
//    }
//
//    @Override
//    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext ) throws ParameterResolutionException {
//        Class<?> type = parameterContext.getParameter().getType();
//        if(WiremockRetrofit.class.equals(type)){
//            WiremockRetrofit wiremock = new WiremockRetrofit();
//            return wiremock;
//        }
//        throw new ParameterResolutionException("No random generator "+type);
//
//    }
//}
