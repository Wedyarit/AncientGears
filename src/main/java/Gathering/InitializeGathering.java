package Gathering;

import Gathering.Ore.Ore;
import Gathering.Ore.OreItems;
import org.bukkit.ChatColor;


public class InitializeGathering {
    public static void InitializeOre() {
        ResourceManager.getInstance().addOre(new Ore(ChatColor.GRAY + "Булыжник", 1, OreItems.stoneOre, 80.0, 30,50));
        ResourceManager.getInstance().addOre(new Ore(ChatColor.GRAY + "Уголь", 1, OreItems.coalOre, 70.0, 45,35));
        ResourceManager.getInstance().addOre(new Ore(ChatColor.GRAY + "Железная руда", 2, OreItems.ironOre, 60.0, 60,150));
        ResourceManager.getInstance().addOre(new Ore(ChatColor.GRAY + "Оловянная руда", 2, OreItems.tinOre, 60.0, 60,110));
        ResourceManager.getInstance().addOre(new Ore(ChatColor.GRAY + "Медная руда", 2, OreItems.copperOre, 60.0, 60,110));
        ResourceManager.getInstance().addOre(new Ore(ChatColor.GRAY + "Цинковая руда", 3, OreItems.zincOre, 40.0, 60,90));
        ResourceManager.getInstance().addOre(new Ore(ChatColor.GRAY + "Золотая руда", 3, OreItems.goldOre, 30.0, 120,60));
        ResourceManager.getInstance().addOre(new Ore(ChatColor.GRAY + "Титановая руда", 3, OreItems.titanOre, 20.0, 120,240));
    }

    public static void InitializeTools() {
        ResourceManager.getInstance().addTool(new Tool(Tool.Type.PICKAXE, 1, OreItems.t1PickAxe,5,1));
        ResourceManager.getInstance().addTool(new Tool(Tool.Type.PICKAXE, 2, OreItems.t2PickAxe,10,1));
        ResourceManager.getInstance().addTool(new Tool(Tool.Type.PICKAXE, 3, OreItems.t3PickAxe,20,2));
        ResourceManager.getInstance().addTool(new Tool(Tool.Type.PICKAXE, 4, OreItems.t4PickAxe,40,2));
        ResourceManager.getInstance().addTool(new Tool(Tool.Type.PICKAXE, 5, OreItems.t5PickAxe,80,3));
        ResourceManager.getInstance().addTool(new Tool(Tool.Type.PICKAXE, 6, OreItems.t6PickAxe,160,3));
    }
}
