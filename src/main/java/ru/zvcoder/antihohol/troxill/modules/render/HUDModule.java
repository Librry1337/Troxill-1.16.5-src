/*
 * Decompiled with CFR 0.152.
 */
package ru.zvcoder.antihohol.troxill.modules.render;

import java.awt.Color;
import java.util.Iterator;
import ru.zvcoder.antihohol.troxill.events.MouseEvent;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;
import ru.zvcoder.antihohol.troxill.modules.ModuleManager;
import ru.zvcoder.antihohol.troxill.utils.fonts.FontManager;
import ru.zvcoder.antihohol.troxill.hooks.RenderHOOK;
import ru.zvcoder.antihohol.troxill.utils.render.ColorUtils;
import ru.zvcoder.antihohol.troxill.utils.render.RenderHelper;
import ru.zvcoder.antihohol.troxill.utils.render.WidthHeightHelper;
import ru.zvcoder.antihohol.troxill.utils.render.ColorUtil2;

public class HUDModule
        extends AbstractModule {
    public static double Psf = 0.0;
    public static double jrY = 0.0;
    private double iGH = 4.0;
    private double pSV = 4.0;
    private double omi;
    private double QjH;
    private boolean BLg;

    public HUDModule(int var1, String[] var2, int var3, int var4) {
        super(var1, var2, var3, var4);
    }

    private void pkq() {
        float var1 = 0.0f;
        Iterator var2 = ModuleManager.TYZ().iterator();
        while (var2.hasNext()) {
            AbstractModule var3 = (AbstractModule)var2.next();
            float var4 = 0.0f;
            if (!var3.inu() || !ModuleManager.SBG((AbstractModule)var3, (int)-1).Xbo) continue;
            if (FontManager.Bbk() != null) {
                Color var5 = new Color(ColorUtils.KSH(new Color(16711835), new Color(40447), var1 / 1.2f));
                float var6 = var3.eRz() + 6.5f;
                if (Psf < (double)var6 + 9.5) {
                    Psf = (double)var6 + 9.5;
                }
                RenderHelper.ASa((float)(this.iGH + (double)var3.STf), (float)(this.pSV + (double)var1), var6, 14.0f, 5, new Color(0).getRGB());
                RenderHelper.Bzy(this.iGH + (double)var3.STf, this.pSV + (double)var1 + 1.5, this.iGH + (double)var3.STf + 1.5, this.pSV + 14.0 + (double)var1, var5.getRGB());
                var1 += 13.0f;
                for (String var10 : var3.HXs()) {
                    FontManager.Bbk().MzK(var10, this.iGH + 2.0 + (double)var4 + (double)var3.STf, this.pSV + (double)var1 - 10.25, -1);
                    var4 = (float)((double)var4 + (double) FontManager.Bbk().gVe(var10) + 0.3);
                }
                if (jrY < (double)(var1 + 4.0f)) {
                    jrY = var1 + 4.0f;
                }
            }
            var3.STf = ColorUtil2.DGl(var3.STf, 7.0f, 10.0f);
        }
        return;
    }

    @Override
    public void onMouse(MouseEvent var1) {
        double var2 = WidthHeightHelper.sug();
        double var4 = WidthHeightHelper.HLX();
        if (var1.Lfk == 0 && HUDModule.fvU(var2, var4, this.iGH + 3.0, this.pSV - 3.0, Psf + this.iGH, jrY + this.pSV)) {
            this.BLg = true;
            this.omi = var2 - this.iGH;
            this.QjH = var4 - this.pSV;
        }
        if (var1.Lfk == 0 && var1.Dan == 0) {
            this.BLg = false;
        }
    }

    @Override
    public void onEnable() {
        double var1 = WidthHeightHelper.sug();
        double var3 = WidthHeightHelper.HLX();
        if (this.BLg) {
            this.iGH = ColorUtil2.UAv(this.iGH, var1 - this.omi, 10.0);
            this.pSV = ColorUtil2.UAv(this.pSV, var3 - this.QjH, 10.0);
        }
    }

    @Override
    public void onRender(RenderHOOK var1) {
        if (!StreamBypassModule.ufx.inu()) {
            if (!var1.jFA()) {
                this.pkq();
            }
        } else if (var1.jFA()) {
            this.pkq();
        }
    }

    public static boolean fvU(double var0, double var2, double var4, double var6, double var8, double var10) {
        return var0 > var4 && var2 > var6 && var0 < var8 && var2 < var10;
    }
}

