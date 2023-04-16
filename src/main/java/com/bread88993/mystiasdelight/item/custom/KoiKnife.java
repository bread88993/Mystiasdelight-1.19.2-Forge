package com.bread88993.mystiasdelight.item.custom;

import com.bread88993.mystiasdelight.item.ModItems;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class KoiKnife {
    public static void execute(Entity entity) {
        if (entity == null) {
            return;
        }
        if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ModItems.KOIKNIFE
                .get()) {
            if (entity instanceof LivingEntity _entity) {
                _entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 60, 1));
            }
        }
    }
}