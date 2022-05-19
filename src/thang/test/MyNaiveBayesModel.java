/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thang.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Debug;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;


/**
 *
 * @author thang
 */
public class MyNaiveBayesModel extends MyKnowledgeModel{
    NaiveBayes nbayes;

    public MyNaiveBayesModel() {
        super();
    }

    public MyNaiveBayesModel(String filename, String m_opt, String d_opt) throws Exception {
        super(filename, m_opt, d_opt);
        
    }
    
    public void BuildNaiveBayes(String filename) throws Exception{
        //Doc trainset
        setTrainset(filename);
        this.trainset.setClassIndex(this.trainset.numAttributes()-1);
        this.nbayes = new NaiveBayes();
        nbayes.buildClassifier(this.trainset);
    }
    
    public void evaluaBayes(String filename) throws Exception{
        setTestset(filename);
        this.testset.setClassIndex(this.testset.numAttributes()-1);
        Random rnd = new Debug.Random(1);
        int folds = 10;
        Evaluation eval = new Evaluation(this.trainset);
        eval.crossValidateModel(nbayes, this.testset, folds, rnd);
        System.out.println(eval.toSummaryString("ket qua danh gia mo hinh 10-fold cross-validation \n",false));
    }
    
    public void predictClassLabel(String fileIn, String fileOut) throws Exception{
        //Doc du lieu can du doan
        DataSource ds = new DataSource(fileIn);
        Instances unlabel = ds.getDataSet();
        unlabel.setClassIndex(unlabel.numAttributes()-1);
        
        //Du doan classLabel cho tung instance
        for(int i = 0; i < unlabel.numInstances(); i++){
            double predict = nbayes.classifyInstance(unlabel.instance(i));
            unlabel.instance(i).setClassValue(predict);
        }
        //Xuat kq
        BufferedWriter outW = new BufferedWriter(new FileWriter(fileOut));
        outW.write(unlabel.toString());
        outW.newLine();
        outW.flush();
        outW.close();
    }

    @Override
    public String toString() {
        return this.nbayes.toString();
    }
    
    
}
