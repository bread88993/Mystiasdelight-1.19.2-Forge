package com.bread88993.mystiasdelight.item;

import com.bread88993.mystiasdelight.Mystiasdelight;
import com.bread88993.mystiasdelight.block.ModBlocks;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.core.impl.DefaultLogEventFactory;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Mystiasdelight.MOD_ID);



    public static final RegistryObject<Item> SALT = ITEMS.register("salt",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.Mystiasdelight_TAB)));
    public static final RegistryObject<Item> CHICKENBLOOD = ITEMS.register("chicken_blood",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.Mystiasdelight_TAB)));
    public static final RegistryObject<Item> SALADSAUCE = ITEMS.register("salad_sauce",
            () -> new Item(new Item.Properties().food(Material.SALADSAUCE).tab(ModCreativeModeTab.Mystiasdelight_TAB)));
    public static final RegistryObject<Item> WAGYU = ITEMS.register("wagyu",
            () -> new Item(new Item.Properties().food(Material.WAGYU).tab(ModCreativeModeTab.Mystiasdelight_TAB)));
    public static final RegistryObject<Item> COOKEDWAGYU = ITEMS.register("cooked_wagyu",
            () -> new Item(new Item.Properties().food(Material.COOKEDWAGYU).tab(ModCreativeModeTab.Mystiasdelight_TAB)));
    public static final RegistryObject<Item> TOFU = ITEMS.register("tofu",
            () -> new Item(new Item.Properties().food(Material.TOFU).tab(ModCreativeModeTab.Mystiasdelight_TAB)));
    public static final RegistryObject<Item> EEL = ITEMS.register("eel",
            () -> new Item(new Item.Properties().food(Material.EEL).tab(ModCreativeModeTab.Mystiasdelight_TAB)));
    public static final RegistryObject<Item> CRAB = ITEMS.register("crab",
            () -> new Item(new Item.Properties().food(Material.CRAB).tab(ModCreativeModeTab.Mystiasdelight_TAB)));
    public static final RegistryObject<Item> SHRIMP = ITEMS.register("shrimp",
            () -> new Item(new Item.Properties().food(Material.SHRIMP).tab(ModCreativeModeTab.Mystiasdelight_TAB)));
    public static final RegistryObject<Item> OCTOPUS = ITEMS.register("octopus",
            () -> new Item(new Item.Properties().food(Material.OCTOPUS).tab(ModCreativeModeTab.Mystiasdelight_TAB)));
    public static final RegistryObject<Item> TUNA = ITEMS.register("tuna",
            () -> new Item(new Item.Properties().food(Material.TUNA).tab(ModCreativeModeTab.Mystiasdelight_TAB)));
    public static final RegistryObject<Item> PEACH = ITEMS.register("peach",
            () -> new Item(new Item.Properties().food(Material.PEACH).tab(ModCreativeModeTab.Mystiasdelight_TAB)));
    public static final RegistryObject<Item> CUCMBER = ITEMS.register("cucumber",
            () -> new Item(new Item.Properties().food(Material.CUCUMBER).tab(ModCreativeModeTab.Mystiasdelight_TAB)));
    public static final RegistryObject<Item> RADISH = ITEMS.register("radish",
            () -> new Item(new Item.Properties().food(Material.RADISH).tab(ModCreativeModeTab.Mystiasdelight_TAB)));
    public static final RegistryObject<Item> CHILIPEPPER = ITEMS.register("chilipepper",
            () -> new Item(new Item.Properties().food(Material.CHILIPEPPER).tab(ModCreativeModeTab.Mystiasdelight_TAB)));
    public static final RegistryObject<Item> SCALLION = ITEMS.register("scallion",
            () -> new Item(new Item.Properties().food(Material.SCALLION).tab(ModCreativeModeTab.Mystiasdelight_TAB)));
    public static final RegistryObject<Item> BUTTER = ITEMS.register("butter",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.Mystiasdelight_TAB)));
    public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese",
            () -> new Item(new Item.Properties().food(Material.CHEESE).tab(ModCreativeModeTab.Mystiasdelight_TAB)));
    public static final RegistryObject<Item> SWEETPOTATO = ITEMS.register("sweet_potato",
            () -> new Item(new Item.Properties().food(Material.SWEETPOTATO).tab(ModCreativeModeTab.Mystiasdelight_TAB)));
    public static final RegistryObject<Item> LEMON = ITEMS.register("lemon",
            () -> new Item(new Item.Properties().food(Material.LEMON).tab(ModCreativeModeTab.Mystiasdelight_TAB)));
    public static final RegistryObject<Item> TRUFFLE = ITEMS.register("truffle",
            () -> new Item(new Item.Properties().food(Material.TRUFFLE).tab(ModCreativeModeTab.Mystiasdelight_TAB)));
    public static final RegistryObject<Item> EVENINGPRIMROSE = ITEMS.register("evening_primrose",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.Mystiasdelight_TAB)));
    public static final RegistryObject<Item> DREAMMATERIAL = ITEMS.register("dream_material",
            () -> new Item(new Item.Properties().food(Material.DREAMMATERIAL).tab(ModCreativeModeTab.Mystiasdelight_TAB)));

    public static final RegistryObject<Item> WILDSALAD = ITEMS.register("wild_salad",
            () -> new ConsumableItem(new Item.Properties().stacksTo(16).food(Material.WILDSALAD).craftRemainder(Items.BOWL).tab(ModCreativeModeTab.Mystiasdelight_TAB_CUISINE)));
    public static final RegistryObject<Item> MINERSALAD = ITEMS.register("miner_salad",
            () -> new ConsumableItem(new Item.Properties().stacksTo(16).food(Material.MINERSALAD).craftRemainder(Items.BOWL).tab(ModCreativeModeTab.Mystiasdelight_TAB_CUISINE)));
    public static final RegistryObject<Item> MINERSALADP = ITEMS.register("miner_saladp",
            () -> new ConsumableItem(new Item.Properties().stacksTo(16).food(Material.MINERSALADP).craftRemainder(Items.BOWL).tab(ModCreativeModeTab.Mystiasdelight_TAB_CUISINE)));
    public static final RegistryObject<Item> MINERSANDWICH = ITEMS.register("miner_sandwich",
            () -> new Item(new Item.Properties().stacksTo(16).food(Material.MINERSANDWICH).tab(ModCreativeModeTab.Mystiasdelight_TAB_CUISINE)));
    public static final RegistryObject<Item> MINERSANDWICHP = ITEMS.register("miner_sandwichp",
            () -> new Item(new Item.Properties().stacksTo(16).food(Material.MINERSANDWICHP).tab(ModCreativeModeTab.Mystiasdelight_TAB_CUISINE)));
    public static final RegistryObject<Item> CUREDMEAT = ITEMS.register("cured_meat",
            () -> new Item(new Item.Properties().food(Material.CUREDMEAT).tab(ModCreativeModeTab.Mystiasdelight_TAB_CUISINE)));
    public static final RegistryObject<Item> HELLSAUSAGE = ITEMS.register("hell_sausage",
            () -> new Item(new Item.Properties().food(Material.HELLSAUSAGE).tab(ModCreativeModeTab.Mystiasdelight_TAB_CUISINE)));
    public static final RegistryObject<Item> MONSTERKEBABS = ITEMS.register("monster_kebabs",
            () -> new ConsumableItem(new Item.Properties().stacksTo(16).food(Material.MONSTERKEBABS).craftRemainder(Items.STICK).tab(ModCreativeModeTab.Mystiasdelight_TAB_CUISINE)));
    public static final RegistryObject<Item> KOIKNIFE = ITEMS.register("koishi_knife",
            () -> new KoiKnife());
    public static final RegistryObject<Item> CAVEHOTPOT = ITEMS.register("cave_hotpot",
            () -> new ConsumableItem(new Item.Properties().stacksTo(16).food(Material.CAVEHOTPOT).craftRemainder(Items.BUCKET).tab(ModCreativeModeTab.Mystiasdelight_TAB_CUISINE)));
    public static final RegistryObject<Item> FLESHKEBABS = ITEMS.register("flesh_kebabs",
            () -> new ConsumableItem(new Item.Properties().stacksTo(16).food(Material.FLESHKEBABS).craftRemainder(Items.STICK).tab(ModCreativeModeTab.Mystiasdelight_TAB_CUISINE)));
    public static final RegistryObject<Item> MAPOTOFU = ITEMS.register("mapo_tofu",
            () -> new ConsumableItem(new Item.Properties().stacksTo(16).food(Material.MAPOTOFU).craftRemainder(Items.BOWL).tab(ModCreativeModeTab.Mystiasdelight_TAB_CUISINE)));
    public static final RegistryObject<Item> APPLEICE = ITEMS.register("apple_ice",
            () -> new ConsumableItem(new Item.Properties().stacksTo(16).food(Material.APPLEICE).craftRemainder(Items.GLASS_BOTTLE).tab(ModCreativeModeTab.Mystiasdelight_TAB_CUISINE)));
    public static final RegistryObject<Item> OBSIDIANFANTASYDRINK = ITEMS.register("obsidian_fantasy_drink",
            () -> new DrinkableItem(new Item.Properties().stacksTo(16).food(Material.OBSIDIANFANTASYDRINK).craftRemainder(Items.GLASS_BOTTLE).tab(ModCreativeModeTab.Mystiasdelight_TAB_CUISINE)));
    public static final RegistryObject<Item> SMARTJELLIEDTOFU = ITEMS.register("smart_jellied_tofu",
            () -> new ConsumableItem(new Item.Properties().stacksTo(16).food(Material.SMARTJELLIEDTOFU).craftRemainder(Items.BOWL).tab(ModCreativeModeTab.Mystiasdelight_TAB_CUISINE)));
    public static final RegistryObject<Item> HONEYSTEAK = ITEMS.register("honey_steak",
            () -> new ConsumableItem(new Item.Properties().stacksTo(16).food(Material.HONEYSTEAK).craftRemainder(Items.BOWL).tab(ModCreativeModeTab.Mystiasdelight_TAB_CUISINE)));





    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
