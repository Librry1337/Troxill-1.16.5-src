// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules.player;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.client.gui.screen.inventory.ChestScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.client.Minecraft;
import ru.zvcoder.antihohol.troxill.clickgui.settings.KeyBindManager;
import java.util.Objects;
import java.lang.reflect.Field;
import ru.zvcoder.antihohol.troxill.Initializer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.inventory.container.Slot;
import net.minecraft.client.gui.screen.Screen;
import ru.zvcoder.antihohol.troxill.events.MouseEvent;
import ru.zvcoder.antihohol.troxill.clickgui.settings.Setting;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;
import ru.zvcoder.antihohol.troxill.modules.ModuleManager;
import ru.zvcoder.antihohol.troxill.utils.calc.TimerHelper;

public class ItemScrollerModule extends AbstractModule
{
    private final TimerHelper nhA;
    boolean MOW;
    
    public ItemScrollerModule(final int var1, final String[] var2, final int var3, final int var4) {
        super(var1, var2, var3, var4);
        this.nhA = new TimerHelper();
        final Setting var5 = ModuleManager.zWY(new Setting(this, new String[] { "De", "la", "y" }, 150.0, 50.0, 500.0, true, 1));
    }
    
    @Override
    public void onMouse(final MouseEvent var1) {
        if (var1.Lfk == 0) {
            this.MOW = (var1.Dan == 1);
        }
        super.onMouse(var1);
    }
    
    private int QkX(final int var1) {
        if (var1 == 1) {
            return 9;
        }
        if (var1 == 2) {
            return 9;
        }
        if (var1 == 3) {
            return 9;
        }
        return (var1 == 4) ? 9 : 0;
    }
    
    private Slot AVQ(final Screen var1) {
        final Field[] var2 = ContainerScreen.class.getDeclaredFields();
        final Field var3 = var2[this.QkX(Initializer.field_id)];
        var3.setAccessible(true);
        try {
            final Slot var4 = (Slot)var3.get(var1);
            return var4;
        }
        catch (final Exception var5) {
            var5.printStackTrace();
            return null;
        }
    }
    
    @Override
    public void onEnable() {
        if (this.nhA.pJy(Objects.requireNonNull(ModuleManager.SBG(this, 1)).iUj())) {
            if (KeyBindManager.kUZ(340) && this.MOW) {
                final Minecraft var1 = Minecraft.getInstance();
                if (var1.screen != null && var1.player != null && var1.gameMode != null) {
                    if (InventoryScreen.class.isInstance(var1.screen)) {
                        final InventoryScreen var2 = (InventoryScreen)var1.screen;
                        final Slot var3 = this.AVQ((Screen)var2);
                        if (var3 != null) {
                            final PlayerContainer var4 = (PlayerContainer)var1.player.containerMenu;
                            if (!var4.slots.get(var3.index).getItem().isEmpty()) {
                                final ItemStack var5 = var1.gameMode.handleInventoryMouseClick(var4.containerId, Objects.requireNonNull(var3).index, 0, ClickType.QUICK_MOVE, (PlayerEntity)var1.player);
                                this.nhA.OQP();
                            }
                        }
                    }
                    if (ChestScreen.class.isInstance(var1.screen)) {
                        final ChestScreen var6 = (ChestScreen)var1.screen;
                        final Slot var3 = this.AVQ((Screen)var6);
                        if (var3 != null) {
                            final ChestContainer var7 = (ChestContainer)var1.player.containerMenu;
                            final ItemStack var5 = var1.gameMode.handleInventoryMouseClick(var7.containerId, Objects.requireNonNull(var3).index, 0, ClickType.QUICK_MOVE, (PlayerEntity)var1.player);
                            this.nhA.OQP();
                        }
                    }
                }
            }
            super.onEnable();
        }
    }
}
