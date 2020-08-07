package Gathering;

import AncientGears.AncientGears;
import Gathering.Ore.Ore;
import Gathering.Ore.OreItems;
import org.bukkit.ChatColor;



public class InitializeGathering {
    public static void InitializeOre() {
        AncientGears.getInstance().getLogger().info("Ore Initialization");
        ItemStackManager itemStackManager = ItemStackManager.getInstance();
        ResourceManager resourceManager = ResourceManager.getInstance();

        resourceManager.addOre(new Ore(ChatColor.GRAY + "Булыжник", 1, itemStackManager.getItem(OreItems.OreItemNames.STONE_ORE.name()) ,itemStackManager.getItem(OreItems.OreItemNames.STONE_ORE.name()), 80.0, 30,50));
        resourceManager.addOre(new Ore(ChatColor.GRAY + "Уголь", 1, itemStackManager.getItem(OreItems.OreItemNames.COAL_ORE.name()),itemStackManager.getItem(OreItems.OreItemNames.COAL_ORE.name()), 70.0, 45,35));
        resourceManager.addOre(new Ore(ChatColor.GRAY + "Железная руда", 2,itemStackManager.getItem(OreItems.OreItemNames.IRON_ORE.name()), itemStackManager.getItem(OreItems.OreItemNames.IRON_ORE.name()), 60.0, 60,150));
        resourceManager.addOre(new Ore(ChatColor.GRAY + "Оловянная руда", 2,itemStackManager.getItem(OreItems.OreItemNames.TIN_ORE.name()), itemStackManager.getItem(OreItems.OreItemNames.TIN_ORE.name()), 60.0, 60,110));
        resourceManager.addOre(new Ore(ChatColor.GRAY + "Медная руда", 2, itemStackManager.getItem(OreItems.OreItemNames.COPPER_ORE.name()), itemStackManager.getItem(OreItems.OreItemNames.COPPER_ORE.name()), 60.0, 60,110));
        resourceManager.addOre(new Ore(ChatColor.GRAY + "Цинковая руда", 3, itemStackManager.getItem(OreItems.OreItemNames.ZINC_ORE.name()), itemStackManager.getItem(OreItems.OreItemNames.ZINC_ORE.name()), 40.0, 60,90));
        resourceManager.addOre(new Ore(ChatColor.GRAY + "Золотая руда", 3, itemStackManager.getItem(OreItems.OreItemNames.GOLD_ORE.name()), itemStackManager.getItem(OreItems.OreItemNames.GOLD_ORE.name()), 30.0, 120,60));
        resourceManager.addOre(new Ore(ChatColor.GRAY + "Титановая руда", 3, itemStackManager.getItem(OreItems.OreItemNames.TITAN_ORE.name()), itemStackManager.getItem(OreItems.OreItemNames.TITAN_ORE.name()), 20.0, 120,240));
        resourceManager.addOre(new Ore(ChatColor.GRAY + "Платиновая руда", 3, itemStackManager.getItem(OreItems.OreItemNames.PLATINUM_ORE.name()), itemStackManager.getItem(OreItems.OreItemNames.PLATINUM_ORE.name()), 20.0, 120,240));
        resourceManager.addOre(new Ore(ChatColor.GRAY + "Мифриловая руда", 4, itemStackManager.getItem(OreItems.OreItemNames.MITHRIL_ORE.name()), itemStackManager.getItem(OreItems.OreItemNames.MITHRIL_ORE.name()), 20.0, 120,240));
        resourceManager.addOre(new Ore(ChatColor.GRAY + "Адамантитовая руда", 5, itemStackManager.getItem(OreItems.OreItemNames.ADAMANTITE_ORE.name()), itemStackManager.getItem(OreItems.OreItemNames.ADAMANTITE_ORE.name()), 20.0, 120,320));
        resourceManager.addOre(new Ore(ChatColor.GRAY + "Кварцeвая руда", 3, itemStackManager.getItem(OreItems.OreItemNames.QUARTZ_ORE.name()), itemStackManager.getItem(OreItems.OreItemNames.QUARTZ_ORE.name()), 80.0, 120,200));
        resourceManager.addOre(new Ore(ChatColor.GRAY + "Руда вечного пламени", 5, itemStackManager.getItem(OreItems.OreItemNames.ETERNAL_FLAME_ORE.name()), itemStackManager.getItem(OreItems.OreItemNames.ETERNAL_FLAME_ORE.name()), 60.0, 120,500));
        resourceManager.addOre(new Ore(ChatColor.GRAY + "Аэролитовая руда", 5, itemStackManager.getItem(OreItems.OreItemNames.AETHERELITE_ORE.name()), itemStackManager.getItem(OreItems.OreItemNames.AETHERELITE_ORE.name()), 15.0, 120,500));
        resourceManager.addOre(new Ore(ChatColor.GRAY + "Сгусток тьмы", 6, itemStackManager.getItem(OreItems.OreItemNames.TENEBRIS_ORE.name()), itemStackManager.getItem(OreItems.OreItemNames.TENEBRIS_ORE.name()), 80.0, 120,3000));

    }

    public static void InitializeTools() {
        AncientGears.getInstance().getLogger().info("Tools Initialization");
        ItemStackManager itemStackManager = ItemStackManager.getInstance();
        ResourceManager resourceManager = ResourceManager.getInstance();
        resourceManager.addTool(new Tool(Tool.Type.PICKAXE, 1, itemStackManager.getItem(OreItems.OreItemNames.T1_PICKAXE.name()),5,1));
        resourceManager.addTool(new Tool(Tool.Type.PICKAXE, 2, itemStackManager.getItem(OreItems.OreItemNames.T2_PICKAXE.name()),10,1));
        resourceManager.addTool(new Tool(Tool.Type.PICKAXE, 3, itemStackManager.getItem(OreItems.OreItemNames.T3_PICKAXE.name()),20,2));
        resourceManager.addTool(new Tool(Tool.Type.PICKAXE, 4, itemStackManager.getItem(OreItems.OreItemNames.T4_PICKAXE.name()),40,2));
        resourceManager.addTool(new Tool(Tool.Type.PICKAXE, 5, itemStackManager.getItem(OreItems.OreItemNames.T5_PICKAXE.name()),80,3));
        resourceManager.addTool(new Tool(Tool.Type.PICKAXE, 6, itemStackManager.getItem(OreItems.OreItemNames.T6_PICKAXE.name()),160,3));
    }
}
