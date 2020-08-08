package Listeners;

import Event.Events.ArmorEquipEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;

public class ArmorEquip extends BaseListener {
    @EventHandler
    public void onEquip(ArmorEquipEvent e) {
        Player player = e.getPlayer();
        if(e.getNewArmorPiece() != null && e.getNewArmorPiece().getType() != Material.AIR) {
            ItemStack armorPiece = e.getNewArmorPiece();
            player.sendMessage("Ты напялил: " + armorPiece.getItemMeta().getDisplayName());
        }
        if(e.getOldArmorPiece() != null && e.getOldArmorPiece().getType() != Material.AIR) {
            ItemStack armorPiece = e.getOldArmorPiece();
            player.sendMessage("Ты снял: " + armorPiece.getItemMeta().getDisplayName());
        }
    }
}
