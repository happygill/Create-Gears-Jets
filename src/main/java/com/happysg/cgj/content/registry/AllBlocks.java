package com.happysg.cgj.content.registry;

import com.happysg.cgj.content.block.landinggear.LandingGearBlock;
import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static com.happysg.cgj.CreateGearsJets.REGISTRATE;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;

public class AllBlocks {
    public static void init(){}


    public static final BlockEntry<LandingGearBlock> LANDING_GEAR = REGISTRATE
            .block("landing_gear", LandingGearBlock::new)
            .initialProperties(SharedProperties::softMetal)
            .properties(BlockBehaviour.Properties::noOcclusion)
            .transform(pickaxeOnly())
            .addLayer(() -> RenderType::cutoutMipped)
            .blockstate((c, p) -> p.simpleBlock(c.getEntry(), AssetLookup.partialBaseModel(c, p)))
            .item(BlockItem::new)
            .model(AssetLookup.customBlockItemModel("landing_gear", "landing_gear_wheel"))
            .build()
            .register();
}
