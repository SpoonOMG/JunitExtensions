package framework.qa.models.omniresponseitem;

import java.util.Objects;

public class ComeBackToWill {

    private ScreenElement element;

    private String primaryOrderId;

    private String primaryScenarioId;

    public ScreenElement getElement() {
        return element;
    }

    public void setElement(ScreenElement element) {
        this.element = element;
    }

    public String getPrimaryOrderId() {
        return primaryOrderId;
    }

    public void setPrimaryOrderId(String primaryOrderId) {
        this.primaryOrderId = primaryOrderId;
    }

    public String getPrimaryScenarioId() {
        return primaryScenarioId;
    }

    public void setPrimaryScenarioId(String primaryScenarioId) {
        this.primaryScenarioId = primaryScenarioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof ComeBackToWill)) return false;
        ComeBackToWill that = (ComeBackToWill) o;
        return Objects.equals(getElement(), that.getElement())
                && Objects.equals(getPrimaryOrderId(), that.getPrimaryOrderId())
                && Objects.equals(getPrimaryScenarioId(), that.getPrimaryScenarioId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getElement(), getPrimaryOrderId(), getPrimaryScenarioId());
    }
}