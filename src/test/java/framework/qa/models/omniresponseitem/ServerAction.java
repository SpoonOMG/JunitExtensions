package framework.qa.models.omniresponseitem;

import java.util.List;

public class ServerAction {
    private ServerActionEnum action;
    private Criticality criticality;
    private StartPoint startPoint = StartPoint.getDefault();
    private List<String> parents;
    private List<ServerActionParameter> parameters;
    private ServerActionConfiguration configuration;

    public ServerActionEnum getAction() {
        return action;
    }

    public Criticality getCriticality() {
        return criticality;
    }

    public StartPoint getStartPoint() {
        return startPoint;
    }

    public List<String> getParents() {
        return parents;
    }

    public List<ServerActionParameter> getParameters() {
        return parameters;
    }

    public ServerActionConfiguration getConfiguration() {
        return configuration;
    }
}
