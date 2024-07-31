// 
// Decompiled by Procyon v0.6.0
// 

package by.radioegor146.gone.fludd;

import ru.zvcoder.antihohol.troxill.Initializer;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;

@Mod("examplemod")
public class ForgeLoadHelper
{
    public ForgeLoadHelper() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::initializeCheat);
        MinecraftForge.EVENT_BUS.register((Object)this);
    }
    
    private void initializeCheat(final FMLClientSetupEvent event) {
        new Initializer();
    }
}
