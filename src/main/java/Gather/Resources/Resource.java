package Gather.Resources;

import Gather.Tools.ResourceTypeEnum;
import net.minecraft.server.v1_16_R2.*;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;
import org.bukkit.inventory.ItemStack;



public class Resource extends EntityArmorStand {
    private final String name;
    private final ResourceTypeEnum type;
    private final Integer tier;
    private final net.minecraft.server.v1_16_R2.ItemStack material;
    private final ItemStack drop;
    private final Double chance;
    private final Integer durability;
    private final Integer cooldown;

    public Resource(Location location, String name, ResourceTypeEnum type, Integer tier, net.minecraft.server.v1_16_R2.ItemStack material, ItemStack drop, Double chance, Integer cooldown, Integer durability) {
        super(EntityTypes.ARMOR_STAND, ((CraftWorld) location.getWorld()).getHandle());
        this.setPosition(location.getX(), location.getY(), location.getZ());
        this.setCustomName(new ChatComponentText(ChatColor.GRAY + "" + ChatColor.BOLD + "[" + tier.toString() + "] " + name));
        this.setCustomNameVisible(true);
        this.setInvisible(true);
        this.setInvulnerable(true);
        this.setLeftArmPose(new Vector3f(125, 250, 10));
        this.setRightArmPose(new Vector3f(225, 0, -75));
        this.setLeftLegPose(new Vector3f(-145, 0, 0));
        this.setRightLegPose(new Vector3f(225, 0, 0));

        this.setSlot(EnumItemSlot.HEAD, material);
        this.setSlot(EnumItemSlot.MAINHAND, material);
        this.setSlot(EnumItemSlot.OFFHAND, material);

        this.name = name;
        this.type = type;
        this.tier = tier;
        this.drop = drop;
        this.chance = chance;
        this.cooldown = cooldown;
        this.durability = durability;
        this.material = material;
    }

    public EntityArmorStand getInstance() {
        return this;
    }

    public ResourceTypeEnum getType() {
        return type;
    }

    public String getName() {
        return this.name;
    }

    public Integer getTier() {
        return this.tier;
    }

    public ItemStack getDrop() {
        return this.drop;
    }

    public net.minecraft.server.v1_16_R2.ItemStack getMaterial() {return this.material;}

    public Double getChance() {
        return this.chance;
    }

    public Integer getCooldown() {
        return this.cooldown;
    }

    public Integer getDurability() {
        return this.durability;
    }
}
