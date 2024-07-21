// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.utils.calc;

public class CalcUtils
{
    public static final float NxQ = 3.1415927f;
    public static final float TYQ = 1.5707964f;
    public static final float MLE = 0.7853982f;
    public static final float WvJ = 6.2831855f;
    private static final float uGW = -0.5f;
    private static final float Yib = 1.5f;
    private static final float ErQ = -1.5f;
    private static final float bvx = 0.5f;
    private static final float tuF = 1.0f;
    private static final float ffN = -2.5f;
    private static final float lMS = 2.0f;
    private static final float FPf = -0.5f;
    private static final float iSB = -0.5f;
    private static final float ftZ = 0.0f;
    private static final float JAS = 0.5f;
    private static final float cRV = 0.0f;
    private static final float ukG = 0.0f;
    private static final float DEz = 1.0f;
    private static final float qLA = 0.0f;
    private static final float EjP = 0.0f;
    
    public static float mbm(final float var0, final float var1) {
        return var0 / ((1.0f / var1 - 2.0f) * (1.0f - var0) + 1.0f);
    }
    
    public static float yaA(final float var0, final float var1) {
        final float var2 = (1.0f / var1 - 2.0f) * (1.0f - 2.0f * var0);
        return (var0 < 0.5) ? (var0 / (var2 + 1.0f)) : ((var2 - var0) / (var2 - 1.0f));
    }
    
    public static float WQw(final float var0, final float var1) {
        return (var1 < var0) ? 0.0f : 1.0f;
    }
    
    public static float Ckh(final float var0, final float var1, final float var2) {
        return (var2 >= var0 && var2 < var1) ? 1.0f : 0.0f;
    }
    
    public static float xxh(final float var0, final float var1, final float var2, final float var3, float var4) {
        if (var4 < var0 || var4 >= var3) {
            return 0.0f;
        }
        if (var4 < var1) {
            var4 = (var4 - var0) / (var1 - var0);
            return var4 * var4 * (3.0f - 2.0f * var4);
        }
        if (var4 < var2) {
            return 1.0f;
        }
        var4 = (var4 - var2) / (var3 - var2);
        return 1.0f - var4 * var4 * (3.0f - 2.0f * var4);
    }
    
    public static float seF(final float var0, final float var1, float var2) {
        if (var2 < var0) {
            return 0.0f;
        }
        if (var2 >= var1) {
            return 1.0f;
        }
        var2 = (var2 - var0) / (var1 - var0);
        return var2 * var2 * (3.0f - 2.0f * var2);
    }
    
    public static float DcH(float var0) {
        var0 = 1.0f - var0;
        return (float)Math.sqrt(1.0f - var0 * var0);
    }
    
    public static float JiK(final float var0) {
        return 1.0f - (float)Math.sqrt(1.0f - var0 * var0);
    }
    
    public static float CKG(final float var0, final float var1, final float var2) {
        return (var0 < var1) ? var1 : ((var0 > var2) ? var2 : var0);
    }
    
    public static int qQg(final int var0, final int var1, final int var2) {
        return (var0 < var1) ? var1 : ((var0 > var2) ? var2 : var0);
    }
    
    public static double BeG(double var0, final double var2) {
        final int var3 = (int)(var0 / var2);
        var0 -= var3 * var2;
        return (var0 < 0.0) ? (var0 + var2) : var0;
    }
    
    public static float cqG(float var0, final float var1) {
        final int var2 = (int)(var0 / var1);
        var0 -= var2 * var1;
        return (var0 < 0.0f) ? (var0 + var1) : var0;
    }
    
    public static int dSv(int var0, final int var1) {
        final int var2 = var0 / var1;
        var0 -= var2 * var1;
        return (var0 < 0) ? (var0 + var1) : var0;
    }
    
    public static float Hrj(final float var0) {
        final float var = cqG(var0, 1.0f);
        return 2.0f * ((var < 0.5) ? var : (1.0f - var));
    }
    
    public static float MZh(final float var0, final float var1, final float var2) {
        return var1 + var0 * (var2 - var1);
    }
    
    public static int gDw(final float var0, final int var1, final int var2) {
        return (int)(var1 + var0 * (var2 - var1));
    }
    
    public static int zmm(final float var0, final int var1, final int var2) {
        int var3 = var1 >> 24 & 0xFF;
        int var4 = var1 >> 16 & 0xFF;
        int var5 = var1 >> 8 & 0xFF;
        int var6 = var1 & 0xFF;
        final int var7 = var2 >> 24 & 0xFF;
        final int var8 = var2 >> 16 & 0xFF;
        final int var9 = var2 >> 8 & 0xFF;
        final int var10 = var2 & 0xFF;
        var3 = gDw(var0, var3, var7);
        var4 = gDw(var0, var4, var8);
        var5 = gDw(var0, var5, var9);
        var6 = gDw(var0, var6, var10);
        return var3 << 24 | var4 << 16 | var5 << 8 | var6;
    }
    
    public static int JqE(final float var0, final float var1, final int var2, final int var3, final int var4, final int var5) {
        final int var6 = var2 >> 24 & 0xFF;
        final int var7 = var2 >> 16 & 0xFF;
        final int var8 = var2 >> 8 & 0xFF;
        final int var9 = var2 & 0xFF;
        final int var10 = var3 >> 24 & 0xFF;
        final int var11 = var3 >> 16 & 0xFF;
        final int var12 = var3 >> 8 & 0xFF;
        final int var13 = var3 & 0xFF;
        final int var14 = var4 >> 24 & 0xFF;
        final int var15 = var4 >> 16 & 0xFF;
        final int var16 = var4 >> 8 & 0xFF;
        final int var17 = var4 & 0xFF;
        final int var18 = var5 >> 24 & 0xFF;
        final int var19 = var5 >> 16 & 0xFF;
        final int var20 = var5 >> 8 & 0xFF;
        final int var21 = var5 & 0xFF;
        final float var22 = 1.0f - var0;
        final float var23 = 1.0f - var1;
        float var24 = var22 * var6 + var0 * var10;
        float var25 = var22 * var14 + var0 * var18;
        final int var26 = (int)(var23 * var24 + var1 * var25);
        var24 = var22 * var7 + var0 * var11;
        var25 = var22 * var15 + var0 * var19;
        final int var27 = (int)(var23 * var24 + var1 * var25);
        var24 = var22 * var8 + var0 * var12;
        var25 = var22 * var16 + var0 * var20;
        final int var28 = (int)(var23 * var24 + var1 * var25);
        var24 = var22 * var9 + var0 * var13;
        var25 = var22 * var17 + var0 * var21;
        final int var29 = (int)(var23 * var24 + var1 * var25);
        return var26 << 24 | var27 << 16 | var28 << 8 | var29;
    }
    
    public static int rNZ(final int var0) {
        final int var = var0 >> 16 & 0xFF;
        final int var2 = var0 >> 8 & 0xFF;
        final int var3 = var0 & 0xFF;
        return (int)(var * 0.299f + var2 * 0.587f + var3 * 0.114f);
    }
    
    public static float lks(float var0, final int var1, final float[] var2) {
        final int var3 = var1 - 3;
        if (var3 < 1) {
            throw new IllegalArgumentException("a");
        }
        var0 = CKG(var0, 0.0f, 1.0f) * var3;
        int var4 = (int)var0;
        if (var4 > var1 - 4) {
            var4 = var1 - 4;
        }
        var0 -= var4;
        final float var5 = var2[var4];
        final float var6 = var2[var4 + 1];
        final float var7 = var2[var4 + 2];
        final float var8 = var2[var4 + 3];
        final float var9 = -0.5f * var5 + 1.5f * var6 + -1.5f * var7 + 0.5f * var8;
        final float var10 = 1.0f * var5 + -2.5f * var6 + 2.0f * var7 + -0.5f * var8;
        final float var11 = -0.5f * var5 + 0.0f * var6 + 0.5f * var7 + 0.0f * var8;
        final float var12 = 0.0f * var5 + 1.0f * var6 + 0.0f * var7 + 0.0f * var8;
        return ((var9 * var0 + var10) * var0 + var11) * var0 + var12;
    }
    
    public static float UMM(final float var0, final int var1, final int[] var2, final int[] var3) {
        final int var4 = var1 - 3;
        if (var4 < 1) {
            throw new IllegalArgumentException("a");
        }
        int var5;
        for (var5 = 0; var5 < var4 && var2[var5 + 1] <= var0; ++var5) {}
        if (var5 > var1 - 3) {
            var5 = var1 - 3;
        }
        float var6 = (var0 - var2[var5]) / (var2[var5 + 1] - var2[var5]);
        if (--var5 < 0) {
            var5 = 0;
            var6 = 0.0f;
        }
        final float var7 = (float)var3[var5];
        final float var8 = (float)var3[var5 + 1];
        final float var9 = (float)var3[var5 + 2];
        final float var10 = (float)var3[var5 + 3];
        final float var11 = -0.5f * var7 + 1.5f * var8 + -1.5f * var9 + 0.5f * var10;
        final float var12 = 1.0f * var7 + -2.5f * var8 + 2.0f * var9 + -0.5f * var10;
        final float var13 = -0.5f * var7 + 0.0f * var8 + 0.5f * var9 + 0.0f * var10;
        final float var14 = 0.0f * var7 + 1.0f * var8 + 0.0f * var9 + 0.0f * var10;
        return ((var11 * var6 + var12) * var6 + var13) * var6 + var14;
    }
    
    public static int plu(float var0, final int var1, final int[] var2) {
        final int var3 = var1 - 3;
        if (var3 < 1) {
            throw new IllegalArgumentException("a");
        }
        var0 = CKG(var0, 0.0f, 1.0f) * var3;
        int var4 = (int)var0;
        if (var4 > var1 - 4) {
            var4 = var1 - 4;
        }
        var0 -= var4;
        int var5 = 0;
        for (int var6 = 0; var6 < 4; ++var6) {
            final int var7 = var6 * 8;
            final float var8 = (float)(var2[var4] >> var7 & 0xFF);
            final float var9 = (float)(var2[var4 + 1] >> var7 & 0xFF);
            final float var10 = (float)(var2[var4 + 2] >> var7 & 0xFF);
            final float var11 = (float)(var2[var4 + 3] >> var7 & 0xFF);
            final float var12 = -0.5f * var8 + 1.5f * var9 + -1.5f * var10 + 0.5f * var11;
            final float var13 = 1.0f * var8 + -2.5f * var9 + 2.0f * var10 + -0.5f * var11;
            final float var14 = -0.5f * var8 + 0.0f * var9 + 0.5f * var10 + 0.0f * var11;
            final float var15 = 0.0f * var8 + 1.0f * var9 + 0.0f * var10 + 0.0f * var11;
            int var16 = (int)(((var12 * var0 + var13) * var0 + var14) * var0 + var15);
            if (var16 < 0) {
                var16 = 0;
            }
            else if (var16 > 255) {
                var16 = 255;
            }
            var5 |= var16 << var7;
        }
        return var5;
    }
    
    public static int boJ(final int var0, final int var1, final int[] var2, final int[] var3) {
        final int var4 = var1 - 3;
        if (var4 < 1) {
            throw new IllegalArgumentException("a");
        }
        int var5;
        for (var5 = 0; var5 < var4 && var2[var5 + 1] <= var0; ++var5) {}
        if (var5 > var1 - 3) {
            var5 = var1 - 3;
        }
        float var6 = (var0 - var2[var5]) / (float)(var2[var5 + 1] - var2[var5]);
        if (--var5 < 0) {
            var5 = 0;
            var6 = 0.0f;
        }
        int var7 = 0;
        for (int var8 = 0; var8 < 4; ++var8) {
            final int var9 = var8 * 8;
            final float var10 = (float)(var3[var5] >> var9 & 0xFF);
            final float var11 = (float)(var3[var5 + 1] >> var9 & 0xFF);
            final float var12 = (float)(var3[var5 + 2] >> var9 & 0xFF);
            final float var13 = (float)(var3[var5 + 3] >> var9 & 0xFF);
            final float var14 = -0.5f * var10 + 1.5f * var11 + -1.5f * var12 + 0.5f * var13;
            final float var15 = 1.0f * var10 + -2.5f * var11 + 2.0f * var12 + -0.5f * var13;
            final float var16 = -0.5f * var10 + 0.0f * var11 + 0.5f * var12 + 0.0f * var13;
            final float var17 = 0.0f * var10 + 1.0f * var11 + 0.0f * var12 + 0.0f * var13;
            int var18 = (int)(((var14 * var6 + var15) * var6 + var16) * var6 + var17);
            if (var18 < 0) {
                var18 = 0;
            }
            else if (var18 > 255) {
                var18 = 255;
            }
            var7 |= var18 << var9;
        }
        return var7;
    }
    
    public static void pOf(final int[] var0, final int[] var1, final int var2, final int var3, final int var4, final float[] var5) {
        int var6 = var3;
        final int var7 = var0.length;
        final float[] var8 = new float[var2 + 2];
        int var9 = 0;
        for (int var10 = 0; var10 < var2; ++var10) {
            while (var5[var9 + 1] < var10) {
                ++var9;
            }
            var8[var10] = var9 + (var10 - var5[var9]) / (var5[var9 + 1] - var5[var9]);
        }
        var8[var2] = (float)var2;
        var8[var2 + 1] = (float)var2;
        float var11 = 1.0f;
        float var13;
        float var12 = var13 = var8[1];
        float var14 = 0.0f;
        float var15 = 0.0f;
        float var16 = 0.0f;
        float var17 = 0.0f;
        int var18 = var0[var3];
        int var19 = var18 >> 24 & 0xFF;
        int var20 = var18 >> 16 & 0xFF;
        int var21 = var18 >> 8 & 0xFF;
        int var22 = var18 & 0xFF;
        int var23 = var3 + var4;
        var18 = var0[var23];
        int var24 = var18 >> 24 & 0xFF;
        int var25 = var18 >> 16 & 0xFF;
        int var26 = var18 >> 8 & 0xFF;
        int var27 = var18 & 0xFF;
        var23 += var4;
        var9 = 1;
        while (var9 <= var2) {
            final float var28 = var11 * var19 + (1.0f - var11) * var24;
            final float var29 = var11 * var20 + (1.0f - var11) * var25;
            final float var30 = var11 * var21 + (1.0f - var11) * var26;
            final float var31 = var11 * var22 + (1.0f - var11) * var27;
            if (var11 < var12) {
                var17 += var28 * var11;
                var16 += var29 * var11;
                var15 += var30 * var11;
                var14 += var31 * var11;
                var12 -= var11;
                var11 = 1.0f;
                var19 = var24;
                var20 = var25;
                var21 = var26;
                var22 = var27;
                if (var23 < var7) {
                    var18 = var0[var23];
                }
                var24 = (var18 >> 24 & 0xFF);
                var25 = (var18 >> 16 & 0xFF);
                var26 = (var18 >> 8 & 0xFF);
                var27 = (var18 & 0xFF);
                var23 += var4;
            }
            else {
                var17 += var28 * var12;
                var16 += var29 * var12;
                var15 += var30 * var12;
                var14 += var31 * var12;
                var1[var6] = ((int)Math.min(var17 / var13, 255.0f) << 24 | (int)Math.min(var16 / var13, 255.0f) << 16 | (int)Math.min(var15 / var13, 255.0f) << 8 | (int)Math.min(var14 / var13, 255.0f));
                var6 += var4;
                var14 = 0.0f;
                var15 = 0.0f;
                var16 = 0.0f;
                var17 = 0.0f;
                var11 -= var12;
                var12 = (var13 = var8[var9 + 1] - var8[var9]);
                ++var9;
            }
        }
    }
    
    public static void oZx(final int[] var0, final int var1, int var2) {
        var2 += var1;
        for (int var3 = var1; var3 < var2; ++var3) {
            final int var4 = var0[var3];
            final int var5 = var4 >> 24 & 0xFF;
            int var6 = var4 >> 16 & 0xFF;
            int var7 = var4 >> 8 & 0xFF;
            int var8 = var4 & 0xFF;
            final float var9 = var5 * 0.003921569f;
            var6 *= (int)var9;
            var7 *= (int)var9;
            var8 *= (int)var9;
            var0[var3] = (var5 << 24 | var6 << 16 | var7 << 8 | var8);
        }
    }
    
    public static void PMr(final int[] var0, final int var1, int var2) {
        var2 += var1;
        for (int var3 = var1; var3 < var2; ++var3) {
            final int var4 = var0[var3];
            final int var5 = var4 >> 24 & 0xFF;
            int var6 = var4 >> 16 & 0xFF;
            int var7 = var4 >> 8 & 0xFF;
            int var8 = var4 & 0xFF;
            if (var5 != 0 && var5 != 255) {
                final float var9 = 255.0f / var5;
                var6 *= (int)var9;
                var7 *= (int)var9;
                var8 *= (int)var9;
                if (var6 > 255) {
                    var6 = 255;
                }
                if (var7 > 255) {
                    var7 = 255;
                }
                if (var8 > 255) {
                    var8 = 255;
                }
                var0[var3] = (var5 << 24 | var6 << 16 | var7 << 8 | var8);
            }
        }
    }
}
