// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules.player;

import net.minecraft.client.Minecraft;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;

public class NoPushModule extends AbstractModule
{
    Minecraft bzG;
    private float dpv;
    
    public NoPushModule(final int var1, final String[] var2, final int var3, final int var4) {
        super(var1, var2, var3, var4);
        this.bzG = Minecraft.getInstance();
    }
    
    @Override
    public void onEnable() {
        this.bzG.player.pushthrough = 1.0f;
    }
    
    @Override
    public void Kxp() {
        this.dpv = this.bzG.player.pushthrough;
    }
    
    @Override
    public void HDK() {
        this.bzG.player.pushthrough = this.dpv;
    }
}
