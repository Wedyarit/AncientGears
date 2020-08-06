package Gathering.Ore;

import org.bukkit.entity.ArmorStand;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Ore {
    private final String name;
    private final Integer tier;
    private final ItemStack drop;
    private final Double chance;
    private final Integer durability;
    private final Integer cooldown;



    public Ore(String name, Integer tier, ItemStack drop, Double chance, Integer cooldown, Integer durability) {
        this.name = name;
        this.tier = tier;
        this.drop = drop;
        this.chance = chance;
        this.cooldown = cooldown;
        this.durability = durability;
    }

    public String getName() {
        return this.name;
    }

    public Integer getTier() {
        return this.tier;
    }

    public ItemStack getDrop() {
        return this.drop;
    }

    public Double getChance() {
        return this.chance;
    }

    public Integer getCooldown() {
        return this.cooldown;
    }

    public Integer getDurability() {
        return this.durability;
    }
}
