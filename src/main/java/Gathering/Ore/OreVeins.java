package Gathering.Ore;

import Gathering.ResourceManager;
import Utilities.ResourceConstructor;
import org.bukkit.entity.ArmorStand;

public class OreVeins {
    public static ArmorStand stoneOre = new ResourceConstructor(ResourceManager.stoneOre.getName())
            .setType(ResourceConstructor.ResourceType.ORE)
            .setMaterial(OreItems.stoneOre)
            .build();

    public static ArmorStand coalOre = new ResourceConstructor(ResourceManager.coalOre.getName())
            .setType(ResourceConstructor.ResourceType.ORE)
            .setMaterial(OreItems.coalOre)
            .build();

    public static ArmorStand ironOre = new ResourceConstructor(ResourceManager.ironOre.getName())
            .setType(ResourceConstructor.ResourceType.ORE)
            .setMaterial(OreItems.ironOre)
            .build();

    public static ArmorStand copperOre = new ResourceConstructor(ResourceManager.copperOre.getName())
            .setType(ResourceConstructor.ResourceType.ORE)
            .setMaterial(OreItems.copperOre)
            .build();

    public static ArmorStand goldOre = new ResourceConstructor(ResourceManager.goldOre.getName())
            .setType(ResourceConstructor.ResourceType.ORE)
            .setMaterial(OreItems.goldOre)
            .build();

    public static ArmorStand tinOre = new ResourceConstructor(ResourceManager.tinOre.getName())
            .setType(ResourceConstructor.ResourceType.ORE)
            .setMaterial(OreItems.tinOre)
            .build();

    public static ArmorStand zincOre = new ResourceConstructor(ResourceManager.zincOre.getName())
            .setType(ResourceConstructor.ResourceType.ORE)
            .setMaterial(OreItems.zincOre)
            .build();

    public static ArmorStand titanOre = new ResourceConstructor(ResourceManager.titanOre.getName())
            .setType(ResourceConstructor.ResourceType.ORE)
            .setMaterial(OreItems.titanOre)
            .build();
}
