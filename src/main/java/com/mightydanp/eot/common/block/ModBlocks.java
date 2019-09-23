package com.mightydanp.eot.common.block;

import com.mightydanp.eot.common.config.BlockConfiguration;
import com.mightydanp.eot.common.handler.RegistryHandler;
import com.mightydanp.eot.common.item.ItemBasicOre;
import com.mightydanp.eot.common.item.ItemCompressed;
import com.mightydanp.eot.common.item.ItemDecorativeBlock;
import com.mightydanp.eot.common.item.ItemEssenceOre;
import com.mightydanp.eot.common.item.ModItems;
import com.mightydanp.eot.common.lib.BlockReferences;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ModBlocks {
	public static Block essenceStone;
	public static Block ore;
	public static Block compressed;
	public static Block decorativeBlock;
	
	public static void init(){
		essenceStone = new BlockEssenceOre(BlockReferences.ESSENCE_STONE_NAME).setHardness(0.5F);
		RegistryHandler.registerBlockWithMetadata(essenceStone, ItemEssenceOre.class);
		RegistryHandler.registerOreDictionaryforMetadataBlock(essenceStone, 0, BlockReferences.ESSENCE_STONE_NAME + "Magic");
		RegistryHandler.registerOreDictionaryforMetadataBlock(essenceStone, 1, BlockReferences.ESSENCE_STONE_NAME + "Air");
		RegistryHandler.registerOreDictionaryforMetadataBlock(essenceStone, 2, BlockReferences.ESSENCE_STONE_NAME + "Earth");
		RegistryHandler.registerOreDictionaryforMetadataBlock(essenceStone, 3, BlockReferences.ESSENCE_STONE_NAME + "Fire");
		RegistryHandler.registerOreDictionaryforMetadataBlock(essenceStone, 4, BlockReferences.ESSENCE_STONE_NAME + "Water");
		
		ore = new BlockDefaultOre(BlockReferences.ORE_NAME).setHardness(2.2F);
		RegistryHandler.registerBlockWithMetadata(ore, ItemBasicOre.class);
		RegistryHandler.registerOreDictionaryforMetadataBlock(ore, 0, BlockReferences.ORE_NAME + "Copper");
		RegistryHandler.registerOreDictionaryforMetadataBlock(ore, 1, BlockReferences.ORE_NAME + "Tin");
		RegistryHandler.registerOreDictionaryforMetadataBlock(ore, 2, BlockReferences.ORE_NAME + "Silver");
		RegistryHandler.registerOreDictionaryforMetadataBlock(ore, 3, BlockReferences.ORE_NAME + "Lead");
		RegistryHandler.registerOreDictionaryforMetadataBlock(ore, 4, BlockReferences.ORE_NAME + "Ruby");
		RegistryHandler.registerOreDictionaryforMetadataBlock(ore, 5, BlockReferences.ORE_NAME + "Sapphire");
		
		compressed = new BlockCompressed(BlockReferences.COMPRESSED_NAME);
		RegistryHandler.registerBlockWithMetadata(compressed, ItemCompressed.class);
		RegistryHandler.registerOreDictionaryforMetadataBlock(compressed, 0, BlockReferences.COMPRESSED_NAME + "Copper");
		RegistryHandler.registerOreDictionaryforMetadataBlock(compressed, 1, BlockReferences.COMPRESSED_NAME + "Tin");
		RegistryHandler.registerOreDictionaryforMetadataBlock(compressed, 2, BlockReferences.COMPRESSED_NAME + "Silver");
		RegistryHandler.registerOreDictionaryforMetadataBlock(compressed, 3, BlockReferences.COMPRESSED_NAME + "Lead");
		RegistryHandler.registerOreDictionaryforMetadataBlock(compressed, 4, BlockReferences.COMPRESSED_NAME + "Bronze");
		RegistryHandler.registerOreDictionaryforMetadataBlock(compressed, 5, BlockReferences.COMPRESSED_NAME + "Ruby");
		
		decorativeBlock = new BlockDecorative(BlockReferences.DECORATIVE_BLOCK_NAME);
		RegistryHandler.registerBlockWithMetadata(decorativeBlock, ItemDecorativeBlock.class);
		RegistryHandler.registerOreDictionaryforMetadataBlock(Blocks.stonebrick, 0, "stoneBrick");
		RegistryHandler.registerOreDictionaryforMetadataBlock(Blocks.stonebrick, 0, "brickStone");
		RegistryHandler.registerOreDictionaryforMetadataBlock(decorativeBlock, 0, "brickCastle");
	}
}
