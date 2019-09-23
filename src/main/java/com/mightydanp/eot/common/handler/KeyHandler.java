package com.mightydanp.eot.common.handler;

import org.lwjgl.input.Keyboard;

import com.mightydanp.eot.common.CommonProxy;
import com.mightydanp.eot.common.network.PacketDispatcher;
import com.mightydanp.eot.common.network.server.OpenGuiMessage;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.StatCollector;

public class KeyHandler
{
	/** Storing an instance of Minecraft in a local variable saves having to get it every time */
	private final Minecraft mc;
	
	/** Key index for easy handling */
	public static final int CUSTOM_INV = 0;

	/** Key descriptions; use a language file to localize the description later */
	private static final String[] desc = {"key.tut_inventory.desc"};

	/** Default key values */
	private static final int[] keyValues = {Keyboard.KEY_P};

	/** Make this public or provide a getter if you'll need access to the key bindings from elsewhere */
	public static final KeyBinding[] keys = new KeyBinding[desc.length];

	public KeyHandler(Minecraft mc) {
		this.mc = mc;
		for (int i = 0; i < desc.length; ++i) {
			keys[i] = new KeyBinding(desc[i], keyValues[i], StatCollector.translateToLocal("key.tutorial.label"));
			ClientRegistry.registerKeyBinding(keys[i]);
		}
	}
	
	@SubscribeEvent
	public void onKeyInput(KeyInputEvent event) {
		// checking inGameHasFocus prevents your keys from firing when the player is typing a chat message
		// NOTE that the KeyInputEvent will NOT be posted when a gui screen such as the inventory is open
		// so we cannot close an inventory screen from here; that should be done in the GUI itself
		if (mc.inGameHasFocus) {
			if (keys[CUSTOM_INV].isPressed()) {
				PacketDispatcher.sendToServer(new OpenGuiMessage(CommonProxy.eotInventory));
			}
		}
	}
}