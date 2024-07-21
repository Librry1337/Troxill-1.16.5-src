// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.clickgui.components;

import ru.zvcoder.antihohol.troxill.clickgui.ClickGui;
import ru.zvcoder.antihohol.troxill.clickgui.Component;
import ru.zvcoder.antihohol.troxill.clickgui.settings.Setting;
import ru.zvcoder.antihohol.troxill.clickgui.Animation;
import ru.zvcoder.antihohol.troxill.clickgui.AnimationImpl;
import ru.zvcoder.antihohol.troxill.utils.render.ColorUtil2;
import ru.zvcoder.antihohol.troxill.utils.render.RenderHelper;
import ru.zvcoder.antihohol.troxill.utils.fonts.FontManager;

import java.awt.Color;

public class SliderComponent extends Component
{
    private final Setting KbE;
    private int PGw;
    private int aaK;
    private int COq;
    private final int bQW;
    private final int AJD;
    private boolean RzB;
    private boolean SGB;
    private float BnI;
    private float Kld;
    private final ModuleComponent NOQ;
    private final int gxV = 2;
    private Color ZQj;
    Animation UEU;
    
    public SliderComponent(final Setting var1, final ModuleComponent var2, final int var3, final int var4) {
        this.RzB = false;
        this.ZQj = new Color(1052688, true);
        this.UEU = new AnimationImpl();
        this.KbE = var1;
        this.NOQ = var2;
        this.aaK = var2.NIE;
        this.COq = var2.RYm + var2.VQk;
        this.bQW = var2.BLU;
        this.AJD = var4;
        this.PGw = var3;
    }
    
    @Override
    public void Txe() {
    }
    
    @Override
    public void KsQ(final int var1) {
        this.PGw -= var1;
    }
    
    @Override
    public void oZQ(final int var1) {
        this.PGw += var1;
    }
    
    @Override
    public float aXr() {
        return (float)this.AJD;
    }
    
    private String epa() {
        return this.KbE.pdN ? String.format("%.0f", this.KbE.nUP) : String.format("%.2f", this.KbE.nUP);
    }
    
    @Override
    public void cPS(final int var1, final int var2) {
        this.COq = this.NOQ.RYm + this.NOQ.VQk;
        this.aaK = this.NOQ.NIE;
        final float var3 = ClickGui.Evk;
        this.SGB = LWn(var1, var2, this.aaK, this.COq + this.PGw + var3, this.aaK + this.bQW, this.COq + this.AJD + this.PGw + var3);
        ((AnimationImpl)this.UEU).Bhf((this.bQW - 12) * (this.KbE.nUP - this.KbE.bmb) / (this.KbE.Irt - this.KbE.bmb), 0.1);
        this.UEU.dmK();
        this.Kld = ColorUtil2.DGl(this.Kld, this.SGB ? 1.0f : 0.0f, 10.0f);
        this.BnI = ColorUtil2.DGl(this.BnI, 0.0f, 2.0f);
        float var4 = 0.0f;
        for (final String var8 : this.KbE.aIm) {
            FontManager.uAe().MzK(var8, this.aaK + 2 + var4 + 2.0f + this.BnI + this.Kld, this.COq + this.PGw - 1.2 + var3, -1);
            var4 += FontManager.uAe().gVe(var8) + 0.3f;
        }
        final String var9 = this.epa();
        FontManager.uAe().MzK(var9, this.aaK + this.bQW - FontManager.uAe().gVe(var9) - 4, this.COq + 1 + this.PGw - 1.2 + var3, -1);
        RenderHelper.NQP(this.aaK + 3 + 2, this.COq + this.AJD - 3.7 + this.PGw + var3, this.aaK + 6 + this.UEU.Etm() + 2.0, this.COq + this.AJD - 5 + this.PGw + var3, new Color(16711863).getRGB());
        if (this.RzB) {
            this.KbE.nUP = (var1 - (this.aaK + 5 + 2)) * (this.KbE.Irt - this.KbE.bmb) / (this.bQW - 12) + this.KbE.bmb;
            if (this.KbE.nUP > this.KbE.Irt) {
                this.KbE.nUP = this.KbE.Irt;
            }
            else if (this.KbE.nUP < this.KbE.bmb) {
                this.KbE.nUP = this.KbE.bmb;
            }
        }
    }
    
    @Override
    public void kJp(final double var1, final double var3, final int var5) {
        if (this.SGB) {
            this.BnI = -1.5f;
            this.RzB = true;
        }
    }
    
    @Override
    public void pmJ(final double var1, final double var3, final int var5) {
        this.RzB = false;
    }
    
    private static boolean LWn(final double var0, final double var2, final double var4, final double var6, final double var8, final double var10) {
        return var0 > var4 && var2 > var6 && var0 < var8 && var2 < var10;
    }
}
