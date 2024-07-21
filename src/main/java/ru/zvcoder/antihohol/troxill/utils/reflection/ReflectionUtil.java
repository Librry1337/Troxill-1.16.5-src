// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.utils.reflection;

import java.lang.reflect.InvocationTargetException;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import net.minecraft.client.Minecraft;

public class ReflectionUtil
{
    public static Object bKO(final Class var0, final Object var1) {
        if (var1 != null) {
            for (final Field var5 : var1.getClass().getDeclaredFields()) {
                if (var0.isAssignableFrom(var5.getType())) {
                    var5.setAccessible(true);
                    try {
                        return var5.get(Minecraft.getInstance().getConnection().getPlayerInfo(Minecraft.getInstance().player.getUUID()));
                    }
                    catch (final IllegalAccessException var6) {
                        throw new RuntimeException(var6);
                    }
                }
            }
        }
        return new Object();
    }
    
    public static void TkS(final Class var0, final Object var1, final Object var2) {
        if (var1 != null) {
            for (final Field var6 : var1.getClass().getDeclaredFields()) {
                if (var0.isAssignableFrom(var6.getType())) {
                    var6.setAccessible(true);
                    try {
                        var6.set(var1, var2);
                    }
                    catch (final IllegalAccessException var7) {
                        throw new RuntimeException(var7);
                    }
                }
            }
        }
    }
    
    public static void IDd(final Class var0) {
        int var = 0;
        for (final Method var5 : var0.getDeclaredMethods()) {
            var5.setAccessible(true);
            final PrintStream var6 = System.out;
            final String var7 = var5.getName();
            var6.println(var7 + " " + var);
            ++var;
        }
    }
    
    public static Object JSq(final Class var0, final Object var1, final int var2, final Object... var3) {
        final Method var4 = var0.getDeclaredMethods()[var2];
        var4.setAccessible(true);
        try {
            return var4.invoke(var1, var3);
        }
        catch (final InvocationTargetException | IllegalAccessException var5) {
            throw new RuntimeException(var5);
        }
    }
}
