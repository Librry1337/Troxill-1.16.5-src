// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules.render;

import net.minecraft.client.Minecraft;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;

public class GammaModule extends AbstractModule
{
    private double Qzm;
    Minecraft bRQ;
    
    public GammaModule(final int var1, final String[] var2, final int var3, final int var4) {
        super(var1, var2, var3, var4);
        this.bRQ = Minecraft.getInstance();
        this.Qzm = this.bRQ.options.gamma;
    }
    
    @Override
    public void Kxp() {
        this.Qzm = this.bRQ.options.gamma;
        this.bRQ.options.gamma = 100.0;
    }
    
    @Override
    public void HDK() {
        this.bRQ.options.gamma = this.Qzm;
    }
}
