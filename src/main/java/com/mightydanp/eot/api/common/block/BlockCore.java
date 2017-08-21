package com.mightydanp.eot.api.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by MightyDanp on 8/10/2017.
 */
public class BlockCore extends Block {

    public BlockCore(String unlocalizedName, Material material, float hardness, float resistance, CreativeTabs creativeTab) {
        super(material);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(creativeTab);
        this.setHardness(hardness);
        this.setResistance(resistance);
    }

    public BlockCore(String unlocalizedName, float hardness, float resistance, CreativeTabs creativeTab) {
        this(unlocalizedName, Material.ROCK, hardness, resistance, creativeTab);
    }

    public BlockCore(String unlocalizedName, CreativeTabs creativeTab) {
        this(unlocalizedName, 2.0f, 10.0f, creativeTab);
    }
}
