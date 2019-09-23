package com.mightydanp.eot.client.gui;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import tconstruct.client.tabs.TabRegistry;

import com.mightydanp.eot.inventory.InventoryEotInventory;
import com.mightydanp.eot.client.tabs.InventoryTabEot;
import com.mightydanp.eot.inventory.ContainterEotInventory;
import com.mightydanp.eot.item.ModItems;
import com.mightydanp.eot.lib.References;

import cpw.mods.fml.common.Loader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GuiEotInventory extends GuiContainer{

	private static final ResourceLocation background = new ResourceLocation(References.MODID, "textures/gui/eotInventory.png");
	private static final ResourceLocation tier1Bag = new ResourceLocation(References.MODID, "textures/gui/tier1Bag.png");
	private static final ResourceLocation tier2Bag = new ResourceLocation(References.MODID, "textures/gui/tier2Bag.png");
	private static final ResourceLocation tier3Bag = new ResourceLocation(References.MODID, "textures/gui/tier3Bag.png");
	
	private float xSize_lo;
    private float ySize_lo;
    
    private static final int BAG_WIDTH = 112;
    private int descLeft = 0;
    private int bagLeft = 0;
    private int bagTop = 0;
    
    private final InventoryEotInventory inventory;
    
	public GuiEotInventory(EntityPlayer player,InventoryPlayer inventoryplayer, InventoryEotInventory holder) {
		super(new ContainterEotInventory(player, inventoryplayer, holder));
		this.inventory = holder;
	}
	
    @Override
    public void initGui ()
    {
        super.initGui();
        this.xSize = 176;
        this.ySize = 166;

        this.guiLeft = (this.width - this.xSize) / 2;
        this.guiTop = (this.height - this.ySize) / 2;
        this.bagLeft = this.guiLeft;
        this.bagTop = this.guiTop;
        //this.ySize = this.guiTop;
        
        if (inventory.getInventory()[0] != null)
        {
            this.xSize += BAG_WIDTH;
            this.bagLeft = this.guiLeft;
            if (inventory.getInventory()[0].getItem() == ModItems.Bagtier3)
                this.ySize = 180;
        }
        
        if (Loader.isModLoaded("NotEnoughItems")) {
        	this.guiLeft -= BAG_WIDTH - 70;
        	this.bagLeft = this.guiLeft;
            //this.bagTop = this.guiTop - 70;
        }
        
        
        
        this.buttonList.clear();
        this.buttonList.clear();

        TabRegistry.updateTabValues(guiLeft, guiTop, InventoryTabEot.class);
        TabRegistry.addTabsToList(this.buttonList);  	
    }
	
	@Override
    public void drawScreen (int par1, int par2, float par3){
        super.drawScreen(par1, par2, par3);
        this.xSize_lo = (float) par1;
        this.ySize_lo = (float) par2;
    }
	

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(background);
        
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, 176, 166);
        
        if (inventory.getInventory()[0] != null)
        {       
            	if(this.xSize == 288 && inventory.getInventory()[0].getItem() == ModItems.Bagtier1){
            		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                    this.mc.getTextureManager().bindTexture(tier1Bag);
                    
                    this.drawTexturedModalRect(bagLeft + 164 , bagTop, 0, 0, 150, 72);
            	}
            	
            	if(this.xSize == 288 && inventory.getInventory()[0].getItem() == ModItems.Bagtier2) {
            		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                    this.mc.getTextureManager().bindTexture(tier2Bag);
                    
                    this.drawTexturedModalRect(bagLeft + 164 , bagTop, 0, 0, 150, 125);
            	}
            	
            	if(this.xSize == 288 && inventory.getInventory()[0].getItem() == ModItems.Bagtier3) {
            		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                    this.mc.getTextureManager().bindTexture(tier3Bag);
                    
                    this.drawTexturedModalRect(bagLeft + 164 , bagTop, 0, 0, 150, 180);
            	}

        }
        
        drawPlayerOnGui(this.mc, guiLeft + 89, guiTop + 75, 30, (float) (guiLeft + 107) - this.xSize_lo, (float) (guiTop + 75 - 50) - this.ySize_lo);
    }

	public static void drawPlayerOnGui (Minecraft par0Minecraft, int par1, int par2, int par3, float par4, float par5)
    {
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glPushMatrix();
        GL11.glTranslatef((float) par1, (float) par2, 50.0F);
        GL11.glScalef((float) (-par3), (float) par3, (float) par3);
        GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        float f2 = par0Minecraft.thePlayer.renderYawOffset;
        float f3 = par0Minecraft.thePlayer.rotationYaw;
        float f4 = par0Minecraft.thePlayer.rotationPitch;
        par4 -= 19;
        GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-((float) Math.atan((double) (par5 / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
        par0Minecraft.thePlayer.renderYawOffset = (float) Math.atan((double) (par4 / 40.0F)) * 20.0F;
        par0Minecraft.thePlayer.rotationYaw = (float) Math.atan((double) (par4 / 40.0F)) * 40.0F;
        par0Minecraft.thePlayer.rotationPitch = -((float) Math.atan((double) (par5 / 40.0F))) * 20.0F;
        par0Minecraft.thePlayer.rotationYawHead = par0Minecraft.thePlayer.rotationYaw;
        GL11.glTranslatef(0.0F, par0Minecraft.thePlayer.yOffset, 0.0F);
        RenderManager.instance.playerViewY = 180.0F;
        RenderManager.instance.renderEntityWithPosYaw(par0Minecraft.thePlayer, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
        par0Minecraft.thePlayer.renderYawOffset = f2;
        par0Minecraft.thePlayer.rotationYaw = f3;
        par0Minecraft.thePlayer.rotationPitch = f4;
        GL11.glPopMatrix();
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }

}
