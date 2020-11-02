package Locations;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;

public class CustomLocation {
    protected String name;
    protected Location pos1;
    protected Location pos2;
    protected ArrayList<Player> playersInLocation = new ArrayList<>();
    protected Sound record;

    public CustomLocation(String name, Location pos1, Location pos2, Sound record) {

        int x1 = Math.min(pos1.getBlockX(), pos2.getBlockX());
        int y1 = Math.min(pos1.getBlockY(), pos2.getBlockY());
        int z1 = Math.min(pos1.getBlockZ(), pos2.getBlockZ());
        int x2 = Math.max(pos1.getBlockX(), pos2.getBlockX());
        int y2 = Math.max(pos1.getBlockY(), pos2.getBlockY());
        int z2 = Math.max(pos1.getBlockZ(), pos2.getBlockZ());
        this.pos1 = new Location(pos1.getWorld(), x1, y1, z1);
        this.pos2 = new Location(pos2.getWorld(), x2, y2, z2);

        this.name = name;
        this.record = record;

    }

    public void addPlayer(Player player) {
        playersInLocation.add(player);
    }

    public void removePlayer(Player player) {
        playersInLocation.remove(player);
    }

    public void removeAllPlayers() {
        playersInLocation.clear();
    }

    public String getName() {
        return name;
    }

    public Sound getRecord() {
        return record;
    }

    public boolean isInLocation(Player player) {
        Location loc = player.getLocation();
        return loc.getBlockX() >= pos1.getBlockX() && loc.getBlockX() <= pos2.getBlockX()
                && loc.getBlockY() >= pos1.getBlockY() && loc.getBlockY() <= pos2.getBlockY()
                && loc.getBlockZ() >= pos1.getBlockZ() && loc.getBlockZ() <= pos2.getBlockZ();
    }

    public boolean isAlreadyBeenInLocation(Player player) {
        return playersInLocation.contains(player);
    }

    public static void updateLocation(Player player) {
        CustomLocation playerLocation = getPlayerLocation(player);
        for (CustomLocation location : LocationsManager.getInstance().getlocationArrayList()) {
            if ((location.isAlreadyBeenInLocation(player) && location != playerLocation)) {
                player.stopSound(location.getRecord());
                location.removePlayer(player);
                if (playerLocation == null) {
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1);
                    player.sendTitle("Локация обновлена", ChatColor.GOLD + "Неизведованные земли", 20, 25, 20);
                    return;
                }
            } else if ((!location.isAlreadyBeenInLocation(player) && location == playerLocation)) {
                location.addPlayer(player);
                processPlayer(player, playerLocation);
            }
        }
    }

    private static void processPlayer(Player player, CustomLocation playerLocation) {
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1);
        player.sendTitle("Локация обновлена", ChatColor.GOLD + playerLocation.getName(), 20, 25, 20);
        player.playSound(player.getLocation(), playerLocation.getRecord(), 10, 1);
    }

    private static CustomLocation getPlayerLocation(Player player) {
        for (CustomLocation location : LocationsManager.getInstance().getlocationArrayList())
            if (location.isInLocation(player))
                return location;
        return null;
    }
}
