// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules.render;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import ru.zvcoder.antihohol.troxill.utils.reflection.ReflectionUtil;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import ru.zvcoder.antihohol.troxill.Initializer;
import ru.zvcoder.antihohol.troxill.clickgui.settings.Setting;
import java.util.ArrayList;
import ru.zvcoder.antihohol.troxill.hooks.ResoursePack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;
import ru.zvcoder.antihohol.troxill.modules.ModuleManager;

public class CustomCapeModule extends AbstractModule
{
    private Object ULN;
    private final ResourceLocation NPT;
    private final ResourceLocation AAw;
    private final ResourceLocation EoS;
    private final ResourceLocation qie;
    private Map Zyf;
    private NetworkPlayerInfo vUN;
    Minecraft XmR;
    
    public CustomCapeModule(final int var1, final String[] var2, final int var3, final int var4) {
        super(var1, var2, var3, var4);

        this.NPT = ResoursePack.WGP(loadByteArrayFromFile("1.dat"));
        this.AAw = ResoursePack.WGP(loadByteArrayFromFile("2.dat"));
        this.EoS = ResoursePack.WGP(loadByteArrayFromFile("3.dat"));
        this.qie = ResoursePack.WGP(loadByteArrayFromFile("4.dat"));
        this.XmR = Minecraft.getInstance();
        final ArrayList var5 = new ArrayList();
        var5.add(new String[] { "tr", "ox", "il", "l" });
        var5.add(new String[] { "se", "xy" });
        var5.add(new String[] { "an", "im", "e" });
        var5.add(new String[] { "an", "im", "e ", "2" });
        final Setting var6 = ModuleManager.zWY(new Setting(this, new String[] { "Ty", "pe" }, var5, 1));
    }
    
    private void hgB(final ResourceLocation var1) {
        if (this.XmR.getConnection() != null) {
            this.Zyf.put(MinecraftProfileTexture.Type.CAPE, var1);
        }
    }
    
    private void uWv(final int var1) {
        if (var1 == 0) {
            this.hgB(this.NPT);
        }
        if (var1 == 1) {
            this.hgB(this.AAw);
        }
        if (var1 == 2) {
            this.hgB(this.EoS);
        }
        if (var1 == 3) {
            this.hgB(this.qie);
        }
    }
    
    private void Wad() {
        final NetworkPlayerInfo var1 = this.XmR.getConnection().getPlayerInfo(this.XmR.player.getUUID());
        if (var1 != null && !var1.equals(this.vUN)) {
            this.vUN = var1;
            this.Zyf = (Map) ReflectionUtil.bKO(Map.class, var1);
            if (this.Zyf == null) {
                this.Wad();
            }
        }
    }
    
    @Override
    public void onEnable() {
        this.Wad();
        if (this.Zyf.containsKey(MinecraftProfileTexture.Type.CAPE)) {
            if (!this.Zyf.values().containsAll(Arrays.asList(this.AAw, this.NPT, this.EoS, this.qie))) {
                this.uWv(ModuleManager.SBG(this, 1).hCJ);
            }
        }
        else {
            this.uWv(ModuleManager.SBG(this, 1).hCJ);
        }
    }
    
    @Override
    public void onSetting(final Setting var1) {
        this.uWv(var1.hCJ);
    }
    
    @Override
    public void Kxp() {
        this.Wad();
        if (this.XmR.getConnection() != null) {
            this.ULN = this.Zyf.get(MinecraftProfileTexture.Type.CAPE);
        }
        this.uWv(ModuleManager.SBG(this, 1).hCJ);
    }
    
    @Override
    public void HDK() {
        if (this.XmR.getConnection() != null && this.Zyf != null) {
            this.Zyf.put(MinecraftProfileTexture.Type.CAPE, this.ULN);
        }
    }
    public static byte[] loadByteArrayFromFile(String resourcePath) {
        try (InputStream is = Initializer.class.getClassLoader().getResourceAsStream( resourcePath)) {
            if (is == null) {
                throw new IOException("Resource not found: " + resourcePath);
            }
            byte[] byteArray = new byte[is.available()];
            is.read(byteArray);
            return byteArray;
        } catch (IOException e) {
            System.err.println("An error occurred while reading the byte array from the resource.");
            e.printStackTrace();
            return null;
        }
    }
}
