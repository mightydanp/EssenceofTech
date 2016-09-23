package com.mightydanp.eot.common.block;


import static com.mightydanp.eot.common.config.BlockConfig.dropChanceEssenceStone;

import java.util.Locale;
import java.util.Random;

import com.mightydanp.eot.api.common.block.IMetaBlock;
import com.mightydanp.eot.common.EoT;
import com.mightydanp.eot.common.item.ModItems;
import com.mightydanp.eot.common.logger.EoTLogger;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

/**
 * @auther MightyDanp date class created: Jul 6, 2016
 */
public class BlockEssenceStone extends IMetaBlock {

    private float originalHardness;

    public static final PropertyEnum TYPE = PropertyEnum.create("essence_stone", EssenceStoneType.class);

    public BlockEssenceStone(String unlocalizedName) {
        super(Material.ROCK, TYPE, EssenceStoneType.class, unlocalizedName);
        this.setHardness(0.5F);
        this.setCreativeTab(EoT.tabEoT);
        this.setUnlocalizedName(unlocalizedName);
    }

    @Override
    public Block setHardness(float par1) {
        originalHardness = par1;
        return super.setHardness(par1);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
    
        int randomDrop = rand.nextInt(100);

        if (randomDrop <= dropChanceEssenceStone && randomDrop >= 0) {
            return ModItems.essenceChunk;
        }if(randomDrop >= 100){
        	EoTLogger.logWarningMessage(TextFormatting.BLACK + "The Percent drop from" + TextFormatting.BOLD  + TextFormatting.RED + "EssenceStone" + TextFormatting.BLACK + "is to high please change it to" + TextFormatting.RED + "100 or below 100");
        }else{
        	EoTLogger.logWarningMessage(TextFormatting.BLACK + "Something went wrong trying to get" + TextFormatting.RED + "int random drop chance" + TextFormatting.WHITE + "from" + TextFormatting.BOLD  + TextFormatting.RED + "EssenceStone" + TextFormatting.BLACK + ".");
        }
        return null;
    }
    
    @Override
    public int quantityDroppedWithBonus(int fortune, Random random) {
        if (fortune > 0) {
            int j = random.nextInt(fortune + 2) - 1;

            if (j < 0) {
                return j++;
            }
            return quantityDropped(random) * (j + 1);
        }
        return quantityDropped(random);

    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
        if (player.getHeldItem(EnumHand.MAIN_HAND) != null) {;
            EntityItem entityItem = new EntityItem(worldIn, player.posX, player.posY, player.posZ, new ItemStack(ModItems.magicalStone, 1, 16));
            Random random = worldIn.rand;
            int randomDrop = random.nextInt(99);

            if (player.getHeldItem(EnumHand.MAIN_HAND).getItem() == ModItems.mysteriousHammer) {
                if (randomDrop <= 10) {
                    worldIn.spawnEntityInWorld(entityItem);
                }
            }
        }
    }

    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {

        if (playerIn.getHeldItemMainhand().getItem() != ModItems.mysteriousHammer) {
            this.blockHardness = -1;
        }
        this.blockHardness = originalHardness;
        super.onBlockClicked(worldIn, pos, playerIn);

    }

    public enum EssenceStoneType implements IStringSerializable, IMetaBlock.IEnumMeta {
        MAGIC,
        AIR,
        EARTH,
        FIRE,
        WATER;
        
        public final int meta;

        EssenceStoneType() {
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
