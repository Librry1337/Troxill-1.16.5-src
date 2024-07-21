// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules.player;

import net.minecraft.client.Minecraft;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;

public class NoRainModule extends AbstractModule
{
    private float WWk;
    private final Minecraft PcG;
    
    public NoRainModule(final int var1, final String[] var2, final int var3, final int var4) {
        super(var1, var2, var3, var4);
        this.PcG = Minecraft.getInstance();
    }
    
    @Override
    public void onEnable() {
        if (this.PcG.level != null) {
            this.PcG.level.setRainLevel(0.0f);
        }
    }
    
    @Override
    public void Kxp() {
        if (this.PcG.level != null) {
            this.WWk = this.PcG.level.getRainLevel(1.0f);
        }
        super.Kxp();
    }
    
    @Override
    public void HDK() {
        if (this.PcG.level != null) {
            this.PcG.level.setRainLevel(this.WWk);
        }
        super.HDK();
    }
}
