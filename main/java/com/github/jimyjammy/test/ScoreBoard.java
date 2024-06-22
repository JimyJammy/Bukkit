package com.github.jimyjammy.test;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import org.bukkit.ChatColor;


public class ScoreBoard {

    public boolean refresh(int Mins, int Hrs){
        for (Player p: Bukkit.getOnlinePlayers()){

            //p.sendMessage("Hello, you are now online");
            //p.sendMessage(Integer.toString(plugin.hrs()));
            //p.sendMessage(Integer.toString(plugin.mins()));

            ScoreboardManager m = Bukkit.getScoreboardManager();
            Scoreboard b = m.getNewScoreboard();

            String mins = String.format("%02d", Mins);
            String hrs = String.format("%02d", Hrs);

            @SuppressWarnings("deprecation")
            Objective o = b.registerNewObjective("RPGcraft", "");
            o.setDisplaySlot(DisplaySlot.SIDEBAR);
            o.setDisplayName(ChatColor.DARK_AQUA + "RPGcraft");

            Score c = o.getScore(ChatColor.GOLD + "Time: " + hrs + ":" + mins);
            c.setScore(1);
            p.setScoreboard(b);
        }
        return true;


}

}