package com.mightydanp.eot.item;

import java.util.List;

import com.mightydanp.eot.Eot;
import com.mightydanp.eot.core.config.GeneralConfiguration;
import com.mightydanp.eot.lib.ItemStrings;
import com.mightydanp.eot.lib.References;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemMagicalStone extends Item{
	
	
	public IIcon[] iconArray = new IIcon[subItems.length];
	
	public static String[] subItems = new String[] {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
	
	public static String emptyFirstLine = "This seems to be pulsing power.";
	public static String emptySecondLine = "It only happens whenever i get close to these creatures.";
	public static String emptyThirdLine = "I wonder if this is linked to them.";
	
	public static String fullFirstLine = "The  Magical Stone seems to be full?";
	public static String fullSecondLine = "It seems to be useless now.";
	public static String fullThirdLine = "I wonder whats inside?";
	
	public static String coolDownFirstLine = "";
	public static String coolDownSecondLine = "Everytime I use this now it seems to get hotter.";
	public static String coolDownThirdLine = "Maybe I should let it cool off.";
	
	public static String[] subItemsDescriptionsFirstLine = new String[] {fullFirstLine, emptyFirstLine, emptyFirstLine, emptyFirstLine, emptyFirstLine, emptyFirstLine, emptyFirstLine, emptyFirstLine, emptyFirstLine, emptyFirstLine, emptyFirstLine, emptyFirstLine, emptyFirstLine, emptyFirstLine, emptyFirstLine, emptyFirstLine, emptyFirstLine};
	public static String[] subItemsDescriptionsSecondLine = new String[] {fullSecondLine, emptySecondLine, emptySecondLine, emptySecondLine, emptySecondLine, emptySecondLine, emptySecondLine, emptySecondLine, emptySecondLine, emptySecondLine, emptySecondLine, emptySecondLine, emptySecondLine, emptySecondLine, emptySecondLine, emptySecondLine, emptySecondLine};
	public static String[] subItemsDescriptionsThirdLine = new String[] {fullThirdLine, emptyThirdLine, emptyThirdLine, emptyThirdLine, emptyThirdLine, emptyThirdLine, emptyThirdLine, emptyThirdLine, emptyThirdLine, emptyThirdLine, emptyThirdLine, emptyThirdLine, emptyThirdLine, emptyThirdLine, emptyThirdLine, emptyThirdLine, emptyThirdLine};
	
	public static String[] subItemsCoolDownDescriptionsFirstLine = new String[] {coolDownFirstLine, coolDownFirstLine, coolDownFirstLine, coolDownFirstLine, coolDownFirstLine, coolDownFirstLine, coolDownFirstLine, coolDownFirstLine, coolDownFirstLine, coolDownFirstLine, coolDownFirstLine, coolDownFirstLine, coolDownFirstLine, coolDownFirstLine, coolDownFirstLine, coolDownFirstLine, coolDownFirstLine};
	public static String[] subItemsCoolDownDescriptionsSecondLine = new String[] {coolDownSecondLine, coolDownSecondLine, coolDownSecondLine, coolDownSecondLine, coolDownSecondLine, coolDownSecondLine, coolDownSecondLine, coolDownSecondLine, coolDownSecondLine, coolDownSecondLine, coolDownSecondLine, coolDownSecondLine, coolDownSecondLine, coolDownSecondLine, coolDownSecondLine, coolDownSecondLine, coolDownSecondLine};
	public static String[] subItemsCoolDownDescriptionsThirdLine = new String[] {coolDownThirdLine, coolDownThirdLine, coolDownThirdLine, coolDownThirdLine, coolDownThirdLine, coolDownThirdLine, coolDownThirdLine, coolDownThirdLine, coolDownThirdLine, coolDownThirdLine, coolDownThirdLine, coolDownThirdLine, coolDownThirdLine, coolDownThirdLine, coolDownThirdLine, coolDownThirdLine, coolDownThirdLine};
	
	public ItemMagicalStone(String unlocalizedName){
		this.setCreativeTab(Eot.eotTab);
		this.setUnlocalizedName(unlocalizedName);
		this.setMaxDamage(16);
		this.setMaxStackSize(1);
		this.setHasSubtypes(true);
	}
	
	@Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int i, boolean flag){
    	super.onUpdate(itemStack, world, entity, i, flag);
    	
    	if (!world.isRemote){
    		NBTTagCompound nbtDataCompund = itemStack.stackTagCompound;
    		if (nbtDataCompund == null)
    		{
    			itemStack.stackTagCompound = new NBTTagCompound();
    			nbtDataCompund = itemStack.getTagCompound();
    		}
    		
    		int coolDown = nbtDataCompund.getInteger("coolDown");
    		if(coolDown > 0){
    			--coolDown;
    			nbtDataCompund.setInteger("coolDown", coolDown);
        	}
    	}
    }
	
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool){
    	if(itemStack.getItemDamage() < subItems.length){
			dataList.add(subItemsDescriptionsFirstLine[itemStack.getItemDamage()]);
			dataList.add(subItemsDescriptionsSecondLine[itemStack.getItemDamage()]);
			dataList.add(subItemsDescriptionsThirdLine[itemStack.getItemDamage()]);
		}
    	
    	NBTTagCompound nbtDataCompund = itemStack.stackTagCompound;
		if (nbtDataCompund != null)
		{
			int coolDown = nbtDataCompund.getInteger("coolDown");

	        if(coolDown > 0){
	        	dataList.add(subItemsCoolDownDescriptionsFirstLine[itemStack.getItemDamage()]);
				dataList.add(subItemsCoolDownDescriptionsSecondLine[itemStack.getItemDamage()]);
				dataList.add(subItemsCoolDownDescriptionsThirdLine[itemStack.getItemDamage()]);
	        }
		}
    }
    
    @Override
    public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer entityplayer, EntityLivingBase entity ){ 
    	
        if(!entity.worldObj.isRemote){
        	NBTTagCompound nbtDataCompund = itemStack.stackTagCompound;
    		if (nbtDataCompund != null)
    		{
    			int coolDown = nbtDataCompund.getInteger("coolDown");
    			
    			if(coolDown > 0){
    	        	return false;
    	        }
    			
    			if(coolDown == 0){
    				if (entity instanceof EntityMob){
    	                if(itemStack.getItemDamage() > 0){
    	                	entity.setHealth(0.0F);
    	                	itemStack.stackTagCompound.setInteger("coolDown", GeneralConfiguration.magicStoneCooldown);
    	                	if(!entity.worldObj.isRemote){
    	                		entityplayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GRAY +"Soul Absurbed!"));
    	                	}
    	                	itemStack.damageItem(-1, entityplayer);
    	                    return true;
    	                }else{
    	                	if(!entity.worldObj.isRemote){
    	                		entityplayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GRAY + "The  Magical Stone seems to be full?"));
    	                        entityplayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GRAY + "It seems to be useless now."));
    	                        entityplayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GRAY + "I wonder whats inside?"));
    	                    }
    	                    return true;
    	                }
    	            }else{
    	            	if(!entity.worldObj.isRemote){
    	            		entityplayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GRAY + "Why has this stoped working?"));
    	                }
    	            }
    			}else{
					entityplayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GRAY + "Why has this stoped working?"));
				}
    		}
        }
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack itemStack)
    {
    	if(itemStack.getItemDamage() > 0){
    		return false;
    	}else{
    		 return itemStack.getItemDamage() == 0;
    	}
    }
  
    public ItemStack onItemRightClick(ItemStack itemstack, World par2World, EntityPlayer entityplayer)
    {
     return itemstack;
    }
    
    @Override
	public void registerIcons(IIconRegister reg) {
	    for (int i = 0; i < subItems.length; i ++) {
	        this.iconArray[i] = reg.registerIcon(References.RESOURCESPREFIX + ItemStrings.MAGICALSTONE_NAME);
	    }
	}
    
    @Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
	    for (int i = 0; i < subItems.length; i ++) {
	        list.add(new ItemStack(item, 1, i));
	    }
	}
    
    @SideOnly(Side.CLIENT)
	public String getUnlocalizedName(ItemStack itemStack){
		return super.getUnlocalizedName();
	}
    
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta){
		return this.iconArray[meta];
	}

}
