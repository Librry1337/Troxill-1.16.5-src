// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules.render;

import net.minecraft.entity.Entity;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;

public class GlowESPModule extends AbstractModule
{
    Minecraft FJo;
    private final List KGA;
    
    public GlowESPModule(final int var1, final String[] var2, final int var3, final int var4) {
        super(var1, var2, var3, var4);
        this.FJo = Minecraft.getInstance();
        this.KGA = new ArrayList();
    }
    
    @Override
    public void onEnable() {
        for (final Entity var2 : this.FJo.level.players()) {
            var2.setGlowing(true);
            this.KGA.add(var2);
        }
    }
    
    @Override
    public void HDK() {
        for (final Entity var2 : this.FJo.level.players()) {
            if (this.KGA.contains(var2)) {
                var2.setGlowing(false);
            }
        }
        this.KGA.clear();
    }
}
