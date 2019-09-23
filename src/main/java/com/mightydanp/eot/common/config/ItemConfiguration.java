package com.mightydanp.eot.common.config;

import java.io.File;

import com.mightydanp.eot.common.handler.ConfigurationHandler;

import net.minecraftforge.common.config.Configuration;

public class ItemConfiguration {
	
	public static boolean magicalStoneEnable;
	public static boolean mysteriousHammerEnable;
	public static boolean endermanFleshEnable;
	public static boolean tier1BagEnable;
	public static boolean tier2BagEnable;
	public static boolean tier3BagEnable;
	public static boolean essenceChunksEnable;
	public static boolean ingotCopperEnable;
	public static boolean ingotTinEnable;
	public static boolean ingotBronzeEnable;
	public static boolean ingotSilverEnable;
	public static boolean gemRubyEnable;
	public static boolean gemSapphireEnable;
	

	public static void init(){
		Configuration config = ConfigurationHandler.config;
		magicalStoneEnable = config.get("Enabled Items", "Enable MagicalStone", true).getBoolean(true);
		mysteriousHammerEnable = config.get("Enabled Items", "Enable Mysterious Hammer", true).getBoolean(true);
		endermanFleshEnable = config.get("Enabled Items", "Enable Enderman Flesh", true).getBoolean(true);
		tier1BagEnable = config.get("Enabled Items", "Enable Tier 1 Bag", true).getBoolean(true);
		tier2BagEnable = config.get("Enabled Items", "Enable Tier 2 Bag", true).getBoolean(true);
		tier3BagEnable = config.get("Enabled Items", "Enable Tier 3 Bag", true).getBoolean(true);
		essenceChunksEnable = config.get("Enabled Items", "Enable Essence Chunks", true).getBoolean(true);
		ingotCopperEnable = config.get("Enabled Items", "Enable Copper Ingot", true).getBoolean(true);
		ingotTinEnable = config.get("Enabled Items", "Enable Tin Ingot", true).getBoolean(true);
		ingotBronzeEnable = config.get("Enabled Items", "Enable Bronze Ingot", true).getBoolean(true);
		ingotSilverEnable = config.get("Enabled Items", "Enable Silver Ingot", true).getBoolean(true);
		gemRubyEnable = config.get("Enabled Items", "Enable Ruby", true).getBoolean(true);
		gemSapphireEnable = config.get("Enabled Items", "Enable Sapphire", true).getBoolean(true);
		
	}

}
