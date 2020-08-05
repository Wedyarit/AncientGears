package Utilities;

import Gathering.Ore.OreItems;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            player.getInventory().addItem(OreItems.t1PickAxe);
            player.getInventory().addItem(OreItems.t2PickAxe);
            player.getInventory().addItem(OreItems.profMenu);
        }
        return true;
    }
}
