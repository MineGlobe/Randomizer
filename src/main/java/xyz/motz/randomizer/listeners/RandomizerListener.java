package xyz.motz.randomizer.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.server.TabCompleteEvent;
import xyz.motz.randomizer.Randomizer;
import xyz.motz.randomizer.manager.RandomizerManager;

import java.util.Arrays;

public class RandomizerListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if(e.isCancelled()) return;
        if (Randomizer.isActivated()) {
            e.setDropItems(false);
            e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(),
                    RandomizerManager.getPartner(e.getBlock().getType()));
        }
    }

    @EventHandler
    public void onTabComplete(TabCompleteEvent e) {
        if (e.getBuffer().startsWith("/randomizer"))
            e.setCompletions(Arrays.asList(
                    "shuffle",
                    "check",
                    "start",
                    "stop"
            ));
    }

}
