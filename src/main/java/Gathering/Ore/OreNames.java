package Gathering.Ore;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class OreNames {
    public static ArrayList<String> oreNames() {
        ArrayList<String> oreNames = new ArrayList<String>();
        oreNames.add(ChatColor.GRAY + "Булыжник");
        oreNames.add(ChatColor.GRAY + "Уголь");
        oreNames.add(ChatColor.GRAY + "Железная руда");
        oreNames.add(ChatColor.GRAY + "Цинковая руда");
        oreNames.add(ChatColor.GRAY + "Медная руда");
        oreNames.add(ChatColor.GRAY + "Оловяная руда");
        oreNames.add(ChatColor.GRAY + "Золотая руда");
        oreNames.add(ChatColor.GRAY + "Титановая руда");
        return oreNames;
    };
}
