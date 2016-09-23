package com.mightydanp.eot.common.item;

import com.mightydanp.eot.api.common.item.IItem;
import java.util.List;

import com.mightydanp.eot.common.EoT;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemBagTier1 extends IItem {

    public ItemBagTier1(String unlocalizedName) {
        super(unlocalizedName);
        this.setCreativeTab(EoT.tabEoT);
        this.setMaxStackSize(1);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
        dataList.add("I seem to have made a somewhat stable bag!!");
        dataList.add("Tier: 1");
    }
}
