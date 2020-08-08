package Commands;

import Player.Modifier;
import Utilities.ItemConstructor;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CommandTest implements CommandExecutor {
    private static final SecureRandom random = new SecureRandom();

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            for (int i = 0; i < 10; i++) {
                int randomNum = ThreadLocalRandom.current().nextInt(1, 60);
                ItemEnum randomPieceType = randomValue(ItemEnum.values());
                ItemStack item = new ItemConstructor(getRandomPiece(randomPieceType, randomNum))
                        .amount(1)
                        .loreAsList(getRandomLore(randomPieceType, randomNum, 2))
                        .build();
                player.getInventory().addItem(item);
            }
        }
        return true;
    }

    <T> T randomValue(T[] values) {
        return values[ThreadLocalRandom.current().nextInt(values.length)];
    }

    private Material getRandomPiece(ItemEnum type, Integer itemLevel) {
        Material item = null;

        switch (type) {
            case HELMET: {
                if (itemLevel <= 10)
                    item = Material.LEATHER_HELMET;
                else if (itemLevel <= 20)
                    item = Material.GOLDEN_HELMET;
                else if (itemLevel <= 30)
                    item = Material.CHAINMAIL_HELMET;
                else if (itemLevel <= 40)
                    item = Material.IRON_HELMET;
                else if (itemLevel <= 50)
                    item = Material.DIAMOND_HELMET;
                else
                    item = Material.NETHERITE_HELMET;
                break;
            }
            case CHESTPLATE: {
                if (itemLevel <= 10)
                    item = Material.LEATHER_CHESTPLATE;
                else if (itemLevel <= 20)
                    item = Material.GOLDEN_CHESTPLATE;
                else if (itemLevel <= 30)
                    item = Material.CHAINMAIL_CHESTPLATE;
                else if (itemLevel <= 40)
                    item = Material.IRON_CHESTPLATE;
                else if (itemLevel <= 50)
                    item = Material.DIAMOND_CHESTPLATE;
                else
                    item = Material.NETHERITE_CHESTPLATE;
                break;
            }
            case LEGGINGS: {
                if (itemLevel <= 10)
                    item = Material.LEATHER_LEGGINGS;
                else if (itemLevel <= 20)
                    item = Material.GOLDEN_LEGGINGS;
                else if (itemLevel <= 30)
                    item = Material.CHAINMAIL_LEGGINGS;
                else if (itemLevel <= 40)
                    item = Material.IRON_LEGGINGS;
                else if (itemLevel <= 50)
                    item = Material.DIAMOND_LEGGINGS;
                else
                    item = Material.NETHERITE_LEGGINGS;
                break;

            }
            case BOOTS: {
                if (itemLevel <= 10)
                    item = Material.LEATHER_BOOTS;
                else if (itemLevel <= 20)
                    item = Material.GOLDEN_BOOTS;
                else if (itemLevel <= 30)
                    item = Material.CHAINMAIL_BOOTS;
                else if (itemLevel <= 40)
                    item = Material.IRON_BOOTS;
                else if (itemLevel <= 50)
                    item = Material.DIAMOND_BOOTS;
                else
                    item = Material.NETHERITE_BOOTS;
                break;

            }
            case SWORD: {
                if (itemLevel <= 10)
                    item = Material.WOODEN_SWORD;
                else if (itemLevel <= 20)
                    item = Material.STONE_SWORD;
                else if (itemLevel <= 30)
                    item = Material.GOLDEN_SWORD;
                else if (itemLevel <= 40)
                    item = Material.IRON_SWORD;
                else if (itemLevel <= 50)
                    item = Material.DIAMOND_SWORD;
                else
                    item = Material.NETHERITE_SWORD;
                break;
            }
            case AXE: {
                if (itemLevel <= 10)
                    item = Material.WOODEN_AXE;
                else if (itemLevel <= 20)
                    item = Material.STONE_AXE;
                else if (itemLevel <= 30)
                    item = Material.GOLDEN_AXE;
                else if (itemLevel <= 40)
                    item = Material.IRON_AXE;
                else if (itemLevel <= 50)
                    item = Material.DIAMOND_AXE;
                else
                    item = Material.NETHERITE_AXE;
                break;
            }
            case BOW: {
                item = Material.BOW;
                break;
            }
            case CROSSBOW: {
                item = Material.CROSSBOW;
                break;
            }
        }
        return item;
    }

    private List<String> getRandomLore(ItemEnum type, Integer itemLevel, Integer itemRarity) {
        List<String> lore = new ArrayList<>();
        int min = itemLevel;
        int max = itemLevel * 2;
        String itemLevelString = ChatColor.GRAY + "Уровень предмета: " + ChatColor.GOLD + itemLevel;

        boolean isArmor = false;
        boolean isMelee = false;
        boolean isRanged = false;

        Modifier modifier = new Modifier();
        switch (type) {
            case HELMET:
            case CHESTPLATE:
            case LEGGINGS:
            case BOOTS:
                isArmor = true;
                break;

            case SWORD:
            case AXE:
                isMelee = true;
                break;

            case BOW:
            case CROSSBOW:
                isRanged = true;
                break;
        }

        for (int i = 0; i < itemRarity; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(min, max);
            int random = ThreadLocalRandom.current().nextInt(1, 5);
            switch (random) {
                case 1: {
                    if (isArmor) {
                        modifier.addAdditionalHealth(randomNum);
                        break;
                    }
                }
                case 2: {
                    if (isArmor) {
                        modifier.addAdditionalArmor(randomNum);
                        break;
                    }
                }
                case 3: {
                    if (isMelee || isRanged) {
                        modifier.addAdditionalAttackDamage(randomNum);
                        break;
                    }
                }
                case 4: {
                    if (isMelee || isRanged) {
                        modifier.addAdditionalAttackSpeed(randomNum);
                        break;
                    }
                }
                case 5: {
                    if (isArmor) {
                        modifier.addAdditionalMovementSpeed(randomNum);
                        break;
                    }
                }
            }
        }
        if (modifier.getAdditionalMovementSpeed() != 0)
            lore.add(modifier.getAdditionalMovementSpeedString());
        if (modifier.getAdditionalHealth() != 0)
            lore.add(modifier.getAdditionalHealthString());
        if (modifier.getAdditionalArmor() != 0)
            lore.add(modifier.getAdditionalArmorString());
        if (modifier.getAdditionalAttackSpeed() != 0)
            lore.add(modifier.getAdditionalAttackSpeedString());
        if (modifier.getAdditionalAttackDamage() != 0)
            lore.add(modifier.getAdditionalAttackDamageString());
        lore.add("");
        lore.add(itemLevelString);
        return lore;
    }
}
