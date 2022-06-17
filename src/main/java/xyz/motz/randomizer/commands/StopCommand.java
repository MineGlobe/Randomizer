package xyz.motz.randomizer.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import xyz.motz.randomizer.Randomizer;

public class StopCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!Randomizer.activated) {
            sender.sendMessage(ChatColor.AQUA + "[RANDOMIZER] " + ChatColor.GREEN
                    + "The Randomizer is already deactivated!");
        } else {
            Randomizer.getInstance().getConfig().set("activated", false);
            Randomizer.getInstance().saveConfig();
            Randomizer.activated = false;
            sender.sendMessage(ChatColor.AQUA + "[RANDOMIZER] " + ChatColor.GREEN
                    + "Successfully deactivated the Randomizer!");
        }
        return true;
    }
}
