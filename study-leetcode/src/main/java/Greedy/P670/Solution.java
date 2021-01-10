package Greedy.P670;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 */
class Solution {
    private final int ten=10;
    public int maximumSwap(int num) {
        //将正整数转换为数组
        List<Integer> array= new ArrayList<>();
        List<Integer> maxList=new ArrayList<>();
        while (num%ten!=0){
            array.add(num%ten);
            num/=ten;
        }
        //遍历存储每个点前面的最大值
        int maxIndex=0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(maxIndex)<=array.get(i)) {
                maxList.add(i);
                maxIndex=i;
            }else {
                maxList.add(maxIndex);
            }
        }
        //从后往前进行贪心
        for (int i = array.size() - 1; i >= 0; i--) {
            if (array.get(i)<maxList.get(i)){
                //交换元素
                int temp=array.get(i);
                array.set(i,maxList.get(i));
                array.set(maxList.get(i),temp);
            }
        }
        //构造数字
        int result=1;
        for (int i = array.size() - 1; i >= 0; i--) {
            result=result*10+array.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumSwap(2736));
    }
}