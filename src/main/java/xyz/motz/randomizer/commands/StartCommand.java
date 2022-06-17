package xyz.motz.randomizer.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import xyz.motz.randomizer.Randomizer;

public class StartCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (Randomizer.activated) {
            sender.sendMessage(ChatColor.AQUA + "[RANDOMIZER] " + ChatColor.GREEN
                    + "The Randomizer is already activated!");
        } else {
            Randomizer.getInstance().getConfig().set("activated", true);
            Randomizer.getInstance().saveConfig();
            Randomizer.activated = true;
            sender.sendMessage(ChatColor.AQUA + "[RANDOMIZER] " + ChatColor.GREEN
                    + "Successfully activated the Randomizer!");
        }
        return true;
    }
}
