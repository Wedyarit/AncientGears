package Event.ClassesNOTWORKING;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

public class TeamManager {
    private HashMap<String, Team> teams = new HashMap<>();
    private HashMap<UUID, String> players = new HashMap<>();
    public static TeamManager instance;

    public TeamManager() {
        instance = this;
    }

    public static TeamManager getInstance() {
        return instance;
    }

    public boolean createTeam(Player owner, String name) {
        if (players.containsKey(owner.getUniqueId())) return false;

        Team team = new Team(owner, name);
        teams.put(name, team);
        players.put(owner.getUniqueId(), name);
        return true;
    }

    public boolean addPlayer(Player player, String name, String rank) {
        if (teams.containsKey(name) && !players.containsKey(player.getUniqueId())) {
            Team team = teams.get(name);
            team.addMember(player, rank);
            players.put(player.getUniqueId(), name);
            return true;
        }
        return false;
    }

    public void removePlayer(Player player) {
        if (players.containsKey(player.getUniqueId())) {
            String name = players.get(player.getUniqueId());
            players.remove(player.getUniqueId());
            Team team = teams.get(name);
            String rank = team.getRank(player);
            if (rank.equals("owner")) {
                Set<UUID> members = team.getMembers();
                for (UUID uuid : members) players.remove(uuid);
            }
            teams.remove(name);
        }
    }

    public boolean isInTeam(Player player) {
        return players.containsKey(player.getUniqueId());
    }

    public String getTeam(Player player) {
        if (players.containsKey(player.getUniqueId()))
            return players.get(player.getUniqueId());
        return null;
    }

    public Set<String> getTeams() {
        return teams.keySet();
    }


}
