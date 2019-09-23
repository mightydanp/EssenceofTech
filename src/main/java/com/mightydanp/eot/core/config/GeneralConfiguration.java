package com.mightydanp.eot.core.config;

import com.mightydanp.eot.core.handler.ConfigurationHandler;
import com.mightydanp.eot.lib.ItemStrings;

import net.minecraftforge.common.config.Configuration;

public class GeneralConfiguration {
	public static Boolean shouldEndermanFleshTeleport;
	public static int magicStoneCooldown;
	public static void init(){
		Configuration config = ConfigurationHandler.config;
		shouldEndermanFleshTeleport = config.get(config.CATEGORY_GENERAL, "Should Enderman Flesh be able to teleport you randomly", true).getBoolean(true);
		magicStoneCooldown = config.getInt("How many ticks should you have to wait to be able to use the Magical Stone", config.CATEGORY_GENERAL, 180, 4, (int) Double.POSITIVE_INFINITY, "");
	}
}
