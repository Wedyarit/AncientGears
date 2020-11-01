package Gather.Resources;

import org.bukkit.inventory.ItemStack;

public class Ore extends Resource {
    public Ore(String name, Integer tier, ItemStack material, ItemStack drop, Double chance, Integer cooldown, Integer durability) {
        super(name, ResourceType.ORE, tier, material, drop, chance, cooldown, durability);
    }
}
