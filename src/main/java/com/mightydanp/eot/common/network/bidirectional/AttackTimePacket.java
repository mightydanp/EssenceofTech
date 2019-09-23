package com.mightydanp.eot.common.network.bidirectional;

import java.io.IOException;

import com.mightydanp.eot.common.network.AbstractMessage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import cpw.mods.fml.relauncher.Side;

public class AttackTimePacket extends AbstractMessage<AttackTimePacket> {
	private int attackTime;

	public AttackTimePacket() {
	}

	public AttackTimePacket(int attackTime) {
		this.attackTime = attackTime;
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		this.attackTime = buffer.readInt();
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeInt(attackTime);
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		player.attackTime = this.attackTime;
	}
}
