package de.momochqn.healfeed.commands;

import de.momochqn.healfeed.Healfeed;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class healcommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

                if (sender instanceof Player){
                    Player player = (Player) sender;
                    if (player.hasPermission("heal.use")){
                        if (args.length == 0){
                            player.setHealthScale(20);
                            player.setHealth(20);
                            player.sendMessage(Healfeed.prefix + Healfeed.healmessage);

                        }else if (args.length == 1){
                            Player target = Bukkit.getPlayer(args[0]);
                            if (player.hasPermission("heal.target")){
                                if (target != null){
                                    target.setHealthScale(20);
                                    target.setHealth(20);
                                    target.sendMessage(Healfeed.prefix + Healfeed.gothealed);
                                    player.sendMessage(Healfeed.prefix + Healfeed.healedother);
                                }else {
                                    player.sendMessage(Healfeed.prefix + Healfeed.playeroffline);
                                }
                            }else {
                                sender.sendMessage(Healfeed.prefix + Healfeed.noperms);
                            }
                        }else {
                            sender.sendMessage(Healfeed.prefix + "§c/heal <player>");
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
