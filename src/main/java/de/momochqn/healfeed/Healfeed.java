package de.momochqn.healfeed;

import de.momochqn.healfeed.commands.feedcommand;
import de.momochqn.healfeed.commands.healcommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Optional;

public final class Healfeed extends JavaPlugin {

    private static Healfeed instance;
    public static String prefix;
    public static String healmessage;
    public static String gothealed;
    public static String healedother;
    public static String feedmessage;
    public static String gotfed;
    public static String fedother;
    public static String playeroffline;
    public static String noperms;


    @Override
    public void onEnable() {
        getCommand("heal").setExecutor(new healcommand());
        getCommand("feed").setExecutor(new feedcommand());
        instance = this;
        loadConfig();
        loadStrings();
    }

    @Override
    public void onDisable() {
    }

    public void loadConfig() {
        FileConfiguration cfg = getConfig();
        cfg.addDefault("Config.Prefix", "&7&l[&e&lHeal&7&l-&6&lFeed&7&l] ");
        cfg.addDefault("Config.HealMessage", "&aYou healed yourself.");
        cfg.addDefault("Config.GotHealed", "&aYou got healed.");
        cfg.addDefault("Config.HealedOther", "&aYou healed this person.");
        cfg.addDefault("Config.FeedMessage", "&aYou fed yourself.");
        cfg.addDefault("Config.GotFed", "&aYou got fed.");
        cfg.addDefault("Config.FedOther", "&aYou fed this person.");
        cfg.addDefault("Config.PlayerOffline", "&cThis player is offline.");
        cfg.addDefault("Config.NoPerms", "&cYou don't have permissions to use this command.");
        cfg.options().copyDefaults(true);
        saveConfig();
        reloadConfig();
    }
    public void loadStrings() {
        FileConfiguration cfg = getConfig();
        prefix = cfg.getString("Config.Prefix").replace("&", "§");
        healmessage = cfg.getString("Config.HealMessage").replace("&", "§");
        gothealed = cfg.getString("Config.GotHealed").replace("&", "§");
        healedother = cfg.getString("Config.HealedOther").replace("&", "§");
        feedmessage = cfg.getString("Config.FeedMessage").replace("&", "§");
        gotfed = cfg.getString("Config.GotFed").replace("&", "§");
        fedother = cfg.getString("Config.FedOther").replace("&", "§");
        playeroffline = cfg.getString("Config.PlayerOffline").replace("&", "§");
        noperms = cfg.getString("Config.PlayerOffline").replace("&", "§");
    }
}
