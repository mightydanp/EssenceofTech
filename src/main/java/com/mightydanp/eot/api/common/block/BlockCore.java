package com.mightydanp.eot.api.common.block;

import com.mightydanp.eot.common.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;

import java.util.Objects;

/**
 * Created by MightyDanp on 7/13/2018.
 */
public class BlockCore extends Block {

    public BlockCore(String unlocalizedName, Material material, float hardness, float resistance, CreativeTabs creativeTabs, final MapColor mapColor) {
        super(material, mapColor);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(creativeTabs);
        this.setHardness(hardness);
        this.setResistance(resistance);
    }
}
