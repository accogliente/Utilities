package Commands;

import Tools.ConfigManager;
import Tools.TM;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Spawn implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("setspawn")){
            if(!(sender instanceof Player)){
                sender.sendMessage(TM.prefix + TM.console);
                return true;
            }else{
                Player player = ((Player) sender).getPlayer();
                Location pl = player.getLocation();

                ConfigManager.getspawn().set("World:", pl.getWorld().getName());
                ConfigManager.getspawn().set("X:", pl.getX());
                ConfigManager.getspawn().set("Y:", pl.getY());
                ConfigManager.getspawn().set("Z:", pl.getZ());
                ConfigManager.getspawn().set("Yaw:", pl.getYaw());
                ConfigManager.getspawn().set("Pitch:", pl.getPitch());
                ConfigManager.getspawn().set("Set by:", player.getName());
                ConfigManager.save();

                player.sendMessage(TM.prefix + TM.spawn_set);
            }
        }else if(command.getName().equalsIgnoreCase("spawn")){
            if(!(sender instanceof Player)){
                sender.sendMessage(TM.prefix + TM.console);
                return true;
            }else{
                Player player = ((Player) sender).getPlayer();
                if(ConfigManager.getspawn().getString("World:") == null){
                    player.sendMessage(TM.prefix + TM.spawn_error);
                    return true;
                }else{
                    World world = Bukkit.getWorld(ConfigManager.getspawn().getString("World:"));
                    float yaw = (float) ConfigManager.getspawn().getDouble("Yaw:");
                    float pitch = (float) ConfigManager.getspawn().getDouble("Pitch:");
                    int x = ConfigManager.getspawn().getInt("X:");
                    int y = ConfigManager.getspawn().getInt("Y:");
                    int z = ConfigManager.getspawn().getInt("Z:");

                    Location loc = new Location(world, ConfigManager.getspawn().getDouble("X:")
                            , ConfigManager.getspawn().getDouble("Y:")
                            , ConfigManager.getspawn().getDouble("Z:")
                            , yaw, pitch);

                    player.teleport(loc);
                    player.sendMessage(TM.prefix + TM.success);
                }
            }
        }
        return true;
    }
}
