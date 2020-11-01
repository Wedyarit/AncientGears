package GUI;

import AncientGears.AncientGears;
import GUI.GUIEnums.GUIType;
import Gather.GatherEnum;
import Gather.ItemStackManager;
import Gather.GatherItems;
import Utilities.GuiConstructor;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class GUIManager {
    public static final HashMap<ItemStack, Inventory> itemStackInventoryHashMap = new HashMap<>();
    public static final HashMap<GUIEnums.GUIType, Inventory> GUIs = new HashMap<>();
    public static final ItemStackManager manager = ItemStackManager.getInstance();

    public static void InitializeInventoryItems() {
        AncientGears.getInstance().getLogger().info("InventoryItems Initialization");

        itemStackInventoryHashMap.put(manager.getItem(GatherEnum.MENU_TOOLS.name()), new GuiConstructor(27,
                ChatColor.RED + "Меню Инструментов")
                .setItems(
                        manager.getItem(GatherEnum.T1_PICKAXE.name()),
                        manager.getItem(GatherEnum.T2_PICKAXE.name()),
                        manager.getItem(GatherEnum.T3_PICKAXE.name()),
                        manager.getItem(GatherEnum.T4_PICKAXE.name()),
                        manager.getItem(GatherEnum.T5_PICKAXE.name()),
                        manager.getItem(GatherEnum.T6_PICKAXE.name()),

                        manager.getItem(GatherEnum.T1_AXE.name()),
                        manager.getItem(GatherEnum.T2_AXE.name()),
                        manager.getItem(GatherEnum.T3_AXE.name()),
                        manager.getItem(GatherEnum.T4_AXE.name()),
                        manager.getItem(GatherEnum.T5_AXE.name()),
                        manager.getItem(GatherEnum.T6_AXE.name()),

                        manager.getItem(GatherEnum.T1_FISHING_ROD.name()),
                        manager.getItem(GatherEnum.T2_FISHING_ROD.name()),
                        manager.getItem(GatherEnum.T3_FISHING_ROD.name()),
                        manager.getItem(GatherEnum.T4_FISHING_ROD.name()),
                        manager.getItem(GatherEnum.T5_FISHING_ROD.name()),
                        manager.getItem(GatherEnum.T6_FISHING_ROD.name()),

                        manager.getItem(GatherEnum.T1_HOE.name()),
                        manager.getItem(GatherEnum.T2_HOE.name()),
                        manager.getItem(GatherEnum.T3_HOE.name()),
                        manager.getItem(GatherEnum.T4_HOE.name()),
                        manager.getItem(GatherEnum.T5_HOE.name()),
                        manager.getItem(GatherEnum.T6_HOE.name()))

                .bulid());

        itemStackInventoryHashMap.put(manager.getItem(GatherEnum.MENU_PROF.name()), new GuiConstructor(27,
                ChatColor.RED + "Меню Профессий")
                .setItems(
                        manager.getItem(GatherEnum.MENU_MINING.name()),
                        manager.getItem(GatherEnum.MENU_LUMBER.name()),
                        manager.getItem(GatherEnum.MENU_FARMING.name()),
                        manager.getItem(GatherEnum.MENU_FISHING.name()),
                        manager.getItem(GatherEnum.MENU_TOOLS.name()))
                .bulid());

        itemStackInventoryHashMap.put(manager.getItem(GatherEnum.MENU_MINING.name()), new GuiConstructor(27,
                ChatColor.RED + "Шахтерство")
                .setItems(
                        manager.getItem(GatherEnum.STONE_ORE.name()),
                        manager.getItem(GatherEnum.COAL_ORE.name()),
                        manager.getItem(GatherEnum.COPPER_ORE.name()),
                        manager.getItem(GatherEnum.TIN_ORE.name()),
                        manager.getItem(GatherEnum.IRON_ORE.name()),
                        manager.getItem(GatherEnum.GOLD_ORE.name()),
                        manager.getItem(GatherEnum.ZINC_ORE.name()),
                        manager.getItem(GatherEnum.TITAN_ORE.name()),
                        manager.getItem(GatherEnum.MITHRIL_ORE.name()),
                        manager.getItem(GatherEnum.ADAMANTITE_ORE.name()),
                        manager.getItem(GatherEnum.QUARTZ_ORE.name()),
                        manager.getItem(GatherEnum.ETERNAL_FLAME_ORE.name()),
                        manager.getItem(GatherEnum.AETHERELITE_ORE.name()),
                        manager.getItem(GatherEnum.TENEBRIS_ORE.name()))
                .bulid());

        itemStackInventoryHashMap.put(manager.getItem(GatherEnum.MENU_LUMBER.name()), new GuiConstructor(27,
                ChatColor.RED + "Лесорубство")

                .bulid());

        itemStackInventoryHashMap.put(manager.getItem(GatherEnum.MENU_FARMING.name()), new GuiConstructor(27,
                ChatColor.RED + "Фермерство")

                .bulid());

        itemStackInventoryHashMap.put(manager.getItem(GatherEnum.MENU_FISHING.name()), new GuiConstructor(27,
                ChatColor.RED + "Рыболовство")

                .bulid());

    }

    public static void replaceItemStacks(Inventory inventory, ItemStack from, ItemStack to) {
        for (int i = 0; i < inventory.getSize(); i++)
            if (inventory.getItem(i) != null)
                if (inventory.getItem(i).equals(from))
                    inventory.setItem(i, to);
    }

    public static Inventory InitializeGUI(GUIType type) {
        switch (type) {
            case BLAST_FURNACE:
                return new GuiConstructor(45,
                        ChatColor.RED + "Доменная печь")
                        .fillSlots(new ItemStack(Material.WHITE_STAINED_GLASS_PANE))
                        .setItem(new HashMap<Integer, ItemStack>() {{
                            put(10, new ItemStack(Material.AIR));
                            put(11, new ItemStack(Material.AIR));
                            put(19, new ItemStack(Material.AIR));
                            put(20, new ItemStack(Material.AIR));
                            put(22, new ItemStack(Material.BLAST_FURNACE));
                            put(24, new ItemStack(Material.AIR));
                            put(28, new ItemStack(Material.AIR));
                            put(29, new ItemStack(Material.AIR));
                        }})
                        .bulid();

        }
        return null;
    }
}
