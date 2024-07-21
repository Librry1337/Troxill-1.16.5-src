// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.hooks;

import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import ru.zvcoder.antihohol.troxill.utils.render.PlayerLayer;

@OnlyIn(Dist.CLIENT)
public class LayerRendererHOOK extends LayerRenderer
{
    public LayerRendererHOOK(final IEntityRenderer var1) {
        super(var1);
    }
    
    public void render(final MatrixStack var1, final IRenderTypeBuffer var2, final int var3, final Entity var4, final float var5, final float var6, final float var7, final float var8, final float var9, final float var10) {
        new PlayerLayer(var1, (AbstractClientPlayerEntity)var4, var7);
    }
}
