// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules.movement;

import net.minecraft.client.GameSettings;
import ru.zvcoder.antihohol.troxill.clickgui.settings.KeyBindManager;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.util.MovementInput;
import net.minecraft.client.settings.KeyBinding;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;

public class InvWalkModule extends AbstractModule
{
    public InvWalkModule(final int var1, final String[] var2, final int var3, final int var4) {
        super(var1, var2, var3, var4);
    }
    
    private int EoE(final KeyBinding var1) {
        return var1.getDefaultKey().getValue();
    }
    
    @Override
    public void onMovement(final MovementInput var1) {
        final Minecraft var2 = Minecraft.getInstance();
        final GameSettings var3 = var2.options;
        if (var2.screen != null && !ChatScreen.class.isInstance(var2.screen)) {
            if (SprintModule.wsR.inu()) {
                var2.player.setSprinting(true);
            }
            if (KeyBindManager.kUZ(this.EoE(var3.keyUp))) {
                ++var1.forwardImpulse;
            }
            if (KeyBindManager.kUZ(this.EoE(var3.keyDown))) {
                --var1.forwardImpulse;
            }
            if (KeyBindManager.kUZ(this.EoE(var3.keyLeft))) {
                ++var1.leftImpulse;
            }
            if (KeyBindManager.kUZ(this.EoE(var3.keyRight))) {
                --var1.leftImpulse;
            }
            var1.jumping = KeyBindManager.kUZ(this.EoE(var3.keyJump));
        }
    }
}
