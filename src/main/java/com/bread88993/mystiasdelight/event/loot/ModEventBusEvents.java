package com.bread88993.mystiasdelight.event.loot;


import com.bread88993.mystiasdelight.Mystiasdelight;
import com.bread88993.mystiasdelight.recipe.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = Mystiasdelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegisterEvent event) {

        event.register(ForgeRegistries.Keys.RECIPE_TYPES, helper -> {
            helper.register(new ResourceLocation(Mystiasdelight.MOD_ID, BarbecuenetRecipe.Type.ID),
                    BarbecuenetRecipe.Type.INSTANCE);
            helper.register(new ResourceLocation(Mystiasdelight.MOD_ID, PressurecookerRecipe.Type.ID),
                    PressurecookerRecipe.Type.PRESS);
            helper.register(new ResourceLocation(Mystiasdelight.MOD_ID, SteamerRecipe.Type.ID),
                    SteamerRecipe.Type.STEAM);
            helper.register(new ResourceLocation(Mystiasdelight.MOD_ID, WokRecipe.Type.ID),
                    WokRecipe.Type.FRY);
            helper.register(new ResourceLocation(Mystiasdelight.MOD_ID, CookingtableRecipe.Type.ID),
                    CookingtableRecipe.Type.HAND);
        });
    }



}
