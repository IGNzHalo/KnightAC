package zhalo.alliance.knightac.Events;

import org.bukkit.event.EventHandler;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import zhalo.alliance.knightac.Main;
import zhalo.alliance.knightac.Checks.CheckResult;
import zhalo.alliance.knightac.Checks.Movement.Glide;
import zhalo.alliance.knightac.Checks.Movement.NoSlowA;
import zhalo.alliance.knightac.Checks.Movement.NormalMovements;
import zhalo.alliance.knightac.Checks.Movement.SpeedA;
import zhalo.alliance.knightac.Utilities.Distance;
import zhalo.alliance.knightac.Utilities.User;

public class MoveListener implements Listener {
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		User u = Main.USERS.get(e.getPlayer().getUniqueId());
		Distance d = new Distance(e);
		CheckResult speed = SpeedA.runCheck(d, u);
		CheckResult noSlow = NoSlowA.runCheck(d, u);
		NoSlowA.registerMove(d, u);
		if (speed.failed()) {
			e.setTo(e.getFrom());
			Main.log(speed, u);
		}
		if (noSlow.failed()) {
			e.setTo(e.getFrom());
			Main.log(noSlow, u);
		}
		CheckResult normalMovements = NormalMovements.runCheck(u, d);
		if (normalMovements.failed()) {
			e.setTo(e.getFrom());
			Main.log(normalMovements, u);
			u.jump = 0;
		}
	}
	
	@EventHandler
	public void onJoin(PlayerMoveEvent e) {
		User user = Main.getUser(e.getPlayer());
		Distance distance = new Distance(e);
		CheckResult glide = Glide.runCheck(user, distance);
		if (glide.failed()) {
			Main.log(glide, user);
			e.setTo(e.getFrom());
		}
	}
	
}
