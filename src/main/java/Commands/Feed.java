package Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Feed implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("feed")){
            if(!(sender instanceof Player)){
                sender.sendMessage("[Utilities] Only for players!");
                return true;
            }else{
                Player player = ((Player) sender).getPlayer();
                if(player.getFoodLevel() >= 20){
                    player.sendMessage(ChatColor.GOLD + "[Utilities] "
                            + ChatColor.RED + "Your food lvl is full");
                    return true;
                }else{
                    player.setFoodLevel(20);
                    player.sendMessage(ChatColor.GOLD + "[Utilities] "
                            + ChatColor.YELLOW + "You have been feed");
                }
            }
        }
        return true;
    }
}
