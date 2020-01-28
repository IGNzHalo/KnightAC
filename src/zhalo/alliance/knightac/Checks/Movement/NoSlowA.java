package zhalo.alliance.knightac.Checks.Movement;

import zhalo.alliance.knightac.Checks.CheckResult;
import zhalo.alliance.knightac.Checks.CheckType;
import zhalo.alliance.knightac.Checks.Level;
import zhalo.alliance.knightac.Utilities.Distance;
import zhalo.alliance.knightac.Utilities.Settings;
import zhalo.alliance.knightac.Utilities.User;

public class NoSlowA {
	
	public static final CheckResult PASS = new CheckResult(Level.PASSED, null, CheckType.NOSLOWA);

	public static void registerMove(Distance d, User u) {
		double xzDist = (d.getxDiff() > d.getzDiff() ? d.getxDiff() : d.getzDiff());
		if (xzDist > Settings.MAX_XZ_EATING_SPEED && u.getFoodStarting() != null && System.currentTimeMillis() - u.getFoodStarting() > 1200)
			u.addInvalidFoodEateableCount();
	}
	
	public static CheckResult runCheck(Distance d, User u) {
		double xzDist = (d.getxDiff() > d.getzDiff() ? d.getxDiff() : d.getzDiff());
		if (u.getPlayer().isBlocking()) {
				if (xzDist > Settings.MAX_XZ_BLOCKING_SPEED) 
			return new CheckResult(Level.DEFINITELY, "tried to move too fast whislt blocking", CheckType.NOSLOWA);
		}
		return PASS;
	}

}
