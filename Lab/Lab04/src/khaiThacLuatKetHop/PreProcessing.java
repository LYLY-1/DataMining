package khaiThacLuatKetHop;

import java.io.File;
import java.io.IOException;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NominalToBinary;
import weka.filters.unsupervised.attribute.NumericToNominal;
import weka.filters.unsupervised.attribute.Remove;
import weka.filters.unsupervised.attribute.ReplaceMissingWithUserConstant;

public abstract class PreProcessing {
	Instances dataSet;
	DataSource source;
	String[] modelOption;
	String[] dataOption;
	public PreProcessing() {
		// TODO Auto-generated constructor stub
	}
	
	public Instances load_data(String filename) throws Exception {
		this.source = new DataSource(filename);
		this.dataSet = source.getDataSet();
		return dataSet;
	}
	
	/**
	 * Luu file arff
	 * @param path
	 * @throws IOException
	 */
	public void saveARFF(String path) throws IOException {
		ArffSaver arffSave = new ArffSaver();
		arffSave.setInstances(dataSet);
		arffSave.setFile(new File(path));
		arffSave.writeBatch();
		System.out.println("Lưu thành công!!!");
	}
	
	
	/**
	 * luu file csv
	 * @param path
	 * @throws IOException
	 */
	public void saveCSV(String path) throws IOException {
		CSVSaver csvSave = new CSVSaver();
		csvSave.setInstances(dataSet);
		csvSave.setFile(new File(path));
		csvSave.writeBatch();
		System.out.println("Lưu thành công!!!");
	}
	
	/**
	 * Chuyển thuộc tính Numeric -> Nominal
	 * @throws Exception 
	 */
	public void convertNumericToNominal(String dataOpt) throws Exception {
        NumericToNominal numeric = new NumericToNominal();
        this.dataOption = weka.core.Utils.splitOptions(dataOpt);
        numeric.setOptions(this.dataOption);
        numeric.setInputFormat(dataSet);
        dataSet =  Filter.useFilter(dataSet, numeric);
    }
	
	/**
	 * Chuyển thuộc tính Nominal -> Binary:
	 * @throws Exception 
	 */
	public void convertNominalToBinary(String dataOpt) throws Exception{
		NominalToBinary nominal = new NominalToBinary();
		dataOption = weka.core.Utils.splitOptions(dataOpt);
		nominal.setOptions(dataOption);
		nominal.setInputFormat(dataSet);
		dataSet=Filter.useFilter(dataSet, nominal);
	}
	
	/**
	 * Xóa thuộc tính k cần thiết
	 * @throws Exception 
	 */
	public void remove(String dataOpt) throws Exception {
		Remove remove = new Remove();
		dataOption = weka.core.Utils.splitOptions(dataOpt);
		remove.setOptions(dataOption);
		remove.setInputFormat(dataSet);
		dataSet = Filter.useFilter(dataSet, remove);
	}
	
	/**
	 * Thay giá trị thiếu = giá trị người dùng nhập vào
	 * @throws Exception 
	 */
	public void replaceMissing(String dataOpt) throws Exception {
		ReplaceMissingWithUserConstant replaceMissing = new ReplaceMissingWithUserConstant();
		dataOption = weka.core.Utils.splitOptions(dataOpt);
		replaceMissing.setOptions(dataOption);
		replaceMissing.setInputFormat(dataSet);
		dataSet = Filter.useFilter(dataSet, replaceMissing);
	}
	
	/**
	 * Phuong thức trừu tượng: Khai thác luật kết hợp
	 * @throws Exception 
	 */
	public abstract void mineRules(String modelOpt) throws Exception;
	

	
	
	
}
