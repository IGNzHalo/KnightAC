package zhalo.alliance.knightac;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import zhalo.alliance.knightac.Checks.CheckResult;
import zhalo.alliance.knightac.Events.JoinLeaveListener;
import zhalo.alliance.knightac.Events.MoveListener;
import zhalo.alliance.knightac.Events.PlayerListener;
import zhalo.alliance.knightac.Utilities.Settings;
import zhalo.alliance.knightac.Utilities.User;

import static org.bukkit.ChatColor.*;

public class Main extends JavaPlugin {
	
	public static HashMap<UUID, User> USERS = new HashMap<>();
	
	@SuppressWarnings("deprecation")
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("====================================================");
		Bukkit.getConsoleSender().sendMessage("[Knight] KnightAC v1.0 Loaded");
		Bukkit.getConsoleSender().sendMessage("[Knight] MCM - zHalo");
		Bukkit.getConsoleSender().sendMessage("[Knight] Discord - zHalo#0817");
		Bukkit.getConsoleSender().sendMessage("====================================================");
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new JoinLeaveListener(), this);
		pm.registerEvents(new MoveListener(), this);
		pm.registerEvents(new PlayerListener(), this);
		
		for (Player p : Bukkit.getOnlinePlayers())
			USERS.put(p.getUniqueId(), new User(p));
	}
	
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("====================================================");
		Bukkit.getConsoleSender().sendMessage("[Knight] KnightAC v1.0 Disabled");
		Bukkit.getConsoleSender().sendMessage("[Knight] MCM - zHalo");
		Bukkit.getConsoleSender().sendMessage("[Knight] Discord - zHalo#0817");
		Bukkit.getConsoleSender().sendMessage("====================================================");
	}
	
	@SuppressWarnings("deprecation")
	public static void log(CheckResult cr, User u) {
		String message = DARK_GRAY.toString() + "[" + DARK_AQUA.toString() + "Knight" + DARK_GRAY.toString() + "]" + " " + RESET.toString() + BLUE + u.getPlayer().getName() + GRAY + " " + cr.getLevel().toString().toLowerCase() + GRAY + "using" + " " + DARK_AQUA + cr.getType().getName() + GRAY +  ": " + cr.getMessage();
		for (Player p : Bukkit.getOnlinePlayers())
			if (p.hasPermission(Settings.NOTIFY))
				p.sendMessage(message);
		Bukkit.getConsoleSender().sendMessage(message);
	}
	
	public static User getUser(Player p) {
		return USERS.get(p.getUniqueId());
	}
}
