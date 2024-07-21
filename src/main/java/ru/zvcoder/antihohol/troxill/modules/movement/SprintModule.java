// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules.movement;

import ru.zvcoder.antihohol.troxill.clickgui.settings.KeyBindManager;
import ru.zvcoder.antihohol.troxill.clickgui.settings.Setting;
import net.minecraft.client.Minecraft;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;
import ru.zvcoder.antihohol.troxill.modules.ModuleManager;

public class SprintModule extends AbstractModule
{
    public static AbstractModule wsR;
    Minecraft RUR;
    
    public SprintModule(final int var1, final String[] var2, final int var3, final int var4) {
        super(var1, var2, var3, var4);
        this.RUR = Minecraft.getInstance();
        SprintModule.wsR = this;
        final Setting var5 = ModuleManager.zWY(new Setting(this, false, new String[] { "Wh", "en", "E", "at" }, 1, 1));
    }
    
    @Override
    public void onEnable() {
        if (this.RUR.screen == null && KeyBindManager.kUZ(87) && !this.RUR.player.horizontalCollision) {
            this.RUR.player.setSprinting(true);
        }
    }
    
    @Override
    public void Kxp() {
        super.Kxp();
    }
    
    @Override
    public void HDK() {
        super.HDK();
    }
}
