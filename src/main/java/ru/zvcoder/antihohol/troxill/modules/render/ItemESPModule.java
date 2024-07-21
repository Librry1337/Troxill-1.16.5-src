/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.vector.Vector2f
 *  net.minecraft.util.math.vector.Vector3d
 *  net.minecraft.util.registry.Registry
 */
package ru.zvcoder.antihohol.troxill.modules.render;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.registry.Registry;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;
import ru.zvcoder.antihohol.troxill.modules.ModuleManager;
import ru.zvcoder.antihohol.troxill.utils.fonts.FontManager;
import ru.zvcoder.antihohol.troxill.hooks.RenderHOOK;
import ru.zvcoder.antihohol.troxill.clickgui.settings.Setting;
import ru.zvcoder.antihohol.troxill.utils.render.ColorUtil2;
import ru.zvcoder.antihohol.troxill.utils.calc.RotationUtils;

public class ItemESPModule
        extends AbstractModule {
    Minecraft yEs = Minecraft.getInstance();

    public ItemESPModule(int var1, String[] var2, int var3, int var4) {
        super(var1, var2, var3, var4);
        Setting var10000 = ModuleManager.zWY(new Setting(this, true, new String[]{"Gl", "ow"}, 1, 1));
        var10000 = ModuleManager.zWY(new Setting(this, true, new String[]{"Te", "xt"}, 1, 2));
    }

    private void TQe() {
        boolean var1 = ModuleManager.SBG((AbstractModule)this, (int)1).Xbo;
        boolean var2 = ModuleManager.SBG((AbstractModule)this, (int)2).Xbo;
        for (Entity var4 : this.yEs.level.entitiesForRendering()) {
            if (!ItemEntity.class.isInstance(var4)) continue;
            if (var1) {
                var4.setGlowing(true);
            }
            if (!var2) continue;
            double var5 = ColorUtil2.UAv(var4.getX(), var4.xOld, this.yEs.getFrameTime());
            double var7 = ColorUtil2.UAv(var4.getY(), var4.yOld, this.yEs.getFrameTime());
            double var9 = ColorUtil2.UAv(var4.getZ(), var4.zOld, this.yEs.getFrameTime());
            Vector3d var11 = new Vector3d(var4.getBoundingBox().maxX - var4.getBoundingBox().minX, var4.getBoundingBox().maxY - var4.getBoundingBox().minY, var4.getBoundingBox().maxZ - var4.getBoundingBox().minZ);
            AxisAlignedBB var12 = new AxisAlignedBB(var5 - var11.x / 2.0, var7, var9 - var11.z / 2.0, var5 + var11.x / 2.0, var7 + var11.y, var9 + var11.z / 2.0);
            Vector2f var13 = RotationUtils.Nxy(var12.maxX, var12.maxY, var12.maxZ);
            String var14 = Registry.ITEM.getKey(((ItemEntity)var4).getItem().getItem()).toString().substring(10);
            FontManager.uAe().tjC(var14, var13.x - (float) FontManager.uAe().gVe(var14) / 2.0f, var13.y - (float)(FontManager.uAe().XtF() * 2), new Color(0xFFFFFF).getRGB());
        }
    }

    @Override
    public void onRender(RenderHOOK var1) {
        if (!StreamBypassModule.ufx.inu()) {
            if (!var1.jFA()) {
                this.TQe();
            }
        } else if (var1.jFA()) {
            this.TQe();
        }
    }

    @Override
    public void HDK() {
        boolean var1 = ModuleManager.SBG((AbstractModule)this, (int)1).Xbo;
        if (var1) {
            for (Entity var3 : this.yEs.level.entitiesForRendering()) {
                if (!ItemEntity.class.isInstance(var3)) continue;
                var3.setGlowing(false);
            }
        }
    }
}

