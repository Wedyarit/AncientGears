package Gathering.Ore;

import Gathering.ItemStackManager;
import Gathering.ResourceManager;
import Utilities.ItemConstructor;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class OreItems {
    public enum OreItemNames {
        STONE_ORE,
        COAL_ORE,
        IRON_ORE,
        TIN_ORE,
        COPPER_ORE,
        ZINC_ORE,
        GOLD_ORE,
        TITAN_ORE,

        T1_PICKAXE,
        T2_PICKAXE,
        T3_PICKAXE,
        T4_PICKAXE,
        T5_PICKAXE,
        T6_PICKAXE,

        BRASS_INGOT,

        MENU_MINING,
        MENU_FISHING,
        MENU_TOOLS,
        MENU_LUMBER,
        MENU_FARMING,
        MENU_PROF,
    }

    public static void InitializeOreItems() {
        ItemStackManager.getInstance().addItem(OreItemNames.STONE_ORE.name(),new ItemConstructor(Material.COBBLESTONE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Булыжник")
                .lore(ChatColor.GRAY + "[✰✰✰✰✰] Материал")
                .build());

        ItemStackManager.getInstance().addItem(OreItemNames.COAL_ORE.name(),new ItemConstructor(Material.COAL)
                .amount(1)
                .displayName(ChatColor.GRAY + "Уголь")
                .lore(ChatColor.GRAY + "[★✰✰✰✰] Материал")
                .build());

        ItemStackManager.getInstance().addItem(OreItemNames.IRON_ORE.name(),new ItemConstructor(Material.IRON_ORE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Железная руда")
                .lore(ChatColor.GRAY + "[★✰✰✰✰] Материал")
                .build());

        ItemStackManager.getInstance().addItem(OreItemNames.COPPER_ORE.name(),new ItemConstructor(Material.ORANGE_CONCRETE_POWDER)
                .amount(1)
                .displayName(ChatColor.GRAY + "Оловянная руда")
                .lore(ChatColor.GRAY + "[★✰✰✰✰] Материал")
                .build());

        ItemStackManager.getInstance().addItem(OreItemNames.TIN_ORE.name(),new ItemConstructor(Material.WHITE_CONCRETE_POWDER)
                .amount(1)
                .displayName(ChatColor.GRAY + "Медная руда")
                .lore(ChatColor.GRAY + "[★✰✰✰✰] Материал")
                .build());

        ItemStackManager.getInstance().addItem(OreItemNames.ZINC_ORE.name(),new ItemConstructor(Material.WHITE_CONCRETE_POWDER)
                .amount(1)
                .displayName(ChatColor.GRAY + "Цинковая руда")
                .lore(ChatColor.GRAY + "[★★✰✰✰] Материал")
                .build());

        ItemStackManager.getInstance().addItem(OreItemNames.GOLD_ORE.name(),new ItemConstructor(Material.GOLD_ORE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Золотая руда")
                .lore(ChatColor.GRAY + "[★✰✰✰✰] Материал")
                .build());

        ItemStackManager.getInstance().addItem(OreItemNames.TITAN_ORE.name(),new ItemConstructor(Material.BLUE_STAINED_GLASS)
                .amount(1)
                .displayName(ChatColor.GRAY + "Титановая руда")
                .lore(ChatColor.GRAY + "[★★★★✰] Материал")
                .build());

        ItemStackManager.getInstance().addItem(OreItemNames.BRASS_INGOT.name(), new ItemConstructor(Material.GOLD_INGOT)
                .amount(1)
                .displayName(ChatColor.GRAY + "Слиток Латуни")
                .lore(ChatColor.GRAY + "[★★✰✰✰] Материал")
                .build());

        ItemStackManager.getInstance().addItem(OreItemNames.T1_PICKAXE.name(),new ItemConstructor(Material.WOODEN_PICKAXE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Деревянная кирка")
                .lore(ChatColor.GRAY + "[✰✰✰✰✰] Кирка","",ChatColor.GRAY + "Фактор удачи: " + ChatColor.GOLD + "0")
                .build());

        ItemStackManager.getInstance().addItem(OreItemNames.T2_PICKAXE.name(),new ItemConstructor(Material.STONE_PICKAXE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Каменная кирка")
                .lore(ChatColor.GRAY + "[★✰✰✰✰] Кирка","",ChatColor.GRAY + "Фактор удачи: " + ChatColor.GOLD + "0")
                .build());

        ItemStackManager.getInstance().addItem(OreItemNames.T3_PICKAXE.name(),new ItemConstructor(Material.IRON_PICKAXE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Железная кирка")
                .lore(ChatColor.GRAY + "[★★✰✰✰] Кирка","",ChatColor.GRAY + "Фактор удачи: " + ChatColor.GOLD + "1")
                .build());

        ItemStackManager.getInstance().addItem(OreItemNames.T4_PICKAXE.name(),new ItemConstructor(Material.GOLDEN_PICKAXE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Золотая кирка")
                .lore(ChatColor.GRAY + "[★★★✰✰] Кирка","",ChatColor.GRAY + "Фактор удачи: " + ChatColor.GOLD + "1")
                .build());

        ItemStackManager.getInstance().addItem(OreItemNames.T5_PICKAXE.name(),new ItemConstructor(Material.DIAMOND_PICKAXE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Алмазная кирка")
                .lore(ChatColor.GRAY + "[★★★★✰] Кирка","",ChatColor.GRAY + "Фактор удачи: " + ChatColor.GOLD + "2")
                .build());

        ItemStackManager.getInstance().addItem(OreItemNames.T6_PICKAXE.name(),new ItemConstructor(Material.DIAMOND_PICKAXE)
                .amount(1)
                .displayName(ChatColor.GRAY + "Незеритовая кирка")
                .lore(ChatColor.GRAY + "[★★★★★] Кирка","",ChatColor.GRAY + "Фактор удачи: " + ChatColor.GOLD + "2")
                .build());

        ItemStackManager.getInstance().addItem(OreItemNames.MENU_FISHING.name(),new ItemConstructor(Material.FISHING_ROD)
                .amount(1)
                .displayName(ChatColor.RED + "Рыболовство")
                .lore(ChatColor.GRAY + "[★★★★★] Меню")
                .build());

        ItemStackManager.getInstance().addItem(OreItemNames.MENU_MINING.name(),new ItemConstructor(Material.IRON_ORE)
                .amount(1)
                .displayName(ChatColor.RED + "Шахтерство")
                .lore(ChatColor.GRAY + "[★★★★★] Меню")
                .build());

        ItemStackManager.getInstance().addItem(OreItemNames.MENU_TOOLS.name(),new ItemConstructor(Material.NETHERITE_PICKAXE)
                .amount(1)
                .displayName(ChatColor.RED + "Инструменты")
                .lore(ChatColor.GRAY + "[★★★★★] Меню")
                .build());

        ItemStackManager.getInstance().addItem(OreItemNames.MENU_FARMING.name(),new ItemConstructor(Material.WHEAT)
                .amount(1)
                .displayName(ChatColor.RED + "Фермерство")
                .lore(ChatColor.GRAY + "[★★★★★] Меню")
                .build());

        ItemStackManager.getInstance().addItem(OreItemNames.MENU_LUMBER.name(),new ItemConstructor(Material.IRON_AXE)
                .amount(1)
                .displayName(ChatColor.RED + "Лесорубство")
                .lore(ChatColor.GRAY + "[★★★★★] Меню")
                .build());

        ItemStackManager.getInstance().addItem(OreItemNames.MENU_PROF.name(),new ItemConstructor(Material.END_ROD)
                .amount(1)
                .displayName(ChatColor.RED + "Меню Профессий")
                .lore(ChatColor.GRAY + "[★★★★★] Меню")
                .build());

    }
}
