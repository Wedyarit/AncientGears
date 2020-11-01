package Gather.Tools;

import org.bukkit.inventory.ItemStack;

public class Tool {
    public enum Type {
        PICKAXE,
        AXE,
        FISHING_ROD,
        HOE
    }

    private final Integer tier;
    private final ItemStack tool;
    private final Integer gatherPower;
    private final String toolType;
    private final Integer luckFactor;

    public Tool(Type toolType, Integer tier, ItemStack tool, Integer gatherPower, Integer luckFactor) {
        this.tool = tool;
        this.tier = tier;
        this.gatherPower = gatherPower;
        this.toolType = toolType.name();
        this.luckFactor = luckFactor;
    }

    public String getType() {
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
