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
        for (CustomLocation location : LocationsManager.getInstance().getlocationArrayList()) {
            if (location.isInLocation(player)) {
                if (!location.isAlreadyBeenInLocation(player)) {
                    player.sendTitle("Локация обновлена", ChatColor.GOLD + location.getName(), 20, 25, 20);
                    player.playSound(player.getLocation(), Sound.BLOCK_BELL_USE, 10, 1);
                    location.addPlayer(player);
                    return;
                }
            }
        }
        for (CustomLocation location : LocationsManager.getInstance().getlocationArrayList()) {
            if (!location.isInLocation(player)) {
                if (location.isAlreadyBeenInLocation(player)) {
                    player.sendTitle("Локация обновлена", ChatColor.GOLD + "Неизведованные земли", 20, 25, 20);
                    player.playSound(player.getLocation(), Sound.BLOCK_BELL_USE, 10, 1);
                    location.removePlayer(player);
                    return;
                }
            }
        }
    }
}
