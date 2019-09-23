package com.mightydanp.eot.common.config;

import com.mightydanp.eot.common.handler.ConfigurationHandler;

import net.minecraftforge.common.config.Configuration;

public class BlockConfiguration {
	
	public static boolean essenceStoneEnable;
	public static boolean oreCopperEnable;
	public static boolean oreTinEnable;
	public static boolean oreSilverEnable;
	public static boolean oreRubyEnable;
	public static boolean oreSapphireEnable;
	public static boolean blockCopperEnable;
	public static boolean blockTinEnable;
	public static boolean blockSilverEnable;
	public static boolean blockRubyEnable;
	public static boolean blockSapphireEnable;

	public static void init(){
		Configuration config = ConfigurationHandler.config;
		blockCopperEnable = config.get("Enabled Blocks", "Enable Copper Ore", true).getBoolean(true);
		blockTinEnable = config.get("Enabled Blocks", "Enable Tin Ore", true).getBoolean(true);
		blockSilverEnable = config.get("Enabled Blocks", "Enable Silver Ore", true).getBoolean(true);
		blockRubyEnable = config.get("Enabled Blocks", "Enable Ruby Ore", true).getBoolean(true);
		blockSapphireEnable = config.get("Enabled Blocks", "Enable Sapphire Ore", true).getBoolean(true);
	}

}
