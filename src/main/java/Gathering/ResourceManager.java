package Gathering;

import Gathering.Ore.Ore;
import Gathering.Ore.OreItems;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ResourceManager {
    public static Ore stoneOre = new Ore(ChatColor.GRAY + "Булыжник", OreItems.t1PickAxe, new ItemStack(Material.REDSTONE_ORE, 1), 80.0, 30);
    public static Ore coalOre = new Ore(ChatColor.GRAY + "Уголь", OreItems.t1PickAxe, OreItems.coalOre, 70.0, 45);
    public static Ore ironOre = new Ore(ChatColor.GRAY + "Железная руда", OreItems.t2PickAxe, OreItems.ironOre, 60.0, 60);
    public static Ore tinOre = new Ore(ChatColor.GRAY + "Оловянная руда", OreItems.t2PickAxe, OreItems.tinOre, 60.0, 60);
    public static Ore copperOre = new Ore(ChatColor.GRAY + "Медная руда", OreItems.t2PickAxe, OreItems.copperOre, 60.0, 60);
    public static Ore zincOre = new Ore(ChatColor.GRAY + "Цинковая руда", OreItems.t3PickAxe, OreItems.zincOre, 40.0, 60);
    public static Ore goldOre = new Ore(ChatColor.GRAY + "Золотая руда", OreItems.t3PickAxe, OreItems.goldOre, 30.0, 120);
    public static Ore titanOre = new Ore(ChatColor.GRAY + "Титановая руда", OreItems.t3PickAxe, OreItems.titanOre, 20.0, 120);
}