package Tools;

import me.accogliente.utilities.Utilities;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.*;

public class ConfigManager {

    //messages.yml reg
    private static File msgfile;
    private static FileConfiguration msgconfig;

    //spawn.yml
    private static File spawnfile;
    private static FileConfiguration spawncfg;

    //configs setup
    public static void setupconfigs(){
        msgfile = new File(Utilities.get()
                .getServer().getPluginManager().getPlugin("Utilities").getDataFolder(), "messages.yml");
        spawnfile = new File(Utilities.get()
                .getServer().getPluginManager().getPlugin("Utilities").getDataFolder(), "spawn.yml");

        if(!msgfile.exists()){
            try {
                msgfile.createNewFile();
            } catch (IOException e){

            }
        }
        msgconfig = YamlConfiguration.loadConfiguration(msgfile);
        spawncfg = YamlConfiguration.loadConfiguration(spawnfile);
    }

    //messages.yml get
    public static FileConfiguration getmsg(){
        return msgconfig;
    }
    //spawn.yml
    public static FileConfiguration getspawn() { return spawncfg; }

    //configs save
    public static void save(){
        try {
            msgconfig.save(msgfile);
            spawncfg.save(spawnfile);
        }catch (IOException e){
            System.out.print("configs ERROR");
        }
    }

    //reload configs
    public static void reload(){
        msgconfig = YamlConfiguration.loadConfiguration(msgfile);
        spawncfg = YamlConfiguration.loadConfiguration(spawnfile);
        ConfigManager.save();
    }

    //public static void reloadmsg() throws UnsupportedEncodingException {
    //    if (msgfile == null) {
    //        msgfile = new File(Utilities.get()
    //                .getServer().getPluginManager().getPlugin("Utilities").getDataFolder(), "messages.yml");
    //    }
    //    msgconfig = YamlConfiguration.loadConfiguration(msgfile);
    //    // Look for defaults in the jar
    //    Reader defConfigStream = new InputStreamReader(Utilities.get().getResource("messages.yml"), "UTF8");
    //    if (defConfigStream != null) {
    //        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
    //        msgconfig.setDefaults(defConfig);
    //    }
    //}

}
