package uk.co.hexeption.rpower.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import uk.co.hexeption.rpower.Rpower;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Rpower.MODID)
public final class DataGenerators {

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        // Tags
        RPBlockTagsProvider blockTagsProvider = new RPBlockTagsProvider(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeClient(), blockTagsProvider);

        event.getGenerator().addProvider(event.includeServer(), new RPItemTagsProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));

        // Models
        generator.addProvider(event.includeClient(), new RPItemModelProvider(packOutput, existingFileHelper));

        // Recipes
        generator.addProvider(event.includeServer(), new RPRecipeProvider(packOutput, lookupProvider));
    }

}
