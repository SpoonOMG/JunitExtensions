package framework.qa.consts;

import lombok.Getter;


@Getter
public enum ScenarioCodeEnum {


    sc_04b1b0cbf1754c9("171","sc_04b1b0cbf1754c9","ПУ Мое дело"),
    sc_f5a1e90d55b4c15("131","sc_f5a1e90d55b4c15","Карта жителя Свердловской области"),
    sc_4262aa8ccd8ada7("9001","sc_4262aa8ccd8ada7","Дополнительная дебетовая карта"),
    sc_421e8df062b2939("261","sc_421e8df062b2939","Карта Армия Ветеран"),
    sc_57eb451bc6aa383("001","sc_57eb451bc6aa383","ПУ Универсальный Visa Gold"),
    sc_d32be9b85bdd188("SITE_ISSUE","sc_d32be9b85bdd188","Заявка на выдачу ДК с сайта"),
    sc_8bcd45ca294be5a("cardIssuanceCourier","sc_8bcd45ca294be5a","Выдача карты из КНД"),
    sc_bf7eb44d4906736("AGGREGATOR","sc_bf7eb44d4906736","Заявка на ДК от партнеров"),
    sc_aaa069108374373("041","sc_aaa069108374373","Пенсионная карта"),
    sc_050bf0e46183924("123","sc_050bf0e46183924","Карта Газпромнефть Instant"),
    sc_3c33693f0cf0e2c("9000","sc_3c33693f0cf0e2c","Зарплатная карта без реестра"),
    sc_952dc9ede3b89c0("012","sc_952dc9ede3b89c0","КЖНО новый сценарий"),
    sc_d4f3b8b82abe703("012","sc_d4f3b8b82abe703","КЖНО старый сценарий"),
    sc_beece2b6ae57866("002","sc_beece2b6ae57866","Премиум"),
    sc_2bd290ce18e7c38("008","sc_2bd290ce18e7c38","Премиум UP"),
    sc_268e095e417227a("010","sc_268e095e417227a","UP Валютная"),
    sc_a962ae4856b4934("035","sc_a962ae4856b4934","Клубный мир Казак"),
    sc_a0afbd89199cded("036","sc_a0afbd89199cded","Карта Жителя Сахалин"),
    sc_28fe75e70f491af("020","sc_28fe75e70f491af","Клубный Кобренд"),
    sc_13cc01653561c2c("SITE","sc_13cc01653561c2c","Заявка с сайта через ГПБ-АПИ"),
    sc_71b501548473525("128","sc_71b501548473525","Карта жителя Вологды");



    private final String code;

    public String getCode() {
        return code;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    ScenarioCodeEnum(String code, String id, String description) {
        this.code = code;
        this.id = id;
        this.description = description;
    }

    private final String id;
    private final String description;

}
