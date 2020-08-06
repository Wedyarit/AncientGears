package Listeners;

import Gathering.Ore.Ore;
import Gathering.Ore.OreItems;
import AncientGears.AncientGears;
import Gathering.ResourceManager;
import Gathering.Tool;
import Utilities.GameTimer;
import com.google.common.base.Strings;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;


public class GatheringListener extends BaseListener {
    private ArrayList<Ore> getOreArray() {
        ArrayList<Ore> arrayList = new ArrayList<>();
        arrayList.add(new Ore(ChatColor.GRAY + "Булыжник", 1, OreItems.stoneOre, 80.0, 30,50));
        arrayList.add(new Ore(ChatColor.GRAY + "Уголь", 1, OreItems.coalOre, 70.0, 45,35));
        arrayList.add(new Ore(ChatColor.GRAY + "Железная руда", 2, OreItems.ironOre, 60.0, 60,150));
        arrayList.add(new Ore(ChatColor.GRAY + "Оловянная руда", 2, OreItems.tinOre, 60.0, 60,110));
        arrayList.add(new Ore(ChatColor.GRAY + "Медная руда", 2, OreItems.copperOre, 60.0, 60,110));
        arrayList.add(new Ore(ChatColor.GRAY + "Цинковая руда", 3, OreItems.zincOre, 40.0, 60,90));
        arrayList.add(new Ore(ChatColor.GRAY + "Золотая руда", 3, OreItems.goldOre, 30.0, 120,60));
        arrayList.add(new Ore(ChatColor.GRAY + "Титановая руда", 3, OreItems.titanOre, 20.0, 120,240));
        return arrayList;
    }


    private ArrayList<Tool> getToolArray() {
        ArrayList<Tool> arrayList = new ArrayList<>();
        arrayList.add(new Tool(Tool.Type.PICKAXE, 1, OreItems.t1PickAxe,5,1));
        arrayList.add(new Tool(Tool.Type.PICKAXE, 2, OreItems.t2PickAxe,10,1));
        arrayList.add(new Tool(Tool.Type.PICKAXE, 3, OreItems.t3PickAxe,20,2));
        arrayList.add(new Tool(Tool.Type.PICKAXE, 4, OreItems.t4PickAxe,40,2));
        arrayList.add(new Tool(Tool.Type.PICKAXE, 5, OreItems.t5PickAxe,80,3));
        arrayList.add(new Tool(Tool.Type.PICKAXE, 6, OreItems.t6PickAxe,160,3));
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
                    if (resource.getCustomName().equals(ore.getName())) {
                        int tier = toolArrayList.get(isContains(toolArrayList, player.getInventory().getItemInMainHand())).getTier();
                        if (tier >= ore.getTier()) {
                            // Нужно получить тул игрока, в Tool есть метод getTool()
                            gather(resource, player.getInventory().getItemInMainHand(), toolArrayList.get(isContains(toolArrayList, player.getInventory().getItemInMainHand())).getTier(), player, ore.getTier(), ore.getCooldown(), ore);
                            break;
                        } else {
                            player.sendMessage(AncientGears.prefix + player.getInventory().getItemInMainHand().getItemMeta().getDisplayName() + ChatColor.RED + " не может добыть " + ore.getName() + ChatColor.RED + ", нужна кирка минимум " + ChatColor.GRAY + ore.getTier() + ChatColor.RED + " тира!");
                            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 2, 5);
                        }
                    }
    }

    @EventHandler
    private void onInteract(EntityInteractEvent e) {
        if (e.getEntity() instanceof ArmorStand) e.setCancelled(true);
    }

    private void addItemsByChance(ItemStack item, Double chance, Integer luckFactor, Player player) {
        chance *= 0.01;
        for (int i = 0; i < luckFactor; i++) {
            double random = Math.random();
            if (chance >= random) {
                player.getInventory().addItem(item);
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("Вы добыли " + item.getItemMeta().getDisplayName()));
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 2);
            }
        }
    }

    public static String getProgressBar(int current, int max, int totalBars, char symbol, ChatColor completedColor,
                                        ChatColor notCompletedColor) {
        float percent = (float) current / max;
        int progressBars = (int) (totalBars * percent);

        return Strings.repeat("" + completedColor + symbol, progressBars)
                + Strings.repeat("" + notCompletedColor + symbol, totalBars - progressBars);
    }

    private void gather(ArmorStand as, Tool tool, Integer toolTier, Player player, Ore ore) {

        new BukkitRunnable() {
            final String name = as.getCustomName();
            final int power = tool.getSpeed();
            int current = ore.getDurability();
            final char symbol = '|';
            final int maxDistance = 4;

            @Override
            public void run() {
                current -= power;
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("Вы добываете " + ore.getName()));
                as.setCustomName(name + ": " + getProgressBar(current, oreDurability * 40, 20, symbol, ChatColor.RESET, ChatColor.GOLD));
                if (current - power <= 0)
                    current = 0;
                player.attack(as);
                Location pLoc = player.getLocation();
                Location oLoc = as.getLocation();
                World world = oLoc.getWorld();

                if (!player.isOnline()) {
                    as.setCustomName(name);
                    this.cancel();
                    return;
                }

                if (pLoc.distance(oLoc) > maxDistance) {
                    as.setCustomName(name);
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.RED + "Вы отошли слишком далеко от ресурса!"));
                    world.playSound(oLoc, Sound.ENTITY_BLAZE_HURT, 10, 0);
                    this.cancel();
                    return;
                }
                if (!player.getInventory().getItemInMainHand().equals(tool.getTool())) {
                    as.setCustomName(name);
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.RED + "Вы выронили инструмент!"));
                    world.playSound(oLoc, Sound.ENTITY_BLAZE_HURT, 10, 0);
                    this.cancel();
                    return;
                }
                if (current < 0) {
                    as.setCustomName(name);
                    setCD(as, ore.getCooldown());
                    addItemsByChance(ore.getDrop(), ore.getChance(), tool.getLuckFactor(), player);
                    this.cancel();
                    return;
                }
                world.spawnParticle(Particle.SMOKE_NORMAL, oLoc, 80, 0.5, 2, 0.5, 0);
                world.playSound(oLoc, Sound.BLOCK_ANVIL_PLACE, 2, 2);
            }
        }.runTaskTimer(AncientGears.getInstance(), 0, 20);

    }

    private void setCD(ArmorStand armorStand, Integer seconds) {
        final String name = armorStand.getCustomName();
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
                String timeString = String.format("%02d:%02d", time / 60, time % 60);
                String timeLeft = ChatColor.RED + "[" + timeString + "] " + ChatColor.WHITE + "Восстановление " + name;
                armorStand.setCustomName(timeLeft);
                armorStand.setCustomNameVisible(true);
                if (time <= 0) {
                    armorStand.getEquipment().setItemInMainHand(rightArm);
                    armorStand.getEquipment().setItemInOffHand(leftArm);
                    armorStand.getEquipment().setHelmet(head);
                    armorStand.setCustomNameVisible(true);
                    armorStand.setCustomName(name);
                    armorStand.setInvulnerable(false);
                    armorStand.getWorld().playSound(armorStand.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2, 2);
                    this.cancel();
                }
            }
        }.runTaskTimer(AncientGears.getInstance(), 0, 20);
    }
}
