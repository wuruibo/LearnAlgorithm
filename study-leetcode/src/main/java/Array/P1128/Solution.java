package Array.P1128;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();

        //因为这里数组元素为1-9,所以关于key的设定，我们可以取巧为i*10+j，如果i<j，则取j*10 +i;
        //这样就能避免使用String 作为key
        for(int i=0;i< dominoes.length;i++){
            Integer key = dominoes[i][0] < dominoes[i][1] ? dominoes[i][0] * 10 + dominoes[i][1]
                    : dominoes[i][1] * 10 + dominoes[i][0];

            Integer val = map.get(key);
            if(val == null) {
                map.put(key, 1);
            }else {
                map.put(key, val + 1);
            }
        }

        int count = 0;
        for(Integer key : map.keySet()){
            Integer val = map.get(key);
            count += val * (val - 1) / 2 ;
        }

        return count;
    }
}
