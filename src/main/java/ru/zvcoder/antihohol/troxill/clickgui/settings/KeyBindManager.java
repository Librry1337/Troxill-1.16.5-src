// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.clickgui.settings;

import java.util.HashMap;

public class KeyBindManager
{
    public static HashMap<Integer, Boolean> kbt;
    public static HashMap<Integer, Boolean> Ymx;
    public static final KeyBind[] FQx;
    
    public static boolean orS(final int var0) {
        return KeyBindManager.kbt.containsKey(var0) && KeyBindManager.kbt.get(var0);
    }
    
    public static boolean kUZ(final int var0) {
        return KeyBindManager.Ymx.containsKey(var0) && KeyBindManager.Ymx.get(var0);
    }
    
    private static KeyBind ylg(final KeyBind var0) {
        return KeyBindManager.FQx[var0.VHN()] = var0;
    }
    
    private static void yWU() {
        KeyBind var10000 = ylg(new KeyBind(false, 49, "1"));
        var10000 = ylg(new KeyBind(false, 50, "2"));
        var10000 = ylg(new KeyBind(false, 51, "3"));
        var10000 = ylg(new KeyBind(false, 52, "4"));
        var10000 = ylg(new KeyBind(false, 53, "5"));
        var10000 = ylg(new KeyBind(false, 54, "6"));
        var10000 = ylg(new KeyBind(false, 55, "7"));
        var10000 = ylg(new KeyBind(false, 56, "8"));
        var10000 = ylg(new KeyBind(false, 57, "9"));
        var10000 = ylg(new KeyBind(false, 48, "0"));
        var10000 = ylg(new KeyBind(false, 81, "q"));
        var10000 = ylg(new KeyBind(false, 87, "w"));
        var10000 = ylg(new KeyBind(false, 69, "e"));
        var10000 = ylg(new KeyBind(false, 82, "r"));
        var10000 = ylg(new KeyBind(false, 84, "t"));
        var10000 = ylg(new KeyBind(false, 89, "y"));
        var10000 = ylg(new KeyBind(false, 85, "u"));
        var10000 = ylg(new KeyBind(false, 73, "i"));
        var10000 = ylg(new KeyBind(false, 79, "o"));
        var10000 = ylg(new KeyBind(false, 80, "p"));
        var10000 = ylg(new KeyBind(false, 91, "["));
        var10000 = ylg(new KeyBind(false, 93, "]"));
        var10000 = ylg(new KeyBind(false, 65, "a"));
        var10000 = ylg(new KeyBind(false, 83, "s"));
        var10000 = ylg(new KeyBind(false, 68, "d"));
        var10000 = ylg(new KeyBind(false, 70, "f"));
        var10000 = ylg(new KeyBind(false, 71, "g"));
        var10000 = ylg(new KeyBind(false, 72, "h"));
        var10000 = ylg(new KeyBind(false, 74, "j"));
        var10000 = ylg(new KeyBind(false, 75, "k"));
        var10000 = ylg(new KeyBind(false, 76, "l"));
        var10000 = ylg(new KeyBind(false, 39, ";"));
        var10000 = ylg(new KeyBind(false, 59, "'"));
        var10000 = ylg(new KeyBind(false, 90, "z"));
        var10000 = ylg(new KeyBind(false, 88, "x"));
        var10000 = ylg(new KeyBind(false, 67, "c"));
        var10000 = ylg(new KeyBind(false, 86, "v"));
        var10000 = ylg(new KeyBind(false, 66, "b"));
        var10000 = ylg(new KeyBind(false, 78, "n"));
        var10000 = ylg(new KeyBind(false, 77, "m"));
        var10000 = ylg(new KeyBind(false, 44, ","));
        var10000 = ylg(new KeyBind(false, 46, "."));
        var10000 = ylg(new KeyBind(false, 47, "/"));
        var10000 = ylg(new KeyBind(false, 61, "+"));
        var10000 = ylg(new KeyBind(false, 45, "-"));
        var10000 = ylg(new KeyBind(false, 92, "\\"));
        var10000 = ylg(new KeyBind(false, 261, new String[] { "de", "le", "te" }));
        var10000 = ylg(new KeyBind(false, 268, new String[] { "ho", "me" }));
        var10000 = ylg(new KeyBind(false, 284, new String[] { "pa", "us", "e" }));
        var10000 = ylg(new KeyBind(false, 344, new String[] { "ri", "gh", "t ", "sh", "if", "t" }));
        var10000 = ylg(new KeyBind(false, 340, new String[] { "le", "ft", " s", "hi", "ft" }));
        var10000 = ylg(new KeyBind(false, 257, new String[] { "en", "te", "r" }));
        var10000 = ylg(new KeyBind(false, 258, new String[] { "ta", "b" }));
        var10000 = ylg(new KeyBind(false, 280, new String[] { "ca", "ps" }));
        var10000 = ylg(new KeyBind(false, 32, new String[] { "sp", "ac", "e" }));
        var10000 = ylg(new KeyBind(false, 341, new String[] { "le", "ft", " c", "on", "tr", "ol" }));
        var10000 = ylg(new KeyBind(false, 345, new String[] { "ri", "gh", "t ", "co", "nt", "ro", "l" }));
        var10000 = ylg(new KeyBind(false, 342, new String[] { "le", "ft", " a", "lt" }));
        var10000 = ylg(new KeyBind(false, 346, new String[] { "ri", "gh", "t ", "al", "t" }));
    }
    
    static {
        KeyBindManager.kbt = new HashMap();
        KeyBindManager.Ymx = new HashMap();
        FQx = new KeyBind[400];
        yWU();
    }
}
