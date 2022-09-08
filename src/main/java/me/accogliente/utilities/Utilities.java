package me.accogliente.utilities;

import Commands.Heal;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Utilities extends JavaPlugin {

    public int test = 2;
    public String title = "[Utilities] ";
    public Plugin Utilities;

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage("TEST");
        this.getCommand("heal").setExecutor(new Heal());
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("TEST2");
    }
}
