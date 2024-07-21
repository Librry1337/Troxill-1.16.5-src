// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.packets;

import io.netty.channel.ChannelPromise;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import java.lang.reflect.Field;
import net.minecraft.network.NetworkManager;
import io.netty.channel.ChannelHandler;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import io.netty.channel.Channel;
import ru.zvcoder.antihohol.troxill.modules.ModuleManager;
import io.netty.channel.ChannelDuplexHandler;

public class PacketHandler extends ChannelDuplexHandler
{
    ModuleManager EDe;
    Channel WOc;
    
    public PacketHandler(final ModuleManager var1) {
        this.EDe = var1;
        try {
            final NetworkManager var2 = Objects.requireNonNull(Minecraft.getInstance().getConnection()).getConnection();
            for (final Field var6 : var2.getClass().getDeclaredFields()) {
                if (var6.getType().getName().contains(Channel.class.getName())) {
                    var6.setAccessible(true);
                    this.WOc = (Channel)var6.get(var2);
                    final ChannelPipeline var7 = this.WOc.pipeline();
                    var7.addBefore("packet_handler", "PacketHandler", (ChannelHandler)this);
                }
            }
        }
        catch (final Exception ex) {}
    }
    
    public void channelRead(final ChannelHandlerContext var1, final Object var2) throws Exception {
        if (!this.EDe.slG(var2, 0)) {
            super.channelRead(var1, var2);
        }
    }
    
    public void write(final ChannelHandlerContext var1, final Object var2, final ChannelPromise var3) throws Exception {
        if (!this.EDe.slG(var2, 0)) {
            super.write(var1, var2, var3);
        }
    }
}
