// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.clickgui;

public class AnimationImpl extends Animation
{
    public void Bhf(final double var1, final double var3) {
        this.qVs(var1, var3, false);
    }
    
    public void qVs(final double var1, final double var3, final boolean var5) {
        super.ZjW(var5);
        if (!super.Vti() || (var1 != super.CGj() && var1 != super.KZK() && var1 != super.Etm())) {
            super.kNm(var3 * 1000.0);
            super.YmH(System.currentTimeMillis());
            super.xsz(super.Etm());
            super.dyt(var1);
        }
    }
}
