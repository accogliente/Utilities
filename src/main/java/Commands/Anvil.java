package Commands;

import Tools.TM;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Anvil implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(TM.prefix + "Only for players");
            return true;
        }else{
            Player player = ((Player) sender).getPlayer();
            Location loc = player.getLocation();

            player.openAnvil(loc, true);
        }
        return true;
    }
}
