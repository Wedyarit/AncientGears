package Utilities;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;


public class GuiConstructor {
    private Inventory gui;
    private int slot = 0;

    public GuiConstructor(Integer size, String name) {
        this.gui = Bukkit.createInventory(null, size, name);
    }

    public GuiConstructor setItems(ItemStack... items) {
        for (ItemStack item : items) {
            this.gui.setItem(slot, item);
            slot++;
        }
        return this;
    }

    public GuiConstructor setItem(HashMap<Integer, ItemStack> integerItemStackHashMap) {
        for (int integer : integerItemStackHashMap.keySet())
            gui.setItem(integer, integerItemStackHashMap.get(integer));
        return this;
    }

    public GuiConstructor fillSlots(ItemStack itemStack) {
        for (int i = 0; i < gui.getSize(); i++)
            gui.setItem(i, itemStack);
        return this;
    }

    public Inventory bulid() {
        return this.gui;
    }

}
