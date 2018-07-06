/**
 * Created by Orion Wolf_Hubbard on 7/5/2018.
 */
public class Store {

    private Inventory inventory;
    private Employees employees;
    private String name;
    private String description;
    private String location;

    public Store(String name, String description, String location) {
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

    public void addEmployee(Employee employee) {
        employees.addEmployee(employee);
    }

    public void addInventory(InventoryItem item) {
        inventory.addItem(item);
    }

    public boolean fireEmployee(int id) {
        return employees.removeEmployee(id);
    }

    public boolean removeItem(int id) {
        return inventory.removeItem(id);
    }

    public void viewEmployees() {
        employees.printEmployees();
    }

    public void viewInventory() {
        inventory.printInventory();
    }

    public String getName() {
        return name;
    }

    public int getEmployeeCount() {
        return employees.getEmployeeCount();
    }

    public int getItemCount() {
        return inventory.getItemCount();
    }

}
