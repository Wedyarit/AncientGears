package Gather.Tools;

import org.bukkit.inventory.ItemStack;

public class Axe extends Tool {
    public Axe(Integer tier, ItemStack tool, Integer gatherPower, Integer luckFactor) {
        super(tier, tool, gatherPower, ResourceTypeEnum.AXE, luckFactor);
    }
}
