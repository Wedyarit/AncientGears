package Player;

import AncientGears.AncientGears;
import Commands.ItemEnum;
import Utilities.ItemConstructor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class CustomItemStack {
    private final Modifier modifiers;
    private final int itemLevel;
    private final int itemRarity;
    private Material material;
    private final HashMap<Material, Double> materialStats = new HashMap<>();

    public CustomItemStack(Modifier modifiers, int itemLevel, int itemRarity) {
        this.itemLevel = itemLevel;
        this.itemRarity = itemRarity;
        this.modifiers = modifiers;
    }

    public ItemStack getItem() {
        ItemEnum type = randomValue(ItemEnum.values());
        Material material = getRandomPiece(type, this.itemLevel);
        this.material = material;
        ItemStack item = new ItemConstructor(material)
                .amount(1)
                .loreAsList(getRandomLore(type, this.itemLevel, this.itemRarity))
                .flags(ItemFlag.HIDE_ATTRIBUTES)
                .build();
        ItemMeta meta = item.getItemMeta();

        AttributeModifier modifierMovementSpeed = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", (this.modifiers.getAdditionalMovementSpeed() / 100.D), AttributeModifier.Operation.ADD_SCALAR, getSlot(type));
        AttributeModifier modifierHealth = new AttributeModifier(UUID.randomUUID(), "generic.max_health", (this.modifiers.getAdditionalHealth() / 100.D), AttributeModifier.Operation.ADD_SCALAR, getSlot(type));
        AttributeModifier modifierArmor = new AttributeModifier(UUID.randomUUID(), "generic.armor", (this.modifiers.getAdditionalArmor() / 100.D), AttributeModifier.Operation.ADD_SCALAR, getSlot(type));
        AttributeModifier modifierAttackSpeed = new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", (this.modifiers.getAdditionalMovementSpeed() / 100.D), AttributeModifier.Operation.ADD_SCALAR, getSlot(type));
        AttributeModifier modifierAttackDamage = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", materialStats.get(this.material) * (1 + this.modifiers.getAdditionalAttackDamage() / 100.D), AttributeModifier.Operation.ADD_NUMBER, getSlot(type));

        if (modifiers.getAdditionalMovementSpeed() != 0)
            meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifierMovementSpeed);
        if (modifiers.getAdditionalHealth() != 0)
            meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifierHealth);
        if (modifiers.getAdditionalArmor() != 0)
            meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifierArmor);
        if (modifiers.getAdditionalAttackSpeed() != 0)
            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifierAttackSpeed);
        if (modifiers.getAdditionalAttackDamage() != 0)
            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifierAttackDamage);

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
        double randomMS = 0, randomHP = 0, randomAR = 0, randomAD = 0, randomAS = 0, randomRD = 0;
        int random = 0;

        int minHP = itemLevel / 8;
        int maxHP = itemLevel / 4;

        int minMS = itemLevel / 4;
        int maxMS = itemLevel / 2;

        int minAS = itemLevel / 4;
        int maxAS = itemLevel / 2;

        int minAD = itemLevel / 2;
        int maxAD = itemLevel;

        int minAR = itemLevel / 2;
        int maxAR = itemLevel * 2;

        int minRD = itemLevel / 2;
        int maxRD = itemLevel;

        // Да, тут нужно столько if'ов
        if (minMS == 0) minMS = 1;
        if (maxMS <= minMS) maxMS = minMS + 1;
        if (minHP == 0) minHP = 1;
        if (maxHP <= minHP) maxHP = minHP + 1;
        if (minAR == 0) minAR = 1;
        if (maxAR <= minAR) maxAR = minAR + 1;
        if (minAD == 0) minAD = 1;
        if (maxAD <= minAD) maxAD = minAD + 1;
        if (minAS == 0) minAS = 1;
        if (maxAS <= minAS) maxAS = minAS + 1;
        if (minRD == 0) minRD = 1;
        if (maxRD <= minRD) maxRD = minRD + 1;

        String itemLevelString = ChatColor.GRAY + "Уровень предмета: " + ChatColor.GOLD + itemLevel;
        String itemArmorString = "";
        String itemDamageString = "";
        String itemRangedDamageString = "";

        boolean isArmor = false;
        boolean isMelee = false;
        boolean isRanged = false;


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

        if (isArmor) itemArmorString = ChatColor.GRAY + "Защита: " + ChatColor.GOLD + materialStats.get(this.material);
        if (isMelee) itemDamageString = ChatColor.GRAY + "Урон: " + ChatColor.GOLD + materialStats.get(this.material);
        if (isRanged) itemRangedDamageString = ChatColor.GRAY + "Дистанционный урон: " + ChatColor.GOLD + materialStats.get(this.material);

        for (int i = 0; i < itemRarity; i++) {


            if (isArmor) {
                randomMS = ThreadLocalRandom.current().nextInt(minMS, maxMS);
                randomHP = ThreadLocalRandom.current().nextInt(minHP, maxHP);
                randomAR = ThreadLocalRandom.current().nextInt(minAR, maxAR);
                random = ThreadLocalRandom.current().nextInt(1, 4);
            }
            if (isMelee) {
                randomAD = ThreadLocalRandom.current().nextInt(minAD, maxAD);
                randomAS = ThreadLocalRandom.current().nextInt(minAS, maxAS);
                random = ThreadLocalRandom.current().nextInt(4, 6);
            }
            if (isRanged) {
                randomRD = ThreadLocalRandom.current().nextInt(minRD, maxRD);
                random = 6;
            }

            switch (random) {
                case 1: {
                    modifiers.addAdditionalHealth(randomHP);
                    break;
                } case 2: {
                    modifiers.addAdditionalArmor(randomAR);
                    itemArmorString = ChatColor.GRAY + "Защита: " + ChatColor.GOLD + new DecimalFormat("#0.0").format(materialStats.get(this.material) * (1 + (modifiers.getAdditionalArmor() / 100)));
                    break;
                } case 3: {
                    modifiers.addAdditionalMovementSpeed(randomMS); break;
                } case 4: {
                    modifiers.addAdditionalAttackDamage(randomAD);
                    itemDamageString = ChatColor.GRAY + "Урон: " + ChatColor.GOLD + new DecimalFormat("#0.0").format(materialStats.get(this.material) * (1 + (modifiers.getAdditionalAttackDamage() / 100)));
                    break;
                } case 5: {
                    modifiers.addAdditionalAttackSpeed(randomAS); break;
                } case 6: {
                    modifiers.addAdditionalRangedDamage(randomRD);
                    itemRangedDamageString = ChatColor.GRAY + "Дистанционный урон: " + ChatColor.GOLD + new DecimalFormat("#0.0").format(materialStats.get(this.material) * (1 + (modifiers.getAdditionalRangedDamage() / 100)));
                    break;
                }
            }
        }

        if (modifiers.getAdditionalMovementSpeed() != 0)
            lore.add(modifiers.getAdditionalMovementSpeedString());
        if (modifiers.getAdditionalHealth() != 0)
            lore.add(modifiers.getAdditionalHealthString());
        if (modifiers.getAdditionalArmor() != 0)
            lore.add(modifiers.getAdditionalArmorString());
        if (modifiers.getAdditionalAttackSpeed() != 0)
            lore.add(modifiers.getAdditionalAttackSpeedString());
        if (modifiers.getAdditionalAttackDamage() != 0)
            lore.add(modifiers.getAdditionalAttackDamageString());
        if (modifiers.getAdditionalRangedDamage() != 0)
            lore.add(modifiers.getAdditionalRangedDamageString());

        lore.add("");
        lore.add(itemLevelString);
        lore.add("");
        if (isArmor) lore.add(itemArmorString);
        else if (isMelee) {
            lore.add("");
            lore.add(itemDamageString);
        } else if (isRanged) {
            lore.add("");
            lore.add(itemRangedDamageString);
        }

        return lore;
    }

    private Material getRandomPiece(ItemEnum type, Integer itemLevel) {
        Material item = null;

        switch (type) {
            case HELMET: {
                if (itemLevel <= 10) {
                    item = Material.LEATHER_HELMET;
                    materialStats.put(item, 1.0D);
                } else if (itemLevel <= 20) {
                    item = Material.GOLDEN_HELMET;
                    materialStats.put(item, 2.0D);
                } else if (itemLevel <= 30) {
                    item = Material.CHAINMAIL_HELMET;
                    materialStats.put(item, 2.0D);
                } else if (itemLevel <= 40) {
                    item = Material.IRON_HELMET;
                    materialStats.put(item, 2.0D);
                } else if (itemLevel <= 50) {
                    item = Material.DIAMOND_HELMET;
                    materialStats.put(item, 3.0D);
                } else {
                    item = Material.NETHERITE_HELMET;
                    materialStats.put(item, 3.0D);
                }
                break;
            }
            case CHESTPLATE: {
                if (itemLevel <= 10) {
                    item = Material.LEATHER_CHESTPLATE;
                    materialStats.put(item, 3.0D);
                } else if (itemLevel <= 20) {
                    item = Material.GOLDEN_CHESTPLATE;
                    materialStats.put(item, 5.0D);
                } else if (itemLevel <= 30) {
                    item = Material.CHAINMAIL_CHESTPLATE;
                    materialStats.put(item, 5.0D);
                } else if (itemLevel <= 40) {
                    item = Material.IRON_CHESTPLATE;
                    materialStats.put(item, 6.0D);
                } else if (itemLevel <= 50) {
                    item = Material.DIAMOND_CHESTPLATE;
                    materialStats.put(item, 8.0D);
                } else {
                    item = Material.NETHERITE_CHESTPLATE;
                    materialStats.put(item, 8.0D);
                }
                break;
            }
            case LEGGINGS: {
                if (itemLevel <= 10) {
                    item = Material.LEATHER_LEGGINGS;
                    materialStats.put(item, 2.0D);
                } else if (itemLevel <= 20) {
                    item = Material.GOLDEN_LEGGINGS;
                    materialStats.put(item, 3.0D);
                } else if (itemLevel <= 30) {
                    item = Material.CHAINMAIL_LEGGINGS;
                    materialStats.put(item, 4.0D);
                } else if (itemLevel <= 40) {
                    item = Material.IRON_LEGGINGS;
                    materialStats.put(item, 5.0D);
                } else if (itemLevel <= 50) {
                    item = Material.DIAMOND_LEGGINGS;
                    materialStats.put(item, 6.0D);
                } else {
                    item = Material.NETHERITE_LEGGINGS;
                    materialStats.put(item, 6.0D);
                }
                break;

            }
            case BOOTS: {
                if (itemLevel <= 10) {
                    item = Material.LEATHER_BOOTS;
                    materialStats.put(item, 1.0D);
                } else if (itemLevel <= 20) {
                    item = Material.GOLDEN_BOOTS;
                    materialStats.put(item, 1.0D);
                } else if (itemLevel <= 30) {
                    item = Material.CHAINMAIL_BOOTS;
                    materialStats.put(item, 1.0D);
                } else if (itemLevel <= 40) {
                    item = Material.IRON_BOOTS;
                    materialStats.put(item, 2.0D);
                } else if (itemLevel <= 50) {
                    item = Material.DIAMOND_BOOTS;
                    materialStats.put(item, 3.0D);
                } else {
                    item = Material.NETHERITE_BOOTS;
                    materialStats.put(item, 3.0D);
                }
                break;

            }
            case SWORD: {
                if (itemLevel <= 10) {
                    item = Material.WOODEN_SWORD;
                    materialStats.put(item, 4.0D);
                } else if (itemLevel <= 20) {
                    item = Material.STONE_SWORD;
                    materialStats.put(item, 5.0D);
                } else if (itemLevel <= 30) {
                    item = Material.GOLDEN_SWORD;
                    materialStats.put(item, 4.0D);
                } else if (itemLevel <= 40) {
                    item = Material.IRON_SWORD;
                    materialStats.put(item, 6.0D);
                } else if (itemLevel <= 50) {
                    item = Material.DIAMOND_SWORD;
                    materialStats.put(item, 7.0D);
                } else {
                    item = Material.NETHERITE_SWORD;
                    materialStats.put(item, 8.0D);
                }
                break;
            }
            case AXE: {
                if (itemLevel <= 10) {
                    item = Material.WOODEN_AXE;
                    materialStats.put(item, 7.0D);
                } else if (itemLevel <= 20) {
                    item = Material.STONE_AXE;
                    materialStats.put(item, 9.0D);
                } else if (itemLevel <= 30) {
                    item = Material.GOLDEN_AXE;
                    materialStats.put(item, 7.0D);
                } else if (itemLevel <= 40) {
                    item = Material.IRON_AXE;
                    materialStats.put(item, 9.0D);
                } else if (itemLevel <= 50) {
                    item = Material.DIAMOND_AXE;
                    materialStats.put(item, 9.0D);
                } else {
                    item = Material.NETHERITE_AXE;
                    materialStats.put(item, 9.0D);
                }
                break;
            }
            case BOW: {
                item = Material.BOW;
                materialStats.put(item, 9.0D);
                break;
            }
            case CROSSBOW: {
                item = Material.CROSSBOW;
                materialStats.put(item, 9.0D);
                break;
            }
        }
        return item;
    }
}