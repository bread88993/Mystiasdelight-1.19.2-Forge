package com.bread88993.mystiasdelight.block.entity.custom;

//I don't know how to write a shapeless recipe and block entity, so I cope the code from Vectorwing 's Pot :P
//Thank you, Vectorwing! You are my Savior!

import com.bread88993.mystiasdelight.Mystiasdelight;
import com.bread88993.mystiasdelight.block.entity.ModBlockEntities;
import com.bread88993.mystiasdelight.recipe.PressurecookerRecipe;
import com.bread88993.mystiasdelight.recipe.ModRecipesType;
import com.bread88993.mystiasdelight.screen.PressurecookerMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Nameable;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.block.entity.HeatableBlockEntity;
import vectorwing.farmersdelight.common.mixin.accessor.RecipeManagerAccessor;
import vectorwing.farmersdelight.common.registry.ModParticleTypes;
import vectorwing.farmersdelight.common.registry.ModSounds;
import vectorwing.farmersdelight.common.utility.TextUtils;

import javax.annotation.Nonnull;
import java.util.Optional;
import java.util.Random;

public class PressurecookerBlockEntity extends BlockEntity implements MenuProvider, HeatableBlockEntity, Nameable {

    private final ItemStackHandler itemHandler;


    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    private Component customName;

    protected final ContainerData data;
    private int cookTimeTotal;
    private int cookTime;
    private ResourceLocation lastRecipeID;
    private boolean checkNewRecipe;
    boolean didInventoryChange = false;



    public PressurecookerBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.PRESSURECOOKER_BLOCK_ENTITY.get(), pPos, pBlockState);
        this.itemHandler = createHandlerC();
        this.data = createIntArray();
        this.checkNewRecipe = true;
    }


    @Override
    @Nonnull
    public Component getName() {
        return customName != null ? customName : TextUtils.getTranslation("mystiasdelight.pressurecooker");
    }

    @Override
    @Nonnull
    public Component getDisplayName() {
        return getName();
    }


    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {

        return new PressurecookerMenu(pContainerId,pInventory,this,this.data);
    }


    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps()  {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("pressurecooker.cookTime",cookTime);
        tag.putInt("CookTimeTotal", cookTimeTotal);
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag compound) {
        super.load(compound);
        itemHandler.deserializeNBT(compound.getCompound("Inventory"));
        cookTime = compound.getInt("CookTime");
        cookTimeTotal = compound.getInt("CookTimeTotal");
        if (compound.contains("CustomName", 9)) {
            customName = Component.Serializer.fromJson(compound.getString("CustomName"));
        }
        CompoundTag compoundRecipes = compound.getCompound("RecipesUsed");
    }

    public ItemStackHandler getInventory() {
        return itemHandler;
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }


    private boolean hasInput() {
        for (int i = 0; i < 8; ++i) {
            if (!itemHandler.getStackInSlot(i).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static void cookingTick(Level level, BlockPos pos, BlockState state, PressurecookerBlockEntity pEntity) {
        boolean isHeated = pEntity.isHeated(level, pos);
        boolean didInventoryChange = false;

        if (isHeated && pEntity.hasInput()) {
            Optional<PressurecookerRecipe> recipe = pEntity.getMatchingRecipeC(new RecipeWrapper(pEntity.itemHandler));
            if (recipe.isPresent() && pEntity.canCookC(recipe.get())) {
                didInventoryChange = pEntity.processCookingC(recipe.get(),pEntity);
            } else {
                pEntity.cookTime = 0;
            }
        } else if (pEntity.cookTime > 0) {
            pEntity.cookTime = Mth.clamp(pEntity.cookTime - 2, 0, pEntity.cookTimeTotal);
        }
        if (didInventoryChange) {
            pEntity.inventoryChangedC();
        }
    }

    private Optional<PressurecookerRecipe> getMatchingRecipeC(RecipeWrapper inventoryWrapper) {
        if (level == null) {
            return Optional.empty();
        }

        if (lastRecipeID != null) {
            Recipe<RecipeWrapper> recipe = ((RecipeManagerAccessor) level.getRecipeManager())
                    .getRecipeMap(ModRecipesType.PRESSURE.get())
                    .get(lastRecipeID);
            if (recipe instanceof PressurecookerRecipe) {
                if (recipe.matches(inventoryWrapper, level)) {
                    return Optional.of((PressurecookerRecipe) recipe);
                }
            }
        }

        if (checkNewRecipe) {
            Optional<PressurecookerRecipe> recipe = level.getRecipeManager().getRecipeFor(ModRecipesType.PRESSURE.get(), inventoryWrapper, level);
            if (recipe.isPresent()) {
                lastRecipeID = recipe.get().getId();
                return recipe;
            }
        }

        checkNewRecipe = false;
        return Optional.empty();
    }

    private boolean processCookingC(PressurecookerRecipe recipe, PressurecookerBlockEntity entity) {
        if (level == null) {
            return false;
        }

        ++cookTime;
        cookTimeTotal = recipe.getCookTime();
        if (cookTime < cookTimeTotal) {
            return false;
        }
        entity.itemHandler.extractItem(0,1, false);
        entity.itemHandler.extractItem(1,1, false);
        entity.itemHandler.extractItem(2,1, false);
        entity.itemHandler.extractItem(3,1, false);
        entity.itemHandler.extractItem(4,1, false);
        entity.itemHandler.extractItem(5,1, false);
        entity.itemHandler.extractItem(6,1, false);
        cookTime = 0;
        ItemStack resultStack = recipe.getResultItem();
        ItemStack storedMealStack = itemHandler.getStackInSlot(7);
        if (storedMealStack.isEmpty()) {
            itemHandler.setStackInSlot(7, resultStack.copy());
        } else if (storedMealStack.sameItem(resultStack)) {
            storedMealStack.grow(resultStack.getCount());
        }

        return true;
    }


    protected boolean canCookC(PressurecookerRecipe recipe) {
        if (hasInput()) {
            ItemStack resultStack = recipe.getResultItem();
            if (resultStack.isEmpty()) {
                return false;
            } else {
                ItemStack storedMealStack = itemHandler.getStackInSlot(7);
                if (storedMealStack.isEmpty()) {
                    return true;
                } else if (!storedMealStack.sameItem(resultStack)) {
                    return false;
                } else if (storedMealStack.getCount() + resultStack.getCount() <= itemHandler.getSlotLimit(7)) {
                    return true;
                } else {
                    return storedMealStack.getCount() + resultStack.getCount() <= resultStack.getMaxStackSize();
                }
            }
        } else {
            return false;
        }
    }


    public boolean isHeated() {
        if (level == null) {
            return false;
        }
        return this.isHeated(level, worldPosition);
    }

    private ItemStackHandler createHandlerC() {
        return new ItemStackHandler(8)
        {
            @Override
            protected void onContentsChanged(int slot) {
                if (slot >= 0 && slot < 7) {
                    checkNewRecipe = true;
                }
                inventoryChangedC();
            }
        };
    }


    @Override
    @Nonnull
    public CompoundTag getUpdateTag() {
        return writeItems(new CompoundTag());
    }

    private CompoundTag writeItems(CompoundTag compound) {
        super.saveAdditional(compound);
        compound.put("Inventory", itemHandler.serializeNBT());
        return compound;
    }
    @Override
    @Nonnull
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            if(side == null){
                return lazyItemHandler.cast();
            }
        }

        return super.getCapability(cap, side);
    }
    private ContainerData createIntArray() {
        return new ContainerData()
        {
            @Override
            public int get(int index) {
                switch (index) {
                    case 0:
                        return PressurecookerBlockEntity.this.cookTime;
                    case 1:
                        return PressurecookerBlockEntity.this.cookTimeTotal;
                    default:
                        return 0;
                }
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0:
                        PressurecookerBlockEntity.this.cookTime = value;
                        break;
                    case 1:
                        PressurecookerBlockEntity.this.cookTimeTotal = value;
                        break;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }
    protected void inventoryChangedC() {
        super.setChanged();
        if (level != null) {
            level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), Block.UPDATE_CLIENTS);
        }
    }

    public static void animateTick(Level world, BlockPos pos, BlockState blockstate, PressurecookerBlockEntity press) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        if (press.isHeated(world,pos)) {
            RandomSource random = world.random;
            for (int l = 0; l < 2; ++l) {
                double x0 = x + 0.5 + (random.nextFloat() - 0.5) * 0.5D;
                double y0 = y + 0.2 + (random.nextFloat() - 0.5) * 3D;
                double z0 = z + 0.5 + (random.nextFloat() - 0.5) * 0.5D;
                world.addParticle(ModParticleTypes.STEAM.get(), x0, y0, z0, 0, 0, 0);


            }
            if (random.nextInt(10) == 0) {
                world.playLocalSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, ModSounds.BLOCK_COOKING_POT_BOIL.get(), SoundSource.BLOCKS, 0.5F, random.nextFloat() * 0.4F + 0.8F, false);
            }
            if (random.nextInt(25) == 0) {
                world.playLocalSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, com.bread88993.mystiasdelight.sound.ModSounds.COOKING_STEAMING.get(), SoundSource.BLOCKS, 0.5F, random.nextFloat() * 0.4F + 0.8F, false);
            }

        }
    }

}
