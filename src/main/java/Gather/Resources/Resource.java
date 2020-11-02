package Gather.Resources;

import AncientGears.AncientGears;
import Gather.Tools.Pickaxe;
import Gather.Tools.Tool;
import com.google.common.base.Strings;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class Resource {
    private final String name;
    private final ResourceType type;
    private final Integer tier;
    private final ItemStack material;
    private final ItemStack drop;
    private final Double chance;
    private final Integer durability;
    private final Integer cooldown;

    public Resource(String name, ResourceType type, Integer tier, ItemStack material, ItemStack drop, Double chance, Integer cooldown, Integer durability) {
        this.name = name;
        this.type = type;
        this.tier = tier;
        this.drop = drop;
        this.chance = chance;
        this.cooldown = cooldown;
        this.durability = durability;
        this.material = material;
    }

    public ResourceType getType() {
        return type;
    }
    public String getName() {
        return this.name;
    }

    public Integer getTier() {
        return this.tier;
    }

    public ItemStack getDrop() {
        return this.drop;
    }

    public ItemStack getMaterial() {return this.material;}

    public Double getChance() {
        return this.chance;
    }

    public Integer getCooldown() {
        return this.cooldown;
    }

    public Integer getDurability() {
        return this.durability;
    }


    private static void addItemsByChance(ItemStack item, Double chance, Integer luckFactor, Player player) {
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

    public static void gather(ArmorStand as, Tool tool, Player player, Resource ore) {
        new BukkitRunnable() {
            final String name = as.getCustomName();
            final int power = tool.gatherPower();
            int current = ore.getDurability() + power;
            final char symbol = '|';
            final int maxDistance = 4;

            @Override
            public void run() {
                if (current > 0) current -= power;

                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("Вы добываете " + ore.getName()));
                if (current < 0) as.setCustomName(name + ": " + getProgressBar(0, ore.getDurability(), 20, symbol, ChatColor.RESET, ChatColor.GOLD));
                else as.setCustomName(name + ": " + getProgressBar(current, ore.getDurability(), 20, symbol, ChatColor.RESET, ChatColor.GOLD));

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
                if (current == 0) {
                    as.setCustomName(name);
                    setCD(as, ore.getCooldown());
                    addItemsByChance(ore.getDrop(), ore.getChance(), tool.getLuckFactor(), player);
                    this.cancel();
                    return;
                }

                if (current < 0) current = 0;

                world.spawnParticle(Particle.SMOKE_NORMAL, oLoc, 80, 0.5, 2, 0.5, 0);
                world.playSound(oLoc, Sound.BLOCK_ANVIL_PLACE, 2, 2);

            }
        }.runTaskTimer(AncientGears.getInstance(), 0, 20);

    }

    public static int isContains(ArrayList<Pickaxe> arrayList, ItemStack pickaxe) {
        for (Pickaxe tool : arrayList)
            if (tool.getTool().equals(pickaxe)) return arrayList.indexOf(tool);
        return -1;
    }


    public static void setCD(ArmorStand armorStand, Integer seconds) {
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