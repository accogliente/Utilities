package Tools;

import me.accogliente.utilities.Utilities;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    //messages.yml reg
    private static File msgfile;
    private static FileConfiguration msgconfig;

    //messages.yml setup
    public static void setupmsg(){
        msgfile = new File(Utilities.get()
                .getServer().getPluginManager().getPlugin("Utilities").getDataFolder(), "messages.yml");

        if(!msgfile.exists()){
            try {
                msgfile.createNewFile();
            } catch (IOException e){

            }
        }
        msgconfig = YamlConfiguration.loadConfiguration(msgfile);
    }

    //messages.yml get
    public static FileConfiguration getmsg(){
        return msgconfig;
    }

    //messages.yml save
    public static void savemsg(){
        try {
            msgconfig.save(msgfile);
        }catch (IOException e){
            System.out.print("messages.yml ERROR");
        }
    }

    //messages.yml reload
    public static void reloadmsg(){
        msgconfig = YamlConfiguration.loadConfiguration(msgfile);
    }

}
