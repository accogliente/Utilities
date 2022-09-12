package Commands;

import Tools.ConfigManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.UnsupportedEncodingException;

public class UtilReload implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("utilreload")){
            ConfigManager.reload();
            sender.sendMessage("Utilities.jar RELOAD");
            sender.sendMessage("Prefix: " + ConfigManager.getmsg().getString("Prefix"));
        }
        return true;
    }
}
