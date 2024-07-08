package me.mie.vstarter.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class LinksCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (label.equalsIgnoreCase("links")) {
            // Another way of writing cmds i guess
            if (args.length == 0) {
                sender.sendMessage(ChatColor.DARK_PURPLE + "WEBSITE: " + ChatColor.WHITE + "https://violetsmc.com/");
                sender.sendMessage(ChatColor.DARK_PURPLE + "VOTE: " + ChatColor.WHITE + "https://violetsmc.com/vote/");
                sender.sendMessage(ChatColor.DARK_PURPLE + "WIKI: " + ChatColor.WHITE + "link here");
                return true;
            } else {
                sender.sendMessage(ChatColor.RED + "Wrong command format");
            }
        }
        return true;
    }
}
