// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules.movement;

import net.minecraft.network.play.client.CPlayerTryUseItemPacket;
import net.minecraft.util.Hand;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.client.CHeldItemChangePacket;
import net.minecraft.item.ItemStack;
import ru.zvcoder.antihohol.troxill.clickgui.settings.Setting;
import net.minecraft.item.FireworkRocketItem;
import net.minecraft.client.Minecraft;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;
import ru.zvcoder.antihohol.troxill.modules.ModuleManager;
import ru.zvcoder.antihohol.troxill.utils.calc.TimerHelper;

public class AuthoFireWorkModule extends AbstractModule
{
    TimerHelper VOO;
    Class aBE;
    private int kni;
    Minecraft Kcf;
    
    public AuthoFireWorkModule(final int var1, final String[] var2, final int var3, final int var4) {
        super(var1, var2, var3, var4);
        this.VOO = new TimerHelper();
        this.aBE = FireworkRocketItem.class;
        this.Kcf = Minecraft.getInstance();
        final Setting var5 = ModuleManager.zWY(new Setting(this, new String[] { "De", "la", "y:", " " }, 500.0, 30.0, 1500.0, true, 1));
    }
    
    private int zqU() {
        if (this.Kcf.player == null) {
            return -1;
        }
        for (int var1 = 0; var1 <= 9; ++var1) {
            final ItemStack var2 = this.Kcf.player.inventory.getItem(var1);
            if (var2.getItem().getClass().equals(this.aBE)) {
                return var1;
            }
        }
        return -1;
    }
    
    @Override
    public void Kxp() {
        super.geu();
        this.kni = this.Kcf.player.inventory.selected;
        final int var1 = this.zqU();
        if (var1 != -1) {
            this.Kcf.player.inventory.selected = var1;
            this.Kcf.player.connection.send((IPacket)new CHeldItemChangePacket(var1));
            this.Kcf.player.connection.send((IPacket)new CPlayerTryUseItemPacket(Hand.MAIN_HAND));
            this.VOO.kWd(true);
            this.VOO.OQP();
        }
    }
    
    @Override
    public void evV() {
        if (this.VOO.pJy(ModuleManager.SBG(this, 1).nUP) && this.VOO.RuA()) {
            this.VOO.kWd(false);
            this.Kcf.player.inventory.selected = this.kni;
            this.Kcf.player.connection.send((IPacket)new CHeldItemChangePacket(this.kni));
        }
    }
}
