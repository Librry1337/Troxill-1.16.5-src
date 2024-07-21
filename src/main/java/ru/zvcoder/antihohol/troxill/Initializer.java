// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill;

import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.SimpleSound;
import net.minecraft.util.SoundEvents;
import java.lang.reflect.Field;
import net.minecraft.client.Minecraft;
import ru.zvcoder.antihohol.troxill.hooks.HookUTIL;
import ru.zvcoder.antihohol.troxill.modules.ModuleManager;
import ru.zvcoder.antihohol.troxill.utils.fonts.FontManager;

public class Initializer
{
    public static float cCn;
    public static String GDN;
    public static ModuleManager moduleManager;
    private boolean kDh;
    public static int PQg;
    
    private static void mpV() {
        final Field var0 = Minecraft.class.getDeclaredFields()[15];
        if (var0.getType().getName().contains(Minecraft.class.getName())) {
            Initializer.PQg = 5;
        }
    }
    
    public Initializer() {
        mpV();
        new Thread(() -> {
            FontManager.loadResources();
            HookUTIL.zvS();
            Initializer.moduleManager = new ModuleManager();
            Minecraft.getInstance().execute(() -> Minecraft.getInstance().getSoundManager().play((ISound)SimpleSound.forUI(SoundEvents.ENDER_DRAGON_AMBIENT, 1.0f)));
        }).start();
    }
    
    static {
        Initializer.cCn = 2.41f;
        Initializer.PQg = 3;
    }
}
