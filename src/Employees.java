import java.util.HashMap;
import java.util.Map;

/**
 * Created by Orion Wolf_Hubbard on 7/5/2018.
 */
public class Employees {

    private Map<Integer, Employee> employees = new HashMap<>();

    void addEmployee(Employee employee) {
        employees.put(employee.getId(), employee);
    }

    void printEmployees() {
        for (int key : employees.keySet())
            System.out.println(String.format("%s) %s", key, employees.get(key)));
    }

    boolean removeEmployee(int key) {
        boolean hasKey = employees.containsKey(key);
        if (hasKey)
            employees.remove(key);
        return hasKey;
    }

    int getEmployeeCount() {
        return employees.size();
    }

}
