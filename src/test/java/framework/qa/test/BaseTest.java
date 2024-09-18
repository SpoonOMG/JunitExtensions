package framework.qa.test;

import framework.qa.jupiter.callbacks.RestExtension;
import framework.qa.jupiter.callbacks.TestSaver;
import framework.qa.jupiter.parameters.WiremockResolver;
import framework.qa.models.init.ValuesItem;
import framework.qa.values.Params;
import org.junit.jupiter.api.extension.ExtendWith;
import framework.qa.jupiter.parameters.InitResolver;

@ExtendWith({TestSaver.class, InitResolver.class, RestExtension.class, WiremockResolver.class})
public class BaseTest {

    protected String title = "руководитель экспертизы по аналитике";
    protected String branchCode = "000";
    protected String branchUnitCode = "ОП_ДО";
    protected String virtualNum = "DRTL10074435955";
    protected String login = "gpbu19309";
    protected String userFullName = "Хохлов Николай";

    protected ValuesItem loginValue = new ValuesItem(Params.LOGIN, login);
    protected ValuesItem userFullNameValue = new ValuesItem(Params.USER_FULL_NAME, userFullName);
    protected ValuesItem titleValue = new ValuesItem(Params.TITLE, title);
    protected ValuesItem branchCodeValue = new ValuesItem(Params.BRANCH_CODE, branchCode);
    protected ValuesItem branchUnitCodeValue = new ValuesItem(Params.BRANCH_UNIT_CODE, branchUnitCode);
    protected ValuesItem virtualNumValue = new ValuesItem(Params.VIRTUAL_NUM, virtualNum);
}
