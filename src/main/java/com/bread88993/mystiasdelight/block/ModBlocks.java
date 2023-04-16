package com.bread88993.mystiasdelight.block;

import com.bread88993.mystiasdelight.Mystiasdelight;
import com.bread88993.mystiasdelight.block.custom.*;
import com.bread88993.mystiasdelight.item.ModCreativeModeTab;
import com.bread88993.mystiasdelight.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Mystiasdelight.MOD_ID);

    //加入物品
    public static final RegistryObject<Block> BARBECUENET = registerBlock("barbecuenet",
            () -> new Barbecuenet(BlockBehaviour.Properties.of(Material.METAL).strength(3.0F,4.0F).sound(SoundType.LANTERN)//.noCollission()
                    ),
            ModCreativeModeTab.Mystiasdelight_TAB_BLOCK);

    public static final RegistryObject<Block> PRESSURECOOKER = registerBlock("pressurecooker",
            () -> new Pressurecooker(BlockBehaviour.Properties.of(Material.METAL).strength(3.0F,4.0F).sound(SoundType.LANTERN)//.noCollission()
            ),
            ModCreativeModeTab.Mystiasdelight_TAB_BLOCK);

    public static final RegistryObject<Block> STEAMER = registerBlock("steamer",
            () -> new Steamer(BlockBehaviour.Properties.of(Material.METAL).strength(3.0F,4.0F).sound(SoundType.LANTERN)//.noCollission()
            ),
            ModCreativeModeTab.Mystiasdelight_TAB_BLOCK);

    public static final RegistryObject<Block> WOK = registerBlock("wok",
            () -> new Wok(BlockBehaviour.Properties.of(Material.METAL).strength(3.0F,4.0F).sound(SoundType.LANTERN)//.noCollission()
            ),
            ModCreativeModeTab.Mystiasdelight_TAB_BLOCK);

    public static final RegistryObject<Block> COOKINGTABLE = registerBlock("cookingtable",
            () -> new Cookingtable(BlockBehaviour.Properties.of(Material.WOOD).strength(1.5F,2.0F).sound(SoundType.WOOD)//.noCollission()
            ),
            ModCreativeModeTab.Mystiasdelight_TAB_BLOCK);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                           CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
