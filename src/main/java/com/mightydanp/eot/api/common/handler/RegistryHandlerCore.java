package com.mightydanp.eot.api.common.handler;

import com.mightydanp.eot.api.common.item.ItemBlockCore;
import com.mightydanp.eot.api.common.item.MetaItemBlockCore;
import com.mightydanp.eot.common.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nullable;

/**
 * Created by MightyDanp on 8/10/2017.
 */
public class RegistryHandlerCore {

    public static Object registerObject(Object objectIn, String prefixName, @Nullable ItemBlock itemBlockIn) {
        if (objectIn instanceof Item) {
            GameRegistry.register((Item) objectIn, new ResourceLocation(Reference.MOD_ID, prefixName));
            return (Item) objectIn;
        }

        if (objectIn instanceof Block) {
            if (itemBlockIn == null) {
                ItemBlock itemBlock = new ItemBlockCore((Block) objectIn, prefixName);
                GameRegistry.register((Block) objectIn, new ResourceLocation(Reference.MOD_ID, prefixName));
                GameRegistry.register(itemBlock.setRegistryName(((Block) objectIn).getRegistryName()));
                return (Block) objectIn;
            }else{
                GameRegistry.register((Block) objectIn, new ResourceLocation(Reference.MOD_ID, prefixName));
                GameRegistry.register(itemBlockIn, new ResourceLocation(Reference.MOD_ID, prefixName));
            }
        }
        return objectIn;
    }

    public static Object registerObjectWithMetadata(Object objectIn, String prefixName, @Nullable String[] suffixName) {
        if (objectIn instanceof Item) {
            GameRegistry.register((Item) objectIn, new ResourceLocation(Reference.MOD_ID, prefixName));
            return (Item) objectIn;
        }

        if (objectIn instanceof Block) {
            ItemBlock itemBlock = new MetaItemBlockCore((Block) objectIn, suffixName);
            GameRegistry.register(itemBlock.setRegistryName(((Block) objectIn).getRegistryName()));
            return (Block) objectIn;
        }
        return objectIn;
    }

    public static Object renderObject(Object objectIn, String prefixName, @Nullable String suffixName, @Nullable int meta) {
        if (suffixName != null) {
            if (objectIn instanceof Item) {
                ModelLoader.setCustomModelResourceLocation((Item) objectIn, meta, new ModelResourceLocation(Reference.MOD_ID + ":" + prefixName + "_" + suffixName));
            }
            if (objectIn instanceof Block) {
                ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock((Block) objectIn), meta, new ModelResourceLocation(Reference.MOD_ID + ":" + prefixName + "_" + suffixName));
            }

        } else {
            if (objectIn instanceof Item) {
                ModelLoader.setCustomModelResourceLocation((Item) objectIn, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + prefixName, "inventory"));
            }
            if (objectIn instanceof Block) {
                ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock((Block) objectIn), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + prefixName, "inventory"));
            }
        }
        return objectIn;
    }
}
