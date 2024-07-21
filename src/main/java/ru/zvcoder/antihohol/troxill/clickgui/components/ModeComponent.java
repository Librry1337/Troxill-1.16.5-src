/*
 * Decompiled with CFR 0.152.
 */
package ru.zvcoder.antihohol.troxill.clickgui.components;

import java.awt.Color;

import ru.zvcoder.antihohol.troxill.clickgui.ClickGui;
import ru.zvcoder.antihohol.troxill.clickgui.Component;
import ru.zvcoder.antihohol.troxill.clickgui.settings.Setting;
import ru.zvcoder.antihohol.troxill.utils.render.ColorUtil2;
import ru.zvcoder.antihohol.troxill.utils.render.RenderHelper;
import ru.zvcoder.antihohol.troxill.modules.ModuleManager;
import ru.zvcoder.antihohol.troxill.utils.fonts.FontManager;

public class ModeComponent
        extends Component {
    private boolean Vpj;
    private final Setting qEZ;
    private final ModuleComponent Cym;
    private int ceA;
    private int CTz;
    private final int nSH;
    private final int TGl;
    public int Qnb;
    private float JDz;
    private float QFc;
    private Color Fxo = new Color(0x101010, true);
    private final int acb = 2;

    public ModeComponent(Setting var1, ModuleComponent var2, int var3, int var4) {
        this.qEZ = var1;
        this.Cym = var2;
        this.ceA = var2.NIE;
        this.CTz = var2.RYm + var2.VQk;
        this.TGl = var2.BLU;
        this.nSH = var4;
        this.Qnb = var3;
    }

    @Override
    public void Txe() {
        this.QFc = ColorUtil2.DGl(this.QFc, this.Vpj ? 1.0f : 0.0f, 10.0f);
        this.JDz = ColorUtil2.DGl(this.JDz, 0.0f, 2.0f);
        float var1 = ClickGui.Evk;
        RenderHelper.Rii(this.ceA, (int)((float)(this.CTz + this.Qnb) + var1), this.TGl + this.ceA, (int)((float)(this.nSH + this.CTz + this.Qnb) + var1), this.Fxo.getRGB());
        float var2 = 0.0f;
        for (String var6 : this.qEZ.aIm) {
            FontManager.uAe().MzK(var6, (float)(this.ceA + 3) + var2 + this.JDz + this.QFc + 2.0f, (double)(this.CTz + this.Qnb) + (double)this.nSH / 4.0 - 1.75 + (double)var1, -1);
            var2 = (float)((double)var2 + (double) FontManager.uAe().gVe(var6) + 0.5);
        }
        FontManager.uAe().MzK(": 123", (float)(this.ceA + 3) + var2 + this.JDz + this.QFc + 2.0f, (double)(this.CTz + this.Qnb) + (double)this.nSH / 4.0 - 1.75, -1);
        var2 = (float)((double)var2 + (double) FontManager.uAe().gVe(": ") + 0.5);
        for (String var6 : (String[])this.qEZ.WJb.get(this.qEZ.hCJ)) {
            FontManager.uAe().MzK(var6, (float)(this.ceA + 3) + var2 + this.JDz + this.QFc + 2.0f, (double)(this.CTz + this.Qnb) + (double)this.nSH / 4.0 - 1.45 + (double)var1, new Color(16711863).getRGB());
            var2 = (float)((double)var2 + (double) FontManager.uAe().gVe(var6) + 0.5);
        }
    }

    @Override
    public void KsQ(int var1) {
        this.Qnb -= var1;
    }

    @Override
    public void oZQ(int var1) {
        this.Qnb += var1;
    }

    @Override
    public float aXr() {
        return this.nSH;
    }

    @Override
    public void kJp(double var1, double var3, int var5) {
        if (this.Vpj) {
            this.qEZ.hCJ = (this.qEZ.hCJ + 1) % this.qEZ.WJb.size();
            this.JDz = -1.5f;
            ModuleManager.mmH(this.qEZ);
        }
        super.kJp(var1, var3, var5);
    }

    @Override
    public void cPS(int var1, int var2) {
        float var3 = ClickGui.Evk;
        this.CTz = this.Cym.RYm + this.Cym.VQk;
        this.ceA = this.Cym.NIE;
        this.Vpj = ModeComponent.uwl(var1, var2, this.ceA, (float)(this.CTz + this.Qnb) + var3, this.ceA + this.TGl, (float)(this.CTz + this.nSH + this.Qnb) + var3);
    }

    private static boolean uwl(double var0, double var2, double var4, double var6, double var8, double var10) {
        return var0 > var4 && var2 > var6 && var0 < var8 && var2 < var10;
    }
}

