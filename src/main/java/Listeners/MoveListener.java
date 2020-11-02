package Listeners;

import Locations.CustomLocation;
import Locations.LocationsManager;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveListener extends BaseListener {

    @EventHandler(priority = EventPriority.LOW)
    public void onMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        CustomLocation.updateLocation(player);
    }
}