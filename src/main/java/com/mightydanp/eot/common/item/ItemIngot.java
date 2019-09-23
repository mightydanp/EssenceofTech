package com.mightydanp.eot.common.item;

import java.util.List;

import com.mightydanp.eot.common.Eot;
import com.mightydanp.eot.common.lib.ItemReferences;
import com.mightydanp.eot.common.lib.References;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemIngot extends Item {
	
    public IIcon[] iconArray = new IIcon[subItems.length];
	
	public static String[] subItems = new String[] {"copper", "tin", "silver", "lead", "bronze", "steel"};
	
	protected ItemIngot(String unlocalizedName) {
		this.setCreativeTab(Eot.eotTab);
		this.setUnlocalizedName(unlocalizedName);
		this.setHasSubtypes(true);
	}
	
	@Override
	public void registerIcons(IIconRegister reg) {
	    for (int i = 0; i < subItems.length; i ++) {
	        this.iconArray[i] = reg.registerIcon(References.RESOURCES_PREFIX + ItemReferences.INGOT_NAME + "_" + subItems[i]);
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
		
		return super.getUnlocalizedName() + "_" + subItems[i];
	}
	
	@SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta){
		return this.iconArray[meta];
	}

}
