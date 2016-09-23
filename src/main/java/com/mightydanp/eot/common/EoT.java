package com.mightydanp.eot.common;

import java.io.File;

import org.apache.logging.log4j.Logger;

import com.mightydanp.eot.common.block.ModBlocks;
import com.mightydanp.eot.common.config.Config;
import com.mightydanp.eot.common.handler.EoTEventHandler;
import com.mightydanp.eot.common.item.ModItems;
import com.mightydanp.eot.common.lib.Reference;
import com.mightydanp.eot.common.world.gen.WorldGen;
import com.mightydanp.eot.common.world.gen.feature.WorldGenTwigs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * @auther MightyDanp
 * date class created: Jul 4, 2016 
 */

@Mod(modid = Reference.MODID, name = Reference.MODNAME , version = Reference.VERSION)

public class EoT {
    @Mod.Instance(Reference.MODID)
    public static EoT instance;
    
   
    @SidedProxy(clientSide = Reference.CLIENTPROXYLOCATION, serverSide = Reference.COMMONPROXYLOCATION)
    public static CommonProxy proxy;
    
    public File modDir;
    
    public static Logger log;
    
    public static CreativeTabs tabEoT = new CreativeTabs(Reference.MODID){
        @Override
        public Item getTabIconItem(){
            return ModItems.magicalStone;
        }
    };
    
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        event.getModMetadata().version = Reference.VERSION;
        modDir = event.getModConfigurationDirectory();
        
        try{
            Config.initialize(event.getSuggestedConfigurationFile());
        } catch (Exception e) {
            EoT.log.error(Reference.MODID + " has a problem loading it's configuration");
        } finally {
                if (Config.config != null) Config.save();
        }
        
        ModBlocks.preInit();
        ModItems.preInit();
        
        MinecraftForge.EVENT_BUS.register(new EoTEventHandler());
        
        EoT.proxy.preInit(event);
        
        Config.save();
    }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ModBlocks.init();
        ModItems.init();
        GameRegistry.registerWorldGenerator(new WorldGen(), 0);
        GameRegistry.registerWorldGenerator(new WorldGenTwigs(), 1);
        EoT.proxy.init(event);
    }
    
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        EoT.proxy.postInit(event);
    }
}