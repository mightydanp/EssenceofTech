package com.mightydanp.eot.common.block;

import com.mightydanp.eot.api.common.block.IMetaBlock;
import com.mightydanp.eot.common.EoT;
import java.util.Locale;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.IStringSerializable;

/**
 * @auther MightyDanp
 * date class created: Jul 7, 2016 
 */

public class BlockDecorative extends IMetaBlock{
    
    public static final PropertyEnum TYPE = PropertyEnum.create("decorative", DecorativeType.class);

    public BlockDecorative(String unlocalizedName) {
        super(Material.ROCK, TYPE, DecorativeType.class, unlocalizedName);
        this.setHardness(0.5F);
        this.setCreativeTab(EoT.tabEoT);
        this.setUnlocalizedName(unlocalizedName);
    }
    
    public enum DecorativeType implements IStringSerializable, IMetaBlock.IEnumMeta {
        BRICK_CASTLE;
        
        public final int meta;

        DecorativeType() {
            meta = ordinal();
        }

        @Override
        public String getName() {
            return this.toString().toLowerCase(Locale.US);
        }

        @Override
        public int getMeta() {
            return meta;
        }
        
    }

}