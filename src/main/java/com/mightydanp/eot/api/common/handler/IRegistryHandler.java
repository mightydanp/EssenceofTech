package com.mightydanp.eot.api.common.handler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import com.mightydanp.eot.api.common.item.IMetaItemBlock;
import com.mightydanp.eot.common.EoT;
import com.mightydanp.eot.common.lib.Reference;
import com.mightydanp.eot.common.logger.EoTLogger;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

/**
 * @auther MightyDanp date class created: Jul 6, 2016
 */
public abstract class IRegistryHandler {

	public static final Set<Block> BLOCKS = new HashSet<>();

	public static Item registerItem(Item item, String prefixName) {
		GameRegistry.register(item, new ResourceLocation(Reference.MODID, prefixName));
		return item;
	}

	public static void renderItem(Item item, String prefixName, @Nullable String suffixName, @Nullable int meta) {
		if (suffixName != null ) {
			ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Reference.MODID + ":" + prefixName + "_" + suffixName));
		}else{
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Reference.MODID + ":" + prefixName, "inventory"));
		}
	}
	
	public static void renderMetaItem(Item item, String prefixName, String[] suffixName, int meta) {
		for (int i = 0; i < meta; i++) {
		     ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(Reference.MODID + ":" + prefixName + "_" + suffixName[i]));
	    }
	}
	
	
	
	public static void renderSpecialItem(Item item, String prefixName) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Reference.MODID + ":" + prefixName));
	}

	public static Block registerBlock(Block block, String prefixName, @Nullable String[] suffixName, @Nullable ItemBlock isCustomItemBlock) {
		if (isCustomItemBlock == null) {
			GameRegistry.register(block, new ResourceLocation(Reference.MODID, prefixName));
			ItemBlock itemBlock = new IMetaItemBlock(block, suffixName);
			GameRegistry.register(itemBlock.setRegistryName(block.getRegistryName()));
		} else {
			GameRegistry.register(block, new ResourceLocation(Reference.MODID, prefixName));
			registerItem(isCustomItemBlock, prefixName);
			EoTLogger.logInfoMessage(Reference.MODID + ":" + prefixName + "is loading in here");
		}
		return block;
	}

	public static void registerCustomItemBlockAndBlock(Block block, ItemBlock itemBlock, String prefixName, @Nullable String[] suffixName) {
		if (block != null && itemBlock != null && prefixName != null && !prefixName.isEmpty()) {
			GameRegistry.register(block.setRegistryName(prefixName));
			if (itemBlock.getRegistryName() == null || !itemBlock.getRegistryName().getResourcePath().isEmpty()) {
				registerItem(itemBlock, prefixName);
			}
		}
	}

	public static void renderBlock(Block block, String prefixName, @Nullable String suffixName, int meta) {
		if (suffixName != null) {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(Reference.MODID + ":" + prefixName + "_" + suffixName));
		} else {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(Reference.MODID + ":" + prefixName, "inventory"));
		}
	}

	public static void registerOreDictionary(Object object, String prefixName, @Nullable String suffixName, int meta) {
		if (suffixName != null) {
			if (object instanceof Item) {
				OreDictionary.registerOre(prefixName + suffixName, new ItemStack((Item) object, 1, meta));
			}
			if (object instanceof Block) {
				OreDictionary.registerOre(prefixName + suffixName, new ItemStack((Block) object, 1, meta));
			}
			if (object instanceof ItemStack) {
				OreDictionary.registerOre(prefixName + suffixName, (ItemStack) object);
			}
		}
		if (suffixName == null) {
			if (object instanceof Item) {
				OreDictionary.registerOre(prefixName, (Item) object);
			}
			if (object instanceof Block) {
				OreDictionary.registerOre(prefixName, (Block) object);
			}
			if (object instanceof ItemStack) {
				OreDictionary.registerOre(prefixName, (ItemStack) object);
			}
		}
	}

	public static void registerBlockRecipe(Boolean isShaped, Block blockOutput, int meta, int amountOutput, Object... params) {
		if (isShaped == true) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockOutput, amountOutput, meta), params));
		}
		if (isShaped == false) {
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(blockOutput, amountOutput, meta), params));
		}
	}

	public static void registerItemRecipe(Boolean isShaped, Item itemOutput, int meta, int amountOutput, Object... params) {
		if (isShaped == true) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(itemOutput, amountOutput, meta), params));
		}
		if (isShaped == false) {
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(itemOutput, amountOutput, meta), params));
		}
	}

	public static void removeVanillaCrafting(ItemStack resultItem) {
		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
		Iterator<IRecipe> Leash = recipes.iterator();
		while (Leash.hasNext()) {
			ItemStack is = Leash.next().getRecipeOutput();
			if (is != null && is == resultItem) {
				Leash.remove();
			}
		}
	}

	public static void addBlockSmeltingToItem(Block blockInput, Item itemOutput, int amountOutput, int meta, float expGiven) {
		GameRegistry.addSmelting(blockInput, new ItemStack(itemOutput, amountOutput, meta), expGiven);
	}

	public static void addBlockSmeltingToBlock(Block blockInput, Block blockOutput, int amountOutput, int meta, float expGiven) {
		GameRegistry.addSmelting(blockInput, new ItemStack(blockOutput, amountOutput, meta), expGiven);
	}

	public static void addItemSmeltingToItem(Item itemInput, Item itemOutput, int amountOutput, int meta, float expGiven) {
		GameRegistry.addSmelting(itemInput, new ItemStack(itemOutput, amountOutput, meta), expGiven);
	}

	public static void addItemSmeltingToBlock(Item itemInput, Block blockOutput, int amountOutput, int meta, float expGiven) {
		GameRegistry.addSmelting(itemInput, new ItemStack(blockOutput, amountOutput, meta), expGiven);
	}

	public static void addBlockSmeltingToOre(Block blockInput, int meta, String oreDictionaryOutput, int recoveredOutput, float xpGiven) {
		for (ItemStack ore : OreDictionary.getOres(oreDictionaryOutput)) {
			GameRegistry.addSmelting(new ItemStack(blockInput, 1, meta), ore, xpGiven);
		}
	}

	public static void addItemSmeltingToOre(Item itemInput, int meta, String oreDictionaryOutput, int recoveredOutput, float xpGiven) {
		for (ItemStack ore : OreDictionary.getOres(oreDictionaryOutput)) {
			GameRegistry.addSmelting(new ItemStack(itemInput, 1, meta), ore, xpGiven);
		}
	}

	public static void addOreSmeltingToBlock(String oreDictionaryInput, Block blockInput, int meta, int recoveredOutput, float xpGiven) {

	}

	public static void addOreSmeltingToItem(String oreDictionaryInput, Item itemInput, int meta, int recoveredOutput, float xpGiven) {
		for (ItemStack ore : OreDictionary.getOres(oreDictionaryInput)) {
			GameRegistry.addSmelting(ore, new ItemStack(itemInput, recoveredOutput, meta), xpGiven);
		}
	}

	public static void removeItemStackResultFromFurnaceRecipes(ItemStack resultItem) {
		Map<ItemStack, ItemStack> recipes = FurnaceRecipes.instance().getSmeltingList();
		for (Iterator<Map.Entry<ItemStack, ItemStack>> entries = recipes.entrySet().iterator(); entries.hasNext();) {
			Map.Entry<ItemStack, ItemStack> entry = entries.next();
			ItemStack result = entry.getValue();
			if (ItemStack.areItemStacksEqual(result, resultItem)) {
				entries.remove();
			}
		}
	}

	public static void removeItemStackKeyFromFurnaceRecipes(ItemStack inputItem) {
		Set<ItemStack> recipes = FurnaceRecipes.instance().getSmeltingList().keySet();
		for (Iterator<ItemStack> entries = recipes.iterator(); entries.hasNext();) {
			ItemStack result = entries.next();
			if (ItemStack.areItemStacksEqual(result, inputItem)) {
				entries.remove();
			}
		}
	}

	public static int	id	= 0;
	public static int	index;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void registerModProjectile(Class entityClass, String name) {
		//EntityRegistry.registerModEntity(entityClass, name, ++id, EoT.instance, 64, 10, true);
	}

	public static void registerTileEntity(Class<? extends TileEntity> tileEntityClass) {
		GameRegistry.registerTileEntity(tileEntityClass, Reference.MODID + ":" + tileEntityClass.getName().substring(11));
	}

	public static void registerEntity(IRenderFactory<? super Entity> renderEntity, Class<Entity> entityClass, int id, Object modInstance, int trackingRange, int updateFreq, int hexColorPrimary, int hexColorSecondary) {
		//EntityRegistry.registerModEntity(entityClass, Reference.MODID + ":" + entityClass.getName().substring(6), id, modInstance, trackingRange, updateFreq, true, hexColorPrimary, hexColorSecondary);
		RenderingRegistry.registerEntityRenderingHandler(entityClass, renderEntity);
	}

	public static void registerKeyBinding(KeyBinding key) {
		ClientRegistry.registerKeyBinding(key);
	}
	
	public static void setBlockMiningLevel(Block block,String toolUsed, int miningLevel) {
		block.setHarvestLevel(toolUsed ,miningLevel);
	}
	
	public static void setItemMiningLevel(Item item,String toolUsed, int miningLevel) {
		item.setHarvestLevel(toolUsed ,miningLevel);
	}
}
