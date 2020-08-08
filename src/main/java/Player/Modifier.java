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
        this.additionalAttackDamage = ChatColor.GRAY + "[⚔] + " + ChatColor.GOLD + "% " + ChatColor.GRAY + "физическому урону";
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

    public void setAdditionalHealth(Integer additionalHealth) {
        this.additionalHealth = this.additionalHealth.replace(ChatColor.GOLD + "%", ChatColor.GOLD + additionalHealth.toString() + "%");
    }

    public void setAdditionalArmor(Integer additionalArmor) {
        int percentIndex = this.additionalArmor.indexOf('%') - 1;
        StringBuilder sb = new StringBuilder(this.additionalHealth);
        this.additionalArmor = sb.replace(percentIndex, percentIndex, additionalArmor.toString()).toString();
    }

    public void setAdditionalAttackSpeed(Integer additionalAttackSpeed) {
        int percentIndex = this.additionalAttackSpeed.indexOf('%') - 1;
        StringBuilder sb = new StringBuilder(this.additionalAttackSpeed);
        this.additionalAttackSpeed = sb.replace(percentIndex, percentIndex, additionalAttackSpeed.toString()).toString();
    }

    public void setAdditionalAttackDamage(Integer additionalAttackDamage) {
        int percentIndex = this.additionalAttackDamage.indexOf('%') - 1;
        StringBuilder sb = new StringBuilder(this.additionalAttackDamage);
        this.additionalAttackDamage = sb.replace(percentIndex, percentIndex, additionalAttackDamage.toString()).toString();
    }
}
