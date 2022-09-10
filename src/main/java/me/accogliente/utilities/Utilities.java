package me.accogliente.utilities;

import Commands.Back;
import Commands.Feed;
import Commands.GM;
import Commands.Heal;
import Tools.ConfigManager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Utilities extends JavaPlugin {

    private static Utilities plugin;

    @Override
    public void onEnable() {
        plugin = this;

        //messages.yml setup
        ConfigManager.setupmsg();

        ConfigManager.getmsg().addDefault("Prefix", "&c[Utilities]");

        ConfigManager.getmsg().options().copyDefaults(true);
        ConfigManager.savemsg();


        //config.yml setup
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();


        //Message on enable
        getServer().getConsoleSender().sendMessage("[Utilities] Plugin is enabled");

        //Commands reg
            //Command /heal
            this.getCommand("heal").setExecutor(new Heal());
            //Command /gm
            this.getCommand("gm").setExecutor(new GM());
            //Command /feed
            this.getCommand("feed").setExecutor(new Feed());
            //Command /back
            getServer().getPluginManager().registerEvents(new Back(), this);
            this.getCommand("back").setExecutor(new Back());
    }

    @Override
    public void onDisable() {
        plugin = null;

        //Message on disable
        getServer().getConsoleSender().sendMessage("[Utilities] Plugin is disabled");
    }

    public static Utilities get(){
        return plugin;
    }


}
