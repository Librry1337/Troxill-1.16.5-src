// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.utils.calc;

import java.math.RoundingMode;
import java.math.BigDecimal;

public class MathUtils2
{
    public static float Wxq(final float var0, final float var1, final float var2, final float var3, final float var4) {
        return var2 + (var0 - var1) * (var4 - var2) / (var3 - var1);
    }
    
    public static double diH(final double var0, final double var2, final double var4) {
        return var2 + (var0 - var2) * var4;
    }
    
    public static double wfe(final double var0, final int var2) {
        if (var2 < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal var3 = new BigDecimal(var0);
        var3 = var3.setScale(var2, RoundingMode.HALF_UP);
        return var3.doubleValue();
    }
}
