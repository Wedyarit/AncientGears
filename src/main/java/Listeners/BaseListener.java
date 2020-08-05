package Listeners;

import AncientGears.AncientGears;
import org.bukkit.event.Listener;

public abstract class BaseListener implements Listener {
    public BaseListener() {
        this.registerEvents();
    }

    private void registerEvents() {
        AncientGears.getInstance().getServer().getPluginManager().registerEvents(this, AncientGears.getInstance());
    }
}
