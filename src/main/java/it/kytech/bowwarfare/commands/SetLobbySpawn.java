package it.kytech.bowwarfare.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import it.kytech.bowwarfare.MessageManager;
import it.kytech.bowwarfare.SettingsManager;

public class SetLobbySpawn implements SubCommand {

    public boolean onCommand(Player player, String[] args) {
        if (!player.hasPermission(permission()) && !player.isOp()) {
            MessageManager.getInstance().sendFMessage(MessageManager.PrefixType.ERROR, "error.nopermission", player);
            return true;
        }
        SettingsManager.getInstance().setLobbySpawn(player.getLocation());
        MessageManager.getInstance().sendFMessage(MessageManager.PrefixType.INFO, "info.lobbyspawn", player);
        return true;
    }

    @Override
    public String help(Player p) {
        return "/bw setlobbyspawn - " + SettingsManager.getInstance().getMessageConfig().getString("messages.help.setlobbyspawn", "Set the lobby spawnpoint");
    }

    @Override
    public String permission() {
        return "bw.admin.setlobby";
    }
}
