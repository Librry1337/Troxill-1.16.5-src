// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.utils.render;

import ru.zvcoder.antihohol.troxill.utils.calc.RandomUtils;

import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;
import java.awt.image.BufferedImage;
import java.awt.image.Kernel;

public class ImageRenderer
{
    protected float BYR;
    protected Kernel niI;
    public static int dNJ;
    public static int Jvd;
    public static int MhH;
    protected boolean dwN;
    protected boolean uXR;
    private int DMa;
    
    public BufferedImage dmy(final BufferedImage var1, ColorModel var2) {
        if (var2 == null) {
            var2 = var1.getColorModel();
        }
        return new BufferedImage(var2, var2.createCompatibleWritableRaster(var1.getWidth(), var1.getHeight()), var2.isAlphaPremultiplied(), null);
    }
    
    public Rectangle2D YVn(final BufferedImage var1) {
        return new Rectangle(0, 0, var1.getWidth(), var1.getHeight());
    }
    
    public Point2D Nrv(final Point2D var1, Point2D var2) {
        if (var2 == null) {
            var2 = new Point2D.Double();
        }
        var2.setLocation(var1.getX(), var1.getY());
        return var2;
    }
    
    public RenderingHints JdS() {
        return null;
    }
    
    public int[] UhX(final BufferedImage var1, final int var2, final int var3, final int var4, final int var5, final int[] var6) {
        final int var7 = var1.getType();
        return (int[])((var7 != 2 && var7 != 1) ? var1.getRGB(var2, var3, var4, var5, var6, 0, var4) : var1.getRaster().getDataElements(var2, var3, var4, var5, var6));
    }
    
    public void blV(final BufferedImage var1, final int var2, final int var3, final int var4, final int var5, final int[] var6) {
        final int var7 = var1.getType();
        if (var7 != 2 && var7 != 1) {
            var1.setRGB(var2, var3, var4, var5, var6, 0, var4);
        }
        else {
            var1.getRaster().setDataElements(var2, var3, var4, var5, var6);
        }
    }
    
    public Object elf() {
        try {
            return super.clone();
        }
        catch (final CloneNotSupportedException var2) {
            return null;
        }
    }
    
    public ImageRenderer() {
        this(2.0f);
    }
    
    public ImageRenderer(final float var1) {
        this.dwN = true;
        this.uXR = true;
        this.DMa = ImageRenderer.Jvd;
        this.vwL(var1);
    }
    
    public void vwL(final float var1) {
        this.BYR = var1;
        this.niI = Gfr(var1);
    }
    
    public float sew() {
        return this.BYR;
    }
    
    public BufferedImage KmN(final BufferedImage var1, BufferedImage var2) {
        final int var3 = var1.getWidth();
        final int var4 = var1.getHeight();
        if (var2 == null) {
            var2 = this.dmy(var1, null);
        }
        final int[] var5 = new int[var3 * var4];
        final int[] var6 = new int[var3 * var4];
        var1.getRGB(0, 0, var3, var4, var5, 0, var3);
        if (this.BYR > 0.0f) {
            wPa(this.niI, var5, var6, var3, var4, this.dwN, this.dwN && this.uXR, false, ImageRenderer.Jvd);
            wPa(this.niI, var6, var5, var4, var3, this.dwN, false, this.dwN && this.uXR, ImageRenderer.Jvd);
        }
        var2.setRGB(0, 0, var3, var4, var5, 0, var3);
        return var2;
    }
    
    public static void wPa(final Kernel var0, final int[] var1, final int[] var2, final int var3, final int var4, final boolean var5, final boolean var6, final boolean var7, final int var8) {
        final float[] var9 = var0.getKernelData(null);
        final int var10 = var0.getWidth();
        final int var11 = var10 / 2;
        for (int var12 = 0; var12 < var4; ++var12) {
            int var13 = var12;
            final int var14 = var12 * var3;
            for (int var15 = 0; var15 < var3; ++var15) {
                float var16 = 0.0f;
                float var17 = 0.0f;
                float var18 = 0.0f;
                float var19 = 0.0f;
                final int var20 = var11;
                for (int var21 = -var11; var21 <= var11; ++var21) {
                    final float var22 = var9[var20 + var21];
                    if (var22 != 0.0f) {
                        int var23 = var15 + var21;
                        if (var23 < 0) {
                            if (var8 == ImageRenderer.Jvd) {
                                var23 = 0;
                            }
                            else if (var8 == ImageRenderer.MhH) {
                                var23 = (var15 + var3) % var3;
                            }
                        }
                        else if (var23 >= var3) {
                            if (var8 == ImageRenderer.Jvd) {
                                var23 = var3 - 1;
                            }
                            else if (var8 == ImageRenderer.MhH) {
                                var23 = (var15 + var3) % var3;
                            }
                        }
                        final int var24 = var1[var14 + var23];
                        final int var25 = var24 >> 24 & 0xFF;
                        int var26 = var24 >> 16 & 0xFF;
                        int var27 = var24 >> 8 & 0xFF;
                        int var28 = var24 & 0xFF;
                        if (var6) {
                            final float var29 = var25 * 0.003921569f;
                            var26 *= (int)var29;
                            var27 *= (int)var29;
                            var28 *= (int)var29;
                        }
                        var19 += var22 * var25;
                        var16 += var22 * var26;
                        var17 += var22 * var27;
                        var18 += var22 * var28;
                    }
                }
                if (var7 && var19 != 0.0f && var19 != 255.0f) {
                    final float var30 = 255.0f / var19;
                    var16 *= var30;
                    var17 *= var30;
                    var18 *= var30;
                }
                int var21 = var5 ? RandomUtils.apv((int)(var19 + 0.5)) : 255;
                final int var31 = RandomUtils.apv((int)(var16 + 0.5));
                int var23 = RandomUtils.apv((int)(var17 + 0.5));
                final int var24 = RandomUtils.apv((int)(var18 + 0.5));
                var2[var13] = (var21 << 24 | var31 << 16 | var23 << 8 | var24);
                var13 += var4;
            }
        }
    }
    
    public static Kernel Gfr(final float var0) {
        final int var = (int)Math.ceil(var0);
        final int var2 = var * 2 + 1;
        final float[] var3 = new float[var2];
        final float var4 = var0 / 3.0f;
        final float var5 = 2.0f * var4 * var4;
        final float var6 = 6.2831855f * var4;
        final float var7 = (float)Math.sqrt(var6);
        final float var8 = var0 * var0;
        float var9 = 0.0f;
        int var10 = 0;
        for (int var11 = -var; var11 <= var; ++var11) {
            final float var12 = (float)(var11 * var11);
            if (var12 > var8) {
                var3[var10] = 0.0f;
            }
            else {
                var3[var10] = (float)Math.exp(-var12 / var5) / var7;
            }
            var9 += var3[var10];
            ++var10;
        }
        for (int var11 = 0; var11 < var2; ++var11) {
            final float[] array = var3;
            final int n = var11;
            array[n] /= var9;
        }
        return new Kernel(var2, 1, var3);
    }
    
    public void LYP(final Kernel var1) {
        this.niI = var1;
    }
    
    public Kernel Xmz() {
        return this.niI;
    }
    
    public void IUW(final int var1) {
        this.DMa = var1;
    }
    
    public int IFv() {
        return this.DMa;
    }
    
    public void sFZ(final boolean var1) {
        this.dwN = var1;
    }
    
    public boolean akd() {
        return this.dwN;
    }
    
    public void IXG(final boolean var1) {
        this.uXR = var1;
    }
    
    public boolean paQ() {
        return this.uXR;
    }
    
    public static void BgL(final Kernel var0, final int[] var1, final int[] var2, final int var3, final int var4, final int var5) {
        RSZ(var0, var1, var2, var3, var4, true, var5);
    }
    
    public static void RSZ(final Kernel var0, final int[] var1, final int[] var2, final int var3, final int var4, final boolean var5, final int var6) {
        if (var0.getHeight() == 1) {
            GrP(var0, var1, var2, var3, var4, var5, var6);
        }
        else if (var0.getWidth() == 1) {
            oEX(var0, var1, var2, var3, var4, var5, var6);
        }
        else {
            CEb(var0, var1, var2, var3, var4, var5, var6);
        }
    }
    
    public static void CEb(final Kernel var0, final int[] var1, final int[] var2, final int var3, final int var4, final boolean var5, final int var6) {
        int var7 = 0;
        final float[] var8 = var0.getKernelData(null);
        final int var9 = var0.getHeight();
        final int var10 = var0.getWidth();
        final int var11 = var9 / 2;
        final int var12 = var10 / 2;
        for (int var13 = 0; var13 < var4; ++var13) {
            for (int var14 = 0; var14 < var3; ++var14) {
                float var15 = 0.0f;
                float var16 = 0.0f;
                float var17 = 0.0f;
                float var18 = 0.0f;
                for (int var19 = -var11; var19 <= var11; ++var19) {
                    final int var20 = var13 + var19;
                    int var21;
                    if (0 <= var20 && var20 < var4) {
                        var21 = var20 * var3;
                    }
                    else if (var6 == ImageRenderer.Jvd) {
                        var21 = var13 * var3;
                    }
                    else {
                        if (var6 != ImageRenderer.MhH) {
                            continue;
                        }
                        var21 = (var20 + var4) % var4 * var3;
                    }
                    final int var22 = var10 * (var19 + var11) + var12;
                    for (int var23 = -var12; var23 <= var12; ++var23) {
                        final float var24 = var8[var22 + var23];
                        if (var24 != 0.0f) {
                            int var25 = var14 + var23;
                            if (0 > var25 || var25 >= var3) {
                                if (var6 == ImageRenderer.Jvd) {
                                    var25 = var14;
                                }
                                else {
                                    if (var6 != ImageRenderer.MhH) {
                                        continue;
                                    }
                                    var25 = (var14 + var3) % var3;
                                }
                            }
                            final int var26 = var1[var21 + var25];
                            var18 += var24 * (var26 >> 24 & 0xFF);
                            var15 += var24 * (var26 >> 16 & 0xFF);
                            var16 += var24 * (var26 >> 8 & 0xFF);
                            var17 += var24 * (var26 & 0xFF);
                        }
                    }
                }
                int var19 = var5 ? RandomUtils.apv((int)(var18 + 0.5)) : 255;
                final int var20 = RandomUtils.apv((int)(var15 + 0.5));
                int var21 = RandomUtils.apv((int)(var16 + 0.5));
                final int var22 = RandomUtils.apv((int)(var17 + 0.5));
                var2[var7++] = (var19 << 24 | var20 << 16 | var21 << 8 | var22);
            }
        }
    }
    
    public static void GrP(final Kernel var0, final int[] var1, final int[] var2, final int var3, final int var4, final boolean var5, final int var6) {
        int var7 = 0;
        final float[] var8 = var0.getKernelData(null);
        final int var9 = var0.getWidth();
        final int var10 = var9 / 2;
        for (int var11 = 0; var11 < var4; ++var11) {
            final int var12 = var11 * var3;
            for (int var13 = 0; var13 < var3; ++var13) {
                float var14 = 0.0f;
                float var15 = 0.0f;
                float var16 = 0.0f;
                float var17 = 0.0f;
                final int var18 = var10;
                for (int var19 = -var10; var19 <= var10; ++var19) {
                    final float var20 = var8[var18 + var19];
                    if (var20 != 0.0f) {
                        int var21 = var13 + var19;
                        if (var21 < 0) {
                            if (var6 == ImageRenderer.Jvd) {
                                var21 = 0;
                            }
                            else if (var6 == ImageRenderer.MhH) {
                                var21 = (var13 + var3) % var3;
                            }
                        }
                        else if (var21 >= var3) {
                            if (var6 == ImageRenderer.Jvd) {
                                var21 = var3 - 1;
                            }
                            else if (var6 == ImageRenderer.MhH) {
                                var21 = (var13 + var3) % var3;
                            }
                        }
                        final int var22 = var1[var12 + var21];
                        var17 += var20 * (var22 >> 24 & 0xFF);
                        var14 += var20 * (var22 >> 16 & 0xFF);
                        var15 += var20 * (var22 >> 8 & 0xFF);
                        var16 += var20 * (var22 & 0xFF);
                    }
                }
                int var19 = var5 ? RandomUtils.apv((int)(var17 + 0.5)) : 255;
                final int var23 = RandomUtils.apv((int)(var14 + 0.5));
                int var21 = RandomUtils.apv((int)(var15 + 0.5));
                final int var22 = RandomUtils.apv((int)(var16 + 0.5));
                var2[var7++] = (var19 << 24 | var23 << 16 | var21 << 8 | var22);
            }
        }
    }
    
    public static void oEX(final Kernel var0, final int[] var1, final int[] var2, final int var3, final int var4, final boolean var5, final int var6) {
        int var7 = 0;
        final float[] var8 = var0.getKernelData(null);
        final int var9 = var0.getHeight();
        final int var10 = var9 / 2;
        for (int var11 = 0; var11 < var4; ++var11) {
            for (int var12 = 0; var12 < var3; ++var12) {
                float var13 = 0.0f;
                float var14 = 0.0f;
                float var15 = 0.0f;
                float var16 = 0.0f;
                for (int var17 = -var10; var17 <= var10; ++var17) {
                    final int var18 = var11 + var17;
                    int var19;
                    if (var18 < 0) {
                        if (var6 == ImageRenderer.Jvd) {
                            var19 = 0;
                        }
                        else if (var6 == ImageRenderer.MhH) {
                            var19 = (var11 + var4) % var4 * var3;
                        }
                        else {
                            var19 = var18 * var3;
                        }
                    }
                    else if (var18 >= var4) {
                        if (var6 == ImageRenderer.Jvd) {
                            var19 = (var4 - 1) * var3;
                        }
                        else if (var6 == ImageRenderer.MhH) {
                            var19 = (var11 + var4) % var4 * var3;
                        }
                        else {
                            var19 = var18 * var3;
                        }
                    }
                    else {
                        var19 = var18 * var3;
                    }
                    final float var20 = var8[var17 + var10];
                    if (var20 != 0.0f) {
                        final int var21 = var1[var19 + var12];
                        var16 += var20 * (var21 >> 24 & 0xFF);
                        var13 += var20 * (var21 >> 16 & 0xFF);
                        var14 += var20 * (var21 >> 8 & 0xFF);
                        var15 += var20 * (var21 & 0xFF);
                    }
                }
                int var17 = var5 ? RandomUtils.apv((int)(var16 + 0.5)) : 255;
                final int var18 = RandomUtils.apv((int)(var13 + 0.5));
                int var19 = RandomUtils.apv((int)(var14 + 0.5));
                final int var22 = RandomUtils.apv((int)(var15 + 0.5));
                var2[var7++] = (var17 << 24 | var18 << 16 | var19 << 8 | var22);
            }
        }
    }
    
    static {
        ImageRenderer.dNJ = 0;
        ImageRenderer.Jvd = 1;
        ImageRenderer.MhH = 2;
    }
}
