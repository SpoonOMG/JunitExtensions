package framework.qa.models.requestData;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Scenario {

    public Scenario(String id, String code, String systemExecute) {
        this.id = id;
        this.code = code;
        this.systemExecute = systemExecute;
    }

    public Scenario() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getKindCode() {
        return kindCode;
    }

    public void setKindCode(String kindCode) {
        this.kindCode = kindCode;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getSystemProvider() {
        return systemProvider;
    }

    public void setSystemProvider(String systemProvider) {
        this.systemProvider = systemProvider;
    }

    public String getSystemInit() {
        return systemInit;
    }

    public void setSystemInit(String systemInit) {
        this.systemInit = systemInit;
    }

    public String getSystemCheck() {
        return systemCheck;
    }

    public void setSystemCheck(String systemCheck) {
        this.systemCheck = systemCheck;
    }

    public String getSystemExecute() {
        return systemExecute;
    }

    public void setSystemExecute(String systemExecute) {
        this.systemExecute = systemExecute;
    }

    private String id;

    private String categoryCode;

    private String categoryName;

    private String kindCode;

    private String kindName;

    private String typeCode;

    private String code;

    private String name;

    private Boolean active;

    private String systemProvider;

    private String systemInit;

    private String systemCheck;

    private String systemExecute;

    public Scenario(String id, String categoryCode, String categoryName, String kindCode, String kindName, String typeCode, String code, String name, Boolean active, String systemProvider, String systemInit, String systemCheck, String systemExecute) {
        this.id = id;
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.kindCode = kindCode;
        this.kindName = kindName;
        this.typeCode = typeCode;
        this.code = code;
        this.name = name;
        this.active = active;
        this.systemProvider = systemProvider;
        this.systemInit = systemInit;
        this.systemCheck = systemCheck;
        this.systemExecute = systemExecute;
    }
}
