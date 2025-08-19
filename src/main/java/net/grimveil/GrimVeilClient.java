package net.grimveil;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.grimveil.block.ModBlocks;
import net.grimveil.entity.ModEntities;
import net.grimveil.entity.client.ShadeModel;
import net.grimveil.entity.client.ShadeRenderer;
import net.grimveil.item.ModItems;
import net.minecraft.client.render.RenderLayer;

public class GrimVeilClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BYSMAL_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BYSMAL_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BYSMAL_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BYSMAL_SHORT_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BYSMAL_LONG_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BYSMAL_LEAVES, RenderLayer.getCutout());
        TerraformBoatClientHelper.registerModelLayers(ModItems.BYSMAL);

        EntityModelLayerRegistry.registerModelLayer(ShadeModel.SHADE, ShadeModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.SHADE, ShadeRenderer::new);
    }
}
