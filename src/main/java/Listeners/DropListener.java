package Listeners;

import Gathering.Ore.Ore;
import Gathering.Ore.OreItems;
import Gathering.Structures.BaseRecipe;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class DropListener extends BaseListener {
    private ArrayList<BaseRecipe> getRecipes() {
        ArrayList<BaseRecipe> arrayList = new ArrayList<>();
        arrayList.add(new BaseRecipe(recipe(OreItems.copperOre, OreItems.zincOre), OreItems.brassOre, 2));
        return arrayList;
    }

    private ArrayList<ItemStack> recipe(ItemStack... items) {
        return new ArrayList<>(Arrays.asList(items));
    }

    private boolean isEnough(ArrayList<Item> items, ArrayList<ItemStack> itemstacks) {
        Bukkit.broadcastMessage(items.toString());
        ArrayList<ItemStack> itemstacks1 = new ArrayList<>();
        for (Item item : items) {
            itemstacks1.add(item.getItemStack());
        }
        ArrayList<ItemStack> commonItemstacks = new ArrayList<>(itemstacks);
        commonItemstacks.retainAll(itemstacks1);
        Bukkit.broadcastMessage(commonItemstacks.size() + " | " + itemstacks.size());
        return commonItemstacks.size() == itemstacks.size();
    }

    private ArrayList<Item> getRemoveItems(ArrayList<Item> items, ArrayList<ItemStack> itemstacks) {
        ArrayList<ItemStack> itemstacks1 = new ArrayList<>();
        ArrayList<Item> removeItems = new ArrayList<>();
        for (Item item : items) {
            itemstacks1.add(item.getItemStack());
        }
        ArrayList<ItemStack> commonItemstacks = new ArrayList<>(itemstacks);
        commonItemstacks.retainAll(itemstacks1);
        Bukkit.broadcastMessage(commonItemstacks.size() + " | " + itemstacks.size());
        for (Item item : items) {
            if (commonItemstacks.contains(item.getItemStack()))
                removeItems.add(item);
        }
        return removeItems;
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        Player player = e.getPlayer();
        Item item = e.getItemDrop();
        ArrayList<Item> entityItems = new ArrayList<>();
        entityItems.add(item);
        ArrayList<BaseRecipe> recipes = getRecipes();
        Collection<Entity> entities = item.getNearbyEntities(2, 2, 2);
        for (Entity entity : entities) {
            if (entity instanceof Item) {
                entityItems.add((Item) entity);
                Bukkit.broadcastMessage(((Item) entity).getItemStack().getItemMeta().getDisplayName());
            }
        }
        for (BaseRecipe recipe : recipes) {
            if (isEnough(entityItems, recipe.getNeed())) {
                for (int i = 0; i < recipe.getResultCount(); i++) {
                    Item resItem = (Item) item.getWorld().spawnEntity(item.getLocation(), EntityType.DROPPED_ITEM);
                    resItem.setItemStack(recipe.getResult());
                }
                ArrayList<Item> removeItems = getRemoveItems(entityItems, recipe.getNeed());
                for (Item removeItem : removeItems)
                    removeItem.remove();
            }
        }

    }

//    @EventHandler
//    public void onPickUp(EntityPickupItemEvent e) {
//        if (!(e.getEntity() instanceof Player)) e.setCancelled(true);
//    }
}
