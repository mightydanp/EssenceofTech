package com.mightydanp.eot.common.item;

import com.mightydanp.eot.api.common.handler.RegistryHandlerCore;
import com.mightydanp.eot.api.common.item.ItemAxeCore;
import com.mightydanp.eot.api.common.item.ItemCore;
import com.mightydanp.eot.common.EoT;
import com.mightydanp.eot.common.lib.ItemReference;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

/**
 * Created by MightyDanp on 8/10/2017.
 */
public class ModItems extends RegistryHandlerCore {
    public static Item.ToolMaterial salvagedToolMaterial = EnumHelper.addToolMaterial("salvaged", 1, 10, 0.7F, 0.0F, 0);

    public static Item salvaged_axe;
    public static Item rock;

    public static void preInit() {
        registerObject(salvaged_axe = new ItemAxeCore(salvagedToolMaterial, ItemReference.SALVAGED_AXE_NAME, 0, 1).setCreativeTab(EoT.tabEot), ItemReference.SALVAGED_AXE_NAME, null);
        registerObject(rock = new ItemCore(ItemReference.ROCK, EoT.tabEot), ItemReference.ROCK, null);
    }

    public static void renderItems() {
        renderObject(salvaged_axe, ItemReference.SALVAGED_AXE_NAME, null, 0);
        renderObject(rock, ItemReference.ROCK, null, 0);
    }

}
