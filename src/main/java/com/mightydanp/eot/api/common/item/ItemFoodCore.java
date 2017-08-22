package com.mightydanp.eot.api.common.item;

import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @auther MightyDanp
 * date class created: Jul 22, 2016 
 */

public class ItemFoodCore extends ItemFood{

    private final String itemUnlocalizedName;
    
    public ItemFoodCore(int amount, float saturation, boolean isWolfFood, String unlocalizedName) {
        super(amount, saturation, isWolfFood);
        itemUnlocalizedName = unlocalizedName;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return "item" + "." + itemUnlocalizedName;
    }

    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
        subItems.add(new ItemStack(itemIn, 1, 0));

    }

}