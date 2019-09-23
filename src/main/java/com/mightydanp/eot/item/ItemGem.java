package com.mightydanp.eot.item;

import java.util.List;

import com.mightydanp.eot.Eot;
import com.mightydanp.eot.lib.ItemStrings;
import com.mightydanp.eot.lib.References;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemGem extends Item {
    public IIcon[] iconArray = new IIcon[subItems.length];
	
	public static String[] subItems = new String[] {"Ruby", "Sapphire"};
	
	protected ItemGem(String unlocalizedName){
		this.setCreativeTab(Eot.eotTab);
		this.setUnlocalizedName(unlocalizedName);
		this.setHasSubtypes(true);
	}
	
	@Override
	public void registerIcons(IIconRegister reg) {
	    for (int i = 0; i < subItems.length; i ++) {
	        this.iconArray[i] = reg.registerIcon(References.RESOURCESPREFIX + ItemStrings.GEM_NAME + subItems[i]);
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
