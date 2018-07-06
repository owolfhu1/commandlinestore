import java.util.HashMap;
import java.util.Map;

/**
 * Created by Orion Wolf_Hubbard on 7/5/2018.
 */
public class Inventory {

    private Map<Integer, InventoryItem> inventory = new HashMap<>();

    public void addItem(InventoryItem item) {
        inventory.put(item.getId(), item);
    }

    public void printInventory() {
        for (int key : inventory.keySet())
            System.out.println(String.format("%s) %s", key, inventory.get(key)));
    }

    public boolean removeItem(int key) {
        boolean hasKey = inventory.containsKey(key);
        if (hasKey)
            inventory.remove(key);
        return hasKey;
    }

    public int getItemCount() {
        return inventory.size();
    }

}
