package 解题群.准备乐其;

import java.util.HashMap;
import java.util.Map;

/**
 * @autor yeqiaozhu.
 * @date 2019-08-20
 */
public class BoolTwoArrays {
    public boolean boolTwoArrays(int[] firstArray,int[] secondArray){
        Map<Integer,Integer> firstMap=getMapFromArray(firstArray);
        Map<Integer,Integer> secondMap=getMapFromArray(secondArray);

        for (int i = 0; i < secondArray.length; i++) {
            Integer countSecond=secondMap.get(secondArray[i]);
            Integer countFirst=firstMap.get(secondArray[i]);
            if(countFirst==null || countSecond>countFirst){
                return false;
            }
        }
        return true;
    }

    public static final Map<Integer,Integer> getMapFromArray(int[] arrays){
        Map<Integer,Integer> map=new HashMap<>();

        for (int i = 0; i < arrays.length; i++) {
            Integer count=map.get(arrays[i]);
            if(count==null){
                map.put(arrays[i],1);
            }else {
                map.put(arrays[i],++count);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        int[] firstArray={1,2,3,4};
        int[] secondArray={1,2,3,4};
        System.out.println(new BoolTwoArrays().boolTwoArrays(firstArray,secondArray));
    }
}
