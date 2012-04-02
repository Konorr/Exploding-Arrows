package me.konor.explodingarrows;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ExplodingArrowsListener implements Listener {

    private ExplodingArrows plugin;

    public ExplodingArrowsListener(ExplodingArrows plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onProjectileHit(ProjectileHitEvent event) {
        Entity entity = event.getEntity();

        if (entity instanceof Arrow) {
            Arrow arrow = (Arrow) entity;
            Entity shooter = arrow.getShooter();
            if (arrow.getShooter() instanceof Player) {
                Player player = (Player) shooter;

                if (plugin.enabledPlayers.contains(player.getName())) {
                    player.getWorld().createExplosion(arrow.getLocation(), 7F);
                }
            }
        }
    }
}
