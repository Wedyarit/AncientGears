package Gathering;

import Gathering.Crop.Crop;
import Gathering.Fish.Fish;
import Gathering.Ore.Ore;
import Gathering.Ore.OreItems;
import Gathering.Tree.Tree;
import org.bukkit.ChatColor;

import java.util.ArrayList;

public class ResourceManager {
    private ArrayList<Ore> oreArrayList;
    private ArrayList<Tree> treesArrayList;
    private ArrayList<Fish> fishArrayList;
    private ArrayList<Crop> cropsArrayList;
    private ArrayList<Tool> toolArrayList;
    private static ResourceManager instance;

    public ResourceManager() {

    }

    public ResourceManager addOre(Ore ore) {
        oreArrayList.add(ore);
        return this;
    }

    public ResourceManager removeOre(Ore ore) {
        oreArrayList.remove(ore);
        return this;
    }

    public ResourceManager addTool(Tool tool) {
        toolArrayList.add(tool);
        return this;
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
        return instance;
    }
}