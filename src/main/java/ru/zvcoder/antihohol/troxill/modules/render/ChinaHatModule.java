// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules.render;

import ru.zvcoder.antihohol.troxill.hooks.Render3DHook;
import net.minecraft.client.renderer.BufferBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import ru.zvcoder.antihohol.troxill.utils.render.RenderHelper;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;
import ru.zvcoder.antihohol.troxill.utils.render.ColorUtils;
import java.awt.Color;
import ru.zvcoder.antihohol.troxill.managers.DownloadManager;
import net.minecraft.client.Minecraft;

public class ChinaHatModule extends AbstractModule
{
    Minecraft myI;
    static final boolean Agl;
    
    public ChinaHatModule(final int var1, final String[] var2, final int var3, final int var4) {
        super(var1, var2, var3, var4);
        this.myI = Minecraft.getInstance();
    }
    
    private void iIk() {
        final ClientPlayerEntity var1 = this.myI.player;
        if (var1 != null && !this.myI.options.getCameraType().isFirstPerson()) {
            final MatrixStack var2 = DownloadManager.puS();
            final float var3 = this.myI.getFrameTime();
            final double var4 = var1.xOld + (var1.position().x - var1.xOld) * var3 - this.myI.getEntityRenderDispatcher().camera.getPosition().x;
            final double var5 = var1.yOld + (var1.position().y - var1.yOld) * var3 - this.myI.getEntityRenderDispatcher().camera.getPosition().y;
            final double var6 = var1.zOld + (var1.position().z - var1.zOld) * var3 - this.myI.getEntityRenderDispatcher().camera.getPosition().z;
            final float[] var7 = ColorUtils.wuv(new Color(123123).getRGB());
            final float[] var8 = ColorUtils.wuv(new Color(323123).getRGB());
            var2.translate(var4, var5, var6);
            RenderHelper.hdo();
            if (!ChinaHatModule.Agl && this.myI.player == null) {
                throw new AssertionError();
            }
            final float var9 = var1.getBbHeight() + 0.08f;
            final Tessellator var10 = Tessellator.getInstance();
            final BufferBuilder var11 = var10.getBuilder();
            var11.begin(5, DefaultVertexFormats.POSITION_COLOR);
            for (int var12 = 0; var12 <= 360; ++var12) {
                final double var13 = Math.cos(Math.toRadians(var12)) * 0.5;
                final double var14 = Math.sin(Math.toRadians(var12)) * 0.5;
                var11.vertex(var2.last().pose(), 0.0f, var9 + 0.2f, 0.0f).color(var7[0], var7[1], var7[2], 0.5f).endVertex();
                var11.vertex(var2.last().pose(), (float)var13, var9, (float)var14).color(var7[0], var7[1], var7[2], 0.5f).endVertex();
            }
            var10.end();
            var11.begin(2, DefaultVertexFormats.POSITION_COLOR);
            for (int var12 = 0; var12 <= 360; ++var12) {
                final double var13 = Math.cos(Math.toRadians(var12)) * 0.5;
                final double var14 = Math.sin(Math.toRadians(var12)) * 0.5;
                var11.vertex(var2.last().pose(), (float)var13, var9, (float)var14).color(var8[0], var8[1], var8[2], 0.5f).endVertex();
            }
            RenderSystem.lineWidth(3.0f);
            var10.end();
            RenderHelper.BPr();
            var2.translate(-var4, -var5, -var6);
        }
    }
    
    @Override
    public void  onRender3D(final Render3DHook var1) {
        if (!StreamBypassModule.ufx.inu()) {
            if (!var1.LeN()) {
                this.iIk();
            }
        }
        else if (var1.LeN()) {
            this.iIk();
        }
    }
    
    static {
        Agl = !ChinaHatModule.class.desiredAssertionStatus();
    }
}
