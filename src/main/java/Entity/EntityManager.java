package Entity;

import Gathering.ResourceManager;
import org.bukkit.entity.LivingEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class EntityManager {
    private static EntityManager instance;
    private final HashMap<UUID, BaseEntity> list = new HashMap<>();

    public static EntityManager getInstance() {
        EntityManager localInstance = instance;
        if (localInstance == null) {
            synchronized (ResourceManager.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new EntityManager();
                }
            }
        }
        return localInstance;
    }

    public HashMap<UUID, BaseEntity> getList() {
        return list;
    }

    public void addToList(BaseEntity entity) {
        list.put(entity.getUuid(), entity);
    }

    public void removeFromList(UUID uuid) {
        list.remove(uuid);
    }

    public BaseEntity getEntity(UUID uuid) {
       return list.get(uuid);
    }

}
