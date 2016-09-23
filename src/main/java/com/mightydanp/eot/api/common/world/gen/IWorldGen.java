package com.mightydanp.eot.api.common.world.gen;

import java.util.Random;

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

public class IWorldGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		if (world.provider instanceof WorldProviderHell) {
			generateNether(world, random, chunkX * 16, chunkZ * 16);
		}
		if (world.provider instanceof WorldProviderSurface) {
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		}
		if (world.provider instanceof WorldProviderEnd) {
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	public void generateNether(World world, Random random, int chunkX, int chunkZ) {}

	public void generateSurface(World world, Random random, int chunkX, int chunkZ) {}

	public void generateEnd(World world, Random random, int chunkX, int chunkZ) {}

	public void spawnOres(IBlockState block, World world, Random random, int chunkX, int chunkZ, int vainSize, int spawnChance, int YMin, int YMax) {
		for (int i = 0; i < spawnChance; i++) {
			int posX = chunkX + random.nextInt(16);
			int posY = YMin + random.nextInt(YMax - YMin);
			int posZ = chunkZ + random.nextInt(16);
			BlockPos blockPos = new BlockPos(posX, posY, posZ);
			(new WorldGenMinable(block, vainSize)).generate(world, random, blockPos);
		}
	}



}
