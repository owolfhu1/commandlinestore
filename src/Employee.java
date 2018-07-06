/**
 * Created by Orion Wolf_Hubbard on 7/5/2018.
 */
public class Employee {

    private static int employeeCount = 0;
    private int id, salary;
    private String firstName, lastName, position;

    Employee(int salary, String firstName, String lastName, String position) {
        id = ++employeeCount;
        this.salary = salary;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }

    @Override
    public String toString() {
        return String.format("%s %s: %s - $%s.00", firstName, lastName, position, salary);
    }

    int getId() {
        return id;
    }
}
