package Gather;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemStackManager {
    private final HashMap<GatherEnum, ItemStack> itemStackHashMap = new HashMap<>();
    private static volatile ItemStackManager instance;

    public ItemStackManager() {

    }

    public void addItem(String name, ItemStack item) {
        itemStackHashMap.put(name, item);
    }


    public ItemStack getItem(GatherEnum name) {
        for (GatherEnum key : itemStackHashMap.keySet())
            if (key.equals(name)) return itemStackHashMap.get(key);
            return null;
    }

    public static ItemStackManager getInstance() {
        ItemStackManager localInstance = instance;
        if (localInstance == null) {
            synchronized (ItemStackManager.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ItemStackManager();
                }
            }
        }
        return localInstance;
    }

    public ArrayList<ItemStack> getAllItems() {
        ArrayList<ItemStack> itemStacks = new ArrayList<>();
        for (String key : itemStackHashMap.keySet())
            itemStacks.add(itemStackHashMap.get(key));
        return itemStacks;
    }

}
