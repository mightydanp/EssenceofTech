package com.mightydanp.eot.common.block;

import java.util.List;
import java.util.Locale;

import javax.annotation.Nullable;

import com.mightydanp.eot.api.common.block.IMetaBlock;
import com.mightydanp.eot.common.EoT;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCauldronLid extends IMetaBlock{
	
	private static final AxisAlignedBB	BOUNDING_BOX	= new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.0625, 1.0);

	public static final PropertyEnum		TYPE					= PropertyEnum.create("cauldron_lid", CauldronLidType.class);

	public BlockCauldronLid(String unlocalizedName) {
		super(Material.IRON, TYPE, CauldronLidType.class, unlocalizedName);
		this.setCreativeTab(EoT.tabEoT);
		this.setUnlocalizedName(unlocalizedName);
		this.setHardness(0.5F);
		this.setSoundType(SoundType.METAL);
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn) {
		super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BOUNDING_BOX);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return BOUNDING_BOX;
	}
	public enum CauldronLidType implements IStringSerializable,IMetaBlock.IEnumMeta {
		CAULDRON_LID;

		public final int meta;

		CauldronLidType() {
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