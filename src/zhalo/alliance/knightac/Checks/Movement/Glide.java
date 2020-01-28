package zhalo.alliance.knightac.Checks.Movement;

import zhalo.alliance.knightac.Checks.CheckResult;
import zhalo.alliance.knightac.Checks.CheckType;
import zhalo.alliance.knightac.Utilities.Distance;
import zhalo.alliance.knightac.Utilities.User;

public class Glide {
	
	public static final CheckResult PASS = new CheckResult(false, CheckType.GLIDE, "");

	public static CheckResult runCheck(User user, Distance distance) {
		final double oldY = user.oldY;
		final boolean wasGoingUp = user.wasGoingUp;
		user.wasGoingUp = distance.getFrom().getY() > distance.getTo().getY();
		user.oldY = distance.getyDiff();
		if (distance.getFrom().getY() > distance.getTo().getY()) {
			System.out.println("Check");
			if (oldY >= distance.getyDiff() && oldY !=0) {
					return new CheckResult(true, CheckType.GLIDE, "tried to glide; " + oldY + " <= " + user.oldY);
			}
		} else {
			user.oldY = 0;
		}
		return PASS;
	}
}
