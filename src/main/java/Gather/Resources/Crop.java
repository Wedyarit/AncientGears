package Gather.Resources;

import org.bukkit.inventory.ItemStack;

public class Crop extends Resource {
    public Crop(String name, Integer tier, ItemStack material, ItemStack drop, Double chance, Integer cooldown, Integer durability) {
        super(name, ResourceType.CROP, tier, material, drop, chance, cooldown, durability);
    }
}
