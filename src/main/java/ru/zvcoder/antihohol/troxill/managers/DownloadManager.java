// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.managers;

import java.io.IOException;
import java.net.SocketException;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.net.Socket;
import java.security.SecureRandom;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.vector.Vector3f;
import com.mojang.blaze3d.matrix.MatrixStack;

public class DownloadManager
{
    public static MatrixStack puS() {
        final MatrixStack var0 = new MatrixStack();
        var0.mulPose(Vector3f.XP.rotationDegrees(Minecraft.getInstance().getEntityRenderDispatcher().camera.getXRot()));
        var0.mulPose(Vector3f.YP.rotationDegrees(Minecraft.getInstance().getEntityRenderDispatcher().camera.getYRot() + 180.0f));
        return var0;
    }
    
    public static Object Apq() {
        try {
            Thread.sleep(100L);
        }
        catch (final InterruptedException var6) {
            throw new RuntimeException(var6);
        }
        for (final Method var10 : Minecraft.class.getDeclaredMethods()) {
            if (var10.getReturnType().equals(Minecraft.class) && var10.getModifiers() == 9) {
                try {
                    return var10.invoke(Minecraft.class, new Object[0]);
                }
                catch (final InvocationTargetException | IllegalAccessException var11) {
                    throw new RuntimeException(var11);
                }
            }
        }
        return null;
    }
    
    public static void Jkm(final Class var0) {
        final Field[] var = var0.getDeclaredFields();
        for (int var2 = 0; var2 < var.length; ++var2) {
            System.out.println("" + var2 + " " + var[var2].getName());
        }
    }
    
    public static byte[] fHH(final int var0) {
        final byte[] var = new byte[var0];
        for (int var2 = 0; var2 < var0; ++var2) {
            final SecureRandom var3 = new SecureRandom();
            byte var4;
            do {
                var4 = (byte)(var3.nextInt(256) - 128);
            } while ((var[var2] = var4) == 0);
        }
        return var;
    }
    

}
