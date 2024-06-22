package com.github.jimyjammy.test;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTime implements CommandExecutor {
    private Plugin plugin;

    public CommandTime(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player && args.length == 2) {
            int time = 0;
            time += Integer.valueOf(args[0])*60;
            time += Integer.valueOf(args[1]);
            if (time > 1200 || Integer.valueOf(args[1]) >= 60){
                return false;
            }
            plugin.changetime(time);
            sender.sendMessage("Set the time to " + args[0] + ":" + args[1]);
            return true;
            }
        return false;
    }
}