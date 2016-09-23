package com.mightydanp.eot.common.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

/**
 * @auther MightyDanp date class created: Jul 22, 2016
 */
public class DebugConfig {

    public static Configuration config;

    public static Boolean showMagicStoneCooldown;

    public static void initialize(File file) {
        config = Config.config;

        showMagicStoneCooldown = config.getBoolean("showMagicStoneCooldown", "Debug", false, "If set to true.It will display tickes left for cooldown");

        try {
            config.load();
            config.save();
        } finally {
        }
    }

    public static void save() {
        config.save();
    }
}
