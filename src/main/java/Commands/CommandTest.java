package Commands;

import Player.Modifier;
import Utilities.ItemConstructor;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import Player.CustomItemStack;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CommandTest implements CommandExecutor {
    private static final SecureRandom random = new SecureRandom();

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            for (int i = 0; i < 10; i++) {
                int random = ThreadLocalRandom.current().nextInt(1,60);
                int random2 = ThreadLocalRandom.current().nextInt(1,5);

                Modifier modifier = new Modifier();
                ItemStack item = new CustomItemStack(modifier, random, random2).getItem();
                player.getInventory().addItem(item);
            }
        }
        return true;
    }

}
