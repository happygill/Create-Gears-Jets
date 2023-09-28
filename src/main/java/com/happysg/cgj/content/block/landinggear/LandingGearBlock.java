package com.happysg.cgj.content.block.landinggear;

import com.happysg.cgj.content.registry.AllBlockEntities;
import com.simibubi.create.foundation.block.IBE;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class LandingGearBlock extends Block implements IBE<LandingGearBlockEntity> {
    public LandingGearBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public Class<LandingGearBlockEntity> getBlockEntityClass() {
        return LandingGearBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends LandingGearBlockEntity> getBlockEntityType() {
        return AllBlockEntities.LANDING_GEAR.get();
    }
}
