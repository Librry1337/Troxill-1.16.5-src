// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules.ghost;

import net.minecraft.client.multiplayer.PlayerController;
import ru.zvcoder.antihohol.troxill.utils.reflection.ReflectionUtil;
import net.minecraft.world.GameType;
import ru.zvcoder.antihohol.troxill.clickgui.components.CategoryComponent;
import ru.zvcoder.antihohol.troxill.clickgui.ClickGui;
import ru.zvcoder.antihohol.troxill.Initializer;
import java.util.ArrayList;
import net.minecraft.client.gui.screen.Screen;
import ru.zvcoder.antihohol.troxill.hooks.HookUTIL;
import net.minecraft.client.Minecraft;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;
import ru.zvcoder.antihohol.troxill.modules.ModuleManager;

public class SelfDestructModule extends AbstractModule
{
    public static SelfDestructModule BNw;
    public boolean JNU;
    
    public SelfDestructModule(final int var1, final String[] var2, final int var3, final int var4) {
        super(var1, var2, var3, var4);
        this.JNU = false;
        SelfDestructModule.BNw = this;
    }
    
    @Override
    public void Kxp() {
        final Minecraft var1 = Minecraft.getInstance();
        final PlayerController var2 = var1.gameMode;
        this.JNU = true;
        HookUTIL.KIq(var1);
        var1.setScreen((Screen)null);
        for (final AbstractModule var4 : ModuleManager.modules) {
            var4.Hyh(false);
        }
        ModuleManager.modules = new ArrayList<AbstractModule>();
        Initializer.moduleManager = null;
        for (final CategoryComponent var5 : ClickGui.BxZ) {
            var5.sFt = new ArrayList();
        }
        ClickGui.BxZ = new ArrayList<CategoryComponent>();
        new Thread(() -> {
            try {
                Thread.sleep(1000L);
            }
            catch (final InterruptedException var6) {
                throw new RuntimeException(var6);
            }
            return;
        }).start();
        ReflectionUtil.TkS(GameType.class, var1.player.connection.getPlayerInfo(var1.player.getUUID()), (var2 != null) ? var2.getPlayerMode() : GameType.SURVIVAL);
    }
}
