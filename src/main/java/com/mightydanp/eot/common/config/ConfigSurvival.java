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

    public static boolean BETTER_ADVENTURE;
    public static boolean FORCE_SURVIVAL;

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
        }

        config.save();
    }
}
