// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules.movement;

import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.entity.player.RemoteClientPlayerEntity;
import net.minecraft.network.play.client.CPlayerPacket;
import ru.zvcoder.antihohol.troxill.utils.reflection.ReflectionUtil;
import net.minecraft.world.GameType;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.client.Minecraft;
import ru.zvcoder.antihohol.troxill.clickgui.settings.Setting;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;
import ru.zvcoder.antihohol.troxill.modules.ModuleManager;

public class FreeCamModule extends AbstractModule
{
    Setting owd;
    private final Minecraft nLB;
    private Vector3d qhr;
    private float tGV;
    private float LMT;
    private GameType Vqd;
    
    public FreeCamModule(final int var1, final String[] var2, final int var3, final int var4) {
        super(var1, var2, var3, var4);
        this.owd = ModuleManager.zWY(new Setting(this, new String[] { "Speed", ":" }, 2.0, 1.0, 5.0, false, 1));
        this.nLB = Minecraft.getInstance();
        this.qhr = null;
    }
    
    @Override
    public void Kxp() {
        if (this.nLB.player != null) {
            this.nLB.player.noPhysics = true;
            this.nLB.player.abilities.flying = true;
            this.qhr = this.nLB.player.position();
            this.tGV = this.nLB.player.xRot;
            this.LMT = this.nLB.player.yRot;
            this.GMc();
            this.Vqd = this.nLB.gameMode.getPlayerMode();
            ReflectionUtil.TkS(GameType.class, this.nLB.getConnection().getPlayerInfo(this.nLB.player.getUUID()), GameType.SPECTATOR);
        }
    }
    
    @Override
    public void onEnable() {
        this.nLB.player.abilities.setFlyingSpeed((float)(this.owd.nUP / 30.0));
    }
    
    @Override
    public void HDK() {
        if (this.nLB.player != null) {
            this.nLB.player.noPhysics = false;
            this.nLB.player.abilities.flying = false;
            if (this.qhr != null) {
                this.nLB.player.absMoveTo(this.qhr.x, this.qhr.y, this.qhr.z, this.LMT, this.tGV);
            }
            this.MAd();
            this.nLB.player.setDeltaMovement(Vector3d.ZERO);
            ReflectionUtil.TkS(GameType.class, this.nLB.getConnection().getPlayerInfo(this.nLB.player.getUUID()), this.Vqd);
        }
    }
    
    @Override
    public boolean HOx(final Object var1, final int var2) {
        return !CPlayerPacket.class.isInstance(var1) && super.HOx(var1, var2);
    }
    
    private void GMc() {
        final RemoteClientPlayerEntity var1 = new RemoteClientPlayerEntity(this.nLB.level, this.nLB.player.getGameProfile());
        var1.copyPosition((Entity)this.nLB.player);
        var1.containerMenu = this.nLB.player.containerMenu;
        this.nLB.level.addPlayer(1488, (AbstractClientPlayerEntity)var1);
    }
    
    private void MAd() {
        this.nLB.level.removeEntity(1488);
    }
}
