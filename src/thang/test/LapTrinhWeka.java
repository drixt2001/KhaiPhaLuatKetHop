/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package thang.test;

import weka.classifiers.trees.J48;

/**
 *
 * @author thang
 */
public class LapTrinhWeka {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
//        MyKnowledgeModel model = new MyKnowledgeModel("D:\\KPDL\\DataWeka\\supermarket.arff");
//        System.out.println(model);
//        
//        model.saveData("D:\\KPDL\\DataWeka\\supermarket-clone.arff");
//        model.saveData2CSV("D:\\KPDL\\DataWeka\\supermarket-clone.csv");

//          MyAprioriModel model = new MyAprioriModel("D:\\KPDL\\DataWeka\\supermarket.arff",
//                  "-N 10 -T 0 -C 0.9 -D 0.05 -U 1.0 -M 0.1 -S -1.0 -c -1",
//                  "-R 1-9,11,57,70,79-81,88-89,98,100-102,107-114,116-120,122-130,137-179,189,192-199,201-216");
//          model.mineAssociationRules();
//          System.out.println(model.toString());

//Khai pha luat ket hop MyApriori
//        MyAprioriModel model = new MyAprioriModel("D:\\KPDL\\DataWeka\\weather.numeric.arff",
//                  "-N 10 -T 0 -C 0.9 -D 0.05 -U 1.0 -M 0.1 -S -1.0 -c -1",
//                  "-R 2-3");
//          model.mineAssociationRules();
//          System.out.println(model.toString());
//
//Khai pha luat ket hop MyFPGWrowth
//          MyFPGrowthModel model = new MyFPGrowthModel("D:\\KPDL\\DataWeka\\supermarket.arff",
//                  "-P 2 -I -1 -N 10 -T 0 -C 0.7 -D 0.05 -U 1.0 -M 0.2",
//                  "-N -R first-last");
//          model.mineAssociationRules();
//          System.out.println(model.toString());
          
//Train set & Test set
//RemovePercentage
//        MyKnowledgeModel model = new MyKnowledgeModel(
//                    "D:\\KPDL\\DataWeka\\iris.arff", null, null);
//        model.trainset = model.divideTrainTest(model.dataset, 30, false);
//        model.testset = model.divideTrainTest(model.dataset, 30, true);
//        System.out.println(model);
//        System.out.println(model.trainset.toSummaryString());
//        System.out.println(model.testset.toSummaryString());
        
        
//Resample
//        MyKnowledgeModel model = new MyKnowledgeModel(
//                    "D:\\KPDL\\DataWeka\\iris.arff", null, null);
//        model.trainset = model.divideTrainTestRe(model.dataset, 70, false);
//        model.testset = model.divideTrainTestRe(model.dataset, 70, true);
//        System.out.println(model);
//        System.out.println(model.trainset.toSummaryString());
//        System.out.println(model.testset.toSummaryString());

//Tree
//    MyDecisionTreeModel model = new MyDecisionTreeModel("D:\\KPDL\\DataWeka\\weather.nominal.arff", 
//            "-C 0.25 -M 2", null);
//    model.buildDecisionTree();
//    model.evaluaDecisionTree();
//    System.out.println(model);
    
//Luu mo hinh
//    model.saveModel("D:\\KPDL\\DataWeka\\tree\\w.model", model.tree);
//tai mo hinh và su dung
//    model.tree = (J48)model.loadModel("D:\\KPDL\\DataWeka\\tree\\w.model");
//    model.predictClassLabel(model.testset);

//NaiveBayes
    MyNaiveBayesModel model = new MyNaiveBayesModel();
    model.BuildNaiveBayes("D:\\KPDL\\DataWeka\\File train test\\iris-train.arff");
    model.evaluaBayes("D:\\KPDL\\DataWeka\\File train test\\iris-test.arff");
    model.predictClassLabel("D:\\KPDL\\DataWeka\\File train test\\iris-unlabel.arff",
                        "D:\\KPDL\\DataWeka\\File train test\\iris-predictNb.arff");
    System.out.println(model);
    
    }
}
