package Gather.Resources;

import org.bukkit.inventory.ItemStack;

public class Fish extends Resource {
    public Fish(String name, Integer tier, ItemStack material, ItemStack drop, Double chance, Integer cooldown, Integer durability) {
        super(name, ResourceType.FISH, tier, material, drop, chance, cooldown, durability);
    }
}
