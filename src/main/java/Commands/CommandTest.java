package Commands;

import AncientGears.AncientGears;
import com.mojang.authlib.GameProfile;
import net.minecraft.server.v1_16_R2.*;
import net.minecraft.server.v1_16_R2.Item;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_16_R2.CraftServer;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import java.util.UUID;


public class CommandTest implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location playerLocation = player.getLocation();
            MinecraftServer server = ((CraftServer)AncientGears.getInstance().getServer()).getServer();
            WorldServer worldServer = ((CraftWorld)AncientGears.getInstance().getServer().getWorlds().get(0)).getHandle();
            EntityPlayer npc = new EntityPlayer(server,worldServer,new GameProfile(UUID.randomUUID(), ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Hello"), new PlayerInteractManager(worldServer));

            npc.setLocation(playerLocation.getX(), playerLocation.getY(), playerLocation.getZ(), playerLocation.getYaw(), playerLocation.getPitch());

            PlayerConnection playerConnection = ((CraftPlayer)player).getHandle().playerConnection;
            playerConnection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, npc));
            playerConnection.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));
//
//            ItemStackManager instance = ItemStackManager.getInstance();
//            double angle = 1.0;
//            for (int i = 0; i < 8; i++) {
//                Random rd = new Random();
//
//                Location location = player.getLocation();
//                double x = (4 * Math.sin(angle));
//                double z = (4 * Math.cos(angle));
//                int random = ThreadLocalRandom.current().nextInt(1, 60);
//                angle += 0.1;
//                BaseEntity entity = new BaseEntity(EntityType.ZOMBIE, "Печка доггича херня", random, rd.nextBoolean(), player.getLocation())
//                        .addDrop(instance.getItem(GatherEnum.ADAMANTITE_ORE.name()), instance.getItem(GatherEnum.TIN_ORE.name()))
//                        .setStats(random * 3, random * 0.3, random, 0.1 + random * 0.005);
//
//                EntityManager.getInstance().addToList(entity);
        }
        return true;
    }


}
