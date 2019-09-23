package com.mightydanp.eot.common.block;

import java.util.List;
import java.util.Random;

import com.mightydanp.eot.common.Eot;
import com.mightydanp.eot.common.item.ItemEssenceOre;
import com.mightydanp.eot.common.item.ModItems;
import com.mightydanp.eot.common.lib.BlockReferences;
import com.mightydanp.eot.common.lib.References;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockEssenceOre extends Block {
	
	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;
	
	public static String[] subBlocks = new String[] {"magic", "air", "earth", "fire", "water"};
	
	public float originalHardness;
	
	
	protected BlockEssenceOre(String unlocalizedName) {
		super(Material.rock);
		this.setCreativeTab(Eot.eotTab);
		this.setBlockName(unlocalizedName);
	}
	
	@Override
    public Block setHardness(float par1){
		originalHardness = par1;
		return super.setHardness(par1);
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs creativeTab, List list){
		for(int i = 0; i < subBlocks.length; i++){
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	public Item getItemDropped(int par1, Random random, int p_149650_3_){
		
		int randomDrop = random.nextInt(100);
		
		if(randomDrop<=60){
			return  ModItems.essenceChunks;
		}
		return null;
    }
	
	public int damageDropped(int meta){

		return meta;
	}
	
	public int quantityDroppedWithBonus(int fortune, Random random){
		if (fortune > 0)
        {
            int j = random.nextInt(fortune + 2) - 1;

            if (j < 0)
            {
                return j++;
            }
            return quantityDropped(random) * (j + 1);
        }
	    return quantityDropped(random);
		
    }
	
	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer par6Player) {
		if(par6Player.getCurrentEquippedItem() != null){;
			EntityItem entityItem = new EntityItem(world, par6Player.posX , par6Player.posY , par6Player.posZ, new ItemStack(ModItems.magicalStone, 1, 16));
			Random random = world.rand;
			int randomDrop = random.nextInt(99);
			
    		if(par6Player.getCurrentEquippedItem().getItem() == ModItems.hammerMysterious){
    			if(randomDrop<=10){
    				world.spawnEntityInWorld(entityItem);
    			}
    		}
    	}
	}
	
	@Override
    public void onBlockClicked(World world, int x, int y, int z, EntityPlayer entityPlayer){
	
		if(!(entityPlayer.getCurrentEquippedItem().getItem() == ModItems.hammerMysterious)){
			this.blockHardness = -1;
			 return;		   
		  }
		  this.blockHardness = originalHardness;
		  super.onBlockClicked(world, x, y, z, entityPlayer);
	
    }

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister){	
		this.iconArray = new IIcon[subBlocks.length];
		for(int i = 0; i < subBlocks.length; i++){
			this.iconArray[i] = par1IconRegister.registerIcon(References.RESOURCES_PREFIX + BlockReferences.ESSENCE_STONE_NAME + "_" + subBlocks[i]);
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side,int meta){
		return iconArray[meta];
    }
}
