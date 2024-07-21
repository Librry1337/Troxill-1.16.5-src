// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules.render;

import ru.zvcoder.antihohol.troxill.hooks.Render3DHook;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.vector.Matrix4f;
import org.lwjgl.opengl.GL11;
import net.minecraft.util.math.vector.Vector4f;
import ru.zvcoder.antihohol.troxill.managers.DownloadManager;
import net.minecraft.util.math.vector.Vector3d;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;

public class TracersModule extends AbstractModule
{
    Minecraft TBV;
    private final Color cOk;
    
    public TracersModule(final int var1, final String[] var2, final int var3, final int var4) {
        super(var1, var2, var3, var4);
        this.TBV = Minecraft.getInstance();
        this.cOk = new Color(10616956);
    }
    
    private static void bff(final Vector3d var0, final Vector3d var1) {
        final Matrix4f var2 = DownloadManager.puS().last().pose();
        final Vector4f var3 = new Vector4f((float)var0.x, (float)var0.y, (float)var0.z, 1.0f);
        var3.transform(var2);
        final Vector4f var4 = new Vector4f((float)var1.x, (float)var1.y, (float)var1.z, 1.0f);
        var4.transform(var2);
        GL11.glVertex3f(var3.x(), 0.0f, var3.z());
        GL11.glVertex3f(var4.x(), var4.y(), var4.z());
    }
    
    private void BEm() {
        if (this.TBV.level != null && this.TBV.player != null) {
            for (final PlayerEntity var2 : this.TBV.level.players()) {
                if (var2 != this.TBV.player) {
                    GL11.glPushMatrix();
                    GL11.glDisable(3553);
                    GL11.glDisable(2929);
                    GL11.glEnable(3042);
                    GL11.glBlendFunc(770, 771);
                    GL11.glEnable(2848);
                    GL11.glHint(3154, 4354);
                    GL11.glColor4d((double)this.cOk.getRed(), (double)this.cOk.getGreen(), (double)this.cOk.getBlue(), (double)this.cOk.getAlpha());
                    final Vector3d var3 = this.TBV.player.getEyePosition(this.TBV.getFrameTime());
                    final Vector3d var4 = var2.getEyePosition(this.TBV.getFrameTime());
                    Vector3d var5 = new Vector3d(0.0, 0.0, 0.0);
                    final Entity var6 = this.TBV.cameraEntity;
                    if (this.TBV.gameRenderer != null) {
                        final Vector3d var7 = this.TBV.gameRenderer.getMainCamera().getPosition();
                        if (this.TBV.gameRenderer.getMainCamera().isDetached()) {
                            var5 = var3.subtract(var7);
                        }
                        else if (var6 != null) {
                            final Vector3d var8 = var6.getViewVector(this.TBV.getFrameTime());
                            var5 = var3.add(var8).subtract(var7);
                        }
                        final Vector3d var9 = var4.subtract(var7);
                        GL11.glLineWidth(2.0f);
                        GL11.glBegin(1);
                        bff(var5, var9);
                        GL11.glEnd();
                    }
                    GL11.glEnable(3553);
                    GL11.glEnable(2929);
                    GL11.glDisable(3042);
                    GL11.glDisable(2848);
                    GL11.glPopMatrix();
                }
            }
        }
    }
    
    @Override
    public void  onRender3D(final Render3DHook var1) {
        if (!StreamBypassModule.ufx.inu()) {
            if (!var1.LeN()) {
                this.BEm();
            }
        }
        else if (var1.LeN()) {
            this.BEm();
        }
    }
}
