package Commands;

import Tools.ConfigManager;
import Tools.MessagesManager;
import me.accogliente.utilities.Utilities;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("heal")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(MessagesManager.p + "Only for players!");
                return true;
            } else {
                Player player = ((Player) sender).getPlayer();
                if (player.getHealth() >= 20) {
                    player.sendMessage(MessagesManager.prefix + "Prefix Your HP is full!");
                } else {
                    player.setHealth(20);
                    player.sendMessage(MessagesManager.prefix + "Prefix You are been healed!");
                }
            }
        }
        return true;
    }
}
