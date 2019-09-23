package com.mightydanp.eot.common.handler;

import java.util.Random;

import com.mightydanp.eot.common.block.ModBlocks;
import com.mightydanp.eot.common.config.GenerationConfiguration;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class GenerationHandler implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
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
	
    private void generateNether(World world, Random random, int chunkX, int chunkZ) {
		
	}

	private void generateSurface(World world, Random random, int chunkX, int chunkZ) {
		if(GenerationConfiguration.magicEssenceOreGeneration){
			this.spawnOres(ModBlocks.essenceStone, 0, Blocks.stone, world, random, chunkX, chunkZ, 3, 25, 5, 60);
		}
		if(GenerationConfiguration.airEssenceOreGeneration){
			this.spawnOres(ModBlocks.essenceStone, 1, Blocks.stone, world, random, chunkX, chunkZ, 3, 25, 5, 60);
		}
		if(GenerationConfiguration.earthEssenceOreGeneration){
			this.spawnOres(ModBlocks.essenceStone, 2, Blocks.stone, world, random, chunkX, chunkZ, 3, 25, 5, 60);

		}
		if(GenerationConfiguration.fireEssenceOreGeneration){
			this.spawnOres(ModBlocks.essenceStone, 3, Blocks.stone, world, random, chunkX, chunkZ, 3, 25, 5, 60);
		}
		if(GenerationConfiguration.waterEssenceOreGeneration){
			this.spawnOres(ModBlocks.essenceStone, 4, Blocks.stone, world, random, chunkX, chunkZ, 3, 25, 5, 60);

		}
	}
	
	private void generateEnd(World world, Random random, int chunkX, int chunkZ) {
		
	}
	
	private void spawnOres(Block block, int meta, Block blockReplaced, World world, Random random, int chunkX, int chunkZ, int vainSize, int spawnChance, int YMin, int YMax) {
		for(int i = 0; i < spawnChance; i ++){
			int posX = chunkX + random.nextInt(16);
			int posY = YMin + random.nextInt(YMax-YMin);
			int posZ = chunkZ + random.nextInt(16);
			(new WorldGenMinable(block, meta, vainSize, blockReplaced)).generate(world, random, posX, posY, posZ);
	    }
     }
	
	private void spawnFlowers(Block block,World world, Random random, int chunkX , int chunkZ, int spawnChance){
        for(int i = 0; i < spawnChance; i++){
            int posX = chunkX + random.nextInt(16);
            int posY = (world.getHeightValue(chunkX,chunkZ));
            int posZ = chunkZ + random.nextInt(16);
            (new WorldGenFlowers(block)).generate(world, random, posX, posY, posZ);
        }
    }
	
	/*
	private void spawnThorns(Block block, World world, Random random, int chunkX , int chunkZ, int spawnChance){
		for(int i = 0; i < spawnChance; i++){
    		int posX = chunkX + random.nextInt(16);
        	int posY = (world.getHeightValue(chunkX,chunkZ));
        	int posZ = chunkZ + random.nextInt(16);
        	(new WorldGenTwigs(block)).generate(world, random, posX, posY, posZ);
    	}
	}
	*/

}
