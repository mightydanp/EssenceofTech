package com.mightydanp.eot.api.common.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @auther MightyDanp date class created: Jul 22, 2016
 */
public class IItemAxe extends ItemAxe {
    
    private final String itemUnlocalizedName;

    public IItemAxe(ToolMaterial toolMaterial, String unlocalizedName, float damage, float speed) {
        super(toolMaterial, damage, speed);
        itemUnlocalizedName = unlocalizedName;
        this.setUnlocalizedName(unlocalizedName);
        this.setMaxStackSize(1);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return "item" + "." + itemUnlocalizedName;
    }

    public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems) {
        subItems.add(new ItemStack(itemIn, 1, 0));

    }

}
