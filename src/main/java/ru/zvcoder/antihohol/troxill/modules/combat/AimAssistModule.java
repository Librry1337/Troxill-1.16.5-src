// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules.combat;

import net.minecraft.client.entity.player.ClientPlayerEntity;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;
import ru.zvcoder.antihohol.troxill.modules.ModuleManager;
import ru.zvcoder.antihohol.troxill.utils.render.ColorUtil2;
import net.minecraft.potion.Effects;
import ru.zvcoder.antihohol.troxill.managers.FriendManager;
import net.minecraft.entity.Entity;
import ru.zvcoder.antihohol.troxill.events.AttackEvent;
import ru.zvcoder.antihohol.troxill.utils.calc.MathUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import ru.zvcoder.antihohol.troxill.clickgui.settings.Setting;

public class AimAssistModule extends AbstractModule
{
    Setting jXF;
    Setting gCL;
    Setting WKp;
    private final Setting YcL;
    private final Setting oZY;
    PlayerEntity DCb;
    private static Minecraft IxS;
    private final MathUtils FEi;
    
    public AimAssistModule(final int var1, final String[] var2, final int var3, final int var4) {
        super(var1, var2, var3, var4);
        this.jXF = ModuleManager.zWY(new Setting(this, new String[] { "Distance", ":" }, 5.0, 2.0, 7.0, false, 1));
        this.gCL = ModuleManager.zWY(new Setting(this, new String[] { "yaw ", "speed", ":" }, 110.0, 0.0, 200.0, false, 2));
        this.WKp = ModuleManager.zWY(new Setting(this, new String[] { "pitch ", "speed", ":" }, 35.0, 0.0, 100.0, false, 3));
        this.YcL = ModuleManager.zWY(new Setting(this, false, new String[] { "Fri", "ends" }, 1, 4));
        this.oZY = ModuleManager.zWY(new Setting(this, false, new String[] { "Invisible", "s" }, 1, 5));
        this.FEi = new MathUtils();
    }
    
    @Override
    public void onAttack(final AttackEvent var1) {
        if (PlayerEntity.class.isInstance(var1.YpI)) {
            this.DCb = (PlayerEntity)var1.YpI;
        }
    }
    
    @Override
    public void onEnable() {
        if (AimAssistModule.IxS.player != null && AimAssistModule.IxS.level != null) {
            final ClientPlayerEntity var1 = AimAssistModule.IxS.player;
            final double var2 = this.jXF.Irt;
            if (this.DCb != null && AimAssistModule.IxS.player.distanceTo((Entity)this.DCb) > var2) {
                this.DCb = null;
                return;
            }
            final double var3 = this.jXF.nUP;
            if (this.DCb == null) {
                for (final PlayerEntity var5 : AimAssistModule.IxS.level.players()) {
                    if ((this.YcL.Xbo || !FriendManager.friendEntityMap.containsValue(var5)) && (this.oZY.Xbo || !var5.hasEffect(Effects.INVISIBILITY))) {
                        if (AimAssistModule.IxS.player.distanceTo((Entity)var5) <= var3 && var1 != var5) {
                            this.DCb = var5;
                            break;
                        }
                        continue;
                    }
                }
            }
            if (FriendManager.friendEntityMap.containsValue(this.DCb)) {
                this.DCb = null;
            }
            if (this.DCb == null) {
                return;
            }
            if (var1.isAlive() && this.DCb.isAlive()) {
                final float var6 = (float)(this.gCL.nUP / ColorUtil2.rLf()) * 5.0f;
                final float var7 = (float)(this.WKp.nUP / ColorUtil2.rLf()) * 5.0f;
                final float[] var8 = this.FEi.BBM((Entity)this.DCb, var6, var7, false);
                if (this.gCL.nUP > 0.0) {
                    var1.yRot = var8[0];
                }
                if (this.WKp.nUP > 0.0) {
                    var1.xRot = var8[1];
                }
            }
        }
    }
    
    static {
        AimAssistModule.IxS = Minecraft.getInstance();
    }
}
