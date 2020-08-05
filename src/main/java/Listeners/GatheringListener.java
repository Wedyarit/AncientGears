package Listeners;

import Gathering.Ore.Ore;
import Gathering.Ore.OreItems;
import AncientGears.AncientGears;
import Gathering.ResourceManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;


public class GatheringListener extends BaseListener {
    public ArrayList<Ore> getOreArray() {
        ArrayList<Ore> arrayList = new ArrayList<>();
        arrayList.add(new Ore(ChatColor.GRAY + "Булыжник", OreItems.t1PickAxe, OreItems.stoneOre, 80.0, 30));
        arrayList.add(new Ore(ChatColor.GRAY + "Уголь", OreItems.t1PickAxe, OreItems.coalOre, 70.0, 45));
        arrayList.add(new Ore(ChatColor.GRAY + "Железная руда", OreItems.t2PickAxe, OreItems.ironOre, 60.0, 60));
        arrayList.add(new Ore(ChatColor.GRAY + "Оловянная руда", OreItems.t2PickAxe, OreItems.tinOre, 60.0, 60));
        arrayList.add(new Ore(ChatColor.GRAY + "Медная руда", OreItems.t2PickAxe, OreItems.copperOre, 60.0, 60));
        arrayList.add(new Ore(ChatColor.GRAY + "Цинковая руда", OreItems.t3PickAxe, OreItems.zincOre, 40.0, 60));
        arrayList.add(new Ore(ChatColor.GRAY + "Золотая руда", OreItems.t3PickAxe, OreItems.goldOre, 30.0, 120));
        arrayList.add(new Ore(ChatColor.GRAY + "Титановая руда", OreItems.t3PickAxe, OreItems.titanOre, 20.0, 120));
        return arrayList;
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onDamage(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player)) return;
        Player player = (Player) e.getDamager();
        if (!(e.getEntity() instanceof ArmorStand)) return;
        ArmorStand resource = (ArmorStand) e.getEntity();
        int maxcount = 3;

        ArrayList<Ore> oreArrayList = getOreArray();
        if (resource.getCustomName() != null)
            for (Ore ore : oreArrayList)
                if (player.getInventory().getItemInMainHand().equals(ore.getTool()))
                    if (resource.getCustomName().equals(ore.getName())) {
                        setCD(resource, ore.getCooldown());
                        addItemsByChance(ore.getDrop(), ore.getChance(), maxcount, player);
                    }


//            if (player.getInventory().getItemInMainHand().equals(OreItems.t1PickAxe)) {
//                if (resource.getCustomName().equals(ResourceManager.stoneOre.getName())) {
//                    setCD(resource, ResourceManager.stoneOre.getCooldown());
//                    addItemsByChance(ResourceManager.stoneOre.getTool(), ResourceManager.stoneOre.getChance(), maxcount, player);
//                } else if (resource.getCustomName().equals(ResourceManager.coalOre.getName())) {
//                    setCD(resource, ResourceManager.coalOre.getCooldown());
//                    addItemsByChance(ResourceManager.coalOre.getDrop(), ResourceManager.coalOre.getChance(), maxcount, player);
//                }
//            } else if (player.getInventory().getItemInMainHand().equals(OreItems.t2PickAxe)) {
//                if (resource.getCustomName().equals(ResourceManager.copperOre.getName())) {
//                    setCD(resource, ResourceManager.copperOre.getCooldown());
//                    addItemsByChance(ResourceManager.copperOre.getDrop(), ResourceManager.copperOre.getChance(), maxcount, player);
//                } else if (resource.getCustomName().equals(ResourceManager.tinOre.getName())) {
//                    setCD(resource, ResourceManager.tinOre.getCooldown());
//                    addItemsByChance(ResourceManager.tinOre.getDrop(), ResourceManager.tinOre.getChance(), maxcount, player);
//                } else if (resource.getCustomName().equals(ResourceManager.ironOre.getName())) {
//                    setCD(resource, ResourceManager.ironOre.getCooldown());
//                    addItemsByChance(ResourceManager.ironOre.getDrop(), ResourceManager.ironOre.getChance(), maxcount, player);
//                }
//            } else if (player.getInventory().getItemInMainHand().equals(OreItems.t3PickAxe)) {
//                if (resource.getCustomName().equals(ResourceManager.goldOre.getName())) {
//                    setCD(resource, ResourceManager.goldOre.getCooldown());
//                    addItemsByChance(ResourceManager.goldOre.getDrop(), ResourceManager.goldOre.getChance(), maxcount, player);
//                } else if (resource.getCustomName().equals(ResourceManager.titanOre.getName())) {
//                    setCD(resource, ResourceManager.titanOre.getCooldown());
//                    addItemsByChance(ResourceManager.titanOre.getDrop(), ResourceManager.titanOre.getChance(), maxcount, player);
//                } else if (resource.getCustomName().equals(ResourceManager.zincOre.getName())) {
//                    setCD(resource, ResourceManager.zincOre.getCooldown());
//                    addItemsByChance(ResourceManager.zincOre.getDrop(), ResourceManager.zincOre.getChance(), maxcount, player);
//                }
//            }
//      }
    }


    @EventHandler
    private void onInteract(EntityInteractEvent e) {
        if (e.getEntity() instanceof ArmorStand) e.setCancelled(true);
    }

    private void addItemsByChance(ItemStack item, Double chance, Integer maxCount, Player player) {
        chance *= 0.01;
        for (int i = 0; i < maxCount; i++) {
            double random = Math.random();
            if (chance >= random) player.getInventory().addItem(item);
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
            int time = seconds;

            @Override
            public void run() {
                time--;
                if (time <= 0) {
                    armorStand.getEquipment().setItemInMainHand(rightArm);
                    armorStand.getEquipment().setItemInOffHand(leftArm);
                    armorStand.getEquipment().setHelmet(head);
                    armorStand.setCustomNameVisible(true);
                    this.cancel();
                }

            }
        }.runTaskTimer(AncientGears.getInstance(), 0, 20);
    }
}
