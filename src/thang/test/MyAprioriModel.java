/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thang.test;

import weka.associations.Apriori;
import weka.core.Instances;

/**
 *
 * @author thang
 */
public class MyAprioriModel extends MyKnowledgeModel {
    Apriori apriori;
    Instances newdata;
    
    public MyAprioriModel() {
    }

    public MyAprioriModel(String filename, String m_opt, String d_opt) throws Exception {
        super(filename, m_opt, d_opt);
        this.apriori = new Apriori();
    }
    
    public void mineAssociationRules() throws Exception{
        //Loc du lieu
//        this.newdata = removeData(this.dataset);
        this.newdata = ConvertData(this.dataset);
        //thiet lap thong so 
        apriori.setOptions(this.model_options);
        //Khai pha luat ket hop
        apriori.buildAssociations(this.newdata);
        
    }

    @Override
    public String toString() {
        return apriori.toString();
    }
    
    
}
