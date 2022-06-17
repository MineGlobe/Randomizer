package xyz.motz.randomizer.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import xyz.motz.randomizer.manager.RandomizerManager;

public class ShuffleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        RandomizerManager.load();
        sender.sendMessage(ChatColor.AQUA + "[RANDOMIZER] " + ChatColor.GREEN
                + "The Random Pairs were successfully regenerated!");
        return true;
    }
}
