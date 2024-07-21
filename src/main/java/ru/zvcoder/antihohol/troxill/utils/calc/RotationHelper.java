// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.utils.calc;

import net.minecraft.client.Minecraft;

public class RotationHelper
{
    public static float CSZ(final float var0) {
        return oyA(var0) * QFm();
    }
    
    public static float QFm() {
        return (float)(SUy() * 0.15);
    }
    
    public static float SUy() {
        final float var0;
        return (var0 = (float)(Minecraft.getInstance().options.sensitivity * 0.6 + 0.2)) * var0 * var0 * 8.0f;
    }
    
    public static float oyA(final float var0) {
        return (float)Math.round(var0 / QFm());
    }
}
