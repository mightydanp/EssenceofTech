package com.mightydanp.eot.common.block;

import com.mightydanp.eot.api.common.block.BlockCore;
import com.mightydanp.eot.api.common.handler.RegisteryHandler;
import com.mightydanp.eot.common.lib.BlockReference;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by MightyDanp on 7/13/2018.
 */
public class ModBlocks extends RegisteryHandler{
    public static Block twigs;

    public static void init(){
        registerObject(twigs = new BlockCore(BlockReference.TWIGS_NAME, Material.GRASS, 0.1F, 0.0F, CreativeTabs.SEARCH, MapColor.BROWN), null);
    }
}
