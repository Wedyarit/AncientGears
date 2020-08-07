package Commands;

import Gathering.ItemStackManager;
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

public class CommandKit implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            player.getInventory().addItem(ItemStackManager.getInstance().getItem(OreItems.OreItemNames.MENU_PROF.name()));
            player.getInventory().addItem(ItemStackManager.getInstance().getItem(OreItems.OreItemNames.T1_PICKAXE.name()));
            player.getInventory().addItem(ItemStackManager.getInstance().getItem(OreItems.OreItemNames.T6_PICKAXE.name()));
            player.getInventory().addItem(ItemStackManager.getInstance().getItem(OreItems.OreItemNames.T3_PICKAXE.name()));
        }
        return true;
    }
}
