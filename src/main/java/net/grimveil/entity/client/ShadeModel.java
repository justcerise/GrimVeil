package net.grimveil.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.grimveil.GrimVeil;

public class ShadeModel extends EntityModel<ShadeRenderState> {
    public static final EntityModelLayer SHADE = new EntityModelLayer(Identifier.of(GrimVeil.MOD_ID, "shade"), "main");

    private final ModelPart Shade;
    private final ModelPart Torso;
    private final ModelPart Head;

    public ShadeModel(ModelPart root) {
        super(root);
        this.Shade = root.getChild("Shade");
        this.Torso = this.Shade.getChild("Torso");
        this.Head = this.Torso.getChild("Head");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData Shade = modelPartData.addChild("Shade", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 12.0F, 0.0F));

        ModelPartData Torso = Shade.addChild("Torso", ModelPartBuilder.create().uv(16, 16).cuboid(-4.0F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData Head = Torso.addChild("Head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -9.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
                .uv(32, 0).cuboid(-4.0F, -9.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.5F)), ModelTransform.pivot(0.0F, -11.0F, 0.0F));

        ModelPartData Left_Arm = Torso.addChild("Left_Arm", ModelPartBuilder.create().uv(32, 48).cuboid(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, -10.0F, 0.0F));

        ModelPartData Right_Arm = Torso.addChild("Right_Arm", ModelPartBuilder.create().uv(40, 16).cuboid(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, -10.0F, 0.0F));

        ModelPartData Left_Leg = Shade.addChild("Left_Leg", ModelPartBuilder.create().uv(16, 48).cuboid(-2.1F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 2.0F, 0.0F));

        ModelPartData Right_Leg = Shade.addChild("Right_Leg", ModelPartBuilder.create().uv(0, 16).cuboid(-1.9F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 2.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(ShadeRenderState state) {
        super.setAngles(state);
        this.setHeadAngles(state.yawDegrees, state.pitch);

        this.animateWalking(ShadeAnimations.ANIM_SHADE_WALK, state.limbFrequency, state.limbAmplitudeMultiplier, 2f, 2.5f);
        this.animate(state.idleAnimationState, ShadeAnimations.ANIM_SHADE_IDLE, state.age, 1f);
        this.animate(state.attackAnimationState, ShadeAnimations.ANIM_SHADE_ATTACK, state.age, 1f);
    }

    private void setHeadAngles(float headYaw, float headPitch){
        headYaw = MathHelper.clamp(headYaw, -30f, 30f);
        headPitch = MathHelper.clamp(headPitch, -25f, 45f);

        this.Head.yaw = headYaw * 0.017453292F;
        this.Head.pitch = headPitch * 0.017453292F;
    }
}
