package Gather;

import AncientGears.AncientGears;
import Gather.Resources.Ore;
import Gather.Resources.Resource;
import Gather.Tools.*;
import org.bukkit.ChatColor;



public class InitializeGathering {
    public static void InitializeOre() {
        AncientGears.getInstance().getLogger().info("Ore Initialization");
        ItemStackManager itemStackManager = ItemStackManager.getInstance();
        ResourceManager resourceManager = ResourceManager.getInstance();

        resourceManager.addResource(new Ore(ChatColor.GRAY + "Булыжник", 1, itemStackManager.getItem(GatherEnum.STONE_ORE) ,itemStackManager.getItem(GatherEnum.STONE_ORE), 80.0, 30,50));
        resourceManager.addResource(new Ore(ChatColor.GRAY + "Уголь", 1, itemStackManager.getItem(GatherEnum.COAL_ORE),itemStackManager.getItem(GatherEnum.COAL_ORE), 70.0, 45,35));
        resourceManager.addResource(new Ore(ChatColor.GRAY + "Железная руда", 2,itemStackManager.getItem(GatherEnum.IRON_ORE), itemStackManager.getItem(GatherEnum.IRON_ORE), 60.0, 60,150));
        resourceManager.addResource(new Ore(ChatColor.GRAY + "Оловянная руда", 2,itemStackManager.getItem(GatherEnum.TIN_ORE), itemStackManager.getItem(GatherEnum.TIN_ORE), 60.0, 60,110));
        resourceManager.addResource(new Ore(ChatColor.GRAY + "Медная руда", 2, itemStackManager.getItem(GatherEnum.COPPER_ORE), itemStackManager.getItem(GatherEnum.COPPER_ORE), 60.0, 60,110));
        resourceManager.addResource(new Ore(ChatColor.GRAY + "Цинковая руда", 3, itemStackManager.getItem(GatherEnum.ZINC_ORE), itemStackManager.getItem(GatherEnum.ZINC_ORE), 40.0, 60,90));
        resourceManager.addResource(new Ore(ChatColor.GRAY + "Золотая руда", 3, itemStackManager.getItem(GatherEnum.GOLD_ORE), itemStackManager.getItem(GatherEnum.GOLD_ORE), 30.0, 120,60));
        resourceManager.addResource(new Ore(ChatColor.GRAY + "Титановая руда", 3, itemStackManager.getItem(GatherEnum.TITAN_ORE), itemStackManager.getItem(GatherEnum.TITAN_ORE), 20.0, 120,240));
        resourceManager.addResource(new Ore(ChatColor.GRAY + "Платиновая руда", 3, itemStackManager.getItem(GatherEnum.PLATINUM_ORE), itemStackManager.getItem(GatherEnum.PLATINUM_ORE), 20.0, 120,240));
        resourceManager.addResource(new Ore(ChatColor.GRAY + "Мифриловая руда", 4, itemStackManager.getItem(GatherEnum.MITHRIL_ORE), itemStackManager.getItem(GatherEnum.MITHRIL_ORE), 20.0, 120,240));
        resourceManager.addResource(new Ore(ChatColor.GRAY + "Адамантитовая руда", 5, itemStackManager.getItem(GatherEnum.ADAMANTITE_ORE), itemStackManager.getItem(GatherEnum.ADAMANTITE_ORE), 20.0, 120,320));
        resourceManager.addResource(new Ore(ChatColor.GRAY + "Кварцeвая руда", 3, itemStackManager.getItem(GatherEnum.QUARTZ_ORE), itemStackManager.getItem(GatherEnum.QUARTZ_ORE), 80.0, 120,200));
        resourceManager.addResource(new Ore(ChatColor.GRAY + "Руда вечного пламени", 5, itemStackManager.getItem(GatherEnum.ETERNAL_FLAME_ORE), itemStackManager.getItem(GatherEnum.ETERNAL_FLAME_ORE), 60.0, 120,500));
        resourceManager.addResource(new Ore(ChatColor.GRAY + "Аэролитовая руда", 5, itemStackManager.getItem(GatherEnum.AETHERELITE_ORE), itemStackManager.getItem(GatherEnum.AETHERELITE_ORE), 15.0, 120,500));
        resourceManager.addResource(new Ore(ChatColor.GRAY + "Сгусток тьмы", 6, itemStackManager.getItem(GatherEnum.TENEBRIS_ORE), itemStackManager.getItem(GatherEnum.TENEBRIS_ORE), 80.0, 120,3000));

    }

    public static void InitializeTools() {
        AncientGears.getInstance().getLogger().info("Tools Initialization");
        ItemStackManager itemStackManager = ItemStackManager.getInstance();
        ResourceManager resourceManager = ResourceManager.getInstance();

        resourceManager.addTool(new Pickaxe(1, itemStackManager.getItem(GatherEnum.T1_PICKAXE), 10, 0));
        resourceManager.addTool(new Pickaxe(2, itemStackManager.getItem(GatherEnum.T2_PICKAXE),10,1));
        resourceManager.addTool(new Pickaxe(3, itemStackManager.getItem(GatherEnum.T3_PICKAXE),20,2));
        resourceManager.addTool(new Pickaxe(4, itemStackManager.getItem(GatherEnum.T4_PICKAXE),40,2));
        resourceManager.addTool(new Pickaxe(5, itemStackManager.getItem(GatherEnum.T5_PICKAXE),80,3));
        resourceManager.addTool(new Pickaxe(6, itemStackManager.getItem(GatherEnum.T6_PICKAXE),160,3));

        resourceManager.addTool(new Axe(1, itemStackManager.getItem(GatherEnum.T1_AXE),5,1));
        resourceManager.addTool(new Axe(2, itemStackManager.getItem(GatherEnum.T2_AXE),10,1));
        resourceManager.addTool(new Axe(3, itemStackManager.getItem(GatherEnum.T3_AXE),20,2));
        resourceManager.addTool(new Axe(4, itemStackManager.getItem(GatherEnum.T4_AXE),40,2));
        resourceManager.addTool(new Axe(5, itemStackManager.getItem(GatherEnum.T5_AXE),80,3));
        resourceManager.addTool(new Axe(6, itemStackManager.getItem(GatherEnum.T6_AXE),160,3));

        resourceManager.addTool(new FishingRod(1, itemStackManager.getItem(GatherEnum.T1_FISHING_ROD),5,1));
        resourceManager.addTool(new FishingRod(2, itemStackManager.getItem(GatherEnum.T2_FISHING_ROD),10,1));
        resourceManager.addTool(new FishingRod(3, itemStackManager.getItem(GatherEnum.T3_FISHING_ROD),20,2));
        resourceManager.addTool(new FishingRod(4, itemStackManager.getItem(GatherEnum.T4_FISHING_ROD),40,2));
        resourceManager.addTool(new FishingRod(5, itemStackManager.getItem(GatherEnum.T5_FISHING_ROD),80,3));
        resourceManager.addTool(new FishingRod(6, itemStackManager.getItem(GatherEnum.T6_FISHING_ROD),160,3));

        resourceManager.addTool(new Hoe( 1,itemStackManager.getItem(GatherEnum.T1_HOE),5,1));
        resourceManager.addTool(new Hoe( 2,itemStackManager.getItem(GatherEnum.T2_HOE),10,1));
        resourceManager.addTool(new Hoe( 3,itemStackManager.getItem(GatherEnum.T3_HOE),20,2));
        resourceManager.addTool(new Hoe( 4,itemStackManager.getItem(GatherEnum.T4_HOE),40,2));
        resourceManager.addTool(new Hoe( 5,itemStackManager.getItem(GatherEnum.T5_HOE),80,3));
        resourceManager.addTool(new Hoe( 6,itemStackManager.getItem(GatherEnum.T6_HOE),160,3));
    }
}
