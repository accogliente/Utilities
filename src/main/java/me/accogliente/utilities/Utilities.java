package me.accogliente.utilities;

import org.bukkit.plugin.java.JavaPlugin;

public final class Utilities extends JavaPlugin {



    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage("TEST");

    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("TEStT2");

    }
}
