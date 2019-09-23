package com.mightydanp.eot.common;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.mightydanp.eot.common.Eot;
import com.mightydanp.eot.client.gui.GuiEotInventory;
import com.mightydanp.eot.common.entities.player.EotExtendedPlayer;
import com.mightydanp.eot.common.inventory.ContainterEotInventory;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy implements IGuiHandler{
	
	private static int modGuiIndex = 10;
	public static final int eotInventory = modGuiIndex++;
	public static final int tier1Bag = modGuiIndex++;
	
	private static final Map<String, NBTTagCompound> extendedEntityData = new HashMap<String, NBTTagCompound>();

	public void preInit(FMLPreInitializationEvent event) {
	}

	public void init(FMLInitializationEvent event) {
		
	}

	public void postInit(FMLPostInitializationEvent event) {
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == CommonProxy.eotInventory){
            return new ContainterEotInventory(player, player.inventory, EotExtendedPlayer.get(player).inventoryEot);
        }else{
        	return null;
        }
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == CommonProxy.eotInventory) {
			return new GuiEotInventory(player, player.inventory, EotExtendedPlayer.get(player).inventoryEot);
        }else{
        	return null;
        }
	}
    
    public EntityPlayer getPlayerEntity(MessageContext ctx) {
		return ctx.getServerHandler().playerEntity;
	}

	public static void storeEntityData(String name, NBTTagCompound compound) {
		extendedEntityData.put(name, compound);
	}

	public static NBTTagCompound getEntityData(String name) {
		return extendedEntityData.remove(name);
	}

}
