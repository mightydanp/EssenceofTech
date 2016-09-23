package com.mightydanp.eot.common.item;

import com.mightydanp.eot.api.common.item.IItemFood;
import java.util.List;

import com.mightydanp.eot.common.EoT;
import com.mightydanp.eot.common.config.ItemConfig;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemEndermanFlesh extends IItemFood {

    private float randomTeleportProbability;

    public ItemEndermanFlesh(String unlocalizedName) {
        super(4, 0.1F, false, unlocalizedName);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(EoT.tabEoT);
        this.setRandomTeleportProbability(0.1F);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
        dataList.add("This piece seem to be a piece of that Enderman.");
        dataList.add("It seems to be very unstable, but is it wise to eat it?");
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        super.onFoodEaten(stack, world, player);
        if (ItemConfig.shouldEndermanFleshTeleport) {
            if (!world.isRemote) {
                if (world.rand.nextFloat() < this.randomTeleportProbability) {
                    double teleportPositionX = player.posX + (this.itemRand.nextDouble() - 0.5D) * 64.0D;
                    double teleportPositionY = player.posY + (this.itemRand.nextInt(64) + 0);
                    double teleportPositionZ = player.posZ + (this.itemRand.nextDouble() - 0.5D) * 64.0D;
                    player.setPositionAndUpdate(teleportPositionX, teleportPositionY, teleportPositionZ);
                }
            }
        }
    }

    public ItemFood setRandomTeleportProbability(float chanceToTeleport) {
        this.randomTeleportProbability = chanceToTeleport;
        return this;
    }
}
