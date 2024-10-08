package framework.qa.models.omniresponse;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ElementsItem{

	@JsonProperty("component")
	private String component;

	@JsonProperty("visible")
	private boolean visible;

	@JsonProperty("type")
	private String type;

	@JsonProperty("value")
	private String value;

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

	@JsonProperty("label")
	private String label;

	@JsonProperty("logInfo")
	private String logInfo;

	public String getStyle() {
		return style;
	}

	@JsonProperty("style")
	private String style;

	@JsonProperty("specific")
	private Specific specific;

	@JsonProperty("dependencies")
	private List<DependenciesItem> dependencies;

	@JsonProperty("markup")
	private String markup;

	public String getComponent(){
		return component;
	}

	public boolean isVisible(){
		return visible;
	}

	public String getType(){
		return type;
	}

	public String getValue(){
		return value;
	}

	public ServerFeature getServerFeature(){
		return serverFeature;
	}

	public String getAlias(){
		return alias;
	}

	public String getId(){
		return id;
	}

	public String getPlaceholder(){
		return placeholder;
	}

	public boolean isRequired(){
		return required;
	}

	public List<ErrorsItem> getErrors(){
		return errors;
	}

	public boolean isDisabled(){
		return disabled;
	}

	public String getLabel(){
		return label;
	}

	public String getLogInfo(){
		return logInfo;
	}

	public Specific getSpecific(){
		return specific;
	}

	public List<DependenciesItem> getDependencies(){
		return dependencies;
	}

	public String getMarkup(){
		return markup;
	}
}