package com.thevortex.allthemodium.items.toolitems.armor.models;// Made with Blockbench 4.0.0-beta.0
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;

public class unobtainium_helmet<T extends LivingEntity> extends HumanoidModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Reference.MOD_ID, "unobtainium_armor"), "main");
	protected final EquipmentSlot slot;

	public unobtainium_helmet(ModelPart root, EquipmentSlot slot) {
		super(root);
		this.slot = slot;
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Helmet = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.5F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(2, 3).addBox(-1.0F, -9.0F, -5.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.1F))
				.texOffs(56, 4).addBox(4.0F, -9.0F, -3.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(60, 4).addBox(4.0F, -9.0F, 1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(36, 4).addBox(-5.0F, -9.0F, -3.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(32, 4).addBox(-5.0F, -9.0F, 1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(24, 4).addBox(-3.0F, -9.0F, 4.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(24, 4).addBox(2.0F, -9.0F, 4.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
		partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.ZERO);
		partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.ZERO);
		partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.ZERO);
		partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.ZERO);
		return LayerDefinition.create(meshdefinition, 64, 32);
	}



	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		setPartVisibility(slot);
		super.renderToBuffer(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}
	private void setPartVisibility(EquipmentSlot slot) {
		setAllVisible(false);
		switch (slot) {
			case HEAD:
				head.visible = true;
				hat.visible = true;
				break;
			case CHEST:
				body.visible = true;
				rightArm.visible = true;
				leftArm.visible = true;
				break;
			case LEGS:
				body.visible = true;
				rightLeg.visible = true;
				leftLeg.visible = true;
				break;
			case FEET:
				rightLeg.visible = true;
				leftLeg.visible = true;
		}
	}
}