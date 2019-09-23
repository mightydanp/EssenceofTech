package com.mightydanp.eot.client.tabs;

import tconstruct.client.tabs.AbstractTab;

import com.mightydanp.eot.Eot;
import com.mightydanp.eot.core.proxy.CommonProxy;
import com.mightydanp.eot.inventory.InventoryEotInventory;
import com.mightydanp.eot.item.ModItems;
import com.mightydanp.eot.network.PacketDispatcher;
import com.mightydanp.eot.network.server.OpenGuiMessage;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C0DPacketCloseWindow;
import net.minecraft.world.World;

public class InventoryTabEot extends AbstractTab{

	private boolean created;
	
	public InventoryTabEot() {
		super(0, 0, 0, new ItemStack(ModItems.magicalStone));
	}

    @Override
    public void onTabClicked (){
    	PacketDispatcher.sendToServer(new OpenGuiMessage(CommonProxy.eotInventory));
    }
    
    @Override
    public boolean shouldAddToList (){
        return true;
    }

}
