// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.hooks;

import net.minecraft.profiler.IProfileResult;
import java.util.function.Supplier;
import java.lang.reflect.Field;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.profiler.IResultableProfiler;
import ru.zvcoder.antihohol.troxill.events.HitboxRender;
import ru.zvcoder.antihohol.troxill.events.UpdateEvent;

public class ProfilerHOOK implements IResultableProfiler
{
    public static ProfilerHOOK MHg;
    
    public void startTick() {
    }
    
    public void endTick() {
    }
    
    public void push(final String var1) {
        if (var1.contains("sound")) {
            final Minecraft var2 = Minecraft.getInstance();
            if (var2.player != null && var2.level != null) {
                UpdateEvent.MZW();
            }
            if (HookUTIL.JqQ == null) {
                for (final Field var6 : Minecraft.class.getDeclaredFields()) {
                    if (var6.getType().getName().contains(GameRenderer.class.getName())) {
                        try {
                            var6.setAccessible(true);
                            HookUTIL.JqQ = (GameRenderer)var6.get(var2);
                            var6.set(var2, new HitboxRender(var2));
                        }
                        catch (final Exception var7) {
                            var7.printStackTrace();
                        }
                    }
                }
            }
        }
        if (var1.toLowerCase().contains("bosshealth")) {
            new RenderHOOK(false);
        }
    }
    
    public void push(final Supplier var1) {
    }
    
    public void pop() {
    }
    
    public void popPush(final String var1) {
        if (var1.contains("hand")) {
            new Render3DHook(false);
        }
    }
    
    public void popPush(final Supplier var1) {
    }
    
    public void incrementCounter(final String var1) {
    }
    
    public void incrementCounter(final Supplier var1) {
    }
    
    public IProfileResult getResults() {
        return null;
    }
    
    static {
        ProfilerHOOK.MHg = new ProfilerHOOK();
    }
}
