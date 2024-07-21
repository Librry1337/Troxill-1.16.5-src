// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.events;

import net.minecraft.world.GameType;
import ru.zvcoder.antihohol.troxill.Initializer;
import ru.zvcoder.antihohol.troxill.hooks.PlayerControllerHOOK;
import ru.zvcoder.antihohol.troxill.modules.ModuleManager;
import net.minecraft.world.World;
import net.minecraft.client.Minecraft;
import ru.zvcoder.antihohol.troxill.packets.PacketHandler;

public class UpdateEvent
{
    private static final Minecraft uEc;
    private static World cKv;
    private PlayerControllerHOOK NTg;
    
    public UpdateEvent() {
        this.NTg = new PlayerControllerHOOK(UpdateEvent.uEc, UpdateEvent.uEc.getConnection());
    }
    
    public static void MZW() {
        ModuleManager.VCU();
        new PacketHandler(Initializer.moduleManager);
        if ((UpdateEvent.cKv == null || UpdateEvent.uEc.player == null || !UpdateEvent.uEc.player.isAlive()) && UpdateEvent.uEc.level != null && UpdateEvent.uEc.gameMode != null) {
            final GameType var0 = UpdateEvent.uEc.gameMode.getPlayerMode();
            (UpdateEvent.uEc.gameMode = new PlayerControllerHOOK(UpdateEvent.uEc, UpdateEvent.uEc.getConnection())).setLocalMode(var0);
            UpdateEvent.cKv = (World) UpdateEvent.uEc.level;
        }
        if (UpdateEvent.cKv != UpdateEvent.uEc.level && UpdateEvent.uEc.gameMode != null) {
            final GameType var0 = UpdateEvent.uEc.gameMode.getPlayerMode();
            (UpdateEvent.uEc.gameMode = new PlayerControllerHOOK(UpdateEvent.uEc, UpdateEvent.uEc.getConnection())).setLocalMode(var0);
            UpdateEvent.cKv = (World) UpdateEvent.uEc.level;
        }
    }
    
    static {
        uEc = Minecraft.getInstance();
    }
}
