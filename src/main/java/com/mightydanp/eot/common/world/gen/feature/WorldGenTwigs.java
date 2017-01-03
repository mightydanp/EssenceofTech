package com.mightydanp.eot.common.world.gen.feature;

import java.util.Random;

import com.mightydanp.eot.common.block.ModBlocks;
import com.mightydanp.eot.common.lib.Reference;
import com.mightydanp.eot.common.logger.EoTLogger;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenTwigs implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		if (!world.provider.isSurfaceWorld()) {
			return;
		}

		if (random.nextInt(4) == 0) {
			int posX = (chunkX * 16) + 8;
			int posZ = (chunkZ * 16) + 8;
			int posY = (world.getTopSolidOrLiquidBlock(new BlockPos(posX + offset(8, random), 0, posZ + offset(8, random))).getY());

			for (int i = 0; i < (random.nextInt(8)) + 8; i++) {
				BlockPos pos = new BlockPos(posX + offset(8, random), posY, posZ + offset(8, random));
				if (world.isAirBlock(new BlockPos(posX + offset(8, random), posY, posZ + offset(8, random))) && (!world.provider.hasNoSky() || pos.getY() < 255)) {
					if (world.getBlockState(pos.down()).getBlock() == Blocks.GRASS || world.getBlockState(pos.down()).getBlock() == Blocks.DIRT || world.getBlockState(pos.down()).getBlock() == Blocks.SAND || world.getBlockState(pos.down()).getBlock() == Blocks.STONE) {
						if (!(world.getBlockState(pos).getBlock() == Blocks.WATER) || !(world.getBlockState(pos).getBlock() == Blocks.LAVA)) {
							if (!(world.getBlockState(pos.down()).getBlock() == Blocks.AIR) && (world.getBlockState(pos.up()).getBlock() == Blocks.AIR)) {
								EoTLogger.logInfoMessage(Reference.MODID + ":" + "Generating Twigs:" + " " + pos.getX() + " " + pos.getY() + " " + pos.getZ());
								world.setBlockState(pos, ModBlocks.twigs.getDefaultState());
							}
						}
					}
				}
			}
		}
	}

	public int offset(int bound, Random rand) {
		return rand.nextInt(bound * 2) - bound;
	}
}