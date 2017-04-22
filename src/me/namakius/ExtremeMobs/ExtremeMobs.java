package me.namakius.ExtremeMobs;

import org.bukkit.plugin.java.JavaPlugin;

public class ExtremeMobs extends JavaPlugin {
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ExtremeMobsListener(this), this);

        System.out.println("[ExtremeMobs] Ready for battle");
    }

    public void onDisable() {
        System.out.println("[ExtremeMobs] Fallback!");
    }
}
