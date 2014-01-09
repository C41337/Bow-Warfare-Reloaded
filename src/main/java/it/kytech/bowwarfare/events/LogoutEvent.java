package it.kytech.bowwarfare.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import it.kytech.bowwarfare.Game;
import it.kytech.bowwarfare.GameManager;



public class LogoutEvent implements Listener{

    
    @EventHandler
    public void PlayerLoggout(PlayerQuitEvent e){
        Player p = e.getPlayer();
        GameManager.getInstance().removeFromOtherQueues(p, -1);
        int id = GameManager.getInstance().getPlayerGameId(p);
        if(GameManager.getInstance().isSpectator(p))
        	GameManager.getInstance().removeSpectator(p);
        if(id == -1) return;
        if(GameManager.getInstance().getGameState(id)==Game.GameState.INGAME)
            GameManager.getInstance().getGame(id).killPlayer(p, true);
        else
            GameManager.getInstance().getGame(id).removePlayer(p, true);
        
        //GameManager.getInstance().removePlayerRefrence(p);
    }
    
}
