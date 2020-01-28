package zhalo.alliance.knightac.Events;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;

import zhalo.alliance.knightac.Main;
import zhalo.alliance.knightac.Checks.CheckResult;
import zhalo.alliance.knightac.Checks.CheckType;
import zhalo.alliance.knightac.Checks.Level;
import zhalo.alliance.knightac.Checks.Player.FastHeal;
import zhalo.alliance.knightac.Checks.Player.FastUse;
import zhalo.alliance.knightac.Utilities.Settings;
import zhalo.alliance.knightac.Utilities.User;

public class PlayerListener implements Listener {
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		User u = Main.getUser(e.getPlayer());
		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK &&
				e.getPlayer().getItemInHand() != null && Settings.FOODS.contains(e.getPlayer().getItemInHand().getType())) {
			u.setFoodStarting();
			u.resetInvalidFoodEateableCount();
		}
		if (e.getPlayer().getItemInHand().getType() == Material.BOW && e.getPlayer().getInventory().contains(Material.ARROW)) {
			u.setBowStart(System.currentTimeMillis());
			u.setBow(true);
		}
	}
	
	@EventHandler
	public void onFoodLevelChange(FoodLevelChangeEvent e) {
		User u = Main.USERS.get(e.getEntity().getUniqueId());
		if (u.getPlayer().getItemInHand() != null && Settings.FOODS.contains(u.getPlayer().getItemInHand().getType())) {
			if (u.getInvalidFoodEateableCount() != 0) {
				e.setCancelled(true);
				u.getPlayer().teleport(u.getFoodStartLocation());
				Main.log(new CheckResult(Level.DEFINITELY, "tried to move too fast whilst eating, " + u.getInvalidFoodEateableCount() + " times in a row, max=(0)", CheckType.NOSLOWA), u);
			}
		}
		CheckResult result = FastUse.runFood(u);
		if (result.failed()) {
			e.setCancelled(true);
			Main.log(result, u);
		}
	}
	
	@EventHandler
	public void onShoot(ProjectileLaunchEvent e) {
		User u = Main.USERS.get(e.getEntity().getUniqueId());
		CheckResult result = FastUse.runBow(u);
		if (result.failed()) {
			e.setCancelled(true);
			Main.log(result, u);
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onRegen(EntityRegainHealthEvent e) {
		if (e.getEntityType() == EntityType.PLAYER) {
			CheckResult result = FastHeal.runCheck((Player) e.getEntity());
			if (result.failed()) {
				e.setCancelled(true);
				e.setAmount(0);
				Main.log(result, Main.getUser((Player) e));
			}
		}
	}
	
	@EventHandler
	public void onItemSwitch(PlayerItemHeldEvent e) {
		Main.getUser(e.getPlayer()).setBow(false);
	}

}
