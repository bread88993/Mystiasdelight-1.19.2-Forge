package com.bread88993.mystiasdelight.block.entity;

import com.bread88993.mystiasdelight.Mystiasdelight;
import com.bread88993.mystiasdelight.block.custom.Pressurecooker;
import com.bread88993.mystiasdelight.block.custom.Steamer;
import com.bread88993.mystiasdelight.block.entity.custom.*;
import com.bread88993.mystiasdelight.Mystiasdelight;
import com.bread88993.mystiasdelight.block.ModBlocks;
import com.bread88993.mystiasdelight.block.entity.custom.BarbecuenetBlockEntity;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Mystiasdelight.MOD_ID);

    public static final RegistryObject<BlockEntityType<BarbecuenetBlockEntity>> BARBECUENET_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("barbecuenet_block_entity", () ->
                    BlockEntityType.Builder.of(BarbecuenetBlockEntity::new,
                                ModBlocks.BARBECUENET.get()).build(null));

    public static final RegistryObject<BlockEntityType<PressurecookerBlockEntity>> PRESSURECOOKER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("pressurecooker_block_entity", () ->
                    BlockEntityType.Builder.of(PressurecookerBlockEntity::new,
                            ModBlocks.PRESSURECOOKER.get()).build(null));

    public static final RegistryObject<BlockEntityType<SteamerBlockEntity>> STEAMER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("steamer_block_entity", () ->
                    BlockEntityType.Builder.of(SteamerBlockEntity::new,
                            ModBlocks.STEAMER.get()).build(null));

    public static final RegistryObject<BlockEntityType<WokBlockEntity>> WOK_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("wok_block_entity", () ->
                    BlockEntityType.Builder.of(WokBlockEntity::new,
                            ModBlocks.WOK.get()).build(null));

    public static final RegistryObject<BlockEntityType<CookingtableBlockEntity>> COOKINGTABLE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("cookingtable_block_entity", () ->
                    BlockEntityType.Builder.of(CookingtableBlockEntity::new,
                            ModBlocks.COOKINGTABLE.get()).build(null));

    //public static void register(IEventBus eventBus) {
    //    BLOCK_ENTITIES.register(eventBus);
    //}
}
