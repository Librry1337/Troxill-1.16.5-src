// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.clickgui.expandble;

import ru.zvcoder.antihohol.troxill.clickgui.Component;
import ru.zvcoder.antihohol.troxill.clickgui.settings.Setting;
import ru.zvcoder.antihohol.troxill.clickgui.components.ModuleComponent;
import ru.zvcoder.antihohol.troxill.utils.render.ColorUtil2;
import ru.zvcoder.antihohol.troxill.utils.render.RenderHelper;
import ru.zvcoder.antihohol.troxill.utils.fonts.FontManager;

import java.awt.Color;

public class BlueExtend extends Component
{
    private boolean tai;
    private final Setting Prc;
    private final ModuleComponent QZe;
    private int qrB;
    private int ADy;
    private final int IZu;
    private final int Jei;
    public int bZy;
    private float MoV;
    private float MhP;
    private Color RVE;
    private final int JaD = 2;
    Color INT;
    
    public BlueExtend(final Setting var1, final ModuleComponent var2, final int var3, final int var4) {
        this.RVE = new Color(1052688, true);
        this.INT = new Color(255);
        this.Prc = var1;
        this.QZe = var2;
        this.qrB = var2.NIE;
        this.ADy = var2.RYm + var2.VQk;
        this.Jei = var2.BLU;
        this.IZu = var4;
        this.bZy = var3;
    }
    
    @Override
    public void Txe() {
        this.MhP = ColorUtil2.DGl(this.MhP, this.tai ? 1.0f : 0.0f, 10.0f);
        this.MoV = ColorUtil2.DGl(this.MoV, 0.0f, 2.0f);
        RenderHelper.Rii(this.qrB, this.ADy + this.bZy, this.Jei + this.qrB, this.IZu + this.ADy + this.bZy, this.RVE.getRGB());
        float var1 = 0.0f;
        for (final String var5 : this.Prc.aIm) {
            FontManager.awW().MzK(var5, this.qrB + 3 + var1 + this.MoV + this.MhP + 2.0f, this.ADy + this.bZy + this.IZu / 4.0, -1);
            var1 = (float)(var1 + (double) FontManager.awW().gVe(var5) + 0.5);
        }
        for (int var6 = 0; var6 < 5; ++var6) {
            RenderHelper.ASa(this.qrB + var1 + 9.3f + this.MoV + this.MhP, this.ADy + this.bZy + 5.1f, 4.6f, 4.6f, 3, -1);
        }
        this.INT = ColorUtil2.OzI(this.INT, this.Prc.Xbo ? new Color(14745767) : new Color(16711680), 0.05f);
        RenderHelper.ASa(this.qrB + var1 + 9.0f + this.MoV + this.MhP, this.ADy + this.bZy + 4.8f, 6.0f, 6.0f, 3, this.INT.getRGB());
    }
    
    @Override
    public void KsQ(final int var1) {
        this.bZy -= var1;
    }
    
    @Override
    public void oZQ(final int var1) {
        this.bZy += var1;
    }
    
    @Override
    public float aXr() {
        return (float)this.IZu;
    }
    
    @Override
    public void kJp(final double var1, final double var3, final int var5) {
        if (this.tai) {
            this.Prc.Xbo = !this.Prc.Xbo;
            this.MoV = -1.5f;
        }
        super.kJp(var1, var3, var5);
    }
    
    @Override
    public void cPS(final int var1, final int var2) {
        this.ADy = this.QZe.RYm + this.QZe.VQk;
        this.qrB = this.QZe.NIE;
        this.tai = owu(var1, var2, this.qrB, this.ADy + this.bZy, this.qrB + this.Jei, this.ADy + this.IZu + this.bZy);
    }
    
    private static boolean owu(final double var0, final double var2, final int var4, final int var5, final int var6, final int var7) {
        return var0 > var4 && var2 > var5 && var0 < var6 && var2 < var7;
    }
}
