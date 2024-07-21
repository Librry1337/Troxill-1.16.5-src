// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.hooks;

import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.PlayerRenderer;

public class PlayerRendererHOOK extends PlayerRenderer
{
    public PlayerRendererHOOK(final EntityRendererManager var1) {
        super(var1);
        super.addLayer((LayerRenderer)new LayerRendererHOOK((IEntityRenderer)this));
    }
    
    public PlayerRendererHOOK(final EntityRendererManager var1, final boolean var2) {
        super(var1, var2);
        super.addLayer((LayerRenderer)new LayerRendererHOOK((IEntityRenderer)this));
    }
}
