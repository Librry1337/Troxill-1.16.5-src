// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules;

import ru.zvcoder.antihohol.troxill.events.PlayerRotationEvent;
import net.minecraft.util.MovementInput;
import ru.zvcoder.antihohol.troxill.events.AttackEvent;
import ru.zvcoder.antihohol.troxill.utils.render.PlayerLayer;
import ru.zvcoder.antihohol.troxill.events.MouseEvent;
import ru.zvcoder.antihohol.troxill.hooks.RenderHOOK;
import ru.zvcoder.antihohol.troxill.hooks.Render3DHook;
import ru.zvcoder.antihohol.troxill.clickgui.settings.Setting;
import ru.zvcoder.antihohol.troxill.utils.fonts.FontManager;

public class AbstractModule
{
    public float STf;
    private int GfJ;
    private int Fel;
    private int category;
    private boolean Cml;
    private String[] name;
    private float drI;
    private float KaO;
    private float Htr;
    
    public AbstractModule(final int var1, final String[] var2, final int var3, final int var4) {
        final String[] var5 = var2;
        for (int var6 = var2.length, var7 = 0; var7 < var6; ++var7) {
            final String var8 = var5[var7];
            this.drI += FontManager.Bbk().gVe(var8);
            this.KaO += FontManager.awW().gVe(var8);
            this.Htr += FontManager.oci().gVe(var8);
        }
        this.category = var1;
        this.name = var2;
        this.Fel = var3;
        this.GfJ = var4;
        this.Cml = false;
        Setting var9 = ModuleManager.zWY(new Setting(this, var4, 0));
        if (var1 == 3) {
            var9 = ModuleManager.zWY(new Setting(this, false, new String[] { "Vi", "si", "bl", "e" }, 1, -1));
        }
        else {
            var9 = ModuleManager.zWY(new Setting(this, true, new String[] { "Vi", "si", "bl", "e" }, 1, -1));
        }
    }
    
    public float eRz() {
        return this.drI;
    }
    
    public float LZM() {
        return this.KaO;
    }
    
    public float Anx() {
        return this.Htr;
    }
    
    public void Kxp() {
        this.STf = 0.0f;
    }
    
    public void HDK() {
    }
    
    public void geu() {
        this.Cml = !this.Cml;
        if (this.Cml) {
            this.Kxp();
        }
        else {
            this.HDK();
        }
    }
    
    public void Hyh(final boolean var1) {
        this.Cml = var1;
        if (this.Cml) {
            this.Kxp();
        }
        else {
            this.HDK();
        }
    }
    
    public int Osr() {
        return this.GfJ;
    }
    
    public int CPH() {
        return this.Fel;
    }
    
    public int QKr() {
        return this.category;
    }
    
    public boolean inu() {
        return this.Cml;
    }
    
    public String[] HXs() {
        return this.name;
    }
    
    public void Bgy(final int var1) {
        this.GfJ = var1;
    }
    
    public boolean HOx(final Object var1, final int var2) {
        return true;
    }
    
    public void izK(final ClickGuiModule var1) {
    }
    
    public void onEnable() {
    }
    
    public void evV() {
    }
    
    public void onRender3D(final Render3DHook var1) {
    }
    
    public void onRender(final RenderHOOK var1) {
    }
    
    public void onMouse(final MouseEvent var1) {
    }
    
    public void onSetting(final Setting var1) {
    }
    

    public void onAttack(final AttackEvent var1) {
    }
    
    public void onMovement(final MovementInput var1) {
    }
    
    public void onRotations(final PlayerRotationEvent var1) {
    }
}
