package Commands;

import me.accogliente.utilities.Utilities;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Heal implements CommandExecutor, Listener {

    private Utilities plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("heal")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("plugin.test" + "Only for players!");
                return true;
            } else {
                Player player = ((Player) sender).getPlayer();
                if (player.getHealth() >= 20) {
                    player.sendMessage("plugin.test" + "" + "Your HP is full!");
                } else {
                    player.setHealth(20);
                    player.sendMessage("plugin.test" + "You are been healed!");
                }
            }
        }
        return true;
    }
}
