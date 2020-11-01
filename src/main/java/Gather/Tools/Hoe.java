package Gather.Tools;

import Gather.Resources.Resource;
import org.bukkit.inventory.ItemStack;

public class Hoe extends Tool {
    public Hoe(Integer tier, ItemStack tool, Integer gatherPower, Integer luckFactor) {
        super(Tool.Type.HOE, tier, tool, gatherPower, luckFactor);
    }
}
