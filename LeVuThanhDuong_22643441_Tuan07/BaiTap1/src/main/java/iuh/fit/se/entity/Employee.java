package iuh.fit.se.entity;

public class Employee {
    private int id;
    private String name;
    private String role;
    private  Department department;

    public Employee() {
    }

    public Employee(int id, String name, String role, Department department) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
