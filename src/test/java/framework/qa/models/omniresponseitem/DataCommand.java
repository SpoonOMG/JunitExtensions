package framework.qa.models.omniresponseitem;

import java.util.Objects;

public class DataCommand {

    /**
     * Контейнер, описывающий серверную информацию для команды, связанной с действием, у которого type == redirect.
     */
    private Redirect redirect;

    public Redirect getRedirect() {
        return redirect;
    }

    public void setRedirect(Redirect redirect) {
        this.redirect = redirect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof DataCommand)) return false;
        DataCommand that = (DataCommand) o;
        return Objects.equals(getRedirect(), that.getRedirect());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRedirect());
    }
}