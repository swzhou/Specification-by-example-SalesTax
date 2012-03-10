package com.thoughtworks.salestax.spec.qszhuan;

import org.concordion.integration.junit3.ConcordionTestCase;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: zhuan
 * Date: 12-3-4
 * Time: 下午9:55
 * To change this template use File | Settings | File Templates.
 */
public class SalesTaxDefinitionTest extends ConcordionTestCase {
       public boolean isExempt(String type){
           SalesTaxEntity salesTaxEntity = new SalesTaxEntity();
           ArrayList<String> exemptGoodTypes = salesTaxEntity.GetBasicTaxExemptTypeList();

           return exemptGoodTypes.contains(type);
       }
    
    public String should_be_get_rate_as_expected( String type){
        double rate = getRate(type);
        String result = doubleToPercent(rate);
        return result;
    }

    private String doubleToPercent(double rate) {
        String result = "0";
        if(rate != 0)
            result  = (int)(rate*100) + "%";
        return result;
    }

    public String should_be_get_imported_duty(String isImported){
        Boolean imported = new Boolean(isImported);
        double importedDuty = getImportedDuty(imported);
        return doubleToPercent(importedDuty);
    }

    private double getImportedDuty(boolean imported) {
        return imported ? 0.05 : 0;
    }

    public double getRate(String type){
            return isExempt(type) ? 0 : 0.1;
        }

}

