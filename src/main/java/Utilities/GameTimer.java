package Utilities;

import org.bukkit.scheduler.BukkitRunnable;

public class GameTimer extends BukkitRunnable {
    private int minutes;
    private int seconds;
    private String time;

    public GameTimer (Integer minutes, Integer seconds) {
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public String getTime() {
        return this.time;
    }

    public Integer getMinutes() {
        return this.minutes;
    }

    public Integer getSeconds() {
        return this.seconds;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }

    @Override
    public void run() {
       this.time = minutes + ":" + seconds;
       if (seconds!=0) seconds--;
       else {
           seconds = 59;
           minutes--;
        }
    }
}
