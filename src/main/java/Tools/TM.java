package Tools;

import me.accogliente.utilities.Utilities;
import org.bukkit.configuration.file.FileConfiguration;

public class TM {

    public static FileConfiguration config = Utilities.get().getConfig();

    //main
    public static String prefix = config.getString("Prefix").replaceAll("&", "§");
    public static String console = config.getString("Only_for_players").replaceAll("&", "§");


    //command /heal

}
