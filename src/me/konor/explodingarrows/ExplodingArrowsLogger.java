package me.konor.explodingarrows;

import java.util.logging.Logger;
import org.bukkit.plugin.PluginDescriptionFile;

public class ExplodingArrowsLogger {

    private ExplodingArrows plugin;
    private Logger log;

    public ExplodingArrowsLogger(ExplodingArrows plugin) {
        this.plugin = plugin;
        this.log = Logger.getLogger("Minecraft");
    }

    private String buildstring(String msg) {
        PluginDescriptionFile pdFile = plugin.getDescription();
        return "[" + pdFile.getName() + " " + pdFile.getVersion() + "]: " + msg;
    }

    public void info(String msg) {
        this.log.info(this.buildString(msg));
    }

    public void warn(String msg) {
        this.log.warning(this.buildString(msg));
    }

    public void severe(String msg) {
        this.log.severe(buildString(msg));

    }

    private String buildString(String msg) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
