package com.mightydanp.eot.common.world.gen;

import static com.mightydanp.eot.common.config.BlockConfig.generateCopper;
import static com.mightydanp.eot.common.config.BlockConfig.generateLead;
import static com.mightydanp.eot.common.config.BlockConfig.generateRuby;
import static com.mightydanp.eot.common.config.BlockConfig.generateSapphire;
import static com.mightydanp.eot.common.config.BlockConfig.generateSilver;
import static com.mightydanp.eot.common.config.BlockConfig.generateTin;

import java.util.Random;

import com.mightydanp.eot.api.common.world.gen.IWorldGen;
import com.mightydanp.eot.common.block.ModBlocks;

import net.minecraft.world.World;

public class WorldGen extends IWorldGen {

	@Override
	public void generateNether(World world, Random random, int chunkX, int chunkZ) {

	}

	@Override
	public void generateSurface(World world, Random random, int chunkX, int chunkZ) {
		if (generateCopper == true) {
			spawnOres(ModBlocks.ore.getStateFromMeta(0), world, random, chunkX, chunkZ, 13, 12, 1, 80);
		}
		if (generateTin == true) {
			spawnOres(ModBlocks.ore.getStateFromMeta(1), world, random, chunkX, chunkZ, 12, 10, 60, 120);
		}
		if (generateSilver == true) {
			spawnOres(ModBlocks.ore.getStateFromMeta(2), world, random, chunkX, chunkZ, 10, 10, 1, 50);
		}
		if (generateLead == true) {
			spawnOres(ModBlocks.ore.getStateFromMeta(3), world, random, chunkX, chunkZ, 5, 9, 1, 32);
		}
		if (generateRuby == true) {
			spawnOres(ModBlocks.ore.getStateFromMeta(4), world, random, chunkX, chunkZ, 4, 7, 1, 32);
		}
		if (generateSapphire == true) {
			spawnOres(ModBlocks.ore.getStateFromMeta(5), world, random, chunkX, chunkZ, 4, 7, 1, 32);
		}

		spawnOres(ModBlocks.essenceStone.getStateFromMeta(0), world, random, chunkX, chunkZ, 3, 25, 5, 60);
		spawnOres(ModBlocks.essenceStone.getStateFromMeta(1), world, random, chunkX, chunkZ, 3, 25, 5, 60);
		spawnOres(ModBlocks.essenceStone.getStateFromMeta(2), world, random, chunkX, chunkZ, 3, 25, 5, 60);
		spawnOres(ModBlocks.essenceStone.getStateFromMeta(3), world, random, chunkX, chunkZ, 3, 25, 5, 60);
		spawnOres(ModBlocks.essenceStone.getStateFromMeta(4), world, random, chunkX, chunkZ, 3, 25, 5, 60);
	}

	@Override
	public void generateEnd(World world, Random random, int chunkX, int chunkZ) {

	}

}
