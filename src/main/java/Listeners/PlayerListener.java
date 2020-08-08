package Listeners;

import Event.ClassesNOTWORKING.RpgPlayer;
import Event.ClassesNOTWORKING.RpgPlayerManager;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener extends BaseListener {

    @EventHandler(priority = EventPriority.MONITOR)
    private void onDamage(EntityDamageByEntityEvent e) {
        Entity damaged = e.getEntity();
        if (damaged instanceof Player) {
            if (RpgPlayerManager.getInstance().isRpgPlayer((Player) damaged)) {
                RpgPlayer player = RpgPlayerManager.getInstance().getPlayer((Player) damaged);
            }
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    private void onInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (e.getItem().equals(Material.BLAZE_ROD)) {

        }
    }

    @EventHandler(priority = EventPriority.LOW)
    private void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if (!RpgPlayerManager.getInstance().isRpgPlayer(player)) {
            RpgPlayer rpgPlayer = new RpgPlayer(player, "none");
        }
    }

}
