package com.mightydanp.eot;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import com.mightydanp.eot.block.ModBlocks;
import com.mightydanp.eot.client.gui.GuiEotInventory;
import com.mightydanp.eot.core.handler.ConfigurationHandler;
import com.mightydanp.eot.core.handler.EotEventHandler;
import com.mightydanp.eot.core.handler.GenerationHandler;
import com.mightydanp.eot.core.handler.RecipeHandler;
import com.mightydanp.eot.core.handler.RegistryHandler;
import com.mightydanp.eot.core.proxy.CommonProxy;
import com.mightydanp.eot.item.ModItems;
import com.mightydanp.eot.lib.References;
import com.mightydanp.eot.network.PacketDispatcher;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.ReflectionHelper;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

import org.apache.logging.log4j.Logger;

import tconstruct.client.tabs.TabRegistry;

@Mod(
        modid = References.MODID,
        name = References.MODNAME,
        version = References.VERSION
)

public class Eot {
	@Mod.Instance(References.MODID)
    public static Eot instance;
	public static Logger modLogger;
	
	@SidedProxy(
            clientSide = References.CLIENTPROXY,
            serverSide = References.COMMONPROXY
    )
	
	public static CommonProxy proxy;
	
	public static Configuration config;
	
	public static int render = RenderingRegistry.getNextAvailableRenderId();
	
	public static CreativeTabs eotTab = new CreativeTabs(References.MODID){
        public Item getTabIconItem(){
            return Items.map;
        }
    };
    
    public static final Field buttonList = ReflectionHelper.findField(GuiScreen.class, new String[]{"buttonList", "field_146292_n"});
    
    static{
    	buttonList.setAccessible(true);
    	try {
			List<GuiButton> list = (List<GuiButton>) buttonList.get(GuiScreen.class);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
    }
	@Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        this.modLogger = event.getModLog();
        this.modLogger.info("Pre-Initialization Started");
        buttonList.isAccessible();
        ConfigurationHandler.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + References.MODNAME + File.separator + References.MODID.toUpperCase()+ "Main" + ".cfg"));
		ModItems.init();
		ModBlocks.init();
		RecipeHandler.init();
		Eot.proxy.preInit(event);
		PacketDispatcher.registerPackets();
        this.modLogger.info("Pre-Initialization Ended");
    }
	
	GenerationHandler generatorHandler = new GenerationHandler();
	
	@Mod.EventHandler
    public void init(FMLInitializationEvent event){
		this.modLogger.info("Initialization Started");
		MinecraftForge.EVENT_BUS.register(TabRegistry.class);
		NetworkRegistry.INSTANCE.registerGuiHandler(Eot.instance, new CommonProxy());
		MinecraftForge.EVENT_BUS.register(new EotEventHandler());
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.hammerMysterious),1,2,6));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.hammerMysterious),1,2,6));
		Eot.proxy.init(event);
		GameRegistry.registerWorldGenerator(generatorHandler, 0);
	    this.modLogger.info("Initialization Ended");	
	}
	
	@Mod.EventHandler
    public void  postInit(FMLPostInitializationEvent event){
	    this.modLogger.info("Post-Initialization Started");
	    Eot.proxy.postInit(event);
	    this.modLogger.info("Post-Initialization Ended");
	  }
	
}
