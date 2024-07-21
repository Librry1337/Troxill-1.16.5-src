// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules.combat;

import java.lang.reflect.Field;
import net.minecraft.network.play.client.CPlayerPacket;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import ru.zvcoder.antihohol.troxill.events.PlayerRotationEvent;
import ru.zvcoder.antihohol.troxill.events.AttackEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.Entity;
import ru.zvcoder.antihohol.troxill.clickgui.settings.Setting;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;
import ru.zvcoder.antihohol.troxill.modules.ModuleManager;
import ru.zvcoder.antihohol.troxill.utils.calc.MathUtils;
import net.minecraft.client.Minecraft;

public class HitboxModule extends AbstractModule
{
    public static AbstractModule IVI;
    private static final Minecraft ays;
    private static final MathUtils Uad;
    public final Setting LLY;
    private final Setting NFq;
    private final Setting JXT;
    private final Setting lAR;
    private final Setting AnT;
    double LGn;
    
    public HitboxModule(final int var1, final String[] var2, final int var3, final int var4) {
        super(var1, var2, var3, var4);
        this.LLY = ModuleManager.zWY(new Setting(this, false, new String[] { "In", "vi", "si", "bl", "e" }, 1, 1));
        this.NFq = ModuleManager.zWY(new Setting(this, new String[] { "Si", "ze" }, 0.5, 0.3, 1.0, false, 2));
        this.JXT = ModuleManager.zWY(new Setting(this, false, new String[] { "Byp", "ass" }, 1, 3));
        this.lAR = ModuleManager.zWY(new Setting(this, false, new String[] { "Movement", "Fix" }, 1, 4));
        this.AnT = ModuleManager.zWY(new Setting(this, false, new String[] { "Random" }, 1, 5));
        this.LGn = 0.0;
        HitboxModule.IVI = this;
    }
    
    public static void kXv() {
        if (HitboxModule.IVI.inu() && ((HitboxModule)HitboxModule.IVI).LLY.Xbo) {
            final double var0 = ((HitboxModule)HitboxModule.IVI).NFq.nUP;
            for (final Entity var3 : HitboxModule.ays.level.players()) {
                if (var3 != HitboxModule.ays.player) {
                    var3.setBoundingBox(new AxisAlignedBB(var3.getX() - var0, var3.getBoundingBox().minY, var3.getZ() - var0, var3.getX() + var0, var3.getBoundingBox().maxY, var3.getZ() + var0));
                }
            }
        }
    }
    
    public static void Iwr() {
        if (((HitboxModule)HitboxModule.IVI).LLY.Xbo) {
            for (final Entity var2 : HitboxModule.ays.level.players()) {
                if (var2 != HitboxModule.ays.player) {
                    var2.setBoundingBox(new AxisAlignedBB(var2.getX() - 0.30000001192092896, var2.getBoundingBox().minY, var2.getZ() - 0.30000001192092896, var2.getX() + 0.30000001192092896, var2.getBoundingBox().maxY, var2.getZ() + 0.30000001192092896));
                }
            }
        }
    }
    
    @Override
    public void onAttack(final AttackEvent var1) {
        if (this.AnT.Xbo) {
            this.LGn = Math.random() * 40.0 - 20.0;
        }
    }
    
    @Override
    public void HDK() {
        for (final Entity var2 : HitboxModule.ays.level.players()) {
            if (var2 != HitboxModule.ays.player) {
                var2.setBoundingBox(new AxisAlignedBB(var2.getX() - 0.30000001192092896, var2.getBoundingBox().minY, var2.getZ() - 0.30000001192092896, var2.getX() + 0.30000001192092896, var2.getBoundingBox().maxY, var2.getZ() + 0.30000001192092896));
            }
        }
    }
    
    @Override
    public void onEnable() {
        if (!this.LLY.Xbo) {
            final double var1 = this.NFq.nUP;
            for (final Entity var3 : HitboxModule.ays.level.players()) {
                if (var3 != HitboxModule.ays.player) {
                    var3.setBoundingBox(new AxisAlignedBB(var3.getX() - var1, var3.getBoundingBox().minY, var3.getZ() - var1, var3.getX() + var1, var3.getBoundingBox().maxY, var3.getZ() + var1));
                }
            }
        }
    }
    
    @Override
    public void onRotations(final PlayerRotationEvent var1) {
        if (this.lAR.Xbo && this.JXT.Xbo && HitboxModule.ays.hitResult != null && HitboxModule.ays.hitResult.getType() == RayTraceResult.Type.ENTITY) {
            final Entity var2 = ((EntityRayTraceResult)HitboxModule.ays.hitResult).getEntity();
            if (PlayerEntity.class.isInstance(var2)) {
                try {
                    final float[] var3 = MathUtils.YJR(var2, var1.pEh(), 100.0f, 50.0f);
                    if (this.LGn != 0.0) {
                        var3[0] += (float)this.LGn;
                        this.LGn = 0.0;
                    }
                    var1.QMO(var3[0]);
                }
                catch (final Exception var4) {
                    var4.printStackTrace();
                }
            }
        }
    }
    
    @Override
    public boolean HOx(final Object var1, final int var2) {
        if (this.JXT.Xbo && !this.lAR.Xbo && CPlayerPacket.class.isInstance(var1) && HitboxModule.ays.hitResult != null && HitboxModule.ays.hitResult.getType() == RayTraceResult.Type.ENTITY) {
            final Entity var3 = ((EntityRayTraceResult)HitboxModule.ays.hitResult).getEntity();
            if (PlayerEntity.class.isInstance(var3)) {
                try {
                    final Field var4 = CPlayerPacket.class.getDeclaredFields()[3];
                    var4.setAccessible(true);
                    final float[] var5 = MathUtils.YJR(var3, var4.getFloat(var1), 100.0f, 50.0f);
                    if (this.LGn != 0.0) {
                        var5[0] += (float)this.LGn;
                        this.LGn = 0.0;
                    }
                    var4.set(var1, var5[0]);
                }
                catch (final Exception var6) {
                    var6.printStackTrace();
                }
            }
        }
        return super.HOx(var1, var2);
    }
    
    static {
        ays = Minecraft.getInstance();
        Uad = new MathUtils();
    }
}
