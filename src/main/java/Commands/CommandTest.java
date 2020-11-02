package Commands;

import AncientGears.AncientGears;
import net.minecraft.server.v1_12_R1.EnumItemSlot;
import net.minecraft.server.v1_12_R1.ItemStack;
import net.minecraft.server.v1_12_R1.Item;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import NPC.NPC;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;

import java.io.IOException;

public class CommandTest implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            final boolean fixhead = true;
            final boolean tablist = true;

            NPC npc = new NPC("name", player.getLocation(), AncientGears.getInstance());

            npc.setRecipientType(NPC.Recipient.LISTED_RECIPIENTS); //EDIT THE PACKET RECEIVERS
            npc.addRecipient(player); //ADDING PLAYER TO PACKET RECEIVERS
            npc.setSkin("(texture)", "(signature)"); //SET THE SKIN TEXTURES AND SIGNATURE
            //PRE - INIT

            npc.spawn(tablist, fixhead);
            npc.setAnimation(NPC.NPCAnimation.SWING_MAIN_HAND);

            try {
                npc.setDisplayName("myglobalname");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                npc.setDisplayNameAboveHead("name above head");
            } catch (IOException e) {
                e.printStackTrace();
            }

            npc.setTablistName("my new tablist name");
            npc.setAction(new NPC.Action()
                    .setCrouched(true)
                    .setGlowing(true)
            );
            npc.setEquipment(EnumItemSlot.MAINHAND, new ItemStack(Item.getById(1)));
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
