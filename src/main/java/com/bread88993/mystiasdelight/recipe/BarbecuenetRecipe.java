package com.bread88993.mystiasdelight.recipe;

import com.bread88993.mystiasdelight.Mystiasdelight;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import javax.annotation.Nullable;
import javax.sound.midi.Receiver;

public class BarbecuenetRecipe implements Recipe<RecipeWrapper> {
    public static final int INPUT_SLOTS = 7;
    private final String group;
    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;
    private final int cookTime;

    public BarbecuenetRecipe(ResourceLocation id,String group, ItemStack output,
                                   NonNullList<Ingredient> recipeItems, int cookTime) {
        this.id = id;
        this.group = group;
        this.output = output;
        this.recipeItems = recipeItems;
        this.cookTime = cookTime;
    }

    @Override
    public boolean matches(RecipeWrapper inv, Level worldIn) {
        java.util.List<ItemStack> inputs = new java.util.ArrayList<>();
        int i = 0;

        for (int j = 0; j < INPUT_SLOTS; ++j) {
            ItemStack itemstack = inv.getItem(j);
            if (!itemstack.isEmpty()) {
                ++i;
                inputs.add(itemstack);
            }
        }
        return i == this.recipeItems.size() && net.minecraftforge.common.util.RecipeMatcher.findMatches(inputs, this.recipeItems) != null;
    }

    @Override
    public ItemStack assemble(RecipeWrapper inv) {
        return this.output.copy();
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.recipeItems;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return this.output;
    }

    @Override
    public String getGroup() {
        return this.group;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public int getCookTime() {
        return this.cookTime;
    }



    public static class Type implements RecipeType<BarbecuenetRecipe>{
        private Type(){}
        public static final Type INSTANCE = new Type();
        public static final String ID = "barbecue";
    }

    public static class Serializer implements RecipeSerializer<BarbecuenetRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Mystiasdelight.MOD_ID,"barbecue");

        //@Override
        //public BarbecuenetRecipe fromJson(ResourceLocation id, JsonObject json) {
        //    ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output"));
//
        //    JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
        //    NonNullList<Ingredient> inputs = NonNullList.withSize(6, Ingredient.EMPTY);
//
        //    for (int i = 0; i < inputs.size(); i++) {
        //       inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
        //    }

         //   return new BarbecuenetRecipe(id, output, inputs);
        //}

        //@Override
        //public BarbecuenetRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
        //    NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readVarInt(), Ingredient.EMPTY);
//
        //    for (int i = 0; i < inputs.size(); i++) {
        //        inputs.set(i, Ingredient.fromNetwork(buf));
        //    }

        //    ItemStack output = buf.readItem();
        //    return new BarbecuenetRecipe(id, output, inputs);
        //}

        //@Override
        //public void toNetwork(FriendlyByteBuf buf, BarbecuenetRecipe recipe) {
        //    buf.writeInt(recipe.getIngredients().size());
        //   for (Ingredient ing : recipe.getIngredients()) {
        //        ing.toNetwork(buf);
        //    }
        //    buf.writeItemStack(recipe.getResultItem(), false);
        //}

        @Override
        public BarbecuenetRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            final String groupIn = GsonHelper.getAsString(json, "group", "");
            final NonNullList<Ingredient> inputItemsIn = readIngredients(GsonHelper.getAsJsonArray(json, "ingredients"));
            if (inputItemsIn.isEmpty()) {
                throw new JsonParseException("No ingredients for cooking recipe");
            } else if (inputItemsIn.size() > BarbecuenetRecipe.INPUT_SLOTS) {
                throw new JsonParseException("Too many ingredients for cooking recipe! The max is " + BarbecuenetRecipe.INPUT_SLOTS);
            } else {
                final int cookTimeIn = GsonHelper.getAsInt(json, "cookingtime", 200);
                final ItemStack outputIn = CraftingHelper.getItemStack(GsonHelper.getAsJsonObject(json, "output"), true);
                return new BarbecuenetRecipe(recipeId,groupIn,outputIn, inputItemsIn,cookTimeIn);
            }
        }

        private static NonNullList<Ingredient> readIngredients(JsonArray ingredientArray) {
            NonNullList<Ingredient> nonnulllist = NonNullList.create();

            for (int i = 0; i < ingredientArray.size(); ++i) {
                Ingredient ingredient = Ingredient.fromJson(ingredientArray.get(i));
                if (!ingredient.isEmpty()) {
                    nonnulllist.add(ingredient);
                }
            }

            return nonnulllist;
        }

        @Nullable
        @Override
        public BarbecuenetRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            String groupIn = buffer.readUtf(32767);
            int i = buffer.readVarInt();
            NonNullList<Ingredient> inputItemsIn = NonNullList.withSize(i, Ingredient.EMPTY);

            for (int j = 0; j < inputItemsIn.size(); ++j) {
                inputItemsIn.set(j, Ingredient.fromNetwork(buffer));
            }

            ItemStack outputIn = buffer.readItem();
            int cookTimeIn = buffer.readVarInt();
            return new BarbecuenetRecipe(recipeId,groupIn,outputIn, inputItemsIn,cookTimeIn);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, BarbecuenetRecipe recipe) {
            buffer.writeUtf(recipe.group);
            buffer.writeVarInt(recipe.recipeItems.size());

            for (Ingredient ingredient : recipe.recipeItems) {
                ingredient.toNetwork(buffer);
            }

            buffer.writeItem(recipe.output);
            buffer.writeVarInt(recipe.cookTime);
        }


    }


}
