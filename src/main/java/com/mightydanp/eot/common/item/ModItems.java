package com.mightydanp.eot.common.item;

import com.mightydanp.eot.api.common.handler.IRegistryHandler;
import com.mightydanp.eot.api.common.item.IItemAxe;
import com.mightydanp.eot.api.common.item.IItemHoe;
import com.mightydanp.eot.api.common.item.IItemSpade;
import com.mightydanp.eot.api.common.item.IItemSword;
import com.mightydanp.eot.api.common.item.IMetaItem;
import com.mightydanp.eot.common.EoT;
import com.mightydanp.eot.common.lib.BlockReference;
import com.mightydanp.eot.common.lib.ItemReference;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

/**
 * @auther MightyDanp date class created: Jul 5, 2016
 */
public class ModItems extends IRegistryHandler {

	public static ToolMaterial	bronzeToolMaterial					= EnumHelper.addToolMaterial("bronze", 2, 190, 5F, 1.5F, 15);
	public static ToolMaterial	steelToolMaterial					= EnumHelper.addToolMaterial("steel", 3, 1750, 10F, 2.5f, 10);
	
	public static Item					axeBronze;
	public static Item					axeSteel;
	public static Item					bagEmpty;
	public static String				bagEmptyItemStates[]		= { "empty", "vibrant" };
	public static Item					bagTier1;
	public static Item					bagTier2;
	public static Item					bagTier3;
	public static Item					endermanFlesh;
	public static Item					essenceChunk;
	public static String				essenceChunkItemStates[]	= { "magic", "air", "earth", "fire", "water" };
	public static Item					gem;
	public static String				gemItemStates[]			    = { "ruby", "sapphire" };
	public static Item					hoeBronze;
	public static Item					hoeSteel;
	public static Item					ingot;
	public static String				ingotItemStates[]		    = { "copper", "tin", "silver", "lead", "bronze", "steel" };
	public static Item					magicalStone;
	public static Item					mysteriousHammer;
	public static Item					pickaxeBronze;
	public static Item					pickaxeSteel;
	public static Item					powder;
	public static String				powderItemStates[]		    = { "iron", "gold", "copper", "tin", "silver", "lead", "bronze" };
	public static Item					purePowder;
	public static String				purePowderItemStates[]		= { "iron", "gold", "copper", "tin", "silver", "lead" };
	public static Item					rawPowder;
	public static String				rawPowderItemStates[]		= { "iron", "gold", "copper", "tin", "silver", "lead" };
	public static Item					spadeBronze;
	public static Item					spadeSteel;
	public static Item					swordBronze;
	public static Item					swordSteel;
	public static Item					vibrantResource;
	public static String				vibrantResourceItemStates[]	= { "bits" };
	public static Item					xpStone;
	public static String				xpStoneItemStates[]	        = { "full", "9", "8", "7", "6", "5", "4", "3", "2", "1", "empty" };
	
	public static void preInit() {
		
		registerItem(axeBronze = new IItemAxe(bronzeToolMaterial, ItemReference.AXEBRONZE_NAME, 5.5F, -3.2F).setCreativeTab(EoT.tabEoT), ItemReference.AXEBRONZE_NAME);
		registerItem(axeSteel = new IItemAxe(steelToolMaterial, ItemReference.AXESTEEL_NAME, 7.5F, -3.2F).setCreativeTab(EoT.tabEoT), ItemReference.AXESTEEL_NAME);
		registerItem(bagEmpty = new ItemBagEmpty(ItemReference.BAGEMPTY_NAME, bagEmptyItemStates, bagEmptyItemStates.length), ItemReference.BAGEMPTY_NAME);
		registerItem(bagTier1 = new ItemBagTier1(ItemReference.BAGTIER1_NAME), ItemReference.BAGTIER1_NAME);
		registerItem(bagTier2 = new ItemBagTier2(ItemReference.BAGTIER2_NAME), ItemReference.BAGTIER2_NAME);
		registerItem(bagTier3 = new ItemBagTier3(ItemReference.BAGTIER3_NAME), ItemReference.BAGTIER3_NAME);
		registerItem(endermanFlesh = new ItemEndermanFlesh(ItemReference.ENDERMANFLESH_NAME), ItemReference.ENDERMANFLESH_NAME);
		registerItem(essenceChunk = new ItemEssenceChunk(ItemReference.ESSENCECHUNK_NAME, essenceChunkItemStates, essenceChunkItemStates.length), ItemReference.ESSENCECHUNK_NAME);
		registerItem(gem = new IMetaItem(ItemReference.GEM_NAME, gemItemStates, gemItemStates.length), ItemReference.GEM_NAME);
		registerItem(hoeBronze = new IItemHoe(bronzeToolMaterial, ItemReference.HOEBRONZE_NAME).setCreativeTab(EoT.tabEoT), ItemReference.HOEBRONZE_NAME);
		registerItem(hoeSteel = new IItemHoe(steelToolMaterial, ItemReference.HOESTEEL_NAME).setCreativeTab(EoT.tabEoT), ItemReference.HOESTEEL_NAME);
		registerItem(ingot = new IMetaItem(ItemReference.INGOT_NAME, ingotItemStates, ingotItemStates.length).setCreativeTab(EoT.tabEoT), ItemReference.INGOT_NAME);
		registerItem(magicalStone = new ItemMagicalStone(ItemReference.MAGICALSTONE_NAME), ItemReference.MAGICALSTONE_NAME);
		registerItem(mysteriousHammer = new ItemMysteriousHammer(ItemReference.MYSTERIOUSHAMMER_NAME), ItemReference.MYSTERIOUSHAMMER_NAME);
		registerItem(pickaxeBronze = new IItemSword(bronzeToolMaterial, ItemReference.PICKAXEBRONZE_NAME).setCreativeTab(EoT.tabEoT), ItemReference.PICKAXEBRONZE_NAME);
		registerItem(pickaxeSteel = new IItemSword(steelToolMaterial, ItemReference.PICKAXESTEEL_NAME).setCreativeTab(EoT.tabEoT), ItemReference.PICKAXESTEEL_NAME);
		registerItem(powder = new IMetaItem(ItemReference.POWDER_NAME, powderItemStates, powderItemStates.length).setCreativeTab(EoT.tabEoT), ItemReference.POWDER_NAME);
		registerItem(purePowder = new IMetaItem(ItemReference.PUREPOWDER_NAME, purePowderItemStates, purePowderItemStates.length).setCreativeTab(EoT.tabEoT), ItemReference.PUREPOWDER_NAME);
		registerItem(rawPowder = new IMetaItem(ItemReference.RAWPOWDER_NAME, rawPowderItemStates, rawPowderItemStates.length).setCreativeTab(EoT.tabEoT), ItemReference.RAWPOWDER_NAME);
		registerItem(spadeBronze = new IItemSpade(bronzeToolMaterial, ItemReference.SPADEBRONZE_NAME).setCreativeTab(EoT.tabEoT), ItemReference.SPADEBRONZE_NAME);
		registerItem(spadeSteel = new IItemSpade(steelToolMaterial, ItemReference.SPADESTEEL_NAME).setCreativeTab(EoT.tabEoT), ItemReference.SPADESTEEL_NAME);
		registerItem(swordBronze = new IItemSword(bronzeToolMaterial, ItemReference.SWORDBRONZE_NAME).setCreativeTab(EoT.tabEoT), ItemReference.SWORDBRONZE_NAME);
		registerItem(swordSteel = new IItemSword(steelToolMaterial, ItemReference.SWORDSTEEL_NAME).setCreativeTab(EoT.tabEoT), ItemReference.SWORDSTEEL_NAME);
		registerItem(vibrantResource = new ItemVibrantResource(ItemReference.VIBRANTRESOURCE_NAME, vibrantResourceItemStates, vibrantResourceItemStates.length).setCreativeTab(EoT.tabEoT), ItemReference.VIBRANTRESOURCE_NAME);
		registerItem(xpStone = new ItemXpStone(ItemReference.XPSTONE_NAME), ItemReference.XPSTONE_NAME);
	}

	public static void init() {
		registerOreDictionary();
		registerRecipes();
		registerSmeltingRecipes();
		registerBlockMiningLevel();
	}

	public static void renderItems() {
		renderItem(axeBronze, ItemReference.AXEBRONZE_NAME, null, 1);
		renderItem(axeSteel, ItemReference.AXESTEEL_NAME, null, 1);
		renderMetaItem(bagEmpty, ItemReference.BAGEMPTY_NAME, bagEmptyItemStates, bagEmptyItemStates.length);
		renderItem(bagTier1, ItemReference.BAGTIER1_NAME, null, 1);
		renderItem(bagTier2, ItemReference.BAGTIER2_NAME, null, 1);
		renderItem(bagTier3, ItemReference.BAGTIER3_NAME, null, 1);
		renderItem(endermanFlesh, ItemReference.ENDERMANFLESH_NAME, null, 1);
        renderMetaItem(essenceChunk, ItemReference.ESSENCECHUNK_NAME, essenceChunkItemStates, essenceChunkItemStates.length);
		for (int i = 0; i < gemItemStates.length; i++) {
			renderItem(gem, ItemReference.GEM_NAME, gemItemStates[i], i);
		}
		renderItem(hoeBronze, ItemReference.HOEBRONZE_NAME, null, 1);
		renderItem(hoeSteel, ItemReference.HOESTEEL_NAME, null, 1);
		for (int i = 0; i < ingotItemStates.length; i++) {
			renderItem(ingot, ItemReference.INGOT_NAME, ingotItemStates[i], i);
		}
		renderItem(magicalStone, ItemReference.MAGICALSTONE_NAME, null, 1);
		renderItem(mysteriousHammer, ItemReference.MYSTERIOUSHAMMER_NAME, null, 1);
		renderItem(pickaxeBronze, ItemReference.PICKAXEBRONZE_NAME, null, 1);
		renderItem(pickaxeSteel, ItemReference.PICKAXESTEEL_NAME, null, 1);
		for (int i = 0; i < powderItemStates.length; i++) {
			renderItem(powder, ItemReference.POWDER_NAME, powderItemStates[i], i);
		}
		for (int i = 0; i < purePowderItemStates.length; i++) {
			renderItem(purePowder, ItemReference.PUREPOWDER_NAME, purePowderItemStates[i], i);
		}
		for (int i = 0; i < rawPowderItemStates.length; i++) {
			renderItem(rawPowder, ItemReference.RAWPOWDER_NAME, rawPowderItemStates[i], i);
		}
		renderItem(spadeBronze, ItemReference.SPADEBRONZE_NAME, null, 1);
		renderItem(spadeSteel, ItemReference.SPADESTEEL_NAME, null, 1);
		renderItem(swordBronze, ItemReference.SWORDBRONZE_NAME, null, 1);
		renderItem(swordSteel, ItemReference.SWORDSTEEL_NAME, null, 1);
		for (int i = 0; i < vibrantResourceItemStates.length; i++) {
			renderItem(vibrantResource, ItemReference.VIBRANTRESOURCE_NAME, vibrantResourceItemStates[i], i);
		}
		renderItem(xpStone, ItemReference.XPSTONE_NAME, null, 1);
	}

	public static void registerOreDictionary() {
		registerOreDictionary(bagEmpty, ItemReference.BAGEMPTY_NAME, "_empty", 0);
		registerOreDictionary(bagEmpty, ItemReference.BAGEMPTY_NAME, "_vibrant", 1);
		registerOreDictionary(bagTier1, ItemReference.BAGTIER1_NAME, null, 0);
		registerOreDictionary(bagTier2, ItemReference.BAGTIER2_NAME, null, 0);
		registerOreDictionary(bagTier3, ItemReference.BAGTIER3_NAME, null, 0);
		registerOreDictionary(essenceChunk, ItemReference.ESSENCECHUNK_NAME, "Magic", 0);
		registerOreDictionary(essenceChunk, ItemReference.ESSENCECHUNK_NAME, "Air", 1);
		registerOreDictionary(essenceChunk, ItemReference.ESSENCECHUNK_NAME, "Earth", 2);
		registerOreDictionary(essenceChunk, ItemReference.ESSENCECHUNK_NAME, "Fire", 3);
		registerOreDictionary(essenceChunk, ItemReference.ESSENCECHUNK_NAME, "Water", 4);
		registerOreDictionary(gem, ItemReference.GEM_NAME, "Ruby", 0);
		registerOreDictionary(gem, ItemReference.GEM_NAME, "Sapphire", 1);
		registerOreDictionary(ingot, ItemReference.INGOT_NAME, "Copper", 0);
		registerOreDictionary(ingot, ItemReference.INGOT_NAME, "Tin", 1);
		registerOreDictionary(ingot, ItemReference.INGOT_NAME, "Silver", 2);
		registerOreDictionary(ingot, ItemReference.INGOT_NAME, "Lead", 3);
		registerOreDictionary(ingot, ItemReference.INGOT_NAME, "Bronze", 4);
		registerOreDictionary(ingot, ItemReference.INGOT_NAME, "Steel", 5);
		registerOreDictionary(magicalStone, ItemReference.MAGICALSTONE_NAME, "_full", 0);
		registerOreDictionary(magicalStone, ItemReference.MAGICALSTONE_NAME, "_empty", 16);
		registerOreDictionary(mysteriousHammer, ItemReference.MYSTERIOUSHAMMER_NAME, null, 1);
		registerOreDictionary(powder, ItemReference.POWDER_NAME, "Iron", 0);
		registerOreDictionary(powder, ItemReference.POWDER_NAME, "Gold", 1);
		registerOreDictionary(powder, ItemReference.POWDER_NAME, "Copper", 2);
		registerOreDictionary(powder, ItemReference.POWDER_NAME, "Tin", 3);
		registerOreDictionary(powder, ItemReference.POWDER_NAME, "Silver", 4);
		registerOreDictionary(powder, ItemReference.POWDER_NAME, "Lead", 5);
		registerOreDictionary(powder, ItemReference.POWDER_NAME, "Bronze", 6);
		registerOreDictionary(powder, "dust", "Iron", 0);
		registerOreDictionary(powder, "dust", "Gold", 1);
		registerOreDictionary(powder, "dust", "Copper", 2);
		registerOreDictionary(powder, "dust", "Tin", 3);
		registerOreDictionary(powder, "dust", "Silver", 4);
		registerOreDictionary(powder, "dust", "Lead", 5);
		registerOreDictionary(powder, "dust", "Bronze", 6);
		registerOreDictionary(purePowder, ItemReference.PUREPOWDER_NAME, "Iron", 0);
		registerOreDictionary(purePowder, ItemReference.PUREPOWDER_NAME, "Gold", 1);
		registerOreDictionary(purePowder, ItemReference.PUREPOWDER_NAME, "Copper", 2);
		registerOreDictionary(purePowder, ItemReference.PUREPOWDER_NAME, "Tin", 3);
		registerOreDictionary(purePowder, ItemReference.PUREPOWDER_NAME, "Silver", 4);
		registerOreDictionary(purePowder, ItemReference.PUREPOWDER_NAME, "Lead", 5);
		registerOreDictionary(rawPowder, ItemReference.RAWPOWDER_NAME, "Iron", 0);
		registerOreDictionary(rawPowder, ItemReference.RAWPOWDER_NAME, "Gold", 1);
		registerOreDictionary(rawPowder, ItemReference.RAWPOWDER_NAME, "Copper", 2);
		registerOreDictionary(rawPowder, ItemReference.RAWPOWDER_NAME, "Tin", 3);
		registerOreDictionary(rawPowder, ItemReference.RAWPOWDER_NAME, "Silver", 4);
		registerOreDictionary(rawPowder, ItemReference.RAWPOWDER_NAME, "Lead", 5);
		registerOreDictionary(vibrantResource, "bits", "Vibrant", 0);
	}

	public static void registerRecipes() {
		registerItemRecipe(true, bagEmpty, 0, 1, " A ", "BCB", " B ", 'A', "string", 'B', "leather", 'C', "slimeball");
		registerItemRecipe(false, bagEmpty, 1, 1, ItemReference.MAGICALSTONE_NAME + "_full", "bag_empty");
		registerItemRecipe(false, powder, 6, 4, ItemReference.POWDER_NAME + "Copper", ItemReference.POWDER_NAME + "Copper", ItemReference.POWDER_NAME + "Copper", ItemReference.POWDER_NAME + "Tin");
		registerItemRecipe(false, powder, 6, 4, "dust" + "Copper", ItemReference.POWDER_NAME, "Copper", "dust" + "Copper", "dust" + "Tin");
	}

	public static void registerSmeltingRecipes() {
		addOreSmeltingToItem(BlockReference.ORE_NAME + "Copper", ingot, 0, 1, 0.0F);
		addOreSmeltingToItem(BlockReference.ORE_NAME + "Tin", ingot, 1, 1, 0.0F);
		addOreSmeltingToItem(BlockReference.ORE_NAME + "Silver", ingot, 2, 1, 0.0F);
		addOreSmeltingToItem(BlockReference.ORE_NAME + "Lead", ingot, 3, 1, 0.0F);
		addOreSmeltingToItem(ItemReference.POWDER_NAME + "Iron", Items.IRON_INGOT, 0, 1, 0.0F);
		addOreSmeltingToItem(ItemReference.POWDER_NAME + "Gold", Items.GOLD_INGOT, 0, 1, 0.0F);
		addOreSmeltingToItem(ItemReference.POWDER_NAME + "Copper", ingot, 0, 1, 0.0F);
		addOreSmeltingToItem(ItemReference.POWDER_NAME + "Tin", ingot, 1, 1, 0.0F);
		addOreSmeltingToItem(ItemReference.POWDER_NAME + "Silver", ingot, 2, 1, 0.0F);
		addOreSmeltingToItem(ItemReference.POWDER_NAME + "Lead", ingot, 3, 1, 0.0F);
		addOreSmeltingToItem(ItemReference.POWDER_NAME + "Bronze", ingot, 4, 1, 0.0F);
		addOreSmeltingToItem(ItemReference.PUREPOWDER_NAME + "Iron", Items.IRON_INGOT, 0, 1, 0.0F);
		addOreSmeltingToItem(ItemReference.PUREPOWDER_NAME + "Gold", Items.GOLD_INGOT, 0, 1, 0.0F);
		addOreSmeltingToItem(ItemReference.PUREPOWDER_NAME + "Copper", ingot, 0, 1, 0.0F);
		addOreSmeltingToItem(ItemReference.PUREPOWDER_NAME + "Tin", ingot, 1, 1, 0.0F);
		addOreSmeltingToItem(ItemReference.PUREPOWDER_NAME + "Silver", ingot, 2, 1, 0.0F);
		addOreSmeltingToItem(ItemReference.PUREPOWDER_NAME + "Lead", ingot, 3, 1, 0.0F);
		addOreSmeltingToItem(ItemReference.RAWPOWDER_NAME + "Iron", Items.IRON_INGOT, 0, 1, 0.0F);
		addOreSmeltingToItem(ItemReference.RAWPOWDER_NAME + "Gold", Items.GOLD_INGOT, 0, 1, 0.0F);
		addOreSmeltingToItem(ItemReference.RAWPOWDER_NAME + "Copper", ingot, 0, 1, 0.0F);
		addOreSmeltingToItem(ItemReference.RAWPOWDER_NAME + "Tin", ingot, 1, 1, 0.0F);
		addOreSmeltingToItem(ItemReference.RAWPOWDER_NAME + "Silver", ingot, 2, 1, 0.0F);
		addOreSmeltingToItem(ItemReference.RAWPOWDER_NAME + "Lead", ingot, 3, 1, 0.0F);
	}
	
	public static void registerBlockMiningLevel() {
		setItemMiningLevel(Items.STONE_PICKAXE, "pickaxe", 1);
		setItemMiningLevel(Items.GOLDEN_PICKAXE, "pickaxe", 1);
		setItemMiningLevel(pickaxeBronze, "pickaxe", 2);
		setItemMiningLevel(Items.IRON_PICKAXE, "pickaxe", 2);
		setItemMiningLevel(Items.DIAMOND_PICKAXE, "pickaxe", 4);
		setItemMiningLevel(pickaxeSteel, "pickaxe", 3);
	}

}
