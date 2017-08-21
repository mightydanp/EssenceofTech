package com.mightydanp.eot.client;

import com.mightydanp.eot.common.CommonProxy;
import com.mightydanp.eot.common.block.ModBlocks;
import com.mightydanp.eot.common.item.ModItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by MightyDanp on 8/8/2017.
 */
public class ClientProxy extends CommonProxy {

    public void preInit() {
        super.preInit();
        ModItems.renderItems();
        ModBlocks.renderBlocks();
    }

    public void init() {
        super.init();
    }

    public void postInit() {
        super.postInit();
    }
}
