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

}

