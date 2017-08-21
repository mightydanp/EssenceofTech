package com.mightydanp.eot.common.item;

import com.mightydanp.eot.api.common.item.ItemBlockCore;
import com.mightydanp.eot.common.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

/**
 * Created by MightyDanp on 8/12/2017.
 */
public class ItemRocks extends ItemBlockCore implements IPlantable{
    public ItemRocks(Block block, String blockStateName) {
        super(block, blockStateName);
    }

    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        net.minecraft.block.state.IBlockState state = worldIn.getBlockState(pos);
        if (facing == EnumFacing.UP && playerIn.canPlayerEdit(pos.offset(facing), facing, stack) && state.getBlock() != ModBlocks.rocks && (worldIn.isAirBlock(pos.up()))) {
            if (state.getBlock().canSustainPlant(state, worldIn, pos, EnumFacing.UP, this)) {
                worldIn.setBlockState(pos.up(), ModBlocks.rocks.getDefaultState());
                if (!playerIn.capabilities.isCreativeMode) {
                    --stack.stackSize;
                }
                return EnumActionResult.SUCCESS;
            }
            return EnumActionResult.FAIL;
        }else {
            return EnumActionResult.FAIL;
        }
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return net.minecraftforge.common.EnumPlantType.Plains;
    }

    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
        return this.block.getDefaultState();
    }
}
