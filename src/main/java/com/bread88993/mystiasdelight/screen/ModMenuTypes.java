package com.bread88993.mystiasdelight.screen;

import com.bread88993.mystiasdelight.Mystiasdelight;
import com.bread88993.mystiasdelight.block.custom.Steamer;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, Mystiasdelight.MOD_ID);

    public static final RegistryObject<MenuType<BarbecuenetMenu>> BARBECUENET_MENU=
            registerMenuType(BarbecuenetMenu::new,"barbecuenet_menu");

    public static final RegistryObject<MenuType<PressurecookerMenu>> PRESSURECOOKER_MENU=
            registerMenuType(PressurecookerMenu::new,"pressurecooker_menu");

    public static final RegistryObject<MenuType<SteamerMenu>> STEAMER_MENU=
            registerMenuType(SteamerMenu::new,"steamer_menu");

    public static final RegistryObject<MenuType<WokMenu>> WOK_MENU=
            registerMenuType(WokMenu::new,"wok_menu");

    public static final RegistryObject<MenuType<CookingtableMenu>> COOKINGTABLE_MENU=
            registerMenuType(CookingtableMenu::new,"cookingtable_menu");



    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T>factory,
                                                                                                 String name){
        return MENUS.register(name,()-> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus){
        MENUS.register(eventBus);
    }
}
