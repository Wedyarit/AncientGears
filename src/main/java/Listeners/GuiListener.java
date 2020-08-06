package Listeners;

import Gathering.Ore.Ore;
import Gathering.Ore.OreItems;
import Gathering.ResourceManager;
import Utilities.GuiConstructor;
import Utilities.ResourceConstructor;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class GuiListener extends BaseListener {
    private static final Inventory guiTools = new GuiConstructor(27, OreItems.toolMenu.getItemMeta().getDisplayName())
            .setItems(OreItems.t1PickAxe, OreItems.t2PickAxe, OreItems.t3PickAxe,
                    OreItems.t4PickAxe, OreItems.t5PickAxe, OreItems.t6PickAxe)
            .bulid();

    private static final Inventory guiGathering = new GuiConstructor(9, OreItems.profMenu.getItemMeta().getDisplayName())
            .setItems(OreItems.oreMenu, OreItems.lumberMenu, OreItems.cropMenu, OreItems.fishingMenu)
            .bulid();

    private static final Inventory guiOre = new GuiConstructor(9, OreItems.oreMenu.getItemMeta().getDisplayName())
            .setItems(OreItems.stoneOre, OreItems.coalOre, OreItems.copperOre,
                    OreItems.tinOre, OreItems.ironOre, OreItems.goldOre,
                    OreItems.zincOre, OreItems.titanOre)
            .bulid();

    private static final Inventory guiLumber = new GuiConstructor(9, OreItems.lumberMenu.getItemMeta().getDisplayName())
            .setItems(OreItems.oreMenu, OreItems.lumberMenu, OreItems.cropMenu, OreItems.fishingMenu)
            .bulid();

    private static final Inventory guiFarming = new GuiConstructor(9, OreItems.cropMenu.getItemMeta().getDisplayName())
            .setItems(OreItems.oreMenu, OreItems.lumberMenu, OreItems.cropMenu, OreItems.fishingMenu)
            .bulid();

    private static final Inventory guiFishing = new GuiConstructor(9, OreItems.fishingMenu.getItemMeta().getDisplayName())
            .setItems(OreItems.oreMenu, OreItems.lumberMenu, OreItems.cropMenu, OreItems.fishingMenu)
            .bulid();

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (e.getItem() == null) return;
        if (!e.getItem().equals(OreItems.profMenu)) return;
        e.getPlayer().openInventory(guiGathering);
    }

    @EventHandler
    public void onInventoryDrag(final InventoryDragEvent e) {
        Inventory inv = e.getInventory();
        if (inv == guiGathering ||
                inv == guiOre ||
                inv == guiLumber ||
                inv == guiFarming ||
                inv == guiFishing ||
                inv == guiTools

        )
            e.setCancelled(true);
    }
//    inv != guiOre ||
//    inv != guiLumber ||
//    inv != guiFarming ||
//    inv != guiFishing

    @EventHandler
    public void onToolGuiClick(final InventoryClickEvent e) {
        Inventory inv = e.getInventory();
        if (inv != guiTools) return;
            e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;
        Player player = (Player) e.getWhoClicked();

        if (clickedItem.equals(OreItems.t1PickAxe)) {
            player.getInventory().addItem(OreItems.t1PickAxe);
        } else if (clickedItem.equals(OreItems.t2PickAxe)) {
            player.getInventory().addItem(OreItems.t2PickAxe);
        } else if (clickedItem.equals(OreItems.t3PickAxe)) {
            player.getInventory().addItem(OreItems.t3PickAxe);
        } else if (clickedItem.equals(OreItems.t4PickAxe)) {
            player.getInventory().addItem(OreItems.t4PickAxe);
        } else if (clickedItem.equals(OreItems.t5PickAxe)) {
            player.getInventory().addItem(OreItems.t5PickAxe);
        } else if (clickedItem.equals(OreItems.t6PickAxe)) {
            player.getInventory().addItem(OreItems.t6PickAxe);
        }
    }

    @EventHandler
    public void onOreGuiClick(final InventoryClickEvent e) {
        Inventory inv = e.getInventory();
        if (inv != guiOre) return;
        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;
        Player player = (Player) e.getWhoClicked();
        World world = player.getWorld();
        ArrayList<Ore> oreArrayList = ResourceManager.getInstance().getOreArrayList();
        ArmorStand as = (ArmorStand) world.spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
        for (Ore ore : oreArrayList) {
            if (clickedItem.equals(ore.getDrop()))
            as = new ResourceConstructor(as)
                    .setName(ore.getName())
                    .setType(ResourceConstructor.ResourceType.ORE)
                    .setMaterial(ore.getDrop())
                    .build();
            break;
        }
        player.closeInventory();
    }

    @EventHandler
    public void onGatheringGuiClick(final InventoryClickEvent e) {
        Inventory inv = e.getInventory();
        if (inv != guiGathering) return;
            e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;
        Player player = (Player) e.getWhoClicked();
        player.closeInventory();
        if (clickedItem.equals(OreItems.oreMenu)) {
            player.openInventory(guiOre);
        } else if (clickedItem.equals(OreItems.cropMenu)) {
            player.openInventory(guiFarming);
        } else if (clickedItem.equals(OreItems.lumberMenu)) {
            player.openInventory(guiLumber);
        } else if (clickedItem.equals(OreItems.fishingMenu)) {
            player.openInventory(guiFishing);
        } else if (clickedItem.equals(OreItems.toolMenu)) {
            player.openInventory(guiTools);
        }
    }
}