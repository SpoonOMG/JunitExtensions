package framework.qa.models.omniresponseitem;

import java.util.Objects;

public class Redirect {

    /**
     * Идентификатор сценария, в который необходимо перейти
     */
    private String scenarioId;

    /**
     * Тип перенаправления. Доступные типы:
     * - basic - базовый и самый простой тип перехода в новый сценарий. Указанный тип перехода рекомендуется использовать на финальных экранах, так как он не предполагает возврат в текущий сценарий. Пример - это "перевод", на финальном экране которого предлагается "сохранить шаблон".
     * - interrupt - сложный тип перехода в новый сценарий. Применяется, если требуется прервать текущий сценарий и запустить новый с последующим возвратом в текущий.
     */
    private String type;

    /**
     * Контейнер, описывающий информацию для возврата в прерванный сценарий. Указывается для тех типов type, которые предполагают возврат в текущий сценарий.
     * В данном случае должен содержать только element.
     */
    private ComeBackToWill comeback;

    /**
     * Имя кофигурационного файла с настройками, позволяющими сформировать объект для вызова нового сценария.
     * Содержимое файла представляет собой абстракцию RedirectWithSelected.
     */
    private String configSelected;

    /**
     * Правила поиска черновика ВИ сценария, в который выполняется переход.
     */
    private SearchDraft searchDraft;

    public String getScenarioId() {
        return scenarioId;
    }

    public void setScenarioId(String scenarioId) {
        this.scenarioId = scenarioId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ComeBackToWill getComeback() {
        return comeback;
    }

    public void setComeback(ComeBackToWill comeback) {
        this.comeback = comeback;
    }

    public String getConfigSelected() {
        return configSelected;
    }

    public void setConfigSelected(String configSelected) {
        this.configSelected = configSelected;
    }

    public SearchDraft getSearchDraft() {
        return searchDraft;
    }

    public void setSearchDraft(SearchDraft searchDraft) {
        this.searchDraft = searchDraft;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Redirect)) return false;
        Redirect redirect = (Redirect) o;
        return Objects.equals(getScenarioId(), redirect.getScenarioId())
                && Objects.equals(getType(), redirect.getType())
                && Objects.equals(getComeback(), redirect.getComeback())
                && Objects.equals(getConfigSelected(), redirect.getConfigSelected())
                && Objects.equals(getSearchDraft(), redirect.getSearchDraft());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getScenarioId(), getType(), getComeback(), getConfigSelected(), getSearchDraft());
    }
}