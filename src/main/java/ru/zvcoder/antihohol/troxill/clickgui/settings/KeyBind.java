// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.clickgui.settings;

public class KeyBind
{

    private final int key_bind;
    private String display_name;
    private String[] display_name_list;
    
    public KeyBind(final int var2, final String var3) {

        this.key_bind = var2;
        this.display_name = var3;
    }
    
    public KeyBind(final int var2, final String[] var3) {

        this.key_bind = var2;
        this.display_name_list = var3;
    }
    
    public String[] get_display_name_list() {
        return this.display_name_list;
    }

    
    public int get_key_bind() {
        return this.key_bind;
    }
    
    public String get_display_name() {
        return this.display_name;
    }
}
