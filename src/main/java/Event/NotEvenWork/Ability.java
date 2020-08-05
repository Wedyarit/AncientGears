//package Event.NotEvenWork;
//
//import Event.ClassesNOTWORKING.RpgPlayer;
//import org.bukkit.Location;
//import org.bukkit.block.Block;
//import org.bukkit.entity.Entity;
//import org.bukkit.entity.Player;
//import org.bukkit.util.BlockIterator;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Ability {
//    public static String healModifier = "HEAL_MODIFIER";
//    public static void arrowBarrage(Player player) {
//
//    }
//
//    public static void heal(Player player) {
//        Player healTarget = getTarget(player);
//        double healAmout = getHealAmount(player);
//        double targerHealth = healTarget.getHealth();
//        healTarget.setHealth(targerHealth + healAmout);
//    }
//
//    public static void slash(Player player) {
//
//    }
//
//    public static void shieldStun(Player player) {
//        RpgPlayer teamMember = new RpgPlayer(player,"LOX", "BLUE");
//    }
//
//    private static Double getHealAmount(Player player) {
//        double heal = 1.0;
//       if (player.getScoreboardTags().contains(Modifier.getModifierName(healModifier)))
//        {
//            int level = Modifier.getModifierLevel(healModifier);
//            heal *= level;
//        }
//      return heal;
//    }
//
//
//    private static Player getTarget(Player player) {
//        List<Entity> nearbyE = player.getNearbyEntities(20, 20, 20);
//        ArrayList<Player> nearPlayers = new ArrayList<Player>();
//        for (Entity e : nearbyE) {
//            if (e instanceof Player) {
//                nearPlayers.add((Player) e);
//            }
//        }
//        Player target = null;
//        BlockIterator bItr = new BlockIterator(player, 20);
//        Block block;
//        Location loc;
//        int bx, by, bz;
//        double ex, ey, ez;
//        while (bItr.hasNext()) {
//
//            block = bItr.next();
//            bx = block.getX();
//            by = block.getY();
//            bz = block.getZ();
//            for (Player e : nearPlayers) {
//                loc = e.getLocation();
//                ex = loc.getX();
//                ey = loc.getY();
//                ez = loc.getZ();
//                if ((bx - .75 <= ex && ex <= bx + 1.75) && (bz - .75 <= ez && ez <= bz + 1.75) && (by - 1 <= ey && ey <= by + 2.5)) {
//                    target = e;
//                    break;
//                }
//            }
//        }
//        return target;
//    }
//}
