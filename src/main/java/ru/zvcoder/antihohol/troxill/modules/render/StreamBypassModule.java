// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules.render;

import ru.zvcoder.antihohol.troxill.modules.AbstractModule;
import ru.zvcoder.antihohol.troxill.utils.fonts.FontManager;
import ru.zvcoder.antihohol.troxill.utils.render.RenderHelper;

public class StreamBypassModule extends AbstractModule
{
    public static AbstractModule ufx;
    
    public StreamBypassModule(final int var1, final String[] var2, final int var3, final int var4) {
        super(var1, var2, var3, var4);
        StreamBypassModule.ufx = this;
    }
    
    @Override
    public void Kxp() {
    }
    
    @Override
    public void geu() {
        super.geu();
        RenderHelper.Uoj.clear();
        FontManager.GHW();
    }
}
