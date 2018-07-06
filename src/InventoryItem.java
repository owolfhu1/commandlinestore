/**
 * Created by Orion Wolf_Hubbard on 7/5/2018.
 */
public class InventoryItem {

    private static int itemCount = 0;
    private int id, price, quantity;
    private String name, description;

    InventoryItem(int price, int quantity, String name, String description) {
        id = ++itemCount;
        this.price = price;
        this.quantity = quantity;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%s: %s\n$%s.00 %s in stock", name, description, price, quantity);
    }

    int getId() {
        return id;
    }
}
