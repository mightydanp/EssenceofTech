package com.mightydanp.eot.common.inventory;

import com.mightydanp.eot.common.item.ItemTier1Bag;
import com.mightydanp.eot.common.item.ItemTier2Bag;
import com.mightydanp.eot.common.item.ItemTier3Bag;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SlotBag extends Slot{
	
	public SlotBag(IInventory inventory, int index, int xPos, int yPos){
		super(inventory, index, xPos, yPos);
	}

	public boolean isItemValid(ItemStack itemstack){
		if(itemstack.getItem() instanceof ItemTier1Bag){
			return true;
		}if(itemstack.getItem() instanceof ItemTier2Bag){
			return true;
		}if(itemstack.getItem() instanceof ItemTier3Bag){
			return true;
		}else{
			return false;
		}
	}

}