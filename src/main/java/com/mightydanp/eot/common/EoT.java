package com.mightydanp.eot.common;

import com.mightydanp.eot.common.block.ModBlocks;
import com.mightydanp.eot.common.config.ConfigSurvival;
import com.mightydanp.eot.common.handler.EventHandler;
import com.mightydanp.eot.common.item.ModItems;
import com.mightydanp.eot.common.lib.Reference;
import com.mightydanp.eot.common.world.gen.WorldGen;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.io.File;
import java.util.logging.Logger;

@Mod(modid = EoT.MOD_ID, version = EoT.MOD_VERSION)
public class EoT {
    public static final String MOD_ID = Reference.MOD_ID;
    public static final String MOD_VERSION = Reference.MOD_VERSION;
    public static final CreativeTabs tabEot = new CreativeTabs(MOD_ID) {
        @Override
        public Item getTabIconItem() {
            return ModItems.rock;
        }
    };

    @Mod.Instance(MOD_ID)
    public static EoT instance;
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_LOCATION, serverSide = Reference.COMMON_PROXY_LOCATION)
    public static CommonProxy proxy;
    public static Logger log;

    public static File configDir;
    public static File getConfigDir(){
        return configDir;
    }


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        event.getModMetadata().version = Reference.MOD_VERSION;

        configDir = new File(event.getModConfigurationDirectory() + "/" + Reference.MOD_ID.toUpperCase());
        configDir.mkdirs();
        ConfigSurvival.preInit(new File(configDir.getPath(), "SurvivialSettings.cfg"));

        ModItems.preInit();
        ModBlocks.preInit();
        EoT.proxy.preInit();
        //Config.save();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        EventHandler handler = new EventHandler();
        MinecraftForge.EVENT_BUS.register(handler);
        GameRegistry.registerWorldGenerator(new WorldGen(), 0);
        FMLCommonHandler.instance().bus().register(handler);
        EoT.proxy.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        EoT.proxy.postInit();
    }
}
