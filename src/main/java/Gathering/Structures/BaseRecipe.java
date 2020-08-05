package Gathering.Structures;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collection;

public class BaseRecipe {
    private final ArrayList<ItemStack> need;
    private final ItemStack result;
    private final Integer resultCount;

    public BaseRecipe(ArrayList<ItemStack> need, ItemStack result, Integer resultCount) {
        this.need = need;
        this.result = result;
        this.resultCount = resultCount;
    }

    public void removeItem(ItemStack item) {
        this.need.remove(item);
    }

    public ArrayList<ItemStack> getNeed() {
        return need;
    }

    public ItemStack getResult() {
        return result;
    }

    public Integer getResultCount() {
        return resultCount;
    }
}
