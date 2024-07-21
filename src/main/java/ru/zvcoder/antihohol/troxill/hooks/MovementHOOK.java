// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.hooks;

import net.minecraft.util.MovementInput;
import ru.zvcoder.antihohol.troxill.modules.ModuleManager;
import net.minecraft.client.Minecraft;
import net.minecraft.util.MovementInputFromOptions;

public class MovementHOOK extends MovementInputFromOptions
{
    public MovementHOOK() {
        super(Minecraft.getInstance().options);
    }
    
    public void tick(final boolean var1) {
        super.tick(var1);
        ModuleManager.onMove((MovementInput)this);
    }
}
