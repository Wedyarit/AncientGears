package Gathering;

import org.bukkit.inventory.ItemStack;

public class Tool {
    private Integer tier;
    private ItemStack tool;

    public Tool(ItemStack tool, Integer tier) {
        this.tool = tool;
        this.tier = tier;
    }

    public ItemStack getTool() {
        return this.tool;
    }

    public Integer getTier() {
        return this.tier;
    }
}
