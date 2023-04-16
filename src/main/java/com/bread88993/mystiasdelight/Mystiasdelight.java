package com.bread88993.mystiasdelight;

import com.bread88993.mystiasdelight.block.ModBlocks;
import com.bread88993.mystiasdelight.block.custom.Steamer;
import com.bread88993.mystiasdelight.block.custom.Wok;
import com.bread88993.mystiasdelight.block.entity.ModBlockEntities;
import com.bread88993.mystiasdelight.item.ModItems;
import com.bread88993.mystiasdelight.recipe.ModRecipes;
import com.bread88993.mystiasdelight.recipe.ModRecipesType;
import com.bread88993.mystiasdelight.screen.*;
import com.bread88993.mystiasdelight.sound.ModSounds;
import com.bread88993.mystiasdelight.villager.ModVillagers;
import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Mystiasdelight.MOD_ID)
public class Mystiasdelight
{
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "mystiasdelight";

    public Mystiasdelight()
    {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModVillagers.register(eventBus);
        ModSounds.register(eventBus);

        ModBlockEntities.BLOCK_ENTITIES.register(eventBus);
        ModMenuTypes.register(eventBus);

        ModRecipes.register(eventBus);
        ModRecipesType.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event){
        MenuScreens.register(ModMenuTypes.BARBECUENET_MENU.get(), BarbecuenetScreen::new);
        MenuScreens.register(ModMenuTypes.PRESSURECOOKER_MENU.get(), PressurecookerScreen::new);
        MenuScreens.register(ModMenuTypes.STEAMER_MENU.get(), SteamerScreen::new);
        MenuScreens.register(ModMenuTypes.WOK_MENU.get(), WokScreen::new);
        MenuScreens.register(ModMenuTypes.COOKINGTABLE_MENU.get(), CookingtableScreen::new);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT);
        event.enqueueWork(()->{
            ModVillagers.registerPOIs();
        });
    }

}
