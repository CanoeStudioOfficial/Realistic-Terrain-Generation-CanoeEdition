package rtg.world.biome.realistic.spookybiomes;

import net.minecraft.world.biome.Biome;
import rtg.api.world.terrain.TerrainBase;
import rtg.world.biome.realistic.biomesoplenty.RealisticBiomeBOPHighland;

public class RealisticBiomeSBSorbusForest extends RealisticBiomeSBBase {

	public RealisticBiomeSBSorbusForest(Biome baseBiome) {
		super(baseBiome);
	}
	
    @Override
    public void initConfig() {
        this.getConfig().addProperty(getConfig().BEACH_BIOME).set(this.baseBiomeId());
    }

	@Override
	public TerrainBase initTerrain() {
		return new RealisticBiomeBOPHighland.TerrainBOPHighland();
	}

}
