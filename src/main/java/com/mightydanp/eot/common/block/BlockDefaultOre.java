package com.mightydanp.eot.common.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.mightydanp.eot.common.Eot;
import com.mightydanp.eot.common.item.ModItems;
import com.mightydanp.eot.common.lib.BlockReferences;
import com.mightydanp.eot.common.lib.References;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDefaultOre extends Block{
	
	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;
	
	public static String[] subBlocks = new String[] {"copper", "tin", "silver", "lead", "ruby", "sapphire"};
	
	protected BlockDefaultOre(String unlocalizedName) {
		super(Material.rock);
		this.setCreativeTab(Eot.eotTab);
		this.setBlockName(unlocalizedName);
		this.setHarvestLevel("pickaxe", 1, 0);
		this.setHarvestLevel("pickaxe", 1, 1);
		this.setHarvestLevel("pickaxe", 2, 2);
		this.setHarvestLevel("pickaxe", 2, 3);
		this.setHarvestLevel("pickaxe", 2, 4);
		this.setHarvestLevel("pickaxe", 2, 5);
	}
	
	private Random rand = new Random();
	@Override
    public int getExpDrop(IBlockAccess p_149690_1_, int meta, int p_149690_7_)
    {
        if (this.getItemDropped(meta, rand, p_149690_7_) != Item.getItemFromBlock(this))
        {
            int j1 = 0;

            if (meta == 4){
                j1 = MathHelper.getRandomIntegerInRange(rand, 3, 7);
            }
            else if (meta == 5){
                j1 = MathHelper.getRandomIntegerInRange(rand, 3, 7);
            }

            return j1;
        }
        return 0;
    }
	
	@Override
    public float getBlockHardness(World par1World, int par2, int par3, int par4)
    {
        final int meta = par1World.getBlockMetadata(par2, par3, par4);

        if (meta == 1)
        {
            return 4.0F;
        }else
        	
        return this.blockHardness;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs creativeTab, List list){
		for(int i = 0; i < subBlocks.length; i++){
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	public Item getItemDropped(int meta, Random random, int par3){
		if(meta == 4){
			return ModItems.gem;
		}else if(meta == 5){
			return ModItems.gem;
		}else
		return Item.getItemFromBlock(this);
    }
	
	public int damageDropped(int meta){
		if(meta == 4){
			return 0;
		}else if(meta == 5){
			return 1;
		}else
		return meta;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister){	
		this.iconArray = new IIcon[subBlocks.length];
		for(int i = 0; i < subBlocks.length; i++){
			this.iconArray[i] = par1IconRegister.registerIcon(References.RESOURCES_PREFIX + BlockReferences.ORE_NAME + "_" + subBlocks[i]);
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side,int meta){
		return iconArray[meta];
    }

}

