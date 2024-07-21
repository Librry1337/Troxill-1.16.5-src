// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.utils.render;

import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.client.renderer.WorldVertexBufferUploader;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.opengl.GL30;
import java.awt.Graphics;
import java.util.Objects;
import com.mojang.blaze3d.systems.RenderSystem;
import java.nio.ByteBuffer;
import org.lwjgl.BufferUtils;
import com.mojang.blaze3d.platform.GlStateManager;
import java.awt.image.BufferedImage;
import org.lwjgl.opengl.GL11;
import java.awt.Color;
import java.util.HashMap;
import net.minecraft.client.Minecraft;

public class RenderHelper
{
    private static final int tgs = 1000;
    private static Minecraft aXV;
    public static final HashMap<Integer,Integer> Uoj;
    protected static float yFI;
    private static double MCB;
    private static double hHR;
    private static double UMu;
    private static double HdB;
    private static int Sdk;
    
    public static Color SCc(final int var0, final float var1, final float var2) {
        double var3 = Math.ceil((System.currentTimeMillis() + var0) / 16.0);
        var3 %= 1000.0;
        return Color.getHSBColor((float)(var3 / 1000.0), var1, var2);
    }
    
    public static void Rkd(final float var0, final float var1, final float var2, final float var3, final int var4, final float var5) {
        final float var6 = (var4 >> 24 & 0xFF) / 255.0f;
        final float var7 = (var4 >> 16 & 0xFF) / 255.0f;
        final float var8 = (var4 >> 8 & 0xFF) / 255.0f;
        final float var9 = (var4 & 0xFF) / 255.0f;
        GL11.glPushMatrix();
        GL11.glColor4f(var7, var8, var9, var6);
        GL11.glTranslatef(var0, var1, 0.0f);
        GL11.glRotatef(180.0f + var3, 0.0f, 0.0f, 1.0f);
        GL11.glTranslatef(-var0, -var1, 0.0f);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glLineWidth(var5);
        GL11.glBegin(1);
        GL11.glVertex2f(var0, var1 - var2);
        GL11.glVertex2f(var0 + var2, var1);
        GL11.glVertex2f(var0, var1 + var2);
        GL11.glVertex2f(var0 + var2, var1);
        GL11.glEnd();
        GL11.glDisable(2848);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }
    
    public static int ZQI(final BufferedImage var0) {
        final int var = GlStateManager._genTexture();
        GlStateManager._bindTexture(var);
        final int var2 = var0.getWidth();
        final int var3 = var0.getHeight();
        final int[] var4 = new int[var2 * var3];
        var0.getRGB(0, 0, var2, var3, var4, 0, var2);
        final ByteBuffer var5 = BufferUtils.createByteBuffer(var2 * var3 * 4);
        final int[] var6 = var4;
        for (int var7 = var4.length, var8 = 0; var8 < var7; ++var8) {
            final int var9 = var6[var8];
            ByteBuffer var10 = var5.put((byte)(var9 >> 16 & 0xFF));
            var10 = var5.put((byte)(var9 >> 8 & 0xFF));
            var10 = var5.put((byte)(var9 & 0xFF));
            var10 = var5.put((byte)(var9 >> 24 & 0xFF));
        }
        ByteBuffer var10 = (ByteBuffer)var5.flip();
        GL11.glTexImage2D(3553, 0, 6408, var2, var3, 0, 6408, 5121, var5);
        GL11.glTexParameteri(3553, 10241, 9729);
        GL11.glTexParameteri(3553, 10240, 9729);
        GlStateManager._bindTexture(0);
        return var;
    }
    
    public static void niV(final int var0) {
        RenderSystem.color4f((var0 >> 16 & 0xFF) / 255.0f, (var0 >> 8 & 0xFF) / 255.0f, (var0 & 0xFF) / 255.0f, (var0 >> 24 & 0xFF) / 255.0f);
    }
    
    public static void ASa(float var0, float var1, float var2, float var3, final int var4, final int var5) {
        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GL11.glPushMatrix();
        GL11.glAlphaFunc(516, 0.01f);
        var2 += var4 * 2;
        var3 += var4 * 2;
        var0 -= var4;
        var1 -= var4;
        final int var6 = Objects.hash((int)var2, (int)var3, var4);
        int var7;
        if (RenderHelper.Uoj.containsKey(var6)) {
            var7 = RenderHelper.Uoj.get(var6);
        }
        else {
            if (var2 <= 0.0f) {
                var2 = 1.0f;
            }
            if (var3 <= 0.0f) {
                var3 = 1.0f;
            }
            final BufferedImage var8 = new BufferedImage((int)var2, (int)var3, 3);
            final Graphics var9 = var8.getGraphics();
            var9.setColor(Color.white);
            var9.fillRect(var4, var4, (int)(var2 - var4 * 2), (int)(var3 - var4 * 2));
            var9.dispose();
            final ImageRenderer var10 = new ImageRenderer((float)var4);
            final BufferedImage var11 = var10.KmN(var8, null);
            var7 = ZQI(var11);
            RenderHelper.Uoj.put(var6, var7);
        }
        GlStateManager._clearCurrentColor();
        xXu();
        GL11.glEnable(3042);
        GL11.glEnable(3553);
        GlStateManager._bindTexture(var7);
        gww(var5);
        hul(var0, var1, var2, var3);
        GlStateManager._bindTexture(0);
        GL11.glDisable(3042);
        iGq();
        GlStateManager._clearCurrentColor();
        GL11.glPopMatrix();
    }
    
    public static void xXu() {
        GlStateManager._disableTexture();
        GlStateManager._enableBlend();
        GlStateManager._blendFunc(770, 771);
    }
    
    public static void iGq() {
        GlStateManager._enableTexture();
        GlStateManager._disableBlend();
        niV(-1);
    }
    
    public static void hul(final float var0, final float var1, final float var2, final float var3) {
        GL30.glBegin(7);
        GL30.glTexCoord2d(0.0, 0.0);
        GL30.glVertex2d((double)var0, (double)var1);
        GL30.glTexCoord2d(0.0, 1.0);
        GL30.glVertex2d((double)var0, (double)(var1 + var3));
        GL30.glTexCoord2d(1.0, 1.0);
        GL30.glVertex2d((double)(var0 + var2), (double)(var1 + var3));
        GL30.glTexCoord2d(1.0, 0.0);
        GL30.glVertex2d((double)(var0 + var2), (double)var1);
        GL30.glEnd();
    }
    
    public static void gww(final int var0) {
        final float var = (var0 >> 24 & 0xFF) / 255.0f;
        final float var2 = (var0 >> 16 & 0xFF) / 255.0f;
        final float var3 = (var0 >> 8 & 0xFF) / 255.0f;
        final float var4 = (var0 & 0xFF) / 255.0f;
        GL11.glColor4f(var2, var3, var4, var);
    }
    
    public static void hdo() {
        RenderSystem.disableTexture();
        RenderSystem.enableBlend();
        RenderSystem.disableAlphaTest();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableCull();
        RenderSystem.shadeModel(7425);
        RenderSystem.depthMask(false);
    }
    
    public static void BPr() {
        RenderSystem.depthMask(true);
        RenderSystem.shadeModel(7424);
        RenderSystem.enableCull();
        RenderSystem.disableBlend();
        RenderSystem.enableAlphaTest();
        RenderSystem.disableBlend();
        RenderSystem.enableTexture();
    }
    
    public static void oZN(final double var0, final double var2, final double var4, final double var6, final int var8, final int var9, final int var10, final int var11) {
        final float var12 = (var8 >> 24 & 0xFF) / 255.0f;
        final float var13 = (var8 >> 16 & 0xFF) / 255.0f;
        final float var14 = (var8 >> 8 & 0xFF) / 255.0f;
        final float var15 = (var8 & 0xFF) / 255.0f;
        final float var16 = (var9 >> 24 & 0xFF) / 255.0f;
        final float var17 = (var9 >> 16 & 0xFF) / 255.0f;
        final float var18 = (var9 >> 8 & 0xFF) / 255.0f;
        final float var19 = (var9 & 0xFF) / 255.0f;
        final float var20 = (var10 >> 24 & 0xFF) / 255.0f;
        final float var21 = (var10 >> 16 & 0xFF) / 255.0f;
        final float var22 = (var10 >> 8 & 0xFF) / 255.0f;
        final float var23 = (var10 & 0xFF) / 255.0f;
        final float var24 = (var11 >> 24 & 0xFF) / 255.0f;
        final float var25 = (var11 >> 16 & 0xFF) / 255.0f;
        final float var26 = (var11 >> 8 & 0xFF) / 255.0f;
        final float var27 = (var11 & 0xFF) / 255.0f;
        GlStateManager._disableTexture();
        GlStateManager._enableBlend();
        GlStateManager._disableAlphaTest();
        GlStateManager._blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA.value, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA.value, GlStateManager.SourceFactor.ONE.value, GlStateManager.DestFactor.ZERO.value);
        GlStateManager._shadeModel(7425);
        final Tessellator var28 = Tessellator.getInstance();
        final BufferBuilder var29 = var28.getBuilder();
        var29.begin(7, DefaultVertexFormats.POSITION_COLOR);
        var29.vertex(var4, var2, (double)RenderHelper.yFI).color(var13, var14, var15, var12).endVertex();
        var29.vertex(var0, var2, (double)RenderHelper.yFI).color(var17, var18, var19, var16).endVertex();
        var29.vertex(var0, var6, (double)RenderHelper.yFI).color(var21, var22, var23, var20).endVertex();
        var29.vertex(var4, var6, (double)RenderHelper.yFI).color(var25, var26, var27, var24).endVertex();
        var28.end();
        GlStateManager._shadeModel(7424);
        GlStateManager._disableBlend();
        GlStateManager._enableAlphaTest();
        GlStateManager._enableTexture();
    }
    
    public static void zCv(final double var0, final double var2, final double var4, final double var6, final int var8, final int var9) {
        final float var10 = (var8 >> 24 & 0xFF) / 255.0f;
        final float var11 = (var8 >> 16 & 0xFF) / 255.0f;
        final float var12 = (var8 >> 8 & 0xFF) / 255.0f;
        final float var13 = (var8 & 0xFF) / 255.0f;
        final float var14 = (var9 >> 24 & 0xFF) / 255.0f;
        final float var15 = (var9 >> 16 & 0xFF) / 255.0f;
        final float var16 = (var9 >> 8 & 0xFF) / 255.0f;
        final float var17 = (var9 & 0xFF) / 255.0f;
        GlStateManager._disableTexture();
        GlStateManager._enableBlend();
        GlStateManager._disableAlphaTest();
        GlStateManager._blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA.value, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA.value, GlStateManager.SourceFactor.ONE.value, GlStateManager.DestFactor.ZERO.value);
        GlStateManager._shadeModel(7425);
        final Tessellator var18 = Tessellator.getInstance();
        final BufferBuilder var19 = var18.getBuilder();
        var19.begin(7, DefaultVertexFormats.POSITION_COLOR);
        var19.vertex(var4, var2, (double)RenderHelper.yFI).color(var11, var12, var13, var10).endVertex();
        var19.vertex(var0, var2, (double)RenderHelper.yFI).color(var11, var12, var13, var10).endVertex();
        var19.vertex(var0, var6, (double)RenderHelper.yFI).color(var15, var16, var17, var14).endVertex();
        var19.vertex(var4, var6, (double)RenderHelper.yFI).color(var15, var16, var17, var14).endVertex();
        var18.end();
        GlStateManager._shadeModel(7424);
        GlStateManager._disableBlend();
        GlStateManager._enableAlphaTest();
        GlStateManager._enableTexture();
    }
    
    public static void sTN(final int var0, final float var1, final float var2, final float var3, final float var4, final int var5) {
        final double var6 = 6.2831852 / var0;
        final float var7 = (float)Math.cos(var6);
        final float var8 = (float)Math.sin(var6);
        float var9 = (float)Math.sin(Math.toRadians(var4)) * var3;
        float var10 = (float)Math.cos(Math.toRadians(180.0f - var4)) * var3;
        final float var11 = (var5 >> 24 & 0xFF) / 255.0f;
        final float var12 = (var5 >> 16 & 0xFF) / 255.0f;
        final float var13 = (var5 >> 8 & 0xFF) / 255.0f;
        final float var14 = (var5 & 0xFF) / 255.0f;
        GL11.glColor4f(var11, var12, var13, var14);
        GL11.glBegin(2);
        float var15 = 0.0f;
        for (int var16 = 0; var16 < var0; ++var16) {
            GL11.glVertex2f(var1 + var9, var2 + var10);
            var15 = var9;
            var9 = var7 * var9 - var8 * var10;
            var10 = var8 * var15 + var7 * var10;
        }
        GL11.glEnd();
    }
    
    public static void apb(final double var0, final double var2, final double var4, final double var6, final int var8) {
        final double var9 = var4 / var8;
        for (int var10 = 0; var10 < var8; ++var10) {
            final int var11 = Dtc(var10, var8);
            Bzy(var0 + var10 * var9, var2, var0 + (var10 + 1) * var9, var6, var11);
        }
    }
    
    public static int Dtc(final int var0, final int var1) {
        final float var2 = var0 / (float)var1;
        return Color.HSBtoRGB(var2, 1.0f, 1.0f);
    }
    
    public static void Bzy(double var0, double var2, double var4, double var6, final int var8) {
        final MatrixStack var9 = new MatrixStack();
        if (var0 < var4) {
            final double var10 = var0;
            var0 = var4;
            var4 = var10;
        }
        if (var2 < var6) {
            final double var10 = var2;
            var2 = var6;
            var6 = var10;
        }
        final float var11 = (var8 >> 24 & 0xFF) / 255.0f;
        final float var12 = (var8 >> 16 & 0xFF) / 255.0f;
        final float var13 = (var8 >> 8 & 0xFF) / 255.0f;
        final float var14 = (var8 & 0xFF) / 255.0f;
        final BufferBuilder var15 = Tessellator.getInstance().getBuilder();
        RenderSystem.enableBlend();
        RenderSystem.disableTexture();
        RenderSystem.defaultBlendFunc();
        final Matrix4f var16 = var9.last().pose();
        var15.begin(7, DefaultVertexFormats.POSITION_COLOR);
        var15.vertex(var16, (float)var0, (float)var6, 0.0f).color(var12, var13, var14, var11).endVertex();
        var15.vertex(var16, (float)var4, (float)var6, 0.0f).color(var12, var13, var14, var11).endVertex();
        var15.vertex(var16, (float)var4, (float)var2, 0.0f).color(var12, var13, var14, var11).endVertex();
        var15.vertex(var16, (float)var0, (float)var2, 0.0f).color(var12, var13, var14, var11).endVertex();
        var15.end();
        WorldVertexBufferUploader.end(var15);
        RenderSystem.enableTexture();
        RenderSystem.disableBlend();
    }
    
    public static void WPN(final double var0, final double var2, final double var4, final double var6, final int var8) {
        RenderHelper.MCB = var0;
        RenderHelper.hHR = var2;
        RenderHelper.UMu = var4;
        RenderHelper.HdB = var6;
        RenderHelper.Sdk = var8;
    }
    
    public static void Rii(int var0, int var1, int var2, int var3, final int var4) {
        if (var0 < var2) {
            final int var5 = var0;
            var0 = var2;
            var2 = var5;
        }
        if (var1 < var3) {
            final int var5 = var1;
            var1 = var3;
            var3 = var5;
        }
        final Matrix4f var6 = new MatrixStack().last().pose();
        final float var7 = (var4 >> 24 & 0xFF) / 255.0f;
        final float var8 = (var4 >> 16 & 0xFF) / 255.0f;
        final float var9 = (var4 >> 8 & 0xFF) / 255.0f;
        final float var10 = (var4 & 0xFF) / 255.0f;
        final BufferBuilder var11 = Tessellator.getInstance().getBuilder();
        RenderSystem.enableBlend();
        RenderSystem.disableTexture();
        RenderSystem.defaultBlendFunc();
        var11.begin(7, DefaultVertexFormats.POSITION_COLOR);
        var11.vertex(var6, (float)var0, (float)var3, 0.0f).color(var8, var9, var10, var7).endVertex();
        var11.vertex(var6, (float)var2, (float)var3, 0.0f).color(var8, var9, var10, var7).endVertex();
        var11.vertex(var6, (float)var2, (float)var1, 0.0f).color(var8, var9, var10, var7).endVertex();
        var11.vertex(var6, (float)var0, (float)var1, 0.0f).color(var8, var9, var10, var7).endVertex();
        var11.end();
        WorldVertexBufferUploader.end(var11);
        RenderSystem.enableTexture();
        RenderSystem.disableBlend();
    }
    
    public static void NQP(final double var0, final double var2, final double var4, final double var6, final int var8) {
        WPN(var0, var2, var4, var6, var8);
        jwL();
    }
    
    private static void jwL() {
        if (RenderHelper.MCB < RenderHelper.UMu) {
            final double var0 = RenderHelper.MCB;
            RenderHelper.MCB = RenderHelper.UMu;
            RenderHelper.UMu = var0;
        }
        if (RenderHelper.hHR < RenderHelper.HdB) {
            final double var0 = RenderHelper.hHR;
            RenderHelper.hHR = RenderHelper.HdB;
            RenderHelper.HdB = var0;
        }
        final float var2 = (RenderHelper.Sdk >> 24 & 0xFF) / 255.0f;
        final float var3 = (RenderHelper.Sdk >> 16 & 0xFF) / 255.0f;
        final float var4 = (RenderHelper.Sdk >> 8 & 0xFF) / 255.0f;
        final float var5 = (RenderHelper.Sdk & 0xFF) / 255.0f;
        final BufferBuilder var6 = Tessellator.getInstance().getBuilder();
        RenderSystem.enableBlend();
        RenderSystem.disableTexture();
        RenderSystem.defaultBlendFunc();
        var6.begin(7, DefaultVertexFormats.POSITION_COLOR);
        var6.vertex(RenderHelper.MCB, RenderHelper.HdB, 0.0).color(var3, var4, var5, var2).endVertex();
        var6.vertex(RenderHelper.UMu, RenderHelper.HdB, 0.0).color(var3, var4, var5, var2).endVertex();
        var6.vertex(RenderHelper.UMu, RenderHelper.hHR, 0.0).color(var3, var4, var5, var2).endVertex();
        var6.vertex(RenderHelper.MCB, RenderHelper.hHR, 0.0).color(var3, var4, var5, var2).endVertex();
        var6.end();
        WorldVertexBufferUploader.end(var6);
        RenderSystem.enableTexture();
        RenderSystem.disableBlend();
    }
    
    public static void zvR(double var0, double var2, double var4, double var6, final int var8) {
        if (var0 < var4) {
            final double var9 = var0;
            var0 = var4;
            var4 = var9;
        }
        if (var2 < var6) {
            final double var9 = var2;
            var2 = var6;
            var6 = var9;
        }
        final float var10 = (var8 >> 24 & 0xFF) / 255.0f;
        final float var11 = (var8 >> 16 & 0xFF) / 255.0f;
        final float var12 = (var8 >> 8 & 0xFF) / 255.0f;
        final float var13 = (var8 & 0xFF) / 255.0f;
        final BufferBuilder var14 = Tessellator.getInstance().getBuilder();
        var14.vertex(var0, var6, 0.0).color(var11, var12, var13, var10).endVertex();
        var14.vertex(var4, var6, 0.0).color(var11, var12, var13, var10).endVertex();
        var14.vertex(var4, var2, 0.0).color(var11, var12, var13, var10).endVertex();
        var14.vertex(var0, var2, 0.0).color(var11, var12, var13, var10).endVertex();
    }
    
    public static void FDB(final double var0, final double var2, final double var4, final double var6, final double var8, final int var10) {
        zvR(var0 + var8, var2, var4 - var8, var2 + var8, var10);
        zvR(var0, var2, var0 + var8, var6, var10);
        zvR(var4 - var8, var2, var4, var6, var10);
        zvR(var0 + var8, var6 - var8, var4 - var8, var6, var10);
    }
    
    public static void cCK(final double var0, final double var2, final double var4, final double var6, final int var8, final int var9) {
        final float var10 = (var8 >> 24 & 0xFF) / 255.0f;
        final float var11 = (var8 >> 16 & 0xFF) / 255.0f;
        final float var12 = (var8 >> 8 & 0xFF) / 255.0f;
        final float var13 = (var8 & 0xFF) / 255.0f;
        final float var14 = (var9 >> 24 & 0xFF) / 255.0f;
        final float var15 = (var9 >> 16 & 0xFF) / 255.0f;
        final float var16 = (var9 >> 8 & 0xFF) / 255.0f;
        final float var17 = (var9 & 0xFF) / 255.0f;
        final Tessellator var18 = Tessellator.getInstance();
        final BufferBuilder var19 = var18.getBuilder();
        var19.vertex(var0, var6, 0.0).color(var11, var12, var13, var10).endVertex();
        var19.vertex(var4, var6, 0.0).color(var15, var16, var17, var14).endVertex();
        var19.vertex(var4, var2, 0.0).color(var15, var16, var17, var14).endVertex();
        var19.vertex(var0, var2, 0.0).color(var11, var12, var13, var10).endVertex();
    }
    
    public static void IBU(final double var0, final double var2, final double var4, final double var6, final int var8, final int var9) {
        final float var10 = (var8 >> 24 & 0xFF) / 255.0f;
        final float var11 = (var8 >> 16 & 0xFF) / 255.0f;
        final float var12 = (var8 >> 8 & 0xFF) / 255.0f;
        final float var13 = (var8 & 0xFF) / 255.0f;
        final float var14 = (var9 >> 24 & 0xFF) / 255.0f;
        final float var15 = (var9 >> 16 & 0xFF) / 255.0f;
        final float var16 = (var9 >> 8 & 0xFF) / 255.0f;
        final float var17 = (var9 & 0xFF) / 255.0f;
        final Tessellator var18 = Tessellator.getInstance();
        final BufferBuilder var19 = var18.getBuilder();
        var19.vertex(var0, var6, 0.0).color(var11, var12, var13, var10).endVertex();
        var19.vertex(var4, var6, 0.0).color(var11, var12, var13, var10).endVertex();
        var19.vertex(var4, var2, 0.0).color(var15, var16, var17, var14).endVertex();
        var19.vertex(var0, var2, 0.0).color(var15, var16, var17, var14).endVertex();
    }
    
    public static void KvX(final double var0, final double var2, final double var4, final double var6, final double var8, final int var10) {
        cCK(var0 + var8, var2, var4 - var8, var2 + var8, var10, var10);
        IBU(var0, var2, var0 + var8, var6, var10, var10);
        IBU(var4 - var8, var2, var4, var6, var10, var10);
        cCK(var0 + var8, var6 - var8, var4 - var8, var6, var10, var10);
    }
    
    static {
        RenderHelper.aXV = Minecraft.getInstance();
        Uoj = new HashMap();
    }
}
