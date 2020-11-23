package 解题群.仙仙计算;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @autor yeqiaozhu.
 * @date 2019-12-20
 */
public class Test {
    private static List<BigDecimal> result= new ArrayList<>();
    public static void main(String[] args) {
        BigDecimal start=new BigDecimal(1),end=new BigDecimal(4),left=new BigDecimal(25.2),right=new BigDecimal(4);
        //step1 计算分割的数组
        result.add(start);
        getList(start,end,2);
        result.add(end);

        for (BigDecimal bigDecimal : result) {
            System.out.println(bigDecimal.multiply(left).setScale(1,BigDecimal.ROUND_HALF_UP)+"*"+bigDecimal.multiply(right).setScale(1,BigDecimal.ROUND_HALF_UP));
        }

    }
    private static void getList(BigDecimal start,BigDecimal end,int time){
        if (time==0) {
            return;
        }
        BigDecimal mid=start.add(end).divide(new BigDecimal(2));
        time--;
        getList(start,mid,time);
        result.add(mid);
        getList(mid,end,time);
    }
}
