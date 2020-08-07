package Commands;

import AncientGears.AncientGears;
import Gathering.ItemStackManager;
import Gathering.Ore.Ore;
import Gathering.Ore.OreItems;
import Gathering.ResourceManager;
import Listeners.GatheringListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class CommandRegenAll implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.isOp()) {
                GatheringListener.regenOre = true;

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        GatheringListener.regenOre = false;
                        this.cancel();
                        player.sendMessage(AncientGears.prefix + "Все ресурсы успешно восстановлены.");
                    }
                }.runTaskTimer(AncientGears.getInstance(), 40, 0);
            }
        }

        return true;
    }
}


