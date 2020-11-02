package Listeners;

import Gather.Resources.Ore;
import Gather.Resources.Resource;
import AncientGears.AncientGears;
import Gather.ResourceManager;
import Gather.Tools.Pickaxe;
import Gather.Tools.Tool;
import com.google.common.base.Strings;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;


public class GatheringListener extends BaseListener {
    public static boolean regenOre = false;
    private static final ResourceManager rManager = ResourceManager.getInstance();

    @EventHandler(priority = EventPriority.LOW)
    public void onDamage(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player)) return;
        Player player = (Player) e.getDamager();
        if (!(e.getEntity() instanceof ArmorStand)) return;
        ArmorStand resource = (ArmorStand) e.getEntity();





//        ArrayList<Ore> oreArrayList = rManager.getOreArrayList();
//        ArrayList<Pickaxe> pickaxesArrayList = rManager.getPickaxesArrayList();
//        if (resource.getCustomName() != null)
//            for (Ore ore : oreArrayList)
//                if (isContains(pickaxesArrayList, player.getInventory().getItemInMainHand()) != -1)
//                    if (resource.getCustomName().equals(ChatColor.GOLD + "[T" + ore.getTier() + "] " + ore.getName())) {
//                        int tier = pickaxesArrayList.get(isContains(pickaxesArrayList, player.getInventory().getItemInMainHand())).getTier();
//                        if (tier >= ore.getTier()) {
//                            gather(resource, pickaxesArrayList.get(isContains(pickaxesArrayList, player.getInventory().getItemInMainHand())), player, ore);
//                            break;
//                        } else {
//                            player.sendMessage(AncientGears.prefix + player.getInventory().getItemInMainHand().getItemMeta().getDisplayName() + ChatColor.RED + " не может добыть " + ore.getName() + ChatColor.RED + ", нужна кирка минимум " + ChatColor.GRAY + ore.getTier() + ChatColor.RED + " тира!");
//                            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 2, 1);
//                        }
//                    }
    }

    @EventHandler
    private void onInteract(EntityInteractEvent e) {
        if (e.getEntity() instanceof ArmorStand) e.setCancelled(true);
    }
}
