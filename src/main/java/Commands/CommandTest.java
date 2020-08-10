package Commands;

import Entity.BaseEntity;
import Entity.EntityManager;
import Gathering.ItemStackManager;
import Gathering.Ore.OreItems;
import Player.Modifier;
import Utilities.ItemConstructor;
import org.bukkit.ChatColor;
import org.bukkit.Location;
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
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class CommandTest implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            ItemStackManager instance = ItemStackManager.getInstance();
            double angle = 1.0;
            for (int i = 0; i < 8; i++) {
                Random rd = new Random();

                Location location = player.getLocation();
                double x = (4 * Math.sin(angle));
                double z = (4 * Math.cos(angle));
                int random = ThreadLocalRandom.current().nextInt(1, 60);
                angle += 0.1;
                BaseEntity entity = new BaseEntity(EntityType.ZOMBIE, "Печка доггича херня", random, rd.nextBoolean(), player.getLocation())
                        .addDrop(instance.getItem(OreItems.OreItemNames.ADAMANTITE_ORE.name()), instance.getItem(OreItems.OreItemNames.TIN_ORE.name()))
                        .setStats(random * 10, random * 0.5, random, 0.1 + random * 0.02);

                EntityManager.getInstance().addToList(entity);
            }
        }
        return true;
    }



}
