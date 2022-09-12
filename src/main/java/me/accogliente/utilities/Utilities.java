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

        //main
        getConfig().addDefault("Prefix", "&2[Utilities]&r ");
        getConfig().addDefault("Only_for_players", "Only for players");
        getConfig().addDefault("Success", "&aSuccess!");
        //command /heal
        getConfig().addDefault("Heal_full_HP", "&cYour HP is full!");
        //command /spawn
        getConfig().addDefault("Spawn_error", "&cSpawn location does not found.");
        getConfig().addDefault("Spawn_set", "&aSpawn set!");
        //command /gm
        getConfig().addDefault("Game_mode_creative", "&fYour game mode change to &bCreative");
        getConfig().addDefault("Game_mode_adventure", "&fYour game mode change to &3Adventure");
        getConfig().addDefault("Game_mode_survival", "&fYour game mode change to &aSurvival");
        getConfig().addDefault("Game_mode_spectator", "&fYour game mode change to &2Spectator");
        getConfig().addDefault("Game_mode_error", "&cType argument (0/1/2/3)!");
        //command /feed
        getConfig().addDefault("Feed_error", "&cYou are not hungry!");

        //config.yml setup
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();


        // ConfigManager.getmsg().options().copyDefaults(true);
        // ConfigManager.save();


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
