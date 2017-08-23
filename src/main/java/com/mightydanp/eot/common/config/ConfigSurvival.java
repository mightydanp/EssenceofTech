package com.mightydanp.eot.common.config;

import com.mightydanp.eot.common.lib.ConfigReference;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.Loader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MightyDanp on 8/15/2017.
 */
public class ConfigSurvival {
    public static Configuration config;
    //
    public static boolean BETTER_ADVENTURE;
    public static boolean FORCE_SURVIVAL;
    //
    public static int MIN_ROCKS;
    public static int MAX_ROCKS;
    public static int MIN_TWIGS;
    public static int MAX_TWIGS;
    //


    public static void preInit(File file) {
        config = new Configuration(file);
        syncConfig();
    }

    private static void syncConfig() {
        String category;
        {
            category = I18n.format("config.category.survivial.name");
            config.addCustomCategoryComment(category, I18n.format("config.category.survivial.comment"));
            BETTER_ADVENTURE = config.getBoolean(I18n.format("config.better_adventure.name"), category, true, I18n.format("config.better_adventure.comment"));
            FORCE_SURVIVAL = config.getBoolean(I18n.format("config.force_survival.name"), category, true, I18n.format("config.force_survival.comment"));
        }{
            category = I18n.format("config.category.world_generation.name");
            config.addCustomCategoryComment(category, I18n.format("config.category.world_generation.comment"));
            MIN_ROCKS = config.getInt(I18n.format("config.min_rocks.name"), category, 2, 1,  256, I18n.format("config.min_rocks.comment"));
            MAX_ROCKS = config.getInt(I18n.format("config.max_rocks.name"), category, 4, 1,  256, I18n.format("config.max_rocks.comment"));
            MIN_TWIGS = config.getInt(I18n.format("config.min_twigs.name"), category, 2, 1,  256, I18n.format("config.min_twigs.comment"));
            MAX_TWIGS = config.getInt(I18n.format("config.max_twigs.name"), category, 5, 1,  256, I18n.format("config.max_twigs.comment"));
        }

        config.save();
    }
}
