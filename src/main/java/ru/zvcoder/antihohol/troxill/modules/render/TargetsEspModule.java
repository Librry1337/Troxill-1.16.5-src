/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  com.mojang.blaze3d.matrix.MatrixStack
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.util.math.vector.Matrix4f
 *  net.minecraft.util.math.vector.Vector3d
 *  org.lwjgl.opengl.GL46
 */
package ru.zvcoder.antihohol.troxill.modules.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3d;
import org.lwjgl.opengl.GL46;
import ru.zvcoder.antihohol.troxill.events.AttackEvent;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;
import ru.zvcoder.antihohol.troxill.utils.render.ColorUtils;
import ru.zvcoder.antihohol.troxill.utils.render.RenderHelper;
import ru.zvcoder.antihohol.troxill.hooks.Render3DHook;
import ru.zvcoder.antihohol.troxill.managers.DownloadManager;

public class TargetsEspModule
        extends AbstractModule {
    public static long MPL = System.currentTimeMillis();
    private Entity SHT;
    protected static Tessellator KGC = Tessellator.getInstance();
    protected static BufferBuilder vXw = KGC.getBuilder();
    private static final Minecraft aMf = Minecraft.getInstance();

    public TargetsEspModule(int var1, String[] var2, int var3, int var4) {
        super(var1, var2, var3, var4);
    }

    @Override
    public void  onRender3D(Render3DHook var1) {
        if (!StreamBypassModule.ufx.inu()) {
            if (!var1.LeN()) {
                if (this.SHT != null && (!this.SHT.isAlive() || this.SHT.distanceTo((Entity)TargetsEspModule.aMf.player) > 7.0f)) {
                    this.SHT = null;
                }
                if (this.SHT != null) {
                    TargetsEspModule.Pvw(DownloadManager.puS(), this.SHT);
                }
            }
        } else if (var1.LeN()) {
            if (this.SHT != null && (!this.SHT.isAlive() || this.SHT.distanceTo((Entity)TargetsEspModule.aMf.player) > 7.0f)) {
                this.SHT = null;
            }
            if (this.SHT != null) {
                TargetsEspModule.Pvw(DownloadManager.puS(), this.SHT);
            }
        }
    }

    @Override
    public void onAttack(AttackEvent var1) {
        if (var1.JIe == TargetsEspModule.aMf.player && PlayerEntity.class.isInstance(this.SHT)) {
            this.SHT = var1.YpI;
        }
    }

    public static void Pvw(MatrixStack var0, Entity var1) {
        int var18;
        int var16;
        ArrayList<Vector3d> var2 = new ArrayList<Vector3d>();
        ArrayList<Vector3d> var3 = new ArrayList<Vector3d>();
        ArrayList<Vector3d> var4 = new ArrayList<Vector3d>();
        float var5 = aMf.getFrameTime();
        double var6 = var1.xOld + (var1.getX() - var1.xOld) * (double)var5 - TargetsEspModule.aMf.getEntityRenderDispatcher().camera.getPosition().x;
        double var8 = var1.yOld + (var1.getY() - var1.yOld) * (double)var5 - TargetsEspModule.aMf.getEntityRenderDispatcher().camera.getPosition().y;
        double var10 = var1.zOld + (var1.getZ() - var1.zOld) * (double)var5 - TargetsEspModule.aMf.getEntityRenderDispatcher().camera.getPosition().z;
        int var12 = 8;
        double var13 = var1.getBbHeight();
        Matrix4f var15 = var0.last().pose();
        for (var16 = 0; var16 <= 360; ++var16) {
            double var17 = Math.sin(Math.toRadians(var16));
            double var19 = Math.cos(Math.toRadians(var16));
            Vector3d var21 = new Vector3d((double)((float)(var19 * 0.5)), var13, (double)((float)(var17 * 0.5)));
            var2.add(var21);
            double var22 = Math.sin(Math.toRadians((var16 + 120) % 360));
            double var24 = Math.cos(Math.toRadians(var16 + 120) % 360.0);
            Vector3d var26 = new Vector3d((double)((float)(var24 * 0.5)), var13, (double)((float)(var22 * 0.5)));
            var3.add(var26);
            double var27 = Math.sin(Math.toRadians((var16 + 240) % 360));
            double var29 = Math.cos(Math.toRadians((var16 + 240) % 360));
            Vector3d var31 = new Vector3d((double)((float)(var29 * 0.5)), var13, (double)((float)(var27 * 0.5)));
            var4.add(var31);
            var13 -= (double)0.004f;
        }
        var0.translate(var6, var8, var10);
        RenderHelper.hdo();
        RenderSystem.depthMask((boolean)true);
        RenderSystem.disableCull();
        RenderSystem.enableAlphaTest();
        GL46.glEnable((int)3042);
        vXw.begin(var12, DefaultVertexFormats.POSITION_COLOR);
        for (var16 = 0; var16 < var2.size() - 1; ++var16) {
            float var32 = 1.0f - ((float)var16 + (float)(System.currentTimeMillis() - MPL) / 5.0f) % 340.0f / 60.0f;
            var18 = ColorUtils.nqm(RenderHelper.SCc(0, 1.0f, 1.0f).getRGB(), (int)(var32 * 255.0f));
            vXw.vertex(var15, (float)((Vector3d)var2.get((int)var16)).x, (float)((Vector3d)var2.get((int)var16)).y, (float)((Vector3d)var2.get((int)var16)).z).color(ColorUtils.PYX(var18), ColorUtils.GuW(var18), ColorUtils.psu(var18), ColorUtils.DOL(var18)).endVertex();
            vXw.vertex(var15, (float)((Vector3d)var2.get((int)(var16 + 1))).x, (float)((Vector3d)var2.get((int)(var16 + 1))).y + 0.1f, (float)((Vector3d)var2.get((int)(var16 + 1))).z).color(ColorUtils.PYX(var18), ColorUtils.GuW(var18), ColorUtils.psu(var18), ColorUtils.DOL(var18)).endVertex();
        }
        KGC.end();
        vXw.begin(var12, DefaultVertexFormats.POSITION_COLOR);
        for (var16 = 0; var16 < var3.size() - 1; ++var16) {
            float var32 = 1.0f - ((float)var16 + (float)(System.currentTimeMillis() - MPL) / 5.0f) % 340.0f / 60.0f;
            var18 = ColorUtils.nqm(RenderHelper.SCc(2000, 1.0f, 1.0f).getRGB(), (int)(var32 * 255.0f));
            vXw.vertex(var15, (float)((Vector3d)var3.get((int)var16)).x, (float)((Vector3d)var3.get((int)var16)).y, (float)((Vector3d)var3.get((int)var16)).z).color(ColorUtils.PYX(var18), ColorUtils.GuW(var18), ColorUtils.psu(var18), ColorUtils.DOL(var18)).endVertex();
            vXw.vertex(var15, (float)((Vector3d)var3.get((int)(var16 + 1))).x, (float)((Vector3d)var3.get((int)(var16 + 1))).y + 0.1f, (float)((Vector3d)var3.get((int)(var16 + 1))).z).color(ColorUtils.PYX(var18), ColorUtils.GuW(var18), ColorUtils.psu(var18), ColorUtils.DOL(var18)).endVertex();
        }
        KGC.end();
        vXw.begin(var12, DefaultVertexFormats.POSITION_COLOR);
        for (var16 = 0; var16 < var4.size() - 1; ++var16) {
            float var32 = 1.0f - ((float)var16 + (float)(System.currentTimeMillis() - MPL) / 5.0f) % 340.0f / 60.0f;
            var18 = ColorUtils.nqm(RenderHelper.SCc(4000, 1.0f, 1.0f).getRGB(), (int)(var32 * 255.0f));
            vXw.vertex(var15, (float)((Vector3d)var4.get((int)var16)).x, (float)((Vector3d)var4.get((int)var16)).y, (float)((Vector3d)var4.get((int)var16)).z).color(ColorUtils.PYX(var18), ColorUtils.GuW(var18), ColorUtils.psu(var18), ColorUtils.DOL(var18)).endVertex();
            vXw.vertex(var15, (float)((Vector3d)var4.get((int)(var16 + 1))).x, (float)((Vector3d)var4.get((int)(var16 + 1))).y + 0.1f, (float)((Vector3d)var4.get((int)(var16 + 1))).z).color(ColorUtils.PYX(var18), ColorUtils.GuW(var18), ColorUtils.psu(var18), ColorUtils.DOL(var18)).endVertex();
        }
        KGC.end();
        RenderHelper.BPr();
    }
}

