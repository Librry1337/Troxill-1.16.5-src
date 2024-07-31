// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.clickgui.components;


import ru.zvcoder.antihohol.troxill.clickgui.ClickGui;
import ru.zvcoder.antihohol.troxill.clickgui.Component;
import ru.zvcoder.antihohol.troxill.clickgui.settings.Setting;
import ru.zvcoder.antihohol.troxill.clickgui.expandble.BlueExtend;
import ru.zvcoder.antihohol.troxill.utils.render.ColorUtil2;
import ru.zvcoder.antihohol.troxill.utils.render.RenderHelper;
import com.mojang.blaze3d.matrix.MatrixStack;
import ru.zvcoder.antihohol.troxill.modules.ModuleManager;
import java.util.ArrayList;
import java.awt.Color;
import java.util.List;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;
import ru.zvcoder.antihohol.troxill.utils.fonts.FontManager;

public class ModuleComponent
{
    public float OBM;
    public int NIE;
    public int RYm;
    public int BLU;
    public int VQk;
    public AbstractModule xKC;
    public CategoryComponent RUG;
    private boolean CHW;
    private float zLU;
    private boolean qdR;
    public final List<Component>  dpm;
    double VLN;
    float VOS;
    private Color XQa;
    
    public ModuleComponent(final int var1, final int var2, final int var3, final int var4, final AbstractModule var5, final CategoryComponent var6) {
        this.OBM = 0.0f;
        this.dpm = new ArrayList();
        this.XQa = new Color(-13421773, true);
        this.NIE = var1;
        this.RYm = var2;
        this.BLU = var3;
        this.VQk = var4;
        this.xKC = var5;
        this.RUG = var6;
        int var7 = 0;
        for (Setting var9 : ModuleManager.osP(var5)) {
            if (var9.BRc()) {

                if (var9.EJg()) {
                    this.dpm.add(new VisibleComponent(var9, this, var7, 15));
                }
                if (var9.uvD()) {
                    this.dpm.add(new BlueExtend(var9, this, var7, 15));
                }
                var7 += 15;
            }
            if (var9.PlK()) {
                this.dpm.add(new KeyBindComponent(var9, this, var7, 15));
                var7 += 15;
            }
            if (var9.jjc()) {
                this.dpm.add(new SliderComponent(var9, this, var7, 15));
                var7 += 15;
            }
            if (var9.xhi()) {
                this.dpm.add(new ModeComponent(var9, this, var7, 15));
                var7 += 15;
            }
            if (var9.STF()) {
                this.dpm.add(new ColorComponent(var9, this, var7, 15));
                var7 += 15;
            }
        }
    }
    
    private Color KmH(final Color var1) {
        return new Color(var1.getRed(), var1.getBlue(), var1.getGreen(), var1.getAlpha() / 2);
    }
    
    public void oxL(final MatrixStack var1, final int var2, final int var3, final float var4) {
        this.VOS = ColorUtil2.DGl(this.VOS, 0.0f, 2.0f);
        final float var5 = ClickGui.Evk;
        this.qdR = JfU(var2, var3, (float)this.NIE, this.RYm + this.OBM + var5, (float)(this.BLU + this.NIE), this.VQk + this.RYm + this.OBM + var5);
        this.XQa = ColorUtil2.OzI(this.XQa, this.xKC.inu() ? new Color(-7602046, true) : (this.qdR ? new Color(-10790053, true) : new Color(-14277082, true)), 0.025f);
        RenderHelper.Bzy(this.NIE, this.RYm + this.OBM + var5, this.BLU + this.NIE, this.VQk + this.RYm + this.OBM + var5, new Color(1052688).getRGB());
        float var6 = 0.0f;
        for (final Component var8 : this.dpm) {
            var6 += var8.aXr();
        }
        if (this.CHW) {
            RenderHelper.Bzy(this.NIE + 1, this.RYm + this.OBM + 2.0f + var5, this.BLU + this.NIE - 1, this.VQk + this.RYm + this.OBM + var6 - 1.0f + var5, new Color(0).getRGB());
        }
        else {
            RenderHelper.Bzy(this.NIE + 1, this.RYm + this.OBM + 2.0f + var5, this.BLU + this.NIE - 1, this.VQk + this.RYm + this.OBM - 1.0f + var5, new Color(0).getRGB());
        }
        RenderHelper.Bzy(this.NIE + 2, this.RYm + this.OBM + 2.0f + var5, this.BLU + this.NIE - 2, this.VQk + this.RYm + this.OBM - 2.0f + var5, this.XQa.getRGB());
        float var9 = 0.0f;
        this.zLU = ColorUtil2.DGl(this.zLU, this.qdR ? 1.0f : 0.0f, 10.0f);
        for (final String var13 : this.xKC.HXs()) {
            FontManager.LWJ().MzK(var13, this.NIE + 3 + this.zLU + this.VOS + var9, this.RYm + this.VQk / 4.0 + this.OBM - 0.5 + var5, -1);
            var9 += FontManager.LWJ().gVe(var13) + 0.5f;
        }
        this.VLN = ColorUtil2.UAv(this.VLN, this.CHW ? 90.0 : 0.0, 10.0);
        RenderHelper.Rkd(this.NIE + this.BLU - 7.5f, this.RYm + 8.5f - (this.CHW ? 1 : 0) + this.OBM + var5, 2.5f, 180.0f + (float)this.VLN, this.CHW ? RenderHelper.SCc(20, 1.0f, 1.0f).getRGB() : -1, this.CHW ? 2.2f : 2.0f);
        if (this.CHW) {
            RenderHelper.Bzy(this.NIE + 2, this.RYm + this.OBM - 2.0f + this.VQk + var5, this.BLU + this.NIE - 2, this.VQk + this.RYm + this.OBM - 2.0f + var6 + var5, new Color(1710618).getRGB());
            for (final Component var15 : this.dpm) {
                var15.cPS(var2, var3);
                var15.Txe();
            }
        }
    }
    
    private void qYP() {
        boolean var1 = false;
        int var2 = 0;
        for (final Component var4 : this.dpm) {
            var2 += (int)var4.aXr();
        }
        for (final ModuleComponent var5 : this.RUG.sFt) {
            if (var1) {
                if (this.CHW) {
                    final ModuleComponent ugi = var5;
                    ugi.OBM += var2;
                    for (final Component var7 : var5.dpm) {
                        var7.oZQ(var2);
                    }
                }
                else {
                    final ModuleComponent ugi2 = var5;
                    ugi2.OBM -= var2;
                    for (final Component var7 : var5.dpm) {
                        var7.KsQ(var2);
                    }
                }
            }
            else {
                var1 = (var5 == this);
            }
        }
    }
    
    public void AJM(final double var1, final double var3, final int var5) {
        if (this.CHW) {
            for (final Component var7 : this.dpm) {
                var7.kJp(var1, var3, var5);
            }
        }
        if (this.qdR) {
            this.VOS = -1.5f;
            if (var5 == 1) {
                this.CHW = !this.CHW;
                this.qYP();
            }
            if (var5 == 0 && this.RUG.NpL) {
                this.xKC.geu();
            }
        }
    }
    
    public void Jmx(final double var1, final double var3, final int var5) {
        if (this.CHW) {
            for (final Component var7 : this.dpm) {
                var7.pmJ(var1, var3, var5);
            }
        }
    }
    
    public void WKm(final int var1) {
        if (this.CHW) {
            for (final Component var3 : this.dpm) {
                var3.KSe(var1);
            }
        }
    }
    
    public boolean iXQ() {
        return this.CHW;
    }
    
    public static boolean JfU(final double var0, final double var2, final float var4, final float var5, final float var6, final float var7) {
        return var0 > var4 && var2 > var5 && var0 < var6 && var2 < var7;
    }
}
