package SalesTax_LJH_LB_LLY;
import org.concordion.integration.junit3.ConcordionTestCase;

/**
 * Created by IntelliJ IDEA.
 * User: LiYing
 * Date: 12-2-29
 * Time: 下午4:03
 * To change this template use File | Settings | File Templates.
 */

public class Cost_With_Tax extends ConcordionTestCase {
    public String getGreeting(){
        return "Hello World";
    }

    public Result cal_mixed_tax(String goods_name,int goods_number) {
        Result result = new Result();
        result.mix_tax_rate=(float)0.00;
        result.tax=(float)0.00;
        result.total= (float) 12.49;
        return result;
    }

    class Result {
        public float mix_tax_rate;
        public float tax;
        public float total;
    }

}
