package clusteringModel;

import weka.clusterers.HierarchicalClusterer;
import weka.core.EuclideanDistance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.Utils;

public class AgnesModel extends PreProcessing {
	HierarchicalClusterer agnes;
	String[] model_option;
	public void buildAgnesModel(Instances data, String model_opt) throws Exception{
		this.model_option = Utils.splitOptions(model_opt);
		agnes = new HierarchicalClusterer();
		agnes.setOptions(model_option);
		agnes.setNumClusters(2);
		agnes.setDistanceFunction(new EuclideanDistance());
		agnes.buildClusterer(data);
	}
	
	public void predictCluster(Instances data) throws Exception{
		for (Instance instance : data) {
			double predict = agnes.clusterInstance(instance);
			System.out.println("Instance " + instance.toString() + " thuộc cluster: " + predict);
		}
	}
	
	public String outputAgnes(){
		return agnes.toString();
	}
}
