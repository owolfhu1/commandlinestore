import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Orion Wolf_Hubbard on 7/5/2018.
 */
public class App {

    private List<Store> stores = new ArrayList<>();

    private int getInt(Scanner scan) {
        Integer i = null;
        while (i == null) {
            if (scan.hasNextInt())
                i = scan.nextInt();
            else
                System.out.print("You must enter an integer to continue: ");
            scan.nextLine();
        }
        return i;
    }

    private String getString(Scanner scan) {
        String string = "";
        while (string.isEmpty()) {
            string = scan.nextLine();
            if (string.isEmpty())
                System.out.print("You must enter a value to continue: ");
        }
        return string;
    }

    private void close(Scanner scan) {
        scan.close();
        System.out.println("Bye! Have a good day!");
    }

    public void mainMenu(Scanner scan) {
        int selection = 0;

        System.out.print("\n---- Main Menu ----\n1) Create Store\n2) Select Store\n3) Exit\nPlease enter your selection: ");

        while (selection < 1 || selection > 3) {
            selection = getInt(scan);
            if (selection < 1 || selection > 3)
                System.out.print("You must choose 1 2 or 3: ");
        }

        switch (selection) {
            case 1 :
                createStoreMenu(scan);
                break;
            case 2 :
                selectStoreMenu(scan);
                break;
            case 3 :
                close(scan);
                break;
        }

    }

    private void createStoreMenu(Scanner scan) {
        System.out.println("\n---- Store Creator ----");
        System.out.print("Store name: ");
        String name = getString(scan);
        System.out.print("Store location: ");
        String location = getString(scan);
        System.out.print("Store description: ");
        String description = getString(scan);
        stores.add(new Store(name,description,location));
        System.out.println("Store " + name + " added! Returning to main menu.");
        mainMenu(scan);
    }

    private void selectStoreMenu(Scanner scan) {

        if(stores.size() == 0){
            System.out.println("There are no stores to select from, try creating one first.");
            mainMenu(scan);
        } else {
            System.out.print("\n---- Store Selector ----\n");
            for (int i = 0; i < stores.size(); i++)
                System.out.println(i + ") " + stores.get(i));

            System.out.print("Please enter your selection: ");

            int selection = -1;

            while (selection < 0 || selection >= stores.size()) {
                selection = getInt(scan);
                if (selection < 0 || selection >= stores.size())
                    System.out.print("You must pick between 0 and " + (stores.size() - 1) + ": ");
            }

            storeMenu(scan, selection);

        }

    }

    private void storeMenu(Scanner scan, int store) {

        System.out.println("\n---- Store Menu ----");
        System.out.println("Current store: " + stores.get(store).getName());
        System.out.println("1) Add Employee");
        System.out.println("2) Remove Employee");
        System.out.println("3) Add Inventory");
        System.out.println("4) Remove Inventory");
        System.out.println("5) Delete store");
        System.out.println("6) Main Menu");
        System.out.print("Please enter your selection: ");

        int selection = -1;
        while (selection < 1 || selection > 6) {
            selection = getInt(scan);
            if (selection < 1 || selection > 6)
                System.out.print("You must pick between 1 and 6: ");
        }

        switch (selection){
            case 1 :
                hireEmployeeMenu(scan,store);
                break;
            case 2 :
                fireEmployeeMenu(scan, store);
                break;
            case 3 :
                addItemMenu(scan, store);
                break;
            case 4 :
                removeItemMenu(scan,store);
                break;
            case 5 :
                stores.remove(store);
                System.out.println("Store removed.");
            case 6 :
                System.out.println("Returning to main menu.");
                mainMenu(scan);
                break;
        }

    }

    private void addItemMenu(Scanner scan, int store) {
        System.out.println("\n---- Add Item Menu ----");
        System.out.println("Adding item to store: " + stores.get(store).getName());
        //int price, int quantity, String name, String description
        System.out.print("Item name: ");
        String name = getString(scan);
        System.out.print("Item description: ");
        String description = getString(scan);
        System.out.print("Item price: ");
        int price = getInt(scan);
        System.out.print("Item quantity: ");
        int quantity = getInt(scan);
        stores.get(store).addInventory(new InventoryItem(price, quantity, name, description));
        System.out.println("Item " + name + " has been added to inventory!");
        System.out.println("Returning to store menu.");
        storeMenu(scan, store);
    }

    private void removeItemMenu(Scanner scan, int store) {
        if (stores.get(store).getItemCount() == 0) {
            System.out.println("There are no Items to remove, returning to store menu.");
            storeMenu(scan, store);
        } else {
            System.out.println("\n---- Remove Item Menu ----");
            System.out.println("Inventory for store: " + stores.get(store).getName());
            stores.get(store).viewInventory();
            System.out.print("Please select item to remove: ");
            int selection = getInt(scan);
            if (stores.get(store).removeItem(selection))
                System.out.println("Congratulations you have removed an item! Returning to store menu.");
            else
                System.out.println("Error, item not found, returning to store menu.");
            storeMenu(scan,store);
        }
    }

    private void hireEmployeeMenu(Scanner scan, int store) {
        System.out.println("/n---- Hire Employee Menu ----");
        System.out.println("Hiring for store: " + stores.get(store).getName());
        System.out.print("Employee first name: ");
        String firstName = getString(scan);
        System.out.print("Employee last name: ");
        String lastName = getString(scan);
        System.out.print("Employee position: ");
        String position = getString(scan);
        System.out.print("Employee salary: ");
        int salary = getInt(scan);
        stores.get(store).addEmployee(new Employee(salary, firstName, lastName, position));
        System.out.println("Employee " + firstName + " " + lastName + " is hired!");
        System.out.println("Returning to store menu.");
        storeMenu(scan, store);
    }

    private void fireEmployeeMenu(Scanner scan, int store) {
        if (stores.get(store).getEmployeeCount() == 0) {
            System.out.println("There are no Employees to fire, returning to store menu.");
            storeMenu(scan, store);
        } else {
            System.out.println("\n---- Fire Employee Menu ----");
            System.out.println("Employees for store: " + stores.get(store).getName());
            stores.get(store).viewEmployees();
            System.out.print("Please select employee to fire: ");
            int selection = getInt(scan);
            if (stores.get(store).fireEmployee(selection))
                System.out.println("Congratulations you have fired the employee! Returning to store menu.");
            else
                System.out.println("Error, employee not found, returning to store menu.");
            storeMenu(scan,store);
        }
    }

}
