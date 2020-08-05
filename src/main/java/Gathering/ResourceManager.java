package Gathering;

import Gathering.Ore.Ore;
import Gathering.Ore.OreItems;
import Gathering.Ore.OreVeins;
import org.bukkit.ChatColor;

public class ResourceManager {

        public static Ore stoneOre = new Ore(OreVeins.stoneOre, ChatColor.GRAY + "Булыжник", OreItems.t1PickAxe, OreItems.stoneOre,80.0, 30);
        public static Ore coalOre = new Ore(OreVeins.coalOre, ChatColor.GRAY + "Уголь", OreItems.t1PickAxe, OreItems.coalOre,70.0, 45);
        public static Ore ironOre = new Ore(OreVeins.ironOre, ChatColor.GRAY + "Железная руда", OreItems.t2PickAxe, OreItems.ironOre,60.0, 60);
        public static Ore tinOre = new Ore(OreVeins.tinOre, ChatColor.GRAY + "Оловянная руда", OreItems.t2PickAxe, OreItems.tinOre, 60.0, 60);
        public static Ore copperOre = new Ore(OreVeins.copperOre, ChatColor.GRAY + "Медная руда", OreItems.t2PickAxe, OreItems.copperOre, 60.0, 60);
        public static Ore zincOre = new Ore(OreVeins.zincOre, ChatColor.GRAY + "Цинковая руда", OreItems.t3PickAxe, OreItems.zincOre, 40.0, 60);
        public static Ore goldOre = new Ore(OreVeins.goldOre, ChatColor.GRAY + "Золотая руда", OreItems.t3PickAxe, OreItems.goldOre, 30.0, 120);
        public static Ore titanOre = new Ore(OreVeins.titanOre, ChatColor.GRAY + "Титановая руда", OreItems.t3PickAxe, OreItems.titanOre,20.0, 120);

}
