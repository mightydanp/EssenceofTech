package com.mightydanp.eot.item;

import com.mightydanp.eot.Eot;
import com.mightydanp.eot.lib.References;

import net.minecraft.item.ItemHoe;
import net.minecraft.item.Item.ToolMaterial;

public class ItemCustomHoe extends ItemHoe{
	
	protected ItemCustomHoe(ToolMaterial toolMaterial, String unlocalizedName) {
		super(toolMaterial);
		this.setCreativeTab(Eot.eotTab);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(References.RESOURCESPREFIX + unlocalizedName);
		this.setMaxStackSize(1);
	}

}
