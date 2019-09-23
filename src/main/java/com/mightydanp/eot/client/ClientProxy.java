package com.mightydanp.eot.client;

import com.mightydanp.eot.common.CommonProxy;
import com.mightydanp.eot.common.Eot;
import com.mightydanp.eot.client.tabs.InventoryTabEot;
import com.mightydanp.eot.common.handler.KeyHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import tconstruct.client.tabs.AbstractTab;
import tconstruct.client.tabs.InventoryTabVanilla;
import tconstruct.client.tabs.TabRegistry;

public class ClientProxy extends CommonProxy {
	private final Minecraft mc = Minecraft.getMinecraft();
	
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new TabRegistry());
	}

	public void init(FMLInitializationEvent event) {
		ClientProxy.registerHandlers();
		FMLCommonHandler.instance().bus().register(new KeyHandler(mc));
	}

	public void postInit(FMLPostInitializationEvent event) {
		ClientProxy.registerInventoryTabs();
	}

	public static void registerInventoryTabs() {
		if (!Loader.isModLoaded("TConstruct") && TabRegistry.getTabList().size() < 1) {
			TabRegistry.registerTab(new InventoryTabVanilla());
		}

		TabRegistry.registerTab(new InventoryTabEot());
	}

	public static void registerHandlers() {
		MinecraftForge.EVENT_BUS.register(Eot.proxy);
	}

	@Override
	public EntityPlayer getPlayerEntity(MessageContext ctx) {
		return (ctx.side.isClient() ? Minecraft.getMinecraft().thePlayer : super.getPlayerEntity(ctx));
	}
}