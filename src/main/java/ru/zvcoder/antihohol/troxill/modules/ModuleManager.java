// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules;

import java.util.ArrayList;
import ru.zvcoder.antihohol.troxill.events.PlayerRotationEvent;
import net.minecraft.util.MovementInput;
import ru.zvcoder.antihohol.troxill.modules.combat.AimAssistModule;
import ru.zvcoder.antihohol.troxill.modules.combat.AutoClickerModule;
import ru.zvcoder.antihohol.troxill.modules.combat.HitboxModule;
import ru.zvcoder.antihohol.troxill.modules.combat.TapeMouseModule;
import ru.zvcoder.antihohol.troxill.modules.ghost.AutoShiftTapModule;
import ru.zvcoder.antihohol.troxill.modules.ghost.MiddlePearlModule;
import ru.zvcoder.antihohol.troxill.modules.ghost.SelfDestructModule;

import ru.zvcoder.antihohol.troxill.utils.render.PlayerLayer;
import ru.zvcoder.antihohol.troxill.hooks.Render3DHook;
import ru.zvcoder.antihohol.troxill.hooks.RenderHOOK;
import ru.zvcoder.antihohol.troxill.events.AttackEvent;
import net.minecraft.client.Minecraft;
import ru.zvcoder.antihohol.troxill.events.MouseEvent;

import java.util.LinkedList;
import java.util.Set;
import ru.zvcoder.antihohol.troxill.clickgui.settings.Setting;
import ru.zvcoder.antihohol.troxill.modules.movement.*;
import ru.zvcoder.antihohol.troxill.modules.player.*;
import ru.zvcoder.antihohol.troxill.modules.render.*;

import java.util.LinkedHashSet;
import java.util.List;

public class ModuleManager
{
    public static List<AbstractModule> modules;
    private static LinkedHashSet<Setting> iwp;
    private static int lastModuleId;
    
    public ModuleManager() {
        ModuleManager.modules.add(new SprintModule(1, new String[] { "Sp", "ri", "nt" }, getNewModuleId(), 0));
        ModuleManager.modules.add(new HitboxModule(0, new String[] { "Hi", "tB", "ox" }, getNewModuleId(), 90));
        ModuleManager.modules.add(new SelfDestructModule(2, new String[] { "Se", "lf", "De", "st", "ru", "ct" }, getNewModuleId(), 261));
        ModuleManager.modules.add(new ElytraSwapModule(1, new String[] { "El", "yt", "ra", "Sw", "ap" }, getNewModuleId(), 71));
        ModuleManager.modules.add(new ESPModule(3, new String[] { "ES", "P" }, getNewModuleId(), 0));
        ModuleManager.modules.add(new TracersModule(3, new String[] { "Tr", "ac", "er", "s" }, getNewModuleId(), 0));
        ModuleManager.modules.add(new NoJumpDelayModule(1, new String[] { "No", "Ju", "mp", "De", "la", "y" }, getNewModuleId(), 0));
        ModuleManager.modules.add(new ItemScrollerModule(4, new String[] { "It", "em", "Sc", "ro", "ll", "er" }, getNewModuleId(), 0));
        ModuleManager.modules.add(new TargetsEspModule(3, new String[] { "Ta", "rg", "et", "Es", "p" }, getNewModuleId(), 0));
        ModuleManager.modules.add(new NoHurtCamModule(3, new String[] { "No", "Hu", "rt", "Ca", "m" }, getNewModuleId(), 0));
        ModuleManager.modules.add(new StreamBypassModule(3, new String[] { "St", "re", "am", "By", "pa", "ss" }, getNewModuleId(), 0));
        ModuleManager.modules.add(new HUDModule(3, new String[] { "HU", "D" }, getNewModuleId(), 0));
        ModuleManager.modules.add(new CustomCapeModule(3, new String[] { "Cu", "st", "om", "Ca", "pe" }, getNewModuleId(), 0));
        ModuleManager.modules.add(new TapeMouseModule(0, new String[] { "Ta", "pe", "Mo", "us", "e" }, getNewModuleId(), 0));
        ModuleManager.modules.add(new GammaModule(3, new String[] { "Ga", "mm", "a" }, getNewModuleId(), 0));
        ModuleManager.modules.add(new AutoShiftTapModule(2, new String[] { "Au", "to", "Sh", "if", "tT", "ap" }, getNewModuleId(), 0));
        ModuleManager.modules.add(new AuthoFireWorkModule(1, new String[] { "Au", "to", "Fi", "re", "Wo", "rk" }, getNewModuleId(), 0));
        ModuleManager.modules.add(new ChinaHatModule(3, new String[] { "Ch", "in", "aH", "at" }, getNewModuleId(), 0));
        ModuleManager.modules.add(new MiddlePearlModule(2, new String[] { "Mi", "dd", "le", "Pe", "ar", "l" }, getNewModuleId(), 0));
        ModuleManager.modules.add(new PlayerLeaveModule(4, new String[] { "Pl", "ay", "er", "Le", "av", "e" }, getNewModuleId(), 0));
        ModuleManager.modules.add(new AimAssistModule(0, new String[] { "Ai", "mA", "ss", "is", "t" }, getNewModuleId(), 0));
        ModuleManager.modules.add(new ItemESPModule(3, new String[] { "Item", "ES", "P" }, getNewModuleId(), 0));
        ModuleManager.modules.add(new InvWalkModule(1, new String[] { "Inv", "Walk" }, getNewModuleId(), 0));
        ModuleManager.modules.add(new NoRainModule(4, new String[] { "No", "Rain" }, getNewModuleId(), 0));
        ModuleManager.modules.add(new NoPushModule(4, new String[] { "No", "Push" }, getNewModuleId(), 0));
        ModuleManager.modules.add(new NoFireModule(3, new String[] { "No", "Fire" }, getNewModuleId(), 0));
        ModuleManager.modules.add(new ChestStealerModule(4, new String[] { "Chest", "Ste", "aler" }, getNewModuleId(), 0));
        ModuleManager.modules.add(new NoHitBoxesModule(4, new String[] { "No", "Hit", "Box", "es" }, getNewModuleId(), 0));
        ModuleManager.modules.add(new FreeCamModule(1, new String[] { "Free", "Cam" }, getNewModuleId(), 0));
        ModuleManager.modules.add(new AutoClickerModule(0, new String[] { "Auto", "Click", "er" }, getNewModuleId(), 0));
        ModuleManager.modules.add(new MCFModule(4, new String[] { "MCF" }, getNewModuleId(), 0));
        ModuleManager.modules.add(new NoFriendDamageModule(4, new String[] { "NoFr", "iend", "Damage" }, getNewModuleId(), 0));
        ModuleManager.modules.add(new GlowESPModule(3, new String[] { "Glow", "ES", "P" }, getNewModuleId(), 0));
    }
    
    public static Setting zWY(Setting var0) {
        ModuleManager.iwp.add(var0);
        return var0;
    }
    
    public static Set<Setting> TCd() {
        return ModuleManager.iwp;
    }
    
    public static LinkedHashSet<Setting> osP(AbstractModule var0) {
        LinkedHashSet var = new LinkedHashSet();
        for (Setting var3 : TCd()) {
            if (var3.ZsE().CPH() == var0.CPH()) {
                var.add(var3);
            }
        }
        return var;
    }
    
    public static Setting SBG(AbstractModule var0, int var1) {
        for (Setting var3 : TCd()) {
            if (var3.ZsE().CPH() == var0.CPH() && var3.cgx == var1) {
                return var3;
            }
        }
        return new Setting(HitboxModule.IVI, 0, 0);
    }
    
    public static AbstractModule dvJ(int var0) {
        for (AbstractModule var2 : ModuleManager.modules) {
            if (var2.CPH() == var0) {
                return var2;
            }
        }
        return null;
    }
    
    public static List<AbstractModule> TYZ() {
        LinkedList<AbstractModule> var0 = new LinkedList<AbstractModule>(ModuleManager.modules);
        var0.sort((var0x, var1) -> Float.compare(var1.eRz(), var0x.eRz()));
        return var0;
    }
    
    public static void MSA(MouseEvent var0) {
        for (AbstractModule var2 : ModuleManager.modules) {
            if (var2.inu()) {
                var2.onMouse(var0);
            }
        }
    }
    
    public static void Qep(ClickGuiModule var0) {
        for (AbstractModule var2 : ModuleManager.modules) {
            if (var2.inu()) {
                var2.izK(var0);
            }
            if (Minecraft.getInstance().screen == null || Minecraft.getInstance().screen == ClickGuiModule.OGj) {
                int var3 = var0.Zgf();
                if (var3 == 0 || var3 != var2.Osr() || var0.Xht() != 1) {
                    continue;
                }
                var2.geu();
            }
        }
    }
    
    public static void VCU() {
        for (AbstractModule var2 : ModuleManager.modules) {
            if (var2.inu()) {
                var2.onEnable();
            }
            else {
                var2.evV();
            }
        }
    }
    
    public static void Ted(AttackEvent var0) {
        for (AbstractModule var2 : ModuleManager.modules) {
            if (var2.inu()) {
                var2.onAttack(var0);
            }
        }
    }
    
    public static void Ljg(RenderHOOK var0) {
        for (AbstractModule var2 : ModuleManager.modules) {
            if (var2.inu()) {
                var2.onRender(var0);
            }
        }
    }
    
    public static void Zav(Render3DHook var0) {
        for (AbstractModule var2 : ModuleManager.modules) {
            if (var2.inu()) {
                var2.onRender3D(var0);
            }
        }
    }
    

    
    public static void mmH(Setting var0) {
        for (AbstractModule var2 : ModuleManager.modules) {
            if (var2.inu()) {
                var2.onSetting(var0);
            }
        }
    }
    
    public static void onMove(MovementInput var0) {
        for (AbstractModule var2 : ModuleManager.modules) {
            if (var2.inu()) {
                var2.onMovement(var0);
            }
        }
    }
    
    public static void rFC(PlayerRotationEvent var0) {
        for (AbstractModule var2 : ModuleManager.modules) {
            if (var2.inu()) {
                var2.onRotations(var0);
            }
        }
    }
    
    public boolean slG(Object var1, int var2) {
        boolean var3 = true;
        for (AbstractModule var5 : ModuleManager.modules) {
            if (var5.inu() && Minecraft.getInstance().level != null) {
                var3 &= var5.HOx(var1, var2);
            }
        }
        return !var3;
    }
    
    public static int getNewModuleId() {
        return ModuleManager.lastModuleId++;
    }
    
    static {
        ModuleManager.modules = new ArrayList<AbstractModule>();
        iwp = new LinkedHashSet();
        ModuleManager.lastModuleId = 1;
    }
}
