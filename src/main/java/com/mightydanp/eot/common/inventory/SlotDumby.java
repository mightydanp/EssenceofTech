package com.mightydanp.eot.common.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.mightydanp.eot.common.item.ItemTier1Bag;
import com.mightydanp.eot.common.item.ItemTier2Bag;
import com.mightydanp.eot.common.item.ItemTier3Bag;

public class SlotDumby extends Slot{
	
	public SlotDumby(IInventory inventory, int index, int xPos, int yPos){
		super(inventory, index, xPos, yPos);
	}
	
	public int getSlotStackLimit(){
		return 64;
	}

	public boolean isItemValid(ItemStack itemstack){
		if(itemstack.getItem() instanceof ItemTier1Bag){
			return false;
		}if(itemstack.getItem() instanceof ItemTier2Bag){
			return false;
		}if(itemstack.getItem() instanceof ItemTier3Bag){
			return false;
		}else{
			return true;
		}
	}

}