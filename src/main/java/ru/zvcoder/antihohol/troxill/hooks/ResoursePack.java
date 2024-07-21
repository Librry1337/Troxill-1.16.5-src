// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.hooks;

import net.minecraft.client.renderer.texture.TextureManager;
import java.io.IOException;
import net.minecraft.client.renderer.texture.Texture;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import java.io.InputStream;
import net.minecraft.client.renderer.texture.NativeImage;
import java.io.ByteArrayInputStream;
import net.minecraft.util.ResourceLocation;

public class ResoursePack
{
    public static ResourceLocation WGP(final byte[] var0) {
        try {
            final NativeImage var = NativeImage.read((InputStream)new ByteArrayInputStream(var0));
            final DynamicTexture var2 = new DynamicTexture(var);
            final TextureManager var3 = Minecraft.getInstance().getTextureManager();
            final ResourceLocation var4 = var3.register(var2.toString().split("@")[var2.toString().split("@").length - 1], var2);
            var3.register(var4, (Texture)var2);
            var2.upload();
            return var4;
        }
        catch (final IOException var5) {
            return null;
        }
    }
}
