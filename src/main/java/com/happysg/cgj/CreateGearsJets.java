package com.happysg.cgj;

import com.happysg.cgj.content.registry.*;
import com.happysg.cgj.foundation.datagen.ModMixingGen;
import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CreateGearsJets.MODID)
public class CreateGearsJets {

    public static final String MODID = "create_gear_jet";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(CreateGearsJets.MODID)
            .creativeModeTab(() -> ModCreativeTab.BASE);

    public CreateGearsJets() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        REGISTRATE.registerEventListeners(modEventBus);
        AllItems.init();
        AllBlocks.init();
        AllFluids.init();
        AllBlockEntities.init();
        AllPartialModels.init();
        ModCreativeTab.init();

        modEventBus.addListener(EventPriority.LOWEST, CreateGearsJets::gatherData);

    }


    public static String toHumanReadable(String key) {
        String s = key.replaceAll("_", " ");
        s = Arrays.stream(StringUtils.splitByCharacterTypeCamelCase(s)).map(StringUtils::capitalize).collect(Collectors.joining(" "));
        s = StringUtils.normalizeSpace(s);
        return s;
    }
    public static ResourceLocation asResource(String name) {
        return new ResourceLocation(MODID, name);
    }

    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();

        if (event.includeServer()) {
            gen.addProvider(true, new ModMixingGen(gen));
        }

    }
}
