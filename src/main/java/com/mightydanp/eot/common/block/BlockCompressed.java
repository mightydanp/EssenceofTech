package com.mightydanp.eot.common.block;

import java.util.List;
import java.util.Random;

import com.mightydanp.eot.common.Eot;
import com.mightydanp.eot.common.lib.BlockReferences;
import com.mightydanp.eot.common.lib.References;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockCompressed extends Block{
	
	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;
	
	public static String[] subBlocks = new String[] {"copper", "tin", "silver", "lead", "bronze", "ruby", "sapphire"};

	public BlockCompressed(String unlocalizedName) {
		super(Material.iron);
		this.setCreativeTab(Eot.eotTab);
		this.setBlockName(unlocalizedName);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs creativeTab, List list){
		for(int i = 0; i < subBlocks.length; i++){
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	public Item getItemDropped(int meta, Random random, int par3){
		return Item.getItemFromBlock(this);
    }
	
	public int damageDropped(int meta){

		return meta;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister){	
		this.iconArray = new IIcon[subBlocks.length];
		for(int i = 0; i < subBlocks.length; i++){
			this.iconArray[i] = par1IconRegister.registerIcon(References.RESOURCES_PREFIX + BlockReferences.COMPRESSED_NAME + "_" + subBlocks[i].toLowerCase());
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side,int meta){
		return iconArray[meta];
    }

}
