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

    public ArrayList<String> GetBasicTaxExemptTypeList() {
        return exemptList;
    }
}
