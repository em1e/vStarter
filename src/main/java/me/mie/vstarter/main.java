package me.mie.vstarter;

import me.mie.vstarter.commands.*;
import me.mie.vstarter.listener.HelpListener;
import me.mie.vstarter.listener.JoinListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class main extends JavaPlugin {

    private Set<String> callForHelp;

    @Override
    public void onEnable() {
        // Plugin startup logic

        saveDefaultConfig(); // save config file in resource folder

        getServer().getPluginManager().registerEvents(new JoinListener(this), this);

        loadCallForHelp();
        getServer().getPluginManager().registerEvents(new HelpListener(callForHelp), this);

        getCommand("media").setExecutor(new MediaCommand());
        getCommand("socials").setExecutor(new SocialsCommand());
        getCommand("links").setExecutor(new LinksCommand());
        getCommand("starter").setExecutor(new HelpCommand());
        getCommand("wiki").setExecutor(new WikiCommand());
    }

    public void loadCallForHelp() {
        FileConfiguration config = getConfig();
        List<String> wordList = config.getStringList("help-when");
        callForHelp = new HashSet<>(wordList);
    }

}
