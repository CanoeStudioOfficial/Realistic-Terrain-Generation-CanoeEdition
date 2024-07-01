package rtg.world.biome.realistic.environs;

import net.minecraft.world.biome.Biome;
import rtg.api.world.RTGWorld;
import rtg.api.world.terrain.TerrainBase;
import rtg.world.biome.realistic.biomesoplenty.RealisticBiomeBOPOvergrownCliffs;


public class RealisticBiomeENVEmeraldCliffs extends RealisticBiomeENVBase {

    public RealisticBiomeENVEmeraldCliffs(Biome biome) {
        super(biome);
    }

    @Override
    public void initConfig() {

    }

    @Override
    public TerrainBase initTerrain() {

        return new RealisticBiomeBOPOvergrownCliffs.TerrainBOPOvergrownCliffs(300f, 100f, 0f);
    }

}
