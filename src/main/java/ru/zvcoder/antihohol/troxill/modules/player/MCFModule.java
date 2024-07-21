// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules.player;

import net.minecraft.entity.Entity;
import ru.zvcoder.antihohol.troxill.managers.FriendManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import ru.zvcoder.antihohol.troxill.events.MouseEvent;
import net.minecraft.client.Minecraft;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;

public class MCFModule extends AbstractModule
{
    Minecraft minecraft;
    
    public MCFModule(final int var1, final String[] var2, final int var3, final int var4) {
        super(var1, var2, var3, var4);
        this.minecraft = Minecraft.getInstance();
    }
    
    @Override
    public void onMouse(final MouseEvent var1) {
        if (this.minecraft.player != null && var1.Lfk == 2 && var1.Dan == 1 && this.minecraft.hitResult != null && this.minecraft.hitResult.getType() == RayTraceResult.Type.ENTITY) {
            final Entity hittedEntity = ((EntityRayTraceResult)this.minecraft.hitResult).getEntity();
            if (hittedEntity instanceof PlayerEntity) {
                final String username = hittedEntity.getName().getString();
                if (FriendManager.friendEntityMap.containsKey(username)) {
                    FriendManager.friendEntityMap.remove(username);
                }
                else {
                    FriendManager.friendEntityMap.put(username, hittedEntity);
                }
            }
        }
    }
}
