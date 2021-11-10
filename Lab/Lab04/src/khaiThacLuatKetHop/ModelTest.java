package khaiThacLuatKetHop;


public class ModelTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		AprioriModel apriori = new AprioriModel("C:\\Program Files\\Weka-3-9\\data\\weather.arff");
//		apriori.convertNumericToNominal("-R first-last");
//		apriori.mineRules("-N 10 -T 0 -C 0.9 -D 0.05 -U 1.0 -M 0.1 -S -1.0 -c -1");
//		System.out.println(apriori.toString());
		
		
		FPGrowthModel fp = new FPGrowthModel("C:\\Program Files\\Weka-3-9\\data\\weather.arff");
		fp.convertNumericToNominal("-R first-last");
		fp.convertNominalToBinary("-N -R first-last");
		fp.mineRules("-P 2 -I -1 -N 10 -T 0 -C 0.9 -D 0.05 -U 1.0 -M 0.1");
//		fp.remove("-R 3");
		fp.saveARFF("D:\\Learning\\DataMinning\\data\\weather1.arff");
		System.out.println(fp.toString());
	}

}
