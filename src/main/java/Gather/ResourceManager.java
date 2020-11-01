package Gather;

import Gather.Resources.*;
import Gather.Tools.*;

import java.util.ArrayList;

public class ResourceManager {
    private final ArrayList<Ore> oreArrayList = new ArrayList<>();
    private final ArrayList<Tree> treesArrayList = new ArrayList<>();
    private final ArrayList<Fish> fishArrayList = new ArrayList<>();
    private final ArrayList<Crop> cropsArrayList = new ArrayList<>();

    private final ArrayList<Pickaxe> pickaxesArrayList = new ArrayList<>();
    private final ArrayList<Axe> axesArrayList = new ArrayList<>();
    private final ArrayList<FishingRod> frArrayList = new ArrayList<>();
    private final ArrayList<Hoe> hoesArrayList = new ArrayList<>();

    private static ResourceManager instance;

    public void addOre(Ore ore) {
        oreArrayList.add(ore);
    }

    public void addTree(Tree tree) {
        treesArrayList.add(tree);
    }

    public void addFish(Fish fish) {
        fishArrayList.add(fish);
    }

    public void addCrop(Crop crop) {
        cropsArrayList.add(crop);
    }

    public void addPickaxe(Pickaxe pickaxe) {
        pickaxesArrayList.add(pickaxe);
    }

    public void addAxe(Axe axe) {
        axesArrayList.add(axe);
    }

    public void addFishingRod(FishingRod rod) {
        frArrayList.add(rod);
    }

    public void addHoe(Hoe hoe) {
        hoesArrayList.add(hoe);
    }

    public ArrayList<Ore> getOreArrayList() {
        return oreArrayList;
    }

    public ArrayList<Tree> getTreesArrayList() {
        return treesArrayList;
    }

    public ArrayList<Crop> getCropsArrayList() {
        return cropsArrayList;
    }

    public ArrayList<Fish> getFishArrayList() {
        return fishArrayList;
    }

    public ArrayList<Axe> getAxesArrayList() {
        return axesArrayList;
    }

    public ArrayList<FishingRod> getFrArrayList() {
        return frArrayList;
    }

    public ArrayList<Hoe> getHoesArrayList() {
        return hoesArrayList;
    }

    public ArrayList<Pickaxe> getPickaxesArrayList() {
        return pickaxesArrayList;
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