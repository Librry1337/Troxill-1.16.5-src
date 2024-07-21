// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules.combat;

import net.minecraft.client.settings.KeyBinding;
import ru.zvcoder.antihohol.troxill.clickgui.settings.Setting;
import net.minecraft.client.Minecraft;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;
import ru.zvcoder.antihohol.troxill.modules.ModuleManager;
import ru.zvcoder.antihohol.troxill.utils.calc.TimerHelper;

public class TapeMouseModule extends AbstractModule
{
    TimerHelper PMs;
    Minecraft YeE;
    
    public TapeMouseModule(final int var1, final String[] var2, final int var3, final int var4) {
        super(var1, var2, var3, var4);
        this.PMs = new TimerHelper();
        this.YeE = Minecraft.getInstance();
        Setting var5 = ModuleManager.zWY(new Setting(this, false, new String[] { "Au", "to", "Ea", "t" }, 1, 1));
        var5 = ModuleManager.zWY(new Setting(this, new String[] { "De", "la", "y" }, 5.0, 2.0, 10.0, false, 2));
    }
    
    @Override
    public void HDK() {
        if (ModuleManager.SBG(this, 1).aCO()) {
            KeyBinding.set(this.YeE.options.keyUse.getDefaultKey(), false);
        }
    }
    
    @Override
    public void onEnable() {
        KeyBinding.set(this.YeE.options.keyUse.getDefaultKey(), ModuleManager.SBG(this, 1).aCO());
        if (this.PMs.pJy(ModuleManager.SBG(this, 2).nUP * 1000.0)) {
            this.PMs.OQP();
            KeyBinding.click(this.YeE.options.keyAttack.getDefaultKey());
        }
    }
}
