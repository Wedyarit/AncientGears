package Gather.Tools;

import Gather.Tools.Tool;
import org.bukkit.inventory.ItemStack;

public class Pickaxe extends Tool {
    public Pickaxe(Integer tier, ItemStack tool, Integer gatherPower, Integer luckFactor) {
        super(Type.PICKAXE, tier, tool, gatherPower, luckFactor);
    }
}
