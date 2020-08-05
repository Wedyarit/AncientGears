package Utilities;

import Gathering.Ore.Ore;
import Gathering.Ore.OreItems;
import Gathering.ResourceManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            ItemStack[] loot = {OreItems.coalOre, OreItems.ironOre};
            LootChestSpawn.spawnChest(loot, player.getLocation());

            player.getInventory().addItem(OreItems.profMenu);
            player.getInventory().addItem(OreItems.t1PickAxe);

        }
        return true;
    }
}
