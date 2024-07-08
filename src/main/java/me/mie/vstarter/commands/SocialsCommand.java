package me.mie.vstarter.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SocialsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (label.equalsIgnoreCase("socials")) {

            // if command is run in console
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.DARK_PURPLE + "YOUTUBE: " + ChatColor.WHITE + "https://www.youtube.com/@VioletsMC");
                sender.sendMessage(ChatColor.DARK_PURPLE + "INSTAGRAM: " + ChatColor.WHITE + "https://www.instagram.com/play.violetsmc/");
                sender.sendMessage(ChatColor.DARK_PURPLE + "DISCORD: " + ChatColor.WHITE + "https://discord.gg/violets");
                sender.sendMessage(ChatColor.DARK_PURPLE + "TIKTOK: " + ChatColor.WHITE + "https://www.tiktok.com/@play.violetsmc");
                return true;
            }

            Player p = (Player) sender;

            if (args.length == 0) {

                p.sendMessage(ChatColor.DARK_PURPLE + "YOUTUBE: " + ChatColor.WHITE + "https://www.youtube.com/@VioletsMC");
                p.sendMessage(ChatColor.DARK_PURPLE + "INSTAGRAM: " + ChatColor.WHITE + "https://www.instagram.com/play.violetsmc/");
                p.sendMessage(ChatColor.DARK_PURPLE + "DISCORD: " + ChatColor.WHITE + "https://discord.gg/violets");
                p.sendMessage(ChatColor.DARK_PURPLE + "TIKTOK: " + ChatColor.WHITE + "https://www.tiktok.com/@play.violetsmc");

            } else if (args.length == 1) {
                // !!! add arg suggestions !!!

                // arguments given with command
                if (args[0].equalsIgnoreCase("youtube")) {
                    p.sendMessage(ChatColor.DARK_PURPLE + "YOUTUBE: " + ChatColor.WHITE + "https://www.youtube.com/@VioletsMC");
                    // left it like this for bedrock, since they can't click in chat
                    return true;
                }
                if (args[0].equalsIgnoreCase("instagram")) {
                    p.sendMessage(ChatColor.DARK_PURPLE + "INSTAGRAM: " + ChatColor.WHITE + "https://www.instagram.com/play.violetsmc/");
                    return true;
                }
                if (args[0].equalsIgnoreCase("discord")) {
                    p.sendMessage(ChatColor.DARK_PURPLE + "DISCORD: " + ChatColor.WHITE + "https://discord.gg/violets");
                    return true;
                }
                if (args[0].equalsIgnoreCase("tiktok")) {
                    p.sendMessage(ChatColor.DARK_PURPLE + "TIKTOK: " + ChatColor.WHITE + "https://www.tiktok.com/@play.violetsmc");
                    return true;
                }
            }
        }
        return true;
    }

}
