package Player;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Modifier {
    private Integer additionalMovementSpeed = 0;
    private Integer additionalHealth = 0;
    private Integer additionalArmor = 0;
    private Integer additionalAttackSpeed = 0;
    private Integer additionalAttackDamage = 0;

    private Integer additionalMovementSpeedPC = 0;
    private Integer additionalHealthPC = 0;
    private Integer additionalArmorPC = 0;
    private Integer additionalAttackSpeedPC = 0;
    private Integer additionalAttackDamagePC = 0;

    public Modifier() {

    }

    public String getAdditionalMovementSpeedString() {
        StringBuilder PC = new StringBuilder();
        for (int i = 0; i < additionalMovementSpeedPC; i++)
            PC.append("☆");
        return ChatColor.GOLD + "" + additionalMovementSpeed + "% " + ChatColor.GRAY + "к скорости передвижения " + PC;
    }

    public String getAdditionalHealthString() {
        StringBuilder PC = new StringBuilder();
        for (int i = 0; i < additionalHealthPC; i++)
            PC.append("☆");
        return ChatColor.GOLD + "" + additionalHealth + "% " + ChatColor.GRAY + "к максимальному здоровью " + PC;
    }

    public String getAdditionalArmorString() {
        StringBuilder PC = new StringBuilder();
        for (int i = 0; i < additionalArmorPC; i++)
            PC.append("☆");
        return ChatColor.GOLD + "" +  additionalArmor + "% " + ChatColor.GRAY + "к физической защите " + PC;
    }

    public String getAdditionalAttackSpeedString() {
        StringBuilder PC = new StringBuilder();
        for (int i = 0; i < additionalAttackSpeedPC; i++)
            PC.append("☆");
        return ChatColor.GOLD + "" +  additionalAttackSpeed + "% " + ChatColor.GRAY + "к скорости атаки " + PC;
    }

    public String getAdditionalAttackDamageString() {
        StringBuilder PC = new StringBuilder();
        for (int i = 0; i < additionalAttackDamagePC; i++)
            PC.append("☆");
        return ChatColor.GOLD + "" +  additionalAttackDamage + "% " + ChatColor.GRAY + "к физическому урону " + PC;
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
        additionalMovementSpeedPC++;
        this.additionalMovementSpeed += additionalMovementSpeed;
    }

    public void addAdditionalHealth(Integer additionalHealth) {
        additionalHealthPC++;
        this.additionalHealth += additionalHealth;
    }

    public void addAdditionalArmor(Integer additionalArmor) {
        additionalArmorPC++;
        this.additionalArmor += additionalArmor;
    }

    public void addAdditionalAttackDamage(Integer additionalAttackDamage) {
        additionalAttackDamagePC++;
        this.additionalAttackDamage += additionalAttackDamage;
    }

    public void addAdditionalAttackSpeed(Integer additionalAttackSpeed) {
        additionalAttackSpeedPC++;
        this.additionalAttackSpeed += additionalAttackSpeed;
    }


}
