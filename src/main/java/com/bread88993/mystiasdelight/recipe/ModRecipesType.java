package com.bread88993.mystiasdelight.recipe;

import com.bread88993.mystiasdelight.Mystiasdelight;
import com.bread88993.mystiasdelight.block.custom.Cookingtable;
import com.bread88993.mystiasdelight.block.custom.Steamer;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipesType {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registry.RECIPE_TYPE.key(), Mystiasdelight.MOD_ID);

    public static final RegistryObject<RecipeType<BarbecuenetRecipe>> BARBECUE = RECIPE_TYPES.register("barbecue",() -> BarbecuenetRecipe.Type.INSTANCE);

    public static final RegistryObject<RecipeType<PressurecookerRecipe>> PRESSURE = RECIPE_TYPES.register("pressure",() -> PressurecookerRecipe.Type.PRESS);

    public static final RegistryObject<RecipeType<SteamerRecipe>> STEAMING = RECIPE_TYPES.register("steaming",() -> SteamerRecipe.Type.STEAM);

    public static final RegistryObject<RecipeType<WokRecipe>> FRYING = RECIPE_TYPES.register("frying",() -> WokRecipe.Type.FRY);

    public static final RegistryObject<RecipeType<CookingtableRecipe>> HANDMAKE = RECIPE_TYPES.register("handmake",() -> CookingtableRecipe.Type.HAND);

    public static void  register(IEventBus eventBus){
        RECIPE_TYPES.register(eventBus);
    }
}
