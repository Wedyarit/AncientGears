package Listeners;

import Event.ClassesNOTWORKING.RpgPlayer;
import Event.ClassesNOTWORKING.RpgPlayerManager;
import Event.Events.ArmorEquipEvent;
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

    @EventHandler
    public void equip(ArmorEquipEvent e) {
        System.out.println("ArmorEquipEvent - " + e.getMethod());
        System.out.println("Type: " + e.getType());
        System.out.println("New: " + ((e.getNewArmorPiece() != null) ? (String) e.getNewArmorPiece().getType().name() : "null"));
        System.out.println("Old: " + ((e.getOldArmorPiece() != null) ? (String) e.getOldArmorPiece().getType().name() : "null"));
        boolean test = true;
        if (test) {
            if (e.getOldArmorPiece() != null && e.getOldArmorPiece().getType().equals(Material.DIAMOND_HELMET))
                e.getPlayer().setGameMode(e.getPlayer().getGameMode().equals(GameMode.ADVENTURE) ? GameMode.SURVIVAL : GameMode.ADVENTURE);
            if (e.getNewArmorPiece() != null && e.getNewArmorPiece().getType().equals(Material.DIAMOND_HELMET))
                e.getPlayer().setGameMode(e.getPlayer().getGameMode().equals(GameMode.ADVENTURE) ? GameMode.SURVIVAL : GameMode.ADVENTURE);
        }
    }
}
