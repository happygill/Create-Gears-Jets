package com.happysg.cgj.content.block.landinggear;

import com.happysg.cgj.content.registry.AllPartialModels;
import com.jozufozu.flywheel.api.MaterialManager;
import com.jozufozu.flywheel.backend.instancing.blockentity.BlockEntityInstance;
import com.jozufozu.flywheel.core.materials.oriented.OrientedData;

public class LandingGearInstance extends BlockEntityInstance<LandingGearBlockEntity> {

    private final OrientedData wheel1;
    private final OrientedData wheel2;
    private final OrientedData wheel3;
    private final OrientedData wheel4;
    private final OrientedData axle;

    public LandingGearInstance(MaterialManager materialManager, LandingGearBlockEntity blockEntity) {
        super(materialManager, blockEntity);
        wheel1 = getOrientedMaterial().getModel(AllPartialModels.LANDING_GEAR_WHEEL, blockState).createInstance();
        wheel2 = getOrientedMaterial().getModel(AllPartialModels.LANDING_GEAR_WHEEL, blockState).createInstance();
        wheel3 = getOrientedMaterial().getModel(AllPartialModels.LANDING_GEAR_WHEEL, blockState).createInstance();
        wheel4 = getOrientedMaterial().getModel(AllPartialModels.LANDING_GEAR_WHEEL, blockState).createInstance();
        axle = getOrientedMaterial().getModel(AllPartialModels.LANDING_GEAR_AXLE, blockState).createInstance();


        wheel1.setPosition(getInstancePosition());
        wheel1.nudge(.5f, 0, 1f);
        wheel2.setPosition(getInstancePosition());
        wheel2.nudge(.5f, 0, -1f);

        wheel3.setPosition(getInstancePosition());
        wheel3.nudge(-.5f, 0, 1f);
        wheel4.setPosition(getInstancePosition());
        wheel4.nudge(-.5f, 0, -1f);

        axle.setPosition(getInstancePosition());
        axle.nudge(0, .5f, 0);
    }

    @Override
    public void updateLight() {
        super.updateLight();
        relight(pos, wheel1);
        relight(pos, wheel2);
        relight(pos, wheel3);
        relight(pos, wheel4);
        relight(pos, axle);

    }
    @Override
    protected void remove() {
        wheel1.delete();
        wheel2.delete();
        wheel3.delete();
        wheel4.delete();
        axle.delete();
    }
}
