package GUI;

import AncientGears.AncientGears;
import Gathering.ItemStackManager;
import Gathering.Ore.OreItems;
import Utilities.GuiConstructor;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class GUIManager {
    public static final HashMap<ItemStack, Inventory> itemStackInventoryHashMap = new HashMap<>();
    public static final HashMap<GUIEnums.GUIType, Inventory> GUIs = new HashMap<>();

    public static void InitializeInventoryItems() {
        AncientGears.getInstance().getLogger().info("InventoryItems Initialization");

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
                        ItemStackManager.getInstance().getItem(OreItems.OreItemNames.TITAN_ORE.name()),
                        ItemStackManager.getInstance().getItem(OreItems.OreItemNames.MITHRIL_ORE.name()),
                        ItemStackManager.getInstance().getItem(OreItems.OreItemNames.ADAMANTITE_ORE.name()),
                        ItemStackManager.getInstance().getItem(OreItems.OreItemNames.QUARTZ_ORE.name()),
                        ItemStackManager.getInstance().getItem(OreItems.OreItemNames.ETERNAL_FLAME_ORE.name()),
                        ItemStackManager.getInstance().getItem(OreItems.OreItemNames.AETHERELITE_ORE.name()),
                        ItemStackManager.getInstance().getItem(OreItems.OreItemNames.TENEBRIS_ORE.name()))
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

    public static void InitializeGUIs() {
        AncientGears.getInstance().getLogger().info("GUIs Initialization");

        GUIs.put(GUIEnums.GUIType.BLAST_FURNACE, new GuiConstructor(45,
                ChatColor.RED + "Доменная печь")
                .fillSlots(new ItemStack(Material.WHITE_STAINED_GLASS_PANE))
                .setItem(new HashMap<Integer, ItemStack>() {{
                    put(10, new ItemStack(Material.AIR));
                    put(11, new ItemStack(Material.AIR));
                    put(19, new ItemStack(Material.AIR));
                    put(20, new ItemStack(Material.AIR));
                    put(24, new ItemStack(Material.AIR));
                    put(28, new ItemStack(Material.AIR));
                    put(29, new ItemStack(Material.AIR));
                }})
                .bulid());
    }
}
