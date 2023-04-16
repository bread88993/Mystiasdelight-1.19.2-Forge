package com.bread88993.mystiasdelight.integration;

import com.bread88993.mystiasdelight.Mystiasdelight;
import com.bread88993.mystiasdelight.block.ModBlocks;
import com.bread88993.mystiasdelight.recipe.BarbecuenetRecipe;
import com.bread88993.mystiasdelight.recipe.WokRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import vectorwing.farmersdelight.common.utility.TextUtils;

import javax.annotation.Nonnull;

public class WokRecipeCategory implements IRecipeCategory<WokRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(Mystiasdelight.MOD_ID, "frying");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(Mystiasdelight.MOD_ID, "textures/gui/wok_gui_jei.png");

    private final IDrawable background;
    private final IDrawable icon;

    public WokRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 29, 16, 117, 57);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.WOK.get()));
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends WokRecipe> getRecipeClass() {
        return WokRecipe.class;
    }

    @Override
    public RecipeType<WokRecipe> getRecipeType(){
        return JEIMystiaPlugin.FRY_TYPE;
    }


    @Override
    public Component getTitle() {
        return TextUtils.getTranslation("mystiasdelight.wok");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull WokRecipe recipe, @Nonnull IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 1).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 19, 1).addIngredients(Ingredient.of(Items.BARRIER));
        builder.addSlot(RecipeIngredientRole.INPUT, 37, 1).addIngredients(Ingredient.of(Items.BARRIER));
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 19).addIngredients(Ingredient.of(Items.BARRIER));
        builder.addSlot(RecipeIngredientRole.INPUT, 19, 19).addIngredients(Ingredient.of(Items.BARRIER));
        builder.addSlot(RecipeIngredientRole.INPUT, 37, 19).addIngredients(Ingredient.of(Items.BARRIER));
        builder.addSlot(RecipeIngredientRole.INPUT, 63, 29).addIngredients(Ingredient.of(Items.BARRIER));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 95, 10).addItemStack(recipe.getResultItem());

    }


}
