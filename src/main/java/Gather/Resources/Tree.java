package Gather.Resources;

import org.bukkit.inventory.ItemStack;

public class Tree extends Resource {
    public Tree(String name, Integer tier, ItemStack material, ItemStack drop, Double chance, Integer cooldown, Integer durability) {
        super(name, ResourceType.TREE, tier, material, drop, chance, cooldown, durability);
    }
}
