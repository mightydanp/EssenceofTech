package com.mightydanp.eot.client;

import com.mightydanp.eot.common.CommonProxy;
import com.mightydanp.eot.common.block.ModBlocks;
import com.mightydanp.eot.common.item.ModItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @auther MightyDanp date class created: Jul 4, 2016
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        ModBlocks.renderBlocks();
        ModItems.renderItems();
    }

    @Override
    public void init(FMLInitializationEvent event) {

    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }

}
