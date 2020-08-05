package Listeners;

import Event.Events.ArmorEquipEvent;
import Event.Events.ArmorType;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockDispenseArmorEvent;

public class DispencerArmorListener extends BaseListener {
    @EventHandler
    public void dispenseArmorEvent(BlockDispenseArmorEvent event) {
        ArmorType type = ArmorType.matchType(event.getItem());
        if (type != null &&
                event.getTargetEntity() instanceof Player) {
            Player p = (Player)event.getTargetEntity();
            ArmorEquipEvent armorEquipEvent = new ArmorEquipEvent(p, ArmorEquipEvent.EquipMethod.DISPENSER, type, null, event.getItem());
            Bukkit.getServer().getPluginManager().callEvent((Event)armorEquipEvent);
            if (armorEquipEvent.isCancelled())
                event.setCancelled(true);
        }
    }
}
