package Commands;

import Entity.BaseEntity;
import Entity.EntityManager;
import Gathering.ItemStackManager;
import Gathering.Ore.OreItems;
import Player.Modifier;
import Utilities.ItemConstructor;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import Player.CustomItemStack;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class CommandTest implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            int random = ThreadLocalRandom.current().nextInt(1, 60);
            ItemStackManager instance = ItemStackManager.getInstance();

            BaseEntity entity = new BaseEntity(EntityType.ZOMBIE, "Печка доггича херня",random, false, player.getLocation())
            .addDrop(instance.getItem(OreItems.OreItemNames.ADAMANTITE_ORE.name()), instance.getItem(OreItems.OreItemNames.TIN_ORE.name()));
            EntityManager.getInstance().addToList(entity);
        }
        return true;
    }



}
