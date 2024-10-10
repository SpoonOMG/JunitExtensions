package framework.qa.models.omniresponseitem;

import java.util.Objects;

public class ScreenElement {

    private String id;

    private String component;

    private String type;

    private String value;

    private String label;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof ScreenElement)) return false;
        ScreenElement that = (ScreenElement) o;
        return Objects.equals(getId(), that.getId())
                && Objects.equals(getComponent(), that.getComponent())
                && Objects.equals(getType(), that.getType())
                && Objects.equals(getValue(), that.getValue())
                && Objects.equals(getLabel(), that.getLabel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getComponent(), getType(), getValue(), getLabel());
    }
}