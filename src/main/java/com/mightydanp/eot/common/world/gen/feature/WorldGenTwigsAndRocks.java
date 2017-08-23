package com.mightydanp.eot.common.world.gen.feature;

import com.mightydanp.eot.common.block.ModBlocks;
import com.mightydanp.eot.common.config.ConfigSurvival;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

/**
 * Created by MightyDanp on 8/21/2017.
 */
public class WorldGenTwigsAndRocks implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (!world.provider.isSurfaceWorld()) {
            return;
        }
        int posX = (chunkX * 16) + 8;
        int posZ = (chunkZ * 16) + 8;

        int countTwigs = random.nextInt(ConfigSurvival.MAX_TWIGS + 1 - ConfigSurvival.MAX_TWIGS) + ConfigSurvival.MAX_TWIGS;
        for (int i = 0; i < countTwigs; i++) {
            BlockPos posTwigs = world.getTopSolidOrLiquidBlock(new BlockPos(posX + offset(8, random), 0, posZ + offset(8, random)));
            IBlockState getBlockStateTwigs = world.getBlockState(posTwigs.down());
            Material getMaterialTwigs = getBlockStateTwigs.getMaterial();

            if (world.isAirBlock(posTwigs) && posTwigs.getY() > 0 && posTwigs.getY() < 255 && (getMaterialTwigs == Material.GRASS || getMaterialTwigs == Material.CLAY || getMaterialTwigs == Material.GROUND || getMaterialTwigs == Material.ROCK || getMaterialTwigs == Material.SAND) && !world.isAirBlock(posTwigs.down()) && getBlockStateTwigs.getBlock() != Blocks.AIR) {
                world.setBlockState(posTwigs, ModBlocks.twigs.getDefaultState());
            }
        }

        int countRocks = random.nextInt(ConfigSurvival.MAX_ROCKS + 1 - ConfigSurvival.MIN_ROCKS) + ConfigSurvival.MIN_ROCKS;
        for (int i = 0; i < countRocks; i++) {
            BlockPos posRocks = world.getTopSolidOrLiquidBlock(new BlockPos(posX + offset(8, random), 0, posZ + offset(8, random)));
            IBlockState getBlockStateRocks = world.getBlockState(posRocks.down());
            Material getMaterialRocks = getBlockStateRocks.getMaterial();

            if (world.isAirBlock(posRocks) && posRocks.getY() > 0 && posRocks.getY() < 255 && (getMaterialRocks == Material.GRASS || getMaterialRocks == Material.CLAY || getMaterialRocks == Material.GROUND || getMaterialRocks == Material.ROCK || getMaterialRocks == Material.SAND) && !world.isAirBlock(posRocks.down()) && getBlockStateRocks.getBlock() != Blocks.AIR) {
                world.setBlockState(posRocks, ModBlocks.rocks.getDefaultState());
            }

        }
    }

    public int offset(int bound, Random rand) {
        return rand.nextInt(bound * 2) - bound;
    }
}