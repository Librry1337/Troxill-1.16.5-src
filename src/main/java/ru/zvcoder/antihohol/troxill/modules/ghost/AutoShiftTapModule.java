// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules.ghost;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.Minecraft;
import ru.zvcoder.antihohol.troxill.events.MouseEvent;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;
import ru.zvcoder.antihohol.troxill.utils.calc.TimerHelper;

public class AutoShiftTapModule extends AbstractModule
{
    TimerHelper Fwm;
    
    public AutoShiftTapModule(final int var1, final String[] var2, final int var3, final int var4) {
        super(var1, var2, var3, var4);
        this.Fwm = new TimerHelper();
    }
    
    @Override
    public void onMouse(final MouseEvent var1) {
        final Minecraft var2 = Minecraft.getInstance();
        if (var2.screen == null) {
            final KeyBinding var3 = var2.options.keyAttack;
            final KeyBinding var4 = var2.options.keyShift;
            if (var1.Lfk == var3.getDefaultKey().getValue() && var1.Dan == 1 && !this.Fwm.RuA() && !var4.isDown()) {
                this.Fwm.OQP();
                this.Fwm.kWd(true);
                KeyBinding.set(var4.getDefaultKey(), true);
            }
        }
    }
    
    @Override
    public void onEnable() {
        final KeyBinding var1 = Minecraft.getInstance().options.keyShift;
        if (this.Fwm.pJy(100.0) && this.Fwm.RuA()) {
            KeyBinding.set(var1.getDefaultKey(), false);
            this.Fwm.kWd(false);
        }
    }
}
