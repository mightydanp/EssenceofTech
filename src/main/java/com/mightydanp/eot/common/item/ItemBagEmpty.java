package com.mightydanp.eot.common.item;

import java.util.List;

import com.mightydanp.eot.api.common.item.IMetaItem;
import com.mightydanp.eot.common.EoT;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;;

public class ItemBagEmpty extends IMetaItem {

	public ItemBagEmpty(String itemPrefixName, String[] itemSuffixName, int meta) {
		super(itemPrefixName, itemSuffixName, meta);
		this.setCreativeTab(EoT.tabEoT);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		if (itemStack.getItemDamage() == 1) {
			dataList.add("I wonder what happens when I smash it.");
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean hasEffect(ItemStack itemStack) {
		if (itemStack.getItemDamage() == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
		if (state.getBlock() == Blocks.STONE && stack.getItemDamage() == 1 && !worldIn.isRemote ) {
			EntityItem entityItemBag = new EntityItem(worldIn, entityLiving.posX, entityLiving.posY, entityLiving.posZ, new ItemStack(ModItems.bagEmpty, 1, 0));
			EntityItem entityItemVibrantBits = new EntityItem(worldIn, entityLiving.posX, entityLiving.posY, entityLiving.posZ, new ItemStack(ModItems.vibrantResource, 1, 0));
			worldIn.spawnEntityInWorld(entityItemVibrantBits);
			--entityLiving.getHeldItemMainhand().stackSize;
			worldIn.spawnEntityInWorld(entityItemBag);return true;
		}
		return true;
	}

}
