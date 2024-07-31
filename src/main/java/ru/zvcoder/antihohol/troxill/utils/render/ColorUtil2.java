// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.utils.render;

import java.awt.Color;
import net.minecraft.util.math.MathHelper;
import java.lang.reflect.Field;
import net.minecraft.client.Minecraft;
import ru.zvcoder.antihohol.troxill.Initializer;

public class ColorUtil2
{
    private static final long SJY;
    
    private static int Puu(final int var0) {
        if (var0 == 1) {
            return 91;
        }
        if (var0 == 2) {
            return 91;
        }
        if (var0 == 3) {
            return 91;
        }
        if (var0 == 4) {
            return 91;
        }
        return (var0 == 5) ? 106 : 0;
    }
    
    public static int rLf() {
        try {
            final Field[] var0 = Minecraft.class.getDeclaredFields();
            final Field var2 = var0[Puu(Initializer.field_id)];
            var2.setAccessible(true);
            return (int)var2.get(Minecraft.getInstance());
        }
        catch (final Exception var3) {
            var3.printStackTrace();
            return 0;
        }
    }
    
    public static double UWA() {
        return 1.0 / (rLf() / 2.0);
    }
    
    public static float xed(final float var0, final int var1) {
        return (System.currentTimeMillis() - ColorUtil2.SJY) / (float)var1 * var0 % var1;
    }
    
    public static float JoP(final float var0) {
        return (var0 < 0.0f) ? 0.0f : Math.min(var0, 1.0f);
    }
    
    public static float kLv(final float var0, final float var1, final float var2) {
        return (1.0f - JoP((float)(UWA() * var2))) * var0 + JoP((float)(UWA() * var2)) * var1;
    }
    
    public static float DGl(final float var0, final float var1, final float var2) {
        return var0 + (var1 - var0) * MathHelper.clamp((float)(UWA() * var2), 0.0f, 1.0f);
    }
    
    public static float qHR(final float var0, final float var1, final float var2) {
        final float var3 = var0 + (var1 - var0) * MathHelper.clamp((float)(UWA() * var2), 0.0f, 1.0f);
        if (DGl(var3, var1, var2) >= var3) {
            return DGl(var3, var1, var2);
        }
        return (DGl(var3, var1, var2) < var3) ? var3 : var1;
    }
    
    public static double UAv(final double var0, final double var2, final double var4) {
        return var0 + (var2 - var0) * MathHelper.clamp(UWA() * var4, 0.0, 1.0);
    }
    
    public static Color OzI(final Color var0, final Color var1, final float var2) {
        final float[] var3 = var0.getRGBComponents(null);
        final float[] var4 = var1.getRGBComponents(null);
        final float var5 = (var4[0] - var3[0]) * var2;
        final float var6 = (var4[1] - var3[1]) * var2;
        final float var7 = (var4[2] - var3[2]) * var2;
        final float var8 = (var4[3] - var3[3]) * var2;
        int var9 = (int)(var3[0] * 255.0f + var5 * 255.0f);
        int var10 = (int)(var3[1] * 255.0f + var6 * 255.0f);
        int var11 = (int)(var3[2] * 255.0f + var7 * 255.0f);
        int var12 = (int)(var3[3] * 255.0f + var8 * 255.0f);
        var9 = Math.min(255, Math.max(0, var9));
        var10 = Math.min(255, Math.max(0, var10));
        var11 = Math.min(255, Math.max(0, var11));
        var12 = Math.min(255, Math.max(0, var12));
        return new Color(var9, var10, var11, var12);
    }
    
    static {
        SJY = System.currentTimeMillis();
    }
}
