package Player;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;

public class RpgPlayer {
    private final Player player;
    private AttributeInstance attackDamage;
    private AttributeInstance speed;
    private AttributeInstance health;
    private AttributeInstance armor;
    private AttributeInstance attackSpeed;

    public RpgPlayer(Player player) {
        this.player = player;
        this.attackDamage = player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE);
        this.speed = player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
        this.health = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        this.armor = player.getAttribute(Attribute.GENERIC_ARMOR);
        this.attackSpeed = player.getAttribute(Attribute.GENERIC_ATTACK_SPEED);
    }

    public Player getPlayer() {
        return player;
    }

    public AttributeInstance getAttackDamage() {
        return attackDamage;
    }

    public AttributeInstance getSpeed() {
        return speed;
    }

    public AttributeInstance getHealth() {
        return health;
    }

    public AttributeInstance getArmor() {
        return armor;
    }

    public AttributeInstance getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackDamage(AttributeInstance attackDamage) {
        this.attackDamage = attackDamage;
    }

    public void setSpeed(AttributeInstance speed) {
        this.speed = speed;
    }

    public void setHealth(AttributeInstance health) {
        this.health = health;
    }

    public void setArmor(AttributeInstance armor) {
        this.armor = armor;
    }

    public void setAttackSpeed(AttributeInstance attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public void addAttackDamage(Double attackDamage) {
        this.attackDamage.setBaseValue(this.attackDamage.getValue() + attackDamage);
    }

    public void addSpeed(Double speed) {
        this.speed.setBaseValue(this.speed.getValue() + speed);
    }

    public void addHealth(Double health) {
        this.health.setBaseValue(this.health.getValue() + health);
    }

    public void addArmor(Double armor) {
        this.armor.setBaseValue(this.armor.getValue() + armor);
    }

    public void addAttackSpeed(Double attackSpeed) {
        this.attackSpeed.setBaseValue(this.attackSpeed.getValue() + attackSpeed);
    }

    public void setBaseAttackDamage() {
        this.attackDamage.setBaseValue(1.0D);
    }

    public void setBaseSpeed() {
        this.speed.setBaseValue(0.1D);
    }

    public void setBaseHealth() {
        this.health.setBaseValue(20.0D);
    }

    public void setBaseArmor() {
        this.armor.setBaseValue(0.0D);
    }

    public void setBaseAttackSpeed() {
        this.attackSpeed.setBaseValue(4.0D);
    }

}
