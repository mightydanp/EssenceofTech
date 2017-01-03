package com.mightydanp.eot.api.client;

import javax.annotation.Nonnull;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @auther MightyDanp
 * date class created: Jul 6, 2016 
 */

public class ICreativeTab extends CreativeTabs {

  private ItemStack icon;

  public ICreativeTab(String label, ItemStack backupIcon) {
    super(label);

    this.icon = backupIcon;
  }

  public void setDisplayIcon(ItemStack displayIcon) {
    if(displayIcon != null && displayIcon.getItem() != null) {
      this.icon = displayIcon;
    }
  }

  @Nonnull
  @SideOnly(Side.CLIENT)
  @Override
  public ItemStack getIconItemStack() {
    return icon;
  }

  @SideOnly(Side.CLIENT)
  public int getIconItemDamage() {
    return icon.getItemDamage();
  }

  @Nonnull
  @SideOnly(Side.CLIENT)
  @Override
  public ItemStack getTabIconItem() {
    return new ItemStack(icon.getItem());
  }
}