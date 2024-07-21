// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.utils.calc;

import java.awt.Color;
import java.util.Random;

public class RandomUtils
{
    public static final int pxY = 0;
    public static final int RrE = 1;
    public static final int VOY = 2;
    public static final int SoK = 3;
    public static final int Hrf = 4;
    public static final int CwA = 5;
    public static final int ZIq = 6;
    public static final int tbm = 7;
    public static final int nkS = 8;
    public static final int Tdo = 9;
    public static final int aUZ = 10;
    public static final int HtG = 11;
    public static final int zMz = 12;
    public static final int iFj = 13;
    public static final int bxR = 14;
    public static final int mtb = 15;
    public static final int Yin = 16;
    public static final int COI = 17;
    public static final int QYB = 18;
    public static final int UmN = 19;
    public static final int yzI = 20;
    private static Random ZQn;
    private static final float[] cMs;
    private static final float[] IJB;
    
    public static int apv(final int var0) {
        if (var0 < 0) {
            return 0;
        }
        return (var0 > 255) ? 255 : var0;
    }
    
    public static int YZX(final int var0, final int var1, final float var2) {
        return apv((int)(var0 + var2 * (var1 - var0)));
    }
    
    public static int BgM(final int var0) {
        final int var = var0 >> 16 & 0xFF;
        final int var2 = var0 >> 8 & 0xFF;
        final int var3 = var0 & 0xFF;
        return (var + var2 + var3) / 3;
    }
    
    public static boolean Mie(final int var0, final int var1, final int var2) {
        final int var3 = var0 >> 16 & 0xFF;
        final int var4 = var0 >> 8 & 0xFF;
        final int var5 = var0 & 0xFF;
        final int var6 = var1 >> 16 & 0xFF;
        final int var7 = var1 >> 8 & 0xFF;
        final int var8 = var1 & 0xFF;
        return Math.abs(var3 - var6) <= var2 && Math.abs(var4 - var7) <= var2 && Math.abs(var5 - var8) <= var2;
    }
    
    public static int mOh(final int var0, final int var1, final int var2) {
        return iFW(var0, var1, var2, 255);
    }
    
    public static int NQp(final int var0, final int var1, final int var2, final int var3, final int var4) {
        return (var1 & ~var4) | iFW(var0 & var4, var1, var2, var3);
    }
    
    public static int iFW(int var0, final int var1, final int var2, final int var3) {
        if (var2 == 0) {
            return var0;
        }
        int var4 = var0 >> 24 & 0xFF;
        int var5 = var0 >> 16 & 0xFF;
        int var6 = var0 >> 8 & 0xFF;
        int var7 = var0 & 0xFF;
        final int var8 = var1 >> 24 & 0xFF;
        final int var9 = var1 >> 16 & 0xFF;
        final int var10 = var1 >> 8 & 0xFF;
        final int var11 = var1 & 0xFF;
        switch (var2) {
            case 2: {
                var5 = Math.min(var5, var9);
                var6 = Math.min(var6, var10);
                var7 = Math.min(var7, var11);
                break;
            }
            case 3: {
                var5 = Math.max(var5, var9);
                var6 = Math.max(var6, var10);
                var7 = Math.max(var7, var11);
                break;
            }
            case 4: {
                var5 = apv(var5 + var9);
                var6 = apv(var6 + var10);
                var7 = apv(var7 + var11);
                break;
            }
            case 5: {
                var5 = apv(var9 - var5);
                var6 = apv(var10 - var6);
                var7 = apv(var11 - var7);
                break;
            }
            case 6: {
                var5 = apv(Math.abs(var5 - var9));
                var6 = apv(Math.abs(var6 - var10));
                var7 = apv(Math.abs(var7 - var11));
                break;
            }
            case 7: {
                var5 = apv(var5 * var9 / 255);
                var6 = apv(var6 * var10 / 255);
                var7 = apv(var7 * var11 / 255);
                break;
            }
            case 8:
            case 9:
            case 10:
            case 11: {
                Color.RGBtoHSB(var5, var6, var7, RandomUtils.cMs);
                Color.RGBtoHSB(var9, var10, var11, RandomUtils.IJB);
                switch (var2) {
                    case 8: {
                        RandomUtils.IJB[0] = RandomUtils.cMs[0];
                        break;
                    }
                    case 9: {
                        RandomUtils.IJB[1] = RandomUtils.cMs[1];
                        break;
                    }
                    case 10: {
                        RandomUtils.IJB[2] = RandomUtils.cMs[2];
                        break;
                    }
                    case 11: {
                        RandomUtils.IJB[0] = RandomUtils.cMs[0];
                        RandomUtils.IJB[1] = RandomUtils.cMs[1];
                        break;
                    }
                }
                var0 = Color.HSBtoRGB(RandomUtils.IJB[0], RandomUtils.IJB[1], RandomUtils.IJB[2]);
                var5 = (var0 >> 16 & 0xFF);
                var6 = (var0 >> 8 & 0xFF);
                var7 = (var0 & 0xFF);
                break;
            }
            case 12: {
                var5 = 255 - (255 - var5) * (255 - var9) / 255;
                var6 = 255 - (255 - var6) * (255 - var10) / 255;
                var7 = 255 - (255 - var7) * (255 - var11) / 255;
                break;
            }
            case 13: {
                var5 = (var5 + var9) / 2;
                var6 = (var6 + var10) / 2;
                var7 = (var7 + var11) / 2;
                break;
            }
            case 14: {
                int var12 = 255 - (255 - var5) * (255 - var9) / 255;
                int var13 = var5 * var9 / 255;
                var5 = (var12 * var5 + var13 * (255 - var5)) / 255;
                var12 = 255 - (255 - var6) * (255 - var10) / 255;
                var13 = var6 * var10 / 255;
                var6 = (var12 * var6 + var13 * (255 - var6)) / 255;
                var12 = 255 - (255 - var7) * (255 - var11) / 255;
                var13 = var7 * var11 / 255;
                var7 = (var12 * var7 + var13 * (255 - var7)) / 255;
                break;
            }
            case 15: {
                var7 = 255;
                var6 = 255;
                var5 = 255;
                break;
            }
            case 17: {
                if ((RandomUtils.ZQn.nextInt() & 0xFF) <= var4) {
                    var5 = var9;
                    var6 = var10;
                    var7 = var11;
                    break;
                }
                break;
            }
            case 18: {
                var5 = apv(var9 * var4 / 255);
                var6 = apv(var10 * var4 / 255);
                var7 = apv(var11 * var4 / 255);
                var4 = apv(var8 * var4 / 255);
                return var4 << 24 | var5 << 16 | var6 << 8 | var7;
            }
            case 19: {
                var4 = var4 * var8 / 255;
                return var4 << 24 | var9 << 16 | var10 << 8 | var11;
            }
            case 20: {
                final int var14 = 255 - var4;
                return var4 << 24 | var14 << 16 | var14 << 8 | var14;
            }
        }
        if (var3 != 255 || var4 != 255) {
            var4 = var4 * var3 / 255;
            final int var13 = (255 - var4) * var8 / 255;
            var5 = apv((var5 * var4 + var9 * var13) / 255);
            var6 = apv((var6 * var4 + var10 * var13) / 255);
            var7 = apv((var7 * var4 + var11 * var13) / 255);
            var4 = apv(var4 + var13);
        }
        return var4 << 24 | var5 << 16 | var6 << 8 | var7;
    }
    
    static {
        RandomUtils.ZQn = new Random();
        cMs = new float[3];
        IJB = new float[3];
    }
}
