package net.grimveil.entity.client;

import com.google.common.collect.Maps;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.grimveil.GrimVeil;
import net.grimveil.entity.custom.ShadeEntity;
import net.grimveil.entity.custom.ShadeVariant;

import java.util.Map;

public class ShadeRenderer extends MobEntityRenderer<ShadeEntity, ShadeRenderState, ShadeModel> {
    public static final Map<ShadeVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(ShadeVariant.class), map -> {
                map.put(ShadeVariant.DEFAULT,
                        Identifier.of(GrimVeil.MOD_ID, "textures/entity/shade/shade.png"));
                map.put(ShadeVariant.CAVE,
                        Identifier.of(GrimVeil.MOD_ID, "textures/entity/shade/shade.png"));
            });

    public ShadeRenderer(EntityRendererFactory.Context context) {
        super(context, new ShadeModel(context.getPart(ShadeModel.SHADE)), 0.5f);
    }

    @Override
    public Identifier getTexture(ShadeRenderState state) {
        return LOCATION_BY_VARIANT.get(state.variant);
        //return Identifier.of(GrimVeil.MOD_ID, "textures/entity/shade/shade.png");
    }

    @Override
    public void render(ShadeRenderState state, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(1f, 1f, 1f);
        super.render(state, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public ShadeRenderState createRenderState() {
        return new ShadeRenderState();
    }

    @Override
    public void updateRenderState(ShadeEntity livingEntity, ShadeRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);
        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idleAnimationState);
        livingEntityRenderState.attackAnimationState.copyFrom(livingEntity.attackAnimationState);
        livingEntityRenderState.variant = livingEntity.getVariant();
    }
}
