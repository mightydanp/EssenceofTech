package com.mightydanp.eot.item;

import com.mightydanp.eot.block.ModBlocks;
import com.mightydanp.eot.core.config.ItemConfiguration;
import com.mightydanp.eot.core.handler.ConfigurationHandler;
import com.mightydanp.eot.core.handler.RecipeHandler;
import com.mightydanp.eot.lib.ItemStrings;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ModItems {
	public static Item magicalStone;
	public static Item hammerMysterious;
	public static Item endermanFlesh;
	public static Item Bagtier1;
	public static Item Bagtier2;
	public static Item Bagtier3;
	public static Item essenceChunks;
	public static Item ingot;
	public static Item gem;
	public static Item rawPowder;
	public static Item purePowder;
	public static Item powder;
	
	
	public static ToolMaterial HammerMysteriousMaterial = EnumHelper.addToolMaterial(ItemStrings.HAMMERMYSTERIOUS_NAME, 0, 64, 2.0F, 0.5F, 5);
	
	public static void init(){
		
		if(ItemConfiguration.magicalStoneEnable){
			magicalStone = new ItemMagicalStone(ItemStrings.MAGICALSTONE_NAME);
			GameRegistry.registerItem(magicalStone = new ItemMagicalStone(ItemStrings.MAGICALSTONE_NAME), ItemStrings.MAGICALSTONE_NAME);
			OreDictionary.registerOre("magicalStoneFull", new ItemStack(magicalStone, 1, 0));
			OreDictionary.registerOre("magicalStoneEmpty", new ItemStack(magicalStone, 1, 16));
		}
		
		if(ItemConfiguration.mysteriousHammerEnable){
			hammerMysterious = new ItemMysteriousHammer(HammerMysteriousMaterial ,ItemStrings.HAMMERMYSTERIOUS_NAME);
			GameRegistry.registerItem(hammerMysterious ,ItemStrings.HAMMERMYSTERIOUS_NAME);
			OreDictionary.registerOre("hammerMysterious", hammerMysterious);
		}
		
		if(ItemConfiguration.endermanFleshEnable){
			endermanFlesh = new ItemEndermanFlesh(ItemStrings.ENDERMANFLESH_NAME, 4, 0.1F, false).setAlwaysEdible();
			GameRegistry.registerItem(endermanFlesh ,ItemStrings.ENDERMANFLESH_NAME);
			OreDictionary.registerOre("endermanFlesh", endermanFlesh);
		}
		
		if(ItemConfiguration.tier1BagEnable){
			Bagtier1 = new ItemTier1Bag(ItemStrings.BAGTIER1_NAME);
			GameRegistry.registerItem(Bagtier1 ,ItemStrings.BAGTIER1_NAME);
			OreDictionary.registerOre("Bagtier1", Bagtier1);
		}
		
		if(ItemConfiguration.tier2BagEnable){
			Bagtier2 = new ItemTier2Bag(ItemStrings.BAGTIER2_NAME);
			GameRegistry.registerItem(Bagtier2 ,ItemStrings.BAGTIER2_NAME);
			OreDictionary.registerOre("Bagtier2", Bagtier2);
		}
		
		if(ItemConfiguration.tier3BagEnable){
			Bagtier3 = new ItemTier3Bag(ItemStrings.BAGTIER3_NAME);
			GameRegistry.registerItem(Bagtier3 ,ItemStrings.BAGTIER3_NAME);
			OreDictionary.registerOre("Bagtier3", Bagtier3);
		}
		
		if(ItemConfiguration.essenceChunksEnable){
			essenceChunks = new ItemEssenceChunks(ItemStrings.ESSANCECHUNK_NAME);
			GameRegistry.registerItem(essenceChunks = new ItemEssenceChunks(ItemStrings.ESSANCECHUNK_NAME), ItemStrings.ESSANCECHUNK_NAME);
			OreDictionary.registerOre("essenceChunksMagic", new ItemStack(essenceChunks, 1, 0));
			OreDictionary.registerOre("essenceChunksAir", new ItemStack(magicalStone, 1, 1));
			OreDictionary.registerOre("essenceChunksEarth", new ItemStack(magicalStone, 1, 2));
			OreDictionary.registerOre("essenceChunksFire", new ItemStack(magicalStone, 1, 3));
			OreDictionary.registerOre("essenceChunksWater", new ItemStack(magicalStone, 1, 4));
		}
		
		ingot = new ItemIngot(ItemStrings.INGOT_NAME);
		GameRegistry.registerItem(ingot = new ItemIngot(ItemStrings.INGOT_NAME), ItemStrings.INGOT_NAME);
		OreDictionary.registerOre("ingotCopper", new ItemStack(ingot, 1, 0));
		OreDictionary.registerOre("ingotTin", new ItemStack(ingot, 1, 1));
		OreDictionary.registerOre("ingotSilver", new ItemStack(ingot, 1, 2));
		OreDictionary.registerOre("ingotLead", new ItemStack(ingot, 1, 3));
		OreDictionary.registerOre("ingotBronze", new ItemStack(ingot, 1, 4));
		OreDictionary.registerOre("ingotSteel", new ItemStack(ingot, 1, 5));
		
		gem = new ItemGem(ItemStrings.GEM_NAME);
		GameRegistry.registerItem(gem = new ItemGem(ItemStrings.GEM_NAME), ItemStrings.GEM_NAME);
		OreDictionary.registerOre("gemRuby", new ItemStack(gem, 1, 0));
		OreDictionary.registerOre("gemSapphire", new ItemStack(gem, 1, 1));
		
		rawPowder = new ItemRawPowder(ItemStrings.RAWPOWDER_NAME);
		GameRegistry.registerItem(rawPowder = new ItemRawPowder(ItemStrings.RAWPOWDER_NAME), ItemStrings.RAWPOWDER_NAME);
		OreDictionary.registerOre("rawPowderIron", new ItemStack(rawPowder, 1, 0));
		OreDictionary.registerOre("rawPowderGold", new ItemStack(rawPowder, 1, 1));
		OreDictionary.registerOre("rawPowderCopper", new ItemStack(rawPowder, 1, 2));
		OreDictionary.registerOre("rawPowderTin", new ItemStack(rawPowder, 1, 3));
		OreDictionary.registerOre("rawPowderSilver", new ItemStack(rawPowder, 1, 4));
		OreDictionary.registerOre("rawPowderLead", new ItemStack(rawPowder, 1, 5));
		
		purePowder = new ItemPurePowder(ItemStrings.PUREPOWDER_NAME);
		GameRegistry.registerItem(purePowder = new ItemPurePowder(ItemStrings.PUREPOWDER_NAME), ItemStrings.PUREPOWDER_NAME);
		OreDictionary.registerOre("purePowderIron", new ItemStack(purePowder, 1, 0));
		OreDictionary.registerOre("purePowderGold", new ItemStack(purePowder, 1, 1));
		OreDictionary.registerOre("purePowderCopper", new ItemStack(purePowder, 1, 2));
		OreDictionary.registerOre("purePowderTin", new ItemStack(purePowder, 1, 3));
		OreDictionary.registerOre("purePowderSilver", new ItemStack(purePowder, 1, 4));
		OreDictionary.registerOre("purePowderLead", new ItemStack(purePowder, 1, 5));
		
		powder = new ItemPowder(ItemStrings.POWDER_NAME);
		GameRegistry.registerItem(powder = new ItemPowder(ItemStrings.POWDER_NAME), ItemStrings.POWDER_NAME);
		OreDictionary.registerOre("powderIron", new ItemStack(powder, 1, 0));
		OreDictionary.registerOre("powderGold", new ItemStack(powder, 1, 1));
		OreDictionary.registerOre("powderCopper", new ItemStack(powder, 1, 2));
		OreDictionary.registerOre("powderTin", new ItemStack(powder, 1, 3));
		OreDictionary.registerOre("powderSilver", new ItemStack(powder, 1, 4));
		OreDictionary.registerOre("powderLead", new ItemStack(powder, 1, 5));
		OreDictionary.registerOre("powderBronze", new ItemStack(powder, 1, 6));
		
		
	}
}