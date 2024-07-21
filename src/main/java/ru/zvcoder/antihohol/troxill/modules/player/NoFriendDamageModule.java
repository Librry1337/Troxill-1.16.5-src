// 
// Decompiled by Procyon v0.6.0
// 

package ru.zvcoder.antihohol.troxill.modules.player;

import ru.zvcoder.antihohol.troxill.managers.FriendManager;
import ru.zvcoder.antihohol.troxill.events.AttackEvent;
import ru.zvcoder.antihohol.troxill.modules.AbstractModule;

public class NoFriendDamageModule extends AbstractModule
{
    public NoFriendDamageModule(final int var1, final String[] var2, final int var3, final int var4) {
        super(var1, var2, var3, var4);
    }
    
    @Override
    public void onAttack(final AttackEvent var1) {
        if (FriendManager.friendEntityMap.containsValue(var1.YpI)) {
            var1.wex = true;
        }
    }
}
