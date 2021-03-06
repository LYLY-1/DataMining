package phanLopDuLieu;

import java.io.BufferedWriter;
import java.io.FileWriter;

import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.evaluation.Evaluation;
import weka.core.Instance;
import weka.core.Instances;

public class NBayesModel extends PreProcessing {
	NaiveBayes naiveBayes;
	Instances train_data, test_data;
	Evaluation eval;
	
	public void buildNaiveBayesModel(Instances dt_train) throws Exception {
		train_data = dt_train;
		train_data.setClassIndex(train_data.numAttributes()-1);
		naiveBayes = new NaiveBayes();
		naiveBayes.buildClassifier(train_data);
	}
	
	public void evaluationNaiveBayesModel(Instances data) throws Exception {
		this.test_data = data;
		test_data.setClassIndex(test_data.numAttributes()-1);
		eval = new Evaluation(train_data);
		eval.evaluateModel(naiveBayes, test_data);
	}
	
	public void predictClass(Instances data, String fileName) throws Exception {
		data.setClassIndex(data.numAttributes()-1);
		for (Instance instance : data) {
			double predict = naiveBayes.classifyInstance(instance);
			instance.setClassValue(predict);
		}
		BufferedWriter output = new BufferedWriter(new FileWriter(fileName));
		output.write(data.toString());
		output.flush();
		output.close();
	}
	
	public String outputModel(){
		return naiveBayes.toString();
	}
	
	public String outputEvaluation() throws Exception{
		return eval.toSummaryString() + '\n' + eval.toMatrixString();
	}
}