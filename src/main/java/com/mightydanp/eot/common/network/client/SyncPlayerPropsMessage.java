package com.mightydanp.eot.common.network.client;

import io.netty.buffer.ByteBuf;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;

import com.mightydanp.eot.common.Eot;
import com.mightydanp.eot.common.entities.player.EotExtendedPlayer;
import com.mightydanp.eot.common.network.AbstractMessage.AbstractClientMessage;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import cpw.mods.fml.relauncher.Side;

public class SyncPlayerPropsMessage extends AbstractClientMessage<SyncPlayerPropsMessage> {
	private NBTTagCompound data;

	public SyncPlayerPropsMessage() {}

	public SyncPlayerPropsMessage(EntityPlayer player) {
		data = new NBTTagCompound();
		EotExtendedPlayer.get(player).saveNBTData(data);
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		data = buffer.readNBTTagCompoundFromBuffer();
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeNBTTagCompoundToBuffer(data);
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		EotExtendedPlayer.get(player).loadNBTData(data);
	}
}
