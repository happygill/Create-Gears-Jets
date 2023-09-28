package com.happysg.cgj.content.registry;

import com.happysg.cgj.CreateGearsJets;
import com.jozufozu.flywheel.core.PartialModel;

public class AllPartialModels {
    private static PartialModel block(String path) {
        return new PartialModel(CreateGearsJets.asResource("block/" + path));
    }

    public static final PartialModel
            LANDING_GEAR_AXLE = block("landing_gear/landing_gear_axle"),
            LANDING_GEAR_WHEEL = block("landing_gear/landing_gear_wheel");


    public static void init() {}
}
