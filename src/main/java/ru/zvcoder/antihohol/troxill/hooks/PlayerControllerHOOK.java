// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.hooks;

import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.util.ClientRecipeBook;
import net.minecraft.stats.StatisticsManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerController;
import ru.zvcoder.antihohol.troxill.events.AttackEvent;

public class PlayerControllerHOOK extends PlayerController
{
    private final Minecraft aOD;
    
    public PlayerControllerHOOK(final Minecraft var1, final ClientPlayNetHandler var2) {
        super(var1, var2);
        this.aOD = Minecraft.getInstance();
    }
    
    public void attack(final PlayerEntity var1, final Entity var2) {
        final AttackEvent var3 = new AttackEvent(var1, var2);
        if (!var3.wex) {
            super.attack(var1, var2);
        }
    }
    
    public ClientPlayerEntity createPlayer(final ClientWorld var1, final StatisticsManager var2, final ClientRecipeBook var3) {
        return this.createPlayer(var1, var2, var3, false, false);
    }
    
    public ClientPlayerEntity createPlayer(final ClientWorld var1, final StatisticsManager var2, final ClientRecipeBook var3, final boolean var4, final boolean var5) {
        return new ClientPlayerHOOK(this.aOD, var1, this.aOD.getConnection(), var2, var3, var4, var5);
    }
}
