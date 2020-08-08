package Recipes;

import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class BlastFurnaceRecipe {
    private HashMap<Integer, ItemStack> integerItemStackHashMap = new HashMap<>();
    private final ItemStack result;
    private final Integer time;

    public BlastFurnaceRecipe(HashMap<Integer, ItemStack> integerItemStackHashMap, ItemStack result, Integer time) {
        this.integerItemStackHashMap = integerItemStackHashMap;
        this.result = result;
        this.time = time;
    }

    public HashMap<Integer, ItemStack> getCraftItems() {
        return integerItemStackHashMap;
    }

    public ItemStack getResultItem() {
        return result;
    }

    public Integer getTime() {
        return time;
    }
}
