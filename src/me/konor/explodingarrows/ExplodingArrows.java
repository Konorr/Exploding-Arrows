package me.konor.explodingarrows;

import java.util.ArrayList;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ExplodingArrows extends JavaPlugin {
    
    protected ExplodingArrowsLogger log;
    protected ArrayList<String> enabledPlayers;
    
    @Override
    public void onEnable() {
        this.log = new ExplodingArrowsLogger(this);
        this.enabledPlayers = new ArrayList<String>();
        
        this.getCommand("ea").setExecutor(new ExplodingArrowsExecutor(this));
        
        PluginManager manager = this.getServer().getPluginManager();
        
        manager.registerEvents(new ExplodingArrowsListener(this), this);
    }
    
    @Override
    public void onDisable() {
        
    }
}
