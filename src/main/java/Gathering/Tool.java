package Gathering;

import org.bukkit.inventory.ItemStack;

public class Tool {
    private final Integer tier;
    private final ItemStack tool;
    private final Integer speed;
    private final String toolType;
    private final Integer luckFactor;

    public enum Type {
        PICKAXE,
        AXE,
        FISHROD,
        HOE;
    }

    public Tool(Type toolType,  Integer tier, ItemStack tool, Integer speed, Integer luckFactor) {
        this.tool = tool;
        this.tier = tier;
        this.speed = speed;
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

    public Integer getSpeed() {
        return this.speed;
    }

    public Integer getLuckFactor() {
        return this.luckFactor;
    }
}
