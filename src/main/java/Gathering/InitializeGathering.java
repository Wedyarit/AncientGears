package Gathering;

import AncientGears.AncientGears;
import Gathering.Ore.Ore;
import Gathering.Ore.OreItems;
import org.bukkit.ChatColor;


public class InitializeGathering {
    public static void InitializeOre() {
        AncientGears.getInstance().getLogger().info("Ore Initialization");
        ResourceManager.getInstance().addOre(new Ore(ChatColor.GRAY + "Булыжник", 1, ItemStackManager.getInstance().getItem(OreItems.OreItemNames.STONE_ORE.name()), 80.0, 30,50));
        ResourceManager.getInstance().addOre(new Ore(ChatColor.GRAY + "Уголь", 1, ItemStackManager.getInstance().getItem(OreItems.OreItemNames.COAL_ORE.name()), 70.0, 45,35));
        ResourceManager.getInstance().addOre(new Ore(ChatColor.GRAY + "Железная руда", 2, ItemStackManager.getInstance().getItem(OreItems.OreItemNames.IRON_ORE.name()), 60.0, 60,150));
        ResourceManager.getInstance().addOre(new Ore(ChatColor.GRAY + "Оловянная руда", 2, ItemStackManager.getInstance().getItem(OreItems.OreItemNames.TIN_ORE.name()), 60.0, 60,110));
        ResourceManager.getInstance().addOre(new Ore(ChatColor.GRAY + "Медная руда", 2, ItemStackManager.getInstance().getItem(OreItems.OreItemNames.COPPER_ORE.name()), 60.0, 60,110));
        ResourceManager.getInstance().addOre(new Ore(ChatColor.GRAY + "Цинковая руда", 3, ItemStackManager.getInstance().getItem(OreItems.OreItemNames.ZINC_ORE.name()), 40.0, 60,90));
        ResourceManager.getInstance().addOre(new Ore(ChatColor.GRAY + "Золотая руда", 3, ItemStackManager.getInstance().getItem(OreItems.OreItemNames.GOLD_ORE.name()), 30.0, 120,60));
        ResourceManager.getInstance().addOre(new Ore(ChatColor.GRAY + "Титановая руда", 3, ItemStackManager.getInstance().getItem(OreItems.OreItemNames.TITAN_ORE.name()), 20.0, 120,240));
    }

    public static void InitializeTools() {
        AncientGears.getInstance().getLogger().info("Tools Initialization");
        ResourceManager.getInstance().addTool(new Tool(Tool.Type.PICKAXE, 1, ItemStackManager.getInstance().getItem(OreItems.OreItemNames.T1_PICKAXE.name()),5,1));
        ResourceManager.getInstance().addTool(new Tool(Tool.Type.PICKAXE, 2, ItemStackManager.getInstance().getItem(OreItems.OreItemNames.T2_PICKAXE.name()),10,1));
        ResourceManager.getInstance().addTool(new Tool(Tool.Type.PICKAXE, 3, ItemStackManager.getInstance().getItem(OreItems.OreItemNames.T3_PICKAXE.name()),20,2));
        ResourceManager.getInstance().addTool(new Tool(Tool.Type.PICKAXE, 4, ItemStackManager.getInstance().getItem(OreItems.OreItemNames.T4_PICKAXE.name()),40,2));
        ResourceManager.getInstance().addTool(new Tool(Tool.Type.PICKAXE, 5, ItemStackManager.getInstance().getItem(OreItems.OreItemNames.T5_PICKAXE.name()),80,3));
        ResourceManager.getInstance().addTool(new Tool(Tool.Type.PICKAXE, 6, ItemStackManager.getInstance().getItem(OreItems.OreItemNames.T6_PICKAXE.name()),160,3));
    }
}
