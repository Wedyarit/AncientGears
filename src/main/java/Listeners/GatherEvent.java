package Listeners;

import Gather.Resources.Resource;
import Gather.Tools.Tool;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GatherEvent extends Event implements Cancellable {

    private final Player player;
    private final Resource resource;
    private final Tool tool;
    private static final  HandlerList HANDLERS = new HandlerList();
    private  boolean isCancelled;

    public GatherEvent(Player player, Resource resource, Tool tool) {
        this.player = player;
        this.resource = resource;
        this.tool = tool;
    }

    public Player getPlayer() {
        return player;
    }

    public Tool getTool() {
        return tool;
    }

    public Resource getResource() {
        return resource;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlersList() {
        return HANDLERS;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        isCancelled = b;
    }
}
