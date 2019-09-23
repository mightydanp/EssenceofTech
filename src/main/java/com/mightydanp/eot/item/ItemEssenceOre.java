package com.mightydanp.eot.item;

import com.mightydanp.eot.block.BlockEssenceOre;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemEssenceOre extends ItemBlock{

	public static String[] subBlocks = new String[] {"Magic", "Air", "Earth", "Fire", "Water"};
	
	public ItemEssenceOre(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}
	
	@SideOnly(Side.CLIENT)
	public String getUnlocalizedName(ItemStack itemStack){
		int i = itemStack.getItemDamage();
		if(i < 0 || i >= subBlocks.length){
			i = 0;
		}
		
		return super.getUnlocalizedName() + subBlocks[i];
	}
	
	@Override
	public int getMetadata(int meta)
    {
        return meta;
    }

}
