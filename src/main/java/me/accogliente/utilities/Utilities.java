package me.accogliente.utilities;

import Commands.*;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Utilities extends JavaPlugin {

    private static Utilities plugin;
    FileConfiguration config;
    File configfile;


    @Override
    public void onEnable() {
        plugin = this;

        config = getConfig();
        config.options().copyDefaults(true);
        saveConfig();
        configfile = new File(getDataFolder(), "config.yml");

        //custom configs setup
        //ConfigManager.setupconfigs();


        //main
        config.addDefault("Prefix", "&2[Utilities]&r ");
        config.addDefault("Only_for_players", "Only for players");
        //config.addDefault("Success", "&aSuccess!");
        ////command /heal
        //config.addDefault("Heal_full_HP", "&cYour HP is full!");
        ////command /spawn
        //config.addDefault("Spawn_error", "&cSpawn location does not found.");
        //config.addDefault("Spawn_set", "&aSpawn set!");
        ////command /gm
        //config.addDefault("Game_mode_creative", "&fYour game mode change to &bCreative");
        //config.addDefault("Game_mode_adventure", "&fYour game mode change to &3Adventure");
        //config.addDefault("Game_mode_survival", "&fYour game mode change to &aSurvival");
        //config.addDefault("Game_mode_spectator", "&fYour game mode change to &2Spectator");
        //config.addDefault("Game_mode_error", "&cType argument (0/1/2/3)!");
        ////command /feed
        //config.addDefault("Feed_error", "&cYou are not hungry!");


        //config.options().copyDefaults(true);
        //saveConfig();


        //Message on enable
        //getServer().getConsoleSender().sendMessage(TM.prefix + "Plugin is enabled");

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
            this.getCommand("utilreload").setExecutor(this.get());
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
        //getServer().getConsoleSender().sendMessage(TM.prefix + "Plugin is disabled");
    }

    public static Utilities get(){
        return plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("utilreload")) {
            config = YamlConfiguration.loadConfiguration(configfile);
            sender.sendMessage(ChatColor.GREEN + "Reloaded Annoucer config!");
        }
        return true;
    }
}
