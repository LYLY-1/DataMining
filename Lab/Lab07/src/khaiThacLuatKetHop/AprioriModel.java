package khaiThacLuatKetHop;

import weka.associations.Apriori;


public class AprioriModel extends PreProcessing {
	Apriori apriori;
	
	public AprioriModel() {
		// TODO Auto-generated constructor stub
	}
	
	public AprioriModel(String fileName) throws Exception{
		super.dataSet = super.load_data(fileName);
		apriori = new Apriori();
	}

	@Override
	public void mineRules(String modelOpt) throws Exception {
		// TODO Auto-generated method stub
		super.modelOption = weka.core.Utils.splitOptions(modelOpt);
		apriori.setOptions(super.modelOption);
		apriori.buildAssociations(dataSet);
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return apriori.toString();
	}
}
