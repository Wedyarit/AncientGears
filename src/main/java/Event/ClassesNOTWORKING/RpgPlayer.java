package Event.ClassesNOTWORKING;

import org.bukkit.entity.Player;

public class RpgPlayer {
    private int additionalMeleeDamageModifier;
    private int additionalRangedDamageModifier;
    private int additionalMovementSpeedModifier;
    private int additionalArmorModifier;
    private int modifierAmount;

    private Player player;
    private String playerClass;

    private int agility;
    private int strength;
    private int intelligence;
    private int defence;
    private int hpRegeneration;
    private int mpRegeneration;
    private int mana;
    private int health;

    public RpgPlayer(Player player, String playerClass) {
        this.player = player;
        this.playerClass = "none";
    }

    public int getHealth() {
        return this.health;
    }

    public int getMana() {
        return this.mana;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void addHealth(int health) {
        this.health += health;
    }

    public void addMana(int mana) {
        this.mana += mana;
    }

    public Integer getAgility() {
        return this.agility;
    }

    public Integer getStrength() {
        return this.strength;
    }

    public Integer getIntelligence() {
        return this.intelligence;
    }

    public void setAgility(Integer agility) {
        this.agility = agility;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public void addAgility(Integer additionalAgility) {
        this.agility += additionalAgility;
    }

    public void addStrength(Integer additionalStrength) {
        this.strength += additionalStrength;
    }

    public void addIntelligence(Integer additionalIntelligence) {
        this.intelligence += additionalIntelligence;
    }

    public Integer getModifierAmount() {
        return this.modifierAmount;
    }

    public void setModifierAmount(Integer amount) {
        this.modifierAmount = amount;
    }

    public Integer getAdditionalMeleeDamageModifier() {
        return this.additionalMeleeDamageModifier;
    }

    public Integer getAdditionalRangedDamageModifier() {
        return this.additionalRangedDamageModifier;
    }

    public Integer getAdditionalMovementSpeedModifier() {
        return this.additionalMovementSpeedModifier;
    }

    public Integer getAdditionalArmorModifier() {
        return this.additionalArmorModifier;
    }

    public void setAdditionalMeleeDamageModifier(Integer additionalMeleeDamageModifier) {
        this.additionalMeleeDamageModifier = additionalMeleeDamageModifier;
    }

    public void setAdditionalRangedDamageModifier(Integer additionalRangedDamageModifier) {
        this.additionalRangedDamageModifier = additionalRangedDamageModifier;
    }

    public void setAdditionalMovementSpeedModifier(Integer additionalMovementSpeedModifier) {
        this.additionalMovementSpeedModifier = additionalMovementSpeedModifier;
    }

    public void setAdditionalArmorModifier(Integer additionalArmorModifier) {
        this.additionalArmorModifier = additionalArmorModifier;
    }

    public void addAdditionalMeleeDamageModifier(Integer additionalMeleeDamageModifier) {
        this.additionalMeleeDamageModifier += additionalMeleeDamageModifier;
    }

    public void addAdditionalRangedDamageModifier(Integer additionalRangedDamageModifier) {
        this.additionalRangedDamageModifier += additionalRangedDamageModifier;
    }

    public void addAdditionalMovementSpeedModifier(Integer additionalMovementSpeedModifier) {
        this.additionalMovementSpeedModifier += additionalMovementSpeedModifier;
    }

    public void addAdditionalArmorModifier(Integer additionalArmorModifier) {
        this.additionalArmorModifier += additionalArmorModifier;
    }

}
