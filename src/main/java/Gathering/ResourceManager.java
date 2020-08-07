package Gathering;

import Gathering.Crop.Crop;
import Gathering.Fish.Fish;
import Gathering.Ore.Ore;
import Gathering.Tree.Tree;

import java.util.ArrayList;

public class ResourceManager {
    private final ArrayList<Ore> oreArrayList = new ArrayList<>();
    private final ArrayList<Tree> treesArrayList = new ArrayList<>();
    private final ArrayList<Fish> fishArrayList = new ArrayList<>();
    private final ArrayList<Crop> cropsArrayList = new ArrayList<>();
    private final ArrayList<Tool> toolArrayList = new ArrayList<>();
    private static ResourceManager instance;

    public ResourceManager() {

    }

    public void addOre(Ore ore) {
        oreArrayList.add(ore);
    }

    public ResourceManager removeOre(Ore ore) {
        oreArrayList.remove(ore);
        return this;
    }

    public void addTool(Tool tool) {
        toolArrayList.add(tool);
    }

    public ResourceManager removeTool(Tool tool) {
        toolArrayList.remove(tool);
        return this;
    }

    public ResourceManager addTree(Tree tree) {
        this.treesArrayList.add(tree);
        return this;
    }

    public ResourceManager removeTree(Tree tree) {
        this.treesArrayList.remove(tree);
        return this;
    }

    public ResourceManager addFish(Fish fish) {
        this.fishArrayList.add(fish);
        return this;
    }

    public ResourceManager removeFish(Fish fish) {
        this.fishArrayList.remove(fish);
        return this;
    }

    public ResourceManager addCrop(Crop crop) {
        this.cropsArrayList.add(crop);
        return this;
    }

    public ResourceManager removeCrop(Crop crop) {
        this.cropsArrayList.remove(crop);
        return this;
    }

    public ArrayList<Fish> getFishArrayList() {
        return fishArrayList;
    }

    public ArrayList<Crop> getCropsArrayList() {
        return cropsArrayList;
    }

    public ArrayList<Tree> getTreesArrayList() {
        return treesArrayList;
    }

    public ArrayList<Ore> getOreArrayList() {
        return oreArrayList;
    }

    public ArrayList<Tool> getToolArrayList() {
        return toolArrayList;
    }

    public static ResourceManager getInstance() {
        ResourceManager localInstance = instance;
        if (localInstance == null) {
            synchronized (ItemStackManager.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ResourceManager();
                }
            }
        }
        return localInstance;
    }
}