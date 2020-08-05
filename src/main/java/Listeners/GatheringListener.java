package Listeners;

import Gathering.Ore.OreEnums;
import Gathering.Ore.OreItems;
import AncientGears.AncientGears;
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
        if (resource.getCustomName() != null) {
            if (player.getInventory().getItemInMainHand().equals(OreItems.t1PickAxe)) {
                if (resource.equals(OreEnums.STONE.getAs())) {
                    setCD(resource, 30);
                    addItemsByChance(OreItems.stoneOre, 75.0, 3, player);
                } else if (resource.equals(OreEnums.COAL.getAs())) {
                    setCD(resource, 45);
                    addItemsByChance(OreItems.coalOre, 65.0, 2, player);
                }
            } else if (player.getInventory().getItemInMainHand().equals(OreItems.t2PickAxe)) {
                if (resource.equals(OreEnums.COPPER)) {
                    setCD(resource, 60);
                    addItemsByChance(OreItems.copperOre, 60.0, 3, player);
                } else if (resource.equals(OreEnums.TIN)) {
                    setCD(resource, 60);
                    addItemsByChance(OreItems.tinOre, 60.0, 3, player);
                } else if (resource.equals(OreEnums.IRON)) {
                    setCD(resource, 60);
                    addItemsByChance(OreItems.ironOre, 60.0, 3, player);
                }
            } else if (player.getInventory().getItemInMainHand().equals(OreItems.t3PickAxe)) {
                if (resource.equals(OreEnums.GOLD)) {
                    setCD(resource, 60);
                    addItemsByChance(OreItems.goldOre, 30.0, 3, player);
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
