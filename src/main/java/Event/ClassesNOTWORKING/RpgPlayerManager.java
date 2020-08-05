package Event.ClassesNOTWORKING;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class RpgPlayerManager {
    private HashMap<UUID, RpgPlayer> players = new HashMap<>();
    public static RpgPlayerManager instance;

    public RpgPlayerManager() {
        instance = this;
    }

    public RpgPlayer getPlayer(Player player) {
        if (players.containsKey(player.getUniqueId()))
        return players.get(player.getUniqueId());
        return null;
    }

    public static RpgPlayerManager getInstance() {
        return instance;
    }

    public void createClass(Player owner, String name) {

    }

    public boolean addPlayerToClass(RpgPlayer player, String Class) {

        return false;
    }

    public void removePlayerFromClass(RpgPlayer player, String Class) {

    }

    public boolean isRpgPlayer(Player player) {
        return players.containsKey(player.getUniqueId());
    }


}
