package Gathering;

import org.bukkit.inventory.ItemStack;

import java.security.Key;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ItemStackManager {
    private HashMap<String,ItemStack> itemStackHashMap;
    private static volatile ItemStackManager instance;

    public ItemStackManager() {

    }

    public ItemStackManager addItem(String name, ItemStack item) {
        itemStackHashMap.put(name, item);
        return this;
    }


    public ItemStack getItem(String name) {
        for (String key : itemStackHashMap.keySet())
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
