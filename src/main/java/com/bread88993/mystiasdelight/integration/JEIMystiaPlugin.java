package com.bread88993.mystiasdelight.integration;

import com.bread88993.mystiasdelight.Mystiasdelight;
import com.bread88993.mystiasdelight.block.custom.Pressurecooker;
import com.bread88993.mystiasdelight.recipe.*;
import com.bread88993.mystiasdelight.screen.BarbecuenetScreen;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIMystiaPlugin implements IModPlugin {
    //@Override
    //public ResourceLocation getPluginUid() {
        //return new ResourceLocation(Mystiasdelight.MOD_ID,"jei_plugin");
    //}


    public static RecipeType<BarbecuenetRecipe> BARBECUE_TYPE =
            new RecipeType<>(BarbecuenetRecipeCategory.UID, BarbecuenetRecipe.class);
    public static RecipeType<PressurecookerRecipe> PRESS_TYPE =
            new RecipeType<>(PressurecookerRecipeCategory.UID, PressurecookerRecipe.class);
    public static RecipeType<SteamerRecipe> STEAM_TYPE =
            new RecipeType<>(SteamerRecipeCategory.UID, SteamerRecipe.class);
    public static RecipeType<WokRecipe> FRY_TYPE =
            new RecipeType<>(WokRecipeCategory.UID, WokRecipe.class);
    public static RecipeType<CookingtableRecipe> HAND_TYPE =
            new RecipeType<>(CookingtableRecipeCategory.UID, CookingtableRecipe.class);

    private static final ResourceLocation ID = new ResourceLocation(Mystiasdelight.MOD_ID, "jei_plugin");

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                BarbecuenetRecipeCategory(registration.getJeiHelpers().getGuiHelper()));

        registration.addRecipeCategories(new
                PressurecookerRecipeCategory(registration.getJeiHelpers().getGuiHelper()));

        registration.addRecipeCategories(new
                SteamerRecipeCategory(registration.getJeiHelpers().getGuiHelper()));

        registration.addRecipeCategories(new
                WokRecipeCategory(registration.getJeiHelpers().getGuiHelper()));

        registration.addRecipeCategories(new
                CookingtableRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<BarbecuenetRecipe> recipes = rm.getAllRecipesFor(BarbecuenetRecipe.Type.INSTANCE);
        registration.addRecipes(BARBECUE_TYPE, recipes);

        List<PressurecookerRecipe> recipes2 = rm.getAllRecipesFor(PressurecookerRecipe.Type.PRESS);
        registration.addRecipes(PRESS_TYPE, recipes2);

        List<SteamerRecipe> recipes3 = rm.getAllRecipesFor(SteamerRecipe.Type.STEAM);
        registration.addRecipes(STEAM_TYPE, recipes3);

        List<WokRecipe> recipes4 = rm.getAllRecipesFor(WokRecipe.Type.FRY);
        registration.addRecipes(FRY_TYPE, recipes4);

        List<CookingtableRecipe> recipes5 = rm.getAllRecipesFor(CookingtableRecipe.Type.HAND);
        registration.addRecipes(HAND_TYPE, recipes5);

    }

    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }

}
