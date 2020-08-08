package Recipes;

import Gathering.ItemStackManager;
import Gathering.Ore.OreItems;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class BlastFurnaceRecipesManager {
    public static ArrayList<BlastFurnaceRecipe> blastFurnaceRecipes = new ArrayList<>();

    public static void InitializeBlastFurnaceRecipes() {
        blastFurnaceRecipes.add(new BlastFurnaceRecipe(new HashMap<ItemStack, Integer>() {{
            put(ItemStackManager.getInstance().getItem(OreItems.OreItemNames.COAL_ORE.name()), 3);
            put(ItemStackManager.getInstance().getItem(OreItems.OreItemNames.IRON_ORE.name()), 1);
        }}, new ItemStack(Material.IRON_INGOT), 10));
    }

    private static boolean isContains(ArrayList<ItemStack> craftingItems, HashMap<ItemStack, Integer> itemStackIntegerHashMap) {
        for (ItemStack itemStack : craftingItems)
            for (ItemStack itemStack1 : itemStackIntegerHashMap.keySet())
                if (itemStack1.equals(itemStack))
                    return true;

        return false;
    }

    public static void craft(Inventory inventory) {
        ArrayList<ItemStack> craftingItems = new ArrayList<ItemStack>() {{
            add(inventory.getItem(10));
            add(inventory.getItem(11));
            add(inventory.getItem(19));
            add(inventory.getItem(20));
            add(inventory.getItem(28));
            add(inventory.getItem(29));
        }};

        HashMap<ItemStack, Integer> itemStackIntegerHashMap = new HashMap<>();

        for (ItemStack itemStack : craftingItems) {
            if (itemStack != null) {
                ItemStack item = new ItemStack(itemStack);
                item.setAmount(0);
                if (isContains(craftingItems, itemStackIntegerHashMap)) {
                    itemStackIntegerHashMap.put(itemStack, itemStackIntegerHashMap.get(itemStack) + itemStack.getAmount());
                } else {
                    itemStackIntegerHashMap.put(itemStack, itemStack.getAmount());
                }
            }
        }

        for (BlastFurnaceRecipe recipe : blastFurnaceRecipes) {
            if (itemStackIntegerHashMap.equals(recipe.getCraftItems())) {
                Bukkit.broadcastMessage("Yay");
            }
        }
    }
}
