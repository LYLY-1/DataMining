package phanLopDuLieu;

import java.io.File;
import java.io.IOException;

import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NominalToBinary;
import weka.filters.unsupervised.attribute.NumericToNominal;
import weka.filters.unsupervised.attribute.Remove;
import weka.filters.unsupervised.attribute.ReplaceMissingWithUserConstant;

public class PreProcessing {
	Instances dataSet;
	DataSource source;
	String[] modelOption;
	String[] dataOption;
	
	public PreProcessing() {
		// TODO Auto-generated constructor stub
	}
	
	public Instances load_data(String fileName) throws Exception {
		this.source = new DataSource(fileName);
		this.dataSet = source.getDataSet();
		return dataSet;
	}
	
	/**
	 * lưu file arff
	 * @throws IOException 
	 */
	
	public void saveARFF(String path) throws IOException{
		ArffSaver arffSave = new ArffSaver();
		arffSave.setInstances(dataSet);
		arffSave.setFile(new File(path));
		arffSave.writeBatch();
		System.out.println("Lưu thành công!!!");
	}
	
	/**
	 * Lưu file csv
	 * @throws IOException 
	 */
	
	public void saveCSV(String path) throws IOException{
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
	
	public void convertNumericToNominal(String dataOpt) throws Exception{
		NumericToNominal num = new NumericToNominal();
		this.dataOption = Utils.splitOptions(dataOpt);
		num.setOptions(this.dataOption);
		num.setInputFormat(dataSet);
		dataSet = Filter.useFilter(dataSet, num);
	}
	
	/**
	 * Chuyển thuộc tính Nominal -> Binary
	 * @throws Exception 
	 */
	
	public void convertNominalToBinary(String dataOpt) throws Exception {
		NominalToBinary nominal = new NominalToBinary();
		this.dataOption = Utils.splitOptions(dataOpt);
		nominal.setOptions(dataOption);
		nominal.setInputFormat(dataSet);
		dataSet = Filter.useFilter(dataSet, nominal);
	}
	
	/**
	 * Xóa thuộc tính không cần thiết
	 * @throws Exception 
	 */
	
	public void remove(String dataOpt) throws Exception {
		Remove remove = new Remove();
		dataOption = Utils.splitOptions(dataOpt);
		remove.setOptions(dataOption);
		remove.setInputFormat(dataSet);
		dataSet = Filter.useFilter(dataSet, remove);
	}
	
	/**
	 * Thay giá trị thiếu = giá trị người dùng nhập vào
	 * @throws Exception 
	 */
	
	public void replaceMissing(String dataOpt) throws Exception {
		ReplaceMissingWithUserConstant replace = new ReplaceMissingWithUserConstant();
		dataOption = Utils.splitOptions(dataOpt);
		replace.setOptions(dataOption);
		replace.setInputFormat(dataSet);
		dataSet = Filter.useFilter(dataSet, replace);
	}
}