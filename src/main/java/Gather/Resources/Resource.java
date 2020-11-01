package Gather.Resources;

import org.bukkit.inventory.ItemStack;

public class Resource {
    private final String name;
    private final ResourceType type;
    private final Integer tier;
    private final ItemStack material;
    private final ItemStack drop;
    private final Double chance;
    private final Integer durability;
    private final Integer cooldown;



    public Resource(String name, ResourceType type, Integer tier, ItemStack material, ItemStack drop, Double chance, Integer cooldown, Integer durability) {
        this.name = name;
        this.type = type;
        this.tier = tier;
        this.drop = drop;
        this.chance = chance;
        this.cooldown = cooldown;
        this.durability = durability;
        this.material = material;
    }

    public ResourceType getType() {
        return type;
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

    public ItemStack getMaterial() {return this.material;}

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
