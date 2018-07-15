package com.mightydanp.eot.common;

import com.mightydanp.eot.common.block.ModBlocks;
import com.mightydanp.eot.common.handler.ModEventHandler;
import com.mightydanp.eot.common.lib.Reference;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.logging.Logger;

@Mod(modid = Reference.MOD_ID, version = Reference.MOD_VERSION)
public class EoT {
    public static EoT instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_LOCATION, serverSide = Reference.COMMON_PROXY_LOCATION)
    public static CommonProxy proxy;
    public static Logger log;
    public static ModEventHandler eventHandler;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println("EoT PreInitialization Started");
        EoT.proxy.preInit();
        System.out.println("EoT PreInitialization Ended");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("EoT Initialization Started");
        EoT.proxy.init();
        ModBlocks.init();
        MinecraftForge.EVENT_BUS.register(new ModEventHandler());
        System.out.println("EoT Initialization Ended");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        System.out.println("EoT PostInitialization Started");
        EoT.proxy.postInit();
        System.out.println("EoT PostInitialization Ended");
    }
}
