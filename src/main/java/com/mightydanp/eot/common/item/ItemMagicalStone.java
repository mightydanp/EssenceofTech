package com.mightydanp.eot.common.item;

import java.util.List;

import com.mightydanp.eot.api.common.item.IItem;
import com.mightydanp.eot.common.EoT;
import com.mightydanp.eot.common.config.DebugConfig;
import com.mightydanp.eot.common.config.ItemConfig;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @auther MightyDanp date class created: Jul 22, 2016
 */
class ItemMagicalStone extends IItem {

	public ItemMagicalStone(String unlocalizedName) {
		super(unlocalizedName);
		this.setCreativeTab(EoT.tabEoT);
		this.setMaxDamage(16);
		this.setMaxStackSize(1);
		this.setHasSubtypes(true);
	}

	@Override
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int i, boolean flag) {
		super.onUpdate(itemStack, world, entity, i, flag);

		if (!world.isRemote) {
			NBTTagCompound nbtDataCompund;
			if (itemStack.hasTagCompound()) {
				nbtDataCompund = itemStack.getTagCompound();
			} else {
				nbtDataCompund = new NBTTagCompound();
			}

			int coolDown = nbtDataCompund.getInteger("coolDown");
			if (coolDown > 0) {
				--coolDown;
				nbtDataCompund.setInteger("coolDown", coolDown);
			}
		}
	}

	@Override
	public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer entityPlayer, EntityLivingBase entity,
			EnumHand hand) {

		NBTTagCompound nbt;
		if (itemStack.hasTagCompound()) {
			nbt = itemStack.getTagCompound();
		} else {
			nbt = new NBTTagCompound();
		}
		int coolDown = nbt.getInteger("coolDown");

		if (coolDown > 0) {
			return false;
		}

		if (coolDown == 0) {
			if (entity instanceof EntityMob) {
				if (itemStack.getItemDamage() > 0) {
					entity.setHealth(0.0F);
					nbt.setInteger("coolDown", ItemConfig.magicStoneCooldown);
					if (!entity.world.isRemote) {
						entityPlayer.sendMessage(new TextComponentString(TextFormatting.GRAY + "Soul Absurbed!"));
					}
					itemStack.damageItem(-1, entityPlayer);
					itemStack.setTagCompound(nbt);
					return true;
				} else {
					if (!entity.world.isRemote) {
						entityPlayer.sendMessage(
								new TextComponentString(TextFormatting.GRAY + "The  Magical Stone seems to be full?"));
						entityPlayer.sendMessage(
								new TextComponentString(TextFormatting.GRAY + "It seems to be useless now."));
						entityPlayer.sendMessage(
								new TextComponentString(TextFormatting.GRAY + "I wonder whats inside?"));
					}
					return true;
				}
			} else if (!entity.world.isRemote) {
				entityPlayer
						.sendMessage(new TextComponentString(TextFormatting.GRAY + "Why has this stoped working?"));
			}
		} else {
			entityPlayer.sendMessage(new TextComponentString(TextFormatting.GRAY + "Why has this stoped working?"));
		}
		itemStack.setTagCompound(nbt);
		return false;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		NBTTagCompound nbt;
		if (itemStack.hasTagCompound()) {
			nbt = itemStack.getTagCompound();
		} else {
			nbt = new NBTTagCompound();
		}
		int coolDown = nbt.getInteger("coolDown");

		if (itemStack.getItemDamage() == 0) {
			dataList.add("The  Magical Stone seems to be full?");
			dataList.add("It seems to be useless now.");
			dataList.add("I wonder whats inside?");
		}

		if (itemStack.getItemDamage() > 0 && coolDown == 0) {
			dataList.add("This seems to be pulsing power.");
			dataList.add("It only happens whenever i get close to these creatures.");
			dataList.add("I wonder if this is linked to them.");
		} else {
			dataList.add("Everytime I use this now it seems to get hotter.");
			dataList.add("Maybe I should let it cool off.");
		}

		if (DebugConfig.showMagicStoneCooldown == true) {
			int i = (coolDown / 20) + 1;
			dataList.add("~Debug cooldown~");
			dataList.add("Seconds Left:" + i);
		}

	}
	
	/*if ((System.nanoTime()-time)/1_000_000>=1000) { 1000 = 1sec
        time=System.nanoTime();*/

	@SideOnly(Side.CLIENT)
	@Override
	public boolean hasEffect(ItemStack itemStack) {
		if (itemStack.getItemDamage() > 0) {
			return false;
		} else {
			return itemStack.getItemDamage() == 0;
		}
	}
}