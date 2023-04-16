package com.bread88993.mystiasdelight.recipe;

import com.bread88993.mystiasdelight.Mystiasdelight;
import com.bread88993.mystiasdelight.block.custom.Steamer;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Mystiasdelight.MOD_ID);

    public static final RegistryObject<RecipeSerializer<BarbecuenetRecipe>> BARBECUENET_SERIALIZER =
            SERIALIZERS.register("barbecue",() -> BarbecuenetRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<PressurecookerRecipe>> PRESSURECOOKER_SERIALIZER =
            SERIALIZERS.register("pressure",() -> PressurecookerRecipe.Serializer.PRESS);
    public static final RegistryObject<RecipeSerializer<SteamerRecipe>> STEAMER_SERIALIZER =
            SERIALIZERS.register("steaming",() -> SteamerRecipe.Serializer.STEAM);

    public static final RegistryObject<RecipeSerializer<WokRecipe>> WOK_SERIALIZER =
            SERIALIZERS.register("frying",() -> WokRecipe.Serializer.FRY);

    public static final RegistryObject<RecipeSerializer<CookingtableRecipe>> COOKINGTABLE_SERIALIZER =
            SERIALIZERS.register("handmake",() -> CookingtableRecipe.Serializer.HAND);

    public static void  register(IEventBus eventBus){
        SERIALIZERS.register(eventBus);
    }
}
