package Listeners;

import Gathering.Ore.OreVeins;
import Gathering.Ore.OreItems;
import AncientGears.AncientGears;
import Gathering.ResourceManager;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class GatheringListener extends BaseListener {
    @EventHandler(priority = EventPriority.LOW)
    public void onDamage(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player)) return;
        Player player = (Player) e.getDamager();
        if (!(e.getEntity() instanceof ArmorStand)) return;
        ArmorStand resource = (ArmorStand) e.getEntity();
        int maxcount = 3;
        if (resource.getCustomName() != null) {
            if (player.getInventory().getItemInMainHand().equals(OreItems.t1PickAxe)) {
                if (resource.equals(ResourceManager.stoneOre.getOre())) {
                    setCD(resource, ResourceManager.stoneOre.getCooldown());
                    addItemsByChance(ResourceManager.stoneOre.getDrop(), ResourceManager.stoneOre.getChance(), maxcount, player);
                } else if (resource.equals(ResourceManager.coalOre.getOre())) {
                    setCD(resource, ResourceManager.coalOre.getCooldown());
                    addItemsByChance(ResourceManager.coalOre.getDrop(), ResourceManager.coalOre.getChance(), maxcount, player);
                }
            } else if (player.getInventory().getItemInMainHand().equals(OreItems.t2PickAxe)) {
                if (resource.equals(ResourceManager.copperOre.getOre())) {
                    setCD(resource, ResourceManager.copperOre.getCooldown());
                    addItemsByChance(ResourceManager.copperOre.getDrop(), ResourceManager.copperOre.getChance(), maxcount, player);
                } else if (resource.equals(ResourceManager.tinOre.getOre())) {
                    setCD(resource, ResourceManager.tinOre.getCooldown());
                    addItemsByChance(ResourceManager.tinOre.getDrop(), ResourceManager.tinOre.getChance(), maxcount, player);
                } else if (resource.equals(ResourceManager.ironOre.getOre())) {
                    setCD(resource, ResourceManager.ironOre.getCooldown());
                    addItemsByChance(ResourceManager.ironOre.getDrop(), ResourceManager.ironOre.getChance(), maxcount, player);
                }
            } else if (player.getInventory().getItemInMainHand().equals(OreItems.t3PickAxe)) {
                if (resource.equals(ResourceManager.goldOre.getOre())) {
                    setCD(resource, ResourceManager.goldOre.getCooldown());
                    addItemsByChance(ResourceManager.goldOre.getDrop(), ResourceManager.goldOre.getChance(), maxcount, player);
                } else if (resource.equals(ResourceManager.titanOre.getOre())) {
                    setCD(resource, ResourceManager.titanOre.getCooldown());
                    addItemsByChance(ResourceManager.titanOre.getDrop(), ResourceManager.titanOre.getChance(), maxcount, player);
                } else if (resource.equals(ResourceManager.zincOre.getOre())) {
                    setCD(resource, ResourceManager.zincOre.getCooldown());
                    addItemsByChance(ResourceManager.zincOre.getDrop(), ResourceManager.zincOre.getChance(), maxcount, player);
                }
            }
        }
    }

    private void addItemsByChance(ItemStack item, Double chance, Integer maxCount, Player player) {
        ArrayList<ItemStack> toReturn = null;
        chance *= 0.01;
        for(int i = 0; i < maxCount; i++) {
            double random = Math.random();
            if (chance <= random) player.getInventory().addItem(item);
        }
    }

    private void setCD(ArmorStand armorStand, Integer seconds) {
        ItemStack head = armorStand.getEquipment().getHelmet();
        ItemStack leftArm = armorStand.getEquipment().getItemInOffHand();
        ItemStack rightArm = armorStand.getEquipment().getItemInMainHand();

        armorStand.getEquipment().setItemInMainHand(new ItemStack(Material.AIR));
        armorStand.getEquipment().setItemInOffHand(new ItemStack(Material.AIR));
        armorStand.getEquipment().setHelmet(new ItemStack(Material.AIR));

        armorStand.setCustomNameVisible(false);

        new BukkitRunnable() {
            int time = seconds * 20;
            @Override
            public void run() {
               if (time <= 0) {
                   armorStand.getEquipment().setItemInMainHand(rightArm);
                   armorStand.getEquipment().setItemInOffHand(leftArm);
                   armorStand.getEquipment().setHelmet(head);
                   armorStand.setCustomNameVisible(true);
                   this.cancel();
               }
                time--;
            }
        }.runTaskTimer(AncientGears.getInstance(), 0,20);
    }
}
