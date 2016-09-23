package com.mightydanp.eot.common.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

/**
 * @auther MightyDanp
 * date class created: Jul 5, 2016 
 */

public class Config {
    
    public static Configuration config;
    
    public static boolean dropChanceEssenceStone;
    
    public static void initialize(File file){
        config = new Configuration(file);
        BlockConfig.initialize(file);
        ItemConfig.initialize(file);
        DebugConfig.initialize(file);
        try{
            config.load();
        } finally {
            config.save();
        }
    }

    public static void save() {
        config.save();
    }

}
