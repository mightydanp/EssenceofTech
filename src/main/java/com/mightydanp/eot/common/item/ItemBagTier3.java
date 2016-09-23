package com.mightydanp.eot.common.item;

import com.mightydanp.eot.api.common.item.IItem;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.mightydanp.eot.common.EoT;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBagTier3 extends IItem {

    public ItemBagTier3(String unlocalizedName) {
        super(unlocalizedName);
        this.setCreativeTab(EoT.tabEoT);
        this.setMaxStackSize(1);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
        dataList.add("For some reason it feels like theres a minture blackhole in this bag!");
        dataList.add("Tier: 3");
    }
}
