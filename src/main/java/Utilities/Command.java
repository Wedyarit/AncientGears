package Utilities;

import Gathering.Ore.Ore;
import Gathering.Ore.OreItems;
import Gathering.ResourceManager;
import Listeners.GatheringListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            player.getInventory().addItem(OreItems.profMenu);
            player.getInventory().addItem(OreItems.t1PickAxe);
            player.getInventory().addItem(OreItems.t2PickAxe);
            player.getInventory().addItem(OreItems.t3PickAxe);
            player.getInventory().addItem(OreItems.t4PickAxe);
            player.getInventory().addItem(OreItems.t5PickAxe);
            player.getInventory().addItem(OreItems.copperOre);
            player.getInventory().addItem(OreItems.zincOre);

        }
        return true;
    }
}
