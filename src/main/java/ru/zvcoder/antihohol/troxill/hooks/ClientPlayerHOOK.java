// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.hooks;

import ru.zvcoder.antihohol.troxill.events.PlayerRotationEvent;
import ru.zvcoder.antihohol.troxill.modules.ModuleManager;
import net.minecraft.client.util.ClientRecipeBook;
import net.minecraft.stats.StatisticsManager;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;

public class ClientPlayerHOOK extends ClientPlayerEntity
{
    public PlayerRotationEvent CzN;
    
    public ClientPlayerHOOK(final Minecraft var1, final ClientWorld var2, final ClientPlayNetHandler var3, final StatisticsManager var4, final ClientRecipeBook var5, final boolean var6, final boolean var7) {
        super(var1, var2, var3, var4, var5, var6, var7);
        this.CzN = new PlayerRotationEvent(0.0f, 0.0f);
    }
    
    public void tick() {
        ModuleManager.rFC(this.CzN = new PlayerRotationEvent(super.xRot, super.yRot));
        super.xRot = this.CzN.nxX();
        super.yRot = this.CzN.VLT();
        super.tick();
        super.xRot = this.CzN.aLl();
        super.yRot = this.CzN.pEh();
    }
    
    public void serverAiStep() {
        super.xRot = this.CzN.aLl();
        super.yRot = this.CzN.pEh();
        super.serverAiStep();
        super.yHeadRot = this.CzN.VLT();
        super.xRot = this.CzN.nxX();
        super.yRot = this.CzN.VLT();
    }
}
