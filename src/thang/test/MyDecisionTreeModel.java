/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thang.test;

import java.util.Random;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Debug;
import weka.core.Instances;


/**
 *
 * @author thang
 */
public class MyDecisionTreeModel extends MyKnowledgeModel{
    J48 tree;

    public MyDecisionTreeModel(String filename, String m_opt, String d_opt) throws Exception {
        super(filename, m_opt, d_opt);
        
    }
    
    public void buildDecisionTree() throws Exception{
        //tao tap du lieu huan luyen - kiem thu
        this.trainset = divideTrainTestRe(this.dataset, 70, false);
        this.testset = divideTrainTestRe(this.dataset, 70, true);
        this.trainset.setClassIndex(this.trainset.numAttributes()-1);
        this.testset.setClassIndex(this.testset.numAttributes()-1);
        //thiet lap thong so cho mo hinh
        
        tree = new J48();
        tree.setOptions(this.model_options);
        
        //huan luyen mo hinh
        tree.buildClassifier(this.trainset);
    }
    
    public void evaluaDecisionTree() throws Exception{
        Random rd = new Debug.Random(1);
        int folds = 10; 
        Evaluation eval = new Evaluation(this.trainset);
        eval.evaluateModel(tree, this.testset);
        System.out.println(eval.toSummaryString("ket qua danh gia mo hinh 10-fold cross-validation \n",false));
//        eval.crossValidateModel(tree, this.testset, folds, rd);
//        System.out.println(eval.toSummaryString("ket qua danh gia mo hinh 10-fold cross-validation \n",false));
        
        
    }
    
    public void predictClassLabel(Instances input) throws Exception{
        for(int i = 0; i < input.numInstances(); i++){
            double predict = tree.classifyInstance(input.instance(i));
            double actual = input.instance(i).classValue();
            System.out.println("Instance "+ i +": predict "+input.classAttribute().value((int)predict)+"; actual = "
            +input.classAttribute().value((int)actual));
            
//            input.instance(i).setClassValue(predict);
        }
        
    }
    
    @Override
    public String toString() {
        return tree.toSummaryString();
    }
    
    
}
