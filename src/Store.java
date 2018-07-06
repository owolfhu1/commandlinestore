/**
 * Created by Orion Wolf_Hubbard on 7/5/2018.
 */
public class Store {

    private Inventory inventory;
    private Employees employees;
    private String name;
    private String description;
    private String location;

    Store(String name, String description, String location) {
        inventory = new Inventory();
        employees = new Employees();
        this.name = name;
        this.description = description;
        this.location = location;
    }

    @Override
    public String toString() {
        return String.format("%s\n%s\n%s\n%s employees\n%s items in stock\n",
                name, location, description, employees.getEmployeeCount(), inventory.getItemCount());
    }

    void addEmployee(Employee employee) {
        employees.addEmployee(employee);
    }

    void addInventory(InventoryItem item) {
        inventory.addItem(item);
    }

    boolean fireEmployee(int id) {
        return employees.removeEmployee(id);
    }

    boolean removeItem(int id) {
        return inventory.removeItem(id);
    }

    void viewEmployees() {
        employees.printEmployees();
    }

    void viewInventory() {
        inventory.printInventory();
    }

    String getName() {
        return name;
    }

    int getEmployeeCount() {
        return employees.getEmployeeCount();
    }

    int getItemCount() {
        return inventory.getItemCount();
    }

}
