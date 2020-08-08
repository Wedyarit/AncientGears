package Commands;

import Event.Events.ArmorType;
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
                ItemStack item = new ItemConstructor(getRandomPiece(randomNum))
                        .amount(1)
                        .displayName("TEST")
                        .loreAsList(getRandomLore(randomNum, 2))
                        .build();
                player.getInventory().addItem(item);
            }
        }
        return true;
    }

    public static <T extends Enum<?>> T randomEnum(Class<T> clazz) {
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    private Material getRandomPiece(Integer itemLevel) {
        Material item = null;
        ItemEnum randomPieceType = randomEnum(ItemEnum.class);

        switch (randomPieceType) {
            case HELMET: {
                if (itemLevel < 10)
                    item = Material.LEATHER_HELMET;
                else if (itemLevel > 10 && itemLevel < 20)
                    item = Material.GOLDEN_HELMET;
                else if (itemLevel > 20 && itemLevel < 30)
                    item = Material.CHAINMAIL_HELMET;
                else if (itemLevel > 30 && itemLevel < 40)
                    item = Material.IRON_HELMET;
                else if (itemLevel > 40 && itemLevel < 50)
                    item = Material.DIAMOND_HELMET;
                else if (itemLevel > 50)
                    item = Material.NETHERITE_HELMET;
            }
            case CHESTPLATE: {
                if (itemLevel < 10)
                    item = Material.LEATHER_CHESTPLATE;
                else if (itemLevel > 10 && itemLevel < 20)
                    item = Material.GOLDEN_CHESTPLATE;
                else if (itemLevel > 20 && itemLevel < 30)
                    item = Material.CHAINMAIL_CHESTPLATE;
                else if (itemLevel > 30 && itemLevel < 40)
                    item = Material.IRON_CHESTPLATE;
                else if (itemLevel > 40 && itemLevel < 50)
                    item = Material.DIAMOND_CHESTPLATE;
                else if (itemLevel > 50)
                    item = Material.NETHERITE_CHESTPLATE;
            }
            case LEGGINGS: {
                if (itemLevel < 10)
                    item = Material.LEATHER_LEGGINGS;
                else if (itemLevel > 10 && itemLevel < 20)
                    item = Material.GOLDEN_LEGGINGS;
                else if (itemLevel > 20 && itemLevel < 30)
                    item = Material.CHAINMAIL_LEGGINGS;
                else if (itemLevel > 30 && itemLevel < 40)
                    item = Material.IRON_LEGGINGS;
                else if (itemLevel > 40 && itemLevel < 50)
                    item = Material.DIAMOND_LEGGINGS;
                else if (itemLevel > 50)
                    item = Material.NETHERITE_LEGGINGS;

            }
            case BOOTS: {
                if (itemLevel < 10)
                    item = Material.LEATHER_BOOTS;
                else if (itemLevel > 10 && itemLevel < 20)
                    item = Material.GOLDEN_BOOTS;
                else if (itemLevel > 20 && itemLevel < 30)
                    item = Material.CHAINMAIL_BOOTS;
                else if (itemLevel > 30 && itemLevel < 40)
                    item = Material.IRON_BOOTS;
                else if (itemLevel > 40 && itemLevel < 50)
                    item = Material.DIAMOND_BOOTS;
                else if (itemLevel > 50)
                    item = Material.NETHERITE_BOOTS;

            }
            case SWORD: {
                if (itemLevel < 10)
                    item = Material.WOODEN_SWORD;
                else if (itemLevel > 10 && itemLevel < 20)
                    item = Material.STONE_SWORD;
                else if (itemLevel > 20 && itemLevel < 30)
                    item = Material.GOLDEN_SWORD;
                else if (itemLevel > 30 && itemLevel < 40)
                    item = Material.IRON_SWORD;
                else if (itemLevel > 40 && itemLevel < 50)
                    item = Material.DIAMOND_SWORD;
                else if (itemLevel > 50)
                    item = Material.NETHERITE_SWORD;
            }
            case AXE: {
                if (itemLevel < 10)
                    item = Material.WOODEN_AXE;
                else if (itemLevel > 10 && itemLevel < 20)
                    item = Material.STONE_AXE;
                else if (itemLevel > 20 && itemLevel < 30)
                    item = Material.GOLDEN_AXE;
                else if (itemLevel > 30 && itemLevel < 40)
                    item = Material.IRON_AXE;
                else if (itemLevel > 40 && itemLevel < 50)
                    item = Material.DIAMOND_AXE;
                else if (itemLevel > 50)
                    item = Material.NETHERITE_AXE;
            }
            case BOW: {
                item = Material.BOW;
            }
            case CROSSBOW: {
                item = Material.CROSSBOW;
            }
        }
        return item;
    }

    private List<String> getRandomLore(Integer itemLevel, Integer itemRarity) {
        List<String> lore = new ArrayList<>();
        int min = itemLevel * 4;
        int max = itemLevel * 8;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max);
        String itemLevelString = ChatColor.GRAY + "Уровень предмета: " + ChatColor.GOLD + itemLevel;

        Modifier modifier = new Modifier();
        for (int i = 0; i < itemRarity; i++) {
            int random = ThreadLocalRandom.current().nextInt(1, 5);
            switch (random) {
                case 1: {
                    modifier.addAdditionalHealth(randomNum);
                    break;
                }
                case 2: {
                    modifier.addAdditionalArmor(randomNum);
                    break;
                }
                case 3: {
                    modifier.addAdditionalAttackDamage(randomNum);
                    break;
                }
                case 4: {
                    modifier.addAdditionalAttackSpeed(randomNum);
                    break;
                }
                case 5: {
                    modifier.addAdditionalMovementSpeed(randomNum);
                    break;
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
