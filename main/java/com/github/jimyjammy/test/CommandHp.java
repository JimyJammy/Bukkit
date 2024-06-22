package com.github.jimyjammy.test;

import org.bukkit.command.CommandExecutor;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHp implements CommandExecutor {
    ItemGui gui = new ItemGui();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player && args.length == 2) {
            Player sent = Bukkit.getPlayer(sender.getName());
            if (sent.isOp()) {
                try{
                    Player player = Bukkit.getPlayer(args[0]);
                    player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(Double.valueOf(args[1]));
                    sent.sendMessage("Set " + player.getName() + "\'s health to: " + args[1] + ".");
                    player.setHealthScale(20);
                    return true;
                }
                finally {
                    sent.getAbsorptionAmount();
                }
                    
                }
            else if (sent.isOp() == false) {
                sent.sendMessage("You do not have access to this command.");
            }
            }
        return false;
    }
}