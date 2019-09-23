package com.mightydanp.eot.common.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.mightydanp.eot.common.Eot;
import com.mightydanp.eot.common.lib.References;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTier3Bag extends Item{
	public ItemTier3Bag(String unlocalizedName){
		this.setCreativeTab(Eot.eotTab);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(References.RESOURCES_PREFIX + unlocalizedName);
		this.setMaxStackSize(1);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool){
		dataList.add("For some reason it feels like theres a minture blackhole in this bag!");
		dataList.add("Tier: 3");
    }
}