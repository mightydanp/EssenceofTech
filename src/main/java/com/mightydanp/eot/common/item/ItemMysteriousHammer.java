package com.mightydanp.eot.common.item;

import com.mightydanp.eot.api.common.item.IItemPickaxe;
import com.mightydanp.eot.common.EoT;
import com.mightydanp.eot.common.lib.ItemReference;
import net.minecraftforge.common.util.EnumHelper;

/**
 * @auther MightyDanp
 * date class created: Jul 22, 2016 
 */

class ItemMysteriousHammer extends IItemPickaxe {

    public static ToolMaterial HammerMysteriousMaterial = EnumHelper.addToolMaterial(ItemReference.MAGICALSTONE_NAME, 0, 64, 2.0F, 0.5F, 5);
    
    public ItemMysteriousHammer(String unlocalizedName) {
        super(HammerMysteriousMaterial, unlocalizedName);
        this.setCreativeTab(EoT.tabEoT);
        this.setMaxStackSize(1);
    }

}
