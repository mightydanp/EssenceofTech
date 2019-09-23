package com.mightydanp.eot.item;
import java.util.List;
import java.util.Random;

import com.mightydanp.eot.Eot;
import com.mightydanp.eot.core.config.GeneralConfiguration;
import com.mightydanp.eot.lib.ItemStrings;
import com.mightydanp.eot.lib.References;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class ItemEndermanFlesh extends ItemFood{
	
	private float randomTeleportProbability;
	
	public ItemEndermanFlesh(String unlocalizedName, int healAmount, float saturationModifier, boolean wolvesFavorite){
		super(healAmount, saturationModifier, wolvesFavorite);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(References.RESOURCESPREFIX + unlocalizedName);
		this.setCreativeTab(Eot.eotTab);
		this.setRandomTeleportProbability(0.1F);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool){
		dataList.add("This piece seem to be a piece of that Enderman.");
		dataList.add("It seems to be very unstable, but is it wise to eat it?");
    }

	@Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
    	super.onFoodEaten(stack, world, player);
    	if(GeneralConfiguration.shouldEndermanFleshTeleport){
    		if (!world.isRemote) {
            	if(world.rand.nextFloat() <this.randomTeleportProbability){
            		double teleportPositionX = player.posX + (this.itemRand.nextDouble() - 0.5D) * 64.0D;
                    double teleportPositionY = player.posY + (this.itemRand.nextInt(64) + 0);
                    double teleportPositionZ = player.posZ + (this.itemRand.nextDouble() - 0.5D) * 64.0D;
                    player.setPositionAndUpdate(teleportPositionX, teleportPositionY, teleportPositionZ);
            	}
            }
    	}
    }
	
    public ItemFood setRandomTeleportProbability(float chanceToTeleport){
        this.randomTeleportProbability = chanceToTeleport;
        return this;
    }

    /*
    // Otherwise use this version
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer playerIn) {
        if (!playerIn.capabilities.isCreativeMode) {
            --stack.stackSize;
        }
 
        if (!worldIn.isRemote) {
            double teleportPositionX = playerIn.posX + (this.itemRand.nextDouble() - 0.5) * 64.0;
            double teleportPositionY = playerIn.posY + (double)(this.itemRand.nextInt(64) - 32);
            double teleportPositionZ = playerIn.posZ + (this.itemRand.nextDouble() - 0.5) * 64.0;
            playerIn.setPositionAndUpdate(teleportPositionX, teleportPositionY, teleportPositionZ);
        }
    return stack;
    */
}
