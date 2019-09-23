package com.mightydanp.eot.common.item;

import com.mightydanp.eot.common.Eot;
import com.mightydanp.eot.common.lib.References;

import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.Item.ToolMaterial;

public class ItemCustomPickaxe extends ItemPickaxe{
	
	protected ItemCustomPickaxe(ToolMaterial toolMaterial, String unlocalizedName) {
		super(toolMaterial);
		this.setCreativeTab(Eot.eotTab);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(References.RESOURCES_PREFIX + unlocalizedName);
		this.setMaxStackSize(1);
	}

}
