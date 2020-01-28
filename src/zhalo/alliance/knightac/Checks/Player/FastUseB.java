package zhalo.alliance.knightac.Checks.Player;

import zhalo.alliance.knightac.Checks.CheckResult;
import zhalo.alliance.knightac.Checks.CheckType;
import zhalo.alliance.knightac.Checks.Level;
import zhalo.alliance.knightac.Utilities.Settings;
import zhalo.alliance.knightac.Utilities.User;

public class FastUseB {
	
	private static final CheckResult PASS = new CheckResult(Level.PASSED, null, CheckType.FASTUSEB);

	public static CheckResult runFood(User u) {
		long now = System.currentTimeMillis();
		if (u.getFoodStarting() != null && now - u.getFoodStarting() < Settings.FOOD_MIN);
		    return new CheckResult(Level.DEFINITELY, "tried to eat too fast, time=(" + (now - u.getFoodStarting() + "), min=(" + Settings.FOOD_MIN + ")"), CheckType.FASTUSEB);
		    return PASS;
	}

}
