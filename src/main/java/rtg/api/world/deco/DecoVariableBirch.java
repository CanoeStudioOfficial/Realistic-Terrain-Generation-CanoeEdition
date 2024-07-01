package rtg.api.world.deco;

import rtg.api.world.gen.feature.tree.rtg.TreeRTGBetulaNigra;
import rtg.api.world.gen.feature.tree.rtg.TreeRTGBetulaPapyrifera;
import rtg.api.world.gen.feature.tree.rtg.TreeRTGBetulaPendula;
import rtg.api.world.gen.feature.tree.rtg.TreeRTGBetulaPopulifolia;
import rtg.api.world.gen.feature.tree.rtg.TreeRTGBetulaUtilis;
import rtg.api.world.gen.feature.tree.rtg.TreeRTGCupressusSempervirens;

public class DecoVariableBirch extends DecoVariableTree {
	
	public DecoVariableBirch() {
		tallTree = new TreeRTGBetulaPendula();
		mediumTree = new TreeRTGBetulaNigra();
		smallTree = new TreeRTGBetulaUtilis();
		this.materials = this.materialsPicker.birch;
		this.averageHeightSqrt += 0f;
	}

}
