import java.util.HashMap;
import java.util.Map;

/**
 * Created by Orion Wolf_Hubbard on 7/5/2018.
 */
public class Inventory {

    private Map<Integer, InventoryItem> inventory = new HashMap<>();

    void addItem(InventoryItem item) {
        inventory.put(item.getId(), item);
    }

    void printInventory() {
        for (int key : inventory.keySet())
            System.out.println(String.format("%s) %s", key, inventory.get(key)));
    }

    boolean removeItem(int key) {
        boolean hasKey = inventory.containsKey(key);
        if (hasKey)
            inventory.remove(key);
        return hasKey;
    }

    int getItemCount() {
        return inventory.size();
    }

}
