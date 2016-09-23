package com.mightydanp.eot.common.block;

import com.mightydanp.eot.api.common.block.IMetaBlock;
import com.mightydanp.eot.common.EoT;
import com.mightydanp.eot.common.lib.BlockReference;
import java.util.Locale;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.IStringSerializable;

/**
 * @auther MightyDanp
 * date class created: Jul 6, 2016 
 */

public class BlockCompressed extends IMetaBlock{
    
    public static final PropertyEnum TYPE = PropertyEnum.create("compressed", CompressedType.class);

    public BlockCompressed(String unlocalizedName) {
        super(Material.IRON, TYPE, CompressedType.class, unlocalizedName);
        this.setHardness(2.2F);
        this.setCreativeTab(EoT.tabEoT);
        this.setUnlocalizedName(unlocalizedName);
    }
    
    public enum CompressedType implements IStringSerializable, IMetaBlock.IEnumMeta {
        COPPER,
        SILVER,
        TIN,
        LEAD,
        BRONZE,
        RUBY,
        SAPPHIRE;
        
        public final int meta;

        CompressedType() {
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
