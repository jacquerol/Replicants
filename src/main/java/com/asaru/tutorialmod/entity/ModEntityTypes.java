package com.asaru.tutorialmod.entity;

import com.asaru.tutorialmod.TutorialMod;
import com.asaru.tutorialmod.entity.custom.AndroidEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, TutorialMod.MOD_ID);

    public static final RegistryObject<EntityType<AndroidEntity>> ANDROID =
            ENTITY_TYPES.register("android", () -> EntityType.Builder.of(AndroidEntity::new, EntityClassification.CREATURE)
                    .build(new ResourceLocation(TutorialMod.MOD_ID, "android").toString()));
    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
