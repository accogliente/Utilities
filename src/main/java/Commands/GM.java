package Commands;

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
                sender.sendMessage("123");
                return true;
            }else{
                Player player = ((Player) sender).getPlayer();
                if(args.length <= 0){
                    player.sendMessage("123");
                    return true;
                }else{
                    if(args[0].equalsIgnoreCase("0")){
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage("123");
                    }else if(args[0].equalsIgnoreCase("1")){
                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage("123");
                    }else if(args[0].equalsIgnoreCase("2")){
                        player.setGameMode(GameMode.ADVENTURE);
                        player.sendMessage("123");
                    }else if(args[0].equalsIgnoreCase("3")){
                        player.setGameMode(GameMode.SPECTATOR);
                        player.sendMessage("123");
                    }
                }
            }
        }
        return true;
    }
}
