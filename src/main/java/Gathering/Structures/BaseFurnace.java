package Gathering.Structures;

import org.bukkit.entity.ArmorStand;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class BaseFurnace {
    private ArmorStand as;
    private String name;
    private Integer speed;

    public BaseFurnace(ArmorStand as, String name, Integer speed) {
        this.as = as;
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public Integer getSpeed() {
        return speed;
    }

    public ArmorStand getAs() {
        return as;
    }
}
