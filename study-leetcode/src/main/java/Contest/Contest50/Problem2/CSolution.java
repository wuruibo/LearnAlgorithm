package Contest.Contest50.Problem2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yeqiaozhu.
 * @date 3/2/21
 */
public class CSolution {
    public static int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        //数据入表
        for (int[] a : adjacentPairs) {
            map.computeIfAbsent(a[0], k -> new ArrayList<>()).add(a[1]);
            map.computeIfAbsent(a[1], k -> new ArrayList<>()).add(a[0]);
        }
        int[] res = new int[adjacentPairs.length+1];
        //遍历找头
        map.forEach((key, value) -> {
            //找到了并防止找到另一头
            if(value.size() == 1 && res[0]==res[1]) {
                //前两个特殊值手动添加
                res[0]=key;
                res[1]=value.get(0);
                for (int i = 2; i < res.length; i++) {      //跟随指向持续Hash
                    int nextKey=map.get(res[i-1]).get(0);   //预设nextKey
                    //纠正反向nextKey
                    res[i]=nextKey!=res[i-2]?nextKey:map.get(res[i-1]).get(1);
                }
            }
        });
        return res;
    }
}
