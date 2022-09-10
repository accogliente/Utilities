package Commands;

import Tools.ConfigManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class UtilReload implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("utilreload")){
            ConfigManager.loadmsg();
            ConfigManager.save();
            sender.sendMessage("Utilities.jar RELOAD");
            sender.sendMessage("Prefix: " + ConfigManager.getmsg().getString("Prefix"));
        }
        return true;
    }
}
