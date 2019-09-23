package com.mightydanp.eot.inventory;

import com.mightydanp.eot.client.gui.GuiEotInventory;
import com.mightydanp.eot.inventory.InventoryEotInventory;
import com.mightydanp.eot.inventory.SlotArmor;
import com.mightydanp.eot.item.ItemTier1Bag;
import com.mightydanp.eot.item.ItemTier2Bag;
import com.mightydanp.eot.item.ItemTier3Bag;
import com.mightydanp.eot.item.ModItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ContainterEotInventory extends Container{

	private final InventoryEotInventory inventory;
	
	private static final int ARMOR_START = InventoryEotInventory.INV_SIZE,
			ARMOR_END = ARMOR_START + 3, INV_START = ARMOR_END + 1,
			INV_END = INV_START + 26, HOTBAR_START = INV_END + 1,
			HOTBAR_END = HOTBAR_START + 8;

	public ContainterEotInventory(EntityPlayer player, InventoryPlayer inventoryPlayer, InventoryEotInventory eotInventory) {
		this.inventory = eotInventory;
		int row;
        int column;
		this.addSlotToContainer(new SlotBag(eotInventory, 0, 152, 8));

		for (column = 0; column < 4; ++column) {
			this.addSlotToContainer(new SlotArmor(player, inventoryPlayer,
					inventoryPlayer.getSizeInventory() - 1 - column, 44, 8 + column * 18,
					column));
		}

		for (column = 0; column < 3; ++column) {
			for (row = 0; row < 9; ++row) {
				this.addSlotToContainer(new Slot(inventoryPlayer,
						row + column * 9 + 9, 8 + row * 18, 84 + column * 18));
			}
		}

		for (column = 0; column < 9; ++column) {
			this.addSlotToContainer(new Slot(inventoryPlayer, column, 8 + column * 18,
					142));
		}
		
		if (eotInventory.getInventory()[0] != null && eotInventory.getInventory()[0].getItem() == ModItems.Bagtier1){
			for (column = 0; column < 3; column++)
            {
                for (row = 0; row < 6; row++)
                {
                    this.addSlotToContainer(new SlotDumby(eotInventory, row + column*6 + 36, 174 + row * 18, 12 + column * 18));
                }
            }
		}
		
		if (eotInventory.getInventory()[0] != null && eotInventory.getInventory()[0].getItem() == ModItems.Bagtier2){
			for (column = 0; column < 6; column++)
            {
                for (row = 0; row < 6; row++)
                {
                    this.addSlotToContainer(new SlotDumby(eotInventory, row + column*6 + 36, 174 + row * 18, 12 + column * 18));
                }
            }
		}
		
		if (eotInventory.getInventory()[0] != null && eotInventory.getInventory()[0].getItem() == ModItems.Bagtier3){
			for (column = 0; column < 9; column++)
            {
                for (row = 0; row < 6; row++)
                {
                    this.addSlotToContainer(new SlotDumby(eotInventory, row + column*6 + 36, 174 + row * 18, 12 + column * 18));
                }
            }
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player){
		return true;
	}

	public ItemStack transferStackInSlot(EntityPlayer player, int par2){
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(par2);
		
		if (slot != null && slot.getHasStack()){
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (par2 < INV_START){


				if (!this.mergeItemStack(itemstack1, INV_START, HOTBAR_END + 1, true)){
					return null;
				}
				slot.onSlotChange(itemstack1, itemstack);
			}else{
				if (itemstack1.getItem() instanceof ItemTier1Bag){
					if (!this.mergeItemStack(itemstack1, 0,InventoryEotInventory.INV_SIZE, false)){
						return null;
					}
				
				}else if (itemstack1.getItem() instanceof ItemTier2Bag){
					if (!this.mergeItemStack(itemstack1, 0,InventoryEotInventory.INV_SIZE, false)){
						return null;
					}
				
				}else if (itemstack1.getItem() instanceof ItemTier3Bag){
					if (!this.mergeItemStack(itemstack1, 0,InventoryEotInventory.INV_SIZE, false)){
						return null;
					}
				}else if (itemstack1.getItem() instanceof ItemArmor){
					int type = ((ItemArmor) itemstack1.getItem()).armorType;
					if (!this.mergeItemStack(itemstack1, ARMOR_START + type, ARMOR_START + type + 1, false)){
					    return null;
					}
				}else if (par2 >= INV_START && par2 < HOTBAR_START){
					if (!this.mergeItemStack(itemstack1, HOTBAR_START,HOTBAR_START + 1, false)){
						return null;
					}
				}else if (par2 >= HOTBAR_START && par2 < HOTBAR_END + 1){
					if (!this.mergeItemStack(itemstack1, INV_START,INV_END + 1, false)){
						return null;
					}
				}
			}
			if (itemstack1.stackSize == 0){
				slot.putStack((ItemStack) null);
			}else{
				slot.onSlotChanged();
			}

			if (itemstack1.stackSize == itemstack.stackSize){
				return null;
			}
			slot.onPickupFromSlot(player, itemstack1);
		}
		return itemstack;
	}
	
	@Override
	protected boolean mergeItemStack(ItemStack stack, int start, int end, boolean backwards)
	{
		boolean flag1 = false;
		int k = (backwards ? end - 1 : start);
		Slot slot;
		ItemStack itemstack1;

		if (stack.isStackable())
		{
			while (stack.stackSize > 0 && (!backwards && k < end || backwards && k >= start))
			{
				slot = (Slot) inventorySlots.get(k);
				itemstack1 = slot.getStack();

				if (!slot.isItemValid(stack)) {
					k += (backwards ? -1 : 1);
					continue;
				}

				if (itemstack1 != null && itemstack1.getItem() == stack.getItem() &&
						(!stack.getHasSubtypes() || stack.getItemDamage() == itemstack1.getItemDamage()) &&
						ItemStack.areItemStackTagsEqual(stack, itemstack1))
				{
					int l = itemstack1.stackSize + stack.stackSize;

					if (l <= stack.getMaxStackSize() && l <= slot.getSlotStackLimit()) {
						stack.stackSize = 0;
						itemstack1.stackSize = l;
						inventory.markDirty();
						flag1 = true;
					} else if (itemstack1.stackSize < stack.getMaxStackSize() && l < slot.getSlotStackLimit()) {
						stack.stackSize -= stack.getMaxStackSize() - itemstack1.stackSize;
						itemstack1.stackSize = stack.getMaxStackSize();
						inventory.markDirty();
						flag1 = true;
					}
				}

				k += (backwards ? -1 : 1);
			}
		}

		if (stack.stackSize > 0)
		{
			k = (backwards ? end - 1 : start);

			while (!backwards && k < end || backwards && k >= start) {
				slot = (Slot) inventorySlots.get(k);
				itemstack1 = slot.getStack();

				if (!slot.isItemValid(stack)) {
					k += (backwards ? -1 : 1);
					continue;
				}

				if (itemstack1 == null) {
					int l = stack.stackSize;

					if (l <= slot.getSlotStackLimit()) {
						slot.putStack(stack.copy());
						stack.stackSize = 0;
						inventory.markDirty();
						flag1 = true;
						break;
					} else {
						putStackInSlot(k, new ItemStack(stack.getItem(), slot.getSlotStackLimit(), stack.getItemDamage()));
						stack.stackSize -= slot.getSlotStackLimit();
						inventory.markDirty();
						flag1 = true;
					}
				}

				k += (backwards ? -1 : 1);
			}
		}

		return flag1;
	}
}
