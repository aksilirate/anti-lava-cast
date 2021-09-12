package me.axilirate.antilavacast;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public final class AntiLavaCast extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);

    }


    @EventHandler
    public void onBlockForm(BlockFormEvent event) {
        if (event.getBlock().getType().equals(Material.LAVA)) {
            BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
            Location blockLocation = event.getBlock().getLocation();

            scheduler.scheduleSyncDelayedTask(this, () -> {
                if (blockLocation.getBlock().getType().equals(Material.COBBLESTONE)) {
                    blockLocation.getBlock().setType(Material.AIR);
                }

            }, 300);
        }
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
