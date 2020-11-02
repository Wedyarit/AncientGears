package Gather;

import Gather.Resources.*;
import Gather.Tools.*;

import java.util.ArrayList;

public class ResourceManager {
    private final ArrayList<Tool> toolArrayList = new ArrayList<>();
    private final ArrayList<Resource> resourceArrayList = new ArrayList<>();

    private static ResourceManager instance;

    public void addResource(Resource resource) {
        resourceArrayList.add(resource);
    }

    public void addTool(Tool tool) {
        toolArrayList.add(tool);
    }

    public ArrayList<Resource> getResourceArrayList() {
        return resourceArrayList;
    }

    public ArrayList<Tool> getToolArrayList() {
        return toolArrayList;
    }

    public static ResourceManager getInstance() {
        ResourceManager localInstance = instance;
        if (localInstance == null) {
            synchronized (ResourceManager.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ResourceManager();
                }
            }
        }
        return localInstance;
    }
}