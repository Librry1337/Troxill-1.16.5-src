// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules.ghost;

import java.util.Random;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPlayerTryUseItemPacket;
import net.minecraft.util.Hand;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.client.CHeldItemChangePacket;
import net.minecraft.item.Items;
import ru.zvcoder.antihohol.troxill.events.MouseEvent;
import ru.zvcoder.antihohol.troxill.clickgui.settings.Setting;
import net.minecraft.client.Minecraft;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;
import ru.zvcoder.antihohol.troxill.modules.ModuleManager;
import ru.zvcoder.antihohol.troxill.utils.calc.TimerHelper;

public class MiddlePearlModule extends AbstractModule
{
    private int Lck;
    private final TimerHelper zes;
    Minecraft qbq;
    
    public MiddlePearlModule(final int var1, final String[] var2, final int var3, final int var4) {
        super(var1, var2, var3, var4);
        this.Lck = 0;
        this.zes = new TimerHelper();
        this.qbq = Minecraft.getInstance();
        Setting var5 = ModuleManager.zWY(new Setting(this, new String[] { "De", "la", "y" }, 50.0, 30.0, 500.0, true, 1));
        var5 = ModuleManager.zWY(new Setting(this, true, new String[] { "Ra", "nd", "om", "iz", "e" }, 1, 2));
    }
    
    @Override
    public void onMouse(final MouseEvent var1) {
        if (!this.zes.RuA()) {
            if (this.qbq.level == null) {
                return;
            }
            if (this.qbq.player != null && var1.Lfk == 2 && var1.Dan == 1) {
                this.Lck = this.qbq.player.inventory.selected;
                for (int var2 = 0; var2 < 9; ++var2) {
                    final ItemStack var3 = this.qbq.player.inventory.getItem(var2);
                    if (var3.getItem() == Items.ENDER_PEARL && this.qbq.screen == null) {
                        this.qbq.player.inventory.selected = var2;
                        this.qbq.player.connection.send((IPacket)new CHeldItemChangePacket(var2));
                        this.qbq.player.connection.send((IPacket)new CPlayerTryUseItemPacket(Hand.MAIN_HAND));
                        this.zes.OQP();
                        this.zes.kWd(true);
                    }
                }
            }
        }
    }
    
    @Override
    public void onEnable() {
        int var1 = 0;
        if (ModuleManager.SBG(this, 2).Xbo) {
            var1 = 50 + new Random().nextInt(100);
        }
        if (this.zes.pJy(ModuleManager.SBG(this, 1).nUP + var1) && this.zes.RuA()) {
            this.qbq.player.connection.send((IPacket)new CHeldItemChangePacket(this.Lck));
            this.qbq.player.inventory.selected = this.Lck;
            this.zes.kWd(false);
        }
    }
}
