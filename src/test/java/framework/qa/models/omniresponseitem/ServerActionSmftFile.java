package framework.qa.models.omniresponseitem;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

public enum ServerActionSmftFile {
    /**
     *  Smft action. Заявка на ДК
     */
    NEW_DEBIT_CARD("omni-oks-cards_new_debit_card"),

    /**
     * Smft action. Заявка на виртуальную ДК
     */
    NEW_DEBIT_VIRT_CARD("omni-oks-cards_new_debit_virt_card"),

    /**
     * Smft action. Сервис управления геоограничениями ДК
     */
    GEO_SET("omni-oks-cards_geo_set"),

    /**
     * Smft action. Сервис управления ограничениями на проведения интернет-операций (3DSecure)
     */
    OMNI_OKS_CARDS_3DSEC("omni-oks-cards_omni-oks-cards_3dsec"),

    /**
     * Smft action. Сервис управления услугой информирования
     */
    INFO_NOTIFICATION_ENABLE_PUSH("omni-oks-cards_info_NOTIFICATION_ENABLE_PUSH"),

    /**
     * Smft action. Сервис управления услугой информирования
     */
    INFO_NOTIFICATION_DISABLE_PUSH("omni-oks-cards_info_NOTIFICATION_DISABLE"),

    /**
     * Smft action. Управление лимитами по карте
     */
    LIMIT("omni-oks-cards_limit");

    private String value;

    ServerActionSmftFile(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
