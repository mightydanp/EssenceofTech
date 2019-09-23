package com.mightydanp.eot.block;

import com.mightydanp.eot.core.config.BlockConfiguration;
import com.mightydanp.eot.core.handler.RegistryHandler;
import com.mightydanp.eot.item.ItemBasicOre;
import com.mightydanp.eot.item.ItemCompressed;
import com.mightydanp.eot.item.ItemDecorativeBlock;
import com.mightydanp.eot.item.ItemEssenceOre;
import com.mightydanp.eot.item.ModItems;
import com.mightydanp.eot.lib.BlockStrings;

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
		essenceStone = new BlockEssenceOre(BlockStrings.ESSENCESTONE_NAME).setHardness(0.5F);
		RegistryHandler.registerBlockWithMetadata(essenceStone, ItemEssenceOre.class);
		RegistryHandler.registerOreDictionaryforMetadataBlock(essenceStone, 0, BlockStrings.ESSENCESTONE_NAME + "Magic");
		RegistryHandler.registerOreDictionaryforMetadataBlock(essenceStone, 1, BlockStrings.ESSENCESTONE_NAME + "Air");
		RegistryHandler.registerOreDictionaryforMetadataBlock(essenceStone, 2, BlockStrings.ESSENCESTONE_NAME + "Earth");
		RegistryHandler.registerOreDictionaryforMetadataBlock(essenceStone, 3, BlockStrings.ESSENCESTONE_NAME + "Fire");
		RegistryHandler.registerOreDictionaryforMetadataBlock(essenceStone, 4, BlockStrings.ESSENCESTONE_NAME + "Water");
		
		ore = new BlockDefaultOre(BlockStrings.ORE_NAME).setHardness(2.2F);
		RegistryHandler.registerBlockWithMetadata(ore, ItemBasicOre.class);
		RegistryHandler.registerOreDictionaryforMetadataBlock(ore, 0, BlockStrings.ORE_NAME + "Copper");
		RegistryHandler.registerOreDictionaryforMetadataBlock(ore, 1, BlockStrings.ORE_NAME + "Tin");
		RegistryHandler.registerOreDictionaryforMetadataBlock(ore, 2, BlockStrings.ORE_NAME + "Silver");
		RegistryHandler.registerOreDictionaryforMetadataBlock(ore, 3, BlockStrings.ORE_NAME + "Lead");
		RegistryHandler.registerOreDictionaryforMetadataBlock(ore, 4, BlockStrings.ORE_NAME + "Ruby");
		RegistryHandler.registerOreDictionaryforMetadataBlock(ore, 5, BlockStrings.ORE_NAME + "Sapphire");
		
		compressed = new BlockCompressed(BlockStrings.COMPRESSED_NAME);
		RegistryHandler.registerBlockWithMetadata(compressed, ItemCompressed.class);
		RegistryHandler.registerOreDictionaryforMetadataBlock(compressed, 0, BlockStrings.COMPRESSED_NAME + "Copper");
		RegistryHandler.registerOreDictionaryforMetadataBlock(compressed, 1, BlockStrings.COMPRESSED_NAME + "Tin");
		RegistryHandler.registerOreDictionaryforMetadataBlock(compressed, 2, BlockStrings.COMPRESSED_NAME + "Silver");
		RegistryHandler.registerOreDictionaryforMetadataBlock(compressed, 3, BlockStrings.COMPRESSED_NAME + "Lead");
		RegistryHandler.registerOreDictionaryforMetadataBlock(compressed, 4, BlockStrings.COMPRESSED_NAME + "Bronze");
		RegistryHandler.registerOreDictionaryforMetadataBlock(compressed, 5, BlockStrings.COMPRESSED_NAME + "Ruby");
		
		decorativeBlock = new BlockDecorative(BlockStrings.DECORATIVEBLOCK_NAME);
		RegistryHandler.registerBlockWithMetadata(decorativeBlock, ItemDecorativeBlock.class);
		RegistryHandler.registerOreDictionaryforMetadataBlock(Blocks.stonebrick, 0, "stoneBrick");
		RegistryHandler.registerOreDictionaryforMetadataBlock(Blocks.stonebrick, 0, "brickStone");
		RegistryHandler.registerOreDictionaryforMetadataBlock(decorativeBlock, 0, "brickCastle");
	}
}
