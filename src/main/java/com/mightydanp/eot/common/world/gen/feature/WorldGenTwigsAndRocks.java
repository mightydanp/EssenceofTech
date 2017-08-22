package com.mightydanp.eot.common.world.gen.feature;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

/**
 * Created by MightyDanp on 8/21/2017.
 */
public class WorldGenTwigsAndRocks extends WorldGenerator {
    private Block getBlock;
    private IBlockState state;

    public WorldGenTwigsAndRocks(Block setBlock) {
        this.setGeneratedBlock(setBlock);
    }

    public void setGeneratedBlock(Block setBlock) {
        this.getBlock = setBlock;
        this.state = setBlock.getDefaultState();
    }

    public boolean generate(World worldIn, Random rand, BlockPos position) {
        for (int i = 0; i < 32; ++i) {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
            IBlockState getBlockState = worldIn.getBlockState(blockpos.down());
            Material getMaterial = getBlockState.getMaterial();

            if(worldIn.isAirBlock(blockpos) && blockpos.getY() < 255 && blockpos.getY() > 0  && (getMaterial == Material.GRASS || getMaterial == Material.CLAY || getMaterial == Material.GROUND || getMaterial == Material.ROCK || getMaterial == Material.SAND)) {
                worldIn.setBlockState(blockpos, state, 2);
            }
        }
        return true;
    }
}