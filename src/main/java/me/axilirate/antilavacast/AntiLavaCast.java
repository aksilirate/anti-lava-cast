package me.axilirate.antilavacast;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class AntiLavaCast extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }





    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }




    @EventHandler
    public void onBlockForm(BlockFormEvent event) {
        if(event.getNewState().getType() == Material.COBBLESTONE){
            event.setCancelled(true);
        }
    }


}
