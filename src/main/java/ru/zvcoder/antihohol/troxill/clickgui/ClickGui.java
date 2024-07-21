// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.clickgui;

import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import ru.zvcoder.antihohol.troxill.clickgui.components.CategoryComponent;
import ru.zvcoder.antihohol.troxill.modules.Category;
import ru.zvcoder.antihohol.troxill.modules.render.StreamBypassModule;
import org.lwjgl.opengl.GL11;
import java.lang.reflect.Field;
import net.minecraft.util.text.StringTextComponent;
import java.util.List;
import net.minecraft.client.gui.screen.Screen;
import ru.zvcoder.antihohol.troxill.utils.render.ColorUtil2;

public class ClickGui extends Screen
{
    public static List<CategoryComponent> BxZ;
    public static boolean KKX;
    private float IMP;
    private float EIY;
    public static float Evk;
    public static int Vzv;
    public static int JPK;
    
    public ClickGui() {
        super(StringTextComponent.EMPTY);
        this.IMP = 0.0f;
        this.EIY = 0.25f;
        int var1 = 0;
        for (final Field var5 : Category.class.getDeclaredFields()) {
            var5.setAccessible(true);
            try {
                ClickGui.BxZ.add(new CategoryComponent(30 + var1, 100, 85, 17, (int)var5.get(Category.class)));
                var1 += 110;
            }
            catch (final IllegalAccessException var6) {
                throw new RuntimeException(var6);
            }
        }
    }
    
    public void glCenteredScale(final float var1, final float var2, final float var3, final float var4, final float var5) {
        GL11.glTranslatef(var1 + var3 / 2.0f, var2 + var4 / 2.0f, 0.0f);
        GL11.glScalef(var5, var5, 1.0f);
        GL11.glTranslatef(-var1 - var3 / 2.0f, -var2 - var4 / 2.0f, 0.0f);
    }
    
    public static void r() {
        if (ClickGui.Vzv != -1000 && StreamBypassModule.ufx.inu()) {
            RenderSystem.pushMatrix();
            for (final CategoryComponent var2 : ClickGui.BxZ) {
                var2.mOk(null, ClickGui.Vzv, ClickGui.JPK, 0.0f);
            }
            RenderSystem.popMatrix();
            ClickGui.Vzv = -1000;
        }
    }
    
    public void render(final MatrixStack var1, final int var2, final int var3, final float var4) {
        this.EIY = ColorUtil2.DGl(this.EIY, 1.0f, 10.0f);
        this.glCenteredScale(0.0f, 0.0f, (float)Minecraft.getInstance().getWindow().getGuiScaledWidth(), (float)Minecraft.getInstance().getWindow().getGuiScaledHeight(), this.EIY);
        super.render(var1, var2, var3, var4);
        ClickGui.Vzv = var2;
        ClickGui.JPK = var3;
        ClickGui.Evk = ColorUtil2.DGl(ClickGui.Evk, this.IMP, 10.0f);
        if (!StreamBypassModule.ufx.inu()) {
            RenderSystem.pushMatrix();
            for (final CategoryComponent var6 : ClickGui.BxZ) {
                var6.mOk(null, var2, var3, 0.0f);
            }
            RenderSystem.popMatrix();
        }
    }
    
    public boolean mouseClicked(final double var1, final double var3, final int var5) {
        for (final CategoryComponent var7 : ClickGui.BxZ) {
            var7.DzC(var1, var3, var5);
        }
        return super.mouseClicked(var1, var3, var5);
    }
    
    public boolean mouseReleased(final double var1, final double var3, final int var5) {
        for (final CategoryComponent var7 : ClickGui.BxZ) {
            var7.pHp(var1, var3, var5);
        }
        return super.mouseReleased(var1, var3, var5);
    }
    
    public boolean keyPressed(final int var1, final int var2, final int var3) {
        for (final CategoryComponent var5 : ClickGui.BxZ) {
            var5.bag(var1);
        }
        return super.keyPressed(var1, var2, var3);
    }
    
    public boolean mouseScrolled(final double var1, final double var3, final double var5) {
        this.IMP += (float)(var5 * 4.0);
        return super.mouseScrolled(var1, var3, var5);
    }
    
    public void onClose() {
        Minecraft.getInstance().setScreen((Screen)null);
        ClickGui.KKX = false;
        this.EIY = 0.25f;
    }
    
    public boolean isPauseScreen() {
        return false;
    }
    
    static {
        ClickGui.BxZ = new ArrayList<CategoryComponent>();
        ClickGui.Evk = 0.0f;
        ClickGui.Vzv = 0;
        ClickGui.JPK = 0;
    }
}
