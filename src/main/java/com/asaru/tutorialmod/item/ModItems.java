package com.asaru.tutorialmod.item;


import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFrameItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.client.renderer.entity.model.BipedModel.ArmPose;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import com.asaru.tutorialmod.TutorialMod;
import org.lwjgl.system.CallbackI;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);
    public static final RegistryObject<Item> TEST = ITEMS.register("amathyst",
            () -> new Item(new Item.Properties().stacksTo(1).tab(ModItemGroup.TUTORIAL_GROUP)));
    public static final RegistryObject<Item> PERFBOARD = ITEMS.register("perfboard",
            () -> new Item(new Item.Properties().stacksTo(1).tab(ModItemGroup.TUTORIAL_GROUP)));
    /*
    public static final RegistryObject<Item> SMARTPHONE = ITEMS.register("smartphone",
            () -> new Item(new Item.Properties().stacksTo(1).tab(ModItemGroup.TUTORIAL_GROUP)));
           */

    public static final RegistryObject<Item> SMARTPHONE = ITEMS.register("smartphone",
            () -> new Item(new Item.Properties().stacksTo(1).tab(ModItemGroup.TUTORIAL_GROUP)));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);

    }

}
