// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.utils.render;

import net.minecraft.client.Minecraft;

public class WidthHeightHelper
{
    public static double sug() {
        return Minecraft.getInstance().mouseHandler.xpos() * Minecraft.getInstance().getWindow().getGuiScaledWidth() / Minecraft.getInstance().getWindow().getScreenWidth();
    }
    
    public static double HLX() {
        return Minecraft.getInstance().mouseHandler.ypos() * Minecraft.getInstance().getWindow().getGuiScaledWidth() / Minecraft.getInstance().getWindow().getScreenWidth();
    }
}
