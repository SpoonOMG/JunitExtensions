package thread.qa;

import org.junit.jupiter.api.extension.ExtendWith;
import thread.qa.callbacks.RestExtension;
import thread.qa.callbacks.TestSaver;
import thread.qa.models.init.ValuesItem;
import thread.qa.parameters.InitResolver;
import thread.qa.parameters.WiremockResolver;

@ExtendWith({TestSaver.class, InitResolver.class, RestExtension.class, WiremockResolver.class})
public class BaseTest {

    protected String title = "руководитель экспертизы по аналитике";
    protected String branchCode = "000";
    protected String branchUnitCode = "ОП_ДО";
    protected String virtualNum = "DRTL10074435955";
    protected String login = "gpbu19309";
    protected String userFullName = "Хохлов Николай";

    protected ValuesItem loginValue = new ValuesItem(Values.LOGIN, login);
    protected ValuesItem userFullNameValue = new ValuesItem(Values.USER_FULL_NAME, userFullName);
    protected ValuesItem titleValue = new ValuesItem(Values.TITLE, title);
    protected ValuesItem branchCodeValue = new ValuesItem(Values.BRANCH_CODE, branchCode);
    protected ValuesItem branchUnitCodeValue = new ValuesItem(Values.BRANCH_UNIT_CODE, branchUnitCode);
    protected ValuesItem virtualNumValue = new ValuesItem(Values.VIRTUAL_NUM, virtualNum);
}
