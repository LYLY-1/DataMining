package khaiThacLuatKetHop;

import weka.associations.FPGrowth;

public class FPGrowthModel extends PreProcessing{
	FPGrowth fpGrowth;
	public FPGrowthModel() {
		// TODO Auto-generated constructor stub
	}
	public FPGrowthModel(String fileName) throws Exception {
		super.dataSet = super.load_data(fileName);
		fpGrowth = new FPGrowth();
	}
	
	@Override
	public void mineRules(String modelOpt) throws Exception {
		// TODO Auto-generated method stub
		super.modelOption = weka.core.Utils.splitOptions(modelOpt);
		fpGrowth.setOptions(super.modelOption);
		fpGrowth.buildAssociations(super.dataSet);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return fpGrowth.toString();
	}
}
