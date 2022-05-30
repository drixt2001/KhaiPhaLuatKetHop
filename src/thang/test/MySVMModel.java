/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thang.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.SMO;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author thang
 */
public class MySVMModel extends MyKnowledgeModel{
    SMO svm;

    public MySVMModel(String filename, String m_opts, String d_opts) throws Exception {
        super(filename, m_opts, d_opts);
    }
    
    public void builSVM(String filename) throws Exception{
        //Doc train set vao bo nho
        setTrainset(filename);
        this.trainset.setClassIndex(this.trainset.numAttributes() -1);
        //Huan luyen mo hinh mang neural
        this.svm = new SMO();
        svm.setOptions(this.model_options);
        svm.buildClassifier(this.trainset);
    }
    
    public void evaluateSVM(String filename) throws Exception{
        //Doc test set vao bo nho
        setTestset(filename);
        this.testset.setClassIndex(this.testset.numAttributes() -1);
        //Danh gia mo hinh bang 10-fold cross-validation
        Random rnd = new Random(1);
        int folds =10;
        Evaluation eval = new Evaluation(this.trainset);
        eval.crossValidateModel(svm, this.testset, folds, rnd);
        System.out.println(eval.toSummaryString("\nKet qua danh gia mo hinh 10-fold cross-validaton\n----\n", false));
        
    }
    
    public void predictClassLable (String fileIn, String fileOut) throws  Exception{
        //Doc du lieu can du doan vao bo nho
        DataSource ds = new DataSource(fileIn);
        Instances unlabel = ds.getDataSet();
        unlabel.setClassIndex(unlabel.numAttributes() -1);
        //Du doan classLabel cho tung instance
        for (int i = 0; i< unlabel.numInstances(); i++){
            double predict =svm.classifyInstance(unlabel.instance(i));
            unlabel.instance(i).setClassValue(predict);
        }
        //Xuat ket qua ra fileOut
        BufferedWriter outWrite = new BufferedWriter(new FileWriter(fileOut));
        outWrite.write(unlabel.toString());
        outWrite.newLine();
        outWrite.flush();
        outWrite.close();
                
    }

    @Override
    public String toString() {
        return this.svm.toString();
    }
}
