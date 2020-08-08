package Commands;

import AncientGears.AncientGears;
import Player.Modifier;
import Utilities.ItemConstructor;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CommandTest implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            ItemStack item = new ItemConstructor(Material.LEATHER_BOOTS)
                    .amount(1)
                    .displayName("TEST")
                    .loreAsList(getRandomLore(3, 2))
                    .build();
            player.getInventory().addItem(item);

        }
        return true;
    }

    private List<String> getRandomLore(Integer itemLevel, Integer itemRarity) {
        List<String> lore = new ArrayList<>();
        int min = itemLevel * 4;
        int max = itemLevel * 8;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max);

        Modifier modifier = new Modifier();
        for (int i = 0; i < itemRarity; i++) {
            int random = ThreadLocalRandom.current().nextInt(1, 5);
            switch (random) {
                case 1: {
                    modifier.addAdditionalHealth(randomNum);
                    break;
                }
                case 2: {
                    modifier.addAdditionalArmor(randomNum);
                    break;
                }
                case 3: {
                    modifier.addAdditionalAttackDamage(randomNum);
                    break;
                }
                case 4: {
                    modifier.addAdditionalAttackSpeed(randomNum);
                    break;
                }
                case 5: {
                    modifier.addAdditionalMovementSpeed(randomNum);
                    break;
                }
            }
        }
        if (modifier.getAdditionalMovementSpeed() != 0)
            lore.add(modifier.getAdditionalMovementSpeedString());
        if (modifier.getAdditionalHealth() != 0)
            lore.add(modifier.getAdditionalHealthString());
        if (modifier.getAdditionalArmor() != 0)
            lore.add(modifier.getAdditionalArmorString());
        if (modifier.getAdditionalAttackSpeed() != 0)
            lore.add(modifier.getAdditionalAttackSpeedString());
        if (modifier.getAdditionalAttackDamage() != 0)
            lore.add(modifier.getAdditionalAttackDamageString());
        return lore;
    }
}
