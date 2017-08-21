package com.mightydanp.eot.common.handler;

import com.mightydanp.eot.common.config.ConfigSurvival;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.GameType;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by MightyDanp on 8/14/2017.
 */
public class EventHandler {
    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed e) {
        if (ConfigSurvival.BETTER_ADVENTURE == true) {
            IBlockState block = e.getState();
            ItemStack itemStackHeld = e.getEntityPlayer().getHeldItemMainhand();
            Material getBlockMaterial = e.getState().getMaterial();

            if (itemStackHeld != null && !e.getEntityPlayer().capabilities.isCreativeMode) {
                Item itemHeld = itemStackHeld.getItem();
                if (!(itemHeld.canHarvestBlock(block, itemStackHeld) || itemHeld.getStrVsBlock(itemStackHeld, block) > 1.0F) && !(getBlockMaterial == Material.PLANTS || getBlockMaterial == Material.REDSTONE_LIGHT || getBlockMaterial == Material.TNT || getBlockMaterial == Material.VINE || getBlockMaterial == Material.LEAVES)) {
                    System.out.println("passed");
                    e.setNewSpeed(0);
                }

            } else {
                if (!getBlockMaterial.isToolNotRequired()) {
                    e.setNewSpeed(0);
                }

                if (!(getBlockMaterial == Material.PLANTS || getBlockMaterial == Material.REDSTONE_LIGHT || getBlockMaterial == Material.TNT || getBlockMaterial == Material.VINE || getBlockMaterial == Material.LEAVES)) {
                    e.setNewSpeed(0);
                }
            }
        }
    }

    @SubscribeEvent
    public void forceSurvival(EntityJoinWorldEvent e) {
        if (ConfigSurvival.FORCE_SURVIVAL == true && e.getEntity() != null && e.getEntity() instanceof EntityPlayerMP) {
            EntityPlayerMP player = (EntityPlayerMP) e.getEntity();
            if (player.interactionManager.getGameType().isAdventure()) {
                player.addChatMessage(new TextComponentString("You where in adventure, now set to survival."));
                player.addChatMessage(new TextComponentString("If you see this message and you dont have any break animation's. Please rejoin the work or server."));
                player.addChatMessage(new TextComponentString( TextFormatting.RED + "To turn this off go into config/EOT/SurvivialSettings.cfg"));
                player.interactionManager.setGameType(GameType.SURVIVAL);
            }
        }
    }
}
