package framework.qa.models.omniresponseitem;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ElementsItem {

    public String getMarkup() {
        return markup;
    }

    @JsonProperty("markup")
    private String markup;

    public String getHelp() {
        return help;
    }

    public Boolean getBorder() {
        return border;
    }

    @JsonProperty("border")
    private Boolean border;


    @JsonProperty("help")
    private String help;

    public String getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    private String icon;

    @JsonProperty("component")
    private String component;

    @JsonProperty("visible")
    private boolean visible;

    @JsonProperty("type")
    private String type;

    @JsonProperty("value")
    private String value;

    @JsonProperty("dependencies")
    private List<DependenciesItem> dependencies;

    @JsonProperty("serverFeature")
    private ServerFeature serverFeature;

    @JsonProperty("alias")
    private String alias;

    @JsonProperty("id")
    private String id;

    @JsonProperty("placeholder")
    private String placeholder;

    @JsonProperty("required")
    private boolean required;

    @JsonProperty("errors")
    private List<ErrorsItem> errors;

    @JsonProperty("disabled")
    private boolean disabled;

    @JsonProperty("style")
    private Style style;

    @JsonProperty("label")
    private String label;

    @JsonProperty("logInfo")
    private String logInfo;

    @JsonProperty("specific")
    private Specific specific;

    @JsonProperty("validator")
    private Validator validator;

    @JsonProperty("maxLength")
    private String maxLength;

    @JsonProperty("keyboard")
    private String keyboard;

    @JsonProperty("minLength")
    private String minLength;

    @JsonProperty("converter")
    private Converter converter;

    public String getComponent() {
        return component;
    }

    public boolean isVisible() {
        return visible;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public List<DependenciesItem> getDependencies() {
        return dependencies;
    }

    public ServerFeature getServerFeature() {
        return serverFeature;
    }

    public String getAlias() {
        return alias;
    }

    public String getId() {
        return id;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public boolean isRequired() {
        return required;
    }

    public List<ErrorsItem> getErrors() {
        return errors;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public Style getStyle() {
        return style;
    }

    public String getLabel() {
        return label;
    }

    public String getLogInfo() {
        return logInfo;
    }

    public Specific getSpecific() {
        return specific;
    }

    public Validator getValidator() {
        return validator;
    }

    public String getMaxLength() {
        return maxLength;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public String getMinLength() {
        return minLength;
    }

    public Converter getConverter() {
        return converter;
    }
}