package com.mightydanp.eot.api.common.item;

import java.util.List;

import com.mightydanp.eot.common.EoT;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class IItemSpade extends ItemSpade {

    private final String itemUnlocalizedName;
    
    public IItemSpade(ToolMaterial toolMaterial, String unlocalizedName) {
        super(toolMaterial);
        itemUnlocalizedName = unlocalizedName;
        this.setCreativeTab(EoT.tabEoT);
        this.setUnlocalizedName(unlocalizedName);
        this.setMaxStackSize(1);
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
