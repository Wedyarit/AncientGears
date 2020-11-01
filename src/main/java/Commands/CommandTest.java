package Commands;

import Entity.BaseEntity;
import Entity.EntityManager;
import Gather.GatherEnum;
import Gather.ItemStackManager;
import Gather.GatherItems;
import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;

import java.util.Random;
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
                        .addDrop(instance.getItem(GatherEnum.ADAMANTITE_ORE.name()), instance.getItem(GatherEnum.TIN_ORE.name()))
                        .setStats(random * 3, random * 0.3, random, 0.1 + random * 0.005);

                EntityManager.getInstance().addToList(entity);
            }
        }
        return true;
    }



}
