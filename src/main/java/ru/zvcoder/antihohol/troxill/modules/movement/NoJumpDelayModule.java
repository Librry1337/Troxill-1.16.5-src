// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules.movement;

import java.lang.reflect.Field;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import ru.zvcoder.antihohol.troxill.Initializer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.Minecraft;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;

public class NoJumpDelayModule extends AbstractModule
{
    public NoJumpDelayModule(final int var1, final String[] var2, final int var3, final int var4) {
        super(var1, var2, var3, var4);
    }
    
    private int Lcp(final int var1) {
        if (var1 == 1) {
            return 68;
        }
        if (var1 == 2) {
            return 70;
        }
        if (var1 == 3) {
            return 68;
        }
        if (var1 == 4) {
            return 68;
        }
        return (var1 == 5) ? 68 : 0;
    }
    
    @Override
    public void onEnable() {
        final ClientPlayerEntity var1 = Minecraft.getInstance().player;
        if (var1 != null) {
            final Field[] var2 = LivingEntity.class.getDeclaredFields();
            final Field var3 = var2[this.Lcp(Initializer.PQg)];
            var3.setAccessible(true);
            try {
                var3.set(var1, 0);
            }
            catch (final Exception var4) {
                var4.printStackTrace();
            }
        }
        super.onEnable();
    }
}
