package Utilities;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CustomLocationConstructor {
    protected String name;
    protected Location pos1;
    protected Location pos2;
    protected ArrayList<Player> playersInLocation = new ArrayList<>();
    protected int recordID;

    public CustomLocationConstructor(String name) {
        this.name = name;
    }

    public CustomLocationConstructor setPos1(Location pos1) {
        this.pos1 = pos1;
        return this;
    }

    public CustomLocationConstructor setRecordID(int id) {
        recordID = id;
        return this;
    }

    public CustomLocationConstructor setPos2(Location pos2) {
        this.pos2 = pos2;
        return this;
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

    public void establishLocation() {
        int x1 = Math.min(pos1.getBlockX(), pos2.getBlockX());
        int y1 = Math.min(pos1.getBlockY(), pos2.getBlockY());
        int z1 = Math.min(pos1.getBlockZ(), pos2.getBlockZ());
        int x2 = Math.max(pos1.getBlockX(), pos2.getBlockX());
        int y2 = Math.max(pos1.getBlockY(), pos2.getBlockY());
        int z2 = Math.max(pos1.getBlockZ(), pos2.getBlockZ());
        this.pos1 = new Location(pos1.getWorld(), x1, y1, z1);
        this.pos2 = new Location(pos2.getWorld(), x2, y2, z2);
    }

    public boolean isInLocation(Player player) {
        Location loc = player.getLocation();
        return loc.getBlockX() >= pos1.getBlockX() && loc.getBlockX() <= pos2.getBlockX()
                && loc.getBlockY() >= pos1.getBlockY() && loc.getBlockY() <= pos2.getBlockY()
                && loc.getBlockZ() >= pos1.getBlockZ() && loc.getBlockZ() <= pos2.getBlockZ();
    }
}
