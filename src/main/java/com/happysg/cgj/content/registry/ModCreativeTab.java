package com.happysg.cgj.content.registry;

import com.happysg.cgj.CreateGearsJets;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collection;
import java.util.function.Supplier;

import static com.happysg.cgj.CreateGearsJets.REGISTRATE;
import static com.happysg.cgj.CreateGearsJets.toHumanReadable;

public class ModCreativeTab extends CreativeModeTab {
    private Supplier<ItemStack> icon;


    public static final CreativeModeTab BASE = new ModCreativeTab("base","Create: Gears & Jets")
            .withIcon(AllBlocks.LANDING_GEAR::asStack);

    public ModCreativeTab(String id,String name) {
        super(CreateGearsJets.MODID + '.' + id);
        REGISTRATE.addRawLang("itemGroup."+CreateGearsJets.MODID +"."+id,name);
    }


    public static void init() {}

    ModCreativeTab withIcon(Supplier<ItemStack> icon) {
        this.icon = icon;
        return this;
    }

    @Override
    public ItemStack makeIcon() {
        return icon.get();
    }

    @Override
    public void fillItemList(NonNullList<ItemStack> items) {
        addItems(items, true);
        addBlocks(items);
        addItems(items, false);
    }

    protected Collection<RegistryEntry<Item>> registeredItems() {
        return REGISTRATE.getAll(ForgeRegistries.ITEMS.getRegistryKey());
    }

    public void addBlocks(NonNullList<ItemStack> items) {
        for (RegistryEntry<Item> entry : registeredItems())
            if (entry.get() instanceof BlockItem blockItem)
                blockItem.fillItemCategory(this, items);
    }

    public void addItems(NonNullList<ItemStack> items, boolean specialItems) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

        for (RegistryEntry<Item> entry : registeredItems()) {
            Item item = entry.get();
            if (item instanceof BlockItem) {
                continue;
            }
            ItemStack stack = new ItemStack(item);
            BakedModel model = itemRenderer.getModel(stack, null, null, 0);
            if (model.isGui3d() == specialItems)
                item.fillItemCategory(this, items);
        }
    }
}
