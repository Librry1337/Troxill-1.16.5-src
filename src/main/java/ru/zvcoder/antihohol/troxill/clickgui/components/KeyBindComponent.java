// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.clickgui.components;

import ru.zvcoder.antihohol.troxill.clickgui.settings.KeyBind;
import ru.zvcoder.antihohol.troxill.clickgui.settings.KeyBindManager;
import ru.zvcoder.antihohol.troxill.clickgui.ClickGui;
import ru.zvcoder.antihohol.troxill.clickgui.Component;
import ru.zvcoder.antihohol.troxill.clickgui.settings.Setting;
import ru.zvcoder.antihohol.troxill.utils.render.ColorUtil2;
import ru.zvcoder.antihohol.troxill.utils.render.RenderHelper;
import ru.zvcoder.antihohol.troxill.utils.fonts.FontManager;

import java.awt.Color;

public class KeyBindComponent extends Component
{
    private boolean fua;
    private final Setting ZNm;
    private final ModuleComponent IvX;
    private int Pon;
    private int lYe;
    private float xoB;
    private final float qOE;
    private final int ONT;
    public int ZTJ;
    private float Llj;
    private float JVE;
    private Color eEC;
    private boolean TTq;
    private final String[] uwO;
    private final String[] GuM;
    private final int krM = 2;
    
    public KeyBindComponent(final Setting var1, final ModuleComponent var2, final int var3, final int var4) {
        this.eEC = new Color(1052688, true);
        this.uwO = new String[] { "Bi", "nd", ": " };
        this.GuM = new String[] { "Bi", "nd", "in", "g", ".." };
        this.ZNm = var1;
        this.IvX = var2;
        this.Pon = var2.NIE;
        this.lYe = var2.RYm + var2.VQk;
        this.ONT = var2.BLU;
        this.xoB = (float)var4;
        this.ZTJ = var3;
        this.qOE = (float)var4;
    }
    
    @Override
    public void Txe() {
        final float var1 = ClickGui.Evk;
        RenderHelper.Bzy(this.Pon, this.lYe + this.ZTJ + var1, this.ONT + this.Pon, this.xoB + this.lYe + this.ZTJ + var1, this.eEC.getRGB());
        float var2 = 0.0f;
        this.Llj = ColorUtil2.DGl(this.Llj, this.fua ? 1.0f : 0.0f, 10.0f);
        this.JVE = ColorUtil2.DGl(this.JVE, 0.0f, 2.0f);
        if (this.TTq) {
            for (final String var6 : this.GuM) {
                FontManager.uAe().MzK(var6, this.Pon + 2 + var2 + this.Llj + this.JVE + 2.0f, this.lYe + this.xoB / 4.0 + this.ZTJ - 1.0 + var1, -1);
                var2 = (float)(var2 + (double) FontManager.uAe().gVe(var6) + 0.5);
            }
        }
        else {
            for (final String var6 : this.uwO) {
                FontManager.uAe().MzK(var6, this.Pon + 2 + var2 + this.Llj + this.JVE + 2.0f, this.lYe + this.xoB / 4.0 + this.ZTJ - 1.0 + var1, -1);
                var2 = (float)(var2 + (double) FontManager.uAe().gVe(var6) + 0.5);
            }
            if (this.IvX.xKC.Osr() != 0 && this.IvX.xKC.Osr() != -1) {
                if (KeyBindManager.FQx[this.IvX.xKC.Osr()] != null) {
                    final KeyBind var7 = KeyBindManager.FQx[this.IvX.xKC.Osr()];
                    if (var7.oGI() != null) {
                        FontManager.uAe().MzK(var7.oGI(), this.Pon + this.ONT - FontManager.uAe().gVe(var7.oGI()) - 5.0f, this.lYe + this.xoB / 4.0 + this.ZTJ - 1.0 + var1, new Color(16711863).getRGB());
                    }
                    else if (var7.FTv() != null) {
                        float var8 = 0.0f;
                        for (final String var12 : var7.FTv()) {
                            var8 = (float)(var8 + (double) FontManager.uAe().gVe(var12) + 0.5);
                        }
                        var2 = 0.0f;
                        for (final String var12 : var7.FTv()) {
                            FontManager.uAe().MzK(var12, this.Pon + this.ONT - var8 + var2 - 5.0f, this.lYe + this.xoB / 4.0 + this.ZTJ - 1.0 + var1, new Color(16711863).getRGB());
                            var2 = (float)(var2 + (double) FontManager.uAe().gVe(var12) + 0.5);
                        }
                    }
                    else {
                        FontManager.uAe().MzK("?", this.Pon + this.ONT - FontManager.uAe().gVe("?") + var2 - 5.0f, this.lYe + this.xoB / 4.0 + this.ZTJ - 1.0 + var1, new Color(16711863).getRGB());
                    }
                }
            }
            else {
                FontManager.uAe().MzK("null", this.Pon + this.ONT - FontManager.uAe().gVe("null") - 5.0f, this.lYe + this.xoB / 4.0 + this.ZTJ - 1.0 + var1, new Color(16711863).getRGB());
            }
        }
    }
    
    public KeyBindComponent Jsu(final float var1) {
        this.xoB = var1;
        return this;
    }
    
    @Override
    public void KsQ(final int var1) {
        this.ZTJ -= var1;
    }
    
    @Override
    public void oZQ(final int var1) {
        this.ZTJ += var1;
    }
    
    @Override
    public float aXr() {
        return this.xoB;
    }
    
    public float xKT() {
        return this.qOE;
    }
    
    @Override
    public void kJp(final double var1, final double var3, final int var5) {
        if (this.fua) {
            this.TTq = !this.TTq;
            this.JVE = -1.5f;
        }
    }
    
    @Override
    public void KSe(final int var1) {
        if (this.TTq) {
            if (var1 != 261 && var1 != 256) {
                this.IvX.xKC.Bgy(var1);
            }
            else {
                this.IvX.xKC.Bgy(0);
            }
            this.TTq = !this.TTq;
        }
        super.KSe(var1);
    }
    
    @Override
    public void cPS(final int var1, final int var2) {
        final float var3 = ClickGui.Evk;
        this.lYe = this.IvX.RYm + this.IvX.VQk;
        this.Pon = this.IvX.NIE;
        this.fua = qdK(var1, var2, (float)this.Pon, this.lYe + this.ZTJ + var3, (float)(this.Pon + this.ONT), this.lYe + this.xoB + this.ZTJ + var3);
    }
    
    private static boolean qdK(final double var0, final double var2, final float var4, final float var5, final float var6, final float var7) {
        return var0 > var4 && var2 > var5 && var0 < var6 && var2 < var7;
    }
}
