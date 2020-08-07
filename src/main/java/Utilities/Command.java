package Utilities;
import AncientGears.AncientGears;
import Player.Modifier;
import Gathering.ItemStackManager;
import Gathering.Ore.OreItems;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Modifier dick = new Modifier();
            int s1 = dick.getAdditionalArmor().length();
            int s2 = dick.getAdditionalAttackDamage().length();
            int s3 = dick.getAdditionalHealth().length();
            int s4 = dick.getAdditionalMovementSpeed().length();
            int s5 = dick.getAdditionalAttackSpeed().length();
            int c = (ChatColor.GRAY + "").length();
            AncientGears.getInstance().getLogger().info(s1 + " " + s2 + " " + s3 + " " + s4 + " " + s5 + " " + c);

            player.getInventory().addItem(ItemStackManager.getInstance().getItem(OreItems.OreItemNames.MENU_PROF.name()));
            player.getInventory().addItem(ItemStackManager.getInstance().getItem(OreItems.OreItemNames.T1_PICKAXE.name()));
            player.getInventory().addItem(ItemStackManager.getInstance().getItem(OreItems.OreItemNames.T6_PICKAXE.name()));
            player.getInventory().addItem(ItemStackManager.getInstance().getItem(OreItems.OreItemNames.T3_PICKAXE.name()));
        }
        return true;
    }
}
