// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules.render;

import ru.zvcoder.antihohol.troxill.hooks.RenderHOOK;
import net.minecraft.util.math.vector.Vector2f;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;
import ru.zvcoder.antihohol.troxill.modules.ModuleManager;
import ru.zvcoder.antihohol.troxill.utils.fonts.FontManager;
import net.minecraft.util.math.MathHelper;
import ru.zvcoder.antihohol.troxill.utils.render.ColorUtils;
import ru.zvcoder.antihohol.troxill.utils.render.RenderHelper;
import ru.zvcoder.antihohol.troxill.utils.render.VectorHelper;
import ru.zvcoder.antihohol.troxill.utils.calc.RotationUtils;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import ru.zvcoder.antihohol.troxill.utils.calc.MathUtils2;
import net.minecraft.entity.player.PlayerEntity;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.Minecraft;
import ru.zvcoder.antihohol.troxill.clickgui.settings.Setting;

import java.awt.Color;

public class ESPModule extends AbstractModule
{
    private final int hbi;
    private final int piH;
    
    public ESPModule(final int var1, final String[] var2, final int var3, final int var4) {
        super(var1, var2, var3, var4);
        this.hbi = new Color(16711931).getRGB();
        this.piH = new Color(16711769).getRGB();
        super.geu();
        final Setting var5 = ModuleManager.zWY(new Setting(this, true, new String[] { "Health" }, 1, 1));
    }
    
    private void ZqW() {
        final Setting var1 = ModuleManager.SBG(this, 1);
        final Minecraft var2 = Minecraft.getInstance();
        GL11.glPushMatrix();
        for (final PlayerEntity var4 : var2.level.players()) {
            if (var4 != var2.player) {
                final double var5 = MathUtils2.diH(var4.getX(), var4.xOld, var2.getFrameTime());
                final double var6 = MathUtils2.diH(var4.getY(), var4.yOld, var2.getFrameTime());
                final double var7 = MathUtils2.diH(var4.getZ(), var4.zOld, var2.getFrameTime());
                final AxisAlignedBB var8 = var4.getBoundingBox();
                final float var9 = 1.0f;
                final Vector3d var10 = new Vector3d((double)var9, var8.maxY - var8.minY, (double)var9);
                final AxisAlignedBB var11 = new AxisAlignedBB(var5 - var10.x / 2.0, var6, var7 - var10.z / 2.0, var5 + var10.x / 2.0, var6 + var10.y, var7 + var10.z / 2.0);
                VectorHelper var12 = null;
                for (int var13 = 0; var13 < 8; ++var13) {
                    final Vector2f var14 = RotationUtils.Nxy((var13 % 2 == 0) ? var11.minX : var11.maxX, (var13 / 2 % 2 == 0) ? var11.minY : var11.maxY, (var13 / 4 % 2 == 0) ? var11.minZ : var11.maxZ);
                    if (var12 == null) {
                        var12 = new VectorHelper(var14.x, var14.y, 1.0, 1.0);
                    }
                    else {
                        var12.UtN = Math.min(var14.x, var12.UtN);
                        var12.hTj = Math.min(var14.y, var12.hTj);
                        var12.Vnx = Math.max(var14.x, var12.Vnx);
                        var12.fTW = Math.max(var14.y, var12.fTW);
                    }
                }
                final float var15 = 0.5f;
                RenderHelper.Bzy(var12.UtN + var15, var12.hTj, var12.Vnx - var15, var12.hTj + var15, this.hbi);
                RenderHelper.Bzy(var12.UtN, var12.hTj, var12.UtN + var15, var12.fTW, this.hbi);
                RenderHelper.Bzy(var12.Vnx - var15, var12.hTj, var12.Vnx, var12.fTW, this.hbi);
                RenderHelper.Bzy(var12.UtN + var15, var12.fTW - var15, var12.Vnx - var15, var12.fTW, this.hbi);
                if (!var1.Xbo) {
                    continue;
                }
                final float var16 = 5.0f;
                final float var17 = 1.0f;
                final float var18 = var4.getHealth();
                final float var19 = var4.getMaxHealth();
                RenderHelper.Bzy(var12.UtN - var16 - var17, var12.hTj - var17, var12.UtN - var16 + 1.0 + var17, var12.fTW + var17, ColorUtils.XnD(0, 0, 0, 128));
                RenderHelper.Bzy(var12.UtN - var16, var12.hTj + (var12.fTW - var12.hTj) * (1.0f - MathHelper.clamp(var18 / var19, 0.0f, 1.0f)), var12.UtN - var16 + 1.0, var12.fTW, this.piH);
                final String var20 = (int)var18 + "HP";
                final float var21 = (float) FontManager.uAe().gVe(var20);
                final float var22 = MathHelper.clamp(var18 / var19, 0.0f, 1.0f);
                final float var23 = (float)(var12.hTj + (var12.fTW - var12.hTj) * (1.0f - var22));
                FontManager.nPm().MzK(var20, var12.UtN - var21 - 3.0, var23, -1);
            }
        }
        GL11.glPopMatrix();
    }
    
    @Override
    public void onRender(final RenderHOOK var1) {
        if (!StreamBypassModule.ufx.inu()) {
            if (!var1.jFA()) {
                this.ZqW();
            }
        }
        else if (var1.jFA()) {
            this.ZqW();
        }
    }
}
