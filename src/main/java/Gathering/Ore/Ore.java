package Gathering.Ore;

import org.bukkit.entity.ArmorStand;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Ore {
    private final String name;
    private final ItemStack tool;
    private final ItemStack drop;
    private final Double chance;
    private final Integer cooldown;

    public Ore(String name, ItemStack tool, ItemStack drop, Double chance, Integer cooldown) {
        this.name = name;
        this.tool = tool;
        this.drop = drop;
        this.chance = chance;
        this.cooldown = cooldown;
    }

    public String getName() {
        return name;
    }

    public ItemStack getTool() {
        return tool;
    }

    public ItemStack getDrop() {
        return drop;
    }

    public Double getChance() {
        return chance;
    }

    public Integer getCooldown() {
        return cooldown;
    }
}
