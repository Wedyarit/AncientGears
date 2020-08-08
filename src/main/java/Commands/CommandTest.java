package Commands;

import AncientGears.AncientGears;
import Player.Modifier;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTest implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Modifier dick = new Modifier();
            AncientGears.getInstance().getLogger().info(dick.getAdditionalHealth());
            dick.setAdditionalHealth(100);
            AncientGears.getInstance().getLogger().info(dick.getAdditionalHealth());
            }
        return true;
    }
}
