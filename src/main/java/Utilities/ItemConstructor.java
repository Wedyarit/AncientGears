package Utilities;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class ItemConstructor {
    protected Material material;
    protected int amount = 1;
    protected short durability = 0;

    protected String displayName;
    protected ChatColor color;
    protected List<String> lore;
    protected ItemFlag[] flags;
    protected Map<Enchantment, Integer> enchantments = new HashMap<>();

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
