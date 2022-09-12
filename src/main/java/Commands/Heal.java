package Commands;

import Tools.ConfigManager;
import Tools.TM;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("heal")) {
            ConfigManager.save();
            if (!(sender instanceof Player)) {
                sender.sendMessage(TM.prefix + TM.console);
                return true;
            } else {
                Player player = ((Player) sender).getPlayer();
                if (player.getHealth() >= 20) {
                    player.sendMessage(TM.prefix + TM.heal_error);
                } else {
                    player.setHealth(20);
                    player.sendMessage(TM.prefix + TM.success);

                }
            }
        }
        return true;
    }
}
