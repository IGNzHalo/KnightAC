package zhalo.alliance.knightac.Checks.Movement;

import org.bukkit.block.BlockFace;

import zhalo.alliance.knightac.Checks.CheckResult;
import zhalo.alliance.knightac.Checks.CheckType;
import zhalo.alliance.knightac.Checks.Level;
import zhalo.alliance.knightac.Utilities.Distance;
import zhalo.alliance.knightac.Utilities.Settings;
import zhalo.alliance.knightac.Utilities.User;

public class SpeedB {
	
	private static final CheckResult PASS = new CheckResult(Level.PASSED, null, CheckType.SPEEDB);
	
	public static CheckResult runCheck(Distance d, User u) {
		Double xz_speed = (d.getxDiff() > d.getzDiff() ? d.getxDiff() : d.getzDiff());
		if (xz_speed > Settings.MAX_XZ_BLOCK_SPEED) {
			if (u.isBlockAboveSolid(d.getTo().getBlock().getRelative(BlockFace.UP).getRelative(BlockFace.UP).getLocation()));
		            d.getTo().getBlock().getRelative(BlockFace.UP).getRelative(BlockFace.UP).getType().isSolid();
		        return new CheckResult(Level.DEFINITELY, "tried to move faster than normal, mode: block, speed=(" + xz_speed.toString() + "), max =(" + Settings.MAX_XZ_BLOCK_SPEED, CheckType.SPEEDB);
		}
		return PASS;
	}
}
