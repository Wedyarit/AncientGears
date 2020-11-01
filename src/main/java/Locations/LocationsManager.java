package Locations;

import java.util.ArrayList;

public class LocationsManager {
    private final ArrayList<CustomLocation> locationArrayList = new ArrayList<>();
    private static LocationsManager instance;

    public void addLocation(CustomLocation customLocation) {
        locationArrayList.add(customLocation);
    }

    public LocationsManager removeLocation(CustomLocation customLocation) {
        locationArrayList.remove(customLocation);
        return this;
    }

    public ArrayList<CustomLocation> getlocationArrayList() {
        return locationArrayList;
    }

    public static LocationsManager getInstance() {
        LocationsManager localInstance = instance;
        if (localInstance == null) {
            synchronized (LocationsManager.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new LocationsManager();
                }
            }
        }
        return localInstance;
    }
}
