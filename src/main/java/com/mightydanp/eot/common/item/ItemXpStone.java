package com.mightydanp.eot.common.item;

import java.util.List;

import javax.annotation.Nullable;

import com.mightydanp.eot.api.common.item.IItem;
import com.mightydanp.eot.common.EoT;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemXpStone extends IItem {

	public ItemXpStone(String unlocalizedName) {
		super(unlocalizedName);
		this.setCreativeTab(EoT.tabEoT);
		this.setMaxStackSize(1);
		this.setMaxDamage(10);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		if (itemStack.getItemDamage() == 0) {
			dataList.add("Seems to be full of xp.");
		}
		if (itemStack.getItemDamage() == 1) {
			dataList.add("Has 9 levels left.");
		}
		if (itemStack.getItemDamage() == 2) {
			dataList.add("Has 8 levels left.");
		}
		if (itemStack.getItemDamage() == 3) {
			dataList.add("Has 7 levels left.");
		}
		if (itemStack.getItemDamage() == 4) {
			dataList.add("Has 6 levels left.");
		}
		if (itemStack.getItemDamage() == 5) {
			dataList.add("Has 5 levels left.");
		}
		if (itemStack.getItemDamage() == 6) {
			dataList.add("Has 4 levels left.");
		}
		if (itemStack.getItemDamage() == 7) {
			dataList.add("Has 3 levels left.");
		}
		if (itemStack.getItemDamage() == 8) {
			dataList.add("Has 2 levels left.");
		}
		if (itemStack.getItemDamage() == 9) {
			dataList.add("Has 1 levels left.");
		}
		if (itemStack.getItemDamage() == 10) {
			dataList.add("It's empty");
		}
	}

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn){
    	int experience = playerIn.experienceLevel;
		int experienceSubtract = playerIn.experienceLevel - 1;
		int experienceAdd = playerIn.experienceLevel + 1;

		if (playerIn.getHeldItemMainhand().getItemDamage() != 0 && experience != 0 && !playerIn.isSneaking()) {
			playerIn.experienceLevel = experienceSubtract;
			playerIn.getHeldItemMainhand().damageItem(-1, playerIn);
			return new ActionResult(EnumActionResult.PASS, playerIn.getHeldItemMainhand());
		}
		if (playerIn.getHeldItemMainhand().getItemDamage() != 10 && playerIn.isSneaking()) {
			playerIn.experienceLevel = experienceAdd;
			playerIn.getHeldItemMainhand().damageItem(+1, playerIn);
			return new ActionResult(EnumActionResult.PASS, playerIn.getHeldItemMainhand());
		}
		return new ActionResult(EnumActionResult.FAIL, playerIn.getHeldItemMainhand());
	}

}
