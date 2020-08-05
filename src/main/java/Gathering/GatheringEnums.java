package Gathering;

import org.bukkit.ChatColor;

public class GatheringEnums {

    public enum lumberTools {
        WOODEN_AXE,
        STONE_AXE,
        IRON_AXE,
        GOLDEN_AXE,
        DIAMOND_AXE,
        NETHERITE_AXE;
    }

    public enum farmerTools {
        WOODEN_HOE,
        STONE_HOE,
        IRON_HOE,
        GOLDEN_HOE,
        DIAMOND_HOE,
        NETHERITE_HOE;
    }

    public enum fishingTools {
        FISHING_ROD_I,
        FISHING_ROD_II,
        FISHING_ROD_III,
        FISHING_ROD_IV,
        FISHING_ROD_V,
        FISHING_ROD_VI;
    }


    public enum menu {
        ORE(ChatColor.RED + "Меню Руды"),
        LUMBER(ChatColor.RED + "Меню Дерева"),
        FISHING(ChatColor.RED + "Меню Рыбалки"),
        CROP(ChatColor.RED + "Меню Фермерства"),
        GATHERING(ChatColor.GOLD + "Меню Профессий"),
        TOOLS(ChatColor.GRAY + "Меню Инструментов");

        private final String displayName;

        private menu(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return this.displayName;
        }
    }


    public enum fish {
        SALMON,
        CLOWN_FISH,
        FISH,
        FUGU,
        GOLDEN_FISH,
        SPARKLE_FISH;
    }

}
