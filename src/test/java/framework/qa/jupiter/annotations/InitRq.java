package framework.qa.jupiter.annotations;

import framework.qa.models.init.ValuesItem;
import framework.qa.models.init.VerifyData;
import framework.qa.models.requestData.ScreenValueBack;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface InitRq {
   String channel();
   String scenarioCode();

}
