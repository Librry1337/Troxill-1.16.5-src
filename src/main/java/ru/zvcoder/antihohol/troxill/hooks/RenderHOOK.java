// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.hooks;

import com.mojang.blaze3d.systems.RenderSystem;
import ru.zvcoder.antihohol.troxill.clickgui.components.CategoryComponent;
import ru.zvcoder.antihohol.troxill.clickgui.ClickGui;
import ru.zvcoder.antihohol.troxill.modules.ModuleManager;
import ru.zvcoder.antihohol.troxill.modules.render.StreamBypassModule;
import net.minecraft.client.Minecraft;
import ru.zvcoder.antihohol.troxill.utils.fonts.FontManager;

public class RenderHOOK
{
    private boolean lfQ;
    
    public RenderHOOK(final boolean var1) {
        this.lfQ = var1;
        if (var1 && FontManager.IOb == null) {
            FontManager.PjI();
        }
        if (var1 && Minecraft.getInstance().level != null && Minecraft.getInstance().player != null) {
            if (StreamBypassModule.ufx != null && StreamBypassModule.ufx.inu()) {
                ModuleManager.Ljg(this);
                if (ClickGui.Vzv != -1000) {
                    RenderSystem.pushMatrix();
                    for (final CategoryComponent var3 : ClickGui.BxZ) {
                        var3.mOk(null, ClickGui.Vzv, ClickGui.JPK, 0.0f);
                    }
                    RenderSystem.popMatrix();
                    ClickGui.Vzv = -1000;
                }
            }
        }
        else if (!var1) {
            ModuleManager.Ljg(this);
        }
    }
    
    public boolean jFA() {
        return this.lfQ;
    }
}
