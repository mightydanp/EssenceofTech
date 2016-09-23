package com.mightydanp.eot.api.common.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @auther MightyDanp
 * date class created: Jul 22, 2016
 */

public class IItem extends Item{
    
    private final String itemUnlocalizedName;
    
    public IItem(String unlocalizedName) {
        this.setUnlocalizedName(unlocalizedName);
        itemUnlocalizedName = unlocalizedName;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return "item" + "." + itemUnlocalizedName;
    }

    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List subItems) {
        subItems.add(new ItemStack(itemIn, 1, 0));

    }

}
