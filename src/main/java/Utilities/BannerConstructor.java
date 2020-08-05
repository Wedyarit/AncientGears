package Utilities;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BannerConstructor {
    private Material banner;
    private int amount = 1;
    private String displayName = "Баннер";
    private List<String> lore;
    List<Pattern> patterns = new ArrayList<Pattern>();

    public BannerConstructor(Material banner) {
        this.banner = banner;
    }

    public BannerConstructor amount(int amount) {
        this.amount = amount;

        return this;
    }

    public BannerConstructor addPattern(PatternType patternType, DyeColor color) {
        patterns.add(new Pattern(color, patternType));

        return this;
    }

    public BannerConstructor displayName(String name) {
        this.displayName = displayName;

        return this;
    }

    public BannerConstructor lore(String... lore) {
        this.lore = new ArrayList<>(Arrays.asList(lore));

        return this;
    }

    public ItemStack build() {
        ItemStack itemStack = new ItemStack(this.banner, this.amount);
        BannerMeta itemMeta = (BannerMeta)itemStack.getItemMeta();
        if (!(patterns.isEmpty())) itemMeta.setPatterns(patterns);
        if (!displayName.equals("Баннер")) itemMeta.setDisplayName(displayName);
        if (lore != null) itemMeta.setLore(this.lore);

        return itemStack;
    }
}
