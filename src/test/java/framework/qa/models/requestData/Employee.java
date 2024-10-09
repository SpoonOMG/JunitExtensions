package framework.qa.models.requestData;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.util.Objects;

public class Employee {

    private String fullName;

    private String position;

    public Employee(EmployeeDepartment department) {
        this.department = department;
    }

    private EmployeeDepartment department;

    private String login;

    public Employee() {
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public EmployeeDepartment getDepartment() {
        return this.department;
    }

    public void setDepartment(EmployeeDepartment department) {
        this.department = department;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null) {
            return false;
        } else if (!(o instanceof Employee)) {
            return false;
        } else {
            Employee employee = (Employee)o;
            return Objects.equals(this.getFullName(), employee.getFullName()) && Objects.equals(this.getPosition(), employee.getPosition()) && Objects.equals(this.getDepartment(), employee.getDepartment()) && Objects.equals(this.getLogin(), employee.getLogin());
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.getFullName(), this.getPosition(), this.getDepartment(), this.getLogin()});
    }
}
