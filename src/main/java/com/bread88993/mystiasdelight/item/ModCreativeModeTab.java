package com.bread88993.mystiasdelight.item;

import com.bread88993.mystiasdelight.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModCreativeModeTab {
    public static final CreativeModeTab Mystiasdelight_TAB = new CreativeModeTab("mystiasdelighttab_material") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.EEL.get());
        }
    };

    public static final CreativeModeTab Mystiasdelight_TAB_BLOCK = new CreativeModeTab("mystiasdelighttab_block") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.PRESSURECOOKER.get());
        }
    };

    public static final CreativeModeTab Mystiasdelight_TAB_CUISINE = new CreativeModeTab("mystiasdelighttab_cuisine") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.WILDSALAD.get());
        }
    };

    public static final CreativeModeTab Mystiasdelight_TAB_MISCELLANEOUS = new CreativeModeTab("mystiasdelighttab_miscellaneous") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.BOOK);
        }
    };
}
