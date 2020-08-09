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
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.List;

public class PlayerListener extends BaseListener {
    @EventHandler(priority = EventPriority.HIGH)
    public void onShoot(EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof LivingEntity)) return;
        LivingEntity entity = (LivingEntity) e.getEntity();
        if (!(e.getDamager() instanceof Arrow)) return;
        Arrow arrow = (Arrow) e.getDamager();
        if (!(arrow.getShooter() instanceof Player)) return;
        Player player = (Player) arrow.getShooter();
        if (player.getInventory().getItemInMainHand().getType().equals(Material.BOW) || player.getInventory().getItemInMainHand().getType().equals(Material.CROSSBOW)) {
            if (player.getInventory().getItemInMainHand().getItemMeta() == null && player.getInventory().getItemInMainHand().getItemMeta().getLore() == null) return;
            List<String> lore = player.getInventory().getItemInMainHand().getItemMeta().getLore();
            for (String line : lore) {
                if (line.startsWith(ChatColor.GRAY + "Дистанционный урон: ")) {
                    double damage = Double.parseDouble(line.substring(24).replace(',','.'));
                    damage *= (arrow.getVelocity().length() * 0.5);
                    if (!entity.isDead()) {
                        player.sendMessage(damage + "");
                        double defence = entity.getAttribute(Attribute.GENERIC_ARMOR).getValue();
                        double toughness = entity.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS).getValue();
                        double protection = entity.getPotionEffect(PotionEffectType.DAMAGE_RESISTANCE).getAmplifier() + 1;

                        damage *= 1 - (Math.min(20,Math.max((defence / 5.0), defence - (damage / 2 + (toughness / 4)))) / 25) * (protection * 4 / 100);;
                        entity.damage(damage);
                    }
                    e.setCancelled(true);
                    arrow.remove();
                }
            }
        }
        if (player.getInventory().getItemInOffHand().getType().equals(Material.BOW) || player.getInventory().getItemInOffHand().getType().equals(Material.CROSSBOW)) {
            if (player.getInventory().getItemInOffHand().getItemMeta() == null && player.getInventory().getItemInOffHand().getItemMeta().getLore() == null) return;
            List<String> lore = player.getInventory().getItemInOffHand().getItemMeta().getLore();
            for (String line : lore) {
                if (line.startsWith(ChatColor.GRAY + "Дистанционный урон: ")) {
                    double damage = Double.parseDouble(line.substring(24).replace(',','.'));
                    damage *= (arrow.getVelocity().length() * 0.5);
                    if (!entity.isDead()) {
                        player.sendMessage(damage + "");
                        double defence = entity.getAttribute(Attribute.GENERIC_ARMOR).getValue();
                        double toughness = entity.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS).getValue();
                        double protection = entity.getPotionEffect(PotionEffectType.DAMAGE_RESISTANCE).getAmplifier() + 1;

                        damage *= 1 - (Math.min(20,Math.max((defence / 5.0), defence - (damage / 2 + (toughness / 4)))) / 25) * (protection * 4 / 100);
                        entity.damage(damage);
                    }
                    e.setCancelled(true);
                    arrow.remove();
                }
            }
        }
    }

}
