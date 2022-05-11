/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package laptrinhweka;

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
////        model.saveData("D:\\KPDL\\DataWeka\\supermarket-clone.arff");
//        model.saveData2CSV("D:\\KPDL\\DataWeka\\supermarket-clone.csv");

//          MyAprioriModel model = new MyAprioriModel("D:\\KPDL\\DataWeka\\supermarket.arff",
//                  "-N 10 -T 0 -C 0.9 -D 0.05 -U 1.0 -M 0.1 -S -1.0 -c -1",
//                  "-R 1-9,11,57,70,79-81,88-89,98,100-102,107-114,116-120,122-130,137-179,189,192-199,201-216");
//          model.mineAssociationRules();
//          System.out.println(model.toString());


//        MyAprioriModel model = new MyAprioriModel("D:\\KPDL\\DataWeka\\weather.numeric.arff",
//                  "-N 10 -T 0 -C 0.9 -D 0.05 -U 1.0 -M 0.1 -S -1.0 -c -1",
//                  "-R 2-3");
//          model.mineAssociationRules();
//          System.out.println(model.toString());

//        MyFPGrowthModel model = new MyFPGrowthModel("D:\\KPDL\\DataWeka\\weather.nominal.arff",
//                  "-P 2 -I -1 -N 10 -T 0 -C 0.8 -D 0.05 -U 1.0 -M 0.2",
//                  "-R 1-9,11,57,70,79-81,88-89,98,100-102,107-114,116-120,122-130,137-179,189,192-199,201-216");
//          model.mineAssociationRules();
//          System.out.println(model.toString());
          
//          MyFPGrowthModel model = new MyFPGrowthModel("D:\\KPDL\\DataWeka\\supermarket.arff",
//                  "-P 2 -I -1 -N 10 -T 0 -C 0.7 -D 0.05 -U 1.0 -M 0.2",
//                  "-N -R first-last");
//          model.mineAssociationRules();
//          System.out.println(model.toString());
          
//Train set & Test set
//        RemovePercentage
//        MyKnowledgeModel model = new MyKnowledgeModel(
//                    "D:\\KPDL\\DataWeka\\iris.arff", null, null);
//        model.trainset = model.divideTrainTest(model.dataset, 30, false);
//        model.testset = model.divideTrainTest(model.dataset, 30, true);
//        System.out.println(model);
//        System.out.println(model.trainset.toSummaryString());
//        System.out.println(model.testset.toSummaryString());
        
        
//Bộ lọc Resample
        MyKnowledgeModel model = new MyKnowledgeModel(
                    "D:\\KPDL\\DataWeka\\iris.arff", null, null);
        model.trainset = model.divideTrainTestRe(model.dataset, 70, false);
        model.testset = model.divideTrainTestRe(model.dataset, 70, true);
        System.out.println(model);
        System.out.println(model.trainset.toSummaryString());
        System.out.println(model.testset.toSummaryString());
    }
    
}
