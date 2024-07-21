// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.events;

import ru.zvcoder.antihohol.troxill.modules.ModuleManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

public class AttackEvent
{
    public final PlayerEntity JIe;
    public final Entity YpI;
    public boolean wex;
    
    public AttackEvent(final PlayerEntity var1, final Entity var2) {
        this.JIe = var1;
        this.YpI = var2;
        ModuleManager.Ted(this);
    }
}
