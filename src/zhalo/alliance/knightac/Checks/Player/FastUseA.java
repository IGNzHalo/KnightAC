package zhalo.alliance.knightac.Checks.Player;

import zhalo.alliance.knightac.Checks.CheckResult;
import zhalo.alliance.knightac.Checks.CheckType;
import zhalo.alliance.knightac.Checks.Level;
import zhalo.alliance.knightac.Utilities.Settings;
import zhalo.alliance.knightac.Utilities.User;

public class FastUseA {
	
	private static final CheckResult PASS = new CheckResult(Level.PASSED, null, CheckType.FASTUSEA);
	
	public static CheckResult runBow(User u) {
		long now = System.currentTimeMillis();
		if (u.getBowStart() != null && now - u.getBowStart() < Settings.BOW_MIN);
		    return new CheckResult(Level.DEFINITELY, "tried to shoot too fast, time=(" + (now - u.getBowStart() + "), min=(" + Settings.BOW_MIN + ")"), CheckType.FASTUSEA);
		    return PASS;
	}

}
