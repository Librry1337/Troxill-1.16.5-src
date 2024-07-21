// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.hooks;

import ru.zvcoder.antihohol.troxill.modules.ModuleManager;
import net.minecraft.client.Minecraft;
import com.mojang.blaze3d.matrix.MatrixStack;

public class Render3DHook
{
    public static MatrixStack blR;
    private boolean btf;
    
    public Render3DHook(final boolean var1) {
        this.btf = var1;
        if (var1 && Minecraft.getInstance().level != null && Minecraft.getInstance().player != null) {
            ModuleManager.Zav(this);
        }
        else if (!var1) {
            ModuleManager.Zav(this);
        }
    }
    
    public boolean LeN() {
        return this.btf;
    }
}
