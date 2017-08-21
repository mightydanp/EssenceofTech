package com.mightydanp.eot.api.common.item;


import java.util.List;

import com.mightydanp.eot.common.EoT;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSwordCore extends ItemSword {

    private final String itemUnlocalizedName;
    
    public ItemSwordCore(ToolMaterial toolMaterial, String unlocalizedName) {
        super(toolMaterial);
        itemUnlocalizedName = unlocalizedName;
        this.setCreativeTab(EoT.tabEot);
        this.setUnlocalizedName(unlocalizedName);
        this.setMaxStackSize(1);
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
