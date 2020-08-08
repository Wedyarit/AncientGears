package Player;

import Commands.ItemEnum;
import Utilities.ItemConstructor;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class CustomItemStack {
    private final Modifier modifiers;
    private Material material;
    private final int itemLevel;
    private final int itemRarity;

    public CustomItemStack(Modifier modifiers, int itemLevel, int itemRarity) {
        this.itemLevel = itemLevel;
        this.itemRarity = itemRarity;
        this.modifiers = modifiers;
    }



    public ItemStack getItem() {
        ItemEnum type = randomValue(ItemEnum.values());
        ItemStack item = new ItemConstructor(getRandomPiece(type, this.itemLevel))
                .amount(1)
                .loreAsList(getRandomLore(type, this.itemLevel, this.itemRarity))
                .build();
        ItemMeta meta = item.getItemMeta();
        double bat = 4.0D;
        double damage = 1.0;
        if (type == ItemEnum.AXE) {
            damage = 6.0D;
            bat = 1.0D;
        }
        if (type == ItemEnum.SWORD) {
            damage = 9.0D;
            bat = 1.6D;
        }


        AttributeModifier modifierMovementSpeed = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1D * (this.modifiers.getAdditionalMovementSpeed() / 100.D), AttributeModifier.Operation.ADD_NUMBER, getSlot(type));
        AttributeModifier modifierHealth = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20.0D * (this.modifiers.getAdditionalHealth() / 100.D), AttributeModifier.Operation.ADD_NUMBER, getSlot(type));
        AttributeModifier modifierArmor = new AttributeModifier(UUID.randomUUID(), "generic.armor", 0.1D * (this.modifiers.getAdditionalArmor() / 100.D), AttributeModifier.Operation.ADD_NUMBER, getSlot(type));
        AttributeModifier modifierAttackSpeed = new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", bat * (this.modifiers.getAdditionalMovementSpeed() / 100.D), AttributeModifier.Operation.ADD_NUMBER, getSlot(type));
        AttributeModifier modifierAttackDamage = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", damage * (this.modifiers.getAdditionalAttackDamage() / 100.D), AttributeModifier.Operation.ADD_NUMBER, getSlot(type));

        if (modifiers.getAdditionalMovementSpeed() != 0)
        meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED,modifierMovementSpeed);
        if (modifiers.getAdditionalHealth() != 0)
        meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH,modifierHealth);
        if (modifiers.getAdditionalArmor() != 0)
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR,modifierArmor);
        if (modifiers.getAdditionalAttackSpeed() != 0)
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED,modifierAttackSpeed);
        if (modifiers.getAdditionalAttackDamage() != 0)
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,modifierAttackDamage);

        item.setItemMeta(meta);
        return item;
    }

    private EquipmentSlot getSlot(ItemEnum type) {
        switch (type) {
            case SWORD:
            case AXE:
            case BOW:
            case CROSSBOW:
                return EquipmentSlot.HAND;
            case HELMET:
                return EquipmentSlot.HEAD;
            case CHESTPLATE:
                return EquipmentSlot.CHEST;
            case LEGGINGS:
                return EquipmentSlot.LEGS;
            case BOOTS:
                return EquipmentSlot.FEET;

        }
        return null;
    }
    <T> T randomValue(T[] values) {
        return values[ThreadLocalRandom.current().nextInt(values.length)];
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
}
