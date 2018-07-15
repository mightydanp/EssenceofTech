package com.mightydanp.eot.api.common.handler;

import com.mightydanp.eot.common.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MightyDanp on 7/13/2018.
 */
public class RegisteryHandler {
    public static List<Block> addBlock = new ArrayList<Block>();
    public static List<Item> addItems = new ArrayList<Item>();

    @SubscribeEvent
    public static Object registerObject(Object object, @Nullable ItemBlock itemBlock){
        if (object instanceof Block){
            if(itemBlock == null){
                if(!addBlock.contains(object))
                    addBlock.add((Block)object);
            }else{
                if(!addBlock.contains(object))
                    addBlock.add((Block)object);
            }
        }
        if (object instanceof Item){
            if(!addItems.contains(object))
                addItems.add((Item)object);

        }
        return null;
    }

}
