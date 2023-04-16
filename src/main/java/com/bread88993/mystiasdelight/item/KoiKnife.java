package com.bread88993.mystiasdelight.item;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

public class KoiKnife extends SwordItem {
    public KoiKnife() {
        super(new Tier() {
                  @Override
                  public int getUses() {
                      return 5140;
                  }

                  @Override
                  public float getSpeed() {
                      return 2f;
                  }

                  @Override
                  public float getAttackDamageBonus() {
                      return 4f;
                  }

                  @Override
                  public int getLevel() {
                      return 1;
                  }

                  @Override
                  public int getEnchantmentValue() {
                      return 2;
                  }

                  @Override
                  public Ingredient getRepairIngredient() {
                      return Ingredient.of(new ItemStack(ModItems.KOIKNIFE.get()), new ItemStack(ModItems.KOIKNIFE.get()));
                  }
              },

                9, -2.4f,

                new Item.Properties().tab(ModCreativeModeTab.Mystiasdelight_TAB_MISCELLANEOUS));
    }


    @Override
    public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(itemstack, world, entity, slot, selected);
        if (selected) {
            com.bread88993.mystiasdelight.item.custom.KoiKnife.execute(entity);
        }
    }
}


