package Listeners;

import Gathering.Ore.Ore;
import Gathering.Ore.OreItems;
import Gathering.Structures.BaseRecipe;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collection;

public class DropListener extends BaseListener {
    private ArrayList<BaseRecipe> getRecipes() {
        ArrayList<BaseRecipe> arrayList = new ArrayList<>();
        arrayList.add(new BaseRecipe(recipe(OreItems.copperOre, OreItems.copperOre,OreItems.zincOre), OreItems.brassOre, 2));
        return arrayList;
    }

    private ArrayList<ItemStack> recipe(ItemStack... items) {
        ArrayList<ItemStack> arrayList = new ArrayList<>();
        for (ItemStack item : items) arrayList.add(item);
        return arrayList;
    }
    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        Player player = e.getPlayer();
        Item item = e.getItemDrop();
        ArrayList<Item> entityItems = new ArrayList<>();
        ArrayList<BaseRecipe> recipes = getRecipes();
        Collection<Entity> entities = item.getNearbyEntities(2,2,2);
        for (Entity entity : entities) {
            if (entity instanceof Item) {
                entityItems.add((Item) entity);
            }
        }
        for (Item entityItem : entityItems) {
            // ПАНИКА
        }
    }

    @EventHandler
    public void onPickUp(EntityPickupItemEvent e) {
        if (!(e.getEntity() instanceof Player)) return;

    }
}
