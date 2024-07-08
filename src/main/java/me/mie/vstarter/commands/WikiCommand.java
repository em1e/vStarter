package me.mie.vstarter.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class WikiCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("wiki"))
            sender.sendMessage(ChatColor.DARK_PURPLE + "WIKI: " + ChatColor.WHITE + "wiki link here");
        return true;
    }
}
