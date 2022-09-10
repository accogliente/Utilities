package Tools;

import org.bukkit.configuration.file.FileConfiguration;

public class MessagesManager {

    private FileConfiguration messages = ConfigManager.getmsg();

    public String prefix = messages.getString("Prefix").replaceAll("&","§");

}
