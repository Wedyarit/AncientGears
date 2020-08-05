package Gathering.Ore;

import org.bukkit.ChatColor;
import org.bukkit.entity.ArmorStand;
import org.bukkit.inventory.ItemStack;

public enum OreEnums {
    STONE(ChatColor.GRAY + "Булыжник", Ore.stoneOre, OreItems.t1PickAxe),
    COAL(ChatColor.GRAY + "Уголь", Ore.coalOre, OreItems.t1PickAxe),
    IRON(ChatColor.GRAY + "Железная руда", Ore.ironOre, OreItems.t2PickAxe),
    ZINC(ChatColor.GRAY + "Цинковая руда", Ore.zincOre, OreItems.t2PickAxe),
    COPPER(ChatColor.GRAY + "Медная руда", Ore.copperOre, OreItems.t2PickAxe),
    TIN(ChatColor.GRAY + "Оловяная руда", Ore.tinOre, OreItems.t2PickAxe),
    GOLD(ChatColor.GRAY + "Золотая руда", Ore.goldOre, OreItems.t3PickAxe),
    TITAN(ChatColor.GRAY + "Титановая руда", Ore.titanOre, OreItems.t3PickAxe);

    private final String displayName;
    private final ItemStack tool;
    private final ArmorStand as;

    OreEnums(String displayName, ArmorStand as, ItemStack tool) {
        this.displayName = displayName;
        this.as = as;
        this.tool = tool;
    }

    public ArmorStand getAs() {
        return this.as;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public ItemStack getTool() {
        return this.tool;
    }
}