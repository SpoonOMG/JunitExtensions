package framework.qa.models.omniresponseitem;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

/**
 * Описание сообщения для пользавателя связанное с неверными значениями элементов на экране
 */
public class ScreenMessage {

    public List<ElementsItem> getElements() {
        return elements;
    }

    @JsonProperty("elements")
    private List<ElementsItem> elements;

    /**
     * Идентификатор элемента
     */
    private String id;

    /**
     * Разметка, которая может присутствовать в отображаемых пользователю текстах
     */
    private String markup;

    /**
     * Описание ошибки компоненты
     */
    private ScreenError error;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarkup() {
        return markup;
    }

    public void setMarkup(String markup) {
        this.markup = markup;
    }

    public ScreenError getError() {
        return error;
    }

    public void setError(ScreenError error) {
        this.error = error;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof ScreenMessage)) return false;
        ScreenMessage that = (ScreenMessage) o;
        return Objects.equals(getId(), that.getId())
                && Objects.equals(getMarkup(), that.getMarkup())
                && Objects.equals(getError(), that.getError());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMarkup(), getError());
    }
}
