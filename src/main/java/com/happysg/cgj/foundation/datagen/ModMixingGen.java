package com.happysg.cgj.foundation.datagen;

import com.happysg.cgj.CreateGearsJets;
import com.happysg.cgj.content.registry.AllFluids;
import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import com.simibubi.create.foundation.data.recipe.ProcessingRecipeGen;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import net.minecraft.data.DataGenerator;

public class ModMixingGen extends ProcessingRecipeGen {
    GeneratedRecipe



    KEROSENE = create(CreateGearsJets.asResource("kerosene_mixing"), b -> b
            .require(AllFluids.OIL.get(), 100)
            .requiresHeat(HeatCondition.SUPERHEATED)
            .output(AllFluids.KEROSENE.get(),1000)
    );

    public ModMixingGen(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected IRecipeTypeInfo getRecipeType() {
        return AllRecipeTypes.MIXING;
    }
}
