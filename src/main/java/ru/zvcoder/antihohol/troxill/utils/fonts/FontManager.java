// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.utils.fonts;

import ru.zvcoder.antihohol.troxill.modules.render.StreamBypassModule;

import static ru.zvcoder.antihohol.troxill.modules.render.CustomCapeModule.loadByteArrayFromFile;

public class FontManager
{
    private static FontRenderer loV;
    private static FontRenderer jqO;
    public static FontRenderer ElD;
    private static FontRenderer AMb;
    private static FontRenderer LTh;
    private static FontRenderer aus;
    private static FontRenderer dOb;
    private static FontRenderer YuE;
    public static FontRenderer IOb;
    private static FontRenderer QpW;
    private static FontRenderer UoV;
    private static FontRenderer keb;
    private static byte[] fontData;
    
    public static FontRenderer Bbk() {
        if (StreamBypassModule.ufx == null) {
            return FontManager.ElD;
        }
        return StreamBypassModule.ufx.inu() ? FontManager.IOb : FontManager.ElD;
    }
    
    public static FontRenderer LWJ() {
        if (StreamBypassModule.ufx == null) {
            return FontManager.AMb;
        }
        return StreamBypassModule.ufx.inu() ? FontManager.QpW : FontManager.AMb;
    }
    
    public static FontRenderer uAe() {
        if (StreamBypassModule.ufx == null) {
            return FontManager.LTh;
        }
        return StreamBypassModule.ufx.inu() ? FontManager.UoV : FontManager.LTh;
    }
    
    public static FontRenderer nPm() {
        if (StreamBypassModule.ufx == null) {
            return FontManager.aus;
        }
        return StreamBypassModule.ufx.inu() ? FontManager.keb : FontManager.aus;
    }
    
    public static FontRenderer awW() {
        if (StreamBypassModule.ufx == null) {
            return FontManager.jqO;
        }
        return StreamBypassModule.ufx.inu() ? FontManager.YuE : FontManager.jqO;
    }
    
    public static FontRenderer oci() {
        if (StreamBypassModule.ufx == null) {
            return FontManager.loV;
        }
        return StreamBypassModule.ufx.inu() ? FontManager.dOb : FontManager.loV;
    }
    
    public static void GHW() {
        FontManager.IOb = null;
    }
    
    public static void loadResources() {
        FontManager.fontData = loadByteArrayFromFile("font.dat");
        FontManager.loV = FontRenderer.ElD(FontManager.fontData, 23, false, false, false);
        FontManager.jqO = FontRenderer.ElD(FontManager.fontData, 19, false, false, false);
        FontManager.ElD = FontRenderer.ElD(FontManager.fontData, 18, false, false, false);
        FontManager.AMb = FontRenderer.ElD(FontManager.fontData, 17, false, false, false);
        FontManager.LTh = FontRenderer.ElD(FontManager.fontData, 15, false, false, false);
        FontManager.aus = FontRenderer.ElD(FontManager.fontData, 10, false, false, false);
    }
    
    public static void PjI() {
        FontManager.fontData = loadByteArrayFromFile("font.dat");
        FontManager.dOb = FontRenderer.ElD(FontManager.fontData, 23, false, false, false);
        FontManager.YuE = FontRenderer.ElD(FontManager.fontData, 19, false, false, false);
        FontManager.IOb = FontRenderer.ElD(FontManager.fontData, 18, false, false, false);
        FontManager.QpW = FontRenderer.ElD(FontManager.fontData, 17, false, false, false);
        FontManager.UoV = FontRenderer.ElD(FontManager.fontData, 15, false, false, false);
        FontManager.keb = FontRenderer.ElD(FontManager.fontData, 10, false, false, false);
    }
}
