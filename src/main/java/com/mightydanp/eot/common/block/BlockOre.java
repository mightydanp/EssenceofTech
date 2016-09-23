package com.mightydanp.eot.common.block;

import java.util.Locale;

import com.mightydanp.eot.api.common.block.IMetaBlock;
import com.mightydanp.eot.common.EoT;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.IStringSerializable;

/**
 * @auther MightyDanp date class created: Jul 7, 2016
 */
public class BlockOre extends IMetaBlock {

	public static final PropertyEnum TYPE = PropertyEnum.create("ore", OreType.class);

	public BlockOre(String unlocalizedName) {
		super(Material.ROCK, TYPE, OreType.class, unlocalizedName);
		this.setCreativeTab(EoT.tabEoT);
		this.setUnlocalizedName(unlocalizedName);
		this.setHardness(2.2f);
		this.setHarvestLevel("pickaxe", 1, this.getStateFromMeta(0));
		this.setHarvestLevel("pickaxe", 1, this.getStateFromMeta(1));
		this.setHarvestLevel("pickaxe", 2, this.getStateFromMeta(2));
		this.setHarvestLevel("pickaxe", 2, this.getStateFromMeta(3));
	}

	public enum OreType implements IStringSerializable,IMetaBlock.IEnumMeta {
		COPPER, TIN, SILVER, LEAD;

		public final int meta;

		OreType() {
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
