// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.utils.calc;

import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.Minecraft;
import ru.zvcoder.antihohol.troxill.utils.render.ColorUtil2;

public class MathUtils
{
    static Minecraft iSO;
    int VLS;
    static int EDV;
    
    public MathUtils() {
        this.VLS = 0;
    }
    
    private static float[] rkF(final double var0, final double var2, final double var4, final double var6, final double var8, final double var10) {
        final double var11 = var6 - var0;
        final double var12 = var8 - var2;
        final double var13 = var10 - var4;
        final double var14 = MathHelper.sqrt(var11 * var11 + var13 * var13);
        final float var15 = (float)(Math.atan2(var13, var11) * 180.0 / 3.141592653589793 - 90.0);
        final float var16 = (float)(-(Math.atan2(var12, var14) * 180.0 / 3.141592653589793));
        return new float[] { var15, var16 };
    }
    
    private static float[] lxJ(final Entity var0, final Entity var1) {
        final float var2 = MathUtils.iSO.getFrameTime();
        Vector3d var3 = var0.position();
        final double var4 = ColorUtil2.UAv(var0.xOld, var3.x, var2);
        final double var5 = ColorUtil2.UAv(var0.yOld, var3.y, var2);
        final double var6 = ColorUtil2.UAv(var0.zOld, var3.z, var2);
        var3 = var1.position();
        final double var7 = ColorUtil2.UAv(var1.xOld, var3.x, var2);
        final double var8 = ColorUtil2.UAv(var1.yOld, var3.y, var2);
        final double var9 = ColorUtil2.UAv(var1.zOld, var3.z, var2);
        return rkF(var4, var5 + var0.getEyeHeight(), var6, var7, var8 + var1.getEyeHeight() / 1.5f, var9);
    }
    
    public static float[] VSZ(final Entity var0, final float var1, final float var2) {
        final float[] var3 = lxJ((Entity) MathUtils.iSO.player, var0);
        final float var4 = var3[0];
        final float var5 = var3[1];
        final boolean var6 = MathHelper.abs(MathHelper.wrapDegrees(var4 - MathUtils.iSO.player.yRot)) <= 180.0f;
        final boolean var7 = MathHelper.abs(MathHelper.wrapDegrees(var5 - MathUtils.iSO.player.xRot)) <= 90.0f;
        if (var6 && var7) {
            final float var8 = MathHelper.wrapDegrees(var4 - MathUtils.iSO.player.yRot) * var1 / 100.0f;
            final float var9 = MathHelper.wrapDegrees(var5 - MathUtils.iSO.player.xRot) * var2 / 100.0f;
            return new float[] { MathUtils.iSO.player.yRot + var8, MathUtils.iSO.player.xRot + var9 };
        }
        return new float[] { MathUtils.iSO.player.yRot, MathUtils.iSO.player.xRot };
    }
    
    public static float[] YJR(final Entity var0, final float var1, final float var2, final float var3) {
        final float[] var4 = lxJ((Entity) MathUtils.iSO.player, var0);
        final float var5 = var4[0];
        final float var6 = var4[1];
        final boolean var7 = MathHelper.abs(MathHelper.wrapDegrees(var5 - var1)) <= 180.0f;
        final boolean var8 = MathHelper.abs(MathHelper.wrapDegrees(var6 - MathUtils.iSO.player.xRot)) <= 90.0f;
        if (var7 && var8) {
            final float var9 = MathHelper.wrapDegrees(var5 - var1) * var2 / 100.0f;
            final float var10 = MathHelper.wrapDegrees(var6 - MathUtils.iSO.player.xRot) * var3 / 100.0f;
            return new float[] { var1 + var9, MathUtils.iSO.player.xRot + var10 };
        }
        return new float[] { var1, MathUtils.iSO.player.xRot };
    }
    
    public float[] BBM(final Entity var1, final float var2, final float var3, final boolean var4) {
        final float[] var5 = VSZ(var1, var2, var3);
        ++this.VLS;
        if (var4 && this.VLS >= 15) {
            var5[0] += (float)(5.0 - Math.random() * 10.0);
        }
        return var5;
    }
    
    public float[] Wtl(final Entity var1, final float var2, final float var3, final float var4, final boolean var5) {
        final float[] var6 = YJR(var1, var2, var3, var4);
        ++this.VLS;
        if (var5 && this.VLS >= 15) {
            var6[0] += (float)(5.0 - Math.random() * 10.0);
        }
        return var6;
    }
    
    public static float[] PaX(final Entity var0, final float var1, final float var2, final float var3, final boolean var4) {
        final float[] var5 = YJR(var0, var1, var2, var3);
        ++MathUtils.EDV;
        if (var4 && MathUtils.EDV >= 15) {
            var5[0] += (float)(5.0 - Math.random() * 10.0);
        }
        return var5;
    }
    
    static {
        MathUtils.iSO = Minecraft.getInstance();
        MathUtils.EDV = 0;
    }
}
