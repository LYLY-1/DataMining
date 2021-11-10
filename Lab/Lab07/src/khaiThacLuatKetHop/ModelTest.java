package khaiThacLuatKetHop;

import weka.classifiers.trees.J48;
import weka.core.Instances;

public class ModelTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		AprioriModel apriori = new AprioriModel("C:\\Program Files\\Weka-3-9\\data\\weather.arff");
//		apriori.convertNumericToNominal("-R first-last");
//		apriori.mineRules("-N 10 -T 0 -C 0.9 -D 0.05 -U 1.0 -M 0.1 -S -1.0 -c -1");
//		System.out.println(apriori.toString());
		
//		
//		FPGrowthModel fp = new FPGrowthModel("C:\\Program Files\\Weka-3-9\\data\\weather.arff");
//		fp.convertNumericToNominal("-R first-last");
//		fp.convertNominalToBinary("-N -R first-last");
//		fp.mineRules("-P 2 -I -1 -N 10 -T 0 -C 0.9 -D 0.05 -U 1.0 -M 0.1");
////		fp.remove("-R 3");
//		fp.saveARFF("D:\\Learning\\DataMinning\\data\\weather1.arff");
//		System.out.println(fp.toString());
		
//		NavieBayesModel np = new NavieBayesModel() ;
//		Instances train_data = np.load_data("D:\\Learning\\DataMinning\\data\\mushroom_train.arff");
//		np.build_NB_Model(train_data);
//		System.out.println(np.output_Model());
//		
//		Instances test_data = np.load_data("D:\\Learning\\DataMinning\\data\\mushroom_test.arff");
//		np.evaluation_NB_model(test_data, 5);
//		System.out.println(np.output_Eval_Model());
//		Instances predict_data = np.load_data("D:\\Learning\\DataMinning\\data\\mushroom_predict.arff");
//		np.predict_NB(predict_data, "D:\\Learning\\DataMinning\\data\\mushroomReplaceMissing_predict.arff");
		
		TreeModel tree = new TreeModel();
		Instances train_data = tree.load_data("D:\\Learning\\DataMinning\\data\\mushroom_train.arff");
		
		tree.build_Tree_model(train_data);
		System.out.println(tree.output_Tree());
		
		Instances test_data = tree.load_data("D:\\Learning\\DataMinning\\data\\mushroom_test.arff");
		tree.evaluation_Tree_model(test_data);
		System.out.println(tree.output_Eval_Model());
		
		Instances predict_data = tree.load_data("D:\\Learning\\DataMinning\\data\\mushroom_predict.arff");
		tree.predict_J48(predict_data, "D:\\Learning\\DataMinning\\data\\mushroom_J48_predict.arff");
		
	}

}
