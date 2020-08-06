package Gathering;

import Gathering.Ore.Ore;
import Gathering.Ore.OreItems;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ResourceManager {
    public static Ore stoneOre = new Ore(ChatColor.GRAY + "Булыжник", 1, OreItems.stoneOre, 80.0, 30, 50);
    public static Ore coalOre = new Ore(ChatColor.GRAY + "Уголь", 1, OreItems.coalOre, 70.0, 45, 35);
    public static Ore ironOre = new Ore(ChatColor.GRAY + "Железная руда", 2, OreItems.ironOre, 60.0, 60, 150);
    public static Ore tinOre = new Ore(ChatColor.GRAY + "Оловянная руда", 2,OreItems.tinOre, 10.0, 60, 110);
    public static Ore copperOre = new Ore(ChatColor.GRAY + "Медная руда", 2, OreItems.copperOre, 60.0, 60, 110);
    public static Ore zincOre = new Ore(ChatColor.GRAY + "Цинковая руда", 3, OreItems.zincOre, 40.0, 60, 90);
    public static Ore goldOre = new Ore(ChatColor.GRAY + "Золотая руда", 3, OreItems.goldOre, 30.0, 120, 60);
    public static Ore titanOre = new Ore(ChatColor.GRAY + "Титановая руда", 3, OreItems.titanOre, 20.0, 120, 240);
}