package com.mightydanp.eot.api.common.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @auther MightyDanp date class created: Jul 22, 2016
 */
public class IMetaItem extends Item {

    private String itemPrefixName;
    private String[] itemSuffixName;
    private int itemNumberofMeta;

    public IMetaItem(String prefixName, String[] suffixName, int numberofMeta) {
        this.setUnlocalizedName(prefixName);
        this.setHasSubtypes(true);
        itemPrefixName = prefixName;
        itemSuffixName = suffixName;
        itemNumberofMeta = numberofMeta;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        for (int i = 0; i < itemNumberofMeta ; i++) {
            if (itemStack.getItemDamage() == i) {
                return "item" + "." + itemPrefixName + "_" + itemSuffixName[i];
            }
        }
        return "Something went wrong in the getUnlocalization of IMetaItem";
    }

    public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems) {
        for (int i = 0; i < itemNumberofMeta ; i++) {
            subItems.add(new ItemStack(itemIn, 1, i));
        }
    }

}
