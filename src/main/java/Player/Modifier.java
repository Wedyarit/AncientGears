package Player;

import org.bukkit.ChatColor;

public class Modifier {
    private Integer additionalMovementSpeed = 0;
    private Integer additionalHealth = 0;
    private Integer additionalArmor = 0;
    private Integer additionalAttackSpeed = 0;
    private Integer additionalAttackDamage = 0;

    public Modifier() {

    }

    public String getAdditionalMovementSpeedString() {
        return ChatColor.GOLD + "" + additionalMovementSpeed + "% " + ChatColor.GRAY + "к скорости передвижения";
    }

    public String getAdditionalHealthString() {
        return ChatColor.GOLD + "" + additionalHealth + "% " + ChatColor.GRAY + "к максимальному здоровью";
    }

    public String getAdditionalArmorString() {
        return ChatColor.GOLD + "" +  additionalArmor + "% " + ChatColor.GRAY + "к физической защите";
    }

    public String getAdditionalAttackSpeedString() {
        return ChatColor.GOLD + "" +  additionalAttackSpeed + "% " + ChatColor.GRAY + "к скорости атаки";
    }

    public String getAdditionalAttackDamageString() {
        return ChatColor.GOLD + "" +  additionalAttackDamage + "% " + ChatColor.GRAY + "к физическому урону";
    }

    public Integer getAdditionalMovementSpeed() {
        return additionalMovementSpeed;
    }

    public Integer getAdditionalHealth() {
        return additionalHealth;
    }

    public Integer getAdditionalArmor() {
        return additionalArmor;
    }

    public Integer getAdditionalAttackDamage() {
        return additionalAttackDamage;
    }

    public Integer getAdditionalAttackSpeed() {
        return additionalAttackSpeed;
    }

    public void setAdditionalMovementSpeed(Integer additionalMovementSpeed) {
        this.additionalMovementSpeed = additionalMovementSpeed;
    }

    public void setAdditionalHealth(Integer additionalHealth) {
        this.additionalHealth = additionalHealth;
    }

    public void setAdditionalArmor(Integer additionalArmor) {
        this.additionalArmor = additionalArmor;
    }

    public void setAdditionalAttackDamage(Integer additionalAttackDamage) {
        this.additionalAttackDamage = additionalAttackDamage;
    }

    public void setAdditionalAttackSpeed(Integer additionalAttackSpeed) {
        this.additionalAttackSpeed = additionalAttackSpeed;
    }

    public void addAdditionalMovementSpeed(Integer additionalMovementSpeed) {
        this.additionalMovementSpeed += additionalMovementSpeed;
    }

    public void addAdditionalHealth(Integer additionalHealth) {
        this.additionalHealth += additionalHealth;
    }

    public void addAdditionalArmor(Integer additionalArmor) {
        this.additionalArmor += additionalArmor;
    }

    public void addAdditionalAttackDamage(Integer additionalAttackDamage) {
        this.additionalAttackDamage += additionalAttackDamage;
    }

    public void addAdditionalAttackSpeed(Integer additionalAttackSpeed) {
        this.additionalAttackSpeed += additionalAttackSpeed;
    }


}
