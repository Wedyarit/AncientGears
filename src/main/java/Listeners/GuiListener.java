package Listeners;

import Gathering.ItemStackManager;
import Gathering.Ore.Ore;
import Gathering.Ore.OreItems;
import Gathering.ResourceManager;
import Gathering.Tool;
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
import java.util.HashMap;

public class GuiListener extends BaseListener {
    private static final HashMap<ItemStack, Inventory> itemStackInventoryHashMap = new HashMap<>();

    public static void InitializeInventoryItems() {
        itemStackInventoryHashMap.put(ItemStackManager.getInstance().getItem(OreItems.OreItemNames.MENU_TOOLS.name()), new GuiConstructor(27,
                ChatColor.RED + "Меню Инструментов")
                .setItems(
                        ItemStackManager.getInstance().getItem(OreItems.OreItemNames.T1_PICKAXE.name()),
                        ItemStackManager.getInstance().getItem(OreItems.OreItemNames.T2_PICKAXE.name()),
                        ItemStackManager.getInstance().getItem(OreItems.OreItemNames.T3_PICKAXE.name()),
                        ItemStackManager.getInstance().getItem(OreItems.OreItemNames.T4_PICKAXE.name()),
                        ItemStackManager.getInstance().getItem(OreItems.OreItemNames.T5_PICKAXE.name()),
                        ItemStackManager.getInstance().getItem(OreItems.OreItemNames.T6_PICKAXE.name()))
                .bulid());

        itemStackInventoryHashMap.put(ItemStackManager.getInstance().getItem(OreItems.OreItemNames.MENU_PROF.name()), new GuiConstructor(27,
                ChatColor.RED + "Меню Профессий")
                .setItems(
                        ItemStackManager.getInstance().getItem(OreItems.OreItemNames.MENU_MINING.name()),
                        ItemStackManager.getInstance().getItem(OreItems.OreItemNames.MENU_LUMBER.name()),
                        ItemStackManager.getInstance().getItem(OreItems.OreItemNames.MENU_FARMING.name()),
                        ItemStackManager.getInstance().getItem(OreItems.OreItemNames.MENU_FISHING.name()),
                        ItemStackManager.getInstance().getItem(OreItems.OreItemNames.MENU_TOOLS.name()))
                .bulid());

        itemStackInventoryHashMap.put(ItemStackManager.getInstance().getItem(OreItems.OreItemNames.MENU_MINING.name()), new GuiConstructor(27,
                ChatColor.RED + "Шахтерство")
                .setItems(
                        ItemStackManager.getInstance().getItem(OreItems.OreItemNames.STONE_ORE.name()),
                        ItemStackManager.getInstance().getItem(OreItems.OreItemNames.COAL_ORE.name()),
                        ItemStackManager.getInstance().getItem(OreItems.OreItemNames.COPPER_ORE.name()),
                        ItemStackManager.getInstance().getItem(OreItems.OreItemNames.TIN_ORE.name()),
                        ItemStackManager.getInstance().getItem(OreItems.OreItemNames.IRON_ORE.name()),
                        ItemStackManager.getInstance().getItem(OreItems.OreItemNames.GOLD_ORE.name()),
                        ItemStackManager.getInstance().getItem(OreItems.OreItemNames.ZINC_ORE.name()),
                        ItemStackManager.getInstance().getItem(OreItems.OreItemNames.TITAN_ORE.name()))
                .bulid());

        itemStackInventoryHashMap.put(ItemStackManager.getInstance().getItem(OreItems.OreItemNames.MENU_LUMBER.name()), new GuiConstructor(27,
                ChatColor.RED + "Лесорубство")

                .bulid());

        itemStackInventoryHashMap.put(ItemStackManager.getInstance().getItem(OreItems.OreItemNames.MENU_FARMING.name()), new GuiConstructor(27,
                ChatColor.RED + "Фермерство")

                .bulid());

        itemStackInventoryHashMap.put(ItemStackManager.getInstance().getItem(OreItems.OreItemNames.MENU_FISHING.name()), new GuiConstructor(27,
                ChatColor.RED + "Рыболовство")

                .bulid());


    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (e.getItem() == null) return;
        if (!e.getItem().equals(ItemStackManager.getInstance().getItem(OreItems.OreItemNames.MENU_PROF.name()))) return;
        e.getPlayer().openInventory(itemStackInventoryHashMap.get(OreItems.OreItemNames.MENU_LUMBER));
    }

    @EventHandler
    public void onInventoryDrag(final InventoryDragEvent e) {
        Inventory inv = e.getInventory();
        if (inv == itemStackInventoryHashMap.get(OreItems.OreItemNames.MENU_PROF) ||
                inv == itemStackInventoryHashMap.get(OreItems.OreItemNames.MENU_MINING) ||
                inv == itemStackInventoryHashMap.get(OreItems.OreItemNames.MENU_LUMBER) ||
                inv == itemStackInventoryHashMap.get(OreItems.OreItemNames.MENU_FARMING) ||
                inv == itemStackInventoryHashMap.get(OreItems.OreItemNames.MENU_FISHING) ||
                inv == itemStackInventoryHashMap.get(OreItems.OreItemNames.MENU_TOOLS)

        )
            e.setCancelled(true);
    }

    @EventHandler
    public void onToolGuiClick(final InventoryClickEvent e) {
        Inventory inv = e.getInventory();
        if (inv != itemStackInventoryHashMap.get(OreItems.OreItemNames.MENU_TOOLS)) return;
            e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;
        Player player = (Player) e.getWhoClicked();

        ArrayList<Tool> toolArrayList = ResourceManager.getInstance().getToolArrayList();
        for (Tool tool : toolArrayList) {
            if (clickedItem.equals(tool.getTool()))
                player.getInventory().addItem(tool.getTool());
            break;
        }
        player.closeInventory();
    }

    @EventHandler
    public void onOreGuiClick(final InventoryClickEvent e) {
        Inventory inv = e.getInventory();
        if (inv != itemStackInventoryHashMap.get(OreItems.OreItemNames.MENU_MINING)) return;
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
        if (inv != itemStackInventoryHashMap.get(OreItems.OreItemNames.MENU_PROF)) return;
            e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;
        Player player = (Player) e.getWhoClicked();
        player.closeInventory();

        for (ItemStack itemStack : itemStackInventoryHashMap.keySet())
            if (clickedItem.equals(itemStack))
                player.openInventory(itemStackInventoryHashMap.get(itemStack));
    }
}