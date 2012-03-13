package com.thoughtworks.salestax.spec.qszhuan;

import org.concordion.integration.junit3.ConcordionTestCase;

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
           return  salesTaxEntity.isExempt(type);
       }
    
    public String should_be_get_rate_as_expected( String type){
        SalesTaxEntity salesTaxEntity = new SalesTaxEntity();
        double rate = salesTaxEntity.getBasicTaxRate(type);
        String result = doubleToPercent(rate);
        return result;
    }

    public String should_be_get_imported_duty(String isImported){
        Boolean imported = new Boolean(isImported);
        double importedDuty = SalesTaxEntity.getImportedDuty(imported);
        return doubleToPercent(importedDuty);
    }

    public String should_get_round_result(double input){
        return Format(SalesTaxEntity.Round(input));
            
    }

    private String Format(double input) {
       // DecimalFormat df = new DecimalFormat("######0.00");
        String format = String.format("%.2f", input);
        return format;//df.format(SalesTaxEntity.Round(input));
    }


    public Result createGoods(String goodsName,String goodsType, double price){
        Goods goods = new Goods(goodsName, goodsType,price);
        Result result = new Result();
        result.tax = Format(goods.GetTax());
        double shelfPrice = goods.GetShelfPrice();
        result.shelfPrice = Format(shelfPrice);
        return result;
    }
    private String doubleToPercent(double rate) {
        String result = "0";
        if(rate != 0)
            result  = (int)(rate*100) + "%";
        return result;
    }

    class Result{
        public String tax;
        public String shelfPrice;
    }

}

