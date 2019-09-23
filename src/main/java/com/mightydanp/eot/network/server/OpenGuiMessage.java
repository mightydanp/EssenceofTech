package com.mightydanp.eot.network.server;

import com.mightydanp.eot.Eot;
import com.mightydanp.eot.network.AbstractMessage.AbstractServerMessage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import cpw.mods.fml.relauncher.Side;

public class OpenGuiMessage extends AbstractServerMessage<OpenGuiMessage> {
	private int id;

	public OpenGuiMessage() {}

	public OpenGuiMessage(int id) {
		this.id = id;
	}

	@Override
	protected void read(PacketBuffer buffer) {
		id = buffer.readInt();
	}

	@Override
	protected void write(PacketBuffer buffer) {
		buffer.writeInt(id);
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		player.openGui(Eot.instance, this.id, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
	}
}
