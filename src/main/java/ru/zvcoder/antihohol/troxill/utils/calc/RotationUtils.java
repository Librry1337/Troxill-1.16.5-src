// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.utils.calc;

import net.minecraft.util.math.MathHelper;
import java.lang.reflect.Method;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3d;
import java.lang.reflect.InvocationTargetException;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.client.Minecraft;

public class RotationUtils
{
    private static final Minecraft pvi;
    
    public static Vector2f Nxy(final double var0, final double var2, final double var4) {
        final Vector3d var5 = RotationUtils.pvi.getEntityRenderDispatcher().camera.getPosition();
        final Quaternion var6 = RotationUtils.pvi.getEntityRenderDispatcher().cameraOrientation().copy();
        var6.conj();
        final Vector3f var7 = new Vector3f((float)(var5.x - var0), (float)(var5.y - var2), (float)(var5.z - var4));
        var7.transform(var6);
        if (RotationUtils.pvi.options.bobView) {
            final Entity var8 = RotationUtils.pvi.getCameraEntity();
            if (PlayerEntity.class.isInstance(var8)) {
                final PlayerEntity var9 = (PlayerEntity)var8;
                dcp(var9, var7);
            }
        }
        for (final Method var13 : GameRenderer.class.getDeclaredMethods()) {
            if (var13.getReturnType() == Double.TYPE && var13.getParameters().length == 3 && var13.getParameters()[0].getType() == ActiveRenderInfo.class && var13.getParameters()[2].getType() == Boolean.TYPE) {
                var13.setAccessible(true);
                try {
                    final double var14 = (double)var13.invoke(RotationUtils.pvi.gameRenderer, RotationUtils.pvi.getEntityRenderDispatcher().camera, RotationUtils.pvi.getFrameTime(), true);
                    return ohS(var7, var14);
                }
                catch (final InvocationTargetException | IllegalAccessException var15) {
                    throw new RuntimeException(var15);
                }
            }
        }
        return new Vector2f(0.0f, 0.0f);
    }
    
    private static void dcp(final PlayerEntity var0, final Vector3f var1) {
        final float var2 = var0.walkDist;
        final float var3 = var2 - var0.walkDistO;
        final float var4 = -(var2 + var3 * RotationUtils.pvi.getFrameTime());
        final float var5 = MathHelper.lerp(RotationUtils.pvi.getFrameTime(), var0.yRot, var0.yRotO);
        final Quaternion var6 = new Quaternion(Vector3f.XP, Math.abs(MathHelper.cos(var4 * 3.1415927f - 0.2f) * var5) * 5.0f, true);
        var6.conj();
        var1.transform(var6);
        final Quaternion var7 = new Quaternion(Vector3f.ZP, MathHelper.sin(var4 * 3.1415927f) * var5 * 3.0f, true);
        var7.conj();
        var1.transform(var7);
        final Vector3f var8 = new Vector3f(MathHelper.sin(var4 * 3.1415927f) * var5 * 0.5f, -Math.abs(MathHelper.cos(var4 * 3.1415927f) * var5), 0.0f);
        var8.set(var8.x(), -var8.y(), var8.z());
        var1.add(var8);
    }
    
    private static Vector2f ohS(final Vector3f var0, final double var1) {
        final float var2 = RotationUtils.pvi.getWindow().getGuiScaledHeight() / 2.0f;
        final float var3 = var2 / (var0.z() * (float)Math.tan(Math.toRadians(var1 / 2.0)));
        return (var0.z() < 0.0f) ? new Vector2f(-var0.x() * var3 + RotationUtils.pvi.getWindow().getGuiScaledWidth() / 2.0f, RotationUtils.pvi.getWindow().getGuiScaledHeight() / 2.0f - var0.y() * var3) : new Vector2f(Float.MAX_VALUE, Float.MAX_VALUE);
    }
    
    static {
        pvi = Minecraft.getInstance();
    }
}
