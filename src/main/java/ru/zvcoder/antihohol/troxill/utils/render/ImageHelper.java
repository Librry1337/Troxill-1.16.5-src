// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.utils.render;

import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.WorldVertexBufferUploader;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.renderer.texture.NativeImage;
import java.nio.ByteBuffer;
import org.lwjgl.BufferUtils;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import net.minecraft.client.renderer.texture.DynamicTexture;
import ru.zvcoder.antihohol.troxill.utils.fonts.Glyph;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.awt.Font;

public class ImageHelper
{
    private int DEj;
    private int Bya;
    private Font ADB;
    private boolean JVX;
    private boolean WjY;
    private HashMap<Character, Glyph> XGB;
    private BufferedImage ppO;
    private DynamicTexture jFF;
    
    public ImageHelper(final Font var1, final boolean var2, final boolean var3) {
        this.Bya = -1;
        this.XGB = new HashMap();
        this.ADB = var1;
        this.JVX = var2;
        this.WjY = var3;
    }
    
    public void VFL(final char[] var1) {
        double var2 = -1.0;
        double var3 = -1.0;
        final AffineTransform var4 = new AffineTransform();
        final FontRenderContext var5 = new FontRenderContext(var4, this.JVX, this.WjY);
        final char[] var6 = var1;
        for (int var7 = var1.length, var8 = 0; var8 < var7; ++var8) {
            final int var9 = var6[var8];
            final Rectangle2D var10 = this.ADB.getStringBounds(Character.toString((char)var9), var5);
            final double var11 = var10.getWidth();
            final double var12 = var10.getHeight();
            if (var2 < var11) {
                var2 = var11;
            }
            if (var3 < var12) {
                var3 = var12;
            }
        }
        var2 += 2.0;
        var3 += 2.0;
        this.DEj = (int)Math.ceil(Math.max(Math.ceil(Math.sqrt(var2 * var2 * var1.length) / var2), Math.ceil(Math.sqrt(var3 * var3 * var1.length) / var3)) * Math.max(var2, var3)) + 1;
        this.ppO = new BufferedImage(this.DEj, this.DEj, 2);
        final Graphics2D var13 = this.ppO.createGraphics();
        var13.setFont(this.ADB);
        var13.setColor(new Color(255, 255, 255, 0));
        var13.fillRect(0, 0, this.DEj, this.DEj);
        var13.setColor(Color.white);
        var13.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, this.WjY ? RenderingHints.VALUE_FRACTIONALMETRICS_ON : RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
        var13.setRenderingHint(RenderingHints.KEY_ANTIALIASING, this.JVX ? RenderingHints.VALUE_ANTIALIAS_OFF : RenderingHints.VALUE_ANTIALIAS_ON);
        var13.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, this.JVX ? RenderingHints.VALUE_TEXT_ANTIALIAS_ON : RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        final FontMetrics var14 = var13.getFontMetrics();
        int var8 = 0;
        int var9 = 0;
        int var15 = 1;
        final char[] var16 = var1;
        for (int var17 = var1.length, var18 = 0; var18 < var17; ++var18) {
            final char var19 = var16[var18];
            final Glyph var20 = new Glyph();
            final Rectangle2D var21 = var14.getStringBounds(Character.toString(var19), var13);
            var20.hVz = var21.getBounds().width + 8;
            var20.KkH = var21.getBounds().height;
            if (var9 + var20.hVz >= this.DEj) {
                var9 = 0;
                var15 += var8;
                var8 = 0;
            }
            var20.pgC = var9;
            var20.swc = var15;
            if (var20.KkH > this.Bya) {
                this.Bya = var20.KkH;
            }
            if (var20.KkH > var8) {
                var8 = var20.KkH;
            }
            var13.drawString(Character.toString(var19), var9 + 2, var15 + var14.getAscent());
            var9 += var20.hVz;
            this.XGB.put(var19, var20);
        }
    }
    
    public void yao() {
        try {
            final ByteArrayOutputStream var1 = new ByteArrayOutputStream();
            ImageIO.write(this.ppO, "png", var1);
            final byte[] var2 = var1.toByteArray();
            final ByteBuffer var3 = BufferUtils.createByteBuffer(var2.length).put(var2);
            final ByteBuffer var4 = (ByteBuffer)var3.flip();
            this.jFF = new DynamicTexture(NativeImage.read(var3));
        }
        catch (final Exception var5) {
            var5.printStackTrace();
        }
    }
    
    public void Wqy() {
        RenderSystem.bindTexture(this.jFF.getId());
    }
    
    public void pek() {
        RenderSystem.bindTexture(0);
    }
    
    public float NfG(final MatrixStack var1, final char var2, final float var3, final float var4, final float var5, final float var6, final float var7, final float var8) {
        final Glyph var9 = this.XGB.get(var2);
        if (var9 == null) {
            return 0.0f;
        }
        final float var10 = var9.pgC / (float)this.DEj;
        final float var11 = var9.swc / (float)this.DEj;
        final float var12 = var9.hVz / (float)this.DEj;
        final float var13 = var9.KkH / (float)this.DEj;
        final float var14 = (float)var9.hVz;
        final float var15 = (float)var9.KkH;
        final BufferBuilder var16 = Tessellator.getInstance().getBuilder();
        var16.begin(7, DefaultVertexFormats.POSITION_COLOR_TEX);
        final Matrix4f var17 = var1.last().pose();
        var16.vertex(var17, var3, var4 + var15, 0.0f).color(var5, var7, var6, var8).uv(var10, var11 + var13).endVertex();
        var16.vertex(var17, var3 + var14, var4 + var15, 0.0f).color(var5, var7, var6, var8).uv(var10 + var12, var11 + var13).endVertex();
        var16.vertex(var17, var3 + var14, var4, 0.0f).color(var5, var7, var6, var8).uv(var10 + var12, var11).endVertex();
        var16.vertex(var17, var3, var4, 0.0f).color(var5, var7, var6, var8).uv(var10, var11).endVertex();
        var16.end();
        WorldVertexBufferUploader.end(var16);
        return var14 - 8.0f;
    }
    
    public float iAS(final char var1) {
        final Glyph var2 = this.XGB.get(var1);
        return (var2 == null) ? 0.0f : ((float)var2.hVz);
    }
    
    public int nEo() {
        return this.Bya;
    }
    
    public boolean RAz() {
        return this.JVX;
    }
    
    public boolean SQb() {
        return this.WjY;
    }
}
