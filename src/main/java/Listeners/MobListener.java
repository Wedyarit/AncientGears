package Listeners;

import Entity.BaseEntity;
import Entity.EntityManager;
import Player.CustomItemStack;
import Player.Modifier;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.UUID;

public class MobListener extends BaseListener {
    @EventHandler
    private void onDeath(EntityDeathEvent e) {
        List<ItemStack> drops = e.getDrops();
        e.getDrops().clear();
        EntityManager em = EntityManager.getInstance();
        UUID uuid = e.getEntity().getUniqueId();
        BaseEntity baseEntity = em.getEntity(uuid);

        if (uuid.equals(baseEntity.getEntity().getUniqueId())) {
            em.removeFromList(uuid);
            int level = baseEntity.getLevel();
            int rarity = (int) (level / 10);
            if (baseEntity.isBoss()) rarity += 2;
            double random = Math.random();
            if (random <= 0.3) {
                drops.add(new CustomItemStack(new Modifier(), level, rarity).getItem());

            }
            for (ItemStack item : baseEntity.getSpecialDrop())
                drops.add(item);
        }
    }
}
