// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.utils.fonts;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.WorldVertexBufferUploader;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import java.util.Locale;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.util.StringUtils;
import com.mojang.blaze3d.matrix.MatrixStack;
import ru.zvcoder.antihohol.troxill.utils.render.ImageHelper;

import java.awt.Font;
import java.io.ByteArrayInputStream;

public class FontRenderer
{
    private float QyZ;
    private float Smh;
    private int[] TUo;
    private boolean JXC;
    private boolean bRg;
    private boolean QaR;
    private boolean JSb;
    private ImageHelper pKs;
    private ImageHelper KjT;
    private ImageHelper PsB;
    private ImageHelper JEy;
    
    public FontRenderer(final ImageHelper var1, final ImageHelper var2, final ImageHelper var3, final ImageHelper var4) {
        this.TUo = new int[32];
        this.pKs = var1;
        this.KjT = var2;
        this.PsB = var3;
        this.JEy = var4;
        for (int var5 = 0; var5 < 32; ++var5) {
            final int var6 = (var5 >> 3 & 0x1) * 85;
            int var7 = (var5 >> 2 & 0x1) * 170 + var6;
            int var8 = (var5 >> 1 & 0x1) * 170 + var6;
            int var9 = (var5 & 0x1) * 170 + var6;
            if (var5 == 6) {
                var7 += 85;
            }
            if (var5 >= 16) {
                var7 /= 4;
                var8 /= 4;
                var9 /= 4;
            }
            this.TUo[var5] = ((var7 & 0xFF) << 16 | (var8 & 0xFF) << 8 | (var9 & 0xFF));
        }
    }
    
    public static FontRenderer ElD(final byte[] var0, final int var1, final boolean var2, final boolean var3, final boolean var4) {
        try {
            final ByteArrayInputStream var5 = new ByteArrayInputStream(var0);
            FontRenderer var13;
            try {
                final char[] var6 = new char[256];
                for (int var7 = 0; var7 < var6.length; ++var7) {
                    var6[var7] = (char)var7;
                }
                final Font var8 = Font.createFont(0, var5).deriveFont(0, (float)var1);
                final ImageHelper var9 = new ImageHelper(var8, true, true);
                var9.VFL(var6);
                var9.yao();
                ImageHelper var10 = var9;
                ImageHelper var11 = var9;
                ImageHelper var12 = var9;
                if (var2) {
                    var10 = new ImageHelper(Font.createFont(0, var5).deriveFont(1, (float)var1), true, true);
                    var10.VFL(var6);
                    var10.yao();
                }
                if (var3) {
                    var11 = new ImageHelper(Font.createFont(0, var5).deriveFont(2, (float)var1), true, true);
                    var11.VFL(var6);
                    var11.yao();
                }
                if (var4) {
                    var12 = new ImageHelper(Font.createFont(0, var5).deriveFont(3, (float)var1), true, true);
                    var12.VFL(var6);
                    var12.yao();
                }
                var13 = new FontRenderer(var9, var10, var11, var12);
            }
            catch (final Throwable var14) {
                try {
                    var5.close();
                }
                catch (final Throwable var15) {
                    var14.addSuppressed(var15);
                }
                throw var14;
            }
            var5.close();
            return var13;
        }
        catch (final Exception var16) {
            var16.printStackTrace();
            return null;
        }
    }
    
    public int HRJ(final String var1, final float var2, final float var3, final int var4) {
        return this.VPP(var1, var2, var3, var4, true);
    }
    
    public int DgV(final String var1, final double var2, final double var4, final int var6) {
        return this.VPP(var1, (float)var2, (float)var4, var6, true);
    }
    
    public int tjC(final String var1, final float var2, final float var3, final int var4) {
        return this.VPP(var1, var2, var3, var4, false);
    }
    
    public int zDS(final String var1, final float var2, final float var3, final int var4, final int var5) {
        return this.REi(var1, var2, var3, var4, var5, false);
    }
    
    public int MzK(final String var1, final double var2, final double var4, final int var6) {
        return this.VPP(var1, (float)var2, (float)var4, var6, false);
    }
    
    public int DjJ(final String var1, final double var2, final double var4, final int var6) {
        return this.VPP(var1, (float)var2 - this.gVe(var1) / 2.0f, (float)var4 - this.XtF() / 2.0f, var6, false);
    }
    
    public int vcV(final String var1, final double var2, final double var4, final int var6) {
        return this.VPP(var1, (float)var2 - this.gVe(var1) / 2.0f, (float)var4 - this.XtF() / 2.0f, var6, true);
    }
    
    public void xqW(final MatrixStack var1, final String var2, final double var3, final double var5, final int var7) {
        this.DjJ(StringUtils.stripColor(var2), var3 - 0.5, var5, var7);
        this.DjJ(StringUtils.stripColor(var2), var3 + 0.5, var5, var7);
        this.DjJ(StringUtils.stripColor(var2), var3, var5 - 0.5, var7);
        this.DjJ(StringUtils.stripColor(var2), var3, var5 + 0.5, var7);
        this.DjJ(StringUtils.stripColor(var2), var3, var5, -1);
    }
    
    public int VPP(final String var1, final float var2, final float var3, final int var4, final boolean var5) {
        this.bOA();
        int var6;
        if (var5) {
            var6 = this.PXF(var1, var2 + 1.0f, var3 + 1.0f, var4, true);
            var6 = Math.max(var6, this.PXF(var1, var2, var3, var4, false));
        }
        else {
            var6 = this.PXF(var1, var2, var3, var4, false);
        }
        return var6;
    }
    
    public int REi(final String var1, final float var2, final float var3, final int var4, final int var5, final boolean var6) {
        this.bOA();
        int var7;
        if (var6) {
            var7 = this.vam(var1, var2 + 1.0f, var3 + 1.0f, var4, var5, true);
            var7 = Math.max(var7, this.vam(var1, var2, var3, var4, var5, false));
        }
        else {
            var7 = this.vam(var1, var2, var3, var4, var5, false);
        }
        return var7;
    }
    
    private int PXF(final String var1, final float var2, final float var3, int var4, final boolean var5) {
        if (var1 == null) {
            return 0;
        }
        if ((var4 & 0xFC000000) == 0x0) {
            var4 |= 0xFF000000;
        }
        if (var5) {
            var4 = ((var4 & 0xFCFCFC) >> 2 | (var4 & 0xFF000000));
        }
        this.QyZ = var2 * 2.0f;
        this.Smh = var3 * 2.0f;
        this.nGJ(var1, var5, var4);
        return (int)(this.QyZ / 4.0f);
    }
    
    private int vam(final String var1, final float var2, final float var3, int var4, int var5, final boolean var6) {
        if (var1 == null) {
            return 0;
        }
        if ((var4 & 0xFC000000) == 0x0) {
            var4 |= 0xFF000000;
        }
        if ((var5 & 0xFC000000) == 0x0) {
            var5 |= 0xFF000000;
        }
        if (var6) {
            var4 = ((var4 & 0xFCFCFC) >> 2 | (var4 & 0xFF000000));
        }
        if (var6) {
            var5 = ((var5 & 0xFCFCFC) >> 2 | (var4 & 0xFF000000));
        }
        this.QyZ = var2 * 2.0f;
        this.Smh = var3 * 2.0f;
        this.GWq(var1, var6, var4, var5);
        return (int)(this.QyZ / 4.0f);
    }
    
    private void nGJ(final String var1, final boolean var2, final int var3) {
        final MatrixStack var4 = new MatrixStack();
        ImageHelper var5 = this.ITp();
        final float var6 = (var3 >> 24 & 0xFF) / 255.0f;
        float var7 = (var3 >> 16 & 0xFF) / 255.0f;
        float var8 = (var3 >> 8 & 0xFF) / 255.0f;
        float var9 = (var3 & 0xFF) / 255.0f;
        var4.pushPose();
        var4.scale(0.5f, 0.5f, 0.5f);
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(770, 771);
        RenderSystem.enableTexture();
        var5.Wqy();
        for (int var10 = 0; var10 < var1.length(); ++var10) {
            final char var11 = var1.charAt(var10);
            if (var11 == '§' && var10 + 1 < var1.length()) {
                int var12 = "0123456789abcdefklmnor".indexOf(var1.toLowerCase(Locale.ENGLISH).charAt(var10 + 1));
                if (var12 < 16) {
                    this.JXC = false;
                    this.JSb = false;
                    this.QaR = false;
                    this.bRg = false;
                    if (var12 < 0) {
                        var12 = 15;
                    }
                    if (var2) {
                        var12 += 16;
                    }
                    final int var13 = this.TUo[var12];
                    var7 = (var13 >> 16 & 0xFF) / 255.0f;
                    var8 = (var13 >> 8 & 0xFF) / 255.0f;
                    var9 = (var13 & 0xFF) / 255.0f;
                }
                else if (var12 != 16) {
                    if (var12 == 17) {
                        this.JXC = true;
                    }
                    else if (var12 == 18) {
                        this.JSb = true;
                    }
                    else if (var12 == 19) {
                        this.QaR = true;
                    }
                    else if (var12 == 20) {
                        this.bRg = true;
                    }
                    else {
                        this.JXC = false;
                        this.JSb = false;
                        this.QaR = false;
                        this.bRg = false;
                    }
                }
                ++var10;
            }
            else {
                var5 = this.ITp();
                var5.Wqy();
                final float var14 = var5.NfG(var4, var11, this.QyZ, this.Smh, var7, var9, var8, var6);
                RenderSystem.texParameter(3553, 10240, 9729);
                this.DgR(var4, var14, var5);
            }
        }
        var5.pek();
        var4.popPose();
        RenderSystem.disableBlend();
    }
    
    private void GWq(final String var1, final boolean var2, final int var3, final int var4) {
        final MatrixStack var5 = new MatrixStack();
        ImageHelper var6 = this.ITp();
        final float var7 = (var3 >> 24 & 0xFF) / 255.0f;
        float var8 = (var3 >> 16 & 0xFF) / 255.0f;
        float var9 = (var3 >> 8 & 0xFF) / 255.0f;
        float var10 = (var3 & 0xFF) / 255.0f;
        var5.pushPose();
        var5.scale(0.5f, 0.5f, 0.5f);
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(770, 771);
        RenderSystem.enableTexture();
        var6.Wqy();
        for (int var11 = 0; var11 < var1.length(); ++var11) {
            final char var12 = var1.charAt(var11);
            if (var12 == '§' && var11 + 1 < var1.length()) {
                int var13 = "0123456789abcdefklmnor".indexOf(var1.toLowerCase(Locale.ENGLISH).charAt(var11 + 1));
                if (var13 < 16) {
                    this.JXC = false;
                    this.JSb = false;
                    this.QaR = false;
                    this.bRg = false;
                    if (var13 < 0) {
                        var13 = 15;
                    }
                    if (var2) {
                        var13 += 16;
                    }
                    final int var14 = this.TUo[var13];
                    var8 = (var14 >> 16 & 0xFF) / 255.0f;
                    var9 = (var14 >> 8 & 0xFF) / 255.0f;
                    var10 = (var14 & 0xFF) / 255.0f;
                }
                else if (var13 != 16) {
                    if (var13 == 17) {
                        this.JXC = true;
                    }
                    else if (var13 == 18) {
                        this.JSb = true;
                    }
                    else if (var13 == 19) {
                        this.QaR = true;
                    }
                    else if (var13 == 20) {
                        this.bRg = true;
                    }
                    else {
                        this.JXC = false;
                        this.JSb = false;
                        this.QaR = false;
                        this.bRg = false;
                    }
                }
                ++var11;
            }
            else {
                var6 = this.ITp();
                var6.Wqy();
                final float var15 = var6.NfG(var5, var12, this.QyZ, this.Smh, var8, var10, var9, var7);
                RenderSystem.texParameter(3553, 10240, 9729);
                this.DgR(var5, var15, var6);
            }
        }
        var6.pek();
        var5.popPose();
    }
    
    private void DgR(final MatrixStack var1, final float var2, final ImageHelper var3) {
        if (this.JSb) {
            final BufferBuilder var4 = Tessellator.getInstance().getBuilder();
            GlStateManager._disableTexture();
            var4.begin(7, DefaultVertexFormats.POSITION);
            var4.vertex((double)this.QyZ, (double)(this.Smh + var3.nEo() / 2), 0.0).endVertex();
            var4.vertex(var1.last().pose(), this.QyZ + var2, this.Smh + var3.nEo() / 2, 0.0f).endVertex();
            var4.vertex(var1.last().pose(), this.QyZ + var2, this.Smh + var3.nEo() / 2 - 1.0f, 0.0f).endVertex();
            var4.vertex(var1.last().pose(), this.QyZ, this.Smh + var3.nEo() / 2 - 1.0f, 0.0f).endVertex();
            var4.end();
            WorldVertexBufferUploader.end(var4);
            GlStateManager._enableTexture();
        }
        if (this.QaR) {
            final BufferBuilder var4 = Tessellator.getInstance().getBuilder();
            GlStateManager._disableTexture();
            var4.begin(7, DefaultVertexFormats.POSITION);
            final int var5 = this.QaR ? -1 : 0;
            var4.vertex(var1.last().pose(), this.QyZ + var5, this.Smh + var3.nEo(), 0.0f).endVertex();
            var4.vertex(var1.last().pose(), this.QyZ + var2, this.Smh + var3.nEo(), 0.0f).endVertex();
            var4.vertex(var1.last().pose(), this.QyZ + var2, this.Smh + var3.nEo() - 1.0f, 0.0f).endVertex();
            var4.vertex(var1.last().pose(), this.QyZ + var5, this.Smh + var3.nEo() - 1.0f, 0.0f).endVertex();
            var4.end();
            WorldVertexBufferUploader.end(var4);
            GlStateManager._enableTexture();
        }
        this.QyZ += var2;
    }
    
    private ImageHelper ITp() {
        if (this.JXC && this.bRg) {
            return this.JEy;
        }
        if (this.JXC) {
            return this.KjT;
        }
        return this.bRg ? this.PsB : this.pKs;
    }
    
    private void bOA() {
        this.JXC = false;
        this.bRg = false;
        this.QaR = false;
        this.JSb = false;
    }
    
    public int XtF() {
        return this.pKs.nEo() / 2;
    }
    
    public int gVe(String var1) {
        if (var1 == null) {
            return 0;
        }
        var1 = var1.replaceAll("пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ0", "");
        var1 = var1.replaceAll("пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ1", "");
        var1 = var1.replaceAll("пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ2", "");
        var1 = var1.replaceAll("пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ3", "");
        var1 = var1.replaceAll("пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ4", "");
        var1 = var1.replaceAll("пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ5", "");
        var1 = var1.replaceAll("пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ6", "");
        var1 = var1.replaceAll("пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ7", "");
        var1 = var1.replaceAll("пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ8", "");
        var1 = var1.replaceAll("пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ8", "");
        var1 = var1.replaceAll("пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ9", "");
        var1 = var1.replaceAll("пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅf", "");
        var1 = var1.replaceAll("пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅr", "");
        var1 = var1.replaceAll("пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅe", "");
        var1 = var1.replaceAll("пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅd", "");
        var1 = var1.replaceAll("пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅa", "");
        var1 = var1.replaceAll("пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅc", "");
        var1 = var1.replaceAll("пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅb", "");
        var1 = var1.replaceAll("пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅn", "");
        var1 = var1.replaceAll("пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ", "");
        int var2 = 0;
        final int var3 = var1.length();
        final boolean var4 = false;
        for (int var5 = 0; var5 < var3; ++var5) {
            final char var6 = var1.charAt(var5);
            final ImageHelper var7 = this.ITp();
            var2 += (int)(var7.iAS(var6) - 8.0f);
        }
        return var2 / 2;
    }
    
    public String lXZ(final String var1, final int var2) {
        return this.ZTC(var1, var2, false);
    }
    
    public String ZTC(final String var1, final int var2, final boolean var3) {
        final StringBuilder var4 = new StringBuilder();
        final boolean var5 = false;
        final int var6 = var3 ? (var1.length() - 1) : 0;
        final int var7 = var3 ? -1 : 1;
        int var8 = 0;
        for (int var9 = var6; var9 >= 0 && var9 < var1.length() && var9 < var2; var9 += var7) {
            final char var10 = var1.charAt(var9);
            final ImageHelper var11 = this.ITp();
            var8 += (int)((var11.iAS(var10) - 8.0f) / 2.0f);
            if (var9 > var8) {
                break;
            }
            if (var3) {
                final StringBuilder var12 = var4.insert(0, var10);
            }
            else {
                var4.append(var10);
            }
        }
        return var4.toString();
    }
}
