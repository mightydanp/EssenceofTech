package com.mightydanp.eot.common.handler;

import com.mightydanp.eot.common.block.ModBlocks;
import com.mightydanp.eot.common.item.ItemBasicOre;
import com.mightydanp.eot.common.item.ItemEssenceOre;
import com.mightydanp.eot.common.item.ItemMagicalStone;
import com.mightydanp.eot.common.lib.BlockReferences;
import com.mightydanp.eot.common.lib.ItemReferences;
import com.mightydanp.eot.common.lib.References;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;

public class RegistryHandler {
	
	public static void registerBlock(Block block) {
		GameRegistry.registerBlock(block, block.getUnlocalizedName());
	}
	
	public static void registerBlockWithMetadata(Block block, Class itemBlock) {
		GameRegistry.registerBlock(block, itemBlock, block.getUnlocalizedName());
	}
	
	public static void registerOreDictionaryforBlock(Block block, String name) {
		OreDictionary.registerOre(block.getUnlocalizedName(), block);
	} 
	
	public static void registerOreDictionaryforItem(Item item, String name) {
		OreDictionary.registerOre(name, item);
	}
	
	public static void registerOreDictionaryforMetadataBlock(Block Block, int meta, String name) {
		OreDictionary.registerOre(name, new ItemStack(Block, 1, meta));
	}
	
	public static void registerOreDictionaryforMetadataItem(Item Item, int meta, String name) {
		OreDictionary.registerOre(name, new ItemStack(Item, 1, meta));
	}

}
