// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.clickgui.components;

import net.minecraft.util.math.MathHelper;
import ru.zvcoder.antihohol.troxill.clickgui.Component;
import ru.zvcoder.antihohol.troxill.clickgui.settings.Setting;
import ru.zvcoder.antihohol.troxill.utils.render.RenderHelper;
import net.minecraft.client.Minecraft;
import ru.zvcoder.antihohol.troxill.utils.render.ColorUtils;
import ru.zvcoder.antihohol.troxill.utils.fonts.FontManager;

import java.awt.Color;

public class ColorComponent extends Component
{
    Setting bjr;
    ModuleComponent AgG;
    int lrr;
    int BHu;
    int TkF;
    int zkY;
    int Dpy;
    float[] mNT;
    float ZXI;
    float jFv;
    float XBs;
    boolean igo;
    boolean dlw;
    boolean UbH;
    boolean dtL;
    
    public ColorComponent(final Setting var1, final ModuleComponent var2, final int var3, final int var4) {
        this.dlw = false;
        this.UbH = false;
        this.dtL = false;
        this.bjr = var1;
        this.AgG = var2;
        this.lrr = var2.NIE;
        this.BHu = var2.RYm + var2.VQk;
        this.zkY = var2.BLU;
        this.TkF = var4;
        this.Dpy = var3;
    }
    
    @Override
    public void Txe() {
        this.dtL = true;
    }
    
    @Override
    public void pmJ(final double var1, final double var3, final int var5) {
        this.UbH = false;
        this.dlw = false;
    }
    
    @Override
    public void KsQ(final int var1) {
        this.Dpy -= var1;
    }
    
    @Override
    public void oZQ(final int var1) {
        this.Dpy += var1;
    }
    
    @Override
    public float aXr() {
        return (float)this.TkF;
    }
    
    @Override
    public void kJp(final double var1, final double var3, final int var5) {
        if (this.igo) {
            this.dlw = true;
            this.UbH = true;
        }
        float var6 = 0.0f;
        for (final String var10 : this.bjr.aIm) {
            var6 += FontManager.Bbk().gVe(var10) + 0.5f;
        }
        if (xAK(var1, var3, this.lrr + 8 + var6, (float)(this.BHu + this.Dpy + 5), this.lrr + 12 + var6, (float)(this.BHu + this.Dpy + 10))) {
            this.dtL = !this.dtL;
            if (this.dtL) {
                this.TkF += 12;
            }
            else {
                this.TkF -= 12;
            }
            this.IQU();
        }
        super.kJp(var1, var3, var5);
    }
    
    private void IQU() {
        boolean var1 = false;
        final byte var2 = 12;
        for (final ModuleComponent var4 : this.AgG.RUG.sFt) {
            if (this.dtL) {
                if (var1) {
                    final ModuleComponent ugi = var4;
                    ugi.OBM += var2;
                }
                for (final Component var6 : var4.dpm) {
                    if (!var1) {
                        var1 = (var6 == this);
                    }
                    else {
                        var6.oZQ(var2);
                    }
                }
            }
            else {
                if (var1) {
                    final ModuleComponent ugi2 = var4;
                    ugi2.OBM -= var2;
                }
                for (final Component var6 : var4.dpm) {
                    if (!var1) {
                        var1 = (var6 == this);
                    }
                    else {
                        var6.KsQ(var2);
                    }
                }
            }
        }
    }
    
    public static int UQH(final int var0) {
        return ColorUtils.nqm(new Color(var0).getRGB(), (float)(Minecraft.getInstance().getWindow().getGuiScale() * 255.0));
    }
    
    @Override
    public void cPS(final int var1, final int var2) {
        this.BHu = this.AgG.RYm + this.AgG.VQk;
        this.lrr = this.AgG.NIE;
        this.igo = MhJ(var1, var2, this.lrr + 1, this.BHu + this.Dpy + 14, this.lrr + this.zkY - 5, this.BHu + 7 + this.Dpy + 15);
        if (this.dtL) {
            final float var3 = (float)(this.BHu + 10);
            RenderHelper.oZN(this.lrr + 4, var3 + 2.0f, this.lrr + 4 + 142, var3 + 2.0f + 60.0f - 10.0f, UQH(new Color(Color.HSBtoRGB(this.ZXI, 1.0f, 1.0f)).getRGB()), UQH(Color.BLACK.getRGB()), UQH(new Color(255, 255, 255, 255).getRGB()), UQH(new Color(Color.HSBtoRGB(this.ZXI, 1.0f, 1.0f)).getRGB()));
            for (int var4 = 0; var4 <= 142; ++var4) {
                RenderHelper.NQP(this.lrr + 4 + var4, var3 + 55.0f, this.lrr + 4 + 1.0f, var3 + 58.0f, UQH(Color.HSBtoRGB(var4 / 142.0f, 1.0f, 1.0f)));
            }
            if (this.dlw) {
                final float var5 = (float)MathHelper.clamp(var1, this.lrr, this.lrr + 148);
                this.ZXI = (var5 - (this.lrr + 4)) / 142.0f;
                this.bjr.nAX = new Color(Color.HSBtoRGB(this.ZXI, 1.0f - this.jFv, this.XBs));
            }
            RenderHelper.NQP(this.lrr + 4 + this.ZXI * 142.0f, var3 + 60.0f - 5.0f, this.lrr + 4 + this.ZXI * 142.0f + 1.0f, var3 + 60.0f - 5.0f + 3.0f, new Color(255, 255, 255, 255).getRGB());
            if (this.UbH) {
                float var5 = (var2 - (var3 + 2.0f)) / 50.0f;
                var5 = MathHelper.clamp(var5, 0.0f, 1.0f);
                float var6 = (var1 - (this.lrr + 4)) / 142.0f;
                var6 = MathHelper.clamp(var6, 0.0f, 1.0f);
                this.XBs = var6;
                this.jFv = 1.0f - var5;
                this.bjr.nAX = new Color(Color.HSBtoRGB(this.ZXI, var5, var6));
            }
        }
    }
    
    public static int NOT(final int var0, final int var1) {
        final float[] var2 = Color.RGBtoHSB(var0 >> 16 & 0xFF, var0 >> 8 & 0xFF, var0 & 0xFF, null);
        final float var3 = var2[0];
        for (int var4 = 0; var4 < var1; ++var4) {
            final float var5 = var4 / (float)var1;
            if (Math.abs(var5 - var3) < 0.01) {
                return var4;
            }
        }
        return -1;
    }
    
    private static boolean MhJ(final double var0, final double var2, final int var4, final int var5, final int var6, final int var7) {
        return var0 > var4 && var2 > var5 && var0 < var6 && var2 < var7;
    }
    
    private static boolean xAK(final double var0, final double var2, final float var4, final float var5, final float var6, final float var7) {
        return var0 > var4 && var2 > var5 && var0 < var6 && var2 < var7;
    }
}
