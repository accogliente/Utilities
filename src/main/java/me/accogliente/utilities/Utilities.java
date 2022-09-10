package me.accogliente.utilities;

import Commands.*;
import Tools.ConfigManager;
import Tools.TM;
import org.bukkit.plugin.java.JavaPlugin;

public final class Utilities extends JavaPlugin {

    private static Utilities plugin;

    @Override
    public void onEnable() {
        plugin = this;

        //custom configs setup
        ConfigManager.setupconfigs();

        ConfigManager.getmsg().addDefault("Prefix", "[Utilities] ");
        ConfigManager.getmsg().addDefault("Only_for_players", "Only for players");
        ConfigManager.getmsg().addDefault("Heal_full_HP", "Your HP is full");
        ConfigManager.getmsg().addDefault("Heal_success", "Success!");
        ConfigManager.getmsg().options().copyDefaults(true);

        ConfigManager.save();


        //config.yml setup
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();


        //Message on enable
        getServer().getConsoleSender().sendMessage(TM.prefix + " Plugin is enabled");

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
            //Command /utilreload
            this.getCommand("utilreload").setExecutor(new UtilReload());
            //Command /spawn & /setspawn
            this.getCommand("spawn").setExecutor(new Spawn());
            this.getCommand("setspawn").setExecutor(new Spawn());
            //Command /wb
            this.getCommand("wb").setExecutor(new WB());
            //Command /anvil
            this.getCommand("anvil").setExecutor(new Anvil());
            //Command /ec
            this.getCommand("ec").setExecutor(new EC());

    }

    @Override
    public void onDisable() {
        plugin = null;

        //Message on disable
        getServer().getConsoleSender().sendMessage(TM.prefix + " Plugin is disabled");
    }

    public static Utilities get(){
        return plugin;
    }


}
