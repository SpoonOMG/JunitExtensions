package framework.qa.consts;

import java.util.Map;

/**
 * Константы сервиса карт
 */
public class OmniOksCardsConst {

    public static final String CLIENT_REQUIRED = "clientRequired";

    public static final String CLIENT_OPTIONAL = "clientOptional";

    public static final String DADATA_ENTRY = "dadataEntry";

    public static final String IS_UNEMBOSSED_EMBOSSED = "0"; //Персонализированная карта

    public static final String IS_UNEMBOSSED_UNEMBOSSED = "1"; //не персонализированная карта

    public static final String IS_UNEMBOSSED_CARD_FOR_PERS = "2"; //карта без номера, для массового выпуска карт

    public static final String IS_UNEMBOSSED_MOMENTAL = "3"; //моментальная карта

    public static final String CLIENT_IS_RESIDENT = "1";

    public static final String CLIENT_NOT_RESIDENT = "2";

    public static final String RESIDENT_TYPE_CODE = "21";

    public static final String NON_RESIDENT_TYPE_CODE = "10";

    public static final String TYPE_CREATION_PLASTIC = "0";

    public static final String TYPE_CREATION_DIGITAL = "1";

    public static final String CARD_CATEGORY_CODE_WORLD = "6";

    public static final String CARD_CATEGORY_CODE_INFINITE = "5";

    public static final String CARD_CATEGORY_CODE_SIGNATURE = "4";

    //Публичное должностное лицо true
    public static final String DIGNITARY_FLAG_TRUE = "2";

    //Публичное должностное лицо false
    public static final String DIGNITARY_FLAG_FALSE = "1";

    public static final String PAYMENT_SYSTEM_CODE_VISA = "1";

    public static final String PAYMENT_SYSTEM_CODE_MC_WORLD = "2";

    public static final String PAYMENT_SYSTEM_CODE_MIR = "3";

    public static final String PAYMENT_SYSTEM_CODE_UNION_PAY = "4";

    public static final String PAYMENT_SYSTEM_CODE_JCB = "5";

    public static final String BG_PAYMENT_SYSTEM_CODE_MIR = "6";

    public static final String PAYMENT_SYSTEM_CODE_MIR_JCB = "7";

    public static final String SEVEN = "7";

    //Способ получения в офисе
    public static final String KIND_GET_OFFICE = "1";

    //Способ получения курьером
    public static final String KIND_GET_COURIER = "2";

    //Для выпуска цифровой карты
    public static final String KIND_GET_DIGITAL = "3";

    public static final String MALE = "1";

    public static final String FEMALE = "0";

    public static final String SERVICE_PACKAGE_UNIVERSAL = "Универсальный";

    public static final String SERVICE_PACKAGE_PREMIUM = "Газпромбанк.Премиум";

    public static final String SERVICE_PACKAGE_PREMIUM_UP = "Газпромбанк.Премиум UP";

    public static final String SERVICE_PACKAGE_PREMIUM_CODE = "002";

    public static final String SERVICE_PACKAGE_PREMIUM_UP_CODE = "008";

    public static final String SUB_PROGRAM_CODE_VISA_GOLD = "001";

    public static final String SUB_PROGRAM_CODE_SIGNATURE = "002";

    public static final String SUB_PROGRAM_CODE_VISA_GOLD_INSTANT = "005";

    public static final String SUB_PROGRAM_CODE_UP_PLATINUM_810 = "007";

    public static final String SUB_PROGRAM_CODE_VISA_INFINITE = "008";

    public static final String SUB_PROGRAM_CODE_VISA_INFINITE_METAL = "009";

    public static final String SUB_PROGRAM_CODE_MC_WORLD_DIGITAL= "010";

    public static final String SUB_PROGRAM_CODE_KZHNO = "012";

    public static final String SUB_PROGRAM_CODE_KZHNO_MIR_ADVANCED = "121";

    public static final String SUB_PROGRAM_CODE_JCB_GOLD = "013";

    public static final String SUB_PROGRAM_CODE_JCB_GOLD_INSTANT = "014";

    public static final String SUB_PROGRAM_CODE_VISA_SIGNATURE_INSTANT = "015";

    public static final String SUB_PROGRAM_CODE_VISA_SIGNATURE_FOREIGN = "016";

    public static final String SUB_PROGRAM_CODE_VISA_INFINITE_FOREIGN = "017";

    public static final String SUB_PROGRAM_CODE_JCB_ADVANCED = "018";

    public static final String SUB_PROGRAM_CODE_JCB_ADVANCED_INSTANT = "019";

    public static final String SUB_PROGRAM_CODE_COBREND_WORLD = "020";

    public static final String SUB_PROGRAM_CODE_UP_CLASSIC_810 = "021";

    public static final String SUB_PROGRAM_CODE_UP_GOLD_810 = "022";

    public static final String SUB_PROGRAM_CODE_UP_GOLD_INSTANT_810 = "023";

    public static final String SUB_PROGRAM_CODE_UP_PLATINUM_INSTANT_810 = "025";

    public static final String SUB_PROGRAM_CODE_MC_PLATINUM_VSDC = "026";

    public static final String SUB_PROGRAM_CODE_MC_WORLD_PP = "027";

    public static final String SUB_PROGRAM_CODE_MC_WORLD_UNEMBOSSED_INSTANT_PP = "028";

    public static final String SUB_PROGRAM_CODE_MC_WORLD_UNEMBOSSED_PP = "029";

    public static final String SUB_PROGRAM_CODE_GPN_MIR_ADVANCED = "119";

    public static final String SUB_PROGRAM_CODE_MIR = "030";

    public static final String SUB_PROGRAM_CODE_MIR_INSTANT = "031";

    public static final String SUB_PROGRAM_CODE_COBREND_VISA = "034";

    public static final String SUB_PROGRAM_CODE_CLUBMIR_KAZAK = "035";

    public static final String SUB_PROGRAM_CODE_CLUBMIR_ADVANCED = "059";

    public static final String SUB_PROGRAM_CODE_SAHALIN = "036";

    public static final String SUB_PROGRAM_CODE_VISA_GOLD_DIGITAL = "037";

    public static final String SUB_PROGRAM_CODE_MIR_JCB_DIGITAL = "038";

    public static final String SUB_PROGRAM_CODE_PENS = "041";

    public static final String SUB_PROGRAM_CODE_PENS_INSTANT = "042";

    public static final String SUB_PROGRAM_CODE_VISA_SIGNATURE_DIGITAL = "043";

    public static final String SUB_PROGRAM_CODE_VISA_SIGNATURE_DIGITAL_FOREIGN = "044";

    public static final String SUB_PROGRAM_CODE_UP_GOLD_810_DIGITAL = "047";

    public static final String SUB_PROGRAM_CODE_UP_CLASSIC_840_DIGITAL = "048";

    public static final String SUB_PROGRAM_CODE_UP_CLASSIC_978_DIGITAL = "049";

    public static final String SUB_PROGRAM_CODE_MIR_ADVANCED_UNIVERSAL = "050";

    public static final String SUB_PROGRAM_CODE_MIR_ADVANCED_INSTANT_UNIVERSAL = "051";

    public static final String SUB_PROGRAM_CODE_MIR_ADVANCED_PENS = "052";

    public static final String SUB_PROGRAM_CODE_MIR_ADVANCED_INSTANT_PENS = "053";

    public static final String SUB_PROGRAM_CODE_MIR_SUPREME_DIGITAL_PACKAGE_PREMIUM = "054";

    public static final String SUB_PROGRAM_CODE_MIR_SUPREME_PACKAGE_PREMIUM = "056";

    public static final String SUB_PROGRAM_CODE_MIR_SUPREME_INSTANT_PACKAGE_PREMIUM = "057";

    public static final String SUB_PROGRAM_CODE_MIR_ADVANCED_DIGITAL = "060";

    public static final String SUB_PROGRAM_CODE_MASS_ISSUANCE = "000";

    public static final String SUB_PROGRAM_UP_GOLD_156 = "067";

    public static final String SUB_PROGRAM_UP_GOLD_INSTANT_156 = "069";

    public static final String SUB_PROGRAM_NAME_VISA_INFINITE_PREMIUM = "Visa Infinite Пакет Премиум";

    public static final String SUB_PROGRAM_NAME_VISA_PLATINUM_PREMIUM = "Visa Platinum Пакет Премиум";

    public static final String SUB_PROGRAM_NAME_MIR_JCB_ADVANCED_PREMIUM = "Зарп Visa Signature Пакет Зарп Premium";

    public static final String SUB_PROGRAM_NAME_UP_GOLD_INSTANT_810 = "UP Gold Instant 810 Пакет Универсальный";

    public static final String SUB_PROGRAM_NAME_UP_PLATINUM_810 = "UP Platinum 810 Пакет Универсальный";

    public static final String SUB_PROGRAM_NAME_UP_PLATINUM_INSTANT_810 = "UP Platinum Instant 810 Пакет Универсал";

    public static final String SUB_PROGRAM_CODE_ADD_UP_GOLD_810 = "085";

    public static final String SUB_PROGRAM_NAME_ADD_UP_GOLD_810 = "Доп UP 810 Gold Пакет Универсальный";

    public static final String SUB_PROGRAM_CODE_ADD_MIR_ADVANCED_UNIVERSAL = "087";

    public static final String SUB_PROGRAM_NAME_ADD_MIR_ADVANCED_UNIVERSAL = "Доп МИР Advanced Пакет Универсальный";

    public static final String SUB_PROGRAM_CODE_ADD_MIR_ADVANCED_INSTANT = "088";

    public static final String SUB_PROGRAM_NAME_MIR_ADVANCED_INSTANT = "МИР Advanced Instant Пакет Универсальный";

    public static final String SUB_PROGRAM_NAME_ADD_MIR_ADVANCED_INSTANT = "Доп МИР Advanced Instant Пакет Универсальный";

    public static final String SUB_PROGRAM_CODE_ADD_UP_GOLD_INSTANT_810 = "089";

    public static final String SUB_PROGRAM_NAME_ADD_UP_GOLD_INSTANT_810 = "Доп UP Gold Instant 810 Пакет Универсальный";

    public static final String SUB_PROGRAM_CODE_ADD_MIR_ADVANCED_INSTANT_STICKER = "090";

    public static final String SUB_PROGRAM_NAME_ADD_MIR_ADVANCED_INSTANT_STICKER = "Доп МИР Advanced Instant Пакет Универсальный Стикер";

    public static final String SUB_PROGRAM_CODE_ADD_MIR_ADVANCED_STICKER = "091";

    public static final String SUB_PROGRAM_NAME_ADD_MIR_ADVANCED_STICKER = "Доп МИР Advanced Пакет Универсальный Стикер";

    public static final String SUB_PROGRAM_CODE_ADD_MIR_SUPREME_PREMIUM = "093";

    public static final String SUB_PROGRAM_NAME_ADD_MIR_SUPREME_PREMIUM = "Доп МИР Supreme Пакет Премиум";

    public static final String SUB_PROGRAM_CODE_ADD_UP_DIAMOND_810_PREMIUM = "094";

    public static final String SUB_PROGRAM_NAME_ADD_UP_DIAMOND_810_PREMIUM = "Доп UP Diamond 810 Пакет Премиум";

    public static final String SUB_PROGRAM_CODE_ADD_UP_DIAMOND_156_PREMIUM = "124";

    public static final String SUB_PROGRAM_NAME_ADD_UP_DIAMOND_156_PREMIUM = "Доп UP Diamond 156 Пакет Премиум";

    public static final String SUB_PROGRAM_CODE_ADD_UP_DIAMOND_INSTANT_810_PREMIUM = "095";

    public static final String SUB_PROGRAM_NAME_ADD_UP_DIAMOND_INSTANT_810_PREMIUM = "Доп UP Diamond Instant 810 Пакет Премиум";

    public static final String SUB_PROGRAM_CODE_ADD_UP_DIAMOND_INSTANT_156_PREMIUM = "125";

    public static final String SUB_PROGRAM_NAME_ADD_UP_DIAMOND_INSTANT_156_PREMIUM = "Доп UP Diamond Instant 156 Пакет Премиум";

    public static final String SUB_PROGRAM_CODE_ADD_MIR_SUPREME_INSTANT_PREMIUM_STICKER = "107";

    public static final String SUB_PROGRAM_NAME_ADD_MIR_SUPREME_INSTANT_PREMIUM_STICKER = "Доп МИР Supreme Instant Пакет Премиум Стикер";

    public static final String SUB_PROGRAM_CODE_ADD_MIR_SUPREME_PREMIUM_UP = "103";

    public static final String SUB_PROGRAM_NAME_ADD_MIR_SUPREME_PREMIUM_UP = "Доп МИР Supreme Пакет Премиум UP";

    public static final String SUB_PROGRAM_CODE_ADD_MIR_SUPREME_INSTANT_PREMIUM_UP_STICKER = "108";

    public static final String SUB_PROGRAM_NAME_ADD_MIR_SUPREME_INSTANT_PREMIUM_UP_STICKER = "Доп МИР Supreme Instant Пакет Премиум UP Стикер";

    public static final String SUB_PROGRAM_CODE_ADD_UP_DIAMOND_810_PREMIUM_UP = "105";

    public static final String SUB_PROGRAM_NAME_ADD_UP_DIAMOND_810_PREMIUM_UP = "Доп UP Diamond 810 Пакет Премиум UP";

    public static final String SUB_PROGRAM_CODE_ADD_UP_DIAMOND_156_PREMIUM_UP = "126";

    public static final String SUB_PROGRAM_NAME_ADD_UP_DIAMOND_156_PREMIUM_UP = "Доп UP Diamond 156 Пакет Премиум UP";

    public static final String SUB_PROGRAM_CODE_ADD_UP_DIAMOND_INSTANT_810_PREMIUM_UP = "106";

    public static final String SUB_PROGRAM_NAME_ADD_UP_DIAMOND_INSTANT_810_PREMIUM_UP = "Доп UP Diamond Instant 810 Пакет Прем UP";

    public static final String SUB_PROGRAM_CODE_ADD_UP_DIAMOND_INSTANT_156_PREMIUM_UP = "127";

    public static final String SUB_PROGRAM_NAME_ADD_UP_DIAMOND_INSTANT_156_PREMIUM_UP = "Доп UP Diamond Instant 156 Пакет Прем UP";

    public static final String SUB_PROGRAM_CODE_MIR_MC_ADVANCED_PROFSOYZ = "110";

    public static final String SUB_PROGRAM_NAME_MIR_MC_ADVANCED_PROFSOYZ = "Доп Зарп МИРmc Advanced Пакет Газпром Профсоюз";

    public static final String SUB_PROGRAM_CODE_MIR_ADVANCED_CASHBACK = "111";

    public static final String SUB_PROGRAM_NAME_MIR_ADVANCED_CASHBACK = "Доп Зарп МИР Advanced Кэшбэк Газпро";

    public static final String SUB_PROGRAM_CODE_MIR_SUPREME_CASHBACK = "112";

    public static final String SUB_PROGRAM_NAME_MIR_SUPREME_CASHBACK = "Доп Зарп МИР Supreme Кэшбэк Газпром к Si";

    public static final String SUB_PROGRAM_CODE_MIR_ADVANCED_ARMY = "113";

    public static final String SUB_PROGRAM_NAME_MIR_ADVANCED_ARMY = "Доп Зарп МИР Advanced Армия";

    public static final String SUB_PROGRAM_CODE_MIR_ADVANCED_SIL_STRUCT = "114";

    public static final String SUB_PROGRAM_NAME_MIR_ADVANCED_SIL_STRUCT = "Доп Зарп МИР Advanced СилСтр";

    public static final String SUB_PROGRAM_CODE_MIR_ADVANCED_CLUB = "115";

    public static final String SUB_PROGRAM_NAME_MIR_ADVANCED_CLUB = "Доп Зарп МИР Advanced Пакет Клубный";

    public static final String SUB_PROGRAM_CODE_MIR_ADVANCED_CLUB_ZP = "116";

    public static final String SUB_PROGRAM_CODE_GAZPROM_NEFT = "123";

    public static final String SUB_PROGRAM_NAME_MIR_ADVANCED_CLUB_ZP = "Доп Зарп МИР Advanced Пакет Клуб ЗП ФБСР";

    public static final String SUB_PROGRAM_CODE_ADD_ZP_MIR_ADVANCED_ZP_UNIVERSAL_STICKER = "097";

    public static final String SUB_PROGRAM_NAME_ADD_ZP_MIR_ADVANCED_ZP_UNIVERSAL_STICKER = "Доп Зарп МИР Advanced Пакет Зарп Ун Стик";

    public static final String SUB_PROGRAM_CODE_ADD_ZP_MIR_ADVANCED_ZP_UNIVERSAL = "098";

    public static final String SUB_PROGRAM_NAME_ADD_ZP_MIR_ADVANCED_ZP_UNIVERSAL = "Доп Зарп МИР Advanced ПУ ЗП Унив";
    //public static final String SUB_PROGRAM_NAME_ADD_ZP_MIR_ADVANCED_ZP_UNIVERSAL = "Доп Зарп МИР Advanced ПУ ЗП Унив";

    public static final String SUB_PROGRAM_CODE_MY_BUSINESS_MIR_ADVANCE_INSTANT = "171";

    public static final String SUB_PROGRAM_CODE_MY_BUSINESS_UP_GOLD_INSTANT = "172";

    public static final String SUB_PROGRAM_NAME_ADD_MY_BUSINESS_INSTANT = "Доп МИР Advanced Instant ПУ Мое дело";

    public static final String SUB_PROGRAM_CODE_ADD_MY_BUSINESS_INSTANT = "174";
    public static final String SUB_PROGRAM_NAME_ADD_MY_BUSINESS_INSTANT_STICK = "Доп МИР Advanced Instant ПУ Мое дело Стикер";

    public static final String SUB_PROGRAM_CODE_ADD_MY_BUSINESS_INSTANT_STICK = "175";
    public static final String SUB_PROGRAM_NAME_ADD_MY_BUSINESS_UP_GOLD_INSTANT = "Доп UP Gold Instant ПУ Мое дело";

    public static final String SUB_PROGRAM_CODE_ADD_MY_BUSINESS_UP_GOLD_INSTANT = "176";

    public static final String SUB_PROGRAM_CODE_VETERAN = "261";

    public static final String SCENARIO_CODE_VIEW_DEBIT_CARDS = "VIEW_DEBIT_CARDS";


    //Плейсхолдеры в сообщениях об ошибках
    public static final String REQUEST_FIELDS = "REQUEST_FIELDS";

    public static final String PHONE_TYPE_CARDHOLDER = "CARDHOLDER";

    public static final String PHONE_TYPE_OTHER = "OTHER";

    public static final String SUB_PROGRAM_NAME = "SUB_PROGRAM_NAME";

    public static final String ERROR_MSG = "ERROR_MSG";

    public static final String SERVICE_PACKAGE_NAME = "SERVICE_PACKAGE_NAME";

    public static final String SUB_PROGRAM_NAMES = "SUB_PROGRAM_NAMES";

    public static final String SUB_PROGRAM_GENITIVE_NAME = "SUB_PROGRAM_GENITIVE_NAME";

    public static final String COMMUNICATION_PACKET_CODE_SMS_PUSH = "003";

    public static final String COMMUNICATION_PACKET_CODE_SMS_DISABLE_PUSH = "000";

    public static final String RUSSIAN_CURRENCY = "1";

    public static final String USA_CURRENCY = "2";

    public static final String EUROPE_CURRENCY = "3";

    public static final String CHINESE_CURRENCY = "4";

    public static final String COMMAND_TYPE_DEFAULT = "default";

    public static final String COMMAND_TYPE_EXECUTE = "execute";

    public static final String LOCATION_OFFICE = "locationOffice";

    public static final String CLIENT_TYPE = "clientType";

    public static final String CONTACT_PHONE_CLIENT = "contactPhoneClient";

    public static final String RAW_SOURCE = "rawSource";

    /**
     * Значение по умолчанию поля ##ProductRestrictionPayment и ##ProductRestrictionPaymentUP
     */
    public static final String PRODUCT_RESTRICTION_PAYMENT_DEFAULT = "false";


    public static final String OMNI_OKS_CARDS = "omni-oks-cards";

    public static final String EMPTY_DATABASE_STRING = "#EMPTY#";

    /**
     * Код значения из VerifyData, в котором приходит признак биометрии.
     */
    public static final String IS_EBS = "isEbs";

    /**
     * Параметр, передаваемый при редиректе со сценария Подписания ДКО на сценарий выпуска цифровой карты
     */
    public static final String RELATION_ORDER_ID = "relationOrderId";

    /**
     * Код экранной формы для INIT биометрии и пакета Универсальный
     */
    public static final String UNIVERSAL_EBS_INIT_METADATA_ID = "5NT_EBS_CARD_PARAMS";

    /**
     * Код кэранной формы для STATUS биометрии и пакета Универсальынй
     */
    public static final String UNIVERSAL_EBS_STATUS_METADATA_ID = "5NT_EBS_CARD_STATUS";


    /**
     * Код экранной формы для INIT биометрии и пакета Универсальный канал ib
     */
    public static final String UNIVERSAL_EBS_INIT_METADATA_ID_IB = "5NT_EBS_CARD_PARAMS_IB";

    /**
     * Код кэранной формы для STATUS биометрии и пакета Универсальынй канал ib
     */
    public static final String UNIVERSAL_EBS_STATUS_METADATA_ID_IB = "5NT_EBS_CARD_STATUS_IB";

    public static final String SIGN_MODE_NEW_DIGITAL_SIGN = "omniDigitalSign";

    public static final String EDIT_CLIENT_DATA_UFO_URL = "https://esfl.int.gazprombank.ru/clients/";
    public static final String EDIT_CLIENT_DATA_UFO_DSA_URL = "https://dsa.int.gazprombank.ru/clients/";


    /**
     * Пакеты услуг
     */
    public static final String UNIVERSAL = "1"; // ПУ Универсальный

    public static final String PREMIUM = "2"; // ПУ Премиум

    public static final String PREMIUM_UP = "3"; // ПУ Премиум UP

    public static final String ZP_UNIVERSAL = "9"; // ПУ Зарплатный Универсальный

    public static final String GAZPROM_PROFSOYZ = "10"; // ПУ Газпром Профосюз

    public static final String GAZPROM_CASHBACK = "11"; // ПУ Группа Газпром

    public static final String ARMY = "12"; // ПУ Армия Силовые Структуры Росгрвадия

    public static final String CLUB_ZP = "13"; // ПУ Клубный, Клубный ЗП

    public static final String MY_BUSINESS = "14"; // ПУ Мое Дело

    public static final String GO_SAVINGS_ACCOUNT_URL_TEMPLATE = "%s/clients/%s/products/newProduct/choose#/web/products?porterMode=default&type=deposit&subType=account";

    public static final String GO_TO_CREDIT_CARD_ORDERS_URL_TEMPLATE = "%s/clients/%s?current_tab_id=orders_tab";

    /**
     * Платежные системы
     */
    public static final String VISA = "VISA";
    public static final String MASTER = "MASTER";
    public static final String MIR = "MIR";
    public static final String MIR_RU = "МИР";
    public static final String UNION_PAY = "UNIONPAY";
    public static final String UP = "UP";
    public static final String JCB = "JCB";
    public static final String MIR_MC = "МИРMC";
    public static final String MIR_JCB = "МИР/JCB";

    /**
     * Идентификатор сценария
     */
    public static final String MASS_ISSUANCE_SCENARIO_ID = "sc_dff09e0c2f36177";
    public static final String UNIVERSAL_SCENARIO_ID = "sc_57eb451bc6aa383";

    private OmniOksCardsConst()  {
        throw new IllegalStateException("Utility class");
    }

    public static final Map<String, String> SERVICE_PACKAGE_NAME_MAP = Map.of(
                SERVICE_PACKAGE_PREMIUM_CODE, SERVICE_PACKAGE_PREMIUM,
                SERVICE_PACKAGE_PREMIUM_UP_CODE, SERVICE_PACKAGE_PREMIUM_UP
        );

}
