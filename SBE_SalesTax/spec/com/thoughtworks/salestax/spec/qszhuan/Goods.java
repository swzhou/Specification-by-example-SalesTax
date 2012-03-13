package com.thoughtworks.salestax.spec.qszhuan;

/**
 * Created by IntelliJ IDEA.
 * User: zhuan
 * Date: 12-3-10
 * Time: 下午10:38
 * To change this template use File | Settings | File Templates.
 */
public class Goods {
    private String goodsName;
    private String goodsType;
    private double price;
    private boolean isImported;
    public double Tax;

    public Goods(String goodsName, String goodsType, double price) {

        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.price = price;
        CalcTax();

    }
    private void CalcTax() {
        this.isImported = goodsName.contains("import");
        SalesTaxEntity salesTaxEntity = new SalesTaxEntity();
        double input = salesTaxEntity.getBasicTaxRate(goodsType) * price + SalesTaxEntity.getImportedDuty(isImported) * price;
        this.Tax =  SalesTaxEntity.Round(input);
    }

    public double GetTax(){
        return this.Tax;
    }
    public double GetShelfPrice(){
        return this.price + this.Tax ;
    }
}
