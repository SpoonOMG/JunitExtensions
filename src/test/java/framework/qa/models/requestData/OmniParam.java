package framework.qa.models.requestData;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Objects;


public class OmniParam implements Serializable {
    private final String key;
    private final String value;
    private final String type;

    @JsonCreator
    public OmniParam(@JsonProperty("key") String key, @JsonProperty("value")  String value, @JsonProperty("type") String type) {
        this.key = key;
        this.value = value;
        this.type = type;
    }

    public OmniParam( String key,  String value) {
        this(key, value, (String)null);
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        return "OmniParameter{key='" + this.key + "', value='" + this.value + "', type='" + this.type + "'}";
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null) {
            return false;
        } else if (!(o instanceof OmniParam)) {
            return false;
        } else {
            OmniParam param = (OmniParam)o;
            return Objects.equals(this.getKey(), param.getKey()) && Objects.equals(this.getValue(), param.getValue()) && Objects.equals(this.getType(), param.getType());
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.getKey(), this.getValue(), this.getType()});
    }
}
