package com.mightydanp.eot.common.block;

import com.mightydanp.eot.api.common.handler.IRegistryHandler;
import com.mightydanp.eot.common.item.ItemCauldronLid;
import com.mightydanp.eot.common.item.ItemTwigs;
import com.mightydanp.eot.common.lib.BlockReference;
import com.mightydanp.eot.common.lib.ItemReference;
import com.mightydanp.eot.common.lib.Reference;
import com.mightydanp.eot.common.logger.EoTLogger;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

/**
 * @auther MightyDanp date class created: Jul 5, 2016
 */
public class ModBlocks extends IRegistryHandler {

	private static IRegistryHandler	register;

	public static Block							cauldronLid;
	public static String						cauldronLidStates[]				= { "cauldron_lid" };
	public static Block							compressed;
	public static String						compressedBlockStates[]		= { "copper", "tin", "silver", "lead", "bronze", "ruby", "sapphire" };
	public static Block							decorative;
	public static String						decorativeBlockStates[]		= { "brick_castle" };
	public static Block							essenceStone;
	public static String						essenceStoneBlockStates[]	= { "magic", "air", "earth", "fire", "water" };
	public static Block							ore;
	public static String						oreBlockStates[]					= { "copper", "tin", "silver", "lead" };
	public static Block							oreGem;
	public static String						oreGemBlockStates[]				= { "ruby", "sapphire" };
	public static Block							twigs;
	public static String						twigsBlockStates[]				= { "twigs" };

	public static void preInit() {
		EoTLogger.logInfoMessage(Reference.MODID + ":" + "ModBlocks preInit is loading.");
		//
		registerBlock(cauldronLid = new BlockCauldronLid(BlockReference.CAULDRONLID_NAME), BlockReference.CAULDRONLID_NAME, null, new ItemCauldronLid(cauldronLid, null));
		registerBlock(compressed = new BlockCompressed(BlockReference.COMPRESSED_NAME), BlockReference.COMPRESSED_NAME, compressedBlockStates, null);
		registerBlock(decorative = new BlockDecorative(BlockReference.DECORATIVE_NAME), BlockReference.DECORATIVE_NAME, decorativeBlockStates, null);
		registerBlock(essenceStone = new BlockEssenceStone(BlockReference.ESSENCESTONE_NAME), BlockReference.ESSENCESTONE_NAME, essenceStoneBlockStates, null);
		registerBlock(ore = new BlockOre(BlockReference.ORE_NAME), BlockReference.ORE_NAME, oreBlockStates, null);
		registerBlock(oreGem = new BlockOreGem(BlockReference.OREGEM_NAME), BlockReference.OREGEM_NAME, oreGemBlockStates, null);
		registerBlock(twigs = new BlockTwigs(BlockReference.TWIGS_NAME), BlockReference.TWIGS_NAME, null, new ItemTwigs(twigs, null));
		//
		EoTLogger.logInfoMessage(Reference.MODID + ":" + "ModBlocks preInit has loaded.");
	}

	public static void init() {
		EoTLogger.logInfoMessage(Reference.MODID + "ModBlocks init has loaded.");
		registerOreDictionary();
		registerRecipes();
		registerBlockMiningLevel();
		EoTLogger.logInfoMessage(Reference.MODID + "ModBlocks init has loaded.");
	}

	public static void renderBlocks() {
		renderBlock(cauldronLid, BlockReference.CAULDRONLID_NAME, null, 0);
		
		for (int i = 0; i < essenceStoneBlockStates.length; i++) {
			renderBlock(essenceStone, BlockReference.ESSENCESTONE_NAME, essenceStoneBlockStates[i], i);
		}
		for (int i = 0; i < oreBlockStates.length; i++) {
			renderBlock(ore, BlockReference.ORE_NAME, oreBlockStates[i], i);
		}
		for (int i = 0; i < compressedBlockStates.length; i++) {
			renderBlock(compressed, BlockReference.COMPRESSED_NAME, compressedBlockStates[i], i);
		}
		for (int i = 0; i < decorativeBlockStates.length; i++) {
			renderBlock(decorative, BlockReference.DECORATIVE_NAME, decorativeBlockStates[i], i);
		}
		for (int i = 0; i < oreGemBlockStates.length; i++) {
			renderBlock(oreGem, BlockReference.OREGEM_NAME, oreGemBlockStates[i], i);
		}

		renderBlock(twigs, BlockReference.TWIGS_NAME, null, 0);
	}

	public static void registerOreDictionary() {
		registerOreDictionary(compressed, "block", "Copper", 0);
		registerOreDictionary(compressed, "block", "Tin", 1);
		registerOreDictionary(compressed, "block", "Silver", 2);
		registerOreDictionary(compressed, "block", "Lead", 3);
		registerOreDictionary(compressed, "block", "Bronze", 4);
		registerOreDictionary(compressed, "block", "Ruby", 5);
		registerOreDictionary(compressed, "block", "Sapphire", 6);
		registerOreDictionary(decorative, "block", "Castle", 0);
		registerOreDictionary(essenceStone, BlockReference.ESSENCESTONE_NAME, "Magic", 0);
		registerOreDictionary(essenceStone, BlockReference.ESSENCESTONE_NAME, "Air", 1);
		registerOreDictionary(essenceStone, BlockReference.ESSENCESTONE_NAME, "Earth", 2);
		registerOreDictionary(essenceStone, BlockReference.ESSENCESTONE_NAME, "Fire", 3);
		registerOreDictionary(essenceStone, BlockReference.ESSENCESTONE_NAME, "Water", 4);
		registerOreDictionary(ore, BlockReference.ORE_NAME, "Copper", 0);
		registerOreDictionary(ore, BlockReference.ORE_NAME, "Tin", 1);
		registerOreDictionary(ore, BlockReference.ORE_NAME, "Silver", 2);
		registerOreDictionary(ore, BlockReference.ORE_NAME, "Lead", 3);
		registerOreDictionary(oreGem, BlockReference.OREGEM_NAME, "Ruby", 0);
		registerOreDictionary(oreGem, BlockReference.OREGEM_NAME, "Sapphire", 1);
	}

	public static void registerRecipes() {
		registerBlockRecipe(true, decorative, 0, 4, "AA ", "AA ", 'A', Blocks.STONEBRICK);
		registerBlockRecipe(true, decorative, 0, 4, " AA", " AA", 'A', Blocks.STONEBRICK);
		registerBlockRecipe(true, compressed, 0, 1, "AAA", "AAA", "AAA", 'A', ItemReference.INGOT_NAME + "Copper");
		registerBlockRecipe(true, compressed, 1, 1, "AAA", "AAA", "AAA", 'A', ItemReference.INGOT_NAME + "Tin");
		registerBlockRecipe(true, compressed, 2, 1, "AAA", "AAA", "AAA", 'A', ItemReference.INGOT_NAME + "Silver");
		registerBlockRecipe(true, compressed, 3, 1, "AAA", "AAA", "AAA", 'A', ItemReference.INGOT_NAME + "Lead");
		registerBlockRecipe(true, compressed, 4, 1, "AAA", "AAA", "AAA", 'A', ItemReference.INGOT_NAME + "Bronze");
		registerBlockRecipe(true, compressed, 5, 1, "AAA", "AAA", "AAA", 'A', ItemReference.GEM_NAME + "Ruby");
		registerBlockRecipe(true, compressed, 6, 1, "AAA", "AAA", "AAA", 'A', ItemReference.GEM_NAME + "Sapphire");
	}

	public static void registerFurnaceRecipes() {

	}
	
	public static void registerBlockMiningLevel() {
		setBlockMiningLevel(Blocks.IRON_ORE, "pickaxe", 2);
		setBlockMiningLevel(Blocks.GOLD_ORE, "pickaxe", 2);
		setBlockMiningLevel(Blocks.EMERALD_ORE, "pickaxe", 3);
		setBlockMiningLevel(Blocks.OBSIDIAN, "pickaxe", 3);
		setBlockMiningLevel(Blocks.DIAMOND_ORE, "pickaxe", 4);
	}
}
