package com.mightydanp.eot.core.entities.player;

import java.lang.ref.WeakReference;

import com.mightydanp.eot.inventory.InventoryEotInventory;
import com.mightydanp.eot.lib.References;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class EotExtendedPlayer implements IExtendedEntityProperties
{
	public final static String EXT_PROP_NAME = "EotExtendedPlayer";
	
	public WeakReference<EntityPlayer> player;
	
	public InventoryEotInventory inventoryEot;

	@Override
    public void init (Entity entity, World world){
		this.player = new WeakReference<EntityPlayer>((EntityPlayer)entity);
		this.inventoryEot.init((EntityPlayer)entity);
    }
	
	public EotExtendedPlayer(){}
	
	public EotExtendedPlayer(EntityPlayer player) {
		this.player = new WeakReference<EntityPlayer>(player);
		
		this.inventoryEot = new InventoryEotInventory();
		this.inventoryEot.init(player);
	}

	/**
	 * Used to register these extended properties for the player during EntityConstructing event
	 */
	public static final void register(EntityPlayer player) {
		player.registerExtendedProperties(EotExtendedPlayer.EXT_PROP_NAME, new EotExtendedPlayer(player));
	}

	/**
	 * Returns ExtendedPlayer properties for player
	 */
	public static final EotExtendedPlayer get(EntityPlayer player) {
		return (EotExtendedPlayer) player.getExtendedProperties(EXT_PROP_NAME);
	}

	/**
	 * Copies additional player data from the given ExtendedPlayer instance
	 * Avoids NBT disk I/O overhead when cloning a player after respawn
	 */
	public void copy(EotExtendedPlayer props) {
		inventoryEot.copy(props.inventoryEot);
	}
	
	public void copyFrom (EotExtendedPlayer props, boolean copyCalc){
		inventoryEot.copy(props.inventoryEot);
    }

	@Override
	public final void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();
		compound.setTag(EXT_PROP_NAME, properties);
		this.inventoryEot.writeToNBT(properties);
	}

	@Override
	public final void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		this.inventoryEot.readFromNBT(properties);
	}
	
	public IInventory getEotInventory (EntityPlayer player){
        return this.inventoryEot;
    }
}