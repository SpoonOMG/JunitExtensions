package framework.qa.models.requestData;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.io.Serializable;
import java.util.Objects;

public final class OmniRequestMeta {

    private String systemId;

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    private String moduleId;

    private String channel;

    private String sessionId;

    private String callbackUrl;

    public static OmniRequestMeta create(String systemId, String moduleId, String channel, String callbackUrl) {
        return new OmniRequestMeta(systemId, moduleId, channel, (String)null, callbackUrl);
    }

    public static OmniRequestMeta createForSystemId(String systemId, String moduleId) {
        return new OmniRequestMeta(systemId, moduleId, (String)null, (String)null, (String)null);
    }

    public static OmniRequestMeta createForChannel(String channel, String moduleId) {
        return new OmniRequestMeta((String)null, moduleId, channel, (String)null, (String)null);
    }


    public OmniRequestMeta() {
    }


    public OmniRequestMeta(String systemId, String channel, String sessionId, String callbackUrl) {
        this(systemId, (String)null, channel, sessionId, callbackUrl);
    }

    public String getSystemId() {
        return this.systemId;
    }

    public String getModuleId() {
        return this.moduleId;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getCallbackUrl() {
        return this.callbackUrl;
    }

    /** @deprecated */
    @Deprecated(
            forRemoval = true,
            since = "1.0"
    )
    public String getSessionId() {
        return this.sessionId;
    }

    public String toString() {
        return "OmniRequestMeta{systemId='" + this.systemId + "', moduleId='" + this.moduleId + "', channel='" + this.channel + "', callbackUrl='" + this.callbackUrl + "'}";
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null) {
            return false;
        } else if (!(o instanceof OmniRequestMeta)) {
            return false;
        } else {
            OmniRequestMeta that = (OmniRequestMeta)o;
            return Objects.equals(this.systemId, that.systemId) && Objects.equals(this.moduleId, that.moduleId) && Objects.equals(this.channel, that.channel) && Objects.equals(this.callbackUrl, that.callbackUrl);
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.systemId, this.moduleId, this.channel, this.callbackUrl});
    }

    private OmniRequestMeta(String systemId, String moduleId, String channel, String sessionId, String callbackUrl) {
        this.systemId = systemId;
        this.moduleId = moduleId;
        this.channel = channel;
        this.sessionId = sessionId;
        this.callbackUrl = callbackUrl;
    }
}
