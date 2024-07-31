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
        return KeyBindManager.FQx[var0.get_key_bind()] = var0;
    }
    
    private static void yWU() {
        KeyBind var10000 = ylg(new KeyBind(49, "1"));
        var10000 = ylg(new KeyBind(50, "2"));
        var10000 = ylg(new KeyBind(51, "3"));
        var10000 = ylg(new KeyBind(52, "4"));
        var10000 = ylg(new KeyBind(53, "5"));
        var10000 = ylg(new KeyBind(54, "6"));
        var10000 = ylg(new KeyBind(55, "7"));
        var10000 = ylg(new KeyBind(56, "8"));
        var10000 = ylg(new KeyBind(57, "9"));
        var10000 = ylg(new KeyBind(48, "0"));
        var10000 = ylg(new KeyBind(81, "q"));
        var10000 = ylg(new KeyBind(87, "w"));
        var10000 = ylg(new KeyBind(69, "e"));
        var10000 = ylg(new KeyBind(82, "r"));
        var10000 = ylg(new KeyBind(84, "t"));
        var10000 = ylg(new KeyBind(89, "y"));
        var10000 = ylg(new KeyBind(85, "u"));
        var10000 = ylg(new KeyBind(73, "i"));
        var10000 = ylg(new KeyBind(79, "o"));
        var10000 = ylg(new KeyBind(80, "p"));
        var10000 = ylg(new KeyBind(91, "["));
        var10000 = ylg(new KeyBind(93, "]"));
        var10000 = ylg(new KeyBind(65, "a"));
        var10000 = ylg(new KeyBind(83, "s"));
        var10000 = ylg(new KeyBind(68, "d"));
        var10000 = ylg(new KeyBind(70, "f"));
        var10000 = ylg(new KeyBind(71, "g"));
        var10000 = ylg(new KeyBind(72, "h"));
        var10000 = ylg(new KeyBind(74, "j"));
        var10000 = ylg(new KeyBind(75, "k"));
        var10000 = ylg(new KeyBind(76, "l"));
        var10000 = ylg(new KeyBind(39, ";"));
        var10000 = ylg(new KeyBind(59, "'"));
        var10000 = ylg(new KeyBind(90, "z"));
        var10000 = ylg(new KeyBind(88, "x"));
        var10000 = ylg(new KeyBind(67, "c"));
        var10000 = ylg(new KeyBind(86, "v"));
        var10000 = ylg(new KeyBind(66, "b"));
        var10000 = ylg(new KeyBind(78, "n"));
        var10000 = ylg(new KeyBind(77, "m"));
        var10000 = ylg(new KeyBind(44, ","));
        var10000 = ylg(new KeyBind(46, "."));
        var10000 = ylg(new KeyBind(47, "/"));
        var10000 = ylg(new KeyBind(61, "+"));
        var10000 = ylg(new KeyBind(45, "-"));
        var10000 = ylg(new KeyBind(92, "\\"));
        var10000 = ylg(new KeyBind(261, new String[] { "de", "le", "te" }));
        var10000 = ylg(new KeyBind(268, new String[] { "ho", "me" }));
        var10000 = ylg(new KeyBind(284, new String[] { "pa", "us", "e" }));
        var10000 = ylg(new KeyBind(344, new String[] { "ri", "gh", "t ", "sh", "if", "t" }));
        var10000 = ylg(new KeyBind(340, new String[] { "le", "ft", " s", "hi", "ft" }));
        var10000 = ylg(new KeyBind(257, new String[] { "en", "te", "r" }));
        var10000 = ylg(new KeyBind(258, new String[] { "ta", "b" }));
        var10000 = ylg(new KeyBind(280, new String[] { "ca", "ps" }));
        var10000 = ylg(new KeyBind(32, new String[] { "sp", "ac", "e" }));
        var10000 = ylg(new KeyBind(341, new String[] { "le", "ft", " c", "on", "tr", "ol" }));
        var10000 = ylg(new KeyBind(345, new String[] { "ri", "gh", "t ", "co", "nt", "ro", "l" }));
        var10000 = ylg(new KeyBind(342, new String[] { "le", "ft", " a", "lt" }));
        var10000 = ylg(new KeyBind(346, new String[] { "ri", "gh", "t ", "al", "t" }));
    }
    
    static {
        KeyBindManager.kbt = new HashMap();
        KeyBindManager.Ymx = new HashMap();
        FQx = new KeyBind[400];
        yWU();
    }
}
