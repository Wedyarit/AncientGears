package Utilities;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class ItemConstructor {
    private Material material;
    private int amount = 1;
    private short durability = 0;

    private String displayName;
    private ChatColor color;
    private List<String> lore;
    private ItemFlag[] flags;
    private Map<Enchantment, Integer> enchantments = new HashMap<>();

    public ItemConstructor(Material material) {
        this.material = material;
    }

    public ItemConstructor amount(int amount) {
        this.amount = amount;

        return this;
    }

    public ItemConstructor displayName(String name) {
        this.displayName = name;

        return this;
    }

    public ItemConstructor durability(int durability) {
        this.durability = (short) durability;

        return this;
    }

    public ItemConstructor lore(String... lore) {
        this.lore = new ArrayList<>(Arrays.asList(lore));

        return this;
    }

    public ItemConstructor loreAsList(List<String> lore) {
        this.lore = lore;
        return this;
    }

    public ItemConstructor flags(ItemFlag... flags) {
        this.flags = flags;

        return this;
    }

    public ItemConstructor enchantment(Enchantment enchantment, int level) {
        this.enchantments.put(enchantment, level);

        return this;
    }

    public ItemStack build() {
        if (this.material == null)
            throw new IllegalArgumentException("Отсутствует материал");

        ItemStack itemStack = new ItemStack(this.material, this.amount);

        ItemMeta itemMeta = itemStack.getItemMeta();
        if (this.displayName != null )
            itemMeta.setDisplayName(this.displayName);
        if (this.lore != null)
            itemMeta.setLore(this.lore);
        if (this.flags != null)
            itemMeta.addItemFlags(this.flags);
        itemStack.setItemMeta(itemMeta);
        if (this.enchantments != null)
            itemStack.addUnsafeEnchantments(this.enchantments);

        return itemStack;
    }

}
