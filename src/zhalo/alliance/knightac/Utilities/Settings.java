package zhalo.alliance.knightac.Utilities;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;
import static org.bukkit.Material.*;

public class Settings {
	
	public static final Double MAX_XZ_SPEED = 0.66D;
	public static final Double MAX_XZ_EATING_SPEED = 0.10177D;
	public static final Double MAX_XZ_BLOCKING_SPEED = 0.12D;
	
	public static final String NOTIFY = "knight.notify"; 
	public static final String CRINGE = "used";
	
	public static final List<Material> FOODS;
	public static final Integer MAX_WARNINGS = 15;
	public static final Double MAX_XZ_BLOCK_SPEED = 0.6714D;
	public static final Long FOOD_MIN = 1000L;
	public static final Long BOW_MIN = 100L;
	public static final String ADMIN = "knight.admin";
	public static final Long MIN_HEAL_DELAY = 4500L; 
	
	public static final Double MAX_JUMP_SECOND = 0.33319D;
	public static final Double MAX_JUMP_FIRST = 0.419999D;
	public static final int MAX_JUMP = 5;
	
	static {
		FOODS = new ArrayList<Material>();
		FOODS.add(RAW_CHICKEN);
		FOODS.add(RAW_BEEF);
		FOODS.add(RAW_FISH);
		
		FOODS.add(COOKED_FISH);
		FOODS.add(COOKED_CHICKEN);
		FOODS.add(COOKED_BEEF);
		
		FOODS.add(GOLDEN_CARROT);
		FOODS.add(GOLDEN_APPLE);
		
		FOODS.add(CARROT);
		FOODS.add(APPLE);
		FOODS.add(POTATO);
		FOODS.add(POTATO_ITEM);
		FOODS.add(POISONOUS_POTATO);
		FOODS.add(BAKED_POTATO);
		FOODS.add(MUSHROOM_SOUP);
	}
}
