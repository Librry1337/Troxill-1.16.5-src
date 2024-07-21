// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules;

import net.minecraft.client.gui.screen.Screen;
import ru.zvcoder.antihohol.troxill.clickgui.settings.KeyBindManager;
import ru.zvcoder.antihohol.troxill.clickgui.ClickGui;
import ru.zvcoder.antihohol.troxill.hooks.HookUTIL;
import net.minecraft.client.Minecraft;

public class ClickGuiModule
{
    private final int GUF;
    private final int oRH;
    private final int HPy;
    private final int Hyt;
    public static ClickGui OGj;
    
    public ClickGuiModule(final int var1, final int var2, final int var3, final int var4) {
        this.GUF = var1;
        this.oRH = var2;
        this.HPy = var3;
        this.Hyt = var4;
        HookUTIL.INm();
        if (Minecraft.getInstance().screen == null || Minecraft.getInstance().screen.getClass() == ClickGui.class) {
            ModuleManager.Qep(this);
            if (var1 != 1 && var1 != 2) {
                if (var1 == 0) {
                    KeyBindManager.kbt.put(var2, false);
                }
            }
            else {
                KeyBindManager.kbt.put(var2, true);
            }
        }
        if (var1 != 1 && var1 != 2) {
            if (var1 == 0) {
                KeyBindManager.Ymx.put(var2, false);
            }
        }
        else {
            KeyBindManager.Ymx.put(var2, true);
        }
        if (ClickGuiModule.OGj == null) {
            ClickGuiModule.OGj = new ClickGui();
        }
        if (KeyBindManager.orS(344)) {
            Minecraft.getInstance().setScreen((Screen) ClickGuiModule.OGj);
            ClickGui.KKX = true;
        }
    }
    
    public int Xht() {
        return this.GUF;
    }
    
    public int Zgf() {
        return this.oRH;
    }
    
    public int Aji() {
        return this.HPy;
    }
    
    public int ESk() {
        return this.Hyt;
    }
}
