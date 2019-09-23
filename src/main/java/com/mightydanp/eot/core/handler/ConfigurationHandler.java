package com.mightydanp.eot.core.handler;

import java.io.File;
import java.util.logging.Level;

import com.mightydanp.eot.core.config.BlockConfiguration;
import com.mightydanp.eot.core.config.GeneralConfiguration;
import com.mightydanp.eot.core.config.GenerationConfiguration;
import com.mightydanp.eot.core.config.ItemConfiguration;
import com.mightydanp.eot.lib.References;

import cpw.mods.fml.common.FMLLog;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class ConfigurationHandler {

	public static Configuration config;
	
	public static void init(File file){
		config = new Configuration(file);

		try{
			config.load();
			ItemConfiguration.init();
			BlockConfiguration.init();
			GenerationConfiguration.init();
			GeneralConfiguration.init();
			}
		finally{
			config.save();
		}
	}
}