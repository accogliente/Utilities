package Commands;

import Tools.ConfigManager;
import me.accogliente.utilities.Utilities;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("heal")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(Utilities.get().getConfig());
                return true;
            } else {
                Player player = ((Player) sender).getPlayer();
                if (player.getHealth() >= 20) {
                    player.sendMessage("123");
                } else {
                    player.setHealth(20);
                    player.sendMessage("123");

                }
            }
        }
        return true;
    }
}
