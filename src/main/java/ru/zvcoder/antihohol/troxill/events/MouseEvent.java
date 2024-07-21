// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.events;

import ru.zvcoder.antihohol.troxill.modules.ModuleManager;

public class MouseEvent
{
    public final int Lfk;
    public final int Dan;
    public final int rgC;
    
    public MouseEvent(final int var1, final int var2, final int var3) {
        this.Lfk = var1;
        this.Dan = var2;
        this.rgC = var3;
        ModuleManager.MSA(this);
    }
}
