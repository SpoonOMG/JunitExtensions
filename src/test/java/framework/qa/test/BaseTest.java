package framework.qa.test;

import framework.qa.config.Config;
import framework.qa.consts.ChannelEnum;
import framework.qa.consts.Params;
import framework.qa.consts.UiFieldsNames;
import framework.qa.jupiter.callbacks.TestSaver;
import framework.qa.jupiter.callbacks.WmockExtension;
import framework.qa.jupiter.parameters.CheckRequestResolver;
import framework.qa.jupiter.parameters.InitRequestResolver;
//import framework.qa.jupiter.parameters.LoadRequestResolver;
//import framework.qa.jupiter.parameters.WiremockResolver;
import framework.qa.models.requestData.ScreenValueBack;
import framework.qa.values.TestDataValues;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;

import static framework.qa.values.TestDataValues.*;
import static framework.qa.values.TestDataValues.title;

@ExtendWith({
        TestSaver.class,
        WmockExtension.class,
        InitRequestResolver.class,
        CheckRequestResolver.class})
public abstract class BaseTest {
    protected static final Config CFG = Config.getInstance();
    protected static final String guid = "6F57A2C3507C4D6AA1A70E9C8C8CF911";

    protected List<ScreenValueBack> operationFinalMinParam() {
        List<ScreenValueBack> operation = new ArrayList<>();
        operation.add(new ScreenValueBack(Params.LOGIN, TestDataValues.login));
        operation.add(new ScreenValueBack(Params.BRANCH_CODE, branchCode));
        operation.add(new ScreenValueBack(Params.CURRENCY_CODE, "810"));
        operation.add(new ScreenValueBack(Params.SUB_PROGRAM_CODE, subProgramCode));
        operation.add(new ScreenValueBack(Params.CARD_CATEGORY_CODE, "7"));
        operation.add(new ScreenValueBack(Params.LATIN_CLIENT_NAME, TestDataValues.latinClientName));
        operation.add(new ScreenValueBack(UiFieldsNames.UI_SOURCE_CHANNEL, ChannelEnum.UFO.getName()));
        return operation;
    }



}
