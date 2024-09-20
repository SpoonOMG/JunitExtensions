package framework.qa.consts;

import lombok.Getter;


@Getter
public enum ChannelEnum {
    UFO("ufo", "Дашборд ФО"),
    IB("ib", "интернет банк"),
    MB("mb", "мобильный банк"),
    MOBILE("mobile", "мобильный банк 2"),
    UFO_CC("ufo-cc", "Дашборд КЦ"),
    UFO_DSA("ufo-dsa", "ufo-dsa"),
    WEB("web", "web"),
    DEFAULT("default", "default"),
    MA_PARTNER("ma-partner", "ma-partner"),
    WA_PARTNER("wa-partner", "wa-partner"),
    GPAY("gpay", "gpay"),
    MA_GPAY("ma-gpay", "ma-gpay"),
    WA_BANKI_RU("wa-banki-ru", "wa-banki-ru");

    ChannelEnum(String name, String description) {
        this.name = name;
        this.description = description;
    }

    private final String name;
    private final String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
