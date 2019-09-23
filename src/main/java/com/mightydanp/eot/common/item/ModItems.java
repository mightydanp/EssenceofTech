package com.mightydanp.eot.common.item;

import com.mightydanp.eot.common.block.ModBlocks;
import com.mightydanp.eot.common.config.ItemConfiguration;
import com.mightydanp.eot.common.handler.ConfigurationHandler;
import com.mightydanp.eot.common.handler.RecipeHandler;
import com.mightydanp.eot.common.lib.ItemReferences;

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
	public static Item bagTier1;
	public static Item bagTier2;
	public static Item bagTier3;
	public static Item essenceChunks;
	public static Item ingot;
	public static Item gem;
	public static Item rawPowder;
	public static Item purePowder;
	public static Item powder;
	
	
	public static ToolMaterial HammerMysteriousMaterial = EnumHelper.addToolMaterial(ItemReferences.HAMMER_MYSTERIOUS_NAME, 0, 64, 2.0F, 0.5F, 5);
	
	public static void init(){
		
		if(ItemConfiguration.magicalStoneEnable){
			magicalStone = new ItemMagicalStone(ItemReferences.MAGICAL_STONE_NAME);
			GameRegistry.registerItem(magicalStone = new ItemMagicalStone(ItemReferences.MAGICAL_STONE_NAME), ItemReferences.MAGICAL_STONE_NAME);
			OreDictionary.registerOre("magicalStoneFull", new ItemStack(magicalStone, 1, 0));
			OreDictionary.registerOre("magicalStoneEmpty", new ItemStack(magicalStone, 1, 16));
		}
		
		if(ItemConfiguration.mysteriousHammerEnable){
			hammerMysterious = new ItemMysteriousHammer(HammerMysteriousMaterial ,ItemReferences.HAMMER_MYSTERIOUS_NAME);
			GameRegistry.registerItem(hammerMysterious ,ItemReferences.HAMMER_MYSTERIOUS_NAME);
			OreDictionary.registerOre("hammerMysterious", hammerMysterious);
		}
		
		if(ItemConfiguration.endermanFleshEnable){
			endermanFlesh = new ItemEndermanFlesh(ItemReferences.ENDERMAN_FLESH_NAME, 4, 0.1F, false).setAlwaysEdible();
			GameRegistry.registerItem(endermanFlesh ,ItemReferences.ENDERMAN_FLESH_NAME);
			OreDictionary.registerOre("endermanFlesh", endermanFlesh);
		}
		
		if(ItemConfiguration.tier1BagEnable){
			bagTier1 = new ItemTier1Bag(ItemReferences.BAG_TIER_1_NAME);
			GameRegistry.registerItem(bagTier1 ,ItemReferences.BAG_TIER_1_NAME);
			OreDictionary.registerOre("bagTier1", bagTier1);
		}
		
		if(ItemConfiguration.tier2BagEnable){
			bagTier2 = new ItemTier2Bag(ItemReferences.BAG_TIER_2_NAME);
			GameRegistry.registerItem(bagTier2 ,ItemReferences.BAG_TIER_2_NAME);
			OreDictionary.registerOre("bag_tier_2", bagTier2);
		}
		
		if(ItemConfiguration.tier3BagEnable){
			bagTier3 = new ItemTier3Bag(ItemReferences.BAG_TIER_3_NAME);
			GameRegistry.registerItem(bagTier3 ,ItemReferences.BAG_TIER_3_NAME);
			OreDictionary.registerOre("bag_tier_3", bagTier3);
		}
		
		if(ItemConfiguration.essenceChunksEnable){
			essenceChunks = new ItemEssenceChunks(ItemReferences.ESSANCE_CHUNK_NAME);
			GameRegistry.registerItem(essenceChunks = new ItemEssenceChunks(ItemReferences.ESSANCE_CHUNK_NAME), ItemReferences.ESSANCE_CHUNK_NAME);
			OreDictionary.registerOre("essence_chunks_magic", new ItemStack(essenceChunks, 1, 0));
			OreDictionary.registerOre("essence_chunks_air", new ItemStack(magicalStone, 1, 1));
			OreDictionary.registerOre("essence_chunks_earth", new ItemStack(magicalStone, 1, 2));
			OreDictionary.registerOre("essence_chunks_fire", new ItemStack(magicalStone, 1, 3));
			OreDictionary.registerOre("essence_chunks_water", new ItemStack(magicalStone, 1, 4));
		}

		ingot = new ItemIngot(ItemReferences.INGOT_NAME);
		GameRegistry.registerItem(ingot = new ItemIngot(ItemReferences.INGOT_NAME), ItemReferences.INGOT_NAME);
		OreDictionary.registerOre("ingotCopper", new ItemStack(ingot, 1, 0));
		OreDictionary.registerOre("ingotTin", new ItemStack(ingot, 1, 1));
		OreDictionary.registerOre("ingotSilver", new ItemStack(ingot, 1, 2));
		OreDictionary.registerOre("ingotLead", new ItemStack(ingot, 1, 3));
		OreDictionary.registerOre("ingotBronze", new ItemStack(ingot, 1, 4));
		OreDictionary.registerOre("ingotSteel", new ItemStack(ingot, 1, 5));
		
		gem = new ItemGem(ItemReferences.GEM_NAME);
		GameRegistry.registerItem(gem = new ItemGem(ItemReferences.GEM_NAME), ItemReferences.GEM_NAME);
		OreDictionary.registerOre("gemRuby", new ItemStack(gem, 1, 0));
		OreDictionary.registerOre("gemSapphire", new ItemStack(gem, 1, 1));
		
		rawPowder = new ItemRawPowder(ItemReferences.RAW_POWDER_NAME);
		GameRegistry.registerItem(rawPowder = new ItemRawPowder(ItemReferences.RAW_POWDER_NAME), ItemReferences.RAW_POWDER_NAME);
		OreDictionary.registerOre("rawPowderIron", new ItemStack(rawPowder, 1, 0));
		OreDictionary.registerOre("rawPowderGold", new ItemStack(rawPowder, 1, 1));
		OreDictionary.registerOre("rawPowderCopper", new ItemStack(rawPowder, 1, 2));
		OreDictionary.registerOre("rawPowderTin", new ItemStack(rawPowder, 1, 3));
		OreDictionary.registerOre("rawPowderSilver", new ItemStack(rawPowder, 1, 4));
		OreDictionary.registerOre("rawPowderLead", new ItemStack(rawPowder, 1, 5));
		
		purePowder = new ItemPurePowder(ItemReferences.PURE_POWDER_NAME);
		GameRegistry.registerItem(purePowder = new ItemPurePowder(ItemReferences.PURE_POWDER_NAME), ItemReferences.PURE_POWDER_NAME);
		OreDictionary.registerOre("purePowderIron", new ItemStack(purePowder, 1, 0));
		OreDictionary.registerOre("purePowderGold", new ItemStack(purePowder, 1, 1));
		OreDictionary.registerOre("purePowderCopper", new ItemStack(purePowder, 1, 2));
		OreDictionary.registerOre("purePowderTin", new ItemStack(purePowder, 1, 3));
		OreDictionary.registerOre("purePowderSilver", new ItemStack(purePowder, 1, 4));
		OreDictionary.registerOre("purePowderLead", new ItemStack(purePowder, 1, 5));
		
		powder = new ItemPowder(ItemReferences.POWDER_NAME);
		GameRegistry.registerItem(powder = new ItemPowder(ItemReferences.POWDER_NAME), ItemReferences.POWDER_NAME);
		OreDictionary.registerOre("powderIron", new ItemStack(powder, 1, 0));
		OreDictionary.registerOre("powderGold", new ItemStack(powder, 1, 1));
		OreDictionary.registerOre("powderCopper", new ItemStack(powder, 1, 2));
		OreDictionary.registerOre("powderTin", new ItemStack(powder, 1, 3));
		OreDictionary.registerOre("powderSilver", new ItemStack(powder, 1, 4));
		OreDictionary.registerOre("powderLead", new ItemStack(powder, 1, 5));
		OreDictionary.registerOre("powderBronze", new ItemStack(powder, 1, 6));
		
		
	}
}