package Listeners;

import Gather.ResourceManager;
import Gather.Resources.Resource;
import Gather.Tools.Tool;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import io.netty.handler.codec.MessageToMessageDecoder;
import net.minecraft.server.v1_16_R2.Packet;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class PacketReader {
    Channel channel;
    public static Map<UUID, Channel> channels = new HashMap<UUID, Channel>();

    public void inject(Player player) {
        CraftPlayer craftPlayer = (CraftPlayer) player;
        channel = craftPlayer.getHandle().playerConnection.networkManager.channel;
        channels.put(player.getUniqueId(), channel);

        if (channel.pipeline().get("PacketInjector") != null) return;

        channel.pipeline().addAfter("decoder", "PacketInjector", new MessageToMessageDecoder<Packet<?>>() {

            @Override
            protected void decode(ChannelHandlerContext channelHandlerContext, Packet<?> packet, List<Object> list) throws Exception {
                list.add(packet);
                readPacket(player, packet);
            }
        });
    }

    public void readPacket(Player player, Packet<?> packet) {
        if (packet.getClass().getSimpleName().equalsIgnoreCase("PacketPlayInUseEntity")) {
            if (getValue(packet, "d").toString().equalsIgnoreCase("OFF_HAND")) return;
            if (getValue(packet, "action").toString().equalsIgnoreCase("INTERACT_AT")) return;
            if (getValue(packet, "action").toString().equalsIgnoreCase("INTERACT")) return;
            int id = (int) getValue(packet, "a");
            if (getValue(packet, "action").toString().equalsIgnoreCase("ATTACK")) {
                for (Resource resource : ResourceManager.getInstance().getResourceArrayList()) {
                    for (Tool tool : ResourceManager.getInstance().getToolArrayList()) {
                        if (resource.getId() == id) {
                            if (tool.getToolType().equals(resource.getType()))
                            Bukkit.getPluginManager().callEvent(new GatherEvent(player, resource, tool));
                        }
                    }
                }
            }
        }
    }

    private Object getValue(Object instance, String name) {
        Object result = null;

        try {
            Field field = instance.getClass().getDeclaredField(name);
            field.setAccessible(true);
            result = field.get(instance);
            field.setAccessible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
