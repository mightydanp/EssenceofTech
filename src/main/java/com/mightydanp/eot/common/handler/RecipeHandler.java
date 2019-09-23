package com.mightydanp.eot.common.handler;

import com.mightydanp.eot.common.block.ModBlocks;
import com.mightydanp.eot.common.item.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class RecipeHandler {
	public static void init(){
		craftingRecipe();
		smeltingRecipe();
	}

	private static void craftingRecipe() {
		//Block
		    //compressed
		RecipeHandler.addBlockShapedCrafting(ModBlocks.compressed, 1, 0, "AAA" ,"AAA","AAA", 'A',"ingotCopper");
		RecipeHandler.addBlockShapedCrafting(ModBlocks.compressed, 1, 1, "AAA" ,"AAA","AAA", 'A',"ingotTin");
		RecipeHandler.addBlockShapedCrafting(ModBlocks.compressed, 1, 2, "AAA" ,"AAA","AAA", 'A',"ingotSilver");
		RecipeHandler.addBlockShapedCrafting(ModBlocks.compressed, 1, 3, "AAA" ,"AAA","AAA", 'A',"ingotLead");
		RecipeHandler.addBlockShapedCrafting(ModBlocks.compressed, 1, 4, "AAA" ,"AAA","AAA", 'A',"ingotBronze");
		RecipeHandler.addBlockShapedCrafting(ModBlocks.compressed, 1, 5, "AAA" ,"AAA","AAA", 'A',"gemRuby");
		RecipeHandler.addBlockShapedCrafting(ModBlocks.compressed, 1, 6, "AAA" ,"AAA","AAA", 'A',"gemSapphire");
		    //Decorative
		RecipeHandler.addBlockShapedCrafting(ModBlocks.decorativeBlock, 4, 0, "AA " ,"AA ", 'A',"stoneBrick");
		RecipeHandler.addBlockShapedCrafting(ModBlocks.decorativeBlock, 4, 0, " AA" ," AA", 'A',"stoneBrick");
		RecipeHandler.addBlockShapedCrafting(ModBlocks.decorativeBlock, 4, 0, "AA " ,"AA ", 'A',"brickStone");
		RecipeHandler.addBlockShapedCrafting(ModBlocks.decorativeBlock, 4, 0, " AA" ," AA", 'A',"brickStone");
		//Item
		    //Ingot
		RecipeHandler.addItemShapelessCrafting(ModItems.ingot, 9, 0, "blockCopper");
		RecipeHandler.addItemShapelessCrafting(ModItems.ingot, 9, 1, "blockTin");
		RecipeHandler.addItemShapelessCrafting(ModItems.ingot, 9, 2, "blockSilver");
		RecipeHandler.addItemShapelessCrafting(ModItems.ingot, 9, 3, "blockLead");
		RecipeHandler.addItemShapelessCrafting(ModItems.ingot, 9, 4, "blockBronze");
		RecipeHandler.addItemShapelessCrafting(ModItems.gem, 9, 0, "blockRuby");
		RecipeHandler.addItemShapelessCrafting(ModItems.gem, 9, 1, "blockSapphire");
		RecipeHandler.addItemShapelessCrafting(ModItems.ingot, 3, 4, "ingotTin", "ingotCopper", "ingotCopper", "ingotCopper");
		RecipeHandler.addItemShapelessCrafting(ModItems.powder, 4, 6, "powderTin", "powderCopper", "powderCopper", "powderCopper");
	}
	
	private static void smeltingRecipe() {
		//Block
		//Item
		    //Ingot
		RecipeHandler.addBlockSmeltingToOre(ModBlocks.ore, 0, "ingotCopper", 0.1F);
		RecipeHandler.addBlockSmeltingToOre(ModBlocks.ore, 1, "ingotTin", 0.1F);
		RecipeHandler.addBlockSmeltingToOre(ModBlocks.ore, 2, "ingotSilver", 0.1F);
		RecipeHandler.addBlockSmeltingToOre(ModBlocks.ore, 3, "ingotLead", 0.1F);
		RecipeHandler.addItemSmeltingToOre(ModItems.powder, 1, 0, "ingotIron", 0.0F);
		RecipeHandler.addItemSmeltingToOre(ModItems.powder, 1, 1, "ingotGold", 0.0F);
		RecipeHandler.addItemSmeltingToOre(ModItems.powder, 1, 2, "ingotCopper", 0.0F);
		RecipeHandler.addItemSmeltingToOre(ModItems.powder, 1, 3, "ingotTin", 0.0F);
		RecipeHandler.addItemSmeltingToOre(ModItems.powder, 1, 4, "ingotSilver", 0.0F);
		RecipeHandler.addItemSmeltingToOre(ModItems.powder, 1, 5, "ingotLead", 0.0F);
		RecipeHandler.addItemSmeltingToOre(ModItems.powder, 1, 6, "ingotBronze", 0.0F);
	}
	
	public static void addBlockShapedCrafting(Block blockOutput, int amountOutput, int meta, Object... params){
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockOutput, amountOutput, meta), params));
	}
	public static void addItemShapedCrafting(Item itemOutput, int amountOutput, int meta, Object... params){
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(itemOutput, amountOutput, meta), params));
	}
	
	public static void addBlockShapelessCrafting(Block blockOutput, int amountOutput, int meta, Object... params){
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(blockOutput, amountOutput, meta), params));
	}
	
	public static void addItemShapelessCrafting(Item itemOutput, int amountOutput, int meta, Object... params){
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(itemOutput, amountOutput, meta), params));
	}
	

	public static void addBlockSmeltingToItem(Block blockInput, Item itemOutput, int amountOutput, int meta, float expGiven){
		GameRegistry.addSmelting(blockInput, new ItemStack(itemOutput , amountOutput, meta), expGiven);
	}
	
	public static void addBlockSmeltingToBlock(Block blockInput, Block blockOutput, int amountOutput, int meta, float expGiven){
		GameRegistry.addSmelting(blockInput, new ItemStack(blockOutput , amountOutput, meta), expGiven);
	}
	
	public static void addItemSmeltingToItem(Item itemInput, Item itemOutput, int amountOutput, int meta, float expGiven){
		GameRegistry.addSmelting(itemInput, new ItemStack(itemOutput , amountOutput, meta), expGiven);
	}
	
	public static void addItemSmeltingToBlock(Item itemInput, Block blockOutput, int amountOutput, int meta, float expGiven){
		GameRegistry.addSmelting(itemInput, new ItemStack(blockOutput , amountOutput, meta), expGiven);
	}
	
	public static void addBlockSmeltingToOre(Block blockInput, int meta, String oreDictionaryOutput, float xpGiven){
		for(ItemStack ore : OreDictionary.getOres(oreDictionaryOutput)){
			GameRegistry.addSmelting(new ItemStack(blockInput, 1, meta), ore, xpGiven);
		}
	}
	
	public static void addItemSmeltingToOre(Item itemInput, int amountOutput, int meta, String oreDictionaryOutput, float xpGiven){
		for(ItemStack ore : OreDictionary.getOres(oreDictionaryOutput)){
			GameRegistry.addSmelting(new ItemStack(itemInput, amountOutput, meta), ore, xpGiven);
		}
	}
	
	public static void addOreSmeltingToBlock(String oreDictionaryInput, Block blockInput, int meta, int recoveredOutput, float xpGiven){
		for(ItemStack ore : OreDictionary.getOres(oreDictionaryInput)){
			GameRegistry.addSmelting(ore, new ItemStack(blockInput, recoveredOutput, meta), xpGiven);
		}
	}
	
	public static void addOreSmeltingToItem(String oreDictionaryInput, Item itemInput, int meta, int recoveredOutput, float xpGiven){
		for(ItemStack ore : OreDictionary.getOres(oreDictionaryInput)){
			GameRegistry.addSmelting(ore, new ItemStack(itemInput, recoveredOutput, meta), xpGiven);
		}
	}

}
