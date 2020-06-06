package HashTable.P525;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public int findMaxLength(int[] nums) {
      
      Map<Integer, Integer> map = new HashMap();
      map.put(0, -1);
      int res = 0, sum = 0;
      for(int i = 0; i < nums.length; i++){
        sum += nums[i] == 0 ? -1 : 1;
        if(map.containsKey(sum)){
          res = Math.max(res, i - map.get(sum));
        } else {
            map.put(sum, i);
        }
      }
      return res;
    }
}