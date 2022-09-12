package Tools;

import me.accogliente.utilities.Utilities;

public class TM {

    //main messages
    public static String prefix = Utilities.get().getConfig().getString("Prefix").replaceAll("&", "§");
    public static String console = Utilities.get().getConfig().getString("Only_for_players").replaceAll("&", "§");
    public static String success = Utilities.get().getConfig().getString("Success").replaceAll("&", "§");

    //command /heal messages
    public static String heal_error = Utilities.get().getConfig().getString("Heal_full_HP").replaceAll("&", "§");

    //command /spawn messages
    public static String spawn_error = Utilities.get().getConfig().getString("Spawn_error").replaceAll("&", "§");
    public static String spawn_set = Utilities.get().getConfig().getString("Spawn_set").replaceAll("&", "§");

    //command /gm messages
    public static String gm_creative = Utilities.get().getConfig().getString("Game_mode_creative").replaceAll("&", "§");
    public static String gm_adventure = Utilities.get().getConfig().getString("Game_mode_adventure").replaceAll("&", "§");
    public static String gm_survival = Utilities.get().getConfig().getString("Game_mode_survival").replaceAll("&", "§");
    public static String gm_spectator = Utilities.get().getConfig().getString("Game_mode_spectator").replaceAll("&", "§");
    public static String gm_error = Utilities.get().getConfig().getString("Game_mode_error").replaceAll("&", "§");

    //command /feed messages
    public static String feed_error = Utilities.get().getConfig().getString("Feed_error").replaceAll("&", "§");



}
