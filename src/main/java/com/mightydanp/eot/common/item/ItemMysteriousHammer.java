package com.mightydanp.eot.common.item;

import java.util.List;

import com.mightydanp.eot.common.Eot;
import com.mightydanp.eot.common.lib.ItemReferences;
import com.mightydanp.eot.common.lib.References;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.biome.WorldChunkManager;

public class ItemMysteriousHammer extends ItemCustomPickaxe {
	
	public ItemMysteriousHammer(ToolMaterial toolMaterial , String unlocalizedName){
		super(toolMaterial, unlocalizedName);
		this.setCreativeTab(Eot.eotTab);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(References.RESOURCES_PREFIX + unlocalizedName);
		this.setMaxDamage(24);
		this.setMaxStackSize(1);
	}
	
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool){
		dataList.add("Seems to be some kind of old hammer.");
		dataList.add("It doesnt seem that usefull, maybe there is more that meets the eye.");
    }

	/*
    @Override
    public boolean hasEffect(ItemStack itemStack){
    	if(itemStack.stackTagCompound == null) {
            itemStack.stackTagCompound = new NBTTagCompound();
        }
    	
    	if(itemStack.stackTagCompound.getBoolean("isNight")){
			return true;
    	}
		return false;
    }

    @Override
    public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5){
    	 if (!par2World.isRemote){
    		 par1ItemStack.stackTagCompound = new NBTTagCompound();
    	        if(!par2World.provider.isDaytime()){
    	        	par1ItemStack.stackTagCompound.setBoolean("isNight", true);
    	        }else{
    	        	par1ItemStack.stackTagCompound.setBoolean("isNight", false);
    	        }
    	 }
    }
    */
    
    public ItemStack onItemRightClick(ItemStack itemstack, World par2World, EntityPlayer entityplayer){ 	
        return itemstack;
    }

}
