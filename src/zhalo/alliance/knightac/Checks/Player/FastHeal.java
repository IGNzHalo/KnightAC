package zhalo.alliance.knightac.Checks.Player;

import org.bukkit.entity.Player;

import zhalo.alliance.knightac.Main;
import zhalo.alliance.knightac.Checks.CheckResult;
import zhalo.alliance.knightac.Checks.CheckType;
import zhalo.alliance.knightac.Checks.Level;
import zhalo.alliance.knightac.Utilities.Settings;
import zhalo.alliance.knightac.Utilities.User;

public class FastHeal {
	
	private static final CheckResult PASS = new CheckResult(Level.DEFINITELY, null, CheckType.FASTHEAL);

	public static CheckResult runCheck(Player player) {
		User user = Main.getUser(player);
		if (user.getLastRegen() != null) 
			player.sendMessage("" + (System.currentTimeMillis() - user.getLastRegen()));
			if (user.getLastRegen() < Settings.MIN_HEAL_DELAY)
				return new CheckResult(Level.DEFINITELY, "tried to heal too fast, delay=" + (System.currentTimeMillis() - user.getLastRegen()) + ", min=(" + Settings.MIN_HEAL_DELAY + ")", CheckType.FASTHEAL);
	    user.setLastRegen();
		return PASS;
	}
	
	

}
