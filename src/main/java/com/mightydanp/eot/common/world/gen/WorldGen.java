package com.mightydanp.eot.common.world.gen;

import com.mightydanp.eot.api.common.world.gen.WorldGenCore;
import com.mightydanp.eot.common.block.ModBlocks;
import com.mightydanp.eot.common.world.gen.feature.WorldGenTwigsAndRocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by MightyDanp on 8/21/2017.
 */
public class WorldGen extends WorldGenCore {
    @Override
    public void generateNether(World world, Random random, int chunkX, int chunkZ) {

    }

    @Override
    public void generateSurface(World world, Random random, int chunkX, int chunkZ) {
        // int rand = new Random().nextInt(100);
        //this.spawnTwigsAndRocks(ModBlocks.twigs, world, random, chunkX, chunkZ, 4);
        //this.spawnTwigsAndRocks(ModBlocks.rocks, world, random, chunkX, chunkZ, 6);

    }

    @Override
    public void generateEnd(World world, Random random, int chunkX, int chunkZ) {

    }
/*
    private void spawnTwigsAndRocks(Block block, World world, Random random, int chunkX, int chunkZ, int spawnChance) {
        for (int j = 0; j < spawnChance; ++j) {
            int posX = chunkX + random.nextInt(16);
            int posZ = chunkZ + random.nextInt(16);
            int posY = world.getTopSolidOrLiquidBlock(new BlockPos(posX + offset(8, random), 0, posZ + offset(8, random))).getY();
            BlockPos blockPos = new BlockPos(posX, posY, posZ);
            (new WorldGenTwigsAndRocks(block)).generate(world, random, blockPos);
        }
    }
    */

    public int offset(int bound, Random rand) {
        return rand.nextInt(bound * 2) - bound;
    }
}
