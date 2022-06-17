package xyz.motz.randomizer.manager;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class RandomizerManager {

    public static HashMap<Material, Material> items = new HashMap<>();

    public static void load(){
        items.clear();
        ArrayList<Material> remaining = new ArrayList<>(Arrays.asList(Material.values()));

        for (Material mat : Material.values()) {
            if (!remaining.isEmpty()) {
                int rand = new Random().nextInt(remaining.size());
                items.put(remaining.get(rand), mat);
                remaining.remove(rand);
            }
        }

    }

    public static int getAmount(){
        return new Random().nextInt(100) <= 60 ? 1 :
                new Random().nextInt(64*6)+64;
    }

    public static ItemStack getPartner(Material mat) {
        return new ItemStack(items.getOrDefault(mat, Material.DIAMOND), getAmount());
    }

}
