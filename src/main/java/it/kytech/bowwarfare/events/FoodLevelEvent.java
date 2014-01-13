package it.kytech.bowwarfare.events;

import it.kytech.bowwarfare.GameManager;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.FoodLevelChangeEvent;

/**
 *
 * @author M2K
 */
public class FoodLevelEvent {

    public void onFoodLevelChange(FoodLevelChangeEvent e) {
        if ((e.getEntity() instanceof Player)) {
            Player p = (Player) e.getEntity();
            if ((GameManager.getInstance().getPlayerGameId(p) != -1) && (p.getFoodLevel() != 20)) {
                p.setFoodLevel(20);
            }
        }
    }
}
