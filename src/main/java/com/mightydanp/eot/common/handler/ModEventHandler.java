package com.mightydanp.eot.common.handler;

import com.mightydanp.eot.api.common.handler.RegisteryHandler;
import com.mightydanp.eot.common.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by MightyDanp on 7/15/2018.
 */
public class ModEventHandler {

    @SubscribeEvent
    public void registerBlockEvent(RegistryEvent.Register<Block> event) {
        for(int i = 0; i++ <= RegisteryHandler.addBlock.size(); i++){
            event.getRegistry().register(RegisteryHandler.addBlock.get(i));
        }
    }

    @SubscribeEvent
    public void registerItemEvent(RegistryEvent.Register<Item> event) {
        for(int i = 0; i++ <= RegisteryHandler.addItems.size(); i++){
            event.getRegistry().register(RegisteryHandler.addItems.get(i));
        }
        for(int i = 0; i++ <= RegisteryHandler.addBlock.size(); i++){
            event.getRegistry().register(new ItemBlock(RegisteryHandler.addBlock.get(i)).setRegistryName(Reference.MOD_ID + ":" + RegisteryHandler.addBlock.get(i).getRegistryName()));

        }
    }

    @SubscribeEvent
    public void registerRenders(ModelRegistryEvent event) {
        for(int i = 0; i++ <= RegisteryHandler.addBlock.size(); i++) {
            registerRender(Item.getItemFromBlock(RegisteryHandler.addBlock.get(i)));
        }
    }

    public void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getRegistryName(), "inventory"));
    }
}
