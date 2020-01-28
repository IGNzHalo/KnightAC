package zhalo.alliance.knightac.Utilities;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import zhalo.alliance.knightac.Checks.CheckType;

public class User {
	
	private Player player;
	private Long foodStart;
	private Long bowStart;
	private Location foodStartLocation;
	private int invalidFoodEateableCount = 0;
	private HashMap<CheckType, Integer> warnings = new HashMap<>();
	private boolean bow = false;
	private Long lastRegen;
	
	public int jump = 0;
	
	public double oldY = 0;
	
	public boolean wasGoingUp = false;
	
	public User(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setFoodStarting() {
		this.foodStart = System.currentTimeMillis();
		this.foodStartLocation = player.getLocation();
	}
	
	public Long getFoodStarting() {
		return foodStart;
	}
	
	public boolean isFoodStarting() {
		return foodStart != null;
	}
	
	public void addInvalidFoodEateableCount() {
		this.invalidFoodEateableCount++;
	}
	
	public int getInvalidFoodEateableCount() {
		return this.invalidFoodEateableCount;
	}

	public Location getFoodStartLocation() {
		return foodStartLocation;
	}

	public void resetInvalidFoodEateableCount() {
		this.invalidFoodEateableCount = 0;
	}
	
	public Long getBowStart() {
		return bowStart;
	}
	
	public void setBowStart(Long bowStart) {
		this.bowStart = bowStart;
	}
	
	public boolean isBlockAboveSolid(Location loc) {
		return isBlockAboveSolid(true, loc) || isBlockAboveSolid(false, loc);
	}
	
	public boolean isBlockAboveSolid(boolean x, Location loc) {
		return x;
	}
	
	public void setBow(boolean bow) {
		this.bow = bow;
	}
	
	public boolean isBow() {
		return bow;
	}
	
	public void addWarning(CheckType type) {
		getWarnings(type);
		warnings.put(type, warnings.get(type)+1);
	}
	
	public int getWarnings(CheckType type) {
		warnings.putIfAbsent(type, 0);
		return warnings.get(type);
	}

	public void setLastRegen() {
		this.lastRegen = System.currentTimeMillis();
	}
	
	public Long getLastRegen() {
		return lastRegen;
	}
	
}
