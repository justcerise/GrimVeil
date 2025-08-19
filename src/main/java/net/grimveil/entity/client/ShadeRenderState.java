package net.grimveil.entity.client;

import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.AnimationState;
import net.grimveil.entity.custom.ShadeVariant;

public class ShadeRenderState extends LivingEntityRenderState {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState attackAnimationState = new AnimationState();
    //public final AnimationState screamAnimationState = new AnimationState();
    public ShadeVariant variant;
}
