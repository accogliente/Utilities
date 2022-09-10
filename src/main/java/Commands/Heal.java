package Commands;

import me.accogliente.utilities.Utilities;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("heal")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("[Utilities] Only for players!");
                return true;
            } else {
                Player player = ((Player) sender).getPlayer();
                if (player.getHealth() >= 20) {
                    player.sendMessage(ChatColor.GOLD + "[Utilities] " + ChatColor.RED + "Your HP is full!");
                } else {
                    player.setHealth(20);
                    player.sendMessage(ChatColor.GOLD + "[Utilities] " + ChatColor.YELLOW + "You are been healed!");
                }
            }
        }
        return true;
    }
}
