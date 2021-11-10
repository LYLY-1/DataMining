package khaiThacLuatKetHop;

import java.io.BufferedWriter;
import java.io.FileWriter;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.J48;
//import weka.core.Debug.Random;
import weka.core.Instance;
import weka.core.Instances;

public class NavieBayesModel extends PreProcessing{
	NaiveBayes naivebays;
	Instances train_data, testdata;
	String[] model_option;
	Evaluation eval;
	
	public void build_NB_Model(Instances dt_train) throws Exception{
		train_data = dt_train;
		train_data.setClassIndex(train_data.numAttributes()-1);
		naivebays=new NaiveBayes();
		naivebays.buildClassifier(train_data);
		
	}
	
	public void evaluation_NB_model(Instances dt, int k) throws Exception{
		this.testdata = dt;
		testdata.setClassIndex(testdata.numAttributes()-1);
//		Random rd = new Random(1);
		eval = new Evaluation(train_data);
//		eval.crossValidateModel(naivebays, testdata, k, rd);
		eval.evaluateModel(naivebays, testdata);
	}
	

	public String output_Model(){
		return naivebays.toString();
	}
	public void predict_NB(Instances data, String fileName) throws Exception {
		data.setClassIndex(data.numAttributes()-1);
		for (Instance instance : data) {
			double predict=naivebays.classifyInstance(instance);
			instance.setClassValue(predict);
		}
		
		BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
		out.write(naivebays.toString());
		out.flush();
		out.close();
	}
	
	public String output_Eval_Model() throws Exception{
		return eval.toSummaryString() + "\n" + eval.toMatrixString();
	}

	@Override
	public void mineRules(String modelOpt) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
