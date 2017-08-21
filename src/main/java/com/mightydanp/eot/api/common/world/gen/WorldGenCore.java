package com.mightydanp.eot.api.common.world.gen;

import java.util.Random;

import com.google.common.base.Predicate;
import com.mightydanp.eot.api.common.world.gen.feature.WorldGenMinableCore;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenCore implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.getDimension()){
		case -1: generateNether(world, random, chunkX* 16, chunkZ* 16);
            break;
		case 0: generateSurface(world, random, chunkX* 16, chunkZ* 16);
            break;
		case 1: generateEnd(world, random, chunkX* 16, chunkZ* 16);
            break;
            default:
            ;
		}
	}

	public void generateNether(World world, Random random, int chunkX, int chunkZ) {}

	public void generateSurface(World world, Random random, int chunkX, int chunkZ) {}

	public void generateEnd(World world, Random random, int chunkX, int chunkZ) {}

	public void spawnOres(IBlockState block, int meta, Block blockReplaced, World world, Random random, int chunkX, int chunkZ, int vainSize, int spawnChance, int YMin, int YMax) {
		for(int i = 0; i < spawnChance; i ++){
			int posX = chunkX + random.nextInt(16);
			int posY = YMin + random.nextInt(YMax-YMin);
			int posZ = chunkZ + random.nextInt(16);

			BlockPos blockPos = new BlockPos(posX, posY, posZ);
			(new WorldGenMinableCore(block, vainSize, blockReplaced)).generate(world, random, blockPos);
	    }
     }

}
