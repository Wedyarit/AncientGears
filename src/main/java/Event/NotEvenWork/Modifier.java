package Event.NotEvenWork;

import org.bukkit.entity.Player;

public class Modifier {
    // Смотрю сейчас на это, и думаю. А какого хрена?
    public static void addModifier(Player player, String addModifier) {
        player.getScoreboardTags().add(addModifier);
    }

    public static void removeModifier(Player player, String removeModifier) {
        player.getScoreboardTags().remove(removeModifier);
    }

    public static void removeAllModifiers(Player player, String[] blackList) {
        player.getScoreboardTags().removeIf(modifier -> !(player.getScoreboardTags().contains(blackList)));
    }

    public static void changeModifier(Player player, String removeModifier, String addModifier) {
        player.getScoreboardTags().remove(removeModifier);
        player.getScoreboardTags().add(addModifier);
    }

    public static Integer getModifierLevel(String modifier) {
        String level;
        char beforeLast = modifier.charAt(modifier.length() - 2);
        if (Character.isDigit(beforeLast)) {
            char last = modifier.charAt(modifier.length() - 1);
            level = modifier.substring(modifier.length() - 2);
        } else  {
            level = modifier.substring(modifier.length() - 1);
        }
        return Integer.parseInt(level);
    }

    public static String getModifierName(String modifier) {
        String name;
        char beforeLast = modifier.charAt(modifier.length() - 2);
        if (Character.isDigit(beforeLast)) {
            char last = modifier.charAt(modifier.length() - 1);
            name = modifier.substring(0,modifier.length() - 2);
        } else  {
            name = modifier.substring(0,modifier.length() - 1);
        }
        return name.substring(0, name.length() -1);
    }

    public static void stackModifier(Player player, String modifier) {
        String upgradedModifier;
        char beforeLast = modifier.charAt(modifier.length() - 2);
        if (Character.isDigit(beforeLast)) {
            char last = modifier.charAt(modifier.length() - 1);
            String level = "" + beforeLast + last;
            upgradedModifier = modifier.substring(0, modifier.length() - 2) + level;
        } else  {
            String level = "" + beforeLast;
            upgradedModifier = modifier.substring(0, modifier.length() - 1) + level;
        }

        player.getScoreboardTags().remove(modifier);
        player.getScoreboardTags().add(upgradedModifier);
    }

    public static Boolean getModifier(Player player, String modifier) {
        return player.getScoreboardTags().contains(modifier);
    }
}
