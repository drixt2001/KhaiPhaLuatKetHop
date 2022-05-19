/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thang.test;

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
import weka.filters.unsupervised.instance.RemovePercentage;
import weka.filters.unsupervised.instance.Resample;

/**
 *
 * @author thang
 */
public class MyKnowledgeModel {
    DataSource source;
    Instances dataset;
    String[] model_options;
    String[] data_options;
    Instances trainset;
    Instances testset;
    
    public MyKnowledgeModel() {
    }
    
    public MyKnowledgeModel(String filename, String m_opt, String d_opt) throws Exception {
        
        if(!filename.isEmpty()){
            this.source = new DataSource(filename);
            this.dataset = source.getDataSet();
        }
        if(m_opt != null){
             this.model_options = weka.core.Utils.splitOptions(m_opt);
        }
        if (d_opt != null){
            this.data_options = weka.core.Utils.splitOptions(d_opt);
        }    
//        this.model_options = weka.core.Utils.splitOptions(m_opt);
//        this.data_options = weka.core.Utils.splitOptions(d_opt);
    }
    
    public Instances removeData(Instances originalData) throws Exception{
        Remove remove = new Remove();
        remove.setOptions(data_options);
        remove.setInputFormat(originalData);
        return Filter.useFilter(originalData, remove);
        
    }
    public void saveData(String filename) throws IOException{
        ArffSaver outData = new ArffSaver();
        outData.setInstances(this.dataset);
        outData.setFile(new File(filename));
        outData.writeBatch();
        System.out.println("Finished");
    }
    
    public Instances ConvertData(Instances originalData) throws Exception{
        NumericToNominal n2n = new NumericToNominal();
        n2n.setOptions(data_options);
        n2n.setInputFormat(originalData);
        return Filter.useFilter(originalData, n2n);
        
    }
    
    public Instances Convert2Binary(Instances originalData) throws Exception{
        NominalToBinary n2b = new NominalToBinary();
        n2b.setOptions(data_options);
        n2b.setBinaryAttributesNominal(true);
        n2b.setInputFormat(originalData);
        return Filter.useFilter(originalData, n2b);
        
    }
    
    public void saveData2CSV(String filename) throws IOException{
        CSVSaver outData = new CSVSaver();
        outData.setInstances(this.dataset);
        outData.setFile(new File(filename));
        outData.writeBatch();
        System.out.println("Converted");
    }
    
    
    
    //Bộ lọc RemovePercentage
    //isTest = false thi tao train, true thi tao test
    public Instances divideTrainTest(Instances originalSet,
            double  percent, boolean isTest) throws Exception{
        RemovePercentage rp  = new RemovePercentage();
        rp.setPercentage(percent);
        rp.setInvertSelection(isTest);
        rp.setInputFormat(originalSet);
        return Filter.useFilter(originalSet, rp);
    }
    
    //Bộ lọc Resample
    public Instances divideTrainTestRe(Instances originalSet,
            double percent, boolean isTest) throws Exception{
            Resample rs = new Resample();
            rs.setNoReplacement(true);
            rs.setSampleSizePercent(percent);
            rs.setInvertSelection(isTest);
            rs.setInputFormat(originalSet);
            return Filter.useFilter(originalSet, rs);
    }
        
    public void saveModel(String filename, Object model) throws Exception{
        weka.core.SerializationHelper.write(filename, model);
    }
    
    public Object loadModel(String filename) throws Exception{
        return weka.core.SerializationHelper.read(filename);
    }
    
    public void setTrainset(String filename) throws Exception{
        DataSource trainsource = new DataSource(filename);
            this.trainset = trainsource.getDataSet();
    }
    
    public void setTestset(String filename) throws Exception{
        DataSource testsource = new DataSource(filename);
            this.trainset = testsource.getDataSet();
    }
    
    @Override
    public String toString() {
        return dataset.toSummaryString();
    }
}
