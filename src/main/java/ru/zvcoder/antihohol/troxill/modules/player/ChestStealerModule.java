// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules.player;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.item.Item;
import net.minecraft.inventory.container.ChestContainer;
import java.util.Objects;
import ru.zvcoder.antihohol.troxill.clickgui.settings.Setting;
import net.minecraft.client.Minecraft;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;
import ru.zvcoder.antihohol.troxill.modules.ModuleManager;
import ru.zvcoder.antihohol.troxill.utils.calc.TimerHelper;

public class ChestStealerModule extends AbstractModule
{
    TimerHelper FaD;
    private final Minecraft XKR;
    
    public ChestStealerModule(final int var1, final String[] var2, final int var3, final int var4) {
        super(var1, var2, var3, var4);
        this.FaD = new TimerHelper();
        this.XKR = Minecraft.getInstance();
        final Setting var5 = ModuleManager.zWY(new Setting(this, new String[] { "Delay", ":" }, 50.0, 1.0, 100.0, true, 1));
    }
    
    @Override
    public void onEnable() {
        if (this.XKR.player != null && this.XKR.gameMode != null) {
            final int var1 = (int)Objects.requireNonNull(ModuleManager.SBG(this, 1)).iUj();
            if (ChestContainer.class.isInstance(this.XKR.player.containerMenu)) {
                final Container var2 = this.XKR.player.containerMenu;
                for (int var3 = 0; var3 < var2.slots.size(); ++var3) {
                    if (((ChestContainer)var2).getContainer().getItem(var3).getItem() != Item.byId(0) && this.FaD.pJy(var1)) {
                        final ItemStack var4 = this.XKR.gameMode.handleInventoryMouseClick(var2.containerId, var3, 0, ClickType.QUICK_MOVE, (PlayerEntity)this.XKR.player);
                        this.FaD.OQP();
                    }
                }
            }
        }
    }
}
