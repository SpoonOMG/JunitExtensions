package framework.qa.models.requestData;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.util.Objects;


public class ScreenValueBack {

    private  String id;

    private  String value;

    private String displayValue;

    private String extendedValue;

    public ScreenValueBack() {
    }

    public ScreenValueBack(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDisplayValue() {
        return this.displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getExtendedValue() {
        return this.extendedValue;
    }

    public void setExtendedValue(String extendedValue) {
        this.extendedValue = extendedValue;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null) {
            return false;
        } else if (!(o instanceof ScreenValueBack)) {
            return false;
        } else {
            ScreenValueBack valueBack = (ScreenValueBack)o;
            return Objects.equals(this.getId(), valueBack.getId()) && Objects.equals(this.getValue(), valueBack.getValue()) && Objects.equals(this.getDisplayValue(), valueBack.getDisplayValue()) && Objects.equals(this.getExtendedValue(), valueBack.getExtendedValue());
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.getId(), this.getValue(), this.getDisplayValue(), this.getExtendedValue()});
    }
}
