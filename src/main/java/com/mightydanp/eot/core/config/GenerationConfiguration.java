package com.mightydanp.eot.core.config;

import com.mightydanp.eot.core.handler.ConfigurationHandler;

import net.minecraftforge.common.config.Configuration;

public class GenerationConfiguration {
	public static Boolean magicEssenceOreGeneration;
	public static Boolean airEssenceOreGeneration;
	public static Boolean earthEssenceOreGeneration;
	public static Boolean fireEssenceOreGeneration;
	public static Boolean waterEssenceOreGeneration;
	
	public static void init(){
		Configuration config = ConfigurationHandler.config;
		magicEssenceOreGeneration = config.get("Generation", "Enable Generation of Magic Essence Ore", true).getBoolean(true);
		airEssenceOreGeneration = config.get("Generation", "Enable Generation of Air Essence Ore", true).getBoolean(true);
		earthEssenceOreGeneration = config.get("Generation", "Enable Generation of Earth Essence Ore", true).getBoolean(true);
		fireEssenceOreGeneration = config.get("Generation", "Enable Generation of Fire Essence Ore", true).getBoolean(true);
		waterEssenceOreGeneration = config.get("Generation", "Enable Generation of Water Essence Ore", true).getBoolean(true);
	}

}
