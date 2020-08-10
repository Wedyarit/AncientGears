package Recipes;

import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class BlastFurnaceRecipe {
    private HashMap<ItemStack, Integer> itemStackHashMap = new HashMap<>();
    private final ItemStack result;
    private final double time;

    public BlastFurnaceRecipe(HashMap<ItemStack, Integer> itemStackHashMap, ItemStack result, double time) {
        this.itemStackHashMap = itemStackHashMap;
        this.result = result;
        this.time = time;
    }

    public HashMap<ItemStack, Integer> getCraftItems() {
        return itemStackHashMap;
    }

    public ItemStack getResultItem() {
        return result;
    }

    public double getTime() {
        return time;
    }
}
