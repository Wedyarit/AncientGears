package Gather.Tools;

import org.bukkit.inventory.ItemStack;

public class Pickaxe extends Tool {
    public Pickaxe(Integer tier, ItemStack tool, Integer gatherPower, Integer luckFactor) {
        super(tier, tool, gatherPower, ResourceTypeEnum.PICKAXE, luckFactor);
    }
}
