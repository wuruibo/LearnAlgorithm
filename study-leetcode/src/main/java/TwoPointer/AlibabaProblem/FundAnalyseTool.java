package TwoPointer.AlibabaProblem;



import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * 感觉类似买卖股票的最佳时机
 * 一遍遍历时间复杂度O(N)
 * 空间复杂度O(1)
 * 问题转换为找出netvalue数组中V[j]/V[i]的最小值
 * @autor yeqiaozhu.
 * @date 2019-09-03
 */
public class FundAnalyseTool {
    public static BigDecimal analyse(List<FundNetValue> netValues){
        //找出V[j]/V[i]的最小值 进行一边遍历
        //默认的最大回撤率为0,同一点的时候
        BigDecimal max=new BigDecimal(0);

        //定义分母
        BigDecimal fenMu=netValues.get(0).getNetValue();

        for (int i = 1; i < netValues.size(); i++) {
            BigDecimal fenzi=netValues.get(i).getNetValue();
            if(fenMu.compareTo(fenzi)>0){
                max=findMax(new BigDecimal(1).subtract(fenzi.divide(fenMu,4, RoundingMode.CEILING)),max);
            }else {
                fenMu=fenzi;
            }
        }
        return max;
    }

    public static BigDecimal findMax(BigDecimal a,BigDecimal b){
        return a.compareTo(b)>0?a:b;
    }

    public static void main(String[] args) {
        List<FundNetValue> fundNetValues= new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            FundNetValue fundNetValue=new FundNetValue();
            fundNetValue.setNetValue(new BigDecimal(i));
            fundNetValues.add(fundNetValue);
        }
        for (int i = 1; i <= 5; i++) {
            FundNetValue fundNetValue=new FundNetValue();
            fundNetValue.setNetValue(new BigDecimal(15-i));
            fundNetValues.add(fundNetValue);
        }
        for (int i = 1; i <=10; i++) {
            FundNetValue fundNetValue=new FundNetValue();
            fundNetValue.setNetValue(new BigDecimal(10+i));
            fundNetValues.add(fundNetValue);
        }
        for (int i = 1; i <= 15; i++) {
            FundNetValue fundNetValue=new FundNetValue();
            fundNetValue.setNetValue(new BigDecimal(20-i));
            fundNetValues.add(fundNetValue);
        }
        FundAnalyseTool.analyse(fundNetValues).doubleValue();
    }
}
