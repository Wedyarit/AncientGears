package Listeners;

import Event.ClassesNOTWORKING.RpgPlayer;
import Event.ClassesNOTWORKING.RpgPlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.List;

public class PlayerListener extends BaseListener {
    @EventHandler(priority = EventPriority.HIGH)
    public void onShoot(EntityShootBowEvent e) {
        if (!(e.getEntity() instanceof  Player)) return;
        ItemStack bow = e.getBow();
        if (!(e.getProjectile() instanceof  Arrow)) return;
        Arrow arrow = (Arrow) e.getProjectile();
        if (bow.hasItemMeta()) {
            List<String> lore = bow.getItemMeta().getLore();
            for (String line : lore) {
                if (line.startsWith(ChatColor.GRAY + "Дистанционный урон: ")) {
                    double damage = Double.parseDouble(line.substring(24).replace(',','.'));
                    damage *= e.getForce();
                    arrow.setDamage(damage);
                }
            }
        }
    }
}
