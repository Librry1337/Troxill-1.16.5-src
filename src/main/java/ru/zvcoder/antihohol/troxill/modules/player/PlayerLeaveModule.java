// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules.player;

import net.minecraft.network.IPacket;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.network.play.server.SDisconnectPacket;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import ru.zvcoder.antihohol.troxill.clickgui.settings.Setting;
import net.minecraft.client.Minecraft;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;
import ru.zvcoder.antihohol.troxill.modules.ModuleManager;

public class PlayerLeaveModule extends AbstractModule
{
    Minecraft Awn;
    
    public PlayerLeaveModule(final int var1, final String[] var2, final int var3, final int var4) {
        super(var1, var2, var3, var4);
        this.Awn = Minecraft.getInstance();
        Setting var5 = ModuleManager.zWY(new Setting(this, new String[] { "Di", "st", "an", "ce", ":" }, 40.0, 5.0, 100.0, true, 1));
        var5 = ModuleManager.zWY(new Setting(this, true, new String[] { "Au", "to", "Di", "sa", "bl", "e" }, 1, 2));
    }
    
    @Override
    public void onEnable() {
        final double var1 = ModuleManager.SBG(this, 1).nUP;
        for (final PlayerEntity var3 : this.Awn.level.players()) {
            if (var3.distanceTo((Entity)this.Awn.player) >= var1 && this.Awn.getConnection() != null) {
                this.Awn.getConnection().send((IPacket)new SDisconnectPacket((ITextComponent)new StringTextComponent("")));
                final boolean var4 = ModuleManager.SBG(this, 2).Xbo;
                if (var4) {
                    super.geu();
                }
            }
        }
    }
}
