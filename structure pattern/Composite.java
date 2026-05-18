import java.util.List;

interface Employee {
    void showEmployeeDetails();
}

class Developer implements Employee {
    private String name;
    private String position;

    public Developer(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println("Developer: " + name + ", Position: " + position);
    }
}

class Manager implements Employee {
    private String name;
    private String department;

    private List<Employee> subordinates;

    public Manager(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println("Manager: " + name + ", Department: " + department);
        System.out.println("Subordinates:");
        for (Employee employee : subordinates) {
            employee.showEmployeeDetails();
        }
    }

    public void addSubordinate(Employee employee) {
        subordinates.add(employee);
    }

    public void removeSubordinate(Employee employee) {
        subordinates.remove(employee);
    }

}

public class Composite {
    public static void main(String[] args) {

        Employee developer1 = new Developer("John Doe", "Developer");
        Employee developer2 = new Developer("Jane Smith", "Developer");

        Employee manager = new Manager("Alice Johnson", "Engineering");
        ((Manager) manager).addSubordinate(developer1);
        ((Manager) manager).addSubordinate(developer2);
        manager.showEmployeeDetails();
    }
}
