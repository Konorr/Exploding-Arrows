package me.konor.explodingarrows;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ExplodingArrowsExecutor implements CommandExecutor {

    private ExplodingArrows plugin;

    public ExplodingArrowsExecutor(ExplodingArrows instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You cannot send this command from console");
            return true;

        }

        Player player = (Player) sender;
        String playerName = player.getName();



        if (plugin.enabledPlayers.contains(playerName)) {
            plugin.enabledPlayers.remove(playerName);
            player.sendMessage(ChatColor.GREEN + "Exploding Arrows disabled.");
        } else {
            plugin.enabledPlayers.add(playerName);
            player.sendMessage(ChatColor.GREEN + "Exploding Arrows enabled.");
        }
        return true;
    }
}
