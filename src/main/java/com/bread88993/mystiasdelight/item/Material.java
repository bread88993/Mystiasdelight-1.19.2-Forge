package com.bread88993.mystiasdelight.item;

import com.ibm.icu.text.Normalizer2;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraftforge.fml.common.Mod;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class Material {
    public static final FoodProperties WAGYU = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.4F).meat().build();
    public static final FoodProperties COOKEDWAGYU = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.8F).effect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0), 1.0F).build();
    public static final FoodProperties PEACH = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0), 1.0F).build();
    public static final FoodProperties TOFU = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.4F).build();
    public static final FoodProperties EEL = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.6F).build();
    public static final FoodProperties CRAB = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).build();
    public static final FoodProperties SHRIMP = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).build();
    public static final FoodProperties OCTOPUS = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).build();
    public static final FoodProperties TUNA = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).effect(new MobEffectInstance(MobEffects.WATER_BREATHING, 1200, 0), 1.0F).build();
    public static final FoodProperties CUCUMBER = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.4F).build();
    public static final FoodProperties RADISH = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.4F).build();
    public static final FoodProperties CHILIPEPPER = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F).effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0), 1.0F).build();
    public static final FoodProperties SCALLION = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.4F).build();
    public static final FoodProperties CHEESE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).build();
    public static final FoodProperties SWEETPOTATO = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.4F).build();
    public static final FoodProperties LEMON = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.4F).build();
    public static final FoodProperties TRUFFLE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F).effect(new MobEffectInstance(MobEffects.REGENERATION, 600, 0), 1.0F).build();
    public static final FoodProperties WILDSALAD = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.5F).effect(new MobEffectInstance(MobEffects.SATURATION, 2, 0), 1.0F).build();
    public static final FoodProperties MINERSALAD = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.5F).effect(new MobEffectInstance(MobEffects.DIG_SPEED, 600, 0), 1.0F).build();
    public static final FoodProperties MINERSALADP = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).effect(new MobEffectInstance(MobEffects.POISON, 300, 0), 1.0F).build();
    public static final FoodProperties MINERSANDWICH = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.5F).effect(new MobEffectInstance(MobEffects.DIG_SPEED, 600, 0), 1.0F).build();
    public static final FoodProperties MINERSANDWICHP = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).effect(new MobEffectInstance(MobEffects.POISON, 300, 0), 1.0F).build();
    public static final FoodProperties CUREDMEAT = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).build();
    public static final FoodProperties MONSTERKEBABS = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.5F).effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 0), 1.0F).build();
    public static final FoodProperties CAVEHOTPOT = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.5F).effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2400, 0), 1.0F).build();
    public static final FoodProperties DREAMMATERIAL = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).effect(new MobEffectInstance(MobEffects.SLOW_FALLING, 600, 0), 1.0F).build();
    public static final FoodProperties FLESHKEBABS = (new FoodProperties.Builder()).nutrition(9).saturationMod(0.5F).effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 0), 1.0F).build();
    public static final FoodProperties SALADSAUCE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).effect(new MobEffectInstance(MobEffects.WEAKNESS, 600, 0), 1.0F).build();
    public static final FoodProperties MAPOTOFU = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.8F).effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 7200, 0), 1.0F).build();
    public static final FoodProperties APPLEICE = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.6F).effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 3600, 0), 1.0F).build();
    public static final FoodProperties OBSIDIANFANTASYDRINK = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.5F).effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2400, 0), 1.0F).effect(new MobEffectInstance(MobEffects.SLOW_FALLING, 2400, 0), 1.0F).effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2400, 0), 1.0F).effect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0), 1.0F).effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2400, 0), 1.0F).effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 2), 1.0F).effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2400, 0), 1.0F).alwaysEat().build();
    public static final FoodProperties SMARTJELLIEDTOFU = (new FoodProperties.Builder()).nutrition(9).saturationMod(0.9F).build();
    public static final FoodProperties HONEYSTEAK = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.8F).effect(new MobEffectInstance(MobEffects.REGENERATION, 400, 0), 1.0F).build();
    public static final FoodProperties HELLSAUSAGE = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.8F).effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 0), 1.0F).build();
}
