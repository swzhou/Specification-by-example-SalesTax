package com.thoughtworks.salestax.spec.qszhuan;

import java.util.ArrayList;

public class    SalesTaxEntity{

    private final ArrayList<String> exemptList;

    public SalesTaxEntity(){

        exemptList = new ArrayList<String>();
        initData();
    }

    private void initData() {
        exemptList.add("Food");
        exemptList.add("Medical");
        exemptList.add("Book");

    }
    public static double Round(double input) {
        double result;
        int percent = (int) (input * 100);
        int high = percent / 10;
        int reminder =  percent %10;
        if (reminder > 5)
            result = (high + 1)/10.0;
        else if(reminder != 0)
            result = (high*10 + 5)/100.0;
        else
        result = high/10.0;
        return result;
    }

    public static double getImportedDuty(boolean imported) {
        return imported ? 0.05 : 0;
    }

    public  double getBasicTaxRate(String type){
        return isExempt(type) ? 0 : 0.1;
    }

    public boolean isExempt(String type){
        SalesTaxEntity salesTaxEntity = new SalesTaxEntity();
        ArrayList<String> exemptGoodTypes = salesTaxEntity.GetBasicTaxExemptTypeList();

        return exemptGoodTypes.contains(type);
    }

    private ArrayList<String> GetBasicTaxExemptTypeList() {
        return exemptList;
    }
}
