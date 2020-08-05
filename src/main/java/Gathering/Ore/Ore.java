package Gathering.Ore;

import Utilities.ResourceConstructor;
import org.bukkit.entity.ArmorStand;

public class Ore {
    public static ArmorStand stoneOre = new ResourceConstructor(OreNames.oreNames().get(0))
            .setType(ResourceConstructor.ResourceType.ORE)
            .setMaterial(OreItems.stoneOre)
            .build();

    public static ArmorStand coalOre = new ResourceConstructor(OreNames.oreNames().get(1))
            .setType(ResourceConstructor.ResourceType.ORE)
            .setMaterial(OreItems.coalOre)
            .build();

    public static ArmorStand ironOre = new ResourceConstructor(OreNames.oreNames().get(2))
            .setType(ResourceConstructor.ResourceType.ORE)
            .setMaterial(OreItems.ironOre)
            .build();

    public static ArmorStand copperOre = new ResourceConstructor(OreNames.oreNames().get(3))
            .setType(ResourceConstructor.ResourceType.ORE)
            .setMaterial(OreItems.copperOre)
            .build();

    public static ArmorStand goldOre = new ResourceConstructor(OreNames.oreNames().get(4))
            .setType(ResourceConstructor.ResourceType.ORE)
            .setMaterial(OreItems.goldOre)
            .build();

    public static ArmorStand tinOre = new ResourceConstructor(OreNames.oreNames().get(5))
            .setType(ResourceConstructor.ResourceType.ORE)
            .setMaterial(OreItems.tinOre)
            .build();

    public static ArmorStand zincOre = new ResourceConstructor(OreNames.oreNames().get(6))
            .setType(ResourceConstructor.ResourceType.ORE)
            .setMaterial(OreItems.zincOre)
            .build();

    public static ArmorStand titanOre = new ResourceConstructor(OreNames.oreNames().get(7))
            .setType(ResourceConstructor.ResourceType.ORE)
            .setMaterial(OreItems.titanOre)
            .build();
}
