// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules.combat;

import net.minecraft.client.settings.KeyBinding;
import ru.zvcoder.antihohol.troxill.clickgui.settings.Setting;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;
import ru.zvcoder.antihohol.troxill.modules.ModuleManager;
import ru.zvcoder.antihohol.troxill.utils.calc.TimerHelper;
import net.minecraft.client.Minecraft;

public class AutoClickerModule extends AbstractModule
{
    Minecraft TBh;
    TimerHelper PjB;
    
    public AutoClickerModule(final int var1, final String[] var2, final int var3, final int var4) {
        super(var1, var2, var3, var4);
        this.TBh = Minecraft.getInstance();
        this.PjB = new TimerHelper();
        final Setting var5 = ModuleManager.zWY(new Setting(this, new String[] { "Dela", "y:" }, 100.0, 20.0, 1000.0, true, 1));
    }
    
    @Override
    public void onEnable() {
        if (this.TBh.screen == null && this.PjB.pJy(ModuleManager.SBG(this, 1).nUP)) {
            KeyBinding.click(this.TBh.options.keyAttack.getDefaultKey());
            this.PjB.OQP();
        }
    }
}
