package zhalo.alliance.knightac.Checks.Movement;

import zhalo.alliance.knightac.Checks.CheckResult;
import zhalo.alliance.knightac.Checks.CheckType;
import zhalo.alliance.knightac.Checks.Level;
import zhalo.alliance.knightac.Utilities.Distance;
import zhalo.alliance.knightac.Utilities.Settings;
import zhalo.alliance.knightac.Utilities.User;

public class SpeedA {
	
	private static final CheckResult PASS = new CheckResult(Level.PASSED, null, CheckType.SPEEDA);
	
	public static CheckResult runCheck(Distance d, User u) {
		Double xz_speed = (d.getxDiff() > d.getzDiff() ? d.getxDiff() : d.getzDiff());
		if (xz_speed > Settings.MAX_XZ_SPEED) 
			return new CheckResult(Level.DEFINITELY, "tried to move faster than normal, speed=(" +  xz_speed.toString() + ") max=(" + Settings.MAX_XZ_SPEED, CheckType.SPEEDA);
		return PASS;
	}

}
