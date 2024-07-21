// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules.render;

import net.minecraft.client.Minecraft;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;

public class NoHurtCamModule extends AbstractModule
{
    public NoHurtCamModule(final int var1, final String[] var2, final int var3, final int var4) {
        super(var1, var2, var3, var4);
    }
    
    @Override
    public void onEnable() {
        Minecraft.getInstance().player.hurtTime = 0;
    }
}
