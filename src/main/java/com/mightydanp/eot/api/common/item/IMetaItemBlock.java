package com.mightydanp.eot.api.common.item;

import javax.annotation.Nonnull;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.item.ItemColored;
import net.minecraft.item.ItemStack;

/**
 * @auther MightyDanp date class created: Jul 22, 2016
 */
public class IMetaItemBlock extends ItemColored {

	protected IProperty		mappingProperty;

	private final String	itemBlockStateName[];

	public IMetaItemBlock(Block block, String[] blockStateName) {
		super(block, true);
		itemBlockStateName = blockStateName;
	}

	@Nonnull
	@Override
	public String getUnlocalizedName(@Nonnull ItemStack stack) {
		if(stack.getItemDamage() < 1 && stack.getMaxDamage() == 0 && itemBlockStateName == null){
			int i = stack.getItemDamage();
			return super.getUnlocalizedName(stack);
		} else {
			int i = stack.getItemDamage();
			return super.getUnlocalizedName(stack) + "_" + itemBlockStateName[i];
		}
		
	}

}
