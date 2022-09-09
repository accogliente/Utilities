package Commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Back implements CommandExecutor, Listener {

    private Location deathloc;

    @EventHandler
    public void death(PlayerDeathEvent event){
        Player player = event.getPlayer();
        deathloc = player.getLastDeathLocation();
        player.sendMessage(ChatColor.GOLD + "[Utilities] " + ChatColor.YELLOW + "Use /back for back to last death location");
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("back")){
            if(!(sender instanceof Player)){
                sender.sendMessage("[Utilities] Only for players");
                return true;
            }else{
                Player player = ((Player) sender).getPlayer();
                if(deathloc == null){
                    player.sendMessage(ChatColor.GOLD + "[Utilities] "
                            + ChatColor.RED + "ERROR!");
                    return true;
                }else{
                    player.teleport(deathloc);
                    player.sendMessage(ChatColor.GOLD + "[Utilities] "
                            + ChatColor.YELLOW + "Success!");
                }
            }

        }
        return true;
    }
}
