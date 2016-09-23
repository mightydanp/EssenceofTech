package com.mightydanp.eot.common.block;

import java.util.Locale;
import java.util.Random;

import com.mightydanp.eot.api.common.block.IMetaBlock;
import com.mightydanp.eot.common.EoT;
import com.mightydanp.eot.common.item.ModItems;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.IStringSerializable;

public class BlockOreGem extends IMetaBlock {

	public static final PropertyEnum TYPE = PropertyEnum.create("ore_gem", OreGemType.class);

	public BlockOreGem(String unlocalizedName) {
		super(Material.ROCK, TYPE, OreGemType.class, unlocalizedName);
		this.setCreativeTab(EoT.tabEoT);
		this.setUnlocalizedName(unlocalizedName);
		this.setHardness(2.2f);
		this.setHarvestLevel("pickaxe", 3, this.getStateFromMeta(0));
		this.setHarvestLevel("pickaxe", 3, this.getStateFromMeta(1));
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ModItems.gem;
	}

	public enum OreGemType implements IStringSerializable,IMetaBlock.IEnumMeta {
		RUBY, SAPPHIRE;

		public final int meta;

		OreGemType() {
			meta = ordinal();
		}

		@Override
		public String getName() {
			return this.toString().toLowerCase(Locale.US);
		}

		@Override
		public int getMeta() {
			return meta;
		}

	}
}