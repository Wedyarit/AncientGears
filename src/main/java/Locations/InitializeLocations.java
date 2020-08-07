package Locations;

import AncientGears.AncientGears;
import org.bukkit.Bukkit;
import org.bukkit.Location;


public class InitializeLocations {
    public static void InitializeAllLocations() {
        AncientGears.getInstance().getLogger().info("Locations Initialization");
        LocationsManager locationsManager = LocationsManager.getInstance();

        locationsManager.addLocation(new CustomLocation("Лобби", new Location(Bukkit.getWorld("world"), 30, 100, -80), new Location(Bukkit.getWorld("world"), -30, -100, 80), 510));
    }

}
