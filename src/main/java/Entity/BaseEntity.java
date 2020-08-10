package Entity;

import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class BaseEntity {
    private final LivingEntity entity;
    private String name;
    private final int level;
    private boolean isBoss = false;
    private final ArrayList<ItemStack> specialDrop = null;
    private final UUID uuid;

    public BaseEntity(EntityType type, String name, int level, boolean isBoss, Location location) {
        this.level = level;
        this.name = name;
        this.isBoss = isBoss;
        this.entity = (LivingEntity) location.getWorld().spawnEntity(location, type);
        this.uuid = entity.getUniqueId();
        entity.setCustomName(this.name);
        entity.setCustomNameVisible(true);
    }

    public BaseEntity addDrop(ItemStack... itemStacks) {
        this.specialDrop.addAll(Arrays.asList(itemStacks));
        return this;
    }

    public void setStats(double health, double damage, double armor, double speed) {
        entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
        entity.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(damage);
        entity.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(armor);
        entity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(speed);
    }

    public static boolean isEnraged(double percent, LivingEntity entity, boolean isBoss, double damage, double armor, double speed, boolean isEnraged) {
        if (isEnraged) return true;
        percent *= 0.01;
        percent++;
        if (isBoss) percent *= 2;

        entity.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(damage * percent);
        entity.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(armor * percent);
        entity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(speed * percent);

        return true;
    }

    public LivingEntity getEntity() {
        return entity;
    }

    public ArrayList<ItemStack> getSpecialDrop() {
        return specialDrop;
    }

    public int getLevel() {
        return level;
    }

    public boolean isBoss() {
        return isBoss;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }
}
