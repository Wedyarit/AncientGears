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
        return ChatColor.WHITE + "[≈] + " + ChatColor.GOLD + additionalMovementSpeed + "% " + ChatColor.GRAY + "скорости передвижения";
    }

    public String getAdditionalHealthString() {
        return ChatColor.RED + "[♥] + " + ChatColor.GOLD + additionalAttackDamage + "% " + ChatColor.GRAY + "максимальному здоровью";
    }

    public String getAdditionalArmorString() {
        return ChatColor.AQUA + "[⛨] + " + ChatColor.GOLD + additionalArmor + "% " + ChatColor.GRAY + "физической защите";
    }

    public String getAdditionalAttackSpeedString() {
        return ChatColor.YELLOW + "[⋙] + " + ChatColor.GOLD + additionalAttackSpeed + "% " + ChatColor.GRAY + "скорости атаки";
    }

    public String getAdditionalAttackDamageString() {
        return ChatColor.RED + "[⚔] + " + ChatColor.GOLD + additionalAttackDamage + "% " + ChatColor.GRAY + "физическому урону";
    }

    public Integer getAdditionalMovementSpeed() {
        return this.additionalMovementSpeed;
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
