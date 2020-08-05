package Listeners;

import Gathering.Ore.Ore;
import Gathering.Ore.OreItems;
import AncientGears.AncientGears;
import Gathering.ResourceManager;
import Gathering.Tool;
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
    private ArrayList<Ore> getOreArray() {
        ArrayList<Ore> arrayList = new ArrayList<>();
        arrayList.add(new Ore(ChatColor.GRAY + "Булыжник", 1, OreItems.stoneOre, 80.0, 30));
        arrayList.add(new Ore(ChatColor.GRAY + "Уголь", 1, OreItems.coalOre, 70.0, 45));
        arrayList.add(new Ore(ChatColor.GRAY + "Железная руда", 2, OreItems.ironOre, 60.0, 60));
        arrayList.add(new Ore(ChatColor.GRAY + "Оловянная руда", 2, OreItems.tinOre, 60.0, 60));
        arrayList.add(new Ore(ChatColor.GRAY + "Медная руда", 2, OreItems.copperOre, 60.0, 60));
        arrayList.add(new Ore(ChatColor.GRAY + "Цинковая руда", 3, OreItems.zincOre, 40.0, 60));
        arrayList.add(new Ore(ChatColor.GRAY + "Золотая руда", 3, OreItems.goldOre, 30.0, 120));
        arrayList.add(new Ore(ChatColor.GRAY + "Титановая руда", 3, OreItems.titanOre, 20.0, 120));
        return arrayList;
    }

    private ArrayList<Tool> getToolArray() {
        ArrayList<Tool> arrayList = new ArrayList<>();
        arrayList.add(new Tool(OreItems.t1PickAxe, 1));
        arrayList.add(new Tool(OreItems.t2PickAxe, 2));
        arrayList.add(new Tool(OreItems.t3PickAxe, 3));
        arrayList.add(new Tool(OreItems.t4PickAxe, 4));
        arrayList.add(new Tool(OreItems.t5PickAxe, 5));
        arrayList.add(new Tool(OreItems.t6PickAxe, 6));
        return arrayList;
    }

    private int isContains(ArrayList<Tool> arrayList, ItemStack tool1) {
        for (Tool tool : arrayList)
            if (tool.getTool().equals(tool1)) return arrayList.indexOf(tool);
        return -1;
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onDamage(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player)) return;
        Player player = (Player) e.getDamager();
        if (!(e.getEntity() instanceof ArmorStand)) return;
        ArmorStand resource = (ArmorStand) e.getEntity();
        int maxcount = 3;

        ArrayList<Ore> oreArrayList = getOreArray();
        ArrayList<Tool> toolArrayList = getToolArray();
        if (resource.getCustomName() != null)
            for (Ore ore : oreArrayList)
                    if (isContains(toolArrayList, player.getInventory().getItemInMainHand()) != -1)
                        if (resource.getCustomName().equals(ore.getName()))
                            if (toolArrayList.get(isContains(toolArrayList, player.getInventory().getItemInMainHand())).getTier() >= ore.getTier()) {
                                setCD(resource, ore.getCooldown());
                                addItemsByChance(ore.getDrop(), ore.getChance(), maxcount, player);
                                break;
                            } else
                                player.sendMessage(ChatColor.RED + "" + player.getInventory().getItemInMainHand().getItemMeta().getDisplayName() + " не может добыть " + ore.getName() + " ,нужна кирка минимум " + ore.getTier() + "  тира" );
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
        armorStand.setInvulnerable(true);

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
                    armorStand.setInvulnerable(false);
                    this.cancel();
                }

            }
        }.runTaskTimer(AncientGears.getInstance(), 0, 20);
    }
}
