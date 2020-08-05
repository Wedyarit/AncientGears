package AncientGears;

import Gathering.Ore.OreItems;
import Gathering.ResourceManager;
import Listeners.GatheringListener;
import Listeners.GuiListener;
import Listeners.InventoryListener;
import Utilities.Command;
import org.bukkit.plugin.java.JavaPlugin;

public final class AncientGears extends JavaPlugin {
    public static AncientGears instance;

    @Override
    public void onEnable() {
        AncientGears.instance = this;
        getLogger().info("[AncientGears] Plugin was enabled!");

        this.getCommand("kit").setExecutor(new Command());

        registerListeners();
    }

    @Override
    public void onDisable() {
        System.out.println("[AncientGears] Plugin was disabled!");
    }

    public static AncientGears getInstance() {
        return AncientGears.instance;
    }

    public void registerListeners() {
        new GuiListener();
        new InventoryListener();
        new GatheringListener();
        new ResourceManager();
    }
}
