// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.clickgui.settings;

public class KeyBind
{
    private final boolean vZM;
    private final int BNh;
    private String NpN;
    private String[] Moa;
    
    public KeyBind(final boolean var1, final int var2, final String var3) {
        this.vZM = var1;
        this.BNh = var2;
        this.NpN = var3;
    }
    
    public KeyBind(final boolean var1, final int var2, final String[] var3) {
        this.vZM = var1;
        this.BNh = var2;
        this.Moa = var3;
    }
    
    public String[] FTv() {
        return this.Moa;
    }
    
    public boolean GDN() {
        return this.vZM;
    }
    
    public int VHN() {
        return this.BNh;
    }
    
    public String oGI() {
        return this.NpN;
    }
}
