package com.mightydanp.eot.common.item;

import com.mightydanp.eot.common.Eot;
import com.mightydanp.eot.common.lib.References;

import net.minecraft.item.Item;

public class ItemDefault extends Item{
	
	protected ItemDefault(String unlocalizedName){
		this.setCreativeTab(Eot.eotTab);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(References.RESOURCES_PREFIX + unlocalizedName);
	}
}
