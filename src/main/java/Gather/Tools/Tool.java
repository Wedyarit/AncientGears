package Gather.Tools;

import org.bukkit.inventory.ItemStack;

public class Tool extends org.bukkit.inventory.ItemStack {


    private final Integer tier;
    private final ItemStack tool;
    private final Integer gatherPower;
    private final ResourceTypeEnum toolType;
    private final Integer luckFactor;

    public Tool(Integer tier, ItemStack tool, Integer gatherPower, ResourceTypeEnum toolType, Integer luckFactor) {
        this.tier = tier;
        this.tool = tool;
        this.gatherPower = gatherPower;
        this.toolType = toolType;
        this.luckFactor = luckFactor;
    }


    public ResourceTypeEnum getToolType() {
        return this.toolType;
    }

    public ItemStack getTool() {
        return this.tool;
    }

    public Integer getTier() {
        return this.tier;
    }

    public Integer gatherPower() {
        return this.gatherPower;
    }

    public Integer getLuckFactor() {
        return this.luckFactor;
    }
}
