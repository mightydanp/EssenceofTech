package com.mightydanp.eot.common.block;

import com.mightydanp.eot.api.common.handler.RegistryHandlerCore;
import com.mightydanp.eot.common.item.ItemRocks;
import com.mightydanp.eot.common.item.ItemTwigs;
import com.mightydanp.eot.common.lib.BlockReference;
import net.minecraft.block.Block;

/**
 * Created by MightyDanp on 8/10/2017.
 */
public class ModBlocks extends RegistryHandlerCore{
    public static Block twigs;
    public static Block rocks;

    public static void preInit(){
        registerObject(twigs = new BlockTwigs(BlockReference.TWIGS_NAME), BlockReference.TWIGS_NAME, new ItemTwigs(twigs, BlockReference.TWIGS_NAME));
        registerObject(rocks = new BlockRocks(BlockReference.ROCKS_NAME), BlockReference.ROCKS_NAME, new ItemRocks(rocks, BlockReference.ROCKS_NAME));
    }

    public static void renderBlocks() {
        renderObject(twigs, BlockReference.TWIGS_NAME, null, 0);
        renderObject(rocks, BlockReference.ROCKS_NAME, null, 0);

    }
}
