package com.mightydanp.eot.common.inventory;

import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.UUID;

import com.mightydanp.eot.common.entities.player.EotExtendedPlayer;
import com.mightydanp.eot.common.item.ItemTier1Bag;
import com.mightydanp.eot.common.item.ModItems;

import cpw.mods.fml.common.network.ByteBufUtils;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.StringTranslate;

public class InventoryEotInventory implements IInventory {

	private final String name = "Eot Inventory";
	public WeakReference<EntityPlayer> parent;
	private final String tagName = "eotInvetoryTag";

	public static int INV_SIZE = 90;

	private ItemStack[] inventory = new ItemStack[INV_SIZE];

	public void init(EntityPlayer player) {
		parent = new WeakReference<EntityPlayer>(player);
	}

	public ItemStack[] getInventory() {
		return inventory.clone();
	}

	@Override
	public int getSizeInventory() {
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return inventory[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		ItemStack stack = getStackInSlot(slot);
		if (stack != null) {
			if (stack.stackSize > amount) {
				stack = stack.splitStack(amount);
				markDirty();
			} else {
				setInventorySlotContents(slot, null);
			}
		}

		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack stack = getStackInSlot(slot);
		setInventorySlotContents(slot, null);
		return stack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		inventory[slot] = stack;
		if (stack != null && stack.stackSize > getInventoryStackLimit()) {
			stack.stackSize = getInventoryStackLimit();
		}
		markDirty();
	}

	public void onInventoryChanged() {
		for (int i = 0; i < this.getSizeInventory(); ++i) {
			if (this.getStackInSlot(i) != null && this.getStackInSlot(i).stackSize == 0)
				this.setInventorySlotContents(i, null);
		}
	}

	@Override
	public String getInventoryName() {
		return name;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return name.length() > 0;

	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return true;
	}

	@Override
	public void markDirty() {
		for (int i = 0; i < getSizeInventory(); ++i) {
			if (getStackInSlot(i) != null && getStackInSlot(i).stackSize == 0) {
				inventory[i] = null;
			}
		}
	}

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
		return false;
	}

	public void writeToNBT(NBTTagCompound tagcompound) {
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < this.getSizeInventory(); ++i) {

			if (this.getStackInSlot(i) != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				this.getStackInSlot(i).writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		tagcompound.setTag(tagName, nbttaglist);
	}

	public void readFromNBT(NBTTagCompound compound) {
		NBTTagList items = compound.getTagList(tagName, compound.getId());

		for (int i = 0; i < items.tagCount(); ++i) {
			NBTTagCompound item = items.getCompoundTagAt(i);
			byte slot = item.getByte("Slot");

			if (slot >= 0 && slot < getSizeInventory()) {

				setInventorySlotContents(slot,
						ItemStack.loadItemStackFromNBT(item));
			}
		}
	}

	public void copy(InventoryEotInventory inv) {
		for (int i = 0; i < inv.getSizeInventory(); ++i) {
			ItemStack stack = inv.getStackInSlot(i);
			inventory[i] = (stack == null ? null : stack.copy());
		}
		markDirty();
	}
}