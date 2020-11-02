package Locations;

import AncientGears.AncientGears;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.List;
import java.util.Map;


public class InitializeLocations {
    public static void InitializeAllLocations() {
        AncientGears.getInstance().getLogger().info("Locations Initialization");
        LocationsManager locationsManager = LocationsManager.getInstance();

        FileConfiguration config = YamlConfiguration.loadConfiguration(new File(AncientGears.getInstance().getDataFolder(), "locations.yml"));

        locationsManager.addLocation(new CustomLocation(config.getString("Незиведованные земли"), new Location(Bukkit.getWorld("world"),0, 0, 0), new Location(Bukkit.getWorld("world"),0, 0, 0), null));

        for (String location : config.getConfigurationSection("locations").getKeys(false)) {
            locationsManager.addLocation(new CustomLocation(config.getString("locations." + location + ".name"), new Location(Bukkit.getWorld(config.getString("locations." + location + ".world")), config.getInt("locations." + location + ".location1.x"), config.getInt("locations." + location + ".location1.y"), config.getInt("locations." + location + ".location1.z")), new Location(Bukkit.getWorld(config.getString("locations." + location + ".world")), config.getInt("locations." + location + ".location2.x"), config.getInt("locations." + location + ".location2.y"), config.getInt("locations." + location + ".location2.z")), Sound.valueOf(config.getString("locations." + location + ".music"))));        }
    }
}
