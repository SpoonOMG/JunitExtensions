package framework.qa.models.requestData;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.util.Objects;

public class DepartmentAddress {

    private String city;

    private String fullAddress;

    public DepartmentAddress() {
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFullAddress() {
        return this.fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null) {
            return false;
        } else if (!(o instanceof DepartmentAddress)) {
            return false;
        } else {
            DepartmentAddress that = (DepartmentAddress)o;
            return Objects.equals(this.getCity(), that.getCity()) && Objects.equals(this.getFullAddress(), that.getFullAddress());
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.getCity(), this.getFullAddress()});
    }
}
