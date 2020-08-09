package Player;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Modifier {
    private Double additionalMovementSpeed = 0.0D;
    private Double additionalHealth = 0.0D;
    private Double additionalArmor = 0.0D;
    private Double additionalAttackSpeed = 0.0D;
    private Double additionalAttackDamage = 0.0D;
    private Double additionalRangedDamage = 0.0D;

    private Integer additionalMovementSpeedPC = 0;
    private Integer additionalHealthPC = 0;
    private Integer additionalArmorPC = 0;
    private Integer additionalAttackSpeedPC = 0;
    private Integer additionalAttackDamagePC = 0;
    private Integer additionalRangedDamagePC = 0;

    public Modifier() {

    }

    public String getAdditionalMovementSpeedString() {
        StringBuilder PC = new StringBuilder();
        for (int i = 0; i < additionalMovementSpeedPC; i++)
            PC.append("☆");
        return ChatColor.GOLD + "+" + additionalMovementSpeed + "% " + ChatColor.GRAY + "к скорости передвижения " + PC;
    }

    public String getAdditionalHealthString() {
        StringBuilder PC = new StringBuilder();
        for (int i = 0; i < additionalHealthPC; i++)
            PC.append("☆");
        return ChatColor.GOLD + "+" + additionalHealth + "% " + ChatColor.GRAY + "к максимальному здоровью " + PC;
    }

    public String getAdditionalArmorString() {
        StringBuilder PC = new StringBuilder();
        for (int i = 0; i < additionalArmorPC; i++)
            PC.append("☆");
        return ChatColor.GOLD + "+" +  additionalArmor + "% " + ChatColor.GRAY + "к физической защите " + PC;
    }

    public String getAdditionalAttackSpeedString() {
        StringBuilder PC = new StringBuilder();
        for (int i = 0; i < additionalAttackSpeedPC; i++)
            PC.append("☆");
        return ChatColor.GOLD + "+" +  additionalAttackSpeed + "% " + ChatColor.GRAY + "к скорости атаки " + PC;
    }

    public String getAdditionalAttackDamageString() {
        StringBuilder PC = new StringBuilder();
        for (int i = 0; i < additionalAttackDamagePC; i++)
            PC.append("☆");
        return ChatColor.GOLD + "+" +  additionalAttackDamage + "% " + ChatColor.GRAY + "к физическому урону " + PC;
    }

    public String getAdditionalRangedDamageString() {
        StringBuilder PC = new StringBuilder();
        for (int i = 0; i < additionalRangedDamagePC; i++)
            PC.append("☆");
        return ChatColor.GOLD + "+" +  additionalRangedDamage + "% " + ChatColor.GRAY + "к дистанционному урону " + PC;
    }

    public Double getAdditionalMovementSpeed() {
        return additionalMovementSpeed;
    }

    public Double getAdditionalHealth() {
        return additionalHealth;
    }

    public Double getAdditionalArmor() {
        return additionalArmor;
    }

    public Double getAdditionalAttackDamage() {
        return additionalAttackDamage;
    }

    public Double getAdditionalAttackSpeed() {
        return additionalAttackSpeed;
    }

    public Double getAdditionalRangedDamage() {return additionalRangedDamage; }

    public void setAdditionalMovementSpeed(Double additionalMovementSpeed) {
        this.additionalMovementSpeed = additionalMovementSpeed;
    }

    public void setAdditionalHealth(Double additionalHealth) {
        this.additionalHealth = additionalHealth;
    }

    public void setAdditionalArmor(Double additionalArmor) {
        this.additionalArmor = additionalArmor;
    }

    public void setAdditionalAttackDamage(Double additionalAttackDamage) {
        this.additionalAttackDamage = additionalAttackDamage;
    }

    public void setAdditionalAttackSpeed(Double additionalAttackSpeed) {
        this.additionalAttackSpeed = additionalAttackSpeed;
    }

    public void setAdditionalRangedDamage(Double additionalRangedDamage) {
        this.additionalRangedDamage = additionalRangedDamage;
    }

    public void addAdditionalMovementSpeed(Double additionalMovementSpeed) {
        additionalMovementSpeedPC++;
        this.additionalMovementSpeed += additionalMovementSpeed;
    }

    public void addAdditionalHealth(Double additionalHealth) {
        additionalHealthPC++;
        this.additionalHealth += additionalHealth;
    }

    public void addAdditionalArmor(Double additionalArmor) {
        additionalArmorPC++;
        this.additionalArmor += additionalArmor;
    }

    public void addAdditionalAttackDamage(Double additionalAttackDamage) {
        additionalAttackDamagePC++;
        this.additionalAttackDamage += additionalAttackDamage;
    }

    public void addAdditionalAttackSpeed(Double additionalAttackSpeed) {
        additionalAttackSpeedPC++;
        this.additionalAttackSpeed += additionalAttackSpeed;
    }

    public void addAdditionalRangedDamage(Double additionalRangedDamage) {
        additionalRangedDamagePC++;
        this.additionalRangedDamage += additionalRangedDamage;
    }


}
