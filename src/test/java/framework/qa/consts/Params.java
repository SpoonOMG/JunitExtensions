package framework.qa.consts;

public class Params {

    //init параметры
    public static final String LOGIN = "login";
    public static final String USER_FULL_NAME = "userFullName";
    public static final String VIRTUAL_NUM = "virtualNum";
    public static final String BRANCH_UNIT_CODE = "branchUnitCode";
    public static final String BRANCH_CODE = "branchCode";
    public static final String TITLE = "title";
    public static final String BRANCH_CODE_5NT = "branchCode5NT";
    public static final String ADDRESS_IS_INCORRECT = "addressIsIncorrect";



    //check параметры
    public static final String CHANNEL = "channel";
    public static final String GUID = "guid";
    public static final String SURNAME = "surname";
    public static final String NAME = "name";
    public static final String PATRONYMIC = "patronymic";
    public static final String SEX_CODE = "sexCode";
    public static final String IS_RESIDENT = "isResident";
    public static final String BIRTH_DATE = "birthDate";
    public static final String BIRTH_PLACE = "birthPlace";
    public static final String DOC_TYPE_CODE = "docTypeCode";
    public static final String DOC_SERIES = "docSeries";
    public static final String DOC_NUM = "docNum";
    public static final String ISSUE_DATE = "issueDate";
    public static final String ISSUED_BY = "issuedBy";
    public static final String ISSUE_DATE_END = "issueDateEnd";
    public static final String DEPART_CODE = "departCode";
    public static final String BIRTH_COUNTRY_CODE = "birthCountryCode";
    public static final String EMAIL = "EMAIL";
    public static final String CELL_PHONE = "CELLPHONE";
    public static final String CONSENT_PERSONAL_DATA = "ConsentPersonalData";
    public static final String CONSENT_PERSONAL_DATA_DATE = "ConsPersDataDate";
    public static final String CONSENT_PERSONAL_DATA_SHARING = "ConsentPersonalDataSharing";
    public static final String CONSENT_CH_CHECK = "ConsentCHCheck";
    public static final String CONSENT_ADV_SUBSCRIPTION = "ConsentAdvSubscription";
    public static final String CONSENT_VOICE_BIOMETRICS = "ConsentVoiceBiometrics";
    public static final String CONSENT_PERSONAL_DATA_PARTNER = "ConsentPersonalDataPartner";
    public static final String CURRENCY_CODE = "currencyCode"; // Код валюты (810 - рубль, 840 - доллар, 978 - евро)
    public static final String PDL = "PDL";
    public static final String FATCA = "FATCA";
    public static final String RECEPTION_SITE_CODE = "receptionSiteCode";
    public static final String SNILS = "SNILS"; //СНИЛС клиента обязателен для Карты Сахалинца
    public static final String LATIN_CLIENT_NAME = "latinClientName";
    public static final String KIND_GET = "kindGet";
    public static final String PROMO_CARD_CODE = "promoCardCode";
    public static final String IS_CODE_WORD = "isCodeWord";
    public static final String PAY_SYSTEM_CODE = "paySystemCode";
    public static final String PAYMENT_SYSTEM_CODE = "paymentSystemCode";
    public static final String PAYMENT_SYSTEM_CODE_DIGITAL = "##paymentSystemCodeDigital";
    public static final String PAYMENT_SYSTEM_CODE_PLASTIC = "##paymentSystemCodePlastic";
    public static final String CARD_CATEGORY_CODE = "cardCategoryCode";

    public static final String SUB_PROGRAM_CODE = "subProgramCode";
    public static final String PRIVILEGE_CARD_CODE = "privilegCardCode";
    public static final String CONTROL_INFO = "controlInfo";
    public static final String COUNTRY_ISO_CODE = "countryISOCODE";
    public static final String CITIZENSHIPS = "citizenships";

    public static final String IS_UNEMBOSSED = "IsUnembossed";
    // Признак неперсонализированной карты
    public static final String TYPE_CREATION = "TypeCreation"; // Признак виртуальной карты
    public static final String CARD_NUMBER = "CardNumber"; // Номер карты, вводимый вручную, только для неперсонализированной карты
    public static final String DATE_EXPIRATION = "DateExpiration"; // Дата истечения карты, вводимая вручную, только для неперсонализированной карты
    public static final String EMPLOYEE_POSITION = "employeePosition"; // Должность исполнителя формирующий отчет
    public static final String EMPLOYEE_FULL_NAME = "employeeFullName"; // Имя исполнителя формирующий отчет
    public static final String IS_DKBO = "isDkbo"; // Признак что клиент подписал договр с  5NT
    public static final String FROM_TIME = "fromTime"; // Признак что клиент подписал договр с  5NT
    public static final String TO_TIME = "toTime"; // Признак что клиент подписал договр с  5NT
    public static final String DELIVERY_ID = "deliveryID"; // TODO: Может, должно быть deliveryId, а не deliveryID?
    public static final String ORDER_4_CLIENT = "order4client";

    public static final String SYSTEM_ID = "systemId";

    public static final String PRODUCT_OFFER_SHORT_NAME = "productOfferShortName";

    // Выпуск доп карт

    public static final String VIRT_NUM_CARD_MAIN = "VirtNumCardMain"; // Виртуальный номер основной карты

    public static final String COMMISSION_VALUE = "CommissionValue"; // Сумма отложенной комиссии за выпуск доп карты

    public static final String COMMISSION_FUND = "CommissionFund"; // Валюта отложенной комиссии за выпуск доп карты

    public static final String PROROGUE = "Prorogue"; // Признак наличия отложенной комиссии за выпуск доп карты

    public static final String MANUFACT_TYPE = "ManufactType"; // Режим выпуск доп карты

    public static final String TYPE_CARD = "TypeCard"; // Признак основной/дополнительной ДК

    public static final String GPB_GUID = "gpbGuid"; // Уникальный идентификатор клиента

    public static final String T_PIN = "tPIN"; // Тип получения ПИНа (СМС или конверт)

    public static final String SOURCE_CHANNEL = "sourceChannel"; // Исходный канал создания ВИ

    public static final String REQUEST_ID = "requestId"; // Идентификатор заявки с сайта

    public static final String DADATA_ADDRESS = "dadataAddress"; // Исходный канал создания ВИ

    // Массовый выпуск ЗП карт
    public static final String CLIENT_ID = "ClientID";
    public static final String CARD_ID = "CardID";

    //Логистический модуль
    public static final String DATES_LOGISTICS = "dates.logistics";

    //Фактический адрес
    public static final String FT_COUNTRY_CODE = "ftCountryCode";
    public static final String FT_POSTAL_CODE = "ftPostalCode";
    public static final String FT_REGION_CODE = "ftRegionCode";
    public static final String FT_REGION_NAME = "ftRegionName";
    public static final String FT_DISTRICT = "ftDistrict";
    public static final String FT_CITY = "ftCity";
    public static final String FT_LOCALITY = "ftLocality";
    public static final String FT_STREET = "ftStreet";
    public static final String FT_HOUSE = "ftHouse";
    public static final String FT_HOUSING = "ftHousing";
    public static final String FT_BUILDING = "ftBuilding";
    public static final String FT_FLAT = "ftFlat";

    //Адрес регистрации
    public static final String RG_COUNTRY_CODE = "rgCountryCode";
    public static final String RG_POSTAL_CODE = "rgPostalCode";
    public static final String RG_REGION_CODE = "rgRegionCode";
    public static final String RG_REGION_NAME = "rgRegionName";
    public static final String RG_DISTRICT = "rgDistrict";
    public static final String RG_CITY = "rgCity";
    public static final String RG_LOCALITY = "rgLocality";
    public static final String RG_STREET = "rgStreet";
    public static final String RG_HOUSE = "rgHouse";
    public static final String RG_HOUSING = "rgHousing";
    public static final String RG_BUILDING = "rgBuilding";
    public static final String RG_FLAT = "rgFlat";

    //Адрес доставки
    public static final String DL_COUNTRY_CODE = "dlCountryCode";
    public static final String DL_POSTAL_CODE = "dlPostalCode";
    public static final String DL_REGION_CODE = "dlRegionCode";
    public static final String DL_REGION_NAME = "dlRegionName";
    public static final String DL_DISTRICT = "dlDistrict";
    public static final String DL_CITY = "dlCity";
    public static final String DL_LOCALITY = "dlLocality";
    public static final String DL_STREET = "dlStreet";
    public static final String DL_HOUSE = "dlHouse";
    public static final String DL_HOUSING = "dlHousing";
    public static final String DL_BUILDING = "dlBuilding";
    public static final String DL_FLAT = "dlFlat";

    //Прочее
    public static final String CLIENT_DATA_URL = "editClientDataUrl";
    public static final String ITIN = "ITIN";
    public static final String REAL_USER = "RealUser";
    public static final String BENF = "Benf";
    public static final String CRS = "CRS";
    public static final String CRS_COUNTRY_CODE = "CRSCountryCode";
    public static final String CRS_COUNTRY_CODE_2 = "CRSCountryCode2";
    public static final String CRS_COUNTRY_CODE_3 = "CRSCountryCode3";
    public static final String CRS_TIN = "CRS_TIN";
    public static final String CRS_TIN_2 = "CRS_TIN2";
    public static final String CRS_TIN_3 = "CRS_TIN3";
    public static final String REASON_NO_TIN = "reasonNoTIN";
    public static final String REASON_NO_TIN_2 = "reasonNoTIN2";
    public static final String REASON_NO_TIN_3 = "reasonNoTIN3";
    public static final String DOC_TYPE_DOP_DUL = "DocType%ddopDUL";
    public static final String DOC_SERIES_DOP_DUL = "DocSeries%ddopDUL";
    public static final String NUM_DOC_DOP_DUL = "NumDoc%ddopDUL";
    public static final String DATE_DOC_DOP_DUL = "DateDoc%ddopDUL";
    public static final String DATE_END_DOP_DUL = "DateEnd%ddopDUL";
    public static final String REG_NAME_DOP_DUL = "RegName%ddopDUL";
    public static final String CODE_DOP_DUL = "Code%ddopDUL";
    public static final String ALL_DOP_DUL = "AllDopDUL";
    public static final String GO_SAVINGS_ACCOUNT_URL = "goSavingsAccountUrl";
    public static final String INST_CODE = "InstCode";

    // Значения для программы Аэрофлот-Бонус
    public static final String PARTNERDEV_PARAM_MEMBER_ID = "partnerdevParam.aflt_memberID";
    public static final String PARTNERDEV_PARAM_NAME = "partnerdevParam.aflt_name";
    public static final String PARTNERDEV_PARAM_SURNAME = "partnerdevParam.aflt_surname";

    //Типы
    public static final String HOME_TYPE = "HOME";
    public static final String WORK_TYPE = "WORK";
    public static final String OTHER_TYPE = "OTHER";
    public static final String CONSTANT_REGISTRATION_TYPE = "CONSTANT_REGISTRATION";
    public static final String REGISTRATION_TYPE = "REGISTRATION";
    public static final String PASSPORT_RU_TYPE = "PASSPORT_RU";
    public static final String PASSPORT_FOREIGNER = "PASSPORT_FOREIGNER";
    public static final String SNILS_TYPE = "SNILS"; //тип документа в даных клиента
    public static final String ACTUAL_TYPE = "ACTUAL";
    public static final String PROLONGED = "PROLONGED";

    public static final String OUTDATED = "OUTDATED";
    public static final String INVALID = "INVALID";
    public static final String MALE_TYPE = "MALE";

    public static final String FEMALE_TYPE = "FEMALE";
    public static final String BASE_TYPE = "base";

    public static final String TAX_TYPE = "tax";
    public static final String MOBILE_TYPE = "MOBILE";
    public static final String PC_TYPE = "PC";
    public static final String MAIN_TYPE = "MAIN";

    // banki.ru
    public static final String CONSENT_IP_ADDRESS = "consentIp_address";
    public static final String CONSENT_SEND_TIME = "consentSend_time";
    public static final String CONSENT_SEND_SMSID = "consentSend_smsid";
    public static final String CONSENT_PHONE = "consentPhone";
    public static final String CONSENT_CODE_OTP = "consentCode_otp";
    public static final String CONSENT_IP_ADDRESS_OTP = "consentIp_address_otp";
    public static final String CONSENT_CHECK_TIME = "consentCheck_time";
    public static final String CONSENT_DIG_SING_CONDIT = "ConsentDigSingCondit";
    public static final String CONS_DIG_SING_CONDIT_DATE = "ConsDigSingConditDate";
    public static final String CONSENT_CASHBACK_GF = "ConsentCashbackGF";
    public static final String CONS_CASHBACK_GF_DATE = "ConsCashbackGFDate";
    public static final String CONSENT_PREMIUM_UP = "ConsentPremiumUP";
    public static final String CONS_PREMIUM_UP_DATE = "ConsPremiumUPDate";
    /**
     * В остальных режимах почему-то deliveryID, а в этом deliveryId.
     * Возможно, в остальных режимах неправильно?
     * {@link #DELIVERY_ID}
     */
    public static final String BANKI_RU_DELIVERY_ID = "deliveryId";

    public static final String IP_ADDRESS = "ip_address";
    public static final String SEND_TIME = "send_time";
    public static final String SEND_SMSID = "send_smsid";
    public static final String PHONE = "phone";
    public static final String CODE_OTP = "codeOtp";
    public static final String IP_ADDRESS_OTP = "ip_address_otp";
    public static final String CHECK_TIME = "check_time";

    public static final String APP_SEQUENCE = "appSequence";
    public static final String SALE_CHANNEL = "saleChannel";
    public static final String REQUESTER = "requester";
    public static final String IN_USR = "InUsr";

    public static final String LIVE_ADDRESS_PHONE = "LIVEADDRESS_PHONE";
    public static final String REG_ADDRESS_PHONE = "REG_ADDRESS_PHONE";
    public static final String KARD_PHONE = "KARDPHONE";

    public static final String BRANCH_CODE_DELIV = "BranchCodeDeliv";
    public static final String COURIER_TIME = "courierTime";
    public static final String WEBSITEDEV_PARAM = "websitedevParam";
    public static final String WEBSITEVALUE = "websitevalue";
    public static final String PARTNERDEV_PARAM = "partnerdevParam";
    public static final String PARTNERVALUE = "partnervalue";

    // Заявка на ДК с сайта, канал web

    public static final String AFLT_MEMBER_ID = "aflt_memberID";
    public static final String AFLT_NAME = "aflt_name";
    public static final String AFLT_SURNAME = "aflt_surname";
    public static final String WILL_TYPE = "willType";
    public static final String WILL_TYPE_ORIGINAL = "willTypeOriginal";
    public static final String SITE_TYPE_CARD = "typeCard";
    public static final String SITE_SNILS = "snils";
    public static final String SITE_MOBILE_NUMBER = "mobileNumber";
    public static final String SITE_EMAIL = "email";

    public static final String EOBPO = "eobpo";

    //Значения
    public static final String COUNTRY_CODE_VALUE = "643";
    public static final String BRANCH_UNIT_CODE_VALUE = "ОП КартаНаДом Москва";

    //Не хватает данных
    public static final String INCORRECT_DATA_ERROR = "incorrectDataError";
    public static final String INCORRECT_DATA_MESSAGE = "incorrectDataMessage";



}
