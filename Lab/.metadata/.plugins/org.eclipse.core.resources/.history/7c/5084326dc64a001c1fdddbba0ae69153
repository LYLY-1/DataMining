package clusteringModel;

import weka.clusterers.SimpleKMeans;
import weka.core.EuclideanDistance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.Utils;

public class KmeanModel extends PreProcessing {
	SimpleKMeans kmeans;
	String[] model_option;
	
	public void buildKmeanModel(Instances data, String model_opt) throws Exception{
		this.model_option = Utils.splitOptions(model_opt);
		kmeans = new SimpleKMeans();
		kmeans.setOptions(model_option);
		kmeans.setNumClusters(2);
		kmeans.setDistanceFunction(new EuclideanDistance());
		kmeans.buildClusterer(data);
	}
	
	public void predictCluster(Instances data) throws Exception {
		for (Instance instance : data) {
			double predict = kmeans.clusterInstance(instance);
			System.out.println("Instances: " + instance.toString() + " thuộc cluster: " + predict);
		}
	}
	
	public String outputModel(){
		return kmeans.toString();
	}
}
