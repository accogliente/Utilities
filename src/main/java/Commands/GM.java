package Commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GM implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("gm")){
            if(!(sender instanceof Player)){
                sender.sendMessage("[Utilities] Only for players!");
                return true;
            }else{
                Player player = ((Player) sender).getPlayer();
                if(args.length <= 0){
                    player.sendMessage(ChatColor.GOLD + "[Utilities] "
                            + ChatColor.RED +  "Type argument (0/1/2/3)!");
                    return true;
                }else{
                    if(args[0].equalsIgnoreCase("0")){
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(ChatColor.GOLD + "[Utilities] "
                                + ChatColor.YELLOW + "Your game mode change to Survival");
                    }else if(args[0].equalsIgnoreCase("1")){
                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage(ChatColor.GOLD + "[Utilities] "
                                + ChatColor.YELLOW + "Your game mode change to Creative");
                    }else if(args[0].equalsIgnoreCase("2")){
                        player.setGameMode(GameMode.ADVENTURE);
                        player.sendMessage(ChatColor.GOLD + "[Utilities] "
                                + ChatColor.YELLOW + "Your game mode change to Adventure");
                    }else if(args[0].equalsIgnoreCase("3")){
                        player.setGameMode(GameMode.SPECTATOR);
                        player.sendMessage(ChatColor.GOLD + "[Utilities] "
                                + ChatColor.YELLOW + "Your game mode change to Spectator");
                    }
                }
            }
        }
        return true;
    }
}
