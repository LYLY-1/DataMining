package phanLopDuLieu;

import java.io.BufferedWriter;
import java.io.FileWriter;

import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Debug.Random;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SerializationHelper;

public class J48Model extends PreProcessing {
	Instances train_data, test_data;
	J48 j48;
	Evaluation evalTest, evalCross;
	
	public void buildJ48Model(Instances dt_train) throws Exception{
		train_data = dt_train;
		train_data.setClassIndex(train_data.numAttributes()-1);
		j48 = new J48();
		j48.buildClassifier(train_data);
		
	}
	
	public void saveJ48Model(Instances dt_train, String fileName) throws Exception {
		this.train_data = dt_train;
		train_data.setClassIndex(train_data.numAttributes()-1);
		j48 = new J48();
		j48.buildClassifier(train_data);
		SerializationHelper.write(fileName, j48);
	}
	
	public void predictJ48(Instances data, String fileName) throws Exception{
		data.setClassIndex(data.numAttributes()-1);
        for (Instance instance : data){
            double predict = j48.classifyInstance(instance);
            instance.setClassValue(predict);
        }
        BufferedWriter output = new BufferedWriter(new FileWriter(fileName));
        output.write(data.toString());
        output.flush();
        output.close();
	}
	
	public void EvaluationJ48ModelTest(Instances data) throws Exception{
		test_data = data;
		test_data.setClassIndex(test_data.numAttributes()-1);
		evalTest = new Evaluation(train_data);
		evalTest.evaluateModel(j48, test_data);
	}
	
	public void EvaluationJ48ModelCross(Instances data, int k) throws Exception {
		test_data = data;
		test_data.setClassIndex(test_data.numAttributes()-1);
		Random rd = new Random(1);
		evalCross = new Evaluation(train_data);
		evalCross.crossValidateModel(j48, test_data, k, rd);
		evalCross.evaluateModel(j48, test_data);
	}
	
	public String output_Model(){
        return j48.toString();
    } 
	
    public String output_Eval_Model_Testset() throws Exception{
        return evalTest.toSummaryString() + "\n" + evalTest.toMatrixString();
    }
    
    public String output_Eval_Model_Cross() throws Exception{
        return evalCross.toSummaryString() + "\n" + evalCross.toMatrixString();
    }
	
	
}