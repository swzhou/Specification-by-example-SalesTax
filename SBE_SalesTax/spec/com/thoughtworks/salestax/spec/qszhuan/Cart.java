package com.thoughtworks.salestax.spec.qszhuan;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-3-19
 * Time: 下午1:16
 * To change this template use File | Settings | File Templates.
 */
public class Cart {

    private static Set<Goods> ItemList = new HashSet<Goods>();

    public  static void Add(Goods goods) {
        ItemList.add(goods);
    }
    public static void Clear(){
        ItemList.clear();
    }

    public static double GetTotalTax() {
        double tax = 0.0;
        for (Goods goods : ItemList)    {
            tax += goods.GetTax();
        }

        return tax;
    }

    public static double GetTotalPrice() {
        double totalPrice = 0.0;
        for (Goods goods : ItemList)    {
            totalPrice += goods.GetShelfPrice();
        }
        return totalPrice;
    }
}
