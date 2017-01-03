package com.mightydanp.eot.common.item;

import com.mightydanp.eot.api.common.item.IMetaItemBlock;
import com.mightydanp.eot.common.block.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemTwigs extends IMetaItemBlock {

	public ItemTwigs(Block block, String[] blockStateName) {
		super(block, blockStateName);

	}

	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		net.minecraft.block.state.IBlockState state = worldIn.getBlockState(pos);
		if (facing == EnumFacing.UP && playerIn.canPlayerEdit(pos.offset(facing), facing, stack) && state.getBlock() != ModBlocks.twigs && worldIn.isAirBlock(pos.up())) {
			worldIn.setBlockState(pos.up(), ModBlocks.twigs.getDefaultState());
			if (!playerIn.capabilities.isCreativeMode) {
				stack.shrink(1);
			}
			return EnumActionResult.SUCCESS;
		} else {
			return EnumActionResult.FAIL;
		}
	}
}
