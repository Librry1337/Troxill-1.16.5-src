// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.utils.render;

import net.minecraft.util.math.MathHelper;
import java.awt.Color;

public class ColorUtils
{
    public static float[] wuv(final int var0) {
        return new float[] { (var0 >> 16 & 0xFF) / 255.0f, (var0 >> 8 & 0xFF) / 255.0f, (var0 & 0xFF) / 255.0f, (var0 >> 24 & 0xFF) / 255.0f };
    }
    
    public static int XnD(final int var0, final int var1, final int var2, final int var3) {
        return var3 << 24 | var0 << 16 | var1 << 8 | var2;
    }
    
    public static float[] Paz(final int var0) {
        return new float[] { (var0 >> 16 & 0xFF) / 255.0f, (var0 >> 8 & 0xFF) / 255.0f, (var0 & 0xFF) / 255.0f, (var0 >> 24 & 0xFF) / 255.0f, (var0 >> 24 & 0xFF) / 255.0f };
    }
    
    public static int[] Pul(final int var0) {
        return new int[] { (var0 >> 16 & 0xFF) / 255, (var0 >> 8 & 0xFF) / 255, (var0 & 0xFF) / 255, (var0 >> 24 & 0xFF) / 255, (var0 >> 24 & 0xFF) / 255 };
    }
    
    public static int nqm(final int var0, final float var1) {
        return pfY(var0 >> 16 & 0xFF, var0 >> 8 & 0xFF, var0 & 0xFF, (int)var1);
    }
    
    public static int pfY(final int var0, final int var1, final int var2, final int var3) {
        return (var0 << 16) + (var1 << 8) + var2 + (var3 << 24);
    }
    
    public static Color atu(final Color var0, final int var1) {
        return new Color(var0.getRed(), var0.getGreen(), var0.getBlue(), MathHelper.clamp(var1, 0, 255));
    }
    
    public static Color BTw(final Color var0, final float var1) {
        return new Color((float)var0.getRed(), (float)var0.getGreen(), (float)var0.getBlue(), var1);
    }
    
    public static float PYX(final int var0) {
        return (var0 >> 16 & 0xFF) / 255.0f;
    }
    
    public static float GuW(final int var0) {
        return (var0 >> 8 & 0xFF) / 255.0f;
    }
    
    public static float psu(final int var0) {
        return (var0 & 0xFF) / 255.0f;
    }
    
    public static float DOL(final int var0) {
        return (var0 >> 24 & 0xFF) / 255.0f;
    }
    
    public static int KSH(final Color var0, final Color var1, final float var2) {
        final double var3 = Math.abs(System.currentTimeMillis() / 20L) / 100.0 + 6.0 * var2 * 0.1 / 60.0;
        final float var4 = HCv((float)Math.sin(18.84955592153876 * (var3 / 4.0 % 1.0)) / 2.0f + 0.5f, 0.0f, 1.0f);
        final float var5 = DJR(var0.getRed() / 255.0f, var1.getRed() / 255.0f, var4);
        final float var6 = DJR(var0.getGreen() / 255.0f, var1.getGreen() / 255.0f, var4);
        final float var7 = DJR(var0.getBlue() / 255.0f, var1.getBlue() / 255.0f, var4);
        final float var8 = DJR(var0.getAlpha() / 255.0f, var1.getAlpha() / 255.0f, var4);
        return new Color(var5, var6, var7, var8).getRGB();
    }
    
    public static float DJR(final float var0, final float var1, final float var2) {
        return var0 + var2 * (var1 - var0);
    }
    
    public static float HCv(float var0, final float var1, final float var2) {
        if (var0 <= var1) {
            var0 = var1;
        }
        if (var0 >= var2) {
            var0 = var2;
        }
        return var0;
    }
}
