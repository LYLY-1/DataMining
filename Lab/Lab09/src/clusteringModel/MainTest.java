package clusteringModel;

import weka.core.Instances;

public class MainTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		KmeanModel kmeans = new KmeanModel();
		Instances dataKmean = kmeans.load_data("C:\\Program Files\\Weka-3-9\\data\\labor_train.arff");
		kmeans.buildKmeanModel(dataKmean, "-init 0 -max-candidates 100 -periodic-pruning 10000 -min-density 2.0 -t1 -1.25 -t2 -1.0 -N 2 -A \"weka.core.EuclideanDistance -R first-last\" -I 500 -num-slots 1 -S 10");
		System.out.println(kmeans.outputModel());
		Instances data_predict_kmeans = kmeans.load_data("C:\\Program Files\\Weka-3-9\\data\\labor_test.arff");
		kmeans.predictCluster(data_predict_kmeans);
		
		/**
		 * b?i 2
		 */
		AgnesModel agnes = new AgnesModel();
		Instances dataAgnes = agnes.load_data("C:\\Program Files\\Weka-3-9\\data\\labor_train.arff");
		agnes.buildAgnesModel(dataAgnes, "-N 2 -L AVERAGE -P -A \"weka.core.EuclideanDistance -R first-last\"");
		System.out.println(agnes.outputAgnes());
		Instances dataPredictAgnes = agnes.load_data("C:\\Program Files\\Weka-3-9\\data\\labor_test.arff");
		agnes.predictCluster(dataPredictAgnes);

	}

}
