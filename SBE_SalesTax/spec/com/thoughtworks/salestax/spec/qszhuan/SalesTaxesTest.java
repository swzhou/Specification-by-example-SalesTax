package com.thoughtworks.salestax.spec.qszhuan;

import org.concordion.integration.junit3.ConcordionTestCase;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-3-19
 * Time: 下午12:46
 * To change this template use File | Settings | File Templates.
 */
public class SalesTaxesTest extends ConcordionTestCase{
    public Result createGoods(String goodsName,String goodsType, double price){
        Goods goods = new Goods(goodsName, goodsType,price);
        Result result = new Result();
        result.tax = Format(goods.GetTax());
        double shelfPrice = goods.GetShelfPrice();
        result.shelfPrice = Format(shelfPrice);

        Cart.Add(goods);
        return result;
    }

    class Result{
        public String tax;
        public String shelfPrice;
    }

    private String Format(double input) {
        String format = String.format("%.2f", input);
        return format;
    }

    public void initCart(){
        Cart.Clear();
    }
    public String getTotalTax(){
        return Format(Cart.GetTotalTax());
    }

    public String getTotalPrice(){
        return Format(Cart.GetTotalPrice());
    }
}
