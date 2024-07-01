package rtg.world.biome.realistic.spookybiomes;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import rtg.api.world.terrain.TerrainBase;
import rtg.world.biome.realistic.biomesoplenty.RealisticBiomeBOPMountainPeaks;
import rtg.world.biome.realistic.biomesoplenty.RealisticBiomeBOPMountainPeaks.TerrainBOPMountainPeaks;

public class RealisticBiomeSBBloodiedHills extends RealisticBiomeSBBase {

	public RealisticBiomeSBBloodiedHills(Biome baseBiome) {
		super(baseBiome);
	}
	
    @Override
    public void initConfig() {
        this.getConfig().addProperty(getConfig().BEACH_BIOME).set(Biome.getIdForBiome(Biomes.STONE_BEACH));
    }

	@Override
	public TerrainBase initTerrain() {
		return new RealisticBiomeBOPMountainPeaks.TerrainBOPMountainPeaks(120f, 100f);
	}

}
