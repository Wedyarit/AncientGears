package Event.NotEvenWork;

import Utilities.BannerConstructor;
import Utilities.ItemConstructor;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.PatternType;
import org.bukkit.inventory.ItemStack;

public class ModifierItems {
    private static final String rarityCommon = ChatColor.GRAY + "Обычный";
    private static final String rarityRare = ChatColor.BLUE + "Редкий";
    private static final String rarityLegendary = ChatColor.GOLD + "Легендарный";

    private int additionalHealthModifier;
    private int additionalMeleeDamageModifier;
    private int additionalRangedDamageModifier;
    private int additionalMovementSpeedModifier;
    private int additionalArmorModifier;
    private int modifierAmount;


    // additionalMeleeDamageModifier
    public static final ItemStack additionalHealthModifierItemCommon = new ItemConstructor(Material.WOODEN_SWORD)
            .amount(1)
            .displayName("Модификатор: Урон в ближнем бою")
            .lore(ChatColor.GRAY + "Урон в ближнем бою +10%", rarityCommon)
            .build();

    public static ItemStack additionalHealthModifierItemRare = new ItemConstructor(Material.IRON_SWORD)
            .amount(1)
            .displayName("Модификатор: Урон в ближнем бою")
            .lore(ChatColor.GRAY + "Урон в ближнем бою +20%", rarityRare)
            .build();

    public static ItemStack additionalHealthModifierItemLegendary = new ItemConstructor(Material.DIAMOND_SWORD)
            .amount(1)
            .displayName("Модификатор: Урон в ближнем бою")
            .lore(ChatColor.GRAY + "Урон в ближнем бою +30%", rarityLegendary)
            .build();

    // additionalHealthModifier
    public static ItemStack additionalMeleeDamageModifierItemCommon = new BannerConstructor(Material.WHITE_BANNER)
            .amount(1)
            .addPattern(PatternType.CROSS, DyeColor.RED)
            .displayName("Модификатор: Дополнительное Здоровье")
            .lore(ChatColor.GRAY + "Дополнительное Здоровье +10%", rarityCommon)
            .build();

    public static ItemStack additionalMeleeDamageModifierItemRare = new BannerConstructor(Material.WHITE_BANNER)
            .amount(1)
            .addPattern(PatternType.CROSS, DyeColor.RED)
            .addPattern(PatternType.TRIANGLE_BOTTOM, DyeColor.RED)
            .displayName("Модификатор: Дополнительное Здоровье")
            .lore(ChatColor.GRAY + "Дополнительное Здоровье +20%", rarityRare)
            .build();

    public static ItemStack additionalMeleeDamageModifierItemLegendary = new BannerConstructor(Material.WHITE_BANNER)
            .amount(1)
            .addPattern(PatternType.CROSS, DyeColor.RED)
            .addPattern(PatternType.TRIANGLE_BOTTOM, DyeColor.RED)
            .addPattern(PatternType.TRIANGLE_TOP, DyeColor.RED)
            .displayName("Модификатор: Дополнительное Здоровье")
            .lore(ChatColor.GRAY + "Дополнительное Здоровье +30%", rarityLegendary)
            .build();



}
