// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.events;

import ru.zvcoder.antihohol.troxill.modules.combat.HitboxModule;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;

public class HitboxRender extends GameRenderer
{
    public HitboxRender(final Minecraft var1) {
        super(var1, var1.getResourceManager(), var1.renderBuffers());
    }
    
    public void pick(final float var1) {
        if (HitboxModule.IVI != null && HitboxModule.IVI.inu() && Minecraft.getInstance().level != null) {
            HitboxModule.kXv();
        }
        super.pick(var1);
        if (HitboxModule.IVI != null && HitboxModule.IVI.inu() && Minecraft.getInstance().level != null) {
            HitboxModule.Iwr();
        }
    }
}
