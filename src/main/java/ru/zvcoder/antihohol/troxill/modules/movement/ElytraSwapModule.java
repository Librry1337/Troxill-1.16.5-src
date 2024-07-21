// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules.movement;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.client.CCloseWindowPacket;
import java.util.Objects;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.Slot;
import ru.zvcoder.antihohol.troxill.clickgui.settings.Setting;
import net.minecraft.item.Items;
import net.minecraft.item.Item;
import net.minecraft.client.Minecraft;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;
import ru.zvcoder.antihohol.troxill.modules.ModuleManager;

public class ElytraSwapModule extends AbstractModule
{
    Minecraft PNy;
    
    private boolean KSM(final Item var1) {
        return var1 == Items.ELYTRA;
    }
    
    private boolean Wdd(final Item var1) {
        return var1 == Items.CHAINMAIL_CHESTPLATE || var1 == Items.DIAMOND_CHESTPLATE || var1 == Items.GOLDEN_CHESTPLATE || var1 == Items.IRON_CHESTPLATE || var1 == Items.LEATHER_CHESTPLATE || var1 == Items.NETHERITE_CHESTPLATE;
    }
    
    public ElytraSwapModule(final int var1, final String[] var2, final int var3, final int var4) {
        super(var1, var2, var3, var4);
        this.PNy = Minecraft.getInstance();
        final Setting var5 = ModuleManager.zWY(new Setting(this, new String[] { "De", "la", "y:" }, 10.0, 1.0, 1000.0, true, 2));
    }
    
    @Override
    public void Kxp() {
        this.PNy.player.sendOpenInventory();
        if (this.PNy.player != null && this.PNy.gameMode != null) {
            final PlayerContainer var1 = this.PNy.player.inventoryMenu;
            if (!var1.slots.get(6).getItem().isEmpty()) {
                if (this.KSM(var1.slots.get(6).getItem().getItem())) {
                    for (final Slot var3 : var1.slots) {
                        final Item var4 = var3.getItem().getItem();
                        if (this.Wdd(var4)) {
                            ItemStack var5 = this.PNy.gameMode.handleInventoryMouseClick(var1.containerId, var3.index, 0, ClickType.SWAP, (PlayerEntity)this.PNy.player);
                            var5 = this.PNy.gameMode.handleInventoryMouseClick(var1.containerId, 6, 0, ClickType.SWAP, (PlayerEntity)this.PNy.player);
                            var5 = this.PNy.gameMode.handleInventoryMouseClick(var1.containerId, var3.index, 0, ClickType.SWAP, (PlayerEntity)this.PNy.player);
                            break;
                        }
                    }
                }
                else if (this.Wdd(var1.slots.get(6).getItem().getItem())) {
                    for (final Slot var3 : var1.slots) {
                        final Item var4 = var3.getItem().getItem();
                        if (this.KSM(var4)) {
                            ItemStack var5 = this.PNy.gameMode.handleInventoryMouseClick(var1.containerId, var3.index, 0, ClickType.SWAP, (PlayerEntity)this.PNy.player);
                            var5 = this.PNy.gameMode.handleInventoryMouseClick(var1.containerId, 6, 0, ClickType.SWAP, (PlayerEntity)this.PNy.player);
                            var5 = this.PNy.gameMode.handleInventoryMouseClick(var1.containerId, var3.index, 0, ClickType.SWAP, (PlayerEntity)this.PNy.player);
                            break;
                        }
                    }
                }
            }
            else {
                for (final Slot var3 : var1.slots) {
                    final Item var4 = var3.getItem().getItem();
                    if (this.KSM(var4) || this.Wdd(var4)) {
                        final ItemStack var5 = this.PNy.gameMode.handleInventoryMouseClick(var1.containerId, var3.index, 0, ClickType.QUICK_MOVE, (PlayerEntity)this.PNy.player);
                    }
                }
            }
        }
        new Thread(() -> {
            try {
                Thread.sleep(200L);
                Objects.requireNonNull(this.PNy.getConnection()).send((IPacket)new CCloseWindowPacket(this.PNy.player.containerMenu.containerId));
            }
            catch (final InterruptedException var6) {
                throw new RuntimeException(var6);
            }
            return;
        });
        super.geu();
    }
}
