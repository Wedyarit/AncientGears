package Utilities;

import AncientGears.AncientGears;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class LootChestSpawn {
   public static void spawnChest(ItemStack[] loot, Location location) {
       Block block = (Block) location.getBlock();
       block.setType(Material.CHEST);
       Chest chest = (Chest) block.getState();
       Inventory inventory = chest.getBlockInventory();
       inventory.addItem(loot);
       ArmorStand timer = (ArmorStand) block.getLocation().getWorld().spawnEntity(block.getLocation().add(0.5,0.5,0.5), EntityType.ARMOR_STAND);

       timer.setInvulnerable(true);
       timer.setGravity(true);
       timer.setVisible(false);

       new BukkitRunnable() {
           int time = 10;
           @Override
           public void run() {
               String timeLeft = ChatColor.RED + "" + (time-1);
               timer.setCustomName(timeLeft);
               timer.setCustomNameVisible(true);
               time--;
               if (time <= 0) {
                   block.setType(Material.AIR);
                   block.getWorld().playSound(block.getLocation(), Sound.BLOCK_WOOD_BREAK, 10, 10);
                   for (int i = 0; i < 8; i++) {
                       Location loc = block.getLocation().add(0.8, i, 0);
                       block.getWorld().spawnParticle(Particle.EXPLOSION_NORMAL, loc, 3);
                       timer.remove();
                   }
                   this.cancel();
                   }
               }
           }.runTaskTimer(AncientGears.getInstance(),0,20);
       }
   }

