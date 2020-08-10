package Recipes;

import AncientGears.AncientGears;
import GUI.GUIManager;
import Gathering.ItemStackManager;
import Gathering.Ore.OreItems;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;

public class BlastFurnaceRecipesManager {
    public static ArrayList<BlastFurnaceRecipe> blastFurnaceRecipes = new ArrayList<>();
    public static ArrayList<Player> craftingPlayers = new ArrayList<>();

    public static void InitializeBlastFurnaceRecipes() {
        blastFurnaceRecipes.add(new BlastFurnaceRecipe(new HashMap<ItemStack, Integer>() {{
            put(ItemStackManager.getInstance().getItem(OreItems.OreItemNames.COAL_ORE.name()), 3);
            put(ItemStackManager.getInstance().getItem(OreItems.OreItemNames.IRON_ORE.name()), 1);
        }}, new ItemStack(Material.IRON_INGOT, 2), 2));
    }

    private static boolean isContains(ItemStack itemStack, HashMap<ItemStack, Integer> itemStackIntegerHashMap) {
        for (ItemStack itemStack1 : itemStackIntegerHashMap.keySet())
            if (itemStack1.equals(itemStack))
                return true;

        return false;
    }

    private static boolean isContainsMap(HashMap<ItemStack, Integer> itemStackIntegerHashMap1, HashMap<ItemStack, Integer> itemStackIntegerHashMap2) {
        int i = 0;

        for (ItemStack itemStack1 : itemStackIntegerHashMap1.keySet())
            for (ItemStack itemStack2 : itemStackIntegerHashMap2.keySet())
                if (itemStack1.equals(itemStack2))
                    if (itemStackIntegerHashMap1.get(itemStack1) <= itemStackIntegerHashMap2.get(itemStack2))
                        i++;

        return i == itemStackIntegerHashMap1.keySet().size();
    }

    private static HashMap<String, Integer> getRemoveItemsDisplayNames(HashMap<ItemStack, Integer> itemStackIntegerHashMap1, HashMap<ItemStack, Integer> itemStackIntegerHashMap2) {
        HashMap<String, Integer> removeItemsDisplayNames = new HashMap<>();

        for (ItemStack itemStack1 : itemStackIntegerHashMap1.keySet())
            for (ItemStack itemStack2 : itemStackIntegerHashMap2.keySet())
                if (itemStack1.equals(itemStack2))
                    if (itemStackIntegerHashMap1.get(itemStack1) <= itemStackIntegerHashMap2.get(itemStack2))
                        removeItemsDisplayNames.put(itemStack1.getItemMeta().getDisplayName(), itemStackIntegerHashMap1.get(itemStack1));


        return removeItemsDisplayNames;
    }

    public static void craft(Inventory inventory, Player player) {
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
                item.setAmount(1);
                if (isContains(item, itemStackIntegerHashMap))
                    itemStackIntegerHashMap.put(item, itemStackIntegerHashMap.get(item) + itemStack.getAmount());
                else
                    itemStackIntegerHashMap.put(item, itemStack.getAmount());

            }
        }

        for (BlastFurnaceRecipe recipe : blastFurnaceRecipes) {
            if (isContainsMap(recipe.getCraftItems(), itemStackIntegerHashMap)) {
                if (inventory.getItem(24) != null && !inventory.getItem(24).getItemMeta().getDisplayName().equals(recipe.getResultItem().getItemMeta().getDisplayName()))
                    return;
                if (craftingPlayers.contains(player)) return;

                craftingPlayers.add(player);

                ItemStack result = new ItemStack(recipe.getResultItem());

                if (inventory.getItem(24) != null)
                    if (inventory.getItem(24).getAmount() + recipe.getResultItem().getAmount() > 64)
                        return;

                new BukkitRunnable() {
                    double time = recipe.getTime();

                    @Override
                    public void run() {
                        if (time == 0) {
                            if (inventory.getItem(24) == null)
                                result.setAmount(recipe.getResultItem().getAmount());
                            else
                                result.setAmount(inventory.getItem(24).getAmount() + recipe.getResultItem().getAmount());
                            inventory.setItem(24, result);

                            HashMap<String, Integer> removeItemsDisplayNames = getRemoveItemsDisplayNames(recipe.getCraftItems(), itemStackIntegerHashMap);
                            for (String displayName : removeItemsDisplayNames.keySet())
                                for (ItemStack itemStack : craftingItems)
                                    if (itemStack != null)
                                        if (itemStack.getItemMeta() != null)
                                            if (itemStack.getItemMeta().getDisplayName().equals(displayName)) {
                                                if (itemStack.getAmount() - removeItemsDisplayNames.get(displayName) < 0) {
                                                    removeItemsDisplayNames.put(displayName, removeItemsDisplayNames.get(displayName) - itemStack.getAmount());
                                                    itemStack.setAmount(0);
                                                    continue;
                                                }
                                                itemStack.setAmount(itemStack.getAmount() - removeItemsDisplayNames.get(displayName));
                                                break;
                                            }
                            craftingPlayers.remove(player);
                            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 2, 1);
                            this.cancel();
                        } else if (time == Math.round(recipe.getTime())) {
                            GUIManager.replaceItemStacks(inventory, new ItemStack(Material.YELLOW_STAINED_GLASS_PANE), new ItemStack(Material.WHITE_STAINED_GLASS_PANE));
                            GUIManager.replaceItemStacks(inventory, new ItemStack(Material.RED_STAINED_GLASS_PANE), new ItemStack(Material.WHITE_STAINED_GLASS_PANE));
                        } else if (time == Math.round(recipe.getTime() / 3) * 2) {
                            GUIManager.replaceItemStacks(inventory, new ItemStack(Material.WHITE_STAINED_GLASS_PANE), new ItemStack(Material.YELLOW_STAINED_GLASS_PANE));
                            GUIManager.replaceItemStacks(inventory, new ItemStack(Material.RED_STAINED_GLASS_PANE), new ItemStack(Material.YELLOW_STAINED_GLASS_PANE));
                        } else {
                            GUIManager.replaceItemStacks(inventory, new ItemStack(Material.YELLOW_STAINED_GLASS_PANE), new ItemStack(Material.RED_STAINED_GLASS_PANE));
                            GUIManager.replaceItemStacks(inventory, new ItemStack(Material.WHITE_STAINED_GLASS_PANE), new ItemStack(Material.RED_STAINED_GLASS_PANE));
                        }

                        player.playSound(player.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 10, 1);

                        time--;
                    }
                }.runTaskTimer(AncientGears.getInstance(), 0, 20);

            }
        }
    }
}
