package framework.qa.test;

import framework.qa.config.Config;
import framework.qa.jupiter.callbacks.RestExtension;
import framework.qa.jupiter.callbacks.TestSaver;
import framework.qa.jupiter.parameters.CheckRequestResolver;
import framework.qa.jupiter.parameters.InitRequestResolver;
import framework.qa.jupiter.parameters.WiremockResolver;
import org.junit.jupiter.api.extension.ExtendWith;
import framework.qa.jupiter.parameters.InitResolver;

@ExtendWith({TestSaver.class,
        InitResolver.class,
        RestExtension.class,
        WiremockResolver.class,
        InitRequestResolver.class,
        CheckRequestResolver.class})
public abstract class BaseTest {
    protected static final Config CFG = Config.getInstance();
    protected static final String guid = "6F57A2C3507C4D6AA1A70E9C8C8CF911";


}
