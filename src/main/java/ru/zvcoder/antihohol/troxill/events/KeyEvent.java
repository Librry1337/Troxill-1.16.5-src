// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.events;

import ru.zvcoder.antihohol.troxill.modules.ClickGuiModule;
import ru.zvcoder.antihohol.troxill.clickgui.ClickGui;
import ru.zvcoder.antihohol.troxill.clickgui.settings.KeyBindManager;
import ru.zvcoder.antihohol.troxill.modules.ghost.SelfDestructModule;
import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyboardListener;

public class KeyEvent extends KeyboardListener
{
    public KeyEvent(final Minecraft var1) {
        super(var1);
    }
    
    public void keyPress(final long var1, final int var3, final int var4, final int var5, final int var6) {
        if (!SelfDestructModule.BNw.JNU) {
            new ClickGuiModule(var5, var3, var6, var4);
            if (Minecraft.getInstance().screen != null && Minecraft.getInstance().screen.getClass() != ClickGui.class) {
                KeyBindManager.kbt.replaceAll((var0, var1x) -> false);
            }
        }
        super.keyPress(var1, var3, var4, var5, var6);
    }
}
