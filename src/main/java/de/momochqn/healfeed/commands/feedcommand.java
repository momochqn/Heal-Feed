package de.momochqn.healfeed.commands;

import de.momochqn.healfeed.Healfeed;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class feedcommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("feed.use")){
                if (args.length == 0){
                    player.setFoodLevel(20);
                    player.sendMessage(Healfeed.prefix + Healfeed.feedmessage);

                }else if (args.length == 1){
                    Player target = Bukkit.getPlayer(args[0]);
                    if (player.hasPermission("feed.target")){
                        if (target != null){
                            player.setFoodLevel(20);
                            target.sendMessage(Healfeed.prefix + Healfeed.gotfed);
                            player.sendMessage(Healfeed.prefix + Healfeed.fedother);
                        }else {
                            player.sendMessage(Healfeed.prefix + Healfeed.playeroffline);
                        }
                    }else {
                        sender.sendMessage(Healfeed.prefix + Healfeed.noperms);
                    }
                }else {
                    sender.sendMessage(Healfeed.prefix + "§c/feed <player>");
                }
            }else {
                sender.sendMessage(Healfeed.prefix + Healfeed.noperms);
            }
        }else {
            sender.sendMessage(Healfeed.prefix + "You can't use this command in the console!");
        }

        return false;
    }
}
