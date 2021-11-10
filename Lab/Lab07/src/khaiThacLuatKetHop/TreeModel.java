package khaiThacLuatKetHop;

import java.io.BufferedWriter;
import java.io.FileWriter;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;

public class TreeModel extends PreProcessing {
	J48 tree;
	Instances train_data, test_data;
	String[] model_option;
	Evaluation eval;
	
	public void build_Tree_model(Instances dt_train) throws Exception {
		train_data = dt_train;
		train_data.setClassIndex(train_data.numAttributes()-1);
		tree=new J48();
		tree.buildClassifier(train_data);
	}
	
	public void evaluation_Tree_model(Instances dt) throws Exception {
		test_data = dt;
		test_data.setClassIndex(test_data.numAttributes()-1);
		eval = new Evaluation(train_data);
		eval.evaluateModel(tree, test_data);
		
	}
	
	public String output_Tree() {
		return tree.toString();
	}
	
	public void predict_J48(Instances dt, String fileName) throws Exception{
		dt.setClassIndex(dt.numAttributes()-1);
		for (Instance instance : dt) {
			double predict = tree.classifyInstance(instance);
			instance.setClassValue(predict);
			
		}
		BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
		out.write(tree.toString());
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
