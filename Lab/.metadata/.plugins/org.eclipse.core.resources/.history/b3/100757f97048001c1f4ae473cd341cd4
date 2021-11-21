package phanLopDuLieu;

import weka.core.Instances;

public class MainTest {

	public static void main(String[] args) throws Exception {
//		 TODO Auto-generated method stub
		System.out.println("Bài 1: NaiveBayes:\n");
		NBayesModel nb = new NBayesModel();
		Instances train_data = nb.load_data("D:\\HK1-Nam3\\DataMinning\\data\\mushroom_train.arff");
		nb.buildNaiveBayesModel(train_data);
		System.out.println(nb.outputModel());
		
		Instances test_data = nb.load_data("D:\\HK1-Nam3\\DataMinning\\data\\mushroom_test.arff");
		nb.evaluationNaiveBayesModel(test_data);
		System.out.println(nb.outputEvaluation());
		
		Instances predict = nb.load_data("D:\\HK1-Nam3\\DataMinning\\data\\mushroom_predict.arff");
		nb.predictClass(predict, "D:\\HK1-Nam3\\DataMinning\\data\\mushroomReplaceMissing_predict.arff");
		
		
		System.out.println("**********************************************\n");
		System.out.println("Bài 2: Tree\n");
		System.out.println("\n**********************************************\n");
		
		J48Model j48 = new J48Model();
		Instances train_j48 = j48.load_data("C:\\Program Files\\Weka-3-9\\data\\hypothyroid_train.arff");
		j48.buildJ48Model(train_j48);
		System.out.println(j48.output_Model());
		
		Instances test_j48 = j48.load_data("C:\\Program Files\\Weka-3-9\\data\\hypothyroid_test.arff");
		j48.EvaluationJ48ModelTest(test_j48);
		System.out.println("\nĐánh giá mô hình với testSet\n");
		System.out.println(j48.output_Eval_Model_Testset());
		
		Instances cross = j48.load_data("C:\\Program Files\\Weka-3-9\\data\\hypothyroid.arff");
		j48.EvaluationJ48ModelCross(cross, 5);
		System.out.println("\nĐánh giá mô hình với cross validation\n");
		System.out.println(j48.output_Eval_Model_Cross());
		
		Instances predict_j48 = j48.load_data("C:\\Program Files\\Weka-3-9\\data\\hypothyroid_predict.arff");
		j48.predictJ48(predict_j48, "C:\\Program Files\\Weka-3-9\\data\\hypothyroid_predictJ48.arff");
		
		j48.saveJ48Model(train_j48, "C:\\Program Files\\Weka-3-9\\data\\j48.model");
		System.out.println("Lưu thành công!!!");
		
		System.out.println("\n**********************************************\n");
		System.out.println("\nBài 3: KNN\n");
		KnnModel knn = new KnnModel();
		Instances train_knn = knn.load_data("D:\\HK1-Nam3\\DataMinning\\data\\mushroom_train.arff");
		knn.buildKnnModel(train_knn);
		System.out.println(knn.outputModel());
		
		Instances test_knn = knn.load_data("D:\\HK1-Nam3\\DataMinning\\data\\mushroom_test.arff");
		knn.evaluationKnnModelTest(test_knn, 5);
		System.out.println("\nĐánh giá mô hình với testset\n");
		System.out.println(knn.outputEvalModelTest());
		
		knn.evaluationKnnModelCross(test_knn, 5);
		System.out.println("\nĐánh giá mô hình với cross vaidation:\n");
		System.out.println(knn.outputEvalModelCross());
		
		Instances predict_knn = knn.load_data("D:\\HK1-Nam3\\DataMinning\\data\\mushroom_predict.arff");
		knn.predictKNN(predict_knn, "D:\\HK1-Nam3\\DataMinning\\data\\mushroom_predictKNN.arff");
		
	}

}