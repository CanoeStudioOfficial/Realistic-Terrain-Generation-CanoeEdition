package rtg.world.biome.realistic.spookybiomes;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import rtg.api.world.terrain.TerrainBase;
import rtg.world.biome.realistic.vanilla.RealisticBiomeVanillaExtremeHills;

public class RealisticBiomeSBSeepingForest extends RealisticBiomeSBBase {

	public RealisticBiomeSBSeepingForest(Biome baseBiome) {
		super(baseBiome);
	}

    @Override
    public void initConfig() {
        this.getConfig().addProperty(getConfig().BEACH_BIOME).set(Biome.getIdForBiome(Biomes.BEACH));
    }

	@Override
	public TerrainBase initTerrain() {
		return new RealisticBiomeVanillaExtremeHills.RidgedExtremeHills(84f, 65f, 200f);
	}

}
