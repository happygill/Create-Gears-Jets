package com.happysg.cgj.content.registry;

import com.happysg.cgj.content.block.landinggear.LandingGearBlockEntity;
import com.happysg.cgj.content.block.landinggear.LandingGearInstance;
import com.happysg.cgj.content.block.landinggear.LandingGearRenderer;
import com.simibubi.create.foundation.blockEntity.renderer.SmartBlockEntityRenderer;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

import static com.happysg.cgj.CreateGearsJets.REGISTRATE;

public class AllBlockEntities {
    public static void init(){}


    public static final BlockEntityEntry<LandingGearBlockEntity> LANDING_GEAR = REGISTRATE
            .blockEntity("landing_gear", LandingGearBlockEntity::new)
            .instance(() -> LandingGearInstance::new)
            .renderer(() -> LandingGearRenderer::new)
            .validBlocks(AllBlocks.LANDING_GEAR)
            .register();
}
