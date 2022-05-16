/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thang.test;

import weka.associations.FPGrowth;
import weka.core.Instances;

/**
 *
 * @author thang
 */
public class MyFPGrowthModel extends MyKnowledgeModel{
    Instances newdata;
    FPGrowth fp;

    public MyFPGrowthModel() {
    }

    public MyFPGrowthModel(String filename, String m_opt, String d_opt) throws Exception {
        super(filename, m_opt, d_opt);
        this.fp = new FPGrowth();
    }
    
    public void mineAssociationRules() throws Exception{
        //Loc du lieu
//        this.newdata = removeData(this.dataset);
        this.newdata = Convert2Binary(this.dataset);
        //Thiet lap thong so
        fp.setOptions(model_options);
        //Khai pha
        fp.buildAssociations(this.newdata);
    }

    @Override
    public String toString() {
        return fp.toString();
    }
    
    
}
