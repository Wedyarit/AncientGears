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

        resourceManager.addOre(new Ore(ChatColor.GRAY + "Булыжник", 1, itemStackManager.getItem(GatherEnum.STONE_ORE.name()) ,itemStackManager.getItem(GatherEnum.STONE_ORE.name()), 80.0, 30,50));
        resourceManager.addOre(new Ore(ChatColor.GRAY + "Уголь", 1, itemStackManager.getItem(GatherEnum.COAL_ORE.name()),itemStackManager.getItem(GatherEnum.COAL_ORE.name()), 70.0, 45,35));
        resourceManager.addOre(new Ore(ChatColor.GRAY + "Железная руда", 2,itemStackManager.getItem(GatherEnum.IRON_ORE.name()), itemStackManager.getItem(GatherEnum.IRON_ORE.name()), 60.0, 60,150));
        resourceManager.addOre(new Ore(ChatColor.GRAY + "Оловянная руда", 2,itemStackManager.getItem(GatherEnum.TIN_ORE.name()), itemStackManager.getItem(GatherEnum.TIN_ORE.name()), 60.0, 60,110));
        resourceManager.addOre(new Ore(ChatColor.GRAY + "Медная руда", 2, itemStackManager.getItem(GatherEnum.COPPER_ORE.name()), itemStackManager.getItem(GatherEnum.COPPER_ORE.name()), 60.0, 60,110));
        resourceManager.addOre(new Ore(ChatColor.GRAY + "Цинковая руда", 3, itemStackManager.getItem(GatherEnum.ZINC_ORE.name()), itemStackManager.getItem(GatherEnum.ZINC_ORE.name()), 40.0, 60,90));
        resourceManager.addOre(new Ore(ChatColor.GRAY + "Золотая руда", 3, itemStackManager.getItem(GatherEnum.GOLD_ORE.name()), itemStackManager.getItem(GatherEnum.GOLD_ORE.name()), 30.0, 120,60));
        resourceManager.addOre(new Ore(ChatColor.GRAY + "Титановая руда", 3, itemStackManager.getItem(GatherEnum.TITAN_ORE.name()), itemStackManager.getItem(GatherEnum.TITAN_ORE.name()), 20.0, 120,240));
        resourceManager.addOre(new Ore(ChatColor.GRAY + "Платиновая руда", 3, itemStackManager.getItem(GatherEnum.PLATINUM_ORE.name()), itemStackManager.getItem(GatherEnum.PLATINUM_ORE.name()), 20.0, 120,240));
        resourceManager.addOre(new Ore(ChatColor.GRAY + "Мифриловая руда", 4, itemStackManager.getItem(GatherEnum.MITHRIL_ORE.name()), itemStackManager.getItem(GatherEnum.MITHRIL_ORE.name()), 20.0, 120,240));
        resourceManager.addOre(new Ore(ChatColor.GRAY + "Адамантитовая руда", 5, itemStackManager.getItem(GatherEnum.ADAMANTITE_ORE.name()), itemStackManager.getItem(GatherEnum.ADAMANTITE_ORE.name()), 20.0, 120,320));
        resourceManager.addOre(new Ore(ChatColor.GRAY + "Кварцeвая руда", 3, itemStackManager.getItem(GatherEnum.QUARTZ_ORE.name()), itemStackManager.getItem(GatherEnum.QUARTZ_ORE.name()), 80.0, 120,200));
        resourceManager.addOre(new Ore(ChatColor.GRAY + "Руда вечного пламени", 5, itemStackManager.getItem(GatherEnum.ETERNAL_FLAME_ORE.name()), itemStackManager.getItem(GatherEnum.ETERNAL_FLAME_ORE.name()), 60.0, 120,500));
        resourceManager.addOre(new Ore(ChatColor.GRAY + "Аэролитовая руда", 5, itemStackManager.getItem(GatherEnum.AETHERELITE_ORE.name()), itemStackManager.getItem(GatherEnum.AETHERELITE_ORE.name()), 15.0, 120,500));
        resourceManager.addOre(new Ore(ChatColor.GRAY + "Сгусток тьмы", 6, itemStackManager.getItem(GatherEnum.TENEBRIS_ORE.name()), itemStackManager.getItem(GatherEnum.TENEBRIS_ORE.name()), 80.0, 120,3000));

    }

    public static void InitializeTools() {
        AncientGears.getInstance().getLogger().info("Tools Initialization");
        ItemStackManager itemStackManager = ItemStackManager.getInstance();
        ResourceManager resourceManager = ResourceManager.getInstance();

        resourceManager.addPickaxe(new Pickaxe(1, itemStackManager.getItem(GatherEnum.T1_PICKAXE.name()),5,1));
        resourceManager.addPickaxe(new Pickaxe(2, itemStackManager.getItem(GatherEnum.T2_PICKAXE.name()),10,1));
        resourceManager.addPickaxe(new Pickaxe(3, itemStackManager.getItem(GatherEnum.T3_PICKAXE.name()),20,2));
        resourceManager.addPickaxe(new Pickaxe(4, itemStackManager.getItem(GatherEnum.T4_PICKAXE.name()),40,2));
        resourceManager.addPickaxe(new Pickaxe(5, itemStackManager.getItem(GatherEnum.T5_PICKAXE.name()),80,3));
        resourceManager.addPickaxe(new Pickaxe(6, itemStackManager.getItem(GatherEnum.T6_PICKAXE.name()),160,3));

        resourceManager.addAxe(new Axe(1, itemStackManager.getItem(GatherEnum.T1_AXE.name()),5,1));
        resourceManager.addAxe(new Axe(2, itemStackManager.getItem(GatherEnum.T2_AXE.name()),10,1));
        resourceManager.addAxe(new Axe(3, itemStackManager.getItem(GatherEnum.T3_AXE.name()),20,2));
        resourceManager.addAxe(new Axe(4, itemStackManager.getItem(GatherEnum.T4_AXE.name()),40,2));
        resourceManager.addAxe(new Axe(5, itemStackManager.getItem(GatherEnum.T5_AXE.name()),80,3));
        resourceManager.addAxe(new Axe(6, itemStackManager.getItem(GatherEnum.T6_AXE.name()),160,3));

        resourceManager.addFishingRod(new FishingRod(1, itemStackManager.getItem(GatherEnum.T1_FISHING_ROD.name()),5,1));
        resourceManager.addFishingRod(new FishingRod(2, itemStackManager.getItem(GatherEnum.T2_FISHING_ROD.name()),10,1));
        resourceManager.addFishingRod(new FishingRod(3, itemStackManager.getItem(GatherEnum.T3_FISHING_ROD.name()),20,2));
        resourceManager.addFishingRod(new FishingRod(4, itemStackManager.getItem(GatherEnum.T4_FISHING_ROD.name()),40,2));
        resourceManager.addFishingRod(new FishingRod(5, itemStackManager.getItem(GatherEnum.T5_FISHING_ROD.name()),80,3));
        resourceManager.addFishingRod(new FishingRod(6, itemStackManager.getItem(GatherEnum.T6_FISHING_ROD.name()),160,3));

        resourceManager.addHoe(new Hoe( 1,itemStackManager.getItem(GatherEnum.T1_HOE.name()),5,1));
        resourceManager.addHoe(new Hoe( 2,itemStackManager.getItem(GatherEnum.T2_HOE.name()),10,1));
        resourceManager.addHoe(new Hoe( 3,itemStackManager.getItem(GatherEnum.T3_HOE.name()),20,2));
        resourceManager.addHoe(new Hoe( 4,itemStackManager.getItem(GatherEnum.T4_HOE.name()),40,2));
        resourceManager.addHoe(new Hoe( 5,itemStackManager.getItem(GatherEnum.T5_HOE.name()),80,3));
        resourceManager.addHoe(new Hoe( 6,itemStackManager.getItem(GatherEnum.T6_HOE.name()),160,3));
    }
}
