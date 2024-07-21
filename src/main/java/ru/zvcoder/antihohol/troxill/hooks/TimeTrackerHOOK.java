// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.hooks;

import net.minecraft.profiler.IProfileResult;
import net.minecraft.profiler.IProfiler;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import net.minecraft.profiler.TimeTracker;

public class TimeTrackerHOOK extends TimeTracker
{
    private ProfilerHOOK LWo;
    
    public TimeTrackerHOOK(final LongSupplier var1, final IntSupplier var2) {
        super(var1, var2);
        this.LWo = ProfilerHOOK.MHg;
    }
    
    public boolean isEnabled() {
        return this.LWo != ProfilerHOOK.MHg;
    }
    
    public void disable() {
        this.LWo = ProfilerHOOK.MHg;
    }
    
    public void enable() {
        this.LWo = new ProfilerHOOK();
    }
    
    public IProfiler getFiller() {
        return (IProfiler)this.LWo;
    }
    
    public IProfileResult getResults() {
        return super.getResults();
    }
}
