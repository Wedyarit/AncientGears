package Utilities;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


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

    public Inventory bulid() {
        return this.gui;
    }

}
