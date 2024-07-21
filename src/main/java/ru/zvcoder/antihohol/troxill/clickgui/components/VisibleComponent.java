// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.clickgui.components;

import ru.zvcoder.antihohol.troxill.clickgui.ClickGui;
import ru.zvcoder.antihohol.troxill.clickgui.Component;
import ru.zvcoder.antihohol.troxill.clickgui.settings.Setting;
import ru.zvcoder.antihohol.troxill.utils.render.ColorUtil2;
import ru.zvcoder.antihohol.troxill.utils.render.RenderHelper;
import ru.zvcoder.antihohol.troxill.utils.fonts.FontManager;

import java.awt.Color;

public class VisibleComponent extends Component
{
    private boolean bGv;
    private final Setting owS;
    private final ModuleComponent QVM;
    private int tvQ;
    private int LXV;
    private final int Dcz;
    private final int ARq;
    public int gPH;
    private float Jjg;
    private float VMm;
    private Color pOT;
    private final int wTj = 1;
    
    public VisibleComponent(final Setting var1, final ModuleComponent var2, final int var3, final int var4) {
        this.pOT = new Color(1052688, true);
        this.owS = var1;
        this.QVM = var2;
        this.tvQ = var2.NIE;
        this.LXV = var2.RYm + var2.VQk;
        this.ARq = var2.BLU;
        this.Dcz = var4;
        this.gPH = var3;
    }
    
    @Override
    public void Txe() {
        final float var1 = ClickGui.Evk;
        this.VMm = ColorUtil2.DGl(this.VMm, this.bGv ? 1.0f : 0.0f, 10.0f);
        this.Jjg = ColorUtil2.DGl(this.Jjg, 0.0f, 2.0f);
        RenderHelper.Bzy(this.tvQ, this.LXV + this.gPH + var1, this.ARq + this.tvQ, this.Dcz + this.LXV + this.gPH + var1, this.pOT.getRGB());
        float var2 = 0.0f;
        for (final String var6 : this.owS.aIm) {
            FontManager.uAe().MzK(var6, this.tvQ + 3 + var2 + this.Jjg + this.VMm + 1.0f, this.LXV + this.gPH + this.Dcz / 4.0 - 1.75 + var1, -1);
            var2 = (float)(var2 + (double) FontManager.uAe().gVe(var6) + 0.5);
        }
        FontManager.uAe().MzK(":", this.tvQ + 3 + var2 + this.Jjg + this.VMm + 1.0f, this.LXV + this.gPH + this.Dcz / 4.0 - 1.75 + var1, -1);
        FontManager.uAe().MzK(String.valueOf(this.owS.Xbo), this.tvQ + this.ARq + 1 - FontManager.uAe().gVe(String.valueOf(this.owS.Xbo)) - 5, this.LXV + this.gPH + this.Dcz / 4.0 - 1.75 + var1, new Color(16716947).getRGB());
    }
    
    @Override
    public void KsQ(final int var1) {
        this.gPH -= var1;
    }
    
    @Override
    public void oZQ(final int var1) {
        this.gPH += var1;
    }
    
    @Override
    public float aXr() {
        return (float)this.Dcz;
    }
    
    @Override
    public void kJp(final double var1, final double var3, final int var5) {
        if (this.bGv) {
            this.owS.Xbo = !this.owS.Xbo;
            this.Jjg = -1.5f;
        }
        super.kJp(var1, var3, var5);
    }
    
    @Override
    public void cPS(final int var1, final int var2) {
        final float var3 = ClickGui.Evk;
        this.LXV = this.QVM.RYm + this.QVM.VQk;
        this.tvQ = this.QVM.NIE;
        this.bGv = vtx(var1, var2, this.tvQ, this.LXV + this.gPH + var3, this.tvQ + this.ARq, this.LXV + this.Dcz + this.gPH + var3);
    }
    
    private static boolean vtx(final double var0, final double var2, final double var4, final double var6, final double var8, final double var10) {
        return var0 > var4 && var2 > var6 && var0 < var8 && var2 < var10;
    }
}
