package framework.qa.models.requestData;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.util.Objects;

public class EmployeeDepartment {

    private String fullName;

    private String branchCode;

    private DepartmentAddress address;

    private String code;

    public EmployeeDepartment() {
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBranchCode() {
        return this.branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public DepartmentAddress getAddress() {
        return this.address;
    }

    public void setAddress(DepartmentAddress address) {
        this.address = address;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null) {
            return false;
        } else if (!(o instanceof EmployeeDepartment)) {
            return false;
        } else {
            EmployeeDepartment that = (EmployeeDepartment)o;
            return Objects.equals(this.getFullName(), that.getFullName()) && Objects.equals(this.getBranchCode(), that.getBranchCode()) && Objects.equals(this.getAddress(), that.getAddress()) && Objects.equals(this.getCode(), that.getCode());
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.getFullName(), this.getBranchCode(), this.getAddress(), this.getCode()});
    }
}
