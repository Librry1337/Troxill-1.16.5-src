// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.hooks;

import net.minecraft.util.MovementInput;
import java.util.HashMap;
import net.minecraft.client.KeyboardListener;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import java.lang.reflect.Field;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import java.util.Map;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.profiler.TimeTracker;
import ru.zvcoder.antihohol.troxill.events.KeyEvent;

public class HookUTIL
{
    static Class KNI;
    static Class Bhn;
    public static TimeTracker fsq;
    public static GameRenderer JqQ;
    private static final Map Ryo;
    private static Map gXo;
    private static PlayerRenderer Dvm;
    private static final MovementHOOK YaV;
    
    public static void INm() {
        final Minecraft var0 = Minecraft.getInstance();
        if (var0.player != null && !var0.player.input.equals(HookUTIL.YaV)) {
            var0.player.input = (MovementInput) HookUTIL.YaV;
        }
    }
    
    public static void cdp() {
    }
    
    public static void zvS() {
        final Minecraft var0 = Minecraft.getInstance();
        try {
            final EntityRendererManager var2 = var0.getEntityRenderDispatcher();
            HookUTIL.Ryo.put("default", new PlayerRendererHOOK(var2));
            HookUTIL.Ryo.put("slim", new PlayerRendererHOOK(var2, true));
            final Field var3 = EntityRendererManager.class.getDeclaredFields()[2];
            final Field var4 = EntityRendererManager.class.getDeclaredFields()[3];
            var3.setAccessible(true);
            var4.setAccessible(true);
            HookUTIL.gXo = (Map)var3.get(var2);
            HookUTIL.Dvm = (PlayerRenderer)var4.get(var2);
            var3.set(var2, HookUTIL.Ryo);
            var4.set(var2, new PlayerRendererHOOK(var2));
        }
        catch (final IllegalAccessException var5) {
            throw new RuntimeException(var5);
        }
        try {
            for (final Field var9 : Minecraft.class.getDeclaredFields()) {
                if (var9.getType().getName().contains(HookUTIL.Bhn.getName())) {
                    var9.setAccessible(true);
                    HookUTIL.fsq = (TimeTracker)var9.get(var0);
                    var9.set(var0, new TimeTrackerHOOK(System::nanoTime, () -> 0));
                }
                if (var9.getType().getName().contains(HookUTIL.KNI.getName())) {
                    final KeyEvent var10 = new KeyEvent(var0);
                    var10.setup(var0.getWindow().getWindow());
                    var9.setAccessible(true);
                    var9.set(var0, var10);
                }
            }
        }
        catch (final Exception var11) {
            var11.printStackTrace();
        }
    }
    
    public static void KIq(final Minecraft var0) {
        try {
            final EntityRendererManager var = var0.getEntityRenderDispatcher();
            for (final Field var5 : Minecraft.class.getDeclaredFields()) {
                if (var5.getType().getName().contains(TimeTracker.class.getName())) {
                    var5.setAccessible(true);
                    var5.set(var0, HookUTIL.fsq);
                }
                if (var5.getType().getName().contains(KeyboardListener.class.getName())) {
                    var5.setAccessible(true);
                    final KeyboardListener var6 = new KeyboardListener(var0);
                    var5.set(var0, var6);
                    var6.setup(var0.getWindow().getWindow());
                }
                if (var5.getType().getName().contains(GameRenderer.class.getName())) {
                    var5.setAccessible(true);
                    var5.set(var0, HookUTIL.JqQ);
                }
            }
            final Field var7 = EntityRendererManager.class.getDeclaredFields()[2];
            final Field var8 = EntityRendererManager.class.getDeclaredFields()[3];
            var7.setAccessible(true);
            var8.setAccessible(true);
            var7.set(var, HookUTIL.gXo);
            var8.set(var, HookUTIL.Dvm);
        }
        catch (final IllegalAccessException var9) {
            throw new RuntimeException(var9);
        }
    }
    
    static {
        HookUTIL.KNI = KeyboardListener.class;
        HookUTIL.Bhn = TimeTracker.class;
        Ryo = new HashMap();
        YaV = new MovementHOOK();
    }
}
