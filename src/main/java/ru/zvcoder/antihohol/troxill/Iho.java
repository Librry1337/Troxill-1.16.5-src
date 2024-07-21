// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill;

import ru.zvcoder.antihohol.troxill.clickgui.Component;
import ru.zvcoder.antihohol.troxill.clickgui.components.ModuleComponent;
import ru.zvcoder.antihohol.troxill.clickgui.settings.Setting;
import ru.zvcoder.antihohol.troxill.utils.render.ColorUtil2;
import ru.zvcoder.antihohol.troxill.utils.render.RenderHelper;
import ru.zvcoder.antihohol.troxill.utils.fonts.FontManager;

import java.awt.Color;

public class Iho extends Component
{
    private boolean OuC;
    private final Setting nSo;
    private final ModuleComponent mBp;
    private int Aak;
    private int SYg;
    private final float tDw;
    private final int dRZ;
    public int Ffw;
    private float bgf;
    private float eHw;
    private float eJI;
    private final float usV;
    private Color Gfo;
    private final int FQh = 2;
    
    public Iho(final Setting var1, final ModuleComponent var2, final int var3, final int var4) {
        this.Gfo = new Color(1052688, true);
        this.nSo = var1;
        this.mBp = var2;
        this.Aak = var2.NIE;
        this.SYg = var2.RYm + var2.VQk;
        this.dRZ = var2.BLU;
        this.tDw = (float)var4;
        this.Ffw = var3;
        this.usV = (float)var4;
    }
    
    @Override
    public void Txe() {
        this.eJI = ColorUtil2.DGl(this.eJI, this.OuC ? 1.0f : 0.0f, 10.0f);
        this.eHw = ColorUtil2.DGl(this.eHw, 0.0f, 2.0f);
        RenderHelper.Bzy(this.Aak, this.SYg + this.Ffw, this.dRZ + this.Aak, this.tDw + this.SYg + this.Ffw, this.Gfo.getRGB());
        float var1 = 0.0f;
        for (final String var5 : this.nSo.aIm) {
            FontManager.awW().MzK(var5, this.Aak + 3 + var1 + this.eHw + this.eJI + 2.0f, this.SYg + this.Ffw + this.tDw / 4.0, -1);
            var1 = (float)(var1 + (double) FontManager.awW().gVe(var5) + 0.5);
        }
        var1 += 0.5;

        this.bgf = ColorUtil2.DGl(this.bgf, this.nSo.Xbo ? var1 : 0.0f, 10.0f);
        RenderHelper.Bzy(this.Aak + 4 + 2, this.SYg + this.Ffw + this.tDw - 2.0f, this.Aak + 4 + this.bgf + 2.0f, this.SYg + this.Ffw + this.tDw - 1.0f, 16711817);
    }
    
    @Override
    public void KsQ(final int var1) {
        this.Ffw -= var1;
    }
    
    @Override
    public void oZQ(final int var1) {
        this.Ffw += var1;
    }
    
    @Override
    public float aXr() {
        return this.tDw;
    }
    
    public float XZe() {
        return this.usV;
    }
    
    @Override
    public void kJp(final double var1, final double var3, final int var5) {
        if (this.OuC) {
            this.nSo.Xbo = !this.nSo.Xbo;
            this.eHw = -1.5f;
        }
        super.kJp(var1, var3, var5);
    }
    
    @Override
    public void cPS(final int var1, final int var2) {
        this.SYg = this.mBp.RYm + this.mBp.VQk;
        this.Aak = this.mBp.NIE;
        this.OuC = FBB(var1, var2, (float)this.Aak, (float)(this.SYg + this.Ffw), (float)(this.Aak + this.dRZ), this.SYg + this.tDw + this.Ffw);
    }
    
    private static boolean FBB(final double var0, final double var2, final float var4, final float var5, final float var6, final float var7) {
        System.out.println(var0);
        return var0 > var4 && var2 > var5 && var0 < var6 && var2 < var7;
    }
}
