package Commands;

import Gather.GatherEnum;
import Gather.ItemStackManager;
import Gather.GatherItems;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandKit implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.isOp())
                player.getInventory().addItem(ItemStackManager.getInstance().getItem(GatherEnum.MENU_PROF.name()));
        }
        return true;
    }
}
