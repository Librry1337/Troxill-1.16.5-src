// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules.player;

import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;

public class NoHitBoxesModule extends AbstractModule
{
    Minecraft yID;
    
    public NoHitBoxesModule(final int var1, final String[] var2, final int var3, final int var4) {
        super(var1, var2, var3, var4);
        this.yID = Minecraft.getInstance();
    }
    
    @Override
    public void onEnable() {
        for (final PlayerEntity var2 : this.yID.level.players()) {
            if (var2 != this.yID.player) {
                var2.setBoundingBox(new AxisAlignedBB(var2.getX() - 0.0, var2.getBoundingBox().minY, var2.getZ() - 0.0, var2.getX() + 0.0, var2.getBoundingBox().maxY, var2.getZ() + 0.0));
            }
        }
    }
    
    @Override
    public void HDK() {
        for (final PlayerEntity var2 : this.yID.level.players()) {
            if (var2 != this.yID.player) {
                var2.setBoundingBox(new AxisAlignedBB(var2.getX() - 0.3, var2.getBoundingBox().minY, var2.getZ() - 0.3, var2.getX() + 0.3, var2.getBoundingBox().maxY, var2.getZ() + 0.3));
            }
        }
    }
}
