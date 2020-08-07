package Player;

import org.bukkit.ChatColor;

public class Modifier {
    private String additionalMovementSpeed;
    private String additionalHealth;
    private String additionalArmor;
    private String additionalAttackSpeed;
    private String additionalAttackDamage;

    public Modifier() {
        this.additionalMovementSpeed = ChatColor.GRAY + "[≈] + " + ChatColor.GOLD + "% " + ChatColor.GRAY + "скорости передвижения";
        this.additionalHealth = ChatColor.GRAY + "[♥] + " + ChatColor.GOLD + "% " + ChatColor.GRAY + "максимальному здоровью";
        this.additionalArmor = ChatColor.GRAY + "[⛨] + " + ChatColor.GOLD + "% " + ChatColor.GRAY + "физической защите";
        this.additionalAttackSpeed = ChatColor.GRAY + "[⋙] + " + ChatColor.GOLD + "% " + ChatColor.GRAY + "скорости атаки";
        this.additionalAttackSpeed = ChatColor.GRAY + "[⚔] + " + ChatColor.GOLD + "% " + ChatColor.GRAY + "физическому урону";
    }

    public void setAdditionalMovementSpeed(String additionalMovementSpeed) {
        this.additionalMovementSpeed = additionalMovementSpeed;
    }

    public String getAdditionalMovementSpeed() {
       return this.additionalMovementSpeed;
    }

    public String getAdditionalHealth() {
        return additionalHealth;
    }

    public String getAdditionalArmor() {
        return additionalArmor;
    }

    public String getAdditionalAttackDamage() {
        return additionalAttackDamage;
    }

    public String getAdditionalAttackSpeed() {
        return additionalAttackSpeed;
    }

    public void setAdditionalHealth(String additionalHealth) {
        this.additionalHealth = additionalHealth;
    }

    public void setAdditionalArmor(String additionalArmor) {
        this.additionalArmor = additionalArmor;
    }

    public void setAdditionalAttackSpeed(String additionalAttackSpeed) {
        this.additionalAttackSpeed = additionalAttackSpeed;
    }

    public void setAdditionalAttackDamage(String additionalAttackDamage) {
        this.additionalAttackDamage = additionalAttackDamage;
    }
}
