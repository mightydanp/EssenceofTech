package com.mightydanp.eot.api.common.item;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemColored;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

/**
 * @auther MightyDanp date class created: Jul 22, 2016
 */
public class ItemBlockCore extends ItemBlock {

    private final String itemBlockStateName;
    protected IProperty mappingProperty;

    public ItemBlockCore(Block block, String blockStateName) {
        super(block);
        itemBlockStateName = blockStateName;
    }

    @Nonnull
    @Override
    public String getUnlocalizedName(@Nonnull ItemStack stack) {
            return super.getUnlocalizedName(stack);

    }

}
