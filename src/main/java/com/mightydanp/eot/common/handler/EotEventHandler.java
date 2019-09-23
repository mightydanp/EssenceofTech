package com.mightydanp.eot.common.handler;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.mightydanp.eot.common.Eot;
import com.mightydanp.eot.common.block.BlockEssenceOre;
import com.mightydanp.eot.common.entities.player.EotExtendedPlayer;
import com.mightydanp.eot.common.item.ItemMysteriousHammer;
import com.mightydanp.eot.common.network.PacketDispatcher;
import com.mightydanp.eot.common.network.client.SyncPlayerPropsMessage;

import net.minecraft.block.BlockAir;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldSettings.GameType;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EotEventHandler {

	private ConcurrentHashMap<UUID, EotExtendedPlayer> playerStats = new ConcurrentHashMap<UUID, EotExtendedPlayer>();

	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) {
		if (event.entity instanceof EntityPlayer) {
			if (EotExtendedPlayer.get((EntityPlayer) event.entity) == null)
				EotExtendedPlayer.register((EntityPlayer) event.entity);
		}
	}

	
	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event) {
		if (event.entity instanceof EntityPlayer && !event.entity.worldObj.isRemote) {
			PacketDispatcher.sendTo(new SyncPlayerPropsMessage((EntityPlayer) event.entity), (EntityPlayerMP) event.entity);
		}
	}

	@SubscribeEvent
	public void onClonePlayer(PlayerEvent.Clone event) {
		EotExtendedPlayer.get(event.entityPlayer).copy(EotExtendedPlayer.get(event.original));
	}
	
	@SubscribeEvent
    public void playerDrops (PlayerDropsEvent event){
		if (event.entityLiving instanceof EntityPlayerMP)
        {
            EotExtendedPlayer stats = EotExtendedPlayer.get((EntityPlayerMP) event.entityLiving);
            if (!event.entityLiving.worldObj.getGameRules().getGameRuleBooleanValue("keepInventory"))
            {
            	event.entityLiving.captureDrops = true;
                for (int i = stats.inventoryEot.getSizeInventory() - 1; i >= 0; i--)
                {
                    ItemStack stack = stats.inventoryEot.getStackInSlot(i);

                    if (stack != null)
                    {
                        ((EntityPlayerMP) event.entityLiving).func_146097_a(stack, true, false);
                        stats.inventoryEot.setInventorySlotContents(i, null);
                    }
                }
                event.entityLiving.captureDrops = false;
            }
        }
    }
	/*
	@SubscribeEvent
	public void onBlockBroken(BlockEvent.BreakEvent event){
		EntityPlayerMP playerMP = (EntityPlayerMP)event.getPlayer();
	    if(event.block instanceof BlockEssenceOre && !(event.getPlayer().inventory.getCurrentItem().getItem() instanceof ItemMysteriousHammer)){
	        event.setCanceled(true);
	    }if(event.block instanceof BlockEssenceOre && (playerMP.theItemInWorldManager.getGameType() == GameType.CREATIVE)){
	        event.setCanceled(true);
	    }
	}
	*/
}