package com.mightydanp.eot.item;

import java.util.List;

import com.mightydanp.eot.Eot;
import com.mightydanp.eot.lib.ItemStrings;
import com.mightydanp.eot.lib.References;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemEssenceChunks extends Item{
	
	public IIcon[] iconArray = new IIcon[subItems.length];
	
	public static String[] subItems = new String[] {"Magic", "Air", "Earth", "Fire", "Water"};
	
	public static String[] subItemsDescriptions = new String[] {"Seems to glowing and emanating power.", "This feels very light.", "Kinda old and dirty.", "Ouch! It burns me.", "Very slippery."};
	
	public ItemEssenceChunks(String unlocalizedName){
		this.setCreativeTab(Eot.eotTab);
		this.setUnlocalizedName(unlocalizedName);
		this.setHasSubtypes(true);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool){
		if(itemStack.getItemDamage() < subItems.length){
			dataList.add(subItemsDescriptions[itemStack.getItemDamage()]);
		}
    }
	
	@Override
	public void registerIcons(IIconRegister reg) {
	    for (int i = 0; i < subItems.length; i ++) {
	        this.iconArray[i] = reg.registerIcon(References.RESOURCESPREFIX + ItemStrings.ESSANCECHUNK_NAME + subItems[i]);
	    }
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
	    for (int i = 0; i < subItems.length; i ++) {
	        list.add(new ItemStack(item, 1, i));
	    }
	}

	@SideOnly(Side.CLIENT)
	public String getUnlocalizedName(ItemStack itemStack){
		int i = itemStack.getItemDamage();
		if(i < 0 || i >= subItems.length){
			i = 0;
		}
		
		return super.getUnlocalizedName() + subItems[i];
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta){
		return this.iconArray[meta];
	}
}