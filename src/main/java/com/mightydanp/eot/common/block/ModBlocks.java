package com.mightydanp.eot.common.block;

import com.mightydanp.eot.api.common.block.BlockCore;
import com.mightydanp.eot.api.common.handler.RegisteryHandler;
import com.mightydanp.eot.common.lib.BlockReference;
import com.mightydanp.eot.common.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by MightyDanp on 7/13/2018.
 */
public class ModBlocks extends RegisteryHandler{
    @GameRegistry.ObjectHolder(Reference.MOD_ID + ":" + BlockReference.TWIGS_NAME)
    public static BlockTwigs twigs;

    public static void init(){
        registerObject(twigs = new BlockTwigs(BlockReference.TWIGS_NAME), null);
    }
}
