package com.mightydanp.eot.common.item;

import com.mightydanp.eot.common.Eot;
import com.mightydanp.eot.common.lib.References;

import net.minecraft.item.ItemSpade;
import net.minecraft.item.Item.ToolMaterial;

public class ItemCustomSpade extends ItemSpade{
	
	protected ItemCustomSpade(ToolMaterial toolMaterial, String unlocalizedName) {
		super(toolMaterial);
		this.setCreativeTab(Eot.eotTab);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(References.RESOURCES_PREFIX + unlocalizedName);
		this.setMaxStackSize(1);
	}

}
