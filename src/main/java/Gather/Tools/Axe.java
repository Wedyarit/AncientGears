package Gather.Tools;

import Gather.Resources.Resource;
import org.bukkit.inventory.ItemStack;

public class Axe extends Tool {
    public Axe(Integer tier, ItemStack tool, Integer gatherPower, Integer luckFactor) {
        super(Tool.Type.HOE, tier, tool, gatherPower, luckFactor);
    }
}
