package Listeners;

import AncientGears.AncientGears;
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
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.List;

public class PlayerListener extends BaseListener {
    @EventHandler(priority = EventPriority.HIGH)
    public void onShoot(EntityShootBowEvent e) {
        if (!(e.getEntity() instanceof Player)) return;
        ItemStack bow = e.getBow();
        if (!(e.getProjectile() instanceof Arrow)) return;
        Arrow arrow = (Arrow) e.getProjectile();
        if (bow.hasItemMeta()) {
            List<String> lore = bow.getItemMeta().getLore();
            for (String line : lore) {
                if (line.startsWith(ChatColor.GRAY + "Дистанционный урон: ")) {
                    double damage = Double.parseDouble(line.substring(24).replace(',', '.'));
                    damage *= e.getForce();
                    arrow.setMetadata("arrow_damage", new FixedMetadataValue(AncientGears.getInstance(), damage));
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onDamage(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Arrow)) return;
        Arrow arrow = (Arrow) e.getDamager();
        if (!(e.getEntity() instanceof LivingEntity)) return;
        LivingEntity entity = (LivingEntity) e.getEntity();
        if (!(arrow.getShooter() instanceof Player)) return;
        Player player = (Player) arrow.getShooter();
        double damage = arrow.getMetadata("arrow_damage").get(0).asDouble();
        e.setCancelled(true);
        arrow.remove();
        if (!entity.isDead()) {
            player.sendMessage(damage + "");
            double defence = entity.getAttribute(Attribute.GENERIC_ARMOR).getValue();
            double toughness = entity.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS).getValue();
            double protection = 0.0;
            if (entity.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE))
                protection = entity.getPotionEffect(PotionEffectType.DAMAGE_RESISTANCE).getAmplifier() + 1;
            damage *= 1 - (Math.min(20, Math.max((defence / 5.0), defence - (damage / 2 + (toughness / 4)))) / 25) * (protection * 4 / 100);
            entity.damage(damage);
        }
    }
}
