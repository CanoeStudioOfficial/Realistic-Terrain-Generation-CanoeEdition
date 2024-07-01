package rtg.world.biome.realistic.environs;

import net.minecraft.world.biome.Biome;
import rtg.api.world.RTGWorld;
import rtg.api.world.terrain.TerrainBase;
import rtg.api.world.terrain.heighteffect.BumpyHillsEffect;
import rtg.api.world.terrain.heighteffect.JitterEffect;
import rtg.world.biome.realistic.biomesoplenty.RealisticBiomeBOPOvergrownCliffs;


public class RealisticBiomeENVExtremeJungle extends RealisticBiomeENVBase {

    public RealisticBiomeENVExtremeJungle(Biome biome) {
        super(biome);
    }

    @Override
    public void initConfig() {

    }

    @Override
    public TerrainBase initTerrain() {
        return new RealisticBiomeBOPOvergrownCliffs.TerrainBOPOvergrownCliffs(300f, 90f, 0f);
    }

}
