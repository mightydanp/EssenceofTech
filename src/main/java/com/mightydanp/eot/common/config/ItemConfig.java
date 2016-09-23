package com.mightydanp.eot.common.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

/**
 * @auther MightyDanp date class created: Jul 22, 2016
 */
public class ItemConfig {

    public static Configuration config;

    public static Boolean shouldEndermanFleshTeleport;
    public static int magicStoneCooldown;

    public static void initialize(File file) {
        config = Config.config;

        shouldEndermanFleshTeleport = config.get("Item Varbles", "Should Enderman Flesh be able to teleport you randomly", true).getBoolean(true);
        magicStoneCooldown = config.getInt("The cooldown of Magical Stone in ticks.*20 Ticks = 1 second*", "Item Varbles", 180, 4, (int) Double.POSITIVE_INFINITY, "20 Ticks = 1 second");

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
