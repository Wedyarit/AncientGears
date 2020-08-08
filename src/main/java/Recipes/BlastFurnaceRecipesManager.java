package Recipes;

import Gathering.ItemStackManager;
import Gathering.Ore.OreItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class BlastFurnaceRecipesManager {
    public static ArrayList<BlastFurnaceRecipe> blastFurnaceRecipes = new ArrayList<>();

    public static void InitializeBlastFurnaceRecipes() {
        blastFurnaceRecipes.add(new BlastFurnaceRecipe(new HashMap<Integer, ItemStack>() {{
            put(3, ItemStackManager.getInstance().getItem(OreItems.OreItemNames.COAL_ORE.name()));
            put(1, ItemStackManager.getInstance().getItem(OreItems.OreItemNames.IRON_ORE.name()));
        }}, new ItemStack(Material.IRON_INGOT), 10));
    }
}
