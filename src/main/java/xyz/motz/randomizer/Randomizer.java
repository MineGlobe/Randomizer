package xyz.motz.randomizer;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.motz.randomizer.commands.*;
import xyz.motz.randomizer.listeners.RandomizerListener;
import xyz.motz.randomizer.manager.RandomizerManager;

import java.util.Objects;

public class Randomizer extends JavaPlugin implements Listener {

    @Getter public static Randomizer instance;

    @Getter public static boolean activated;

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getPluginManager().registerEvents(new RandomizerListener(), this);
        Objects.requireNonNull(getCommand("randomizer")).setExecutor(new RandomizerCommand());
        saveDefaultConfig();
        activated = getConfig().getBoolean("activated");
        RandomizerManager.load();
    }

}
