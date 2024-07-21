// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.clickgui.components;

import ru.zvcoder.antihohol.troxill.clickgui.ClickGui;
import ru.zvcoder.antihohol.troxill.clickgui.Component;
import ru.zvcoder.antihohol.troxill.modules.Category;
import ru.zvcoder.antihohol.troxill.utils.render.RenderHelper;
import java.awt.Color;
import com.mojang.blaze3d.matrix.MatrixStack;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;
import ru.zvcoder.antihohol.troxill.modules.ModuleManager;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import ru.zvcoder.antihohol.troxill.utils.render.ColorUtil2;
import ru.zvcoder.antihohol.troxill.utils.fonts.FontManager;

public class CategoryComponent
{
    public Minecraft dMJ;
    private int EMv;
    public int gVy;
    public int VKR;
    public int nIv;
    public int Abs;
    public int Eec;
    public int Qzw;
    private float Nuj;
    public boolean NpL;
    public boolean Uwx;
    public int hCZ;
    public List<ModuleComponent> sFt;
    
    public int CAh() {
        return this.EMv;
    }
    
    public void RKD(final int var1) {
        this.EMv = var1;
    }
    
    public CategoryComponent(final int var1, final int var2, final int var3, final int var4, final int var5) {
        this.dMJ = Minecraft.getInstance();
        this.Nuj = 35.0f;
        this.sFt = new ArrayList();
        this.nIv = var1;
        this.Abs = var2;
        this.Eec = var3;
        this.Qzw = var4;
        this.hCZ = var5;
        int var6 = var2 + var4;
        for (final AbstractModule var8 : ModuleManager.modules) {
            if (var8.QKr() == var5) {
                this.sFt.add(new ModuleComponent(var1, var6, var3, var4, var8, this));
                var6 += var4;
            }
        }
    }
    
    public void mOk(final MatrixStack var1, final int var2, final int var3, final float var4) {
        this.Nuj = ColorUtil2.DGl(this.Nuj, this.NpL ? 10.0f : 35.0f, 10.0f);
        final float var5 = ClickGui.Evk;
        float var6 = (float)this.Qzw;
        if (this.NpL) {
            for (ModuleComponent var8 : this.sFt) {
                var6 += var8.VQk;
                if (var8.iXQ()) {
                    for (Component var10 : var8.dpm) {
                        var6 += var10.aXr();
                    }
                }
            }
            RenderHelper.ASa((float)(this.nIv - 2), this.Abs - 2 + var5, (float)(this.Eec + 4), var6 + 4.0f, 5, new Color(1052688).getRGB());
        }
        else {
            RenderHelper.ASa((float)(this.nIv - 2), this.Abs - 2 + var5, (float)(this.Eec + 4), (float)(this.Qzw + 4), 5, new Color(1052688).getRGB());
        }
        RenderHelper.Rii(this.nIv, (int)(this.Abs + var5), this.Eec + this.nIv, (int)(this.Qzw + this.Abs + var5), new Color(1710618).getRGB());
        float var11 = 0.0f;
        float var12 = 0.0f;
        for (final String var16 : Category.JiL(this.hCZ)) {
            var12 += (FontManager.oci().gVe(var16) + 0.5f) / 2.0f;
        }
        for (final String var16 : Category.JiL(this.hCZ)) {
            FontManager.oci().tjC(var16, this.nIv + var11 + this.Eec / 2.0f - var12, this.Abs - 2 + this.Qzw / 4.0f + var5, -1);
            var11 = (float)(var11 + (double) FontManager.oci().gVe(var16) + 0.5);
        }
        for (ModuleComponent var17 : this.sFt) {
            if (this.NpL) {
                var17.oxL(var1, var2, var3, var4);
            }
        }
        if (this.Uwx) {
            this.nIv = var2 - this.VKR;
            this.Abs = var3 - this.gVy;
        }
        int var18 = this.Abs + this.Qzw;
        for (ModuleComponent var20 : this.sFt) {
            var20.NIE = this.nIv;
            var20.RYm = var18;
            var18 += this.Qzw;
        }
    }
    
    public void bag(final int var1) {
        if (this.NpL) {
            for (ModuleComponent var3 : this.sFt) {
                var3.WKm(var1);
            }
        }
    }
    
    public void DzC(final double var1, final double var3, final int var5) {
        final float var6 = ClickGui.Evk;
        if (var5 == 0 && kUD(var1, var3, this.nIv, this.Abs + var6, this.Eec + this.nIv, this.Qzw + this.Abs + var6)) {
            this.Uwx = true;
            this.VKR = (int)(var1 - this.nIv);
            this.gVy = (int)(var3 - this.Abs);
        }
        if (var5 == 1 && kUD(var1, var3, this.nIv, this.Abs + var6, this.Eec + this.nIv, this.Qzw + this.Abs + var6)) {
            this.NpL = !this.NpL;
        }
        if (this.NpL) {
            for (ModuleComponent var8 : this.sFt) {
                var8.AJM(var1, var3, var5);
            }
        }
    }
    
    public void pHp(final double var1, final double var3, final int var5) {
        this.Uwx = false;
        if (this.NpL) {
            for ( ModuleComponent var7 : this.sFt) {
                var7.Jmx(var1, var3, var5);
            }
        }
    }
    
    public static boolean kUD(final double var0, final double var2, final double var4, final double var6, final double var8, final double var10) {
        return var0 > var4 && var2 > var6 && var0 < var8 && var2 < var10;
    }
    
    public static boolean lMP(final double var0, final double var2, final int var4, final int var5, final int var6, final int var7) {
        return var0 > var4 && var2 > var5 && var0 < var6 && var2 < var7;
    }
}
