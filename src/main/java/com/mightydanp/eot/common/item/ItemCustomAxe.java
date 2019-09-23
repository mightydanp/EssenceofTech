package com.mightydanp.eot.common.item;

import com.mightydanp.eot.common.Eot;
import com.mightydanp.eot.common.lib.References;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemAxe;

public class ItemCustomAxe extends ItemAxe{

	protected ItemCustomAxe(ToolMaterial toolMaterial, String unlocalizedName) {
		super(toolMaterial);
		this.setCreativeTab(Eot.eotTab);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(References.RESOURCES_PREFIX + unlocalizedName);
		this.setMaxStackSize(1);
	}
}
