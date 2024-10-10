package framework.qa.models.omniresponseitem;

import java.util.Objects;

/**
 * Описание ошибки компоненты
 */
public class ScreenError {


    private String type;


    private String severity;


    private String message;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof ScreenError)) return false;
        ScreenError that = (ScreenError) o;
        return Objects.equals(getType(), that.getType())
                && Objects.equals(getSeverity(), that.getSeverity())
                && Objects.equals(getMessage(), that.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getSeverity(), getMessage());
    }
}