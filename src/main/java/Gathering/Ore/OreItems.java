package Gathering.Ore;

import Gathering.ResourceManager;
import Utilities.ItemConstructor;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class OreItems {
    //////////////////////// Руда /////////////////////////////////////////////////

    public static ItemStack stoneOre = new ItemConstructor(Material.COBBLESTONE)
            .amount(1)
            .displayName(ResourceManager.stoneOre.getName())
            .lore(ChatColor.GRAY + "[✰✰✰✰✰] Материал")
            .build();

    public static ItemStack coalOre = new ItemConstructor(Material.COAL)
            .amount(1)
            .displayName(ResourceManager.coalOre.getName())
            .lore(ChatColor.GRAY + "[★✰✰✰✰] Материал")
            .build();

    public static ItemStack ironOre = new ItemConstructor(Material.IRON_ORE)
            .amount(1)
            .displayName(ResourceManager.ironOre.getName())
            .lore(ChatColor.GRAY + "[★✰✰✰✰] Материал")
            .build();

    public static ItemStack copperOre = new ItemConstructor(Material.ORANGE_CONCRETE_POWDER)
            .amount(1)
            .displayName(ResourceManager.copperOre.getName())
            .lore(ChatColor.GRAY + "[★✰✰✰✰] Материал")
            .build();

    public static ItemStack tinOre = new ItemConstructor(Material.WHITE_CONCRETE_POWDER)
            .amount(1)
            .displayName(ResourceManager.tinOre.getName())
            .lore(ChatColor.GRAY + "[★✰✰✰✰] Материал")
            .build();

    public static ItemStack zincOre = new ItemConstructor(Material.WHITE_CONCRETE_POWDER)
            .amount(1)
            .displayName(ResourceManager.zincOre.getName())
            .lore(ChatColor.GRAY + "[★★✰✰✰] Материал")
            .build();

    public static ItemStack goldOre = new ItemConstructor(Material.GOLD_ORE)
            .amount(1)
            .displayName(ResourceManager.goldOre.getName())
            .lore(ChatColor.GRAY + "[★✰✰✰✰] Материал")
            .build();

    public static ItemStack titanOre = new ItemConstructor(Material.BLUE_STAINED_GLASS)
            .amount(1)
            .displayName(ResourceManager.titanOre.getName())
            .lore(ChatColor.GRAY + "[★★★★✰] Материал")
            .build();

    //////////////////////// Инструменты /////////////////////////////////////////////////

    public static ItemStack t1PickAxe = new ItemConstructor(Material.WOODEN_PICKAXE)
            .amount(1)
            .displayName(ChatColor.GRAY + "Деревянная кирка")
            .lore(ChatColor.GRAY + "[✰✰✰✰✰] Кирка")
            .build();

    public static ItemStack t2PickAxe = new ItemConstructor(Material.STONE_PICKAXE)
            .amount(1)
            .displayName(ChatColor.GRAY + "Каменная кирка")
            .lore(ChatColor.GRAY + "[★✰✰✰✰] Кирка")
            .build();

    public static ItemStack t3PickAxe = new ItemConstructor(Material.IRON_PICKAXE)
            .amount(1)
            .displayName(ChatColor.GRAY + "Железная кирка")
            .lore(ChatColor.GRAY + "[★★✰✰✰] Кирка")
            .build();

    public static ItemStack t4PickAxe = new ItemConstructor(Material.GOLDEN_PICKAXE)
            .amount(1)
            .displayName(ChatColor.GRAY + "Золотая кирка")
            .lore(ChatColor.GRAY + "[★★★✰✰] Кирка")
            .build();

    public static ItemStack t5PickAxe = new ItemConstructor(Material.DIAMOND_PICKAXE)
            .amount(1)
            .displayName(ChatColor.GRAY + "Алмазная кирка")
            .lore(ChatColor.GRAY + "[★★★★✰] Кирка")
            .build();

    public static ItemStack t6PickAxe = new ItemConstructor(Material.DIAMOND_PICKAXE)
            .amount(1)
            .displayName(ChatColor.GRAY + "Незеритовая кирка")
            .lore(ChatColor.GRAY + "[★★★★★] Кирка")
            .build();

    //////////////////////// Меню /////////////////////////////////////////////////
    public static ItemStack fishingMenu = new ItemConstructor(Material.FISHING_ROD)
            .amount(1)
            .displayName(ChatColor.RED + "Рыболовство")
            .lore(ChatColor.GRAY + "[★★★★★] Меню")
            .build();

    public static ItemStack oreMenu = new ItemConstructor(Material.IRON_ORE)
            .amount(1)
            .displayName(ChatColor.RED + "Шахтерство")
            .lore(ChatColor.GRAY + "[★★★★★] Меню")
            .build();

    public static ItemStack toolMenu = new ItemConstructor(Material.NETHERITE_PICKAXE)
            .amount(1)
            .displayName(ChatColor.RED + "Инструменты")
            .lore(ChatColor.GRAY + "[★★★★★] Меню")
            .build();

    public static ItemStack cropMenu = new ItemConstructor(Material.WHEAT)
            .amount(1)
            .displayName(ChatColor.RED + "Фермерство")
            .lore(ChatColor.GRAY + "[★★★★★] Меню")
            .build();

    public static ItemStack lumberMenu = new ItemConstructor(Material.IRON_AXE)
            .amount(1)
            .displayName(ChatColor.RED + "Лесорубство")
            .lore(ChatColor.GRAY + "[★★★★★] Меню")
            .build();

    public static ItemStack profMenu = new ItemConstructor(Material.END_ROD)
            .amount(1)
            .displayName(ChatColor.RED + "Меню Профессий")
            .lore(ChatColor.GRAY + "[★★★★★] Меню")
            .build();



}
