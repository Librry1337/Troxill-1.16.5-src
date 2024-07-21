// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules;

public class Category
{
    public static final int oLr = 0;
    public static final int vuM = 1;
    public static final int APq = 2;
    public static final int oHf = 3;
    public static final int lfc = 4;
    
    public static String[] JiL(final int var0) {
        if (var0 == 0) {
            return new String[] { "Co", "mb", "at" };
        }
        if (var0 == 1) {
            return new String[] { "Mo", "ve", "me", "nt" };
        }
        if (var0 == 2) {
            return new String[] { "Gh", "os", "t" };
        }
        if (var0 == 3) {
            return new String[] { "Re", "nd", "er" };
        }
        return (var0 == 4) ? new String[] { "Pl", "ay", "er" } : new String[] { null };
    }
}
