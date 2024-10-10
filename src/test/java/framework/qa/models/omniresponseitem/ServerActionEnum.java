package framework.qa.models.omniresponseitem;


import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

public enum ServerActionEnum {
    SIGNATURE("signature"),
    SMFT("smft"),
    DRAFT_REGISTRATION("draft-registration"),
    DRAFT_REGISTRATION_DIGITAL_SIGN("draft-registration-digital-sign"),
    DRAFT_NOTIFICATION_SMS("draft-notification-sms"),
    WILL_START("will-start"),
    WILL_FINISH("will-finish"),
    WILL_COMMUNICATION_EVENT("will-communication-event");

    private String value;

    ServerActionEnum(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

}
