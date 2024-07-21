// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.utils.calc;

public class TimerHelper
{
    private long MYs;
    private long Dpk;
    private boolean kAJ;
    public static long WFE;
    
    public TimerHelper() {
        this.MYs = 0L;
    }
    
    public static long ZmR() {
        return System.currentTimeMillis();
    }
    
    public boolean Eza(final float var1) {
        return ZmR() - TimerHelper.WFE >= var1;
    }
    
    public long clS() {
        return System.nanoTime() / 1000000L;
    }
    
    public boolean pJy(final double var1) {
        return this.clS() - this.Dpk >= var1;
    }
    
    public void OQP() {
        this.Dpk = this.clS();
    }
    
    public boolean RuA() {
        return this.kAJ;
    }
    
    public void kWd(final boolean var1) {
        this.kAJ = var1;
    }
    
    public boolean CTJ(final float var1) {
        return this.gcs() - this.MYs >= var1;
    }
    
    public void DOK(final long var1) {
        this.Dpk = var1;
    }
    
    public long gcs() {
        return this.clS() - this.Dpk;
    }
    
    static {
        TimerHelper.WFE = -1L;
    }
}
