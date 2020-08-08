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
                    .loreAsList(getRandomLore(3,2))
                    .build();
            player.getInventory().addItem(item);

            }
        return true;
    }

    private List<String> getRandomLore(Integer itemLevel, Integer itemRarity) {
        List<String> lore = null;
        int min = itemLevel * 4;
        int max = itemLevel * 8;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max);
        int random = ThreadLocalRandom.current().nextInt(1, 5);
        Modifier modifier = new Modifier();
        for (int i = 0; i < itemRarity; i++) {
            switch (random) {
                case 1: {
                    modifier.setAdditionalHealth(randomNum);
                    lore.add(modifier.getAdditionalHealth());
                    break;
                }
                case 2: {
                    modifier.setAdditionalArmor(randomNum);
                    lore.add(modifier.getAdditionalArmor());
                }
                case 3: {
                    modifier.setAdditionalAttackDamage(randomNum);
                    lore.add(modifier.getAdditionalAttackDamage());
                }
                case 4: {
                    modifier.setAdditionalAttackSpeed(randomNum);
                    lore.add(modifier.getAdditionalAttackSpeed());
                }
                case 5: {
                    modifier.setAdditionalMovementSpeed(randomNum);
                    lore.add(modifier.getAdditionalMovementSpeed());
                }
            }
        }

        return lore;
    }
}
