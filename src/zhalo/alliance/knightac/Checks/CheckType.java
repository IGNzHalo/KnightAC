package zhalo.alliance.knightac.Checks;

import org.bukkit.Bukkit;
import org.bukkit.permissions.Permission;

public enum CheckType {
	
	SPEEDA("SpeedA", new Permission("knight.bypass.speeda")),
	NOSLOWA("NoSlowDownA", new Permission("knight.bypass.noslowa")),
	FASTUSEA("FastUseA", new Permission("knight.bypass.fastusea")),
	FASTUSEB("FastUseB", new Permission("knight.bypass.fastuseb")),
	FASTHEAL("FastHeal", new Permission("knight.bypass.fastheal")),
	SPEEDB("SpeedB", new Permission("knight.bypass.speedb")),
	NORMALMOVEMENTS("NormalMovements", new Permission("knight.bypass.normalmovements")),
	GLIDE("Glide", new Permission("knight.bypass.glide"));
	
	private String name;
	private Permission perm;
	
	private CheckType(String name, Permission perm) {
		this.name = name;
		this.perm = perm;
		Bukkit.getPluginManager().addPermission(perm);
	}

	public String getName() {
		return name;
	}

	public Permission getPerm() {
		return perm;
	}

}
