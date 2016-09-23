package com.mightydanp.eot.common.item;

import java.util.List;

import com.mightydanp.eot.api.common.item.IMetaItem;
import com.mightydanp.eot.common.EoT;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemVibrantResource extends IMetaItem{

	public ItemVibrantResource(String prefixName, String[] suffixName, int numberofMeta) {
		super(prefixName, suffixName, numberofMeta);
		this.setCreativeTab(EoT.tabEoT);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		if (itemStack.getItemDamage() == 0) {
			dataList.add("It burns my hands when i touch it!");
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean hasEffect(ItemStack itemStack) {
		if (itemStack.getItemDamage() == 0) {
			return true;
		} else {
			return false;
		}
	}

}
