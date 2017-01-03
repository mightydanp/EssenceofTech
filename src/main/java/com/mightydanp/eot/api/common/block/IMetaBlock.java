package com.mightydanp.eot.api.common.block;

import java.util.List;
import javax.annotation.Nonnull;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @auther MightyDanp
 * date class created: Jul 6, 2016 
 */

public class IMetaBlock <E extends Enum<E> & IMetaBlock.IEnumMeta & IStringSerializable> extends Block {

  public final PropertyEnum<E> prop;
  private final E[] values;
  protected static PropertyEnum<?> tmp;

  public IMetaBlock(Material material, PropertyEnum<E> prop, Class<E> clazz, String unlocalizedName) {
    super(preInit(material, prop));
    this.prop = prop;
    values = clazz.getEnumConstants();
  }

  private static Material preInit(Material material, PropertyEnum<?> property) {
    tmp = property;
    return material;
  }

  @SideOnly(Side.CLIENT)
  public void getSubBlocks(@Nonnull Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list) {
    for(E type : values) {
      list.add(new ItemStack(this, 1, type.getMeta()));
    }
  }

  @Nonnull
  @Override
  protected BlockStateContainer createBlockState() {
    if(prop == null) {
      return new BlockStateContainer(this, tmp);
    }
    return new BlockStateContainer(this, prop);
  }

  @Nonnull
  @Override
  public IBlockState getStateFromMeta(int meta) {
    return this.getDefaultState().withProperty(prop, fromMeta(meta));
  }

  @Override
  public int getMetaFromState(IBlockState state) {
    return state.getValue(prop).getMeta();
  }

  @Override
  public int damageDropped(IBlockState state) {
    return getMetaFromState(state);
  }

  protected E fromMeta(int meta) {
    if(meta < 0 || meta >= values.length) {
      meta = 0;
    }

    return values[meta];
  }

  public interface IEnumMeta {

    int getMeta();
  }
}