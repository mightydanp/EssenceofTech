package com.mightydanp.eot.api.common.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by MightyDanp on 8/10/2017.
 */
public class ItemCore extends Item{
    public ItemCore(String unlocalizedName, CreativeTabs creativeTab) {
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(creativeTab);
    }
}
