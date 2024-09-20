package framework.qa.consts;

import lombok.Getter;


@Getter
public enum ScenarioCodeEnum {


    id171("171","sc_04b1b0cbf1754c9","ПУ Мое дело"),
    id172("172","sc_04b1b0cbf1754c9","ПУ Мое дело"),
    id131("131","sc_f5a1e90d55b4c15","Карта жителя"),
    id085("085","sc_4262aa8ccd8ada7","Дополнительная дебетовая карта"),
    id087("087","sc_4262aa8ccd8ada7","Дополнительная дебетовая карта"),
    id088("088","sc_4262aa8ccd8ada7","Дополнительная дебетовая карта"),
    id089("089","sc_4262aa8ccd8ada7","Дополнительная дебетовая карта"),
    id090("090","sc_4262aa8ccd8ada7","Дополнительная дебетовая карта"),
    id091("091","sc_4262aa8ccd8ada7","Дополнительная дебетовая карта"),
    sc_421e8df062b2939("261","sc_421e8df062b2939","Карта Армия Ветеран"),
    sc_57eb451bc6aa383("001","sc_57eb451bc6aa383","ПУ Универсальный Visa Gold");


//    sc_dff09e0c2f36177("",""),
//    sc_13cc01653561c2c("",""),
//    sc_c632ca3932f0692("",""),
//    sc_28fe75e70f491af("",""),
//    sc_838c6f1fcb1f86e("",""),
//    sc_71b501548473525("",""),
//    sc_57eb451bc6aa383("",""),
//    sc_050bf0e46183924("",""),
//    sc_1d06932184be90c("",""),
//    sc_aaa069108374373("",""),
//    sc_beece2b6ae57866("",""),
//    sc_268e095e417227a("",""),
//    sc_3c33693f0cf0e2c("",""),
//    sc_a962ae4856b4934("",""),


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
