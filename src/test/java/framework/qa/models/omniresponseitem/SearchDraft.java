package framework.qa.models.omniresponseitem;

import java.util.Objects;

public class SearchDraft {

    /**
     * Период времени для вычисления начала интервала поиска черновика волеизъявления сценария, в который выполняется переход.
     */
    private String takeFrom;

    /**
     * Ключ доступа к черновику
     */
    private String accessKey;

    public String getTakeFrom() {
        return takeFrom;
    }

    public void setTakeFrom(String takeFrom) {
        this.takeFrom = takeFrom;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof SearchDraft)) return false;
        SearchDraft that = (SearchDraft) o;
        return Objects.equals(getTakeFrom(), that.getTakeFrom())
                && Objects.equals(getAccessKey(), that.getAccessKey());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getTakeFrom(),
                getAccessKey());
    }
}