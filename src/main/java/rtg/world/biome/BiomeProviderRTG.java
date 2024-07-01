package rtg.world.biome;

import org.apache.logging.log4j.Level;

import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerRiverMix;
import rtg.api.RTGAPI;
import rtg.api.util.Logger;
import rtg.api.world.RTGWorld;
import rtg.api.world.gen.RTGChunkGenSettings;
import rtg.compat.ModCompat.Mods;


public class BiomeProviderRTG extends BiomeProvider {
  private final RTGWorld rtgWorld;
  private final RTGChunkGenSettings generatorSettings;

    public BiomeProviderRTG(RTGWorld rtgWorld) {

        super(rtgWorld.world().getWorldInfo());
        

      this.rtgWorld = rtgWorld; //new RTGWorld(world)
      this.generatorSettings = rtgWorld.getGeneratorSettings();
      // Access

      GenLayer[] agenlayer = GenLayer.initializeAllBiomeGenerators(rtgWorld.seed(), rtgWorld.world().getWorldType(), ChunkGeneratorSettings.Factory.jsonToFactory(rtgWorld.world().getWorldInfo().getGeneratorOptions()).build());
      
      this.genBiomes = agenlayer[0]; //maybe this will be needed
      this.biomeIndexLayer = agenlayer[1];
      
      maybeRemoveRivers();
      
      agenlayer = getModdedBiomeGenerators(rtgWorld.world().getWorldType(), rtgWorld.seed(), agenlayer);
      
      this.genBiomes = agenlayer[0]; //maybe this will be needed
      this.biomeIndexLayer = agenlayer[1];
    }

    private void maybeRemoveRivers() {
        /*
         * If the river layer is an instance of GenLayerRiverRTG (ie: no mods have altered the GenLayers from WorldTypeEvent$InitBiomeGens)
         * then leave the layers alone since it will handle rivers, otherwise the layers have been altered by another mod, so we need to remove the river layer.
         */
    	if (Mods.geographicraft.isLoaded()) return;// Geographicraft has *always* removed vanilla rivers for RTG.
        GenLayer layer = this.genBiomes;
        boolean fixed = false;
        while (layer != null) {
            Logger.warn("Trying layer with name: {}", layer.getClass().getName());
            if (layer instanceof GenLayerRiverMix) {
                // Overwrite the river layer with the biome layer to kill vanilla rivers.
                Logger.debug("Removing vanilla river layer");
                ((GenLayerRiverMix)layer).riverPatternGeneratorChain = ((GenLayerRiverMix)layer).biomePatternGeneratorChain;
                fixed = true;
                break;
            } 
            layer = layer.parent;
        }
        if (!fixed) {
            Logger.error("Failed to remove the vanilla river layer; Wrong GenLayer type: {}", genBiomes.getClass().getName());
        }
    }

}
