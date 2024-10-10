package framework.qa.consts;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Наименования полей, передаваемых на UI
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UiFieldsNames {

    public static final String SCENARIO_ID = "##scenarioId";

    public static final String UI_CARDS_LOYALTY_PROGRAM = "##cardsLoyaltyProgram";

    public static final String UI_LOCATION = "##location";

    public static final String UI_FIAS_CODE = "##fiasCode";

    public static final String UI_DELIVERY_COURIER = "##delivery.courier";
    public static final String UI_DELIVERY_OFFICE = "##delivery.office";

    public static final String UI_LOCATION_BASE64 = "##locationBase64";

    public static final String UI_FULL_NAME = "##full_name";

    public static final String UI_LAST_NAME = "##lastName";

    public static final String UI_FIRST_NAME = "##firstName";

    public static final String UI_SECOND_NAME = "##secondName";

    public static final String UI_BIRTH_DATE = "##birth_date";

    public static final String UI_DOCUMENT = "##document";

    public static final String UI_REGISTRATION_ADDRESS = "##registration_address";

    public static final String UI_FACT_ADDRESS = "##fact_address";

    public static final String UI_CELLPHONE = "##CELLPHONE";

    public static final String UI_CLIENT_PHONE = "##clientPhone";

    public static final String UI_PHONE_NUMBER_SVFE_OPERATION = "##phoneNumberSvfeOperation";

    public static final String UI_MTE_CLIENT_PHONE = "##MTEClientPhone";

    public static final String UI_CLIENT_PHONE_OTP = "##clientPhoneOTP";

    public static final String UI_PHONE_NUMBER_SMS_PUSH = "##phoneNumberSmsPush";

    public static final String UI_EMBOSSING_CLIENT_NAME = "##embossing_client_name";

    public static final String UI_EMAIL = "##email";

    public static final String UI_CODEWORD = "##codeword";

    public static final String UI_IS_TEENAGER = "##isTeenager";

    public static final String UI_REQUEST_ID = "##requestId";

    public static final String UI_SECRET_WORD = "##isSecretWord";

    public static final String UI_DATE_EXPIRATION = "##dateExpiration";

    public static final String UI_SNILS = "##snils";

    public static final String UI_KIND_GET = "##kind_get";

    public static final String UI_KIND_GET_ENRICHED = "##kind_get_enriched";

    public static final String UI_DELIVERY_DSA = "##delivery.dsa";

    public static final String UI_DASHBOARD_BRANCH_UNIT_CODE = "##dashboardBranchUnitCode";

    public static final String UI_DASHBOARD_BRANCH_CODE = "##dashboardBranchCode";

    public static final String UI_DELIVERY_ADDRESS = "##delivery_address";

    public static final String UI_BRANCH_SYSTEM_EXECUTE = "##branchSystemExecute";

    public static final String UI_IS_OTP = "##isOTP";
    public static final String UI_TYPE_SIGN = "##TypeSign";


    public static final String UI_IS_OTP_AVAILABLE = "##isOTPAvailable";

    public static final String UI_OTP_CHANNELS_AVAILABLE = "##OTPAvailableChannels";

    public static final String UI_OTP_CHANNEL = "##OTPChannel";

    public static final String UI_SIGN_MODE = "##signMode";

    //Согласие на обработку персональных данных
    public static final String UI_CLIENT_CONSENTS = "##consent_all";
    public static final String UI_CLIENT_CONSENT_PERS_DATA_ADV = "##consentPersDataAdv";
    public static final String UI_CLIENT_CONSENT_RU_TAX_RESIDENT = "##consentRuTaxResident";
    public static final String UI_ACCEPT_MASK_NUMBER = "##accept_maskNum";

    public static final String UI_EXPIRED_PASSPORT = "##expiredPassport";

    //Логистический модуль
    public static final String LOGISCTICS_ADDRESS = "##dadata.address";
    public static final String INTERVALS_LOGISTICS = "intervals.logistics";



    //SECURE
    public static final String UI_PAN = "pan";

    public static final String UI_VIRTUAL_NUM = "virtualNum";

    public static final String UI_3D_SECURE = "##is3DSecureEnabled";

    public static final String UI_CARD_STATE = "##cardState";

    public static final String UI_SVS_STATE_CARD = "##svsStateCode";

    public static final String UI_STATE_REASON = "##stateReason";


    //GEO-RESTRICTIONS

    public static final String UI_SELECTED_REGION = "##selectedRegion";

    // Канал информирования SMS, PUSH
    public static final String UI_TEL_INFO = "##telInfo";

    public static final String UI_DATE_INFO = "##dateInfo";

    public static final String UI_CLIENT_TYPE = "clientType";

    public static final String UI_INFO_TYPE_TECH = "##InfoTypeTech";

    public static final String UI_YOUNGER_THEN_PREPENSION = "##isYoungerThenPrepension";

    public static final String UI_CURRENCY_DEFAULT_VALUE = "##currencyDefaultValue";

    public static final String UI_ACCEPTED_TIME = "##acceptedTime";

    public static final String UI_CHECK_PRINT_BUTTON_ID = "checkPrint";

    public static final String UI_CHECK_LOCATION_BUTTON_ID = "checkLocation";

    public static final String UI_CHECK_CARD_PARAM_BUTTON_ID = "checkCardParam";

    public static final String UI_CARD_NUMBER_FIELD_ID = "CardNumber";

    public static final String UI_CURRENCY = "##currencyId";

    public static final String UI_PAYMENT_SYSTEM_CODE_PLASTIC = "##paymentSystemCodePlastic";

    public static final String UI_PAYMENT_SYSTEM_CODE_DIGITAL = "##paymentSystemCodeDigital";

    public static final String UI_SUB_PROGRAM_CODE_VISA = "##subProgramCodeVisa";

    public static final String UI_PRINT_CARD_NAME = "##printCardName";

    public static final String ORDER_OWNER = "##orderOwner";

    public static final String SALE_CHANNEL_NAME = "##saleChannelName";

    public static final String TYPE_SIGN = "TypeSign";

    public static final String CARD_ID_PRODUCT_NAME = "##cardIdProductName";
    public static final String CARD_ID_CATEGORY_NAME = "##cardIdCategoryName";
    public static final String CARD_ID_PRODUCT_NAME_FOR_PRINT_SCREEN = "##cardIdProductNameForPrintScreen";

    public static final String VIRTUAL_NUM = "##virtualNum";

    public static final String IS_SALARY = "##isSalary";
    public static final String TESSA_META_ECM_AGR_ACCOUNTS_NUMBER = "##tessaMetaEcmAgrAccountsNumber";

    // Выпуск доп карт
    public static final String MAIN_BALANCE = "##mainBalance";

    public static final String MAIN_ACCOUNT = "##mainAccount";

    public static final String MAIN_CARD_PAN = "##mainCardPan";

    public static final String VIRT_NUM_CARD_MAIN = "##virtNumCardMain";

    public static final String CARD_FOR_MAIN_CARD_OWNER = "##cardForMainCardOwner";

    public static final String PROMO_CARD_CODE = "##promoCardCode";

    public static final String COMMISSION_VALUE = "##commissionValue";

    public static final String CLIENT_COMMISSION_INFO = "##clientCommissionInfo";

    public static final String COMMISSION_FUND = "##commissionFund";

    public static final String PROROGUE = "##prorogue";

    public static final String APPLICATION_DATE_TIME = "##applicationDateTime";

    public static final String APPLICATION_DATE_TIME_SCREEN = "##applicationDateTimeScreen";

    public static final String DISPLAY_BRANCH_UNIT_CODE = "##displayBranchUnitCode";

    public static final String INHERITED_LOYALTY_NAME = "##inheritedLoyaltyName";

    public static final String INHERITED_LOYALTY_NOTE = "##inheritedLoyaltyNote";

    public static final String SEQUENCE = "##sequence";

    public static final String PARENT_SUB_PROGRAM_ID = "##parentSubProgramId";

    public static final String SUB_PROGRAM_CODE_CL_ZP_MIR = "##subProgramCodeClZpMir";

    public static final String MAIN_CONTRACT_NUMBER = "##mainContractNumber";

    public static final String MAIN_CONTRACT_CREATION_DATE = "##mainContractCreationDate";

    public static final String IS_STICKER = "##isSticker";

    public static final String MAIN_SERVICE_PACKAGE_ID = "##mainServicePackageId";

    public static final String IS_ADD_BRANCH_EQUAL_TO_MAIN_BRANCH = "##isAddBranchEqualToMainBranch";

    public static final String UI_SOURCE_CHANNEL = "##sourceChannel";

    public static final String SYSTEM_ID_FOR_ANTI_FRAUD = "##systemIdForAntiFraud";

    public static final String IS_CREDIT_BUREAU_ACTUAL_CONSENT = "##isCreditBureauActualConsent";

    public static final String CREDIT_BUREAU_CONSENT_START_DATE = "##creditBureauConsentStartDate";

    public static final String IS_CREDIT_BUREAU_CONSENT_FRESH = "##isCreditBureauConsentFresh";

    public static final String IS_OSW_CREDIT_CARD_ANSWER_SUCCESS = "##isOswCreditCardAnswerSuccess";

    public static final String UI_GPB_BONUS_PROMO_AVAILABLE = "##GPBBonusPromoAvailable";
    public static final String UI_GPB_BONUS_STATIC_TEXT = "##GPBBonusStaticText1";
    public static final String UI_GPB_BONUS_TARIFF_LINK = "##GPBBonusTariffLink";

    public static final String ARE_EMBOSSED_CARDS_AVAILABLE = "##areEmbossedCardsAvailable";
    public static final String ARE_INSTANT_CARDS_AVAILABLE = "##areInstantCardsAvailable";
    public static final String DEPOSIT_PRODUCT_AVAILABLE = "##depositProductAvailable";

    public static final String DEPOSIT_NAME = "##depositName";
    public static final String DEPOSIT_CONTRACT_NUMBER = "##depositContractNumber";
    public static final String DEPOSIT_RATE = "##depositRate";
    public static final String DEPOSIT_BRANCH_CODE = "##depositBranchCode";
    public static final String DEPOSIT_ACC_NUMBER = "##depositAccNumber";
    public static final String DEPOSIT_CREATION_DATE = "##depositCreationDate";
    public static final String DEPOSIT_PRODUCT_CODE = "##depositProductCode";
    public static final String DEPOSIT_REQ_SYSTEM_ID = "##depositReqSystemId";
    public static final String LOCATION_LIST_INSTANCE_5NT = "##instance5nt";
    public static final String LOCATION_LIST_BRANCH_5NT = "##branch5nt";
    public static final String IS_DEPOSIT_ERROR = "##isDepositError";


    //Поля omni-oks-credit-cards
    public static final String GO_TO_CREDIT_CARD_ORDERS_URL = "##goToCreditCardOrdersUrl";
    public static final String CC_PROCESS_SUB_TYPE_ID = "##ccProcessSubTypeId";
    public static final String GO_TO_CREDIT_CARD_ORDERS = "##goToCreditCardOrders";


    public static class Print {
        private Print() {
            throw new IllegalStateException("Utility class");
        }

        public static final String UI_APPLICATION_DATE = "##applicationDate";
        public static final String UI_CARD_CATEGORY = "##cardCategory";
        public static final String UI_LOYALTY_PROGRAM = "##loyaltyProgram";
        public static final String UI_CARD_CURRENCY = "##cardCurrency";
        public static final String UI_ORGANISATION = "##organisation";
        public static final String UI_SERVICE_PACKAGE = "##servicePackage";
        public static final String UI_DEPARTMENT_CODE = "##departmentCode";
        public static final String UI_EMPLOYEE_FULL_NAME = "##employeeFullName";
        public static final String UI_EMPLOYEE_POSITION = "##employeePosition";
        public static final String UI_IS_TRANSFER_AGREED = "##isTransferAgreed";
        public static final String UI_IS_INSTANT = "##isInstant";
        public static final String UI_CARD_PAN = "##cardPan";
        public static final String UI_ACCEPT_MASK_CARD_NUM = "##accept_maskNum";
        public static final String UI_IS_NEW_CARD = "##isNewCard";

        public static final String UI_IS_MOBILE_PIN = "##isMobilePin";
        public static final String UI_VALID_YEARS = "##validYears";
        public static final String UI_IS_SALARY = "##isSalary";
        public static final String UI_PRINT_ACC_NUMBER = "##print_accNumber";
        public static final String UI_IS_PACKAGE = "##isPackage";
        public static final String UI_CARD_SCENARIO = "##cardScenario";
        public static final String UI_PAY_SYSTEM = "##paySystemCode";
        public static final String UI_CODE_WORD_PRINT = "##codewordPrint";
        public static final String UI_IS_CARD_ACCOUNT_RESERVED = "##isCardAccountReserved";
        public static final String UI_PAY_SYSTEM_CODE = "##paySystemCode";
        public static final String UI_SYSTEM_ID = "##systemId";
        public static final String UI_TESSA_CLIENT_ROLE_CODE = "##tessaClientRoleCode";  // Код роли клиента
        public static final String UI_TESSA_CLIENT_ROLE_NAME = "##tessaClientRoleName";  // Наименование роли клиента
        public static final String UI_TESSA_DOC_IS_ERROR = "##tessaDocIsError";  // Признак наличия ошибки
        public static final String UI_TESSA_DOC_IS_UPDATE = "##tessaDocIsUpdate";  // Признак необходимости обновления карточки документа в Тесса
        public static final String UI_TESSA_META_ECM_AGR_NUMBER = "##tessaMetaEcmAgrNumber";  // Номер договора
        public static final String UI_TESSA_META_ECM_AGR_CREATION_DATE = "##tessaMetaEcmAgrCreationDate";  // Дата открытия договора
        public static final String UI_TESSA_META_ECM_BATCH_IS_UPDATE = "##tessaMetaEcmBatchIsUpdate";
        public static final String UI_TESSA_META_ECM_BATCH_STATE_CODE = "##tessaMetaEcmBatchStateCode";  // Идентификатор статуса пакета документа
        public static final String UI_TESSA_META_ECM_BATCH_STATE_NAME = "##tessaMetaEcmBatchStateName";  // Наименование статуса пакета документа
        public static final String UI_TESSA_META_ECM_BATCH_TYPE_CODE = "##tessaMetaEcmBatchTypeCode";  // Идентификатор типа пакета документа
        public static final String UI_TESSA_META_ECM_BATCH_TYPE_NAME = "##tessaMetaEcmBatchTypeName";  // Наименование типа пакета документа
        public static final String UI_TESSA_META_ECM_BID_CHANNEL_CODE = "##tessaMetaEcmBidChannelCode";  // Код канала поступления
        public static final String UI_TESSA_META_ECM_BID_CHANNEL_NAME = "##tessaMetaEcmBidChannelName";  // Наименование канала поступления
        public static final String UI_TESSA_META_ECM_BID_EXT_ID = "##tessaMetaEcmBidExtId";  // Идентификатор заявки в АБС
        public static final String UI_TESSA_META_ECM_BID_PRODUCT_NAME = "##tessaMetaEcmBidProductName";  // Наименование продукта (операции)
        public static final String UI_TESSA_META_ECM_BID_SYSTEM_INFO_RAW_ID = "##tessaMetaEcmBidSystemInfoRawId"; // Идентификатор заявки в системе, где она ведется
        public static final String UI_TESSA_META_ECM_TYPE_DOC_CODE = "##tessaMetaEcmTypeDocCode";  // Идентификатор типа документа в Тесса
        public static final String UI_TESSA_META_ECM_TYPE_DOC_NAME = "##tessaMetaEcmTypeDocName";  // Название типа документа в Тесса
        public static final String UI_TESSA_DOC_STATE_CODE = "##tessaDocStateCode";  // Идентификатор статуса документа в Тесса
        public static final String UI_TESSA_DOC_STATE_NAME = "##tessaDocStateName";  // Наименование статуса документа в Тесса
        public static final String UI_PRODUCT_RESTRICTION_PAYMENT = "##ProductRestrictionPayment"; // Поле управляет отображением продуктов на экране


        public static final String APPLICATION_DATE = "##print_applicationDate";
        public static final String CARD_PRODUCT_CODE = "##print_cardProductCode";
        public static final String LOYALTY_PROGRAM_NAME = "##print_loyaltyProgramName";
        public static final String ACCOUNT_CURRENCY = "##print_accountCurrency";
        public static final String COMPANY_ADDRESS = "##print_companyAddress";

        //В перспективе при переходе на префикс ##print_ для параметров ПФ параметры без префикса удалятся
        public static final String PRINT_ORGANIZATION_NAME = "##print_organizationName";
        public static final String ORGANIZATION_NAME = "##organizationName";
        public static final String PRINT_OBPO = "##print_obpo";
        public static final String OBPO = "##obpo";
        public static final String SERVICE_PACKAGE = "##print_packageName";
        public static final String DEPARTMENT_CODE = "##print_departmentCode";
        public static final String EMPLOYEE_FULL_NAME = "##print_employeeFullName";
        public static final String EMPLOYEE_POSITION = "##print_employeePosition";
        public static final String IS_INSTANT = "##print_isInstant";
        public static final String MASK_CARD_NUM = "##print_maskCardNum";
        public static final String LATIN_CLIENT_NAME = "##print_latinClientName";
        public static final String SECRET_WORD = "##print_secretWord";
        public static final String IS_PACKAGE = "##print_isPackage";
        public static final String IS_SALARY = "##print_isSalary";
        public static final String PAY_SYSTEM_CODE = "##print_paySystemCode";
        public static final String TYPE_SIGN = "##print_TypeSign";
        public static final String IS_MOBILE_PIN = "##print_isMobilePin";
        public static final String PHONE_FULL_NUMBER = "##print_phoneFullNumber";

        public static final String KIND_GET = "##print_kind_get";
        public static final String IS_CARD_ACCOUNT_RESERVED = "##print_isCardAccountReserved";
        public static final String CARD_SCENARIO = "##print_cardScenario";
        public static final String RECEPTION_SITE_CODE = "##print_receptionSiteCode";
        public static final String BRANCH_CODE = "##print_branchCode";
        public static final String ORDER_4_CLIENT = "##print_order4client";
        public static final String LOGIN = "##print_login";
        public static final String DADATA_ADDRESS = "##print_dadataAddress";
        public static final String PRIVILEGE_CARD_CODE = "##print_privilegCardCode";
        public static final String SOURCE_CHANNEL = "##print_sourceChannel";
    }
}
