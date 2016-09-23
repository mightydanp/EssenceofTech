package com.mightydanp.eot.common.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

/**
 * @auther MightyDanp
 * date class created: Jul 6, 2016 
 */

public class BlockConfig {
    
    public static Configuration config;
    
    public static int dropChanceEssenceStone;
    public static Boolean generateCopper;
    public static Boolean generateTin;
    public static Boolean generateSilver;
    public static Boolean generateLead;
    public static Boolean generateRuby;
    public static Boolean generateSapphire;
    
    public static void initialize(File file){
        config = Config.config;
        
        dropChanceEssenceStone = config.get("Block Varbles", "Precent chance to drop EssenceChunks from EssenceStone.*Cannot be above 100*", 60).getInt(60);
        
        generateCopper = config.get("Generation Varbles", "Should the world generate Copper Ore", true).getBoolean(true);
        generateTin = config.get("Generation Varbles", "Should the world generate Tin Ore", true).getBoolean(true);
        generateSilver = config.get("Generation Varbles", "Should the world generate Silver Ore", true).getBoolean(true);
        generateLead = config.get("Generation Varbles", "Should the world generate Lead Ore", true).getBoolean(true);
        generateRuby = config.get("Generation Varbles", "Should the world generate Ruby Ore", true).getBoolean(true);
        generateSapphire = config.get("Generation Varbles", "Should the world generate Sapphire Ore", true).getBoolean(true);
        
        try{
            config.load();
            config.save();
        } finally {
        }
    }

    public static void save() {
        config.save();
    }

}