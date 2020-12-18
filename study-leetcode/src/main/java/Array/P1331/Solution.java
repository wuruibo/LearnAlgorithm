package Array.P1331;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = arr.clone();
        Arrays.sort(temp);
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = temp.length;
        int count = 1;
        for(int i=0;i<n;i++){
            if(map.get(temp[i])==null){
                map.put(temp[i],count);
                count++;
            }
        }
        for(int i=0;i<n;i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}