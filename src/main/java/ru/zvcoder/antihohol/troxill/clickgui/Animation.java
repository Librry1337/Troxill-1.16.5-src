// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.clickgui;

public abstract class Animation
{
    private double xiX;
    private long YDc;
    private double MGA;
    private double mrO;
    private double iqo;
    private boolean XCz;
    
    public boolean dmK() {
        final boolean var1 = this.Vti();
        if (var1) {
            this.xiX = this.AbN(this.CGj(), this.KZK(), this.DKZ());
        }
        else {
            this.YmH(0L);
            this.xiX = this.KZK();
        }
        return var1;
    }
    
    public boolean Vti() {
        return !this.sXd();
    }
    
    public boolean sXd() {
        return this.DKZ() >= 1.0;
    }
    
    public double DKZ() {
        return (System.currentTimeMillis() - this.Jpg()) / this.QPr();
    }
    
    public double AbN(final double var1, final double var3, final double var5) {
        return var1 + (var3 - var1) * var5;
    }
    
    public double Etm() {
        return this.xiX;
    }
    
    public void YQO(final double var1) {
        this.xiX = var1;
    }
    
    public long Jpg() {
        return this.YDc;
    }
    
    public void YmH(final long var1) {
        this.YDc = var1;
    }
    
    public double QPr() {
        return this.MGA;
    }
    
    public void kNm(final double var1) {
        this.MGA = var1;
    }
    
    public double CGj() {
        return this.mrO;
    }
    
    public void xsz(final double var1) {
        this.mrO = var1;
    }
    
    public double KZK() {
        return this.iqo;
    }
    
    public void dyt(final double var1) {
        this.iqo = var1;
    }
    
    public boolean nyF() {
        return this.XCz;
    }
    
    public void ZjW(final boolean var1) {
        this.XCz = var1;
    }
}
