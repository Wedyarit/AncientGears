package Player;

import org.bukkit.ChatColor;

public class Modifier {
    private String additionalMovementSpeed;
    private String additionalHealth;
    private String additionalArmor;
    private String additionalAttackSpeed;
    private String additionalAttackDamage;

    public Modifier() {
        this.additionalMovementSpeed = ChatColor.WHITE + "[≈] + " + ChatColor.GOLD + "% " + ChatColor.GRAY + "скорости передвижения";
        this.additionalHealth = ChatColor.RED + "[♥] + " + ChatColor.GOLD + "% " + ChatColor.GRAY + "максимальному здоровью";
        this.additionalArmor = ChatColor.AQUA + "[⛨] + " + ChatColor.GOLD + "% " + ChatColor.GRAY + "физической защите";
        this.additionalAttackSpeed = ChatColor.YELLOW + "[⋙] + " + ChatColor.GOLD + "% " + ChatColor.GRAY + "скорости атаки";
        this.additionalAttackDamage = ChatColor.RED + "[⚔] + " + ChatColor.GOLD + "% " + ChatColor.GRAY + "физическому урону";
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

    public void setAdditionalMovementSpeed(Integer additionalMovementSpeed) {
        this.additionalMovementSpeed = this.additionalMovementSpeed.replace(ChatColor.GOLD + "%", ChatColor.GRAY + additionalMovementSpeed.toString() + ChatColor.GOLD + "%");
    }

    public void setAdditionalHealth(Integer additionalHealth) {
        this.additionalHealth = this.additionalHealth.replace(ChatColor.GOLD + "%", ChatColor.GRAY + additionalHealth.toString() + ChatColor.GOLD + "%");
    }

    public void setAdditionalArmor(Integer additionalArmor) {
        this.additionalArmor = this.additionalArmor.replace(ChatColor.GOLD + "%", ChatColor.GRAY + additionalArmor.toString() + ChatColor.GOLD + "%");

    }

    public void setAdditionalAttackSpeed(Integer additionalAttackSpeed) {
        this.additionalAttackSpeed = this.additionalAttackSpeed.replace(ChatColor.GOLD + "%", ChatColor.GRAY + additionalAttackSpeed.toString() + ChatColor.GOLD + "%");

    }

    public void setAdditionalAttackDamage(Integer additionalAttackDamage) {
        this.additionalAttackDamage = this.additionalAttackDamage.replace(ChatColor.GOLD + "%", ChatColor.GRAY + additionalAttackDamage.toString() + ChatColor.GOLD + "%");

    }
}
