package com.asaru.tutorialmod.mixin;
/*
import com.asaru.tutorialmod.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.util.Hand;

@Mixin(PlayerRenderer.class)
public class PlayerEntityRendererMixin {
    @Inject(
            method = "getArmPose",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void getArmPose(AbstractClientPlayerEntity player, Hand hand, CallbackInfoReturnable<PlayerModel.ArmPose> ci) {

        if (!player.swinging && player.getItemInHand(hand).getItem() instanceof ModItems.SMARTPHONE)
            ci.setReturnValue(PlayerModel.ArmPose.CROSSBOW_HOLD);
    }
}
*/
