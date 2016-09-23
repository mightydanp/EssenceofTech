package com.mightydanp.eot.common.item;

import java.util.List;

import com.mightydanp.eot.api.common.item.IMetaItem;
import com.mightydanp.eot.common.EoT;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @auther MightyDanp date class created: Jul 22, 2016
 */
public class ItemEssenceChunk extends IMetaItem {

	public ItemEssenceChunk(String prefixName, String[] suffixName, int numberofMeta) {
		super(prefixName, suffixName, numberofMeta);
		this.setCreativeTab(EoT.tabEoT);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		if (itemStack.getItemDamage() == 0) {
			dataList.add("Seems to glowing and emanating power.");
		}
		if (itemStack.getItemDamage() == 1) {
			dataList.add("This feels very light.");
		}
		if (itemStack.getItemDamage() == 2) {
			dataList.add("Kinda old and dirty.");
		}
		if (itemStack.getItemDamage() == 3) {
			dataList.add("Ouch! It burns me.");
		}
		if (itemStack.getItemDamage() == 4) {
			dataList.add("Very slippery.");
		}
	}

}
