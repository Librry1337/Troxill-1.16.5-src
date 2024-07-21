// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.events;

public class PlayerRotationEvent
{
    private float VpF;
    private float iiE;
    private final float SmN;
    private final float CFz;
    
    public PlayerRotationEvent(final float var1, final float var2) {
        this.SmN = var1;
        this.CFz = var2;
        this.VpF = var1;
        this.iiE = var2;
    }
    
    public float nxX() {
        return this.VpF;
    }
    
    public float VLT() {
        return this.iiE;
    }
    
    public void GQb(final float var1) {
        this.VpF = var1;
    }
    
    public void QMO(final float var1) {
        this.iiE = var1;
    }
    
    public float aLl() {
        return this.SmN;
    }
    
    public float pEh() {
        return this.CFz;
    }
}
