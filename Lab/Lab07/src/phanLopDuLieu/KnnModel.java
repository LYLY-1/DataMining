package phanLopDuLieu;

import java.io.BufferedWriter;
import java.io.FileWriter;

import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.lazy.IBk;
import weka.core.Debug.Random;
import weka.core.Instance;
import weka.core.Instances;

public class KnnModel extends PreProcessing {
	Instances train_data, test_data;
	IBk knn;
	Evaluation evalCross, evalTest;
	
	public void buildKnnModel(Instances dt_train) throws Exception {
		train_data = dt_train;
		train_data.setClassIndex(train_data.numAttributes()-1);
		knn = new IBk();
		knn.buildClassifier(train_data);
	}
	
	public void evaluationKnnModelTest(Instances dt_test,int k) throws Exception {
		this.test_data = dt_test;
		this.test_data.setClassIndex(test_data.numAttributes()-1);
		evalTest = new Evaluation(train_data);
		evalTest.evaluateModel(knn, test_data);
	}
	
	public void evaluationKnnModelCross(Instances dt_cross, int k) throws Exception{
		this.test_data = dt_cross;
		test_data.setClassIndex(test_data.numAttributes()-1);
		Random rd = new Random(1);
		evalCross = new Evaluation(train_data);
		evalCross.crossValidateModel(knn, test_data, k, rd);
		evalCross.evaluateModel(knn, test_data);
	}
	
	public void predictKNN(Instances data, String fileName) throws Exception{
		data.setClassIndex(data.numAttributes()-1);
        for (Instance instance : data) {
            double predict = knn.classifyInstance(instance);
            instance.setClassValue(predict);
        }
        BufferedWriter output = new BufferedWriter( new FileWriter(fileName));
        output.write(data.toString());
        output.flush();
        output.close();
	}
	
	public String outputModel(){
		return knn.toString();
	}
	
	public String outputEvalModelTest() throws Exception{
		return evalTest.toSummaryString() + '\n' + evalTest.toMatrixString();
	}
	
	public String outputEvalModelCross() throws Exception{
		return evalCross.toSummaryString() + "\n" + evalCross.toMatrixString();
	}
}