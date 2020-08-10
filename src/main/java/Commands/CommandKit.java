package Commands;

import GUI.GUIEnums;
import GUI.GUIManager;
import Gathering.ItemStackManager;
import Gathering.Ore.Ore;
import Gathering.Ore.OreItems;
import Gathering.ResourceManager;
import Listeners.GatheringListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.Jukebox;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.UUID;

public class CommandKit implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.isOp())
                player.getInventory().addItem(ItemStackManager.getInstance().getItem(OreItems.OreItemNames.MENU_PROF.name()));
        }
        return true;
    }
}
