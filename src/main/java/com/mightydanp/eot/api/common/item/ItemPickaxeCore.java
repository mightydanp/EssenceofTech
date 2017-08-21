package com.mightydanp.eot.api.common.item;

import com.mightydanp.eot.common.EoT;
import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemPickaxeCore extends ItemPickaxe {

    private final String itemUnlocalizedName;
    
    protected ItemPickaxeCore(ToolMaterial toolMaterial, String unlocalizedName) {
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
